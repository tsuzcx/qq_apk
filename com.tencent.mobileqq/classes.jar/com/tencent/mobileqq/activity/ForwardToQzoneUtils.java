package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;

public class ForwardToQzoneUtils
{
  public static void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    localIntent.addFlags(131072);
    localIntent.setData(Uri.parse("mqqapi://qzone/to_friend_feeds"));
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Intent paramIntent, String paramString, boolean paramBoolean)
  {
    if ("msg_tab_camera".equals(paramString))
    {
      if (paramIntent == null) {
        return;
      }
      QZoneHelper.forwardToWriteMood(paramBaseActivity, paramQQAppInterface, paramIntent, 20005, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardToQzoneUtils
 * JD-Core Version:    0.7.0.1
 */