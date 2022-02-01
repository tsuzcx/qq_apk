import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class aoxl
{
  private static volatile aoxl jdField_a_of_type_Aoxl;
  private ArrayList<aoxi> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private aoxl()
  {
    a("mqqapi://qqidentifier/web", aoxd.class);
    a("mqqapi://groupopenapp/openapp", apag.class);
    a("mqqapi://commonBuddyGroup/commonBuddyGroup", apae.class);
    a("mqqapi://manage_troop/main_page", apac.class);
    a("mqqapi://nearby_entry/nearby_feed", aowr.class);
    a("mqqapi://now/playmedia", aozu.class);
    a("mqqapi://wsgzh/waterfall", apak.class);
    a("mqqapi://wsgzh/miniapp_player", apam.class);
    a("mqqzone", aozj.class);
    a("mqqapi://qzoneschema", aozq.class);
    a("mqqapi://qzone/publicaccount", aozl.class);
    a("mqqapi://qboss/loader", aoym.class);
    a("qqfav://operation/", aoya.class);
    a("mqq://shop/apollo_store", aowj.class);
    a("mqqapi://shop/apollo_store", aowj.class);
    a("mqqapi://cmshow/game_invite", aowi.class);
    a("mqqapi://assistant_setting/ASSISTANT_SETTING", aowd.class);
    a("mqqapi://qzone/to_publish_queue", aozn.class);
    a("mqqapi://qzone/to_friend_feeds", aozg.class);
    a("mqqapi://qzone/activefeed", aozg.class);
    a("mqqapi://qzone/open_homepage", aozi.class);
    a("mqqapi://ftssearch/tab", aowp.class);
    a("mqqapi://ftssearch/openmixweb", aown.class);
    a("mqqapi://qzone/to_qzone_dialog", aoze.class);
    a("mqqapi://qzone/to_redpocket_share", aozp.class);
    a("qapp://", aoyk.class);
    a("mqqapi://qqreg", aoye.class);
    a("mqqapi://microapp/open?", aowx.class);
    a("mqqapi://miniapp/open?", aowz.class);
    a("mqqapi://miniapp/adopen", aowz.class);
    a("mqqapi://buscard/open", aoyv.class);
    a("mqqapi://wxminiapp/launch", aoyz.class);
    a("mqqapi://qqnotify/subscribe", aoyc.class);
    a("mqqapi://qqnotify/open", aozb.class);
    a("mqqapi://wallet/open", aoyx.class);
    a("mqqmdpass://wallet/modify_pass", aoyt.class);
    a("mqqapi://gamecenter/install", apai.class);
    a("mqqapi://vaslive", aoxf.class);
    a("mqqapi://asyncmsg/showdetail?", aowf.class);
    a("mqqapi://schedule/showDetail?", aozs.class);
    a("mqqapi://huayang", aoxb.class);
    a("mqqapi://od", aoxs.class);
    a("mqqapi://0odAddFriend", aoxq.class);
    a("mqqapi://teamwork/opendoclist", apaa.class);
    a("mqqapi://qstory/opencontent", aoyi.class);
    a("qqstory://qstory/opencontent", aoyi.class);
    a("mqqapi://contact/add", aowl.class);
    a("mqqapi://profile/setting", aoxu.class);
    a("mqqapi://stickynote", aozw.class);
    a("mqqapi://groupvideo", aowt.class);
    a("mqqapi://qwerewolf/enterHomePage", aoxw.class);
    a("mqqapi://lightapp/open", aoxo.class);
    a("mqqapi://qsubscribe", aozy.class);
    a("mqqapi://qcircle", aoxy.class);
    a("mqqapi://troop_homework/publish", aowv.class);
    a("https://qm.qq.com/cgi-bin/qm/qr", aoyo.class);
    a("mqqapi://avgame/join_room", aowb.class);
    a("mqqapi://avgame/create_room", aovy.class);
    a("mqqapi://writetogether/open", apao.class);
  }
  
  public static aoxg a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      if (jdField_a_of_type_Aoxl == null) {}
      try
      {
        if (jdField_a_of_type_Aoxl == null) {
          jdField_a_of_type_Aoxl = new aoxl();
        }
        paramQQAppInterface = jdField_a_of_type_Aoxl.b(paramQQAppInterface, paramContext, paramString);
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
      bdmc.a(BaseApplicationImpl.getApplication()).a("", "keyJumpParserUtil", true, 0L, 0L, paramContext, "", false);
      QLog.e("JumpParserUtil", 1, "parse error: " + paramQQAppInterface.getMessage());
    }
  }
  
  private static aoxk a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("JumpParserUtil", 1, "parseUrl error: jump is empty");
      paramString = null;
      return paramString;
    }
    aoxk localaoxk = new aoxk("", "", "", "", paramString);
    int i = paramString.indexOf(":");
    String[] arrayOfString1;
    if (i > 0)
    {
      localaoxk.a(paramString.substring(0, i));
      QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localaoxk.a());
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
        localaoxk.b(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localaoxk.b());
        paramString = localaoxk;
        if (arrayOfString1.length != 2) {
          break;
        }
        arrayOfString1 = arrayOfString1[1].split("&");
        i = 0;
        label188:
        paramString = localaoxk;
        if (i >= arrayOfString1.length) {
          break;
        }
        paramString = arrayOfString1[i].split("=");
        if (paramString.length != 2) {}
      }
      try
      {
        paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
        localaoxk.a(paramString[0], paramString[1]);
        i += 1;
        break label188;
        localaoxk.a(paramString);
        QLog.d("JumpParserUtil", 1, "parseUrl scheme is: " + localaoxk.a());
        return localaoxk;
        label278:
        paramString = paramString.substring(i + 3);
        continue;
        localaoxk.b(arrayOfString2[0]);
        localaoxk.c(paramString.substring(paramString.indexOf("/") + 1));
        QLog.d("JumpParserUtil", 1, "parseUrl server is: " + localaoxk.b() + " action is: " + localaoxk.c());
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
    this.jdField_a_of_type_JavaUtilArrayList.add(new aoxi(paramString, paramClass));
  }
  
  public ArrayList<aoxi> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public aoxg b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
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
    aoxh localaoxh = aoxj.a((aoxk)localObject, a());
    if (localaoxh != null)
    {
      QLog.d("JumpParserUtil", 1, "doParse, prepare to parse url: " + paramString);
      return localaoxh.a(paramQQAppInterface, paramContext, paramString, (aoxk)localObject);
    }
    QLog.d("JumpParserUtil", 1, "doParse error: jumpParser not register, handle with old method:" + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxl
 * JD-Core Version:    0.7.0.1
 */