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
  private final long jdField_a_of_type_Long = 60000L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SDKSetEmotionDialog jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog;
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SDKEmotionSettingManager.6(this);
  private String jdField_a_of_type_JavaLangString = null;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  protected boolean a;
  protected QQCustomDialog b;
  private Runnable jdField_b_of_type_JavaLangRunnable = new SDKEmotionSettingManager.7(this);
  private String jdField_b_of_type_JavaLangString = null;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  protected boolean b;
  private Runnable jdField_c_of_type_JavaLangRunnable = new SDKEmotionSettingManager.8(this);
  private String jdField_c_of_type_JavaLangString;
  private List<Uri> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private String e;
  private String f;
  
  public SDKEmotionSettingManager(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " onCreateView ");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private String a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramList.size())
      {
        int j = ((Integer)paramList.get(i)).intValue();
        if (j == 0) {
          localStringBuilder.append("0_");
        } else if (j == 1) {
          localStringBuilder.append("102_");
        } else if (j == 3) {
          localStringBuilder.append("100_");
        } else if (j == 2) {
          localStringBuilder.append("100_");
        } else {
          localStringBuilder.append("101_");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog;
    if (localObject != null)
    {
      if (!((SDKSetEmotionDialog)localObject).isShowing()) {
        return;
      }
      int i = (int)(paramInt * paramFloat);
      double d1 = paramFloat;
      Double.isNaN(d1);
      int j = (int)(d1 * 100.0D);
      localObject = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691325), new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateCurrentDisplay displayStr=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" disPlayProgress=");
        localStringBuilder.append(j);
        localStringBuilder.append(", currentCount = ");
        localStringBuilder.append(i);
        QLog.d("SDKEmotionSettingManager", 2, localStringBuilder.toString());
      }
      ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.19(this, (String)localObject, j));
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
      int i = paramInt1 + paramInt2;
      boolean bool = false;
      if ((paramInt1 > 0) && (paramInt2 == 0))
      {
        localObject1 = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691328), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1) });
        bool = true;
      }
      else if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localObject1 = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691330), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(paramInt2) });
      }
      else if ((paramInt1 == 0) && (paramInt2 > 0))
      {
        localObject1 = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691323), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt2) });
      }
      else
      {
        localObject1 = "";
      }
      a(null, (String)localObject1, bool, paramString);
      paramString = this.jdField_c_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i);
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
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
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
      str = ((Resources)localObject).getString(2131691329);
      localObject = "";
      bool = true;
    }
    else if ((paramInt != 2) && (paramInt != 3))
    {
      if (paramInt == 1) {
        localObject = ((Resources)localObject).getString(2131691326);
      } else {
        localObject = ((Resources)localObject).getString(2131691324);
      }
    }
    else
    {
      localObject = ((Resources)localObject).getString(2131691320);
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
    str = this.jdField_c_of_type_JavaLangString;
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
      int i = 0;
      int k = 0;
      int j = 0;
      while (i < paramList.size())
      {
        if (((Integer)paramList.get(i)).intValue() == 0) {
          k += 1;
        } else {
          j += 1;
        }
        i += 1;
      }
      localObject = a(paramList);
      ThreadManager.getUIHandler().postDelayed(new SDKEmotionSettingManager.21(this, paramInt, k, (String)localObject, paramList, j), 200L);
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
      ((Intent)localObject).setPackage(this.jdField_b_of_type_JavaLangString);
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
      ((Intent)localObject).setPackage(this.jdField_b_of_type_JavaLangString);
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
      localIntent.setPackage(this.jdField_b_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, "showResultDialog is finishing return");
      }
      return;
    }
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = HardCodeUtil.a(2131713522);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131713522));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setPositiveButton("留在QQ", new SDKEmotionSettingManager.23(this, paramBoolean, paramString3)).setNegativeButton((String)localObject, new SDKEmotionSettingManager.22(this, paramBoolean, paramString3)).show();
  }
  
  private void a(List<Uri> paramList)
  {
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { " openSetEmotion uriList = ", paramList });
    ((IFavroamingManagerService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFavroamingManagerService.class)).syncRoaming();
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    new SDKEmotionSettingManager.1(this, paramList).execute(new Void[0]);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleStopUpload totalSize =");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mCurrentUploadedList = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList);
      QLog.d("SDKEmotionSettingManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    k();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    if (localObject != null) {
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        k = i;
        if (((Integer)this.jdField_a_of_type_JavaUtilList.get(j)).intValue() == 0) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    ThreadManager.getUIHandler().post(new SDKEmotionSettingManager.20(this, paramInt, k, paramInt - k));
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      this.jdField_d_of_type_Boolean = false;
      int i = paramArrayList.size();
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(11);
      localMessage.arg1 = i;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 60000L);
      ((IFavroamingManagerService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IFavroamingManagerService.class)).addCustomEmotions(paramArrayList, new SDKEmotionSettingManager.18(this, i));
    }
  }
  
  private void b(List<Integer> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  private void g()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void h()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidAppActivity.getString(2131718866));
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject3;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getPackageManager().getPackageInfo(this.jdField_b_of_type_JavaLangString, 64);
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
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "checkApiPermission api, mShareAppId=", this.jdField_c_of_type_JavaLangString, ", mPkgName=", this.jdField_b_of_type_JavaLangString, ",signature=", localObject2, ",mSdkVerdion=", this.e });
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("sdkVersion", this.e);
      ((Bundle)localObject3).putString("pkgName", this.jdField_b_of_type_JavaLangString);
      ((Bundle)localObject3).putString("signature", (String)localObject2);
      a(2131719039);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_c_of_type_JavaLangString, (Bundle)localObject3).a("sdk_face_collection", null, new SDKEmotionSettingManager.3(this, str));
      return;
    }
    QLog.e("SDKEmotionSettingManager", 1, new Object[] { "check, invalid param, mShareAppId=", this.jdField_c_of_type_JavaLangString, ", pkgName=", this.jdField_b_of_type_JavaLangString, ", signature=", localObject2 });
    try
    {
      localObject2 = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
      ((QQCustomDialog)localObject2).setMessage(HardCodeUtil.a(2131713527));
      ((QQCustomDialog)localObject2).setNegativeButton(2131690728, new SDKEmotionSettingManager.2(this));
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
    boolean bool = ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity);
    QLog.d("SDKEmotionSettingManager", 1, new Object[] { "setEmotion hasPermission=", Boolean.valueOf(bool) });
    if (!bool)
    {
      PermissionUtils.requestStorePermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, 3, new SDKEmotionSettingManager.4(this));
      return;
    }
    a(this.jdField_c_of_type_JavaUtilList);
  }
  
  private void j()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" checkJumpAction mShareAppId = ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append("， mShareOpenId =");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
    QLog.i("SDKEmotionSettingManager", 1, ((StringBuilder)localObject).toString());
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      a(this.jdField_a_of_type_AndroidAppActivity, Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), false, "-10");
      l();
      return;
    }
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      OpenID localOpenID = ((QQAppInterface)localObject).getMsgHandler().a(this.jdField_c_of_type_JavaLangString);
      if (localOpenID == null)
      {
        a(2131719039);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 8000L);
        try
        {
          long l = Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin());
          ((QQAppInterface)localObject).getMsgHandler().a(l, this.jdField_d_of_type_JavaLangString, Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), new SDKEmotionSettingManager.5(this));
          return;
        }
        catch (Exception localException)
        {
          QLog.e("SDKEmotionSettingManager", 1, "-->parse uin exception:", localException);
          return;
        }
      }
      if (!this.jdField_d_of_type_JavaLangString.equals(localOpenID.openID))
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
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    f();
    this.jdField_a_of_type_AndroidAppActivity.moveTaskToBack(true);
  }
  
  private void m()
  {
    try
    {
      PendingIntent localPendingIntent = (PendingIntent)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
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
    else if (!TextUtils.isEmpty(this.f))
    {
      try
      {
        paramList = this.f.split(";");
        i = 0;
        while (i < paramList.length)
        {
          localArrayList.add(Uri.parse(paramList[i]));
          i += 1;
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
    UriParserPathHelper localUriParserPathHelper = new UriParserPathHelper(this.jdField_a_of_type_AndroidAppActivity, false, null);
    int i = 0;
    while (i < localArrayList.size())
    {
      String str = localUriParserPathHelper.a((Uri)localArrayList.get(i), false);
      if (!TextUtils.isEmpty(str)) {
        paramList.add(str);
      }
      i += 1;
    }
    return paramList;
  }
  
  public void a()
  {
    h();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299168));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog;
    if ((localObject != null) && (((SDKSetEmotionDialog)localObject).isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKEmotionSettingManager", 2, " onNewIntent return error");
      }
      paramIntent = null;
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        paramIntent = new StringBuilder();
        localObject = this.jdField_b_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          paramIntent.append("104_");
        }
        paramIntent = paramIntent.toString();
      }
      a(this.jdField_a_of_type_AndroidAppActivity, Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), false, paramIntent);
      m();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, " onNewIntent start new");
    }
    this.jdField_a_of_type_AndroidAppActivity.setIntent(paramIntent);
    b(paramIntent);
    a();
  }
  
  protected void a(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString1);
    paramString1 = new SDKEmotionSettingManager.9(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString2, paramString1);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnKeyListener(new SDKEmotionSettingManager.10(this));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPreviewDialog list =");
    localStringBuilder.append(paramArrayList);
    QLog.i("SDKEmotionSettingManager", 1, localStringBuilder.toString());
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      int i = paramArrayList.size();
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog = new SDKSetEmotionDialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.a("收藏为QQ表情");
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.a(2131690728, new SDKEmotionSettingManager.12(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.c(2131691316, new SDKEmotionSettingManager.13(this, paramArrayList, i));
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.b(2131691317, new SDKEmotionSettingManager.14(this, i));
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.a(paramArrayList, new SDKEmotionSettingManager.15(this, i, paramArrayList));
      if (i > 1)
      {
        paramArrayList = String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131691322), new Object[] { Integer.valueOf(i) });
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.b(paramArrayList);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.setOnDismissListener(new SDKEmotionSettingManager.16(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.setOnKeyListener(new SDKEmotionSettingManager.17(this, i));
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog.show();
      AbstractGifImage.resumeAll();
      return;
    }
    QLog.e("SDKEmotionSettingManager", 1, "showPreviewDialog list null error");
  }
  
  public void b()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(11);
    SDKSetEmotionDialog localSDKSetEmotionDialog = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKSetEmotionDialog;
    if (localSDKSetEmotionDialog != null) {
      localSDKSetEmotionDialog.dismiss();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void b(Intent paramIntent)
  {
    this.f = paramIntent.getStringExtra("key_from_sdk_set_emotion_uri_list");
    this.jdField_c_of_type_JavaUtilList = paramIntent.getParcelableArrayListExtra("key_from_sdk_set_emotion_uri");
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("key_from_sdk_set_emotion_appname");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("key_from_sdk_set_emotion_share_id");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("key_from_sdk_set_emotion_open_id");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("pkg_name");
    this.e = paramIntent.getStringExtra("sdk_version");
    g();
    if (QLog.isColorLevel()) {
      QLog.w("SDKEmotionSettingManager", 2, " initParam ");
    }
  }
  
  public void c()
  {
    Intent localIntent = new Intent();
    PendingIntent localPendingIntent = (PendingIntent)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("sdk_emotion_pending_intent");
    if (localPendingIntent != null)
    {
      QLog.d("SDKEmotionSettingManager", 1, "onBackEvent using PendingIntent");
      localIntent.putExtra("activity_finish_run_pendingIntent", localPendingIntent);
    }
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void e()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(HardCodeUtil.a(2131713523));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
    localObject = new SDKEmotionSettingManager.11(this);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718876, (DialogInterface.OnClickListener)localObject);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void f()
  {
    m();
    Intent localIntent = new Intent();
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 11) {
      return true;
    }
    this.jdField_d_of_type_Boolean = true;
    b(paramMessage.arg1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager
 * JD-Core Version:    0.7.0.1
 */