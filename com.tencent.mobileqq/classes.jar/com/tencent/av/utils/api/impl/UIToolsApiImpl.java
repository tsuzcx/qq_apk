package com.tencent.av.utils.api.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class UIToolsApiImpl
  extends AVCoreUtil
  implements IUIToolsApi
{
  private static final String SHARED_PREF_KEY_HAS_SHOW_SVIP_DIALOG = "has_show_svip_dialog";
  private static final String TAG = "UIToolsApiImpl";
  private Boolean mHasShowDialog;
  private Boolean mHasShowPressSpeakerModeFirstGuider;
  private Boolean mHasShowPressSpeakerModeSecondGuider;
  private Boolean sHasRoundedInScreen;
  
  public UIToolsApiImpl()
  {
    Boolean localBoolean = Boolean.valueOf(true);
    this.mHasShowPressSpeakerModeFirstGuider = localBoolean;
    this.mHasShowPressSpeakerModeSecondGuider = localBoolean;
    this.sHasRoundedInScreen = null;
  }
  
  public void avLog(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public int avRalationType2DAVRelationType(int paramInt)
  {
    int i = 3;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          if (paramInt != 4)
          {
            if (paramInt != 100) {
              return 3;
            }
          }
          else {
            return 4;
          }
        }
        return 1;
      }
      i = 2;
    }
    return i;
  }
  
  public int avRelationType2UinType(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if ((paramInt != 7) && (paramInt != 9))
          {
            if (paramInt != 10) {
              return -1;
            }
            return 1;
          }
          return 1011;
        }
        return 0;
      }
      return 3000;
    }
    return 1;
  }
  
  boolean canPlayRing(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    if (paramAppInterface == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication);
    boolean bool1 = bool2;
    if (paramAppInterface.getCurrentAccountUin() != null)
    {
      String str = paramAppInterface.getCurrentAccountUin();
      bool1 = bool2;
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface.getApp().getString(2131892707));
        localStringBuilder.append(str);
        bool1 = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
      }
    }
    bool2 = bool1;
    if (AudioUtil.a() != 0)
    {
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (!PhoneStatusTools.b(BaseApplicationImpl.sApplication))
        {
          bool2 = bool1;
          if (!PhoneStatusTools.d(BaseApplicationImpl.sApplication))
          {
            bool2 = bool1;
            if (!PhoneStatusTools.e(BaseApplicationImpl.sApplication)) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public void cancelSetPermission(Activity paramActivity, AppInterface paramAppInterface)
  {
    boolean bool = paramActivity.getIntent().getBooleanExtra("is_video", false);
    paramActivity = paramAppInterface.getCurrentAccountUin();
    SmallScreenUtils.a(paramActivity, SmallScreenUtils.a(paramActivity, bool) + 1, bool);
  }
  
  public Bitmap captureFrameBySelf(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    Object localObject1 = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject1, 0);
    GLES20.glBindFramebuffer(36160, localObject1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 36197, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject2);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, (int[])localObject1, 0);
    localObject1[0] = 0;
    ((ByteBuffer)localObject2).position(0);
    localObject1 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject1).copyPixelsFromBuffer((Buffer)localObject2);
    localObject2 = new Matrix();
    ((Matrix)localObject2).postRotate(0.0F);
    ((Matrix)localObject2).postScale(1.0F, -1.0F);
    localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, paramInt2, paramInt3, (Matrix)localObject2, true);
    ((Bitmap)localObject1).recycle();
    return localObject2;
  }
  
  public void clearPressSpeakerGuiderFlag(boolean paramBoolean)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if (paramBoolean)
    {
      this.mHasShowPressSpeakerModeFirstGuider = localBoolean;
      return;
    }
    this.mHasShowPressSpeakerModeSecondGuider = localBoolean;
  }
  
  public void clearSpeakerStatus(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = SharedPreUtils.B(paramContext);
      Object localObject = paramContext.edit();
      ((SharedPreferences.Editor)localObject).putBoolean("qav_random_speakeron", false);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("qav_random_speakeron:");
        ((StringBuilder)localObject).append(paramContext.getBoolean("qav_random_speakeron", false));
        QLog.d("UIToolsApiImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void disableShowTips(int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "grid_enable_switch";
    } else {
      str = "slide_enable_switch";
    }
    if (paramInt == 1) {
      UITools.c = 0;
    } else {
      UITools.d = 0;
    }
    SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("UIToolsApiImpl", 4).edit().putInt(str, 0));
  }
  
  public Bitmap doBlur(Bitmap paramBitmap, Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i7 = paramInt;
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("width = ");
      ((StringBuilder)localObject).append(paramBitmap.getWidth());
      ((StringBuilder)localObject).append(" # height = ");
      ((StringBuilder)localObject).append(paramBitmap.getHeight());
      QLog.d("blur", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      i = getScreenWidth(paramContext);
      j = getScreenHeight(paramContext);
      k = paramBitmap.getHeight() * i / j;
      j = (paramBitmap.getWidth() - k) / 2;
      i = j;
      if (j < 0) {
        i = 0;
      }
      paramContext = Bitmap.createBitmap(paramBitmap, i, 0, k, paramBitmap.getHeight());
      paramBitmap = Bitmap.createScaledBitmap(paramContext, paramContext.getWidth() / 2, paramContext.getHeight() / 2, false);
      paramContext.recycle();
    }
    else
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, false);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isMutable = ");
      paramContext.append(paramBitmap.isMutable());
      QLog.d("blur", 2, paramContext.toString());
    }
    if (i7 < 1) {
      return null;
    }
    int i15 = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int i = i15 * j;
    int[] arrayOfInt2 = new int[i];
    paramBitmap.getPixels(arrayOfInt2, 0, i15, 0, 0, i15, j);
    int i18 = i15 - 1;
    int k = j - 1;
    int i16 = i7 + i7 + 1;
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[i];
    int[] arrayOfInt1 = new int[Math.max(i15, j)];
    i = i16 + 1 >> 1;
    int m = i * i;
    int n = m * 256;
    Object localObject = new int[n];
    i = 0;
    while (i < n)
    {
      localObject[i] = (i / m);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i16, 3 });
    int i17 = i7 + 1;
    int i9 = 0;
    int i10 = 0;
    int i8 = 0;
    i = k;
    paramContext = paramBitmap;
    int i11;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i12;
    int i13;
    int i14;
    while (i9 < j)
    {
      i11 = -i7;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      n = 0;
      m = 0;
      k = 0;
      i4 = 0;
      i5 = 0;
      i6 = 0;
      while (i11 <= i7)
      {
        i12 = arrayOfInt2[(Math.min(i18, Math.max(i11, 0)) + i10)];
        paramBitmap = arrayOfInt[(i11 + i7)];
        paramBitmap[0] = ((i12 & 0xFF0000) >> 16);
        paramBitmap[1] = ((i12 & 0xFF00) >> 8);
        paramBitmap[2] = (i12 & 0xFF);
        i12 = i17 - Math.abs(i11);
        i1 += paramBitmap[0] * i12;
        i2 += paramBitmap[1] * i12;
        i3 += paramBitmap[2] * i12;
        if (i11 > 0)
        {
          i4 += paramBitmap[0];
          i5 += paramBitmap[1];
          i6 += paramBitmap[2];
        }
        else
        {
          n += paramBitmap[0];
          m += paramBitmap[1];
          k += paramBitmap[2];
        }
        i11 += 1;
      }
      i13 = i7;
      i14 = 0;
      i11 = i5;
      i12 = i4;
      i5 = i1;
      i4 = i13;
      i1 = i14;
      while (i1 < i15)
      {
        arrayOfInt3[i10] = localObject[i5];
        arrayOfInt4[i10] = localObject[i2];
        arrayOfInt5[i10] = localObject[i3];
        paramBitmap = arrayOfInt[((i4 - i7 + i16) % i16)];
        int i19 = paramBitmap[0];
        i14 = paramBitmap[1];
        i13 = paramBitmap[2];
        if (i9 == 0) {
          arrayOfInt1[i1] = Math.min(i1 + i7 + 1, i18);
        }
        int i20 = arrayOfInt2[(i8 + arrayOfInt1[i1])];
        paramBitmap[0] = ((i20 & 0xFF0000) >> 16);
        paramBitmap[1] = ((i20 & 0xFF00) >> 8);
        paramBitmap[2] = (i20 & 0xFF);
        i12 += paramBitmap[0];
        i11 += paramBitmap[1];
        i6 += paramBitmap[2];
        i5 = i5 - n + i12;
        i2 = i2 - m + i11;
        i3 = i3 - k + i6;
        i4 = (i4 + 1) % i16;
        paramBitmap = arrayOfInt[(i4 % i16)];
        n = n - i19 + paramBitmap[0];
        m = m - i14 + paramBitmap[1];
        k = k - i13 + paramBitmap[2];
        i12 -= paramBitmap[0];
        i11 -= paramBitmap[1];
        i6 -= paramBitmap[2];
        i10 += 1;
        i1 += 1;
      }
      i8 += i15;
      i9 += 1;
    }
    k = 0;
    i7 = j;
    j = i;
    paramBitmap = arrayOfInt1;
    i = k;
    for (;;)
    {
      i8 = paramInt;
      if (i >= i15) {
        break;
      }
      i9 = -i8;
      i10 = i9 * i15;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      n = 0;
      m = 0;
      k = 0;
      i4 = 0;
      i6 = 0;
      i5 = 0;
      while (i9 <= i8)
      {
        i12 = Math.max(0, i10) + i;
        arrayOfInt1 = arrayOfInt[(i9 + i8)];
        arrayOfInt1[0] = arrayOfInt3[i12];
        arrayOfInt1[1] = arrayOfInt4[i12];
        arrayOfInt1[2] = arrayOfInt5[i12];
        i13 = i17 - Math.abs(i9);
        i11 = i1 + arrayOfInt3[i12] * i13;
        i2 += arrayOfInt4[i12] * i13;
        i3 += arrayOfInt5[i12] * i13;
        if (i9 > 0)
        {
          i4 += arrayOfInt1[0];
          i6 += arrayOfInt1[1];
          i5 += arrayOfInt1[2];
        }
        else
        {
          n += arrayOfInt1[0];
          m += arrayOfInt1[1];
          k += arrayOfInt1[2];
        }
        i1 = i10;
        if (i9 < j) {
          i1 = i10 + i15;
        }
        i9 += 1;
        i10 = i1;
        i1 = i11;
      }
      i9 = i5;
      i13 = 0;
      i5 = i8;
      i10 = i4;
      i11 = i2;
      i12 = i1;
      i4 = i;
      i8 = i9;
      i9 = i6;
      i1 = i5;
      i2 = i3;
      i3 = i11;
      i6 = i12;
      i5 = i4;
      i4 = i13;
      while (i4 < i7)
      {
        arrayOfInt2[i5] = (arrayOfInt2[i5] & 0xFF000000 | localObject[i6] << 16 | localObject[i3] << 8 | localObject[i2]);
        arrayOfInt1 = arrayOfInt[((i1 - paramInt + i16) % i16)];
        i13 = arrayOfInt1[0];
        i12 = arrayOfInt1[1];
        i11 = arrayOfInt1[2];
        if (i == 0) {
          paramBitmap[i4] = (Math.min(i4 + i17, j) * i15);
        }
        i14 = paramBitmap[i4] + i;
        arrayOfInt1[0] = arrayOfInt3[i14];
        arrayOfInt1[1] = arrayOfInt4[i14];
        arrayOfInt1[2] = arrayOfInt5[i14];
        i10 += arrayOfInt1[0];
        i9 += arrayOfInt1[1];
        i8 += arrayOfInt1[2];
        i6 = i6 - n + i10;
        i3 = i3 - m + i9;
        i2 = i2 - k + i8;
        i1 = (i1 + 1) % i16;
        arrayOfInt1 = arrayOfInt[i1];
        n = n - i13 + arrayOfInt1[0];
        m = m - i12 + arrayOfInt1[1];
        k = k - i11 + arrayOfInt1[2];
        i10 -= arrayOfInt1[0];
        i9 -= arrayOfInt1[1];
        i8 -= arrayOfInt1[2];
        i5 += i15;
        i4 += 1;
      }
      i += 1;
    }
    paramContext.setPixels(arrayOfInt2, 0, i15, 0, 0, i15, i7);
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("blur time = ");
      paramBitmap.append(System.currentTimeMillis() - l);
      paramBitmap.append("ms");
      QLog.d("blur", 2, paramBitmap.toString());
    }
    return paramContext;
  }
  
  public void doScreenShareReport(String paramString)
  {
    doScreenShareReport(paramString, SessionMgr.a().b().g);
  }
  
  public void doScreenShareReport(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UIToolsApiImpl", 2, String.format("doScreenShareReport, tag[%s], fromType[%s]", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public float dp2px(Context paramContext, float paramFloat)
  {
    return paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F;
  }
  
  public Bitmap drawBitmapCoverLayer(Bitmap paramBitmap, String paramString, boolean paramBoolean)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      localObject = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (localObject != null)
      {
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        if (localCanvas.getDensity() != paramBitmap.getDensity()) {
          localCanvas.setDensity(paramBitmap.getDensity());
        }
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
        localPaint.setColor(Color.parseColor(paramString));
        paramString = new RectF(0.0F, 0.0F, i, j);
        if (paramBoolean)
        {
          localCanvas.drawRoundRect(paramString, i / 2, j / 2, localPaint);
          return localObject;
        }
        localCanvas.drawRect(paramString, localPaint);
        return localObject;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("grey bitmap, oom, stack:");
        ((StringBuilder)localObject).append(MsfSdkUtils.getStackTraceString(paramString));
        QLog.d("UIToolsApiImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
    return paramBitmap;
  }
  
  public boolean equals(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str = paramString1;
      if (paramString1.startsWith("+")) {
        str = paramString1.substring(1);
      }
      paramString1 = paramString2;
      if (paramString2.startsWith("+")) {
        paramString1 = paramString2.substring(1);
      }
      return str.equals(paramString1);
    }
    return false;
  }
  
  public String formatTime(long paramLong)
  {
    if (paramLong > 0L)
    {
      long l1 = paramLong % 60L;
      long l2 = paramLong / 60L;
      paramLong = l2 / 60L;
      l2 %= 60L;
      if (paramLong > 0L) {
        return String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(l1) });
      }
      return String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
    }
    return "00:00";
  }
  
  public Bitmap getBitmapFromResourceId(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = ((BitmapDrawable)paramContext.getResources().getDrawable(paramInt)).getBitmap();
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
        return null;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
    }
    return null;
  }
  
  public float getMeasureTextWidth(TextView paramTextView)
  {
    return paramTextView.getPaint().measureText((String)paramTextView.getText());
  }
  
  public int getMobileQQLastSyncVersion()
  {
    return 710;
  }
  
  public String getNameMaxMaseaured(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramContext = paramString;
        paramFloat = f1;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramFloat = f1;
          paramContext = paramTextView;
          if (f1 == 0.0F)
          {
            paramFloat = f1;
            paramContext = paramTextView;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0)
          {
            paramString = new StringBuilder();
            paramString.append(paramContext);
            paramString.append("...");
            paramTextView = paramString.toString();
          }
        }
      }
    }
    return paramTextView;
  }
  
  public Drawable getOvalDrawable(float paramFloat, Context paramContext)
  {
    int i = AIOUtils.b(paramFloat, paramContext.getResources());
    paramContext = new GradientDrawable();
    paramContext.setShape(1);
    paramContext.setColor(Color.parseColor("#4C000000"));
    paramContext.setSize(i, i);
    return paramContext;
  }
  
  public String getPhoneNumberByUinInMainThread(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject3 = ((FriendsManager)paramBaseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(paramString);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = BusinessCardUtils.a(((Card)localObject3).bCardInfo);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (!((BusinessCard)localObject3).mobilesNum.isEmpty()) {
          localObject1 = (String)((BusinessCard)localObject3).mobilesNum.get(0);
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramBaseQQAppInterface = (IPhoneContactService)paramBaseQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
      localObject2 = localObject1;
      if (paramBaseQQAppInterface != null)
      {
        int i = paramBaseQQAppInterface.getSelfBindState();
        if ((i != 9) && (i != 8) && (i != 4))
        {
          localObject2 = localObject1;
          if (i != 2) {}
        }
        else
        {
          localObject2 = localObject1;
          if (PermissionChecker.a().e())
          {
            paramBaseQQAppInterface = paramBaseQQAppInterface.queryPhoneContactByUin(paramString);
            localObject2 = localObject1;
            if (paramBaseQQAppInterface != null) {
              localObject2 = paramBaseQQAppInterface.mobileNo;
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  public boolean getPressSpeakerGuiderFlag(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.mHasShowPressSpeakerModeFirstGuider.booleanValue();
    }
    return this.mHasShowPressSpeakerModeSecondGuider.booleanValue();
  }
  
  public SharedPreferences getQavSP(AppInterface paramAppInterface)
  {
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("qav_SP");
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public float getScreenBrightness()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (!MobileIssueSettings.f) {
      KapalaiAdapterUtil.a().a(localLayoutParams);
    } else {
      localLayoutParams.screenBrightness = 0.034F;
    }
    return localLayoutParams.screenBrightness;
  }
  
  public float getScreenDensity(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public String getTimeDesc(String paramString)
  {
    Object localObject1 = HardCodeUtil.a(2131913112);
    Object localObject2 = paramString.split(":");
    int i = localObject2.length;
    int k = 0;
    int j;
    if (i == 3)
    {
      k = Integer.valueOf(localObject2[0]).intValue();
      j = Integer.valueOf(localObject2[1]).intValue();
      i = Integer.valueOf(localObject2[2]).intValue();
    }
    else if (localObject2.length == 2)
    {
      j = Integer.valueOf(localObject2[0]).intValue();
      i = Integer.valueOf(localObject2[1]).intValue();
    }
    else
    {
      i = 0;
      j = 0;
    }
    if ((k <= 0) && (j <= 0) && (i <= 0))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramString);
      return ((StringBuilder)localObject2).toString();
    }
    paramString = (String)localObject1;
    if (k > 0)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append(k);
      paramString.append(HardCodeUtil.a(2131913110));
      paramString = paramString.toString();
    }
    if (j > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913109));
      paramString = ((StringBuilder)localObject1).toString();
    }
    localObject1 = paramString;
    if (i > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131913108));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public boolean gotoSetting(Activity paramActivity)
  {
    return (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR")) || (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC")) || (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER")) || (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"));
  }
  
  public boolean hasSmartBar()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      label47:
      break label47;
    }
    if (Build.DEVICE.equals("mx2")) {
      return true;
    }
    if ((!Build.DEVICE.equals("mx")) && (Build.DEVICE.equals("m9"))) {}
    return false;
  }
  
  public boolean isEnableShowTips(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 1)
    {
      if (UITools.c == -1) {
        UITools.c = BaseApplicationImpl.getApplication().getSharedPreferences("UIToolsApiImpl", 4).getInt("grid_enable_switch", 1);
      }
      if (UITools.c == 1) {
        bool1 = true;
      }
      return bool1;
    }
    if (UITools.d == -1) {
      UITools.d = BaseApplicationImpl.getApplication().getSharedPreferences("UIToolsApiImpl", 4).getInt("slide_enable_switch", 1);
    }
    bool1 = bool2;
    if (UITools.d == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean isFeatureSupportRounedScreen(Activity paramActivity)
  {
    Boolean localBoolean = this.sHasRoundedInScreen;
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    this.sHasRoundedInScreen = new Boolean(false);
    if (!Build.MANUFACTURER.equalsIgnoreCase("vivo"))
    {
      this.sHasRoundedInScreen = Boolean.valueOf(LiuHaiUtils.c(paramActivity));
      return this.sHasRoundedInScreen.booleanValue();
    }
    try
    {
      paramActivity = paramActivity.getClassLoader().loadClass("android.util.FtFeature");
      this.sHasRoundedInScreen = ((Boolean)paramActivity.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramActivity, new Object[] { Integer.valueOf(8) }));
      return this.sHasRoundedInScreen.booleanValue();
    }
    catch (ClassNotFoundException paramActivity) {}catch (NoSuchMethodException paramActivity) {}catch (Exception paramActivity) {}finally
    {
      break label167;
    }
    QLog.e("UIToolsApiImpl", 1, "hasNotchInScreen Exception");
    return this.sHasRoundedInScreen.booleanValue();
    QLog.e("UIToolsApiImpl", 1, "hasNotchInScreen NoSuchMethodException");
    return this.sHasRoundedInScreen.booleanValue();
    QLog.e("UIToolsApiImpl", 1, "hasNotchInScreen ClassNotFoundException");
    return this.sHasRoundedInScreen.booleanValue();
    label167:
    return this.sHasRoundedInScreen.booleanValue();
  }
  
  public boolean isFirstTimeShowUserGuideForFace(AppInterface paramAppInterface)
  {
    if (AudioHelper.a(0) == 1) {
      return true;
    }
    return getQavSP(paramAppInterface).getBoolean("qav_UserGuide_for_voiceSticker", true);
  }
  
  public boolean isNeedShowSVIPDialog()
  {
    if (this.mHasShowDialog == null)
    {
      this.mHasShowDialog = new Boolean(false);
      this.mHasShowDialog = Boolean.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("UIToolsApiImpl", 4).getBoolean("has_show_svip_dialog", true));
    }
    return this.mHasShowDialog.booleanValue();
  }
  
  public boolean isVIPPayProcessExist(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName)) {
        return true;
      }
    }
    return false;
  }
  
  public void openPermissionActivity(Activity paramActivity)
  {
    String str = paramActivity.getPackageName();
    if (SmallScreenUtils.a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      Intent localIntent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent3.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent3.putExtra("extra_pkgname", str);
      try
      {
        paramActivity.startActivity(localIntent3);
        bool1 = true;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("openPermissionActivity e = ");
            localStringBuilder.append(localException3);
            QLog.e("UIToolsApiImpl", 2, localStringBuilder.toString());
          }
          bool1 = false;
        }
      }
      j = 1;
      break label121;
    }
    StringBuilder localStringBuilder;
    boolean bool1 = false;
    int j = 0;
    label121:
    boolean bool2 = bool1;
    int i = j;
    if (!bool1)
    {
      bool2 = bool1;
      i = j;
      if (SmallScreenUtils.a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
      {
        Intent localIntent4 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        localIntent4.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        localIntent4.putExtra("packageName", str);
        try
        {
          paramActivity.startActivity(localIntent4);
          bool2 = true;
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("openPermissionActivity e = ");
              localStringBuilder.append(localException4);
              QLog.e("UIToolsApiImpl", 2, localStringBuilder.toString());
            }
            bool2 = false;
          }
        }
        i = 2;
      }
    }
    bool1 = bool2;
    j = i;
    if (!bool2)
    {
      bool1 = bool2;
      j = i;
      if (SmallScreenUtils.a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
      {
        i = 3;
        Intent localIntent5 = new Intent();
        localIntent5.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        localIntent5.addFlags(268435456);
        try
        {
          paramActivity.startActivity(localIntent5);
          bool2 = true;
        }
        catch (Exception localException5)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("openPermissionActivity e = ");
            localStringBuilder.append(localException5);
            QLog.e("UIToolsApiImpl", 2, localStringBuilder.toString());
          }
          bool2 = false;
        }
        bool1 = bool2;
        j = i;
        if (!bool2)
        {
          Intent localIntent6 = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
          try
          {
            paramActivity.startActivity(localIntent6);
            bool1 = true;
            j = i;
          }
          catch (Exception localException6)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("openPermissionActivity e = ");
              localStringBuilder.append(localException6);
              QLog.e("UIToolsApiImpl", 2, localStringBuilder.toString());
            }
            bool1 = false;
            j = i;
          }
        }
      }
    }
    bool2 = bool1;
    Object localObject;
    if (!bool1)
    {
      j = 4;
      localObject = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      try
      {
        ((Intent)localObject).setData(Uri.fromParts("package", str, null));
        paramActivity.startActivity((Intent)localObject);
        bool2 = true;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("openPermissionActivity e = ");
          ((StringBuilder)localObject).append(localException1);
          QLog.e("UIToolsApiImpl", 2, ((StringBuilder)localObject).toString());
        }
        bool2 = false;
      }
    }
    bool1 = bool2;
    i = j;
    if (!bool2)
    {
      bool1 = bool2;
      i = j;
      if (SmallScreenUtils.a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))
      {
        i = 5;
        Intent localIntent1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        try
        {
          paramActivity.startActivity(localIntent1);
          bool1 = true;
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("openPermissionActivity e = ");
            ((StringBuilder)localObject).append(localException2);
            QLog.e("UIToolsApiImpl", 2, ((StringBuilder)localObject).toString());
          }
          bool1 = false;
        }
      }
    }
    if (!bool1)
    {
      Intent localIntent2 = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent2.putExtra("hide_left_button", false);
      localIntent2.putExtra("show_right_close_button", false);
      localIntent2.putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.b(paramActivity, "https://view.yutu.qq.com/yutu/activity/3857.html", 524288L, localIntent2, false, -1);
      i = 6;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("请求相机权限, which[");
    paramActivity.append(i);
    paramActivity.append("], openSuccess[");
    paramActivity.append(bool1);
    paramActivity.append("]");
    QLog.w("UIToolsApiImpl", 1, paramActivity.toString());
  }
  
  public void printStacktrace(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString, 2, "PrintBacktrace-->can npt het StackTrace");
      }
      return;
    }
    String str = new String();
    int i = 0;
    while (i < arrayOfStackTraceElement.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("STE[");
      localStringBuilder.append(i);
      localStringBuilder.append("]:");
      localStringBuilder.append(arrayOfStackTraceElement[i].toString());
      localStringBuilder.append("\n");
      str = localStringBuilder.toString();
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, str);
    }
  }
  
  public float px2dp(Context paramContext, float paramFloat)
  {
    return paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F;
  }
  
  public void recordHasShowSVIPDialog()
  {
    this.mHasShowDialog = new Boolean(false);
    SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("UIToolsApiImpl", 4).edit().putBoolean("has_show_svip_dialog", false));
  }
  
  public void setAccText(View paramView, String paramString)
  {
    if (UITools.b)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SetAccText: ");
        localStringBuilder.append(paramString);
        QLog.i("UITools", 2, localStringBuilder.toString());
      }
      if (paramView == null) {
        return;
      }
      paramView.setFocusable(true);
      paramView.setContentDescription(paramString);
    }
  }
  
  public void setAccText(View paramView, String paramString, int paramInt)
  {
    if (UITools.b)
    {
      String str = paramString;
      if (paramInt == 2) {
        str = paramString.replace(paramView.getResources().getString(2131893110), HardCodeUtil.a(2131913111));
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("SetAccText with avType:");
        paramString.append(str);
        paramString.append(" avType:");
        paramString.append(paramInt);
        QLog.i("UITools", 2, paramString.toString());
      }
      paramView.setFocusable(true);
      paramView.setContentDescription(str);
    }
  }
  
  public void setFirstTimeShowUserGuideForFace(AppInterface paramAppInterface)
  {
    paramAppInterface = getQavSP(paramAppInterface).edit();
    paramAppInterface.putBoolean("qav_UserGuide_for_voiceSticker", false);
    paramAppInterface.commit();
  }
  
  public void setScreenBrightness(Activity paramActivity, float paramFloat)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = paramActivity.getWindow();
    if (paramActivity == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramActivity.setAttributes(localLayoutParams);
  }
  
  @TargetApi(11)
  public void setViewAlpha(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
  }
  
  public boolean startRing(AppInterface paramAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (canPlayRing(paramAppInterface))
    {
      AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      return true;
    }
    return false;
  }
  
  public Bitmap takeScreenShot(Activity paramActivity)
  {
    if (paramActivity == null) {
      return null;
    }
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramActivity == null) {
      return null;
    }
    paramActivity.setDrawingCacheEnabled(true);
    paramActivity.buildDrawingCache(true);
    Bitmap localBitmap = paramActivity.getDrawingCache();
    if (localBitmap == null) {
      return null;
    }
    localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    paramActivity.destroyDrawingCache();
    return localBitmap;
  }
  
  public int uinType2AVRelationType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 1011)
        {
          if (paramInt != 3000) {
            return 0;
          }
          return 2;
        }
        return 7;
      }
      return 1;
    }
    return 3;
  }
  
  public int uinType2MultiAVType(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3000) {
        return 0;
      }
      return 1;
    }
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.utils.api.impl.UIToolsApiImpl
 * JD-Core Version:    0.7.0.1
 */