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

public class anrm
{
  private static volatile anrm jdField_a_of_type_Anrm;
  private ArrayList<anrj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private anrm()
  {
    a("mqqapi://qqidentifier/web", anre.class);
    a("mqqapi://groupopenapp/openapp", anuh.class);
    a("mqqapi://commonBuddyGroup/commonBuddyGroup", anuf.class);
    a("mqqapi://trooptogether/open", anuj.class);
    a("mqqapi://manage_troop/main_page", anud.class);
    a("mqqapi://nearby_entry/nearby_feed", anqs.class);
    a("mqqapi://now/playmedia", antv.class);
    a("mqqapi://wsgzh/waterfall", anun.class);
    a("mqqapi://wsgzh/miniapp_player", anup.class);
    a("mqqzone", antk.class);
    a("mqqapi://qzoneschema", antr.class);
    a("mqqapi://qzone/publicaccount", antm.class);
    a("mqqapi://qboss/loader", ansn.class);
    a("qqfav://operation/", ansb.class);
    a("mqq://shop/apollo_store", anqk.class);
    a("mqqapi://shop/apollo_store", anqk.class);
    a("mqqapi://cmshow/game_invite", anqj.class);
    a("mqqapi://assistant_setting/ASSISTANT_SETTING", anqe.class);
    a("mqqapi://qzone/to_publish_queue", anto.class);
    a("mqqapi://qzone/to_friend_feeds", anth.class);
    a("mqqapi://qzone/activefeed", anth.class);
    a("mqqapi://qzone/open_homepage", antj.class);
    a("mqqapi://ftssearch/tab", anqq.class);
    a("mqqapi://ftssearch/openmixweb", anqo.class);
    a("mqqapi://qzone/to_qzone_dialog", antf.class);
    a("mqqapi://qzone/to_redpocket_share", antq.class);
    a("qapp://", ansl.class);
    a("mqqapi://qqreg", ansf.class);
    a("mqqapi://microapp/open?", anqy.class);
    a("mqqapi://miniapp/open?", anra.class);
    a("mqqapi://miniapp/adopen", anra.class);
    a("mqqapi://buscard/open", answ.class);
    a("mqqapi://wxminiapp/launch", anta.class);
    a("mqqapi://qqnotify/subscribe", ansd.class);
    a("mqqapi://qqnotify/open", antc.class);
    a("mqqapi://wallet/open", ansy.class);
    a("mqqmdpass://wallet/modify_pass", ansu.class);
    a("mqqapi://gamecenter/install", anul.class);
    a("mqqapi://vaslive", anrg.class);
    a("mqqapi://asyncmsg/showdetail?", anqg.class);
    a("mqqapi://schedule/showDetail?", antt.class);
    a("mqqapi://huayang", anrc.class);
    a("mqqapi://od", anrt.class);
    a("mqqapi://0odAddFriend", anrr.class);
    a("mqqapi://teamwork/opendoclist", anub.class);
    a("mqqapi://qstory/opencontent", ansj.class);
    a("qqstory://qstory/opencontent", ansj.class);
    a("mqqapi://contact/add", anqm.class);
    a("mqqapi://profile/setting", anrv.class);
    a("mqqapi://stickynote", antx.class);
    a("mqqapi://groupvideo", anqu.class);
    a("mqqapi://qwerewolf/enterHomePage", anrx.class);
    a("mqqapi://lightapp/open", anrp.class);
    a("mqqapi://qsubscribe", antz.class);
    a("mqqapi://qcircle", anrz.class);
    a("mqqapi://troop_homework/publish", anqw.class);
    a("https://qm.qq.com/cgi-bin/qm/qr", ansp.class);
    a("mqqapi://avgame/join_room", anqc.class);
    a("mqqapi://avgame/create_room", anpx.class);
    a("mqqapi://avgame/lobby", anpz.class);
    a("mqqapi://writetogether/open", anur.class);
  }
  
  public static anrh a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      if (jdField_a_of_type_Anrm == null) {}
      try
      {
        if (jdField_a_of_type_Anrm == null) {
          jdField_a_of_type_Anrm = new anrm();
        }
        paramQQAppInterface = jdField_a_of_type_Anrm.b(paramQQAppInterface, paramContext, paramString);
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
  
  private static anrl a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "parseUrl error: jump is empty");
      paramString = null;
      return paramString;
    }
    anrl localanrl = new anrl("", "", "", "", paramString);
    int i = paramString.indexOf(":");
    String[] arrayOfString1;
    if (i > 0)
    {
      localanrl.a(paramString.substring(0, i));
      QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localanrl.a());
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
        localanrl.b(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localanrl.b());
        paramString = localanrl;
        if (arrayOfString1.length != 2) {
          break;
        }
        arrayOfString1 = arrayOfString1[1].split("&");
        i = 0;
        label188:
        paramString = localanrl;
        if (i >= arrayOfString1.length) {
          break;
        }
        paramString = arrayOfString1[i].split("=");
        if (paramString.length != 2) {}
      }
      try
      {
        paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
        localanrl.a(paramString[0], paramString[1]);
        i += 1;
        break label188;
        localanrl.a(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localanrl.a());
        return localanrl;
        label278:
        paramString = paramString.substring(i + 3);
        continue;
        localanrl.b(arrayOfString2[0]);
        localanrl.c(paramString.substring(paramString.indexOf("/") + 1));
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localanrl.b() + " action is: " + localanrl.c());
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
    this.jdField_a_of_type_JavaUtilArrayList.add(new anrj(paramString, paramClass));
  }
  
  public ArrayList<anrj> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public anrh b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
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
    anri localanri = anrk.a((anrl)localObject, a());
    if (localanri != null)
    {
      QLog.d("JumpParserUtil", 1, "doParse, prepare to parse url: " + paramString);
      return localanri.a(paramQQAppInterface, paramContext, paramString, (anrl)localObject);
    }
    QLog.d("JumpParserUtil", 1, "doParse error: jumpParser not register, handle with old method:" + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrm
 * JD-Core Version:    0.7.0.1
 */