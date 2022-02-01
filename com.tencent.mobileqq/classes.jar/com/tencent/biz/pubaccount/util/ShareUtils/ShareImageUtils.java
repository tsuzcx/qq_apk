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
  private static String a;
  private static Bitmap b;
  private static WXShareHelper.WXShareListener c = new ShareImageUtils.1();
  
  public static void a()
  {
    WXShareHelper.a().a(c);
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("launchFriendPicker path = ");
      ((StringBuilder)localObject).append(a);
      QLog.d("ShareImageUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (a == null)
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
    ((Intent)localObject).setData(Uri.parse(a));
    paramActivity.startActivityForResult((Intent)localObject, 3);
  }
  
  public static void a(Context paramContext)
  {
    if (b == null)
    {
      QLog.e("ShareImageUtils", 1, "bitmap is null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ShareImageUtils.2(paramContext));
  }
  
  public static void a(Bitmap paramBitmap)
  {
    b = paramBitmap;
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "shareToQzone");
    }
    if (a == null)
    {
      QLog.e("ShareImageUtils", 1, "currentPath is null");
      return;
    }
    paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a);
    localBundle.putStringArrayList("images", localArrayList);
    QZoneShareManager.publishToQzone(paramBaseActivity, BaseApplicationImpl.getContext(), localBundle, null, 2);
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  public static void b()
  {
    a = null;
    b = null;
    WXShareHelper.a().b(c);
  }
  
  public static void b(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "ScreenShotShareFragment shareToWXFriend");
    }
    if ((a != null) && (b != null))
    {
      int i;
      if (!WXShareHelper.a().b()) {
        i = 2131918154;
      } else if (!WXShareHelper.a().c()) {
        i = 2131918155;
      } else {
        i = -1;
      }
      if (i != -1)
      {
        QQToast.makeText(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(i), 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
        return;
      }
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).shareImageToWX(a, b, 0, false);
      return;
    }
    QLog.e("ShareImageUtils", 1, "currentPath or bitmap is null");
  }
  
  public static void c(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "shareToFriendCircle");
    }
    if ((a != null) && (b != null))
    {
      int i;
      if (!WXShareHelper.a().b()) {
        i = 2131918154;
      } else if (!WXShareHelper.a().c()) {
        i = 2131918155;
      } else {
        i = -1;
      }
      if (i != -1)
      {
        QQToast.makeText(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(i), 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
        return;
      }
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).shareImageToWX(a, b, 1, false);
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
    if (FileUtils.saveBitmapToFile(b, (String)localObject))
    {
      QLog.d("ShareImageUtils", 1, "save to sdcard success");
      ImageUtil.b(BaseApplicationImpl.getContext(), (String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131892639));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils
 * JD-Core Version:    0.7.0.1
 */