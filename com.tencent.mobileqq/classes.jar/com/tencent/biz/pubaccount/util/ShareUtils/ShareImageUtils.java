package com.tencent.biz.pubaccount.util.ShareUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class ShareImageUtils
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new ShareImageUtils.1();
  private static String jdField_a_of_type_JavaLangString;
  
  public static void a()
  {
    WXShareHelper.a().a(jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchFriendPicker path = ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      QLog.d("ShareImageUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (jdField_a_of_type_JavaLangString == null)
    {
      QLog.e("ShareImageUtils", 1, "currentPath is null");
      return;
    }
    Object localObject = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_help_forward_pic", true);
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("forward_type", 1);
    ((Intent)localObject).putExtra("key_allow_multiple_forward_from_limit", false);
    ((Intent)localObject).putExtra("key_share_from_screen_shot", true);
    ((Intent)localObject).putExtra("key_share_from_screen_need_finish", true);
    ((Intent)localObject).setData(Uri.parse(jdField_a_of_type_JavaLangString));
    paramActivity.startActivityForResult((Intent)localObject, 3);
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      QLog.e("ShareImageUtils", 1, "bitmap is null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ShareImageUtils.2(paramContext));
  }
  
  public static void a(Bitmap paramBitmap)
  {
    jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "shareToQzone");
    }
    if (jdField_a_of_type_JavaLangString == null)
    {
      QLog.e("ShareImageUtils", 1, "currentPath is null");
      return;
    }
    paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(jdField_a_of_type_JavaLangString);
    localBundle.putStringArrayList("images", localArrayList);
    QZoneShareManager.publishToQzone(paramBaseActivity, BaseApplicationImpl.getContext(), localBundle, null, 2);
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_AndroidGraphicsBitmap = null;
    WXShareHelper.a().b(jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  public static void b(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "ScreenShotShareFragment shareToWXFriend");
    }
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      int i;
      if (!WXShareHelper.a().a()) {
        i = 2131720478;
      } else if (!WXShareHelper.a().b()) {
        i = 2131720479;
      } else {
        i = -1;
      }
      if (i != -1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(i), 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
        return;
      }
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).shareImageToWX(jdField_a_of_type_JavaLangString, jdField_a_of_type_AndroidGraphicsBitmap, 0, false);
      return;
    }
    QLog.e("ShareImageUtils", 1, "currentPath or bitmap is null");
  }
  
  public static void c(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "shareToFriendCircle");
    }
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      int i;
      if (!WXShareHelper.a().a()) {
        i = 2131720478;
      } else if (!WXShareHelper.a().b()) {
        i = 2131720479;
      } else {
        i = -1;
      }
      if (i != -1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(i), 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
        return;
      }
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).shareImageToWX(jdField_a_of_type_JavaLangString, jdField_a_of_type_AndroidGraphicsBitmap, 1, false);
      return;
    }
    QLog.e("ShareImageUtils", 1, "currentPath or bitmap is null");
  }
  
  private static void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_ROOT);
    ((StringBuilder)localObject).append("/Tencent/QQ_Images/");
    ((StringBuilder)localObject).append(Calendar.getInstance().getTime());
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    if (FileUtils.saveBitmapToFile(jdField_a_of_type_AndroidGraphicsBitmap, (String)localObject))
    {
      QLog.d("ShareImageUtils", 1, "save to sdcard success");
      ImageUtil.a(BaseApplicationImpl.getContext(), (String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131694913));
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
      ThreadManager.getUIHandler().post(new ShareImageUtils.3((String)localObject));
      return;
    }
    QLog.d("ShareImageUtils", 1, "save to sdcard fail");
    ThreadManager.getUIHandler().post(new ShareImageUtils.4());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils
 * JD-Core Version:    0.7.0.1
 */