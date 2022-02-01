package com.tencent.mobileqq.bubble;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BubbleUnRead
{
  private int a = 0;
  private Rect b = null;
  private String c;
  private final LruCache<String, Bitmap> d;
  private final BubbleManager e;
  
  BubbleUnRead(BubbleManager paramBubbleManager)
  {
    this.e = paramBubbleManager;
    this.d = new LruCache(10);
  }
  
  @Nullable
  private BubbleUnRead.BubbleUnreadBundle a(TextView paramTextView, int paramInt, String paramString, String[] paramArrayOfString, BubbleInfo paramBubbleInfo)
  {
    if ((paramArrayOfString != null) && (a()))
    {
      String str = a(paramInt, paramArrayOfString);
      if (str == null) {
        return null;
      }
      Bitmap localBitmap = (Bitmap)this.d.get(str);
      if ((localBitmap != null) || (FileUtils.fileExists(str)))
      {
        paramArrayOfString = localBitmap;
        if (localBitmap == null)
        {
          paramArrayOfString = BitmapFactory.decodeFile(str);
          if (paramArrayOfString != null)
          {
            this.d.put(str, paramArrayOfString);
          }
          else
          {
            QLog.d("BubbleManager", 2, "find no bubble unread : decode error");
            return null;
          }
        }
        return a(paramTextView, paramString, paramBubbleInfo, paramArrayOfString);
      }
    }
    QLog.d("BubbleManager", 2, "find no bubble unread");
    return null;
  }
  
  @NotNull
  private BubbleUnRead.BubbleUnreadBundle a(TextView paramTextView, String paramString, BubbleInfo paramBubbleInfo, Bitmap paramBitmap)
  {
    if ((this.b == null) || (!TextUtils.equals(paramString, this.c))) {}
    try
    {
      int i;
      if (this.b == null)
      {
        this.c = paramString;
        this.b = new Rect();
        paramString = paramTextView.getText();
        Rect localRect = new Rect(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
        Drawable localDrawable = paramTextView.getBackground();
        paramTextView.setText("1");
        paramTextView.measure(0, 0);
        int i2 = paramTextView.getMeasuredWidth();
        if (Build.VERSION.SDK_INT >= 16) {
          paramTextView.setBackground(new BitmapDrawable(paramBitmap));
        } else {
          paramTextView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
        }
        paramTextView.setPadding(0, 0, 0, 0);
        paramTextView.measure(0, 0);
        i = paramTextView.getMeasuredWidth();
        int j = paramTextView.getMeasuredHeight();
        i = i2 - i;
        int k = Math.max(i / 2, 0);
        j = i2 - j;
        int n = Math.max(j / 2, 0);
        int m = Math.max(i - k, 0);
        int i1 = Math.max(j - n, 0);
        paramTextView.setPadding(m, i1, k, n);
        paramTextView.measure(0, 0);
        int i3 = i2 - paramTextView.getMeasuredWidth();
        j = m;
        i = k;
        if (i3 != 0)
        {
          j = m + i3 / 2;
          i = k + (i3 - i3 / 2);
        }
        i2 -= paramTextView.getMeasuredHeight();
        m = i1;
        k = n;
        if (i2 != 0)
        {
          m = i1 + i2 / 2;
          k = n + (i2 - i2 / 2);
        }
        this.b.set(j, m, i, k);
        paramTextView.setText(paramString);
        if (Build.VERSION.SDK_INT >= 16) {
          paramTextView.setBackground(localDrawable);
        } else {
          paramTextView.setBackgroundDrawable(localDrawable);
        }
        paramTextView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      }
      paramTextView = new BitmapDrawable(paramBitmap);
      if (paramBubbleInfo.a > 0) {
        i = paramBubbleInfo.l;
      } else {
        i = -1;
      }
      return new BubbleUnRead.BubbleUnreadBundle(paramTextView, i, this.b);
    }
    finally {}
  }
  
  @Nullable
  private String a(int paramInt, String[] paramArrayOfString)
  {
    if (paramInt < 10) {
      paramArrayOfString = paramArrayOfString[0];
    } else if (paramInt < 100) {
      paramArrayOfString = paramArrayOfString[1];
    } else {
      paramArrayOfString = paramArrayOfString[2];
    }
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString == null) {
      arrayOfString = null;
    }
    return arrayOfString;
  }
  
  private String[] a(int paramInt, String[] paramArrayOfString, BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo.i != null) {
      return paramBubbleInfo.i;
    }
    if (paramInt > 0) {
      paramArrayOfString = a(paramInt);
    }
    return paramArrayOfString;
  }
  
  public BubbleUnRead.BubbleUnreadBundle a(TextView paramTextView, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = this.e.d;
    if (localObject == null) {
      return null;
    }
    localObject = BubbleUtils.a(paramInt1, (AppRuntime)localObject, null, null);
    return a(paramTextView, paramInt2, paramString, a(paramInt1, null, (BubbleInfo)localObject), (BubbleInfo)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.e.d;
    if (localObject == null) {
      return;
    }
    boolean bool2 = b();
    boolean bool1 = true;
    if (!bool2) {
      paramBoolean = true;
    }
    if (paramBoolean != a())
    {
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = -1;
      }
      this.a = i;
      SharedPreferences.Editor localEditor = ((AppInterface)localObject).getApp().getSharedPreferences(((AppInterface)localObject).getCurrentAccountUin(), 0).edit();
      if (i != 1) {
        bool1 = false;
      }
      localEditor.putBoolean("svip_bubble_unread_switch", bool1).apply();
      localObject = (VipInfoHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
      if (localObject != null) {
        ((VipInfoHandler)localObject).a(paramBoolean);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setBubbleUnreadShow ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("BubbleManager", 2, ((StringBuilder)localObject).toString());
  }
  
  public boolean a()
  {
    Object localObject = this.e.d;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if (this.a == 0)
    {
      int i;
      if (((AppRuntime)localObject).getApp().getSharedPreferences(((AppRuntime)localObject).getCurrentAccountUin(), 0).getBoolean("svip_bubble_unread_switch", true)) {
        i = 1;
      } else {
        i = -1;
      }
      this.a = i;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showBubbleUnread ");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("BubbleManager", 2, ((StringBuilder)localObject).toString());
    if (this.a == 1) {
      bool = true;
    }
    return bool;
  }
  
  String[] a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.e.d(paramInt).getAbsolutePath());
    ((StringBuilder)localObject1).append(File.separatorChar);
    ((StringBuilder)localObject1).append("unread");
    ((StringBuilder)localObject1).append(File.separatorChar);
    ((StringBuilder)localObject1).append("unread1.png");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.e.d(paramInt).getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separatorChar);
    ((StringBuilder)localObject2).append("unread");
    ((StringBuilder)localObject2).append(File.separatorChar);
    ((StringBuilder)localObject2).append("unread2.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.e.d(paramInt).getAbsolutePath());
    ((StringBuilder)localObject3).append(File.separatorChar);
    ((StringBuilder)localObject3).append("unread");
    ((StringBuilder)localObject3).append(File.separatorChar);
    ((StringBuilder)localObject3).append("unread3.png");
    localObject3 = ((StringBuilder)localObject3).toString();
    if ((new File((String)localObject1).exists()) && (new File((String)localObject2).exists()) && (new File((String)localObject3).exists())) {
      return new String[] { localObject1, localObject2, localObject3 };
    }
    return null;
  }
  
  public boolean b()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("K_QQ_VAS", "SK_QQ_VAS_ShowSwitchPersonalUnread", 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleUnRead
 * JD-Core Version:    0.7.0.1
 */