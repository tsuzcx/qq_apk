package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.search.TempMsgBoxOpenParser;
import com.tencent.mobileqq.apollo.utils.api.ICMShowJumpParserFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.jump.IQWalletJumpParserFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.jump.api.ITimiGameParserFactory;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class JumpParserUtil
{
  private static volatile JumpParserUtil a;
  private ArrayList<JumpParserBean> b = null;
  
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
    a("mqqapi://wsgzh/wesee", WeishiPublicAccountUniversalParser.class);
    a("mqqzone", QzoneParser.class);
    a("mqqapi://qzoneschema", QzoneV2Parser.class);
    a("mqqapi://qzone/publicaccount", QzonePublicAccountParser.class);
    a("qqfav://operation/", QQFavParser.class);
    try
    {
      ICMShowJumpParserFactory localICMShowJumpParserFactory = (ICMShowJumpParserFactory)QRoute.api(ICMShowJumpParserFactory.class);
      if (localICMShowJumpParserFactory != null)
      {
        a("mqq://shop/apollo_store", localICMShowJumpParserFactory.getJumpParserClass("mqq://shop/apollo_store"));
        a("mqqapi://shop/apollo_store", localICMShowJumpParserFactory.getJumpParserClass("mqqapi://shop/apollo_store"));
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpParserUtil", 1, "register CMShowJumpParser error!", localThrowable);
    }
    a("mqqapi://assistant_setting/ASSISTANT_SETTING", AssistantSettingParser.class);
    a("mqqapi://gamemsgbox/open", GameMsgBoxParser.class);
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
    try
    {
      IQWalletJumpParserFactory localIQWalletJumpParserFactory = (IQWalletJumpParserFactory)QRoute.api(IQWalletJumpParserFactory.class);
      if (localIQWalletJumpParserFactory != null) {
        a("mqqapi://wxminiapp/launch", localIQWalletJumpParserFactory.getJumpParserClass("mqqapi://wxminiapp/launch"));
      }
    }
    catch (Exception localException1)
    {
      QLog.e("JumpParserUtil", 1, localException1, new Object[0]);
    }
    a("mqqapi://qqnotify/subscribe", QQNotifySettingParser.class);
    a("mqqapi://qqnotify/open", QwalletToNotifyParser.class);
    a("mqqapi://qqnotify/jump", QQNotifyJumpParse.class);
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
    a("mqqapi://qflash", QFlashShowParser.class);
    a("mqqapi://troop_homework/publish", HomeWorkTroopPublishParser.class);
    a("https://qm.qq.com/cgi-bin/qm/qr", QrCodeParser.class);
    a("mqqapi://avgame/join_room", AVGameShareJoinRoomParser.class);
    a("mqqapi://avgame/create_room", AVGameShareCreateRoomParser.class);
    a("mqqapi://avgame/lobby", AVGameShareEntryLobbyParser.class);
    a("mqqapi://avgame/pk_qqcj", AVGameSpringHBParser.class);
    a("mqqapi://writetogether/open", WriteTogetherOpenParser.class);
    a("mqqapi://avsharescreen/request", ScreenShareAskParser.class);
    a("mqqapi://setting", QQSettingJumpParser.class);
    a("mqqapi://opensdk", OpenSdkJumpParser.class);
    a("mqqapi://TempSessionMessageBox", TempMsgBoxOpenParser.class);
    a("mqqguild://guild", GuildJumpParser.class);
    a("mqqapi://qqfile/openmyfile", OpenMyFileParser.class);
    try
    {
      a("mqqapi://esports/open", ((ITimiGameParserFactory)QRoute.api(ITimiGameParserFactory.class)).getJumpParserClass());
      a("mqqapi://esports/team/create", ((ITimiGameParserFactory)QRoute.api(ITimiGameParserFactory.class)).getTeamCreateParserClass());
      a("mqqapi://esports/team/join", ((ITimiGameParserFactory)QRoute.api(ITimiGameParserFactory.class)).getTeamJoinParserClass());
      return;
    }
    catch (Exception localException2)
    {
      QLog.e("JumpParserUtil", 1, localException2, new Object[0]);
    }
  }
  
  public static JumpParserResult a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "parseUrl error: jump is empty");
      return null;
    }
    JumpParserResult localJumpParserResult = new JumpParserResult("", "", "", "", paramString);
    int i = paramString.indexOf(":");
    if (i > 0)
    {
      localJumpParserResult.a(paramString.substring(0, i));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseUrl scheme is: ");
      ((StringBuilder)localObject).append(localJumpParserResult.a());
      QLog.d("JumpParserUtil", 1, ((StringBuilder)localObject).toString());
      localObject = paramString.split("\\?");
      if (localObject.length == 2) {
        paramString = localObject[0].substring(i + 3);
      } else {
        paramString = paramString.substring(i + 3);
      }
      String[] arrayOfString = paramString.split("/");
      if (arrayOfString.length == 0)
      {
        localJumpParserResult.b(paramString);
        paramString = new StringBuilder();
        paramString.append("parseUrl server is: ");
        paramString.append(localJumpParserResult.b());
        QLog.d("JumpParserUtil", 1, paramString.toString());
      }
      else
      {
        localJumpParserResult.b(arrayOfString[0]);
        localJumpParserResult.c(paramString.substring(paramString.indexOf("/") + 1));
        paramString = new StringBuilder();
        paramString.append("parseUrl server is: ");
        paramString.append(localJumpParserResult.b());
        paramString.append(" action is: ");
        paramString.append(localJumpParserResult.c());
        QLog.d("JumpParserUtil", 1, paramString.toString());
      }
      if (localObject.length == 2)
      {
        paramString = localObject[1].split("&");
        i = 0;
        while (i < paramString.length)
        {
          localObject = paramString[i].split("=");
          if (localObject.length == 2) {
            try
            {
              localObject[1] = URLDecoder.decode(localObject[1], "UTF-8");
              localJumpParserResult.a(localObject[0], localObject[1]);
            }
            catch (Exception localException)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("failed to decode param value,keyValues[1] is:");
              localStringBuilder.append(localObject[1]);
              localStringBuilder.append(",keyValues[2] is:");
              localStringBuilder.append(localObject[1]);
              QLog.e("JumpParserUtil", 1, localStringBuilder.toString(), localException);
            }
          }
          i += 1;
        }
      }
      return localJumpParserResult;
    }
    localJumpParserResult.a(paramString);
    paramString = new StringBuilder();
    paramString.append("parseUrl scheme is: ");
    paramString.append(localJumpParserResult.a());
    QLog.d("JumpParserUtil", 1, paramString.toString());
    return localJumpParserResult;
  }
  
  public static JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new JumpParserUtil();
          }
        }
        finally {}
      }
      paramBaseQQAppInterface = a.b(paramBaseQQAppInterface, paramContext, paramString);
      return paramBaseQQAppInterface;
    }
    catch (Exception paramBaseQQAppInterface)
    {
      paramContext = new HashMap(1);
      paramContext.put("keyJumpParserUtilUrlErrorKey", paramString);
      paramContext.put("keyJumpParserUtilSceneErrorKey", "1");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, paramContext, "", false);
      paramContext = new StringBuilder();
      paramContext.append("parse error: ");
      paramContext.append(paramBaseQQAppInterface.getMessage());
      QLog.e("JumpParserUtil", 1, paramContext.toString());
    }
    return null;
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
    this.b.add(new JumpParserBean(paramString, paramClass));
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "shouldPreDecodeUrl error: url is null");
      return paramString;
    }
    String str = paramString;
    if (!paramString.startsWith("mqqapi://qqidentifier/web"))
    {
      str = paramString;
      if (!paramString.startsWith("mqqapi://groupopenapp/openapp"))
      {
        str = paramString;
        if (!paramString.startsWith("mqqapi://commonBuddyGroup/commonBuddyGroup"))
        {
          str = paramString;
          if (!paramString.startsWith("mqqapi://manage_troop/main_page"))
          {
            str = paramString;
            if (!paramString.startsWith("mqqapi://nearby_entry/nearby_feed"))
            {
              str = paramString;
              if (!paramString.startsWith("mqqapi://now/playmedia"))
              {
                str = paramString;
                if (!paramString.startsWith("mqqapi://wsgzh/waterfall"))
                {
                  str = paramString;
                  if (!paramString.startsWith("mqqapi://wsgzh/miniapp_player"))
                  {
                    str = paramString;
                    if (!paramString.startsWith("mqqapi://wsgzh/wesee"))
                    {
                      str = paramString;
                      if (!paramString.startsWith("mqqzone"))
                      {
                        str = paramString;
                        if (!paramString.startsWith("mqqapi://qzoneschema"))
                        {
                          str = paramString;
                          if (!paramString.startsWith("mqqapi://qzone/publicaccount"))
                          {
                            str = paramString;
                            if (!paramString.startsWith("mqqapi://qboss/loader"))
                            {
                              str = paramString;
                              if (!paramString.startsWith("qqfav://operation/"))
                              {
                                str = paramString;
                                if (!paramString.startsWith("mqq://shop/apollo_store"))
                                {
                                  str = paramString;
                                  if (!paramString.startsWith("mqqapi://shop/apollo_store"))
                                  {
                                    str = paramString;
                                    if (!paramString.startsWith("mqqapi://assistant_setting/ASSISTANT_SETTING"))
                                    {
                                      if (paramString.startsWith("mqqapi://trooptogether/open")) {
                                        return paramString;
                                      }
                                      str = paramString;
                                      if (paramString.contains("videochat"))
                                      {
                                        str = paramString;
                                        if (paramString.contains("uinType=21"))
                                        {
                                          QLog.d("JumpParserUtil", 1, "shouldPreDecodeUrl execute for containing videochat and uinType=21");
                                          str = URLDecoder.decode(paramString);
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return str;
  }
  
  public ArrayList<JumpParserBean> a()
  {
    return this.b;
  }
  
  public JumpAction b(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doParse url: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("JumpParserUtil", 1, ((StringBuilder)localObject).toString());
    if (paramString == null)
    {
      QLog.d("JumpParserUtil", 1, "doParse url is null, return");
      return null;
    }
    localObject = b(paramString);
    paramString = (String)localObject;
    if (QQAudioHelper.b())
    {
      paramString = (String)localObject;
      if (QQAudioHelper.b(8) == 1)
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doParse, prepare to parse url: ");
      localStringBuilder.append(paramString);
      QLog.d("JumpParserUtil", 1, localStringBuilder.toString());
      return localJumpParserBase.a(paramBaseQQAppInterface, paramContext, paramString, (JumpParserResult)localObject);
    }
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append("doParse error: jumpParser not register, handle with old method:");
    paramBaseQQAppInterface.append(paramString);
    QLog.d("JumpParserUtil", 1, paramBaseQQAppInterface.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpParserUtil
 * JD-Core Version:    0.7.0.1
 */