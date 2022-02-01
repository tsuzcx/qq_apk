package com.tencent.biz.qqstory.newshare.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.ClipboardUtil;
import com.tencent.biz.qqstory.newshare.callback.StoryShareCallback;
import com.tencent.biz.qqstory.newshare.model.ShareCopyLinkData;
import com.tencent.biz.qqstory.newshare.model.ShareData;
import com.tencent.biz.qqstory.newshare.model.ShareQQData;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;
import com.tencent.biz.qqstory.newshare.model.ShareSinaData;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import cooperation.qzone.QZoneShareManager;
import java.net.URLEncoder;
import java.util.ArrayList;

public class StoryBasicShareUtils
{
  private static void a(Context paramContext, ShareCopyLinkData paramShareCopyLinkData, StoryShareCallback paramStoryShareCallback)
  {
    try
    {
      ClipboardUtil.a(paramContext, paramShareCopyLinkData.jdField_a_of_type_JavaLangString);
      if (paramStoryShareCallback != null) {
        paramStoryShareCallback.a(paramShareCopyLinkData);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (paramStoryShareCallback == null) {}
      paramStoryShareCallback.b(paramShareCopyLinkData);
    }
  }
  
  public static void a(Context paramContext, ShareData paramShareData, StoryShareCallback paramStoryShareCallback)
  {
    SLog.b("StoryBasicShareUtils", "share() data = %s", paramShareData.toString());
    if ((paramShareData instanceof ShareQQData))
    {
      a(paramContext, (ShareQQData)paramShareData, paramStoryShareCallback);
      return;
    }
    if ((paramShareData instanceof ShareCopyLinkData))
    {
      a(paramContext, (ShareCopyLinkData)paramShareData, paramStoryShareCallback);
      return;
    }
    if ((paramShareData instanceof ShareQZoneData))
    {
      a(paramContext, (ShareQZoneData)paramShareData, paramStoryShareCallback);
      return;
    }
    if ((paramShareData instanceof ShareWeChatData))
    {
      paramContext = (ShareWeChatData)paramShareData;
      a(paramContext, paramContext.jdField_a_of_type_Boolean, paramStoryShareCallback);
      return;
    }
    if ((paramShareData instanceof ShareSinaData))
    {
      a(paramContext, (ShareSinaData)paramShareData, paramStoryShareCallback);
      return;
    }
    paramStoryShareCallback.a(paramShareData);
  }
  
  private static void a(Context paramContext, ShareQQData paramShareQQData, StoryShareCallback paramStoryShareCallback)
  {
    switch (paramShareQQData.b)
    {
    default: 
      return;
    case 0: 
      paramStoryShareCallback = new MessageForQQStory();
      paramStoryShareCallback.authorName = paramShareQQData.i;
      paramStoryShareCallback.brief = paramShareQQData.jdField_d_of_type_JavaLangString;
      paramStoryShareCallback.briefBgColor = paramShareQQData.jdField_c_of_type_Int;
      paramStoryShareCallback.coverImgUrl = paramShareQQData.jdField_a_of_type_JavaLangString;
      paramStoryShareCallback.logoImgUrl = paramShareQQData.jdField_c_of_type_JavaLangString;
      paramStoryShareCallback.msgAction = paramShareQQData.h;
      paramStoryShareCallback.srcAction = paramShareQQData.g;
      paramStoryShareCallback.srcName = paramShareQQData.f;
      paramStoryShareCallback.type = paramShareQQData.jdField_e_of_type_Int;
      paramStoryShareCallback.mVid = paramShareQQData.jdField_e_of_type_JavaLangString;
      paramStoryShareCallback.storyTitle = paramShareQQData.o;
      paramStoryShareCallback.storyBrief = paramShareQQData.p;
      TroopShareUtility.a((Activity)paramContext, paramStoryShareCallback, 29782);
      return;
    case 1: 
      if (ShareMsgHelper.a(paramContext, 29, paramShareQQData.jdField_d_of_type_Int, "web_share", paramShareQQData.n, paramShareQQData.jdField_a_of_type_JavaLangString, paramShareQQData.k, paramShareQQData.l, paramShareQQData.jdField_d_of_type_JavaLangString, paramShareQQData.jdField_a_of_type_JavaLangString, "plugin", null, paramShareQQData.h, paramShareQQData.h, "plugin", null, paramShareQQData.g, paramShareQQData.g, null, paramShareQQData.f, null, paramShareQQData.m, true))
      {
        paramStoryShareCallback.a(paramShareQQData);
        return;
      }
      paramStoryShareCallback.b(paramShareQQData);
      return;
    }
    ShareMsgHelper.a(paramContext, 1001, 1, "web_share", "", paramShareQQData.jdField_a_of_type_JavaLangString, paramShareQQData.k, paramShareQQData.l, paramShareQQData.jdField_d_of_type_JavaLangString, paramShareQQData.h, "web", null, null, null, "plugin", paramShareQQData.g, null, null, null, paramShareQQData.f, null, null, 29782, null, -1L);
  }
  
  private static void a(Context paramContext, ShareQZoneData paramShareQZoneData, StoryShareCallback paramStoryShareCallback)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    Object localObject;
    if (TextUtils.isEmpty(paramShareQZoneData.jdField_c_of_type_JavaLangString))
    {
      localObject = paramShareQZoneData.jdField_e_of_type_JavaLangString;
      localBundle.putString("title", (String)localObject);
      if (!TextUtils.isEmpty(paramShareQZoneData.jdField_d_of_type_JavaLangString)) {
        break label151;
      }
      localObject = paramShareQZoneData.jdField_e_of_type_JavaLangString;
      label58:
      localBundle.putString("desc", (String)localObject);
      localBundle.putString("detail_url", paramShareQZoneData.jdField_e_of_type_JavaLangString);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramShareQZoneData.jdField_a_of_type_JavaLangString);
      localBundle.putStringArrayList("image_url", (ArrayList)localObject);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 0);
      if (!QZoneShareManager.jumpToQzoneShare(localQQAppInterface, paramContext, localBundle, null)) {
        break label159;
      }
      if (paramStoryShareCallback != null) {
        paramStoryShareCallback.a(paramShareQZoneData);
      }
    }
    label151:
    label159:
    while (paramStoryShareCallback == null)
    {
      return;
      localObject = paramShareQZoneData.jdField_c_of_type_JavaLangString;
      break;
      localObject = paramShareQZoneData.jdField_d_of_type_JavaLangString;
      break label58;
    }
    paramStoryShareCallback.b(paramShareQZoneData);
  }
  
  private static void a(Context paramContext, ShareSinaData paramShareSinaData, StoryShareCallback paramStoryShareCallback)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(localPackageManager.getApplicationInfo("com.sina.weibo", 8192), paramShareSinaData, paramContext, paramStoryShareCallback));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      do
      {
        try
        {
          do
          {
            Object localObject1 = URLEncoder.encode(paramShareSinaData.jdField_a_of_type_JavaLangString, "UTF-8");
            localObject1 = "https://v.t.sina.com.cn/share/share.php?" + "mTitle=" + (String)localObject1;
            Object localObject2 = URLEncoder.encode(paramShareSinaData.jdField_c_of_type_JavaLangString, "UTF-8");
            localObject2 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramShareSinaData.jdField_e_of_type_JavaLangString))
            {
              localObject1 = URLEncoder.encode(paramShareSinaData.jdField_e_of_type_JavaLangString, "UTF-8");
              localObject1 = (String)localObject2 + "&pic=" + (String)localObject1;
            }
            localObject1 = (String)localObject1 + "&_wv=3";
            localObject2 = new Intent(paramContext, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            paramContext.startActivity((Intent)localObject2);
          } while (paramStoryShareCallback == null);
          paramStoryShareCallback.a(paramShareSinaData);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      } while (paramStoryShareCallback == null);
      paramStoryShareCallback.b(paramShareSinaData);
    }
  }
  
  private static void a(ShareWeChatData paramShareWeChatData, boolean paramBoolean, StoryShareCallback paramStoryShareCallback)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    paramStoryShareCallback = new StoryBasicShareUtils.1(str1, paramStoryShareCallback, paramShareWeChatData);
    WXShareHelper.a().a(paramStoryShareCallback);
    paramStoryShareCallback = WXShareHelper.a();
    String str2 = paramShareWeChatData.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = paramShareWeChatData.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = paramShareWeChatData.jdField_c_of_type_JavaLangString;
    paramShareWeChatData = paramShareWeChatData.jdField_d_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramStoryShareCallback.b(str1, str2, localBitmap, str3, paramShareWeChatData, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils
 * JD-Core Version:    0.7.0.1
 */