import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class aojx
{
  private static volatile aojx jdField_a_of_type_Aojx;
  private ArrayList<aoju> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private aojx()
  {
    a("mqqapi://qqidentifier/web", aojp.class);
    a("mqqapi://groupopenapp/openapp", aoms.class);
    a("mqqapi://commonBuddyGroup/commonBuddyGroup", aomq.class);
    a("mqqapi://manage_troop/main_page", aomo.class);
    a("mqqapi://nearby_entry/nearby_feed", aojd.class);
    a("mqqapi://now/playmedia", aomg.class);
    a("mqqapi://wsgzh/waterfall", aomw.class);
    a("mqqapi://wsgzh/miniapp_player", aomy.class);
    a("mqqzone", aolv.class);
    a("mqqapi://qzoneschema", aomc.class);
    a("mqqapi://qzone/publicaccount", aolx.class);
    a("mqqapi://qboss/loader", aoky.class);
    a("qqfav://operation/", aokm.class);
    a("mqq://shop/apollo_store", aoiv.class);
    a("mqqapi://shop/apollo_store", aoiv.class);
    a("mqqapi://cmshow/game_invite", aoiu.class);
    a("mqqapi://assistant_setting/ASSISTANT_SETTING", aoip.class);
    a("mqqapi://qzone/to_publish_queue", aolz.class);
    a("mqqapi://qzone/to_friend_feeds", aols.class);
    a("mqqapi://qzone/activefeed", aols.class);
    a("mqqapi://qzone/open_homepage", aolu.class);
    a("mqqapi://ftssearch/tab", aojb.class);
    a("mqqapi://ftssearch/openmixweb", aoiz.class);
    a("mqqapi://qzone/to_qzone_dialog", aolq.class);
    a("mqqapi://qzone/to_redpocket_share", aomb.class);
    a("qapp://", aokw.class);
    a("mqqapi://qqreg", aokq.class);
    a("mqqapi://microapp/open?", aojj.class);
    a("mqqapi://miniapp/open?", aojl.class);
    a("mqqapi://miniapp/adopen", aojl.class);
    a("mqqapi://buscard/open", aolh.class);
    a("mqqapi://wxminiapp/launch", aoll.class);
    a("mqqapi://qqnotify/subscribe", aoko.class);
    a("mqqapi://qqnotify/open", aoln.class);
    a("mqqapi://wallet/open", aolj.class);
    a("mqqmdpass://wallet/modify_pass", aolf.class);
    a("mqqapi://gamecenter/install", aomu.class);
    a("mqqapi://vaslive", aojr.class);
    a("mqqapi://asyncmsg/showdetail?", aoir.class);
    a("mqqapi://schedule/showDetail?", aome.class);
    a("mqqapi://huayang", aojn.class);
    a("mqqapi://od", aoke.class);
    a("mqqapi://0odAddFriend", aokc.class);
    a("mqqapi://teamwork/opendoclist", aomm.class);
    a("mqqapi://qstory/opencontent", aoku.class);
    a("qqstory://qstory/opencontent", aoku.class);
    a("mqqapi://contact/add", aoix.class);
    a("mqqapi://profile/setting", aokg.class);
    a("mqqapi://stickynote", aomi.class);
    a("mqqapi://groupvideo", aojf.class);
    a("mqqapi://qwerewolf/enterHomePage", aoki.class);
    a("mqqapi://lightapp/open", aoka.class);
    a("mqqapi://qsubscribe", aomk.class);
    a("mqqapi://qcircle", aokk.class);
    a("mqqapi://troop_homework/publish", aojh.class);
    a("https://qm.qq.com/cgi-bin/qm/qr", aola.class);
    a("mqqapi://avgame/join_room", aoin.class);
    a("mqqapi://avgame/create_room", aoik.class);
  }
  
  public static aojs a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      if (jdField_a_of_type_Aojx == null) {}
      try
      {
        if (jdField_a_of_type_Aojx == null) {
          jdField_a_of_type_Aojx = new aojx();
        }
        paramQQAppInterface = jdField_a_of_type_Aojx.b(paramQQAppInterface, paramContext, paramString);
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
      bctj.a(BaseApplicationImpl.getApplication()).a("", "keyJumpParserUtil", true, 0L, 0L, paramContext, "", false);
      QLog.e("JumpParserUtil", 1, "parse error: " + paramQQAppInterface.getMessage());
    }
  }
  
  private static aojw a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "parseUrl error: jump is empty");
      paramString = null;
      return paramString;
    }
    aojw localaojw = new aojw("", "", "", "", paramString);
    int i = paramString.indexOf(":");
    String[] arrayOfString1;
    if (i > 0)
    {
      localaojw.a(paramString.substring(0, i));
      QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localaojw.a());
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
        localaojw.b(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localaojw.b());
        paramString = localaojw;
        if (arrayOfString1.length != 2) {
          break;
        }
        arrayOfString1 = arrayOfString1[1].split("&");
        i = 0;
        label188:
        paramString = localaojw;
        if (i >= arrayOfString1.length) {
          break;
        }
        paramString = arrayOfString1[i].split("=");
        if (paramString.length != 2) {}
      }
      try
      {
        paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
        localaojw.a(paramString[0], paramString[1]);
        i += 1;
        break label188;
        localaojw.a(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localaojw.a());
        return localaojw;
        label278:
        paramString = paramString.substring(i + 3);
        continue;
        localaojw.b(arrayOfString2[0]);
        localaojw.c(paramString.substring(paramString.indexOf("/") + 1));
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localaojw.b() + " action is: " + localaojw.c());
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
    while ((paramString.startsWith("mqqapi://qqidentifier/web")) || (paramString.startsWith("mqqapi://groupopenapp/openapp")) || (paramString.startsWith("mqqapi://commonBuddyGroup/commonBuddyGroup")) || (paramString.startsWith("mqqapi://manage_troop/main_page")) || (paramString.startsWith("mqqapi://nearby_entry/nearby_feed")) || (paramString.startsWith("mqqapi://now/playmedia")) || (paramString.startsWith("mqqapi://wsgzh/waterfall")) || (paramString.startsWith("mqqapi://wsgzh/miniapp_player")) || (paramString.startsWith("mqqzone")) || (paramString.startsWith("mqqapi://qzoneschema")) || (paramString.startsWith("mqqapi://qzone/publicaccount")) || (paramString.startsWith("mqqapi://qboss/loader")) || (paramString.startsWith("qqfav://operation/")) || (paramString.startsWith("mqq://shop/apollo_store")) || (paramString.startsWith("mqqapi://shop/apollo_store")) || (paramString.startsWith("mqqapi://cmshow/game_invite")) || (paramString.startsWith("mqqapi://assistant_setting/ASSISTANT_SETTING")) || (!paramString.contains("videochat")) || (!paramString.contains("uinType=21"))) {
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
    this.jdField_a_of_type_JavaUtilArrayList.add(new aoju(paramString, paramClass));
  }
  
  public ArrayList<aoju> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public aojs b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
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
    aojt localaojt = aojv.a((aojw)localObject, a());
    if (localaojt != null)
    {
      QLog.d("JumpParserUtil", 1, "doParse, prepare to parse url: " + paramString);
      return localaojt.a(paramQQAppInterface, paramContext, paramString, (aojw)localObject);
    }
    QLog.d("JumpParserUtil", 1, "doParse error: jumpParser not register, handle with old method:" + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojx
 * JD-Core Version:    0.7.0.1
 */