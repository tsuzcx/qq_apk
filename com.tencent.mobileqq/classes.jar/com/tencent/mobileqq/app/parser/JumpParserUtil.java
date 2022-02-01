package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.msgbox.search.TempMsgBoxOpenParser;
import com.tencent.mobileqq.apollo.api.uitls.ICMShowJumpParserFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class JumpParserUtil
{
  private static volatile JumpParserUtil jdField_a_of_type_ComTencentMobileqqAppParserJumpParserUtil;
  private ArrayList<JumpParserBean> jdField_a_of_type_JavaUtilArrayList = null;
  
  private JumpParserUtil()
  {
    a("mqqapi://qqidentifier/web", IdentifierWebJumpParser.class);
    a("mqqapi://groupopenapp/openapp", TroopProfileParser.class);
    a("mqqapi://commonBuddyGroup/commonBuddyGroup", TroopOneWayParser.class);
    a("mqqapi://trooptogether/open", TroopTogetherParser.class);
    a("mqqapi://manage_troop/main_page", TroopManagerParser.class);
    a("mqqapi://nearby_entry/nearby_feed", GotoNearbyParser.class);
    a("mqqapi://now/playmedia", SmallVideoParser.class);
    a("mqqapi://wsgzh/waterfall", WeishiPublicAccountParser.class);
    a("mqqapi://wsgzh/miniapp_player", WeishiPublicAccountVideoParser.class);
    a("mqqzone", QzoneParser.class);
    a("mqqapi://qzoneschema", QzoneV2Parser.class);
    a("mqqapi://qzone/publicaccount", QzonePublicAccountParser.class);
    a("mqqapi://qboss/loader", QbossLoaderParser.class);
    a("qqfav://operation/", QQFavParser.class);
    ICMShowJumpParserFactory localICMShowJumpParserFactory = (ICMShowJumpParserFactory)QRoute.api(ICMShowJumpParserFactory.class);
    if (localICMShowJumpParserFactory != null)
    {
      a("mqq://shop/apollo_store", localICMShowJumpParserFactory.getJumpParserClass("mqq://shop/apollo_store"));
      a("mqqapi://shop/apollo_store", localICMShowJumpParserFactory.getJumpParserClass("mqqapi://shop/apollo_store"));
      a("mqqapi://cmshow/game_invite", localICMShowJumpParserFactory.getJumpParserClass("mqqapi://cmshow/game_invite"));
    }
    a("mqqapi://assistant_setting/ASSISTANT_SETTING", AssistantSettingParser.class);
    a("mqqapi://expand/openpage", ExtendOpenPageParser.class);
    a("mqqapi://qzone/to_publish_queue", QzonePublishQueueParser.class);
    a("mqqapi://qzone/to_friend_feeds", QzoneFriendFeedsV1AndV2Parser.class);
    a("mqqapi://qzone/activefeed", QzoneFriendFeedsV1AndV2Parser.class);
    a("mqqapi://qzone/open_homepage", QzoneOpenHomePageParser.class);
    a("mqqapi://ftssearch/tab", FTSSearchTabParser.class);
    a("mqqapi://ftssearch/openmixweb", FTSSearchOpenMixWebParser.class);
    a("mqqapi://qzone/to_qzone_dialog", QzoneDialogParser.class);
    a("mqqapi://qzone/to_redpocket_share", QzoneRedpocketShareParser.class);
    a("qapp://", QappCenterParser.class);
    a("mqqapi://qqreg", QQRegisterParser.class);
    a("mqqapi://microapp/open?", HttpOpenMicroAppParser.class);
    a("mqqapi://miniapp/open?", HttpOpenMiniAppAndAdParser.class);
    a("mqqapi://miniapp/adopen", HttpOpenMiniAppAndAdParser.class);
    a("mqqapi://wxminiapp/launch", QwalletToLaunchWXMiniAppParser.class);
    a("mqqapi://qqnotify/subscribe", QQNotifySettingParser.class);
    a("mqqapi://qqnotify/open", QwalletToNotifyParser.class);
    a("mqqapi://wallet/open", QwalletToHomeParser.class);
    a("mqqmdpass://wallet/modify_pass", QwalletModifyPassParser.class);
    a("mqqapi://gamecenter/install", WadlParser.class);
    a("mqqapi://vaslive", IliveJumpParser.class);
    a("mqqapi://asyncmsg/showdetail?", AsyncShowDetailParser.class);
    a("mqqapi://webcustomheight", CustomHeightWebJumpParser.class);
    a("mqqapi://schedule/showDetail?", ScheduleShowDetailParser.class);
    a("mqqapi://huayang", HuaYangParser.class);
    a("mqqapi://od", OnlineDatingParser.class);
    a("mqqapi://0odAddFriend", OdAddFriendParser.class);
    a("mqqapi://teamwork/opendoclist", TeamWorkListParser.class);
    a("mqqapi://qstory/opencontent", QQstoryOpenContentParser.class);
    a("qqstory://qstory/opencontent", QQstoryOpenContentParser.class);
    a("mqqapi://contact/add", ContactAddParser.class);
    a("mqqapi://profile/setting", OpenOnProfileSettingParser.class);
    a("mqqapi://stickynote", StickyNoteParser.class);
    a("mqqapi://groupvideo", GroupVideoParser.class);
    a("mqqapi://qwerewolf/enterHomePage", OpenWereWolfParser.class);
    a("mqqapi://lightapp/open", LightAppOpenParser.class);
    a("mqqapi://qsubscribe", SubScribeParser.class);
    a("mqqapi://qcircle", QCircleParser.class);
    a("mqqapi://troop_homework/publish", HomeWorkTroopPublishParser.class);
    a("https://qm.qq.com/cgi-bin/qm/qr", QrCodeParser.class);
    a("mqqapi://avgame/join_room", AVGameShareJoinRoomParser.class);
    a("mqqapi://avgame/create_room", AVGameShareCreateRoomParser.class);
    a("mqqapi://avgame/lobby", AVGameShareEntryLobbyParser.class);
    a("mqqapi://avgame/pk_qqcj", AVGameSpringHBParser.class);
    a("mqqapi://writetogether/open", WriteTogetherOpenParser.class);
    a("mqqapi://avsharescreen/request", ScreenShareAskParser.class);
    a("mqqapi://setting", QQSettingJumpParser.class);
    a("mqqapi://TempSessionMessageBox", TempMsgBoxOpenParser.class);
  }
  
  public static JumpActionBase a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppParserJumpParserUtil == null) {}
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqAppParserJumpParserUtil == null) {
          jdField_a_of_type_ComTencentMobileqqAppParserJumpParserUtil = new JumpParserUtil();
        }
        paramQQAppInterface = jdField_a_of_type_ComTencentMobileqqAppParserJumpParserUtil.b(paramQQAppInterface, paramContext, paramString);
        return paramQQAppInterface;
      }
      finally {}
      return null;
    }
    catch (Exception paramQQAppInterface)
    {
      paramContext = new HashMap(1);
      paramContext.put("keyJumpParserUtilUrlErrorKey", paramString);
      paramContext.put("keyJumpParserUtilSceneErrorKey", "1");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, paramContext, "", false);
      QLog.e("JumpParserUtil", 1, "parse error: " + paramQQAppInterface.getMessage());
    }
  }
  
  private static JumpParserResult a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "parseUrl error: jump is empty");
      paramString = null;
      return paramString;
    }
    JumpParserResult localJumpParserResult = new JumpParserResult("", "", "", "", paramString);
    int i = paramString.indexOf(":");
    String[] arrayOfString1;
    if (i > 0)
    {
      localJumpParserResult.a(paramString.substring(0, i));
      QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localJumpParserResult.a());
      arrayOfString1 = paramString.split("\\?");
      if (arrayOfString1.length != 2) {
        break label278;
      }
      paramString = arrayOfString1[0].substring(i + 3);
    }
    for (;;)
    {
      String[] arrayOfString2 = paramString.split("/");
      if (arrayOfString2.length == 0)
      {
        localJumpParserResult.b(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localJumpParserResult.b());
        paramString = localJumpParserResult;
        if (arrayOfString1.length != 2) {
          break;
        }
        arrayOfString1 = arrayOfString1[1].split("&");
        i = 0;
        label188:
        paramString = localJumpParserResult;
        if (i >= arrayOfString1.length) {
          break;
        }
        paramString = arrayOfString1[i].split("=");
        if (paramString.length != 2) {}
      }
      try
      {
        paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
        localJumpParserResult.a(paramString[0], paramString[1]);
        i += 1;
        break label188;
        localJumpParserResult.a(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localJumpParserResult.a());
        return localJumpParserResult;
        label278:
        paramString = paramString.substring(i + 3);
        continue;
        localJumpParserResult.b(arrayOfString2[0]);
        localJumpParserResult.c(paramString.substring(paramString.indexOf("/") + 1));
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localJumpParserResult.b() + " action is: " + localJumpParserResult.c());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("JumpParserUtil", 1, "failed to decode param value,keyValues[1] is:" + paramString[1] + ",keyValues[2] is:" + paramString[1], localException);
        }
      }
    }
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("JumpParserUtil", 1, "shouldPreDecodeUrl error: url is null");
    }
    while ((paramString.startsWith("mqqapi://qqidentifier/web")) || (paramString.startsWith("mqqapi://groupopenapp/openapp")) || (paramString.startsWith("mqqapi://commonBuddyGroup/commonBuddyGroup")) || (paramString.startsWith("mqqapi://manage_troop/main_page")) || (paramString.startsWith("mqqapi://nearby_entry/nearby_feed")) || (paramString.startsWith("mqqapi://now/playmedia")) || (paramString.startsWith("mqqapi://wsgzh/waterfall")) || (paramString.startsWith("mqqapi://wsgzh/miniapp_player")) || (paramString.startsWith("mqqzone")) || (paramString.startsWith("mqqapi://qzoneschema")) || (paramString.startsWith("mqqapi://qzone/publicaccount")) || (paramString.startsWith("mqqapi://qboss/loader")) || (paramString.startsWith("qqfav://operation/")) || (paramString.startsWith("mqq://shop/apollo_store")) || (paramString.startsWith("mqqapi://shop/apollo_store")) || (paramString.startsWith("mqqapi://cmshow/game_invite")) || (paramString.startsWith("mqqapi://assistant_setting/ASSISTANT_SETTING")) || (paramString.startsWith("mqqapi://trooptogether/open")) || (!paramString.contains("videochat")) || (!paramString.contains("uinType=21"))) {
      return paramString;
    }
    QLog.d("JumpParserUtil", 1, "shouldPreDecodeUrl execute for containing videochat and uinType=21");
    return URLDecoder.decode(paramString);
  }
  
  private void a(String paramString, Class paramClass)
  {
    if (paramClass == null)
    {
      QLog.e("JumpParserUtil", 1, "registerParser error: class is null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "registerParser error: urlStartStr is empty");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new JumpParserBean(paramString, paramClass));
  }
  
  public ArrayList<JumpParserBean> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public JumpActionBase b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    QLog.d("JumpParserUtil", 1, "doParse url: " + paramString);
    if (paramString == null)
    {
      QLog.d("JumpParserUtil", 1, "doParse url is null, return");
      return null;
    }
    Object localObject = a(paramString);
    paramString = (String)localObject;
    if (AudioHelper.d())
    {
      paramString = (String)localObject;
      if (AudioHelper.a(8) == 1)
      {
        paramString = (String)localObject;
        if (((String)localObject).startsWith("mqqconferenceflyticket://")) {
          paramString = "mqqavshare://avshare/forward?url=https%3a%2f%2fwww.baidu.com%2fs%3fwd%3dabc%26rsv_spt%3d1&exp=1566906601";
        }
      }
    }
    localObject = a(paramString);
    JumpParserBase localJumpParserBase = JumpParserFactory.a((JumpParserResult)localObject, a());
    if (localJumpParserBase != null)
    {
      QLog.d("JumpParserUtil", 1, "doParse, prepare to parse url: " + paramString);
      return localJumpParserBase.a(paramQQAppInterface, paramContext, paramString, (JumpParserResult)localObject);
    }
    QLog.d("JumpParserUtil", 1, "doParse error: jumpParser not register, handle with old method:" + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpParserUtil
 * JD-Core Version:    0.7.0.1
 */