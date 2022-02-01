import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class aoum
{
  private static volatile aoum jdField_a_of_type_Aoum;
  private ArrayList<aouj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private aoum()
  {
    a("mqqapi://qqidentifier/web", aotz.class);
    a("mqqapi://groupopenapp/openapp", aoxh.class);
    a("mqqapi://commonBuddyGroup/commonBuddyGroup", aoxf.class);
    a("mqqapi://trooptogether/open", aoxj.class);
    a("mqqapi://manage_troop/main_page", aoxd.class);
    a("mqqapi://nearby_entry/nearby_feed", aotn.class);
    a("mqqapi://now/playmedia", aowv.class);
    a("mqqapi://wsgzh/waterfall", aoxn.class);
    a("mqqapi://wsgzh/miniapp_player", aoxp.class);
    a("mqqzone", aowk.class);
    a("mqqapi://qzoneschema", aowr.class);
    a("mqqapi://qzone/publicaccount", aowm.class);
    a("mqqapi://qboss/loader", aovn.class);
    a("qqfav://operation/", aovb.class);
    a("mqq://shop/apollo_store", aotd.class);
    a("mqqapi://shop/apollo_store", aotd.class);
    a("mqqapi://cmshow/game_invite", aotc.class);
    a("mqqapi://assistant_setting/ASSISTANT_SETTING", aosx.class);
    a("mqqapi://qzone/to_publish_queue", aowo.class);
    a("mqqapi://qzone/to_friend_feeds", aowh.class);
    a("mqqapi://qzone/activefeed", aowh.class);
    a("mqqapi://qzone/open_homepage", aowj.class);
    a("mqqapi://ftssearch/tab", aotl.class);
    a("mqqapi://ftssearch/openmixweb", aotj.class);
    a("mqqapi://qzone/to_qzone_dialog", aowf.class);
    a("mqqapi://qzone/to_redpocket_share", aowq.class);
    a("qapp://", aovl.class);
    a("mqqapi://qqreg", aovf.class);
    a("mqqapi://microapp/open?", aott.class);
    a("mqqapi://miniapp/open?", aotv.class);
    a("mqqapi://miniapp/adopen", aotv.class);
    a("mqqapi://buscard/open", aovw.class);
    a("mqqapi://wxminiapp/launch", aowa.class);
    a("mqqapi://qqnotify/subscribe", aovd.class);
    a("mqqapi://qqnotify/open", aowc.class);
    a("mqqapi://wallet/open", aovy.class);
    a("mqqmdpass://wallet/modify_pass", aovu.class);
    a("mqqapi://gamecenter/install", aoxl.class);
    a("mqqapi://vaslive", aoub.class);
    a("mqqapi://asyncmsg/showdetail?", aosz.class);
    a("mqqapi://webcustomheight", aoth.class);
    a("mqqapi://schedule/showDetail?", aowt.class);
    a("mqqapi://huayang", aotx.class);
    a("mqqapi://od", aout.class);
    a("mqqapi://0odAddFriend", aour.class);
    a("mqqapi://teamwork/opendoclist", aoxb.class);
    a("mqqapi://qstory/opencontent", aovj.class);
    a("qqstory://qstory/opencontent", aovj.class);
    a("mqqapi://contact/add", aotf.class);
    a("mqqapi://profile/setting", aouv.class);
    a("mqqapi://stickynote", aowx.class);
    a("mqqapi://groupvideo", aotp.class);
    a("mqqapi://qwerewolf/enterHomePage", aoux.class);
    a("mqqapi://lightapp/open", aoup.class);
    a("mqqapi://qsubscribe", aowz.class);
    a("mqqapi://qcircle", aouz.class);
    a("mqqapi://troop_homework/publish", aotr.class);
    a("https://qm.qq.com/cgi-bin/qm/qr", aovp.class);
    a("mqqapi://avgame/join_room", aosv.class);
    a("mqqapi://avgame/create_room", aosq.class);
    a("mqqapi://avgame/lobby", aoss.class);
    a("mqqapi://writetogether/open", aoxr.class);
  }
  
  public static aouc a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      if (jdField_a_of_type_Aoum == null) {}
      try
      {
        if (jdField_a_of_type_Aoum == null) {
          jdField_a_of_type_Aoum = new aoum();
        }
        paramQQAppInterface = jdField_a_of_type_Aoum.b(paramQQAppInterface, paramContext, paramString);
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
  
  private static aoul a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "parseUrl error: jump is empty");
      paramString = null;
      return paramString;
    }
    aoul localaoul = new aoul("", "", "", "", paramString);
    int i = paramString.indexOf(":");
    String[] arrayOfString1;
    if (i > 0)
    {
      localaoul.a(paramString.substring(0, i));
      QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localaoul.a());
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
        localaoul.b(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localaoul.b());
        paramString = localaoul;
        if (arrayOfString1.length != 2) {
          break;
        }
        arrayOfString1 = arrayOfString1[1].split("&");
        i = 0;
        label188:
        paramString = localaoul;
        if (i >= arrayOfString1.length) {
          break;
        }
        paramString = arrayOfString1[i].split("=");
        if (paramString.length != 2) {}
      }
      try
      {
        paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
        localaoul.a(paramString[0], paramString[1]);
        i += 1;
        break label188;
        localaoul.a(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localaoul.a());
        return localaoul;
        label278:
        paramString = paramString.substring(i + 3);
        continue;
        localaoul.b(arrayOfString2[0]);
        localaoul.c(paramString.substring(paramString.indexOf("/") + 1));
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localaoul.b() + " action is: " + localaoul.c());
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
    this.jdField_a_of_type_JavaUtilArrayList.add(new aouj(paramString, paramClass));
  }
  
  public ArrayList<aouj> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public aouc b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    QLog.d("JumpParserUtil", 1, "doParse url: " + paramString);
    if (paramString == null)
    {
      QLog.d("JumpParserUtil", 1, "doParse url is null, return");
      return null;
    }
    Object localObject = a(paramString);
    paramString = (String)localObject;
    if (AudioHelper.e())
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
    aoui localaoui = aouk.a((aoul)localObject, a());
    if (localaoui != null)
    {
      QLog.d("JumpParserUtil", 1, "doParse, prepare to parse url: " + paramString);
      return localaoui.a(paramQQAppInterface, paramContext, paramString, (aoul)localObject);
    }
    QLog.d("JumpParserUtil", 1, "doParse error: jumpParser not register, handle with old method:" + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoum
 * JD-Core Version:    0.7.0.1
 */