package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import mqq.app.MobileQQ;

public final class SdkDynamicAvatarSettingHelper
{
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, "[showSettingResultDialog]");
    }
    if (paramActivity == null) {
      return;
    }
    Object localObject = paramActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("pkg_name");
    String str2 = ((Intent)localObject).getStringExtra("app_name");
    String str3 = ((Intent)localObject).getStringExtra("share_id");
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)))
    {
      localObject = new ShareAioResultDialog(paramActivity);
      ((TextView)((ShareAioResultDialog)localObject).findViewById(2131447473)).setText(HardCodeUtil.a(2131911068));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQAppInterface.getApplication().getString(2131916399));
      localStringBuilder.append(str2);
      str2 = localStringBuilder.toString();
      paramActivity = new SdkDynamicAvatarSettingHelper.5(paramActivity, str1, str3, localQQAppInterface);
      ((ShareAioResultDialog)localObject).a(str2, paramActivity);
      ((ShareAioResultDialog)localObject).a(paramActivity);
      ((ShareAioResultDialog)localObject).setCancelable(false);
      ((ShareAioResultDialog)localObject).show();
      return;
    }
    QLog.d("SdkDynamicAvatarSettingHelper", 1, "[showSettingResultDialog] no third app info");
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Intent localIntent = paramActivity.getIntent();
      String str1 = localIntent.getStringExtra("share_id");
      Object localObject1 = localIntent.getStringExtra("app_name");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localQQAppInterface.getApplication().getString(2131916399));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      String str2 = localIntent.getStringExtra("sdk_version");
      String str3 = localIntent.getStringExtra("pkg_name");
      Object localObject3;
      if (!TextUtils.isEmpty(str3)) {
        try
        {
          localObject1 = paramActivity.getPackageManager().getPackageInfo(str3, 64);
          if (localObject1 == null) {
            break label192;
          }
          localObject1 = ((PackageInfo)localObject1).signatures;
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label192;
          }
          localObject3 = MessageDigest.getInstance("MD5");
          ((MessageDigest)localObject3).update(localObject1[0].toByteArray());
          localObject1 = HexUtil.bytes2HexStr(((MessageDigest)localObject3).digest());
        }
        catch (Exception localException)
        {
          QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, get signature exception=", localException);
          break label192;
        }
      } else {
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, pkgName null");
      }
      label192:
      CharSequence localCharSequence = null;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(localCharSequence)))
      {
        ((IDoraemonService)QRoute.api(IDoraemonService.class)).prepare();
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("sdkVersion", str2);
        ((Bundle)localObject3).putString("pkgName", str3);
        ((Bundle)localObject3).putString("signature", localCharSequence);
        ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(paramActivity, 1, str1, (Bundle)localObject3).a("sdk_dynamic_avatar_edit", null, new SdkDynamicAvatarSettingHelper.2(localQQAppInterface, str1, paramActivity, (String)localObject2, str3, paramString, localIntent));
        return;
      }
      QLog.e("SdkDynamicAvatarSettingHelper", 1, new Object[] { "check, invalid param, shareAppId=", str1, ", pkgName=", str3, ", signature=", localCharSequence });
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009DFB", "0X8009DFB", 0, 0, str1, "1", "", "");
      try
      {
        paramString = DialogUtil.a(paramActivity, 230);
        paramString.setMessage(HardCodeUtil.a(2131911067));
        paramString.setNegativeButton(2131887648, new SdkDynamicAvatarSettingHelper.1(paramActivity));
        paramString.setCancelable(false);
        paramString.show();
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "show invalid param dialog, exception=", paramActivity);
        return;
      }
    }
    QLog.e("SdkDynamicAvatarSettingHelper", 1, "check, param null");
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(9);
    String str1 = localMediaMetadataRetriever.extractMetadata(18);
    String str2 = localMediaMetadataRetriever.extractMetadata(19);
    localMediaMetadataRetriever.release();
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 1, new Object[] { "[isVideoValid] width=", str1, ", height=", str2, ", duration=", paramString });
    }
    long l3 = 0L;
    long l1 = l3;
    long l2 = l3;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        l2 = l3;
        l1 = Long.parseLong(paramString);
      }
      l2 = l1;
      if (!TextUtils.isEmpty(str1))
      {
        l2 = l1;
        i = Integer.parseInt(str1);
      }
      else
      {
        i = 0;
      }
      l2 = l1;
      j = i;
      try
      {
        if (TextUtils.isEmpty(str2)) {
          break label216;
        }
        j = Integer.parseInt(str2);
      }
      catch (Exception paramString) {}
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "[isVideoValid] parse exception=", paramString);
    }
    catch (Exception paramString)
    {
      i = 0;
      l1 = l2;
    }
    int j = i;
    l2 = l1;
    label216:
    int k = 0;
    int i = j;
    l1 = l2;
    j = k;
    bool1 = bool2;
    if (l1 > 500L)
    {
      bool1 = bool2;
      if (l1 <= 8000L)
      {
        bool1 = bool2;
        if (i == j)
        {
          bool1 = bool2;
          if (i == 480) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      try
      {
        ShareAioResultDialog localShareAioResultDialog = new ShareAioResultDialog(paramActivity);
        ((TextView)localShareAioResultDialog.findViewById(2131447473)).setText(paramString1);
        paramString1 = localShareAioResultDialog.findViewById(2131431870);
        View localView = localShareAioResultDialog.findViewById(2131429863);
        paramString1.setVisibility(8);
        localView.setVisibility(8);
        localShareAioResultDialog.findViewById(2131447474).setVisibility(8);
        localShareAioResultDialog.a(paramString2, new SdkDynamicAvatarSettingHelper.3(paramActivity, paramString3, paramString4));
        localShareAioResultDialog.setCancelable(false);
        localShareAioResultDialog.show();
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "[showErrorDialog] exception=", paramActivity);
      }
    }
  }
  
  private static void b(Activity paramActivity, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        Intent localIntent = new Intent();
        localIntent.addFlags(268435456);
        if (paramBoolean2) {
          localIntent.putExtra("stay_back_stack", true);
        }
        long l = Long.parseLong(paramString2);
        if (paramBoolean1) {
          localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), "sdkSetDynamicAvatar" })));
        } else {
          localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error", new Object[] { Long.valueOf(l), "sdkSetDynamicAvatar" })));
        }
        localIntent.setPackage(paramString1);
        paramActivity.startActivity(localIntent);
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.e("SdkDynamicAvatarSettingHelper", 1, "[startSdkCallback] startActivity failed, exception=", paramActivity);
        return;
      }
    }
    QLog.e("SdkDynamicAvatarSettingHelper", 1, "[startSdkCallback] param null");
  }
  
  private static void c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    try
    {
      Object localObject = paramActivity.getIntent();
      String str1 = ((Intent)localObject).getStringExtra("pkg_name");
      String str2 = ((Intent)localObject).getStringExtra("share_id");
      localObject = DialogUtil.a(paramActivity, 230);
      ((QQCustomDialog)localObject).setMessage(HardCodeUtil.a(2131911069));
      ((QQCustomDialog)localObject).setTitle(2131889094);
      paramActivity = new SdkDynamicAvatarSettingHelper.4(paramActivity, str1, str2);
      ((QQCustomDialog)localObject).setNegativeButton(2131887648, paramActivity);
      ((QQCustomDialog)localObject).setPositiveButton(2131916409, paramActivity);
      ((QQCustomDialog)localObject).setCancelable(false);
      ((QQCustomDialog)localObject).show();
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("SdkDynamicAvatarSettingHelper", 1, "showDifferentAccountConfirm exception=", paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SdkDynamicAvatarSettingHelper
 * JD-Core Version:    0.7.0.1
 */