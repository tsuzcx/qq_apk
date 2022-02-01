package com.tencent.mobileqq.activity.emogroupstore;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class SDKEmotionSettingManager
  implements Handler.Callback, ISDKEmotionSettingManager
{
  protected boolean a = false;
  protected boolean b = false;
  protected QQProgressDialog c;
  protected QQCustomDialog d = null;
  protected QQCustomDialog e = null;
  private final long f = 60000L;
  private Activity g;
  private String h = null;
  private String i = null;
  private String j;
  private String k;
  private String l;
  private boolean m = false;
  private List<Integer> n;
  private List<String> o = new ArrayList();
  private List<Uri> p = new ArrayList();
  private String q;
  private final MqqHandler r = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean s = false;
  private Runnable t = new SDKEmotionSettingManager.6(this);
  private Runnable u = new SDKEmotionSettingManager.7(this);
  private Runnable v = new SDKEmotionSettingManager.8(this);
  private SDKSetEmotionDialog w;
  
  public SDKEmotionSettingManager(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " onCreateView ");
    }
    this.g = paramActivity;
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (this.g.isFinishing()) {
      return;
    }
    Object localObject = this.w;
    if (localObject != null)
    {
      if (!((SDKSetEmotionDialog)localObject).isShowing()) {
        return;
      }
      int i1 = (int)(paramInt * paramFloat);
      double d1 = paramFloat;
      Double.isNaN(d1);
      int i2 = (int)(d1 * 100.0D);
      localObject = String.format(this.g.getResources().getString(2131888280), new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) });
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateCurrentDisplay displayStr=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" disPlayProgress=");
        localStringBuilder.append(i2);
        localStringBuilder.append(", currentCount = ");
        localStringBuilder.append(i1);
        QLog.d("SDKEmotionSettingManager", 2, localStringBuilder.toString());
      }
      ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.19(this, (String)localObject, i2));
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showResultDialog successCount =");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", failCount =");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("SDKEmotionSettingManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        return;
      }
      int i1 = paramInt1 + paramInt2;
      boolean bool = false;
      if ((paramInt1 > 0) && (paramInt2 == 0))
      {
        localObject1 = String.format(this.g.getResources().getString(2131888283), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
        bool = true;
      }
      else if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localObject1 = String.format(this.g.getResources().getString(2131888285), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i1), Integer.valueOf(paramInt2) });
      }
      else if ((paramInt1 == 0) && (paramInt2 > 0))
      {
        localObject1 = String.format(this.g.getResources().getString(2131888278), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt2) });
      }
      else
      {
        localObject1 = "";
      }
      a(null, (String)localObject1, bool, paramString);
      paramString = this.j;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("");
      ReportController.b(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, paramString, (String)localObject1, (String)localObject2, localStringBuilder.toString());
      if (paramInt2 > 0)
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(paramInt2);
        ReportController.b(null, "dc00898", "", "", "0X8009DCC", "0X8009DCC", 0, 0, paramString.toString(), "", "", "");
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    localObject = ((Activity)localObject).getResources();
    if (localObject == null) {
      return;
    }
    String str = null;
    boolean bool = false;
    if (paramInt == 0)
    {
      str = ((Resources)localObject).getString(2131888284);
      localObject = "";
      bool = true;
    }
    else if ((paramInt != 2) && (paramInt != 3))
    {
      if (paramInt == 1) {
        localObject = ((Resources)localObject).getString(2131888281);
      } else {
        localObject = ((Resources)localObject).getString(2131888279);
      }
    }
    else
    {
      localObject = ((Resources)localObject).getString(2131888275);
    }
    a(str, (String)localObject, bool, paramString);
    localObject = "1";
    if (bool) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    if (bool) {
      localObject = "0";
    }
    str = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("");
    ReportController.b(null, "dc00898", "", "", "0X8009DC9", "0X8009DC9", 0, 0, str, "1", paramString, localStringBuilder.toString());
  }
  
  private void a(int paramInt, List<Integer> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleFinishUpload addEmotionsResults =");
      ((StringBuilder)localObject).append(paramList);
      ((StringBuilder)localObject).append(", totalSize =");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SDKEmotionSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 0)
    {
      if (paramList == null) {
        return;
      }
      if (paramInt != paramList.size()) {
        return;
      }
      int i1 = 0;
      int i3 = 0;
      int i2 = 0;
      while (i1 < paramList.size())
      {
        if (((Integer)paramList.get(i1)).intValue() == 0) {
          i3 += 1;
        } else {
          i2 += 1;
        }
        i1 += 1;
      }
      localObject = d(paramList);
      ThreadManager.getUIHandler().postDelayed(new SDKEmotionSettingManager.21(this, paramInt, i3, (String)localObject, paramList, i2), 200L);
    }
  }
  
  private void a(Activity paramActivity, long paramLong)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSdkCancelCallback:sdk callback= appid=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("SDKEmotionSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion" })));
    if (paramActivity.getIntent() != null) {
      ((Intent)localObject).setPackage(this.i);
    }
    try
    {
      localObject = PendingIntent.getActivity(paramActivity, 0, (Intent)localObject, 268435456);
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        paramActivity.removeExtra("sdk_emotion_pending_intent");
        paramActivity.putExtra("sdk_emotion_pending_intent", (Parcelable)localObject);
        return;
      }
    }
    catch (ActivityNotFoundException paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
      }
    }
  }
  
  private void a(Activity paramActivity, long paramLong, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSdkSuccessCallback:sdk callback= appid=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("SDKEmotionSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    if (paramBoolean) {
      ((Intent)localObject).putExtra("stay_back_stack", true);
    }
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion" })));
    if (paramActivity.getIntent() != null) {
      ((Intent)localObject).setPackage(this.i);
    }
    try
    {
      localObject = PendingIntent.getActivity(paramActivity, 0, (Intent)localObject, 268435456);
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        paramActivity.removeExtra("sdk_emotion_pending_intent");
        paramActivity.putExtra("sdk_emotion_pending_intent", (Parcelable)localObject);
        return;
      }
    }
    catch (ActivityNotFoundException paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
      }
    }
  }
  
  private void a(Activity paramActivity, long paramLong, boolean paramBoolean, String paramString)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startSdkErrorCallback:sdk callback= appid=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("SDKEmotionSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    Intent localIntent = new Intent();
    if (paramBoolean) {
      localIntent.putExtra("stay_back_stack", true);
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), "sdkSetEmotion", Integer.valueOf(-1), localObject })));
    if (paramActivity.getIntent() != null) {
      localIntent.setPackage(this.i);
    }
    try
    {
      paramString = PendingIntent.getActivity(paramActivity, 0, localIntent, 268435456);
      paramActivity = paramActivity.getIntent();
      if (paramActivity != null)
      {
        paramActivity.removeExtra("sdk_emotion_pending_intent");
        paramActivity.putExtra("sdk_emotion_pending_intent", paramString);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, paramActivity.getMessage());
      }
    }
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (this.g.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, "showResultDialog is finishing return");
      }
      return;
    }
    Object localObject;
    if (TextUtils.isEmpty(this.h))
    {
      localObject = HardCodeUtil.a(2131901576);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131901576));
      ((StringBuilder)localObject).append(this.h);
      localObject = ((StringBuilder)localObject).toString();
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.g, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setPositiveButton("留在QQ", new SDKEmotionSettingManager.23(this, paramBoolean, paramString3)).setNegativeButton((String)localObject, new SDKEmotionSettingManager.22(this, paramBoolean, paramString3)).show();
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleStopUpload totalSize =");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mCurrentUploadedList = ");
      ((StringBuilder)localObject).append(this.n);
      QLog.d("SDKEmotionSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    this.r.removeMessages(11);
    k();
    Object localObject = this.n;
    int i2 = 0;
    if (localObject != null) {
      for (int i1 = 0;; i1 = i3)
      {
        i3 = i1;
        if (i2 >= this.n.size()) {
          break;
        }
        i3 = i1;
        if (((Integer)this.n.get(i2)).intValue() == 0) {
          i3 = i1 + 1;
        }
        i2 += 1;
      }
    }
    int i3 = 0;
    ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.20(this, paramInt, i3, paramInt - i3));
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      this.s = false;
      int i1 = paramArrayList.size();
      Message localMessage = this.r.obtainMessage(11);
      localMessage.arg1 = i1;
      this.r.sendMessageDelayed(localMessage, 60000L);
      ((IFavroamingManagerService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFavroamingManagerService.class)).addCustomEmotions(paramArrayList, new SDKEmotionSettingManager.18(this, i1));
    }
  }
  
  private void b(List<Uri> paramList)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { " openSetEmotion uriList = ", paramList });
    ((IFavroamingManagerService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFavroamingManagerService.class)).syncRoaming();
    this.r.postDelayed(this.v, 2000L);
    new SDKEmotionSettingManager.1(this, paramList).execute(new Void[0]);
  }
  
  private void c(List<Integer> paramList)
  {
    if (this.n == null) {
      this.n = new ArrayList();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.n.clear();
      this.n.addAll(paramList);
      return;
    }
    this.n.clear();
  }
  
  private String d(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i1 = 0;
      while (i1 < paramList.size())
      {
        int i2 = ((Integer)paramList.get(i1)).intValue();
        if (i2 == 0) {
          localStringBuilder.append("0_");
        } else if (i2 == 1) {
          localStringBuilder.append("102_");
        } else if (i2 == 3) {
          localStringBuilder.append("100_");
        } else if (i2 == 2) {
          localStringBuilder.append("100_");
        } else {
          localStringBuilder.append("101_");
        }
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private void g()
  {
    this.a = false;
    this.b = false;
  }
  
  private void h()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.g.getString(2131916399));
    ((StringBuilder)localObject1).append(this.h);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject3;
    if (!TextUtils.isEmpty(this.i)) {
      try
      {
        localObject1 = this.g.getPackageManager().getPackageInfo(this.i, 64);
        if (localObject1 == null) {
          break label133;
        }
        localObject1 = ((PackageInfo)localObject1).signatures;
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label133;
        }
        localObject3 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject3).update(localObject1[0].toByteArray());
        localObject1 = HexUtil.bytes2HexStr(((MessageDigest)localObject3).digest());
      }
      catch (Exception localException1)
      {
        QLog.e("SDKEmotionSettingManager", 1, "check, get signature exception=", localException1);
        break label133;
      }
    } else {
      QLog.e("SDKEmotionSettingManager", 1, "check, pkgName null");
    }
    label133:
    Object localObject2 = null;
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "checkApiPermission api, mShareAppId=", this.j, ", mPkgName=", this.i, ",signature=", localObject2, ",mSdkVerdion=", this.l });
    if ((!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("sdkVersion", this.l);
      ((Bundle)localObject3).putString("pkgName", this.i);
      ((Bundle)localObject3).putString("signature", (String)localObject2);
      a(2131916575);
      this.r.postDelayed(this.t, 5000L);
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(this.g, 1, this.j, (Bundle)localObject3).a("sdk_face_collection", null, new SDKEmotionSettingManager.3(this, str));
      return;
    }
    QLog.e("SDKEmotionSettingManager", 1, new Object[] { "check, invalid param, mShareAppId=", this.j, ", pkgName=", this.i, ", signature=", localObject2 });
    try
    {
      localObject2 = DialogUtil.a(this.g, 230);
      ((QQCustomDialog)localObject2).setMessage(HardCodeUtil.a(2131911074));
      ((QQCustomDialog)localObject2).setNegativeButton(2131887648, new SDKEmotionSettingManager.2(this));
      ((QQCustomDialog)localObject2).setCancelable(false);
      ((QQCustomDialog)localObject2).show();
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("SDKEmotionSettingManager", 1, "show invalid param dialog, exception=", localException2);
    }
  }
  
  private void i()
  {
    boolean bool = ForwardUtils.a(this.g);
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "setEmotion hasPermission=", Boolean.valueOf(bool) });
    if (!bool)
    {
      PermissionUtils.requestStorePermission((AppActivity)this.g, 3, new SDKEmotionSettingManager.4(this));
      return;
    }
    b(this.p);
  }
  
  private void j()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" checkJumpAction mShareAppId = ");
    ((StringBuilder)localObject).append(this.j);
    ((StringBuilder)localObject).append("， mShareOpenId =");
    ((StringBuilder)localObject).append(this.k);
    QLog.i("SDKEmotionSettingManager", 1, ((StringBuilder)localObject).toString());
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(this.g, Long.valueOf(this.j).longValue(), false, "-10");
      l();
      return;
    }
    if ((!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.k)))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      OpenID localOpenID = ((QQAppInterface)localObject).getMsgHandler().e(this.j);
      if (localOpenID == null)
      {
        a(2131916575);
        this.r.postDelayed(this.u, 8000L);
        try
        {
          long l1 = Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin());
          ((QQAppInterface)localObject).getMsgHandler().a(l1, this.k, Long.valueOf(this.j).longValue(), new SDKEmotionSettingManager.5(this));
          return;
        }
        catch (Exception localException)
        {
          QLog.e("SDKEmotionSettingManager", 1, "-->parse uin exception:", localException);
          return;
        }
      }
      if (!this.k.equals(localOpenID.openID))
      {
        QLog.i("SDKEmotionSettingManager", 1, "-->preForward--openid doesn't equal current local openid");
        e();
        return;
      }
      d();
      i();
      return;
    }
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction find third app not login setEmotion");
    d();
    i();
  }
  
  private void k()
  {
    ((IFavroamingManagerService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFavroamingManagerService.class)).cancelAddCustomEmotions();
  }
  
  private void l()
  {
    this.r.removeMessages(11);
    f();
    this.g.moveTaskToBack(true);
  }
  
  private void m()
  {
    try
    {
      PendingIntent localPendingIntent = (PendingIntent)this.g.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
      if (localPendingIntent != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SDKEmotionSettingManager", 2, "-->finish--send callback using PendingIntent");
        }
        try
        {
          localPendingIntent.send();
          return;
        }
        catch (PendingIntent.CanceledException localCanceledException)
        {
          QLog.e("SDKEmotionSettingManager", 2, "failed to send PendingIntent", localCanceledException);
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SDKEmotionSettingManager", 2, "qbShowShareResultDialog ", localThrowable);
      }
    }
  }
  
  public ArrayList<String> a(List<Uri> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      localArrayList.addAll(paramList);
    }
    else if (!TextUtils.isEmpty(this.q))
    {
      try
      {
        paramList = this.q.split(";");
        i1 = 0;
        while (i1 < paramList.length)
        {
          localArrayList.add(Uri.parse(paramList[i1]));
          i1 += 1;
        }
        if (!QLog.isColorLevel()) {
          break label130;
        }
      }
      catch (Exception paramList)
      {
        QLog.d("SDKEmotionSettingManager", 1, " openSetEmotion mComingStrUriList parse error!", paramList);
      }
    }
    else
    {
      paramList = new StringBuilder();
      paramList.append(" openSetEmotion JSONArray currentUris = ");
      paramList.append(localArrayList);
      QLog.d("SDKEmotionSettingManager", 2, paramList.toString());
    }
    label130:
    if (localArrayList.size() == 0) {
      return null;
    }
    paramList = new ArrayList();
    UriParserPathHelper localUriParserPathHelper = new UriParserPathHelper(this.g, false, null);
    int i1 = 0;
    while (i1 < localArrayList.size())
    {
      String str = localUriParserPathHelper.a((Uri)localArrayList.get(i1), false);
      if (!TextUtils.isEmpty(str)) {
        paramList.add(str);
      }
      i1 += 1;
    }
    return paramList;
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt)
  {
    if (this.c == null)
    {
      Activity localActivity = this.g;
      this.c = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299920));
    }
    this.c.c(paramInt);
    if (!this.g.isFinishing()) {
      this.c.show();
    }
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = this.w;
    if ((localObject != null) && (((SDKSetEmotionDialog)localObject).isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, " onNewIntent return error");
      }
      paramIntent = null;
      if (this.o != null)
      {
        paramIntent = new StringBuilder();
        localObject = this.o.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramIntent.append("104_");
        }
        paramIntent = paramIntent.toString();
      }
      a(this.g, Long.valueOf(this.j).longValue(), false, paramIntent);
      m();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, " onNewIntent start new");
    }
    this.g.setIntent(paramIntent);
    b(paramIntent);
    a();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = this.d;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.e = DialogUtil.a(this.g, 230);
    this.e.setMessage(paramString1);
    paramString1 = new SDKEmotionSettingManager.9(this);
    this.e.setNegativeButton(paramString2, paramString1);
    this.e.setOnKeyListener(new SDKEmotionSettingManager.10(this));
    this.e.show();
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPreviewDialog list =");
    localStringBuilder.append(paramArrayList);
    QLog.i("SDKEmotionSettingManager", 1, localStringBuilder.toString());
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      int i1 = paramArrayList.size();
      this.w = new SDKSetEmotionDialog(this.g);
      this.w.a("收藏为QQ表情");
      this.w.a(2131887648, new SDKEmotionSettingManager.12(this));
      this.w.c(2131888271, new SDKEmotionSettingManager.13(this, paramArrayList, i1));
      this.w.b(2131888272, new SDKEmotionSettingManager.14(this, i1));
      this.w.a(paramArrayList, new SDKEmotionSettingManager.15(this, i1, paramArrayList));
      if (i1 > 1)
      {
        paramArrayList = String.format(this.g.getResources().getString(2131888277), new Object[] { Integer.valueOf(i1) });
        this.w.b(paramArrayList);
      }
      this.w.setOnDismissListener(new SDKEmotionSettingManager.16(this));
      this.w.setOnKeyListener(new SDKEmotionSettingManager.17(this, i1));
      this.w.setCanceledOnTouchOutside(false);
      this.w.show();
      AbstractGifImage.resumeAll();
      return;
    }
    QLog.e("SDKEmotionSettingManager", 1, "showPreviewDialog list null error");
  }
  
  public void b()
  {
    this.r.removeMessages(11);
    SDKSetEmotionDialog localSDKSetEmotionDialog = this.w;
    if (localSDKSetEmotionDialog != null) {
      localSDKSetEmotionDialog.dismiss();
    }
    this.o.clear();
    this.m = false;
    this.s = false;
  }
  
  public void b(Intent paramIntent)
  {
    this.q = paramIntent.getStringExtra("key_from_sdk_set_emotion_uri_list");
    this.p = paramIntent.getParcelableArrayListExtra("key_from_sdk_set_emotion_uri");
    this.h = paramIntent.getStringExtra("key_from_sdk_set_emotion_appname");
    this.j = paramIntent.getStringExtra("key_from_sdk_set_emotion_share_id");
    this.k = paramIntent.getStringExtra("key_from_sdk_set_emotion_open_id");
    this.i = paramIntent.getStringExtra("pkg_name");
    this.l = paramIntent.getStringExtra("sdk_version");
    g();
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " initParam ");
    }
  }
  
  public void c()
  {
    Intent localIntent = new Intent();
    PendingIntent localPendingIntent = (PendingIntent)this.g.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
    if (localPendingIntent != null)
    {
      QLog.d("SDKEmotionSettingManager", 1, "onBackEvent using PendingIntent");
      localIntent.putExtra("activity_finish_run_pendingIntent", localPendingIntent);
    }
    localIntent.setClass(this.g, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    this.g.startActivity(localIntent);
  }
  
  public void d()
  {
    QQProgressDialog localQQProgressDialog = this.c;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.c.dismiss();
    }
  }
  
  protected void e()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.e.show();
      }
      return;
    }
    this.e = DialogUtil.a(this.g, 230);
    this.e.setMessage(HardCodeUtil.a(2131911071));
    this.e.setTitle(2131889094);
    localObject = new SDKEmotionSettingManager.11(this);
    this.e.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    this.e.setPositiveButton(2131916409, (DialogInterface.OnClickListener)localObject);
    this.e.show();
  }
  
  protected void f()
  {
    m();
    Intent localIntent = new Intent();
    this.g.setResult(-1, localIntent);
    this.g.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 11) {
      return true;
    }
    this.s = true;
    b(paramMessage.arg1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager
 * JD-Core Version:    0.7.0.1
 */