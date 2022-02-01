import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.parser.QQstoryAction.2;
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

public class aovg
  extends aouc
{
  public aovg(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    boolean bool = ((Boolean)((wjl)wjs.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str)) {
      wyt.a(this.jdField_a_of_type_AndroidContentContext, str, new aovh(this), null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.equals(this.c, "publish"))
      {
        D();
      }
      else
      {
        if (bool)
        {
          this.c = "open";
          wyt.a(this.jdField_a_of_type_JavaUtilHashMap);
        }
        D();
      }
    }
  }
  
  private boolean D()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new QQstoryAction.2(this));
      return false;
    }
    if ((((wms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a) && (!"open".equals(this.c)) && (!"openTag".equals(this.c)) && (!"openSquare".equals(this.c)) && (!"publish".equals(this.c))) {
      return F();
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      wms localwms = (wms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
      str1 = str2;
      if (localwms != null)
      {
        str1 = str2;
        if (!localwms.a)
        {
          str1 = String.valueOf(0);
          this.jdField_a_of_type_JavaUtilHashMap.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return E();
    }
    if ("open".equals(this.c)) {
      return E();
    }
    return F();
  }
  
  private boolean E()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().a)
    {
      ykq.b("QQstoryAction", "startStoryMainActivity, isNowTabShow==true");
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.g);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.setFlags(335544320);
      localIntent = e(localIntent);
      if ((localIntent != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ykq.e("QQstoryAction", "Error: context is not instanceof Activity, context is: " + String.valueOf(this.jdField_a_of_type_AndroidContentContext));
      }
      if (localIntent == null) {
        ykq.e("QQstoryAction", "Error: jumpIntent is null");
      }
      return false;
    }
    ykq.b("QQstoryAction", "startStoryMainActivity, isNowTabShow==false");
    if (((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) && (!BaseApplicationImpl.appMainActivityHasLanuch))
    {
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.setFlags(335544320);
      localIntent.putExtra("jump_to_story", true);
    }
    for (;;)
    {
      localIntent = e(localIntent);
      if ((localIntent == null) || ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseApplicationImpl)))) {
        break;
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      localIntent = a();
    }
  }
  
  private boolean F()
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
      return H();
    }
    if ("opentopic".equals(this.c)) {
      return G();
    }
    if ("infoCard".equals(this.c)) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.c)) {
      return b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new xuf((Activity)this.jdField_a_of_type_AndroidContentContext, new aovi(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((xuf)localObject).a(i, localIntent);
    }
    return false;
  }
  
  private boolean G()
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
  
  private boolean H()
  {
    if (!TextUtils.isEmpty(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      ykv.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ("1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"))) {}
      return true;
    }
    return false;
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
      if (!QLog.isColorLevel()) {
        break label59;
      }
      QLog.e("QQstoryAction", 2, "makeStoryContentPageIntent, NumberFormatException, shareFromStr:" + paramMap);
    }
    return 0;
    label59:
    return 0;
  }
  
  public static int a(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = Integer.parseInt(paramMap);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        i = paramInt;
      } while (!QLog.isColorLevel());
      QLog.e("QQstoryAction", 2, "getIntAttribute, NumberFormatException, key:" + paramString + " strVal:" + paramMap);
    }
    return paramInt;
  }
  
  private Intent a()
  {
    ((wjg)wjs.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  @NotNull
  private Intent a(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean) {
      ykv.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    paramIntent.putExtra("story_default_label", (String)this.jdField_a_of_type_JavaUtilHashMap.get("default_label"));
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("capture_mode");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tab_id");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("category_id");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("item_id");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("album_id");
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("dispatch_event");
    paramIntent.putExtra("cameraDirection", 2);
    paramIntent.putExtra("story_game_id", str3);
    paramIntent.putExtra("story_capture_album_id", str6);
    if (!TextUtils.isEmpty(str8)) {
      paramIntent.putExtra("web_dispatch_event", str8);
    }
    try
    {
      if (!TextUtils.isEmpty(str7)) {
        paramIntent.putExtra("key_finish_jump_to_page", Integer.valueOf(str7));
      }
      if (!TextUtils.isEmpty(str2)) {
        paramIntent.putExtra("capture_intent_mode", Integer.valueOf(str2));
      }
      if (!TextUtils.isEmpty(str3)) {
        paramIntent.putExtra("firsttab", Integer.valueOf(str3));
      }
      if (!TextUtils.isEmpty(str4)) {
        paramIntent.putExtra("secondtab", Integer.valueOf(str4));
      }
      paramIntent.putExtra("itemid", str5);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("Q.qqstory.publish.QQstoryAction", 2, "start story publish, NumberFormatException, attrs=" + this.jdField_a_of_type_JavaUtilHashMap.toString() + "\n" + localNumberFormatException);
      }
    }
    paramIntent.putExtra("from_type", str1);
    paramIntent.putExtra("action", 1);
    return paramIntent;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      switch (i)
      {
      default: 
        return paramString;
      case 21: 
        return "2";
      case 20: 
        return "3";
      case 15: 
        return "4";
      case 3001: 
        return "5";
      case 22: 
        return "6";
      }
      return "7";
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
      ykv.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramString3 });
    }
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "JUMP_ACTION_EMPTY_FEED_ID";
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 7;
    }
    xbp.b(paramActivity, paramString3, paramString1, i);
  }
  
  private static void a(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("bannerID");
    if (!TextUtils.isEmpty(paramHashMap)) {
      xbp.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramHashMap), 102).a());
    }
  }
  
  private static boolean a(Activity paramActivity, HashMap<String, String> paramHashMap, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    String str = (String)paramHashMap.get("collection_id");
    paramHashMap = (String)paramHashMap.get("time_zone");
    int i = -1;
    if (!TextUtils.isEmpty(paramHashMap)) {
      i = Integer.valueOf(paramHashMap).intValue();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      xbp.a(paramActivity, paramString2, VideoCollectionEntry.getCollectionKey(1, str, paramString2), i, paramInt1, paramString3, paramInt2, null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.isEmpty(paramString1)) {
        break;
      }
      xbp.a(paramActivity, paramString1, VideoCollectionEntry.getCollectionKey(1, str, paramString1), i, paramInt1, paramString3, paramInt2, null);
    }
    return false;
  }
  
  private static boolean a(Activity paramActivity, HashMap<String, String> paramHashMap, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    String str = (String)paramHashMap.get("collection_id");
    if (TextUtils.isEmpty(str))
    {
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = 30;
      }
      xbp.a(paramActivity, paramString3, paramString4, paramInt2);
    }
    for (;;)
    {
      return true;
      paramHashMap = (String)paramHashMap.get("time_zone");
      int i = -1;
      if (!TextUtils.isEmpty(paramHashMap)) {
        i = Integer.valueOf(paramHashMap).intValue();
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        xbp.a(paramActivity, paramString2, VideoCollectionEntry.getCollectionKey(1, str, paramString2), i, paramInt1, paramString4, paramInt2, null);
      }
      else
      {
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        xbp.a(paramActivity, paramString1, VideoCollectionEntry.getCollectionKey(1, str, paramString1), i, paramInt1, paramString4, paramInt2, null);
      }
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
        xbp.a(paramActivity, paramString2, paramString5, paramInt2, paramInt1, 0, null);
      }
    }
    for (;;)
    {
      return false;
      if (!TextUtils.isEmpty(paramString1))
      {
        xbp.a(paramActivity, paramString1, paramString5, paramInt2, paramInt1, 0, null);
      }
      else
      {
        return true;
        if ((!TextUtils.isEmpty(paramString4)) && (paramString4.equals(String.valueOf(1))))
        {
          paramInt2 = paramInt1;
          if (paramInt1 == 0) {
            paramInt2 = 57;
          }
          xbp.b(paramActivity, paramString3, paramString5, paramInt2);
        }
        else if ("onedaylist".equals(paramString4))
        {
          xbp.a(paramActivity, paramString2, paramString5, paramInt2, paramInt1, 0, null);
        }
        else
        {
          paramInt2 = paramInt1;
          if (paramInt1 == 0) {
            paramInt2 = 17;
          }
          xbp.b(paramActivity, paramString3, paramString5, paramInt2);
        }
      }
    }
  }
  
  private static boolean a(Activity paramActivity, HashMap<String, String> paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (paramString1.equals(paramString4)) {
      ykv.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramString5 });
    }
    paramString1 = (String)paramHashMap.get("et");
    paramHashMap = (String)paramHashMap.get("time_zone");
    if (!TextUtils.isEmpty(paramHashMap)) {
      Integer.valueOf(paramHashMap).intValue();
    }
    if (!TextUtils.isEmpty(paramString3)) {
      xbp.a(paramActivity, paramString3, paramString6, 1, 109, 1, null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
      xbp.a(paramActivity, paramString2, paramString6, 1, 109, 1, null);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramQQAppInterface = (String)paramHashMap.get("uin");
    String str1 = (String)paramHashMap.get("usertype");
    String str2 = (String)paramHashMap.get("unionid");
    paramHashMap = (String)paramHashMap.get("fromId");
    if ((TextUtils.isEmpty(str1)) || ((TextUtils.isEmpty(paramQQAppInterface)) && (TextUtils.isEmpty(str2))) || (TextUtils.isEmpty(paramHashMap))) {
      return false;
    }
    try
    {
      if (!TextUtils.isEmpty(str2)) {
        weg.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        weg.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
    catch (Exception paramQQAppInterface)
    {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str4 = (String)paramHashMap.get("videoOwnerUin");
    String str5 = (String)paramHashMap.get("unionid");
    String str2 = (String)paramHashMap.get("fromId");
    String str1 = (String)paramHashMap.get("videoId");
    String str3 = (String)paramHashMap.get("type");
    str3 = (String)paramHashMap.get("videoList");
    int i = a(paramHashMap);
    str3 = (String)paramHashMap.get("feedid");
    int k = a(paramHashMap, "ptype", 0);
    int j;
    if ("0".equals(paramHashMap.get("identify")))
    {
      j = 0;
      if (str1 != null) {
        break label482;
      }
      str1 = (String)paramHashMap.get("videoid");
    }
    label482:
    for (;;)
    {
      if (str2 == null) {
        str2 = (String)paramHashMap.get("fromid");
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramString)) && (k == 0)) {
          k = 7;
        }
        for (;;)
        {
          switch (k)
          {
          default: 
            paramQQAppInterface = str3;
            if (str3 == null) {
              paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
            }
            j = i;
            if (i == 0) {
              j = 7;
            }
            xbp.b(paramActivity, str1, paramQQAppInterface, j);
            return true;
            j = 1;
            break;
          case 1: 
            a(paramActivity, "17", str2, str1, i, str3);
            return true;
          case 2: 
            return a(paramActivity, paramHashMap, "17", str4, str5, str2, str1, str3);
          case 3: 
            j = i;
            if (i == 0) {
              j = 30;
            }
            xbp.a(paramActivity, str1, str3, j);
            return true;
          case 4: 
            return a(paramActivity, paramHashMap, str4, str5, i, str3, j);
          case 7: 
            j = i;
            if (i == 0) {
              j = 19;
            }
            xbp.b(paramActivity, str1, str3, j);
            return true;
          case 6: 
            j = i;
            if (i == 0) {
              j = 57;
            }
            xbp.b(paramActivity, str1, str3, j);
            return true;
          case 5: 
            xbp.a(paramActivity, str5, str3, j, i, 0, null);
            return true;
          case 8: 
            j = i;
            if (i == 0) {
              j = 90;
            }
            xbp.b(paramActivity, str1, str3, j);
            return true;
          case 9: 
            j = i;
            if (i == 0) {
              j = 96;
            }
            xbp.a(paramActivity, str3, j);
            return true;
          case 10: 
            a(paramActivity, paramHashMap);
            return true;
          case 0: 
            return b(paramQQAppInterface, paramActivity, paramHashMap, paramString);
          }
        }
      }
    }
  }
  
  private boolean a(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    a(paramMap);
    if (((str5 == null) || (!str5.equals("0"))) || (TextUtils.isEmpty(str4)))
    {
      if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
        return false;
      }
      try
      {
        int i = Integer.parseInt(str2);
        if (i == 1)
        {
          if (TextUtils.isEmpty(str1)) {
            return false;
          }
          weg.a(this.jdField_a_of_type_AndroidContentContext, 23, str3);
        }
        for (;;)
        {
          return true;
          if (i != 5) {}
        }
        return true;
      }
      catch (NumberFormatException paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQstoryAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, userId:" + str1 + ", userType:" + str2);
        }
        return false;
      }
    }
  }
  
  private Intent b(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean) {
      ykv.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    return c(paramIntent);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("unionid");
    paramQQAppInterface = (String)paramHashMap.get("fromuid");
    int i = -1;
    try
    {
      int j = Integer.valueOf((String)paramHashMap.get("fromId")).intValue();
      i = j;
    }
    catch (NumberFormatException paramHashMap)
    {
      for (;;)
      {
        QLog.e("QQstoryAction", 2, "gotoStoryShareGroupCard from id is error:" + paramHashMap);
      }
    }
    paramHashMap = QQStoryShareGroupProfileActivity.a(paramActivity, 2, str, null, i, 0);
    paramHashMap.putExtra("extra_share_from_user_uid", paramQQAppInterface);
    paramActivity.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str3 = (String)paramHashMap.get("videoOwnerUin");
    String str4 = (String)paramHashMap.get("unionid");
    String str1 = (String)paramHashMap.get("fromId");
    paramQQAppInterface = (String)paramHashMap.get("videoId");
    String str5 = (String)paramHashMap.get("type");
    String str2 = (String)paramHashMap.get("videoList");
    int i = a(paramHashMap);
    str2 = (String)paramHashMap.get("feedid");
    a(paramHashMap, "ptype", 0);
    label130:
    boolean bool;
    label149:
    int j;
    label168:
    int k;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = (String)paramHashMap.get("videoid");
      if (str1 == null)
      {
        str1 = (String)paramHashMap.get("fromid");
        if ((str5 == null) || (!str5.equals("mylist"))) {
          break label435;
        }
        bool = true;
        if ((str5 == null) || (!str5.equals("myonedaylist"))) {
          break label441;
        }
        j = 1;
        if (!"0".equals(paramHashMap.get("identify"))) {
          break label447;
        }
        k = 0;
        try
        {
          label186:
          if ("17".equals(str1))
          {
            if (!bool) {
              break label261;
            }
            ykv.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          while (j != 0)
          {
            return a(paramActivity, paramHashMap, str3, str4, paramQQAppInterface, i, str2, k);
            label261:
            ykv.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          if (!"17".equals(str1)) {
            break label386;
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQstoryAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:" + str3 + ",e:" + QLog.getStackTraceString(paramQQAppInterface));
          }
          return false;
        }
        if (!a(paramActivity, paramHashMap, str3, str4, paramQQAppInterface, str5, i, str2, bool, k)) {
          break label453;
        }
        return false;
        label386:
        if (TextUtils.isEmpty(paramString)) {
          break label455;
        }
        j = i;
        if (i == 0) {
          j = 19;
        }
        xbp.b(paramActivity, paramQQAppInterface, str2, j);
        break label453;
      }
    }
    for (;;)
    {
      xbp.b(paramActivity, paramQQAppInterface, paramHashMap, j);
      break label453;
      break label130;
      break;
      label435:
      bool = false;
      break label149;
      label441:
      j = 0;
      break label168;
      label447:
      k = 1;
      break label186;
      label453:
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
      String str = "topicId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
      ykv.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str });
    }
    return b(paramIntent);
  }
  
  private Intent d(Intent paramIntent, boolean paramBoolean)
  {
    String str2;
    String str3;
    String str4;
    if (paramBoolean)
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
      if (!TextUtils.isEmpty(str3)) {
        break label167;
      }
    }
    label167:
    for (String str1 = "unionId=" + str4 + "&userId=" + str1 + "&userType=" + str2;; str1 = "storyId=" + str3)
    {
      ykv.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
      return d(paramIntent);
    }
  }
  
  private Intent e(Intent paramIntent)
  {
    if (!TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"))) {}
    for (boolean bool = true;; bool = false)
    {
      ykq.a("QQstoryAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.c, Boolean.valueOf(bool));
      ykq.a("QQstoryAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.jdField_a_of_type_JavaUtilHashMap));
      if (!"open".equals(this.c)) {
        break;
      }
      return f(paramIntent, bool);
    }
    if (("openVideo".equals(this.c)) || ("openvideo".equals(this.c))) {
      return e(paramIntent, bool);
    }
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
  
  private Intent e(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = "userId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin") + "&vid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId");
      ykv.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str });
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
      ykv.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
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
    catch (NumberFormatException paramIntent) {}
    return null;
  }
  
  @Nullable
  private Intent i(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    if ((TextUtils.isEmpty(str2)) || ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str4))) || (TextUtils.isEmpty(str3))) {
      return null;
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
        return g();
      }
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QQstoryAction", 1, "doAction error: " + localException.getMessage());
      a("QQstoryAction");
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
    catch (Exception paramIntent) {}
    return null;
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
    catch (Exception paramIntent) {}
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
    if ((str5 != null) && (str5.equals("0"))) {}
    for (boolean bool = false;; bool = true)
    {
      if (TextUtils.isEmpty(str4))
      {
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
          return null;
        }
        int j;
        try
        {
          j = Integer.parseInt(str2);
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
        }
        catch (NumberFormatException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQstoryAction", 2, "makeStoryPlayVideoPageIntent, NumberFormatException, userId:" + str1 + ", userType:" + str2);
          }
          return null;
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
      paramIntent.putExtra("action", 6);
      paramIntent.putExtra("story_id", str4);
      paramIntent.putExtra("come_from", i);
      paramIntent.putExtra("showTitleBar", false);
      paramIntent.putExtra("showInfoCard", false);
      return paramIntent;
    }
  }
  
  public boolean g()
  {
    Object localObject1;
    String str2;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 != null)
      {
        str2 = ((Intent)localObject1).getStringExtra("big_brother_source_key");
        localObject1 = ((Intent)localObject1).getDataString();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = this.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        String str4 = a("roomid", "0");
        String str5 = a("fromid", "");
        String str6 = a("roomtype", "");
        String str7 = a("list_name", "");
        String str8 = a("first_jump_mode", "h5");
        String str9 = a("need_record", "1");
        String str10 = a("is_record", "0");
        String str11 = a("enter_record_if_finish", "1");
        String str12 = a("nowapp_ext", "");
        String str13 = a("nowplugin_ext", "");
        String str14 = a("h5_ext", "");
        String str15 = a("shakespearetime", "");
        String str16 = a("hostloading_percent", "0");
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgurl")) {}
        for (String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("msgurl"));; str3 = "")
        {
          String str17 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("coverurl");
          String str18 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extras");
          Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first");
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("coverurl", str17);
          ((Bundle)localObject2).putString("roomid", str4);
          ((Bundle)localObject2).putString("roomtype", str6);
          ((Bundle)localObject2).putString("extras_from_js", str18);
          ((Bundle)localObject2).putBoolean("can_use_h5_first", true);
          ((Bundle)localObject2).putString("first_jump_mode", str8);
          ((Bundle)localObject2).putString("is_record", str10);
          ((Bundle)localObject2).putString("enter_record_if_finish", str11);
          ((Bundle)localObject2).putString("nowapp_ext", str12);
          ((Bundle)localObject2).putString("nowplugin_ext", str13);
          ((Bundle)localObject2).putString("h5_ext", str14);
          ((Bundle)localObject2).putString("shakespearetime", str15);
          ((Bundle)localObject2).putString("fromid", str5);
          ((Bundle)localObject2).putString("url", str3);
          ((Bundle)localObject2).putString("listname", str7);
          ((Bundle)localObject2).putString("mqqScheme", (String)localObject1);
          if (!TextUtils.isEmpty(str2)) {
            ((Bundle)localObject2).putString("big_brother_source_key", str2);
          }
          boolean bool2 = true;
          boolean bool1 = bool2;
          if (!TextUtils.isEmpty(str9))
          {
            bool1 = bool2;
            if ("0".equals(str9)) {
              bool1 = false;
            }
          }
          ((Bundle)localObject2).putBoolean("need_record", bool1);
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topic")) {
            ((Bundle)localObject2).putString("topic", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topic"));
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("story_ext")) {
            ((Bundle)localObject2).putString("story_ext", (String)this.jdField_a_of_type_JavaUtilHashMap.get("story_ext"));
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("startsrc")) {
            ((Bundle)localObject2).putString("startsrc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("startsrc"));
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hostloading_percent")) {
            ((Bundle)localObject2).putInt("hostloading_percent", Integer.valueOf(str16).intValue());
          }
          if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
          {
            QQToast.a(BaseApplicationImpl.getApplication(), 1, "无网络连接请稍后再试", 1).a();
            return false;
          }
          try
          {
            ((avux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject2);
            QLog.i("QQstoryAction", 1, "enter now plugin use shadow");
            return true;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QQstoryAction", 2, localException.toString());
            }
            return false;
          }
        }
      }
      String str1 = "";
      str2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovg
 * JD-Core Version:    0.7.0.1
 */