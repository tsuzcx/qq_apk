package com.tencent.biz.qqstory.newshare.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
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
import cooperation.qzone.QZoneShareManager;
import java.net.URLEncoder;
import java.util.ArrayList;

public class StoryBasicShareUtils
{
  private static void a(Context paramContext, ShareCopyLinkData paramShareCopyLinkData, StoryShareCallback paramStoryShareCallback)
  {
    try
    {
      ClipboardUtil.a(paramContext, paramShareCopyLinkData.a);
      if (paramStoryShareCallback == null) {
        break label31;
      }
      paramStoryShareCallback.a(paramShareCopyLinkData);
      return;
    }
    catch (Throwable paramContext)
    {
      label20:
      label31:
      break label20;
    }
    if (paramStoryShareCallback != null) {
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
      a(paramContext, paramContext.a, paramStoryShareCallback);
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
    int i = paramShareQQData.b;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        ShareMsgHelper.a(paramContext, 1001, 1, "web_share", "", paramShareQQData.a, paramShareQQData.k, paramShareQQData.l, paramShareQQData.jdField_d_of_type_JavaLangString, paramShareQQData.h, "web", null, null, null, "plugin", paramShareQQData.g, null, null, null, paramShareQQData.f, null, null, 29782, null, -1L);
        return;
      }
      if (ShareMsgHelper.a(paramContext, 29, paramShareQQData.jdField_d_of_type_Int, "web_share", paramShareQQData.n, paramShareQQData.a, paramShareQQData.k, paramShareQQData.l, paramShareQQData.jdField_d_of_type_JavaLangString, paramShareQQData.a, "plugin", null, paramShareQQData.h, paramShareQQData.h, "plugin", null, paramShareQQData.g, paramShareQQData.g, null, paramShareQQData.f, null, paramShareQQData.m, true))
      {
        paramStoryShareCallback.a(paramShareQQData);
        return;
      }
      paramStoryShareCallback.b(paramShareQQData);
      return;
    }
    paramStoryShareCallback = new MessageForQQStory();
    paramStoryShareCallback.authorName = paramShareQQData.i;
    paramStoryShareCallback.brief = paramShareQQData.jdField_d_of_type_JavaLangString;
    paramStoryShareCallback.briefBgColor = paramShareQQData.jdField_c_of_type_Int;
    paramStoryShareCallback.coverImgUrl = paramShareQQData.a;
    paramStoryShareCallback.logoImgUrl = paramShareQQData.jdField_c_of_type_JavaLangString;
    paramStoryShareCallback.msgAction = paramShareQQData.h;
    paramStoryShareCallback.srcAction = paramShareQQData.g;
    paramStoryShareCallback.srcName = paramShareQQData.f;
    paramStoryShareCallback.type = paramShareQQData.jdField_e_of_type_Int;
    paramStoryShareCallback.mVid = paramShareQQData.jdField_e_of_type_JavaLangString;
    paramStoryShareCallback.storyTitle = paramShareQQData.o;
    paramStoryShareCallback.storyBrief = paramShareQQData.p;
    TroopShareUtility.a((Activity)paramContext, paramStoryShareCallback, 29782);
  }
  
  private static void a(Context paramContext, ShareQZoneData paramShareQZoneData, StoryShareCallback paramStoryShareCallback)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Bundle localBundle = new Bundle();
    if (TextUtils.isEmpty(paramShareQZoneData.jdField_c_of_type_JavaLangString)) {
      localObject = paramShareQZoneData.jdField_e_of_type_JavaLangString;
    } else {
      localObject = paramShareQZoneData.jdField_c_of_type_JavaLangString;
    }
    localBundle.putString("title", (String)localObject);
    if (TextUtils.isEmpty(paramShareQZoneData.jdField_d_of_type_JavaLangString)) {
      localObject = paramShareQZoneData.jdField_e_of_type_JavaLangString;
    } else {
      localObject = paramShareQZoneData.jdField_d_of_type_JavaLangString;
    }
    localBundle.putString("desc", (String)localObject);
    localBundle.putString("detail_url", paramShareQZoneData.jdField_e_of_type_JavaLangString);
    Object localObject = new ArrayList(1);
    ((ArrayList)localObject).add(paramShareQZoneData.a);
    localBundle.putStringArrayList("image_url", (ArrayList)localObject);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putInt("iUrlInfoFrm", 0);
    if (QZoneShareManager.jumpToQzoneShare(localQQAppInterface, paramContext, localBundle, null))
    {
      if (paramStoryShareCallback != null) {
        paramStoryShareCallback.a(paramShareQZoneData);
      }
    }
    else if (paramStoryShareCallback != null) {
      paramStoryShareCallback.b(paramShareQZoneData);
    }
  }
  
  private static void a(Context paramContext, ShareSinaData paramShareSinaData, StoryShareCallback paramStoryShareCallback)
  {
    Object localObject1 = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        ThreadManager.executeOnSubThread(new StoryBasicShareUtils.2(((PackageManager)localObject1).getApplicationInfo("com.sina.weibo", 8192), paramShareSinaData, paramContext, paramStoryShareCallback));
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        continue;
      }
      try
      {
        localObject1 = URLEncoder.encode(paramShareSinaData.a, "UTF-8");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("https://v.t.sina.com.cn/share/share.php?");
        ((StringBuilder)localObject2).append("mTitle=");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = URLEncoder.encode(paramShareSinaData.jdField_c_of_type_JavaLangString, "UTF-8");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("&url=");
        localStringBuilder.append((String)localObject2);
        localObject2 = localStringBuilder.toString();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramShareSinaData.jdField_e_of_type_JavaLangString))
        {
          localObject1 = URLEncoder.encode(paramShareSinaData.jdField_e_of_type_JavaLangString, "UTF-8");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("&pic=");
          localStringBuilder.append((String)localObject1);
          localObject1 = localStringBuilder.toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&_wv=3");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        paramContext.startActivity((Intent)localObject2);
        if (paramStoryShareCallback != null)
        {
          paramStoryShareCallback.a(paramShareSinaData);
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        if (paramStoryShareCallback != null) {
          paramStoryShareCallback.b(paramShareSinaData);
        }
      }
    }
  }
  
  private static void a(ShareWeChatData paramShareWeChatData, boolean paramBoolean, StoryShareCallback paramStoryShareCallback)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils
 * JD-Core Version:    0.7.0.1
 */