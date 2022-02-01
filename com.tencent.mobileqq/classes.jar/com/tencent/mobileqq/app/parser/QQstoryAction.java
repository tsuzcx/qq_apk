package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryHomeJumpHelper;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class QQstoryAction
  extends JumpAction
{
  private QQAppInterface a;
  
  public QQstoryAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static int a(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("sharefromtype");
    if (paramMap != null) {}
    try
    {
      int i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label23:
      StringBuilder localStringBuilder;
      break label23;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("makeStoryContentPageIntent, NumberFormatException, shareFromStr:");
      localStringBuilder.append(paramMap);
      QLog.e("QQstoryAction", 2, localStringBuilder.toString());
    }
    return 0;
  }
  
  public static int a(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    if (paramMap != null) {}
    try
    {
      int i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label22:
      StringBuilder localStringBuilder;
      break label22;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIntAttribute, NumberFormatException, key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" strVal:");
      localStringBuilder.append(paramMap);
      QLog.e("QQstoryAction", 2, localStringBuilder.toString());
    }
    return paramInt;
  }
  
  private Intent a()
  {
    ((QQStoryActivityManager)SuperManager.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  @NotNull
  private Intent a(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean) {
      StoryReportor.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("capture_mode");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tab_id");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("category_id");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("item_id");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("album_id");
    str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("dispatch_event");
    paramIntent.putExtra("cameraDirection", 2);
    if (!TextUtils.isEmpty(str6)) {
      paramIntent.putExtra("web_dispatch_event", str6);
    }
    try
    {
      if (!TextUtils.isEmpty(str5)) {
        paramIntent.putExtra("key_finish_jump_to_page", Integer.valueOf(str5));
      }
      if (!TextUtils.isEmpty(str2)) {
        paramIntent.putExtra("capture_intent_mode", Integer.valueOf(str2));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramIntent.putExtra("firsttab", Integer.valueOf((String)localObject));
      }
      if (!TextUtils.isEmpty(str3)) {
        paramIntent.putExtra("secondtab", Integer.valueOf(str3));
      }
      paramIntent.putExtra("itemid", str4);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start story publish, NumberFormatException, attrs=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilHashMap.toString());
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(localNumberFormatException);
      QLog.e("Q.qqstory.publish.QQstoryAction", 2, ((StringBuilder)localObject).toString());
    }
    paramIntent.putExtra("from_type", str1);
    paramIntent.putExtra("action", 1);
    return paramIntent;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      if (i != 15)
      {
        if (i != 45)
        {
          if (i != 3001)
          {
            switch (i)
            {
            default: 
              return paramString;
            case 22: 
              return "6";
            case 21: 
              return "2";
            }
            return "3";
          }
          return "5";
        }
        return "7";
      }
      str = "4";
      return str;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return paramString;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1)) {
      return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    }
    return paramString2;
  }
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (paramString1.equals(paramString2)) {
      StoryReportor.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramString3 });
    }
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "JUMP_ACTION_EMPTY_FEED_ID";
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 7;
    }
    StoryPlayerLauncher.b(paramActivity, paramString3, paramString1, i);
  }
  
  private static void a(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("bannerID");
    if (!TextUtils.isEmpty(paramHashMap)) {
      StoryPlayerLauncher.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramHashMap), 102).a());
    }
  }
  
  private static boolean a(Activity paramActivity, HashMap<String, String> paramHashMap, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    String str = (String)paramHashMap.get("collection_id");
    paramHashMap = (String)paramHashMap.get("time_zone");
    int i;
    if (!TextUtils.isEmpty(paramHashMap)) {
      i = Integer.valueOf(paramHashMap).intValue();
    } else {
      i = -1;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      StoryPlayerLauncher.a(paramActivity, paramString2, VideoCollectionEntry.getCollectionKey(1, str, paramString2), i, paramInt1, paramString3, paramInt2, null);
      return true;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      StoryPlayerLauncher.a(paramActivity, paramString1, VideoCollectionEntry.getCollectionKey(1, str, paramString1), i, paramInt1, paramString3, paramInt2, null);
      return true;
    }
    return false;
  }
  
  private static boolean a(Activity paramActivity, HashMap<String, String> paramHashMap, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    String str = (String)paramHashMap.get("collection_id");
    if (TextUtils.isEmpty(str))
    {
      if (paramInt1 == 0) {
        paramInt1 = 30;
      }
      StoryPlayerLauncher.a(paramActivity, paramString3, paramString4, paramInt1);
      return true;
    }
    paramHashMap = (String)paramHashMap.get("time_zone");
    int i;
    if (!TextUtils.isEmpty(paramHashMap)) {
      i = Integer.valueOf(paramHashMap).intValue();
    } else {
      i = -1;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      StoryPlayerLauncher.a(paramActivity, paramString2, VideoCollectionEntry.getCollectionKey(1, str, paramString2), i, paramInt1, paramString4, paramInt2, null);
      return true;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      StoryPlayerLauncher.a(paramActivity, paramString1, VideoCollectionEntry.getCollectionKey(1, str, paramString1), i, paramInt1, paramString4, paramInt2, null);
      return true;
    }
    return false;
  }
  
  private static boolean a(Activity paramActivity, HashMap<String, String> paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean)
    {
      paramString3 = (String)paramHashMap.get("et");
      paramHashMap = (String)paramHashMap.get("time_zone");
      if (!TextUtils.isEmpty(paramHashMap)) {
        Integer.valueOf(paramHashMap).intValue();
      }
      if (!TextUtils.isEmpty(paramString2)) {
        StoryPlayerLauncher.a(paramActivity, paramString2, paramString5, paramInt2, paramInt1, 0, null);
      } else if (!TextUtils.isEmpty(paramString1)) {
        StoryPlayerLauncher.a(paramActivity, paramString1, paramString5, paramInt2, paramInt1, 0, null);
      } else {
        return true;
      }
    }
    else if ((!TextUtils.isEmpty(paramString4)) && (paramString4.equals(String.valueOf(1))))
    {
      if (paramInt1 == 0) {
        paramInt1 = 57;
      }
      StoryPlayerLauncher.b(paramActivity, paramString3, paramString5, paramInt1);
    }
    else if ("onedaylist".equals(paramString4))
    {
      StoryPlayerLauncher.a(paramActivity, paramString2, paramString5, paramInt2, paramInt1, 0, null);
    }
    else
    {
      if (paramInt1 == 0) {
        paramInt1 = 17;
      }
      StoryPlayerLauncher.b(paramActivity, paramString3, paramString5, paramInt1);
    }
    return false;
  }
  
  private static boolean a(Activity paramActivity, HashMap<String, String> paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramString1.equals(paramString4)) {
      StoryReportor.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramString5 });
    }
    paramString1 = (String)paramHashMap.get("et");
    paramHashMap = (String)paramHashMap.get("time_zone");
    if (!TextUtils.isEmpty(paramHashMap)) {
      Integer.valueOf(paramHashMap).intValue();
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      StoryPlayerLauncher.a(paramActivity, paramString3, paramString6, 1, 109, 1, null);
      return true;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      StoryPlayerLauncher.a(paramActivity, paramString2, paramString6, 1, 109, 1, null);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramQQAppInterface = (String)paramHashMap.get("uin");
    String str1 = (String)paramHashMap.get("usertype");
    String str2 = (String)paramHashMap.get("unionid");
    paramHashMap = (String)paramHashMap.get("fromId");
    if ((!TextUtils.isEmpty(str1)) && ((!TextUtils.isEmpty(paramQQAppInterface)) || (!TextUtils.isEmpty(str2)))) {
      if (TextUtils.isEmpty(paramHashMap)) {
        return false;
      }
    }
    try
    {
      if (!TextUtils.isEmpty(str2)) {
        StoryApi.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        StoryApi.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
      }
      return true;
    }
    catch (Exception paramQQAppInterface) {}
    return false;
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str5 = (String)paramHashMap.get("videoOwnerUin");
    String str6 = (String)paramHashMap.get("unionid");
    String str3 = (String)paramHashMap.get("fromId");
    String str2 = (String)paramHashMap.get("videoId");
    String str1 = (String)paramHashMap.get("type");
    str1 = (String)paramHashMap.get("videoList");
    int i = a(paramHashMap);
    String str4 = (String)paramHashMap.get("feedid");
    int m = a(paramHashMap, "ptype", 0);
    int n = "0".equals(paramHashMap.get("identify")) ^ true;
    str1 = str2;
    if (str2 == null) {
      str1 = (String)paramHashMap.get("videoid");
    }
    str2 = str3;
    if (str3 == null) {
      str2 = (String)paramHashMap.get("fromid");
    }
    boolean bool = TextUtils.isEmpty(paramString);
    int k = 7;
    int j = m;
    if (!bool)
    {
      j = m;
      if (m == 0) {
        j = 7;
      }
    }
    switch (j)
    {
    default: 
      paramQQAppInterface = str4;
      if (str4 == null) {
        paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
      }
      break;
    case 10: 
      a(paramActivity, paramHashMap);
      return true;
    case 9: 
      j = i;
      if (i == 0) {
        j = 96;
      }
      StoryPlayerLauncher.a(paramActivity, str4, j);
      return true;
    case 8: 
      j = i;
      if (i == 0) {
        j = 90;
      }
      StoryPlayerLauncher.b(paramActivity, str1, str4, j);
      return true;
    case 7: 
      j = i;
      if (i == 0) {
        j = 19;
      }
      StoryPlayerLauncher.b(paramActivity, str1, str4, j);
      return true;
    case 6: 
      j = i;
      if (i == 0) {
        j = 57;
      }
      StoryPlayerLauncher.b(paramActivity, str1, str4, j);
      return true;
    case 5: 
      StoryPlayerLauncher.a(paramActivity, str6, str4, n, i, 0, null);
      return true;
    case 4: 
      return a(paramActivity, paramHashMap, str5, str6, i, str4, n);
    case 3: 
      j = i;
      if (i == 0) {
        j = 30;
      }
      StoryPlayerLauncher.a(paramActivity, str1, str4, j);
      return true;
    case 2: 
      return a(paramActivity, paramHashMap, "17", str5, str6, str2, str1, str4);
    case 1: 
      a(paramActivity, "17", str2, str1, i, str4);
      return true;
    case 0: 
      return b(paramQQAppInterface, paramActivity, paramHashMap, paramString);
    }
    if (i == 0) {
      i = k;
    }
    StoryPlayerLauncher.b(paramActivity, str1, paramQQAppInterface, i);
    return true;
  }
  
  private boolean a(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    a(paramMap);
    if (str5 != null) {
      str5.equals("0");
    }
    if (TextUtils.isEmpty(str4)) {
      if (!TextUtils.isEmpty(str2)) {
        if (TextUtils.isEmpty(str3)) {
          return false;
        }
      }
    }
    try
    {
      if (Integer.parseInt(str2) == 1)
      {
        if (TextUtils.isEmpty(str1)) {
          return false;
        }
        StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 23, str3);
      }
      return true;
    }
    catch (NumberFormatException paramMap)
    {
      label145:
      break label145;
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("gotoStoryPlayVideoPage, NumberFormatException, userId:");
      paramMap.append(str1);
      paramMap.append(", userType:");
      paramMap.append(str2);
      QLog.d("QQstoryAction", 2, paramMap.toString());
    }
    return false;
    return true;
  }
  
  private Intent b(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean) {
      StoryReportor.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    return c(paramIntent);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("unionid");
    paramQQAppInterface = (String)paramHashMap.get("fromuid");
    int i;
    try
    {
      i = Integer.valueOf((String)paramHashMap.get("fromId")).intValue();
    }
    catch (NumberFormatException paramHashMap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoStoryShareGroupCard from id is error:");
      localStringBuilder.append(paramHashMap);
      QLog.e("QQstoryAction", 2, localStringBuilder.toString());
      i = -1;
    }
    paramHashMap = QQStoryShareGroupProfileActivity.a(paramActivity, 2, str, null, i, 0);
    paramHashMap.putExtra("extra_share_from_user_uid", paramQQAppInterface);
    paramActivity.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str4 = (String)paramHashMap.get("videoOwnerUin");
    String str5 = (String)paramHashMap.get("unionid");
    String str3 = (String)paramHashMap.get("fromId");
    String str1 = (String)paramHashMap.get("videoId");
    String str6 = (String)paramHashMap.get("type");
    paramQQAppInterface = (String)paramHashMap.get("videoList");
    int i = a(paramHashMap);
    String str2 = (String)paramHashMap.get("feedid");
    a(paramHashMap, "ptype", 0);
    paramQQAppInterface = str1;
    if (str1 == null) {
      paramQQAppInterface = (String)paramHashMap.get("videoid");
    }
    str1 = str3;
    if (str3 == null) {
      str1 = (String)paramHashMap.get("fromid");
    }
    boolean bool1;
    if ((str6 != null) && (str6.equals("mylist"))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int j;
    if ((str6 != null) && (str6.equals("myonedaylist"))) {
      j = 1;
    } else {
      j = 0;
    }
    int k = "0".equals(paramHashMap.get("identify")) ^ true;
    for (;;)
    {
      try
      {
        boolean bool2 = "17".equals(str1);
        if (bool2) {
          if (bool1) {
            StoryReportor.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          } else {
            StoryReportor.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
        }
        if (j != 0) {
          return a(paramActivity, paramHashMap, str4, str5, paramQQAppInterface, i, str2, k);
        }
        if ("17".equals(str1))
        {
          if (a(paramActivity, paramHashMap, str4, str5, paramQQAppInterface, str6, i, str2, bool1, k)) {
            return false;
          }
        }
        else
        {
          if (TextUtils.isEmpty(paramString)) {
            break label455;
          }
          j = i;
          if (i == 0) {
            j = 19;
          }
          StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, str2, j);
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramActivity = new StringBuilder();
        paramActivity.append("gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:");
        paramActivity.append(str4);
        paramActivity.append(",e:");
        paramActivity.append(QLog.getStackTraceString(paramQQAppInterface));
        QLog.d("QQstoryAction", 2, paramActivity.toString());
        return false;
      }
      StoryPlayerLauncher.b(paramActivity, paramQQAppInterface, paramHashMap, j);
      return true;
      label455:
      paramHashMap = str2;
      if (str2 == null) {
        paramHashMap = "JUMP_ACTION_EMPTY_FEED_ID";
      }
      j = i;
      if (i == 0) {
        j = 7;
      }
    }
  }
  
  private Intent c(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("topicId=");
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid"));
      localObject = ((StringBuilder)localObject).toString();
      StoryReportor.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", localObject });
    }
    return b(paramIntent);
  }
  
  private boolean c()
  {
    boolean bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str))
    {
      StoryShareEncryptHelper.a(this.jdField_a_of_type_AndroidContentContext, str, new QQstoryAction.1(this), null);
    }
    else if (TextUtils.equals(this.c, "publish"))
    {
      j();
    }
    else
    {
      if (bool)
      {
        this.c = "open";
        StoryShareEncryptHelper.a(this.jdField_a_of_type_JavaUtilHashMap);
      }
      j();
    }
    return true;
  }
  
  private Intent d(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
      String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
      Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("unionId=");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append("&userId=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&userType=");
        ((StringBuilder)localObject2).append(str1);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("storyId=");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      StoryReportor.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", localObject1 });
    }
    return d(paramIntent);
  }
  
  private Intent e(Intent paramIntent)
  {
    boolean bool = TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")) ^ true;
    SLog.a("QQstoryAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.c, Boolean.valueOf(bool));
    SLog.a("QQstoryAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.jdField_a_of_type_JavaUtilHashMap));
    if ("open".equals(this.c)) {
      return f(paramIntent, bool);
    }
    if ((!"openVideo".equals(this.c)) && (!"openvideo".equals(this.c)))
    {
      if ("opencontent".equals(this.c)) {
        return d(paramIntent, bool);
      }
      if ("opentopic".equals(this.c)) {
        return c(paramIntent, bool);
      }
      if ("opendiscovery".equals(this.c)) {
        return b(paramIntent, bool);
      }
      if ("publish".equals(this.c)) {
        return a(paramIntent, bool);
      }
      if ("infoCard".equals(this.c)) {
        return i(paramIntent);
      }
      if ("sharegroupcard".equals(this.c)) {
        return h(paramIntent);
      }
      if ("openTag".equals(this.c)) {
        return g(paramIntent);
      }
      if ("openSquare".equals(this.c)) {
        return f(paramIntent);
      }
      return null;
    }
    return e(paramIntent, bool);
  }
  
  private Intent e(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("userId=");
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin"));
      ((StringBuilder)localObject).append("&vid=");
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId"));
      localObject = ((StringBuilder)localObject).toString();
      StoryReportor.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", localObject });
    }
    return a(paramIntent);
  }
  
  @NotNull
  private Intent f(Intent paramIntent)
  {
    paramIntent.putExtra("action", 15);
    return paramIntent;
  }
  
  @NotNull
  private Intent f(Intent paramIntent, boolean paramBoolean)
  {
    paramIntent.putExtra("redid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("redid"));
    paramIntent.putExtra("lebaVersion", (String)this.jdField_a_of_type_JavaUtilHashMap.get("lebaVersion"));
    if (paramBoolean) {
      StoryReportor.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    return paramIntent;
  }
  
  @NotNull
  private Intent g(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_id");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_type");
    paramIntent.putExtra("action", 14);
    paramIntent.putExtra("tag_id", str1);
    paramIntent.putExtra("tag_type", str2);
    return paramIntent;
  }
  
  @Nullable
  private Intent h(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromuid");
    try
    {
      paramIntent.putExtra("union_id", str1);
      paramIntent.putExtra("extra_share_from_uid", str3);
      paramIntent.putExtra("source", Integer.valueOf(str2));
      paramIntent.putExtra("action", 13);
      return paramIntent;
    }
    catch (NumberFormatException paramIntent)
    {
      label85:
      break label85;
    }
    return null;
  }
  
  @Nullable
  private Intent i(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    if ((!TextUtils.isEmpty(str2)) && ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str4)))) {
      if (TextUtils.isEmpty(str3)) {
        return null;
      }
    }
    try
    {
      paramIntent.putExtra("union_id", str4);
      paramIntent.putExtra("qq_number", Long.valueOf(str1));
      paramIntent.putExtra("source", Integer.valueOf(str3));
      paramIntent.putExtra("action", 11);
      return paramIntent;
    }
    catch (NumberFormatException paramIntent) {}
    return null;
    return null;
  }
  
  private boolean j()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new QQstoryAction.2(this));
      return false;
    }
    if ((((MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a) && (!"open".equals(this.c)) && (!"openTag".equals(this.c)) && (!"openSquare".equals(this.c)) && (!"publish".equals(this.c))) {
      return l();
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      MsgTabStoryNodeConfigManager localMsgTabStoryNodeConfigManager = (MsgTabStoryNodeConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
      str1 = str2;
      if (localMsgTabStoryNodeConfigManager != null)
      {
        str1 = str2;
        if (!localMsgTabStoryNodeConfigManager.a)
        {
          str1 = String.valueOf(0);
          this.jdField_a_of_type_JavaUtilHashMap.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return k();
    }
    if ("open".equals(this.c)) {
      return k();
    }
    return l();
  }
  
  private boolean k()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().a)
    {
      SLog.b("QQstoryAction", "startStoryMainActivity, isNowTabShow==true");
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", FrameControllerUtil.f);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.setFlags(335544320);
      localIntent = e(localIntent);
      if ((localIntent != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Error: context is not instanceof Activity, context is: ");
        localStringBuilder.append(String.valueOf(this.jdField_a_of_type_AndroidContentContext));
        SLog.e("QQstoryAction", localStringBuilder.toString());
      }
      if (localIntent == null) {
        SLog.e("QQstoryAction", "Error: jumpIntent is null");
      }
    }
    else
    {
      SLog.b("QQstoryAction", "startStoryMainActivity, isNowTabShow==false");
      if (((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) && (!BaseApplicationImpl.appMainActivityHasLanuch))
      {
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("tab_index", FrameControllerUtil.a);
        localIntent.setFlags(335544320);
        localIntent.putExtra("jump_to_story", true);
      }
      else
      {
        localIntent = a();
      }
      localIntent = e(localIntent);
      if ((localIntent != null) && (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof BaseApplicationImpl))))
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
    }
    return false;
  }
  
  private boolean l()
  {
    if ("open".equals(this.c))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 8855);
      return true;
    }
    if ("openVideo".equalsIgnoreCase(this.c))
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, null);
      }
      return false;
    }
    if ("opencontent".equals(this.c)) {
      return a(this.jdField_a_of_type_JavaUtilHashMap, false);
    }
    if ("opendiscovery".equals(this.c)) {
      return n();
    }
    if ("opentopic".equals(this.c)) {
      return m();
    }
    if ("infoCard".equals(this.c)) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.c)) {
      return b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new QQStoryHomeJumpHelper((Activity)this.jdField_a_of_type_AndroidContentContext, new QQstoryAction.3(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((QQStoryHomeJumpHelper)localObject).a(i, localIntent);
    }
    return false;
  }
  
  private boolean m()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    a((String)this.jdField_a_of_type_JavaUtilHashMap.get("sharefromtype"));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      return true;
    }
    return false;
  }
  
  private boolean n()
  {
    if (!TextUtils.isEmpty(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      StoryReportor.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      "1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"));
      return true;
    }
    return false;
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra("action", 5);
    paramIntent.putExtra("extra_jump_attrs", this.jdField_a_of_type_JavaUtilHashMap);
    return paramIntent;
  }
  
  public boolean a()
  {
    try
    {
      if ("openNow".equals(this.c)) {
        return b();
      }
      boolean bool = c();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QQstoryAction", 1, localStringBuilder.toString());
      b_("QQstoryAction");
    }
    return false;
  }
  
  public Intent b(Intent paramIntent)
  {
    paramIntent.putExtra("action", 4);
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storysharefrom");
    String str1 = str2;
    try
    {
      if (TextUtils.equals(str4, "qzone")) {
        str1 = URLDecoder.decode(str2, "utf-8");
      }
      paramIntent.putExtra("extra_topic_id", Long.parseLong(str3));
      paramIntent.putExtra("extra_topic_name", str1);
      paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", a(this.jdField_a_of_type_JavaUtilHashMap));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      label132:
      break label132;
    }
    return null;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 != null)
      {
        str1 = ((Intent)localObject1).getStringExtra("big_brother_source_key");
        localObject1 = ((Intent)localObject1).getDataString();
        break label46;
      }
    }
    String str1 = null;
    Object localObject1 = "";
    label46:
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_JavaLangString;
    }
    String str2 = a("roomid", "0");
    String str3 = a("fromid", "");
    String str4 = a("roomtype", "");
    String str5 = a("list_name", "");
    String str6 = a("first_jump_mode", "h5");
    String str7 = a("need_record", "1");
    String str8 = a("is_record", "0");
    String str9 = a("enter_record_if_finish", "1");
    String str10 = a("nowapp_ext", "");
    String str11 = a("nowplugin_ext", "");
    String str12 = a("h5_ext", "");
    String str13 = a("shakespearetime", "");
    String str14 = a("hostloading_percent", "0");
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgurl")) {
      localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("msgurl"));
    } else {
      localObject1 = "";
    }
    String str15 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("coverurl");
    String str16 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extras");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
    localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first");
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("coverurl", str15);
    ((Bundle)localObject3).putString("roomid", str2);
    ((Bundle)localObject3).putString("roomtype", str4);
    ((Bundle)localObject3).putString("extras_from_js", str16);
    ((Bundle)localObject3).putBoolean("can_use_h5_first", true);
    ((Bundle)localObject3).putString("first_jump_mode", str6);
    ((Bundle)localObject3).putString("is_record", str8);
    ((Bundle)localObject3).putString("enter_record_if_finish", str9);
    ((Bundle)localObject3).putString("nowapp_ext", str10);
    ((Bundle)localObject3).putString("nowplugin_ext", str11);
    ((Bundle)localObject3).putString("h5_ext", str12);
    ((Bundle)localObject3).putString("shakespearetime", str13);
    ((Bundle)localObject3).putString("fromid", str3);
    ((Bundle)localObject3).putString("url", (String)localObject1);
    ((Bundle)localObject3).putString("listname", str5);
    ((Bundle)localObject3).putString("mqqScheme", (String)localObject2);
    if (!TextUtils.isEmpty(str1)) {
      ((Bundle)localObject3).putString("big_brother_source_key", str1);
    }
    boolean bool;
    if ((!TextUtils.isEmpty(str7)) && ("0".equals(str7))) {
      bool = false;
    } else {
      bool = true;
    }
    ((Bundle)localObject3).putBoolean("need_record", bool);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topic")) {
      ((Bundle)localObject3).putString("topic", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topic"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("story_ext")) {
      ((Bundle)localObject3).putString("story_ext", (String)this.jdField_a_of_type_JavaUtilHashMap.get("story_ext"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("startsrc")) {
      ((Bundle)localObject3).putString("startsrc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("startsrc"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hostloading_percent")) {
      ((Bundle)localObject3).putInt("hostloading_percent", Integer.valueOf(str14).intValue());
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, "无网络连接请稍后再试", 1).a();
      return false;
    }
    try
    {
      ((IDynamicNowManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject3);
      QLog.i("QQstoryAction", 1, "enter now plugin use shadow");
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQstoryAction", 2, localException.toString());
      }
    }
    return false;
  }
  
  public Intent c(Intent paramIntent)
  {
    paramIntent.putExtra("action", 12);
    try
    {
      paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", a(this.jdField_a_of_type_JavaUtilHashMap));
      paramIntent.putExtra("to_new_version", (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      label67:
      break label67;
    }
    return null;
  }
  
  public Intent d(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("showinfocard");
    int i = a(this.jdField_a_of_type_JavaUtilHashMap);
    boolean bool;
    if ((str5 != null) && (str5.equals("0"))) {
      bool = false;
    } else {
      bool = true;
    }
    if ((!TextUtils.isEmpty(str4)) || ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))) {}
    try
    {
      int j = Integer.parseInt(str2);
      if (j == 1)
      {
        if (TextUtils.isEmpty(str1)) {
          return null;
        }
        paramIntent.putExtra("action", 7);
        paramIntent.putExtra("EXTRA_USER_UIN", str1);
        paramIntent.putExtra("EXTRA_USER_UNION_ID", str3);
        paramIntent.putExtra("extra_is_show_info_card", bool);
        paramIntent.putExtra("extra_share_from_type", i);
        paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
        return paramIntent;
      }
      if (j == 5)
      {
        paramIntent.putExtra("action", 4);
        paramIntent.putExtra("extra_topic_id", Long.parseLong(str1));
        paramIntent.putExtra("extra_topic_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"));
        str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topiccolor");
        if (!TextUtils.isEmpty(str3)) {
          paramIntent.putExtra("extra_topic_color", Integer.parseInt(str3));
        }
        paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
        paramIntent.putExtra("extra_share_from_type", i);
        return paramIntent;
      }
      paramIntent.putExtra("action", 6);
      paramIntent.putExtra("user_type", Integer.parseInt(str2));
      paramIntent.putExtra("user_unionid", str3);
      paramIntent.putExtra("come_from", i);
      paramIntent.putExtra("showTitleBar", false);
      paramIntent.putExtra("showInfoCard", bool);
      return paramIntent;
    }
    catch (NumberFormatException paramIntent)
    {
      label402:
      break label402;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("makeStoryPlayVideoPageIntent, NumberFormatException, userId:");
      paramIntent.append(str1);
      paramIntent.append(", userType:");
      paramIntent.append(str2);
      QLog.d("QQstoryAction", 2, paramIntent.toString());
    }
    return null;
    return null;
    paramIntent.putExtra("action", 6);
    paramIntent.putExtra("story_id", str4);
    paramIntent.putExtra("come_from", i);
    paramIntent.putExtra("showTitleBar", false);
    paramIntent.putExtra("showInfoCard", false);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQstoryAction
 * JD-Core Version:    0.7.0.1
 */