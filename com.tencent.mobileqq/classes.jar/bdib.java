import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bdib
{
  public static bdhk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "Jump input=" + paramString);
    }
    if (paramString == null) {
      paramQQAppInterface = null;
    }
    Object localObject1;
    String str2;
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          if (paramString.startsWith("mqqapi://qqidentifier/web"))
          {
            paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
            paramQQAppInterface.a = paramString;
            paramQQAppInterface.b = "qqidentifier";
            paramQQAppInterface.c = "web";
            paramContext = paramString.split("\\?");
            if (paramContext.length != 2) {
              return paramQQAppInterface;
            }
            paramContext = paramContext[1].split("&");
            i = 0;
            while (i < paramContext.length)
            {
              paramString = paramContext[i].split("=");
              if (paramString.length == 2) {
                paramQQAppInterface.a(paramString[0], paramString[1]);
              }
              i += 1;
            }
            return paramQQAppInterface;
          }
          if (!paramString.startsWith("mqqapi://groupopenapp/openapp")) {
            break;
          }
          paramContext = new bdhk(paramQQAppInterface, paramContext);
          paramContext.a = paramString;
          paramContext.b = "groupopenapp";
          paramContext.c = "openapp";
          paramString = paramString.split("\\?");
          paramQQAppInterface = paramContext;
        } while (paramString.length != 2);
        paramString = paramString[1].split("&");
        j = paramString.length;
        i = 0;
        for (;;)
        {
          paramQQAppInterface = paramContext;
          if (i >= j) {
            break;
          }
          paramQQAppInterface = paramString[i].split("=");
          if (paramQQAppInterface.length == 2) {
            paramContext.a(paramQQAppInterface[0], paramQQAppInterface[1]);
          }
          i += 1;
        }
        if (!paramString.startsWith("mqqapi://commonBuddyGroup/commonBuddyGroup")) {
          break;
        }
        paramContext = new bdhk(paramQQAppInterface, paramContext);
        paramContext.a = paramString;
        paramContext.b = "commonBuddyGroup";
        paramContext.c = "open";
        paramString = paramString.split("\\?");
        paramQQAppInterface = paramContext;
      } while (paramString.length != 2);
      paramString = paramString[1].split("&");
      j = paramString.length;
      i = 0;
      for (;;)
      {
        paramQQAppInterface = paramContext;
        if (i >= j) {
          break;
        }
        paramQQAppInterface = paramString[i].split("=");
        if (paramQQAppInterface.length == 2) {
          paramContext.a(paramQQAppInterface[0], paramQQAppInterface[1]);
        }
        i += 1;
      }
      if (paramString.startsWith("mqqapi://manage_troop/main_page"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "manage_troop";
        paramQQAppInterface.c = "main_page";
        paramContext = paramString.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        i = 0;
        while (i < paramContext.length)
        {
          paramString = paramContext[i].split("=");
          if (paramString.length == 2) {
            paramQQAppInterface.a(paramString[0], paramString[1]);
          }
          i += 1;
        }
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://nearby_entry/nearby_feed"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "nearby_entry";
        paramQQAppInterface.c = "nearby_feed";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://now/playmedia"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "now";
        paramQQAppInterface.c = "playmedia";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://wsgzh/waterfall"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "wsgzh";
        paramQQAppInterface.c = "waterfall";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://wsgzh/miniapp_player"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "wsgzh";
        paramQQAppInterface.c = "miniapp_player";
        paramContext = paramString.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        i = 0;
        for (;;)
        {
          if (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if (paramString.length == 2) {}
            try
            {
              paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
              paramQQAppInterface.a(paramString[0], paramString[1]);
              i += 1;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException1);
                }
              }
            }
          }
        }
        return paramQQAppInterface;
      }
      if ((paramString.startsWith("mqqzone")) || (paramString.startsWith("mqqapi://qzoneschema")))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "qzone_schema";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://qzone/publicaccount"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "qzone_publicaccount";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://qboss/loader"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "qboss";
        paramQQAppInterface.c = "qboss_load";
        paramContext = paramString.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        i = 0;
        for (;;)
        {
          if (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if (paramString.length == 2) {}
            try
            {
              paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
              paramQQAppInterface.a(paramString[0], paramString[1]);
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException2);
                }
              }
            }
          }
        }
        return paramQQAppInterface;
      }
      if (paramString.startsWith("qqfav://operation/"))
      {
        str1 = Uri.parse(paramString).getLastPathSegment();
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "com.qqfav";
        paramQQAppInterface.c = str1;
        return paramQQAppInterface;
      }
      if ((paramString.startsWith("mqq://shop/apollo_store")) || (paramString.startsWith("mqqapi://shop/apollo_store")))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "shop";
        paramQQAppInterface.c = "apollo_store";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://cmshow/game_invite"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "cmshow";
        paramQQAppInterface.c = "game_invite";
        return paramQQAppInterface;
      }
      if (paramString.startsWith("mqqapi://assistant_setting/ASSISTANT_SETTING"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = paramString;
        paramQQAppInterface.b = "assistant_setting";
        paramQQAppInterface.c = "ASSISTANT_SETTING";
        return paramQQAppInterface;
      }
      String str1 = paramString;
      if (paramString.contains("videochat"))
      {
        str1 = paramString;
        if (paramString.contains("uinType=21")) {
          str1 = URLDecoder.decode(paramString);
        }
      }
      if (str1.startsWith("mqqapi://qzone/to_publish_queue"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "to_publish_queue";
        return paramQQAppInterface;
      }
      if ((str1.startsWith("mqqapi://qzone/to_friend_feeds")) || (str1.startsWith("mqqapi://qzone/activefeed")))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "to_friend_feeds";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qzone/open_homepage"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "open_homepage";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://ftssearch/tab"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "ftssearch";
        paramQQAppInterface.c = "tab";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://ftssearch/openmixweb"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "ftssearch";
        paramQQAppInterface.c = "openmixweb";
        paramContext = str1.replace("mqqapi://ftssearch/openmixweb?", "").replace("^?", "").split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qzone/to_qzone_dialog"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "to_qzone_dialog";
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qzone/to_redpocket_share"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qzone";
        paramQQAppInterface.c = "to_redpocket_share";
        return paramQQAppInterface;
      }
      if (str1.startsWith("qapp://"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qapp";
        paramQQAppInterface.c = Uri.parse(str1).getHost();
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qqreg"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.b = "qqreg";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://microapp/open?"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "microapp";
        paramQQAppInterface.c = "open";
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "[miniapp-scheme], open microapp scheme=" + str1);
        }
        paramContext = str1.split("\\?");
        if ((paramContext.length < 2) || (paramContext[0].length() == 0)) {
          return paramQQAppInterface;
        }
        paramContext = str1.substring(paramContext[0].length() + 1).split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2))
            {
              paramQQAppInterface.a(paramString[0], paramString[1]);
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "[miniapp-scheme], open microapp key=" + paramString[0] + ", value=" + paramString[1]);
              }
            }
            i += 1;
          }
        }
        paramContext = paramQQAppInterface.b("fakeUrl");
        if ((TextUtils.isEmpty(paramQQAppInterface.b("scene"))) && (!TextUtils.isEmpty(paramContext))) {
          paramQQAppInterface.a("scene", String.valueOf(2003));
        }
        return paramQQAppInterface;
      }
      if ((str1.startsWith("mqqapi://miniapp/open?")) || (str1.startsWith("mqqapi://miniapp/adopen")))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "miniapp";
        paramQQAppInterface.c = "open";
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://buscard/open"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "buscard";
        paramQQAppInterface.c = "open";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://wxminiapp/launch"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "wxminiapp";
        paramQQAppInterface.c = "launch";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qqnotify/subscribe"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qqnotify";
        paramQQAppInterface.c = "subscribe";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://qqnotify/open"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "qqnotify";
        paramQQAppInterface.c = "open";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://wallet/open"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "wallet";
        paramQQAppInterface.c = "open";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqmdpass://wallet/modify_pass"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "wallet";
        paramQQAppInterface.c = "modify_pass";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://asyncmsg/showdetail?"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "asyncmsg";
        paramQQAppInterface.c = "open_async_detail";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://schedule/showDetail?"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "schedule";
        paramQQAppInterface.c = "showDetail";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (str1.startsWith("mqqapi://huayang"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = str1;
        paramQQAppInterface.b = "huayang";
        paramQQAppInterface.c = "open";
        paramContext = str1.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        i = 0;
        for (;;)
        {
          if (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if (paramString.length == 2) {}
            try
            {
              paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
              paramQQAppInterface.a(paramString[0], paramString[1]);
              i += 1;
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException3);
                }
              }
            }
          }
        }
        return paramQQAppInterface;
      }
      if (localException3.startsWith("mqqapi://od"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException3;
        paramQQAppInterface.b = "od";
        paramQQAppInterface.c = "openroom";
        paramContext = localException3.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException3.startsWith("mqqapi://0odAddFriend"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException3;
        paramQQAppInterface.b = "odAddFriend";
        paramQQAppInterface.c = "addFriend";
        paramContext = localException3.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException3.startsWith("mqqapi://teamwork/opendoclist"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException3;
        paramQQAppInterface.b = "teamwork";
        paramQQAppInterface.c = "opendoclist";
        return paramQQAppInterface;
      }
      if ((localException3.startsWith("mqqapi://qstory/opencontent")) || (localException3.startsWith("qqstory://qstory/opencontent")))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException3;
        paramQQAppInterface.b = "qstory";
        paramQQAppInterface.c = "opencontent";
        paramContext = localException3.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException3.startsWith("mqqapi://contact/add"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException3;
        paramQQAppInterface.b = "contact";
        paramQQAppInterface.c = "add";
        paramContext = localException3.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException3.startsWith("mqqapi://profile/setting"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = localException3;
        paramQQAppInterface.b = "profile";
        paramQQAppInterface.c = "setting";
        paramContext = localException3.split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (localException3.startsWith("mqqapi://stickynote"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramContext = localException3.split("\\?");
        if (paramContext.length < 1) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[0].substring("mqqapi://".length()).split("/");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramQQAppInterface.a = localException3;
        paramQQAppInterface.b = paramContext[0];
        paramQQAppInterface.c = paramContext[1];
        paramContext = Uri.parse(localException3);
        paramString = paramContext.getQueryParameterNames().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (String)paramString.next();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            str2 = paramContext.getQueryParameter((String)localObject1);
            if (!TextUtils.isEmpty(str2)) {
              paramQQAppInterface.a(((String)localObject1).toLowerCase(), str2);
            }
          }
        }
        return paramQQAppInterface;
      }
      if (((String)localObject1).startsWith("mqqapi://groupvideo"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = ((String)localObject1);
        paramQQAppInterface.b = "groupvideo";
        if (((String)localObject1).contains("openroom")) {
          paramQQAppInterface.c = "openroom";
        }
        for (;;)
        {
          paramContext = ((String)localObject1).split("\\?");
          if (paramContext.length == 2) {
            break;
          }
          return paramQQAppInterface;
          if (((String)localObject1).contains("preload")) {
            paramQQAppInterface.c = "preload";
          }
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (((String)localObject1).startsWith("mqqapi://qwerewolf/enterHomePage"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = ((String)localObject1);
        paramQQAppInterface.b = "qwerewolf";
        paramQQAppInterface.c = "enterHomePage";
        paramContext = ((String)localObject1).split("\\?");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[1].split("&");
        if (paramContext != null)
        {
          i = 0;
          while (i < paramContext.length)
          {
            paramString = paramContext[i].split("=");
            if ((paramString != null) && (paramString.length == 2)) {
              paramQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
        }
        return paramQQAppInterface;
      }
      if (((String)localObject1).startsWith("mqqapi://lightapp/open"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramQQAppInterface.a = ((String)localObject1);
        paramQQAppInterface.b = "lightapp";
        paramQQAppInterface.c = "open";
        paramContext = Uri.parse((String)localObject1);
        paramString = paramContext.getQueryParameterNames().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (String)paramString.next();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            str2 = paramContext.getQueryParameter((String)localObject1);
            if (!TextUtils.isEmpty(str2)) {
              paramQQAppInterface.a((String)localObject1, str2);
            }
          }
        }
        return paramQQAppInterface;
      }
      if (((String)localObject1).startsWith("mqqapi://qsubscribe"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramContext = ((String)localObject1).split("\\?");
        if (paramContext.length < 1) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[0].substring("mqqapi://".length()).split("/");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramQQAppInterface.a = ((String)localObject1);
        paramQQAppInterface.b = paramContext[0];
        paramQQAppInterface.c = paramContext[1];
        paramContext = Uri.parse((String)localObject1);
        paramString = paramContext.getQueryParameterNames().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (String)paramString.next();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            str2 = paramContext.getQueryParameter((String)localObject1);
            if (!TextUtils.isEmpty(str2)) {
              paramQQAppInterface.a(((String)localObject1).toLowerCase(), str2);
            }
          }
        }
        return paramQQAppInterface;
      }
      if (((String)localObject1).startsWith("mqqapi://qcircle"))
      {
        paramQQAppInterface = new bdhk(paramQQAppInterface, paramContext);
        paramContext = ((String)localObject1).split("\\?");
        if (paramContext.length < 1) {
          return paramQQAppInterface;
        }
        paramContext = paramContext[0].substring("mqqapi://".length()).split("/");
        if (paramContext.length != 2) {
          return paramQQAppInterface;
        }
        paramQQAppInterface.a = ((String)localObject1);
        paramQQAppInterface.b = paramContext[0];
        paramQQAppInterface.c = paramContext[1];
        paramContext = Uri.parse((String)localObject1);
        paramString = paramContext.getQueryParameterNames().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (String)paramString.next();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            str2 = paramContext.getQueryParameter((String)localObject1);
            if (!TextUtils.isEmpty(str2)) {
              paramQQAppInterface.a(((String)localObject1).toLowerCase(), str2);
            }
          }
        }
        return paramQQAppInterface;
      }
      if (!((String)localObject1).startsWith("mqqapi://troop_homework/publish")) {
        break;
      }
      paramContext = new bdhk(paramQQAppInterface, paramContext);
      paramContext.a = ((String)localObject1);
      paramContext.b = "troop_homework";
      paramContext.c = "publish";
      paramString = ((String)localObject1).split("\\?");
      paramQQAppInterface = paramContext;
    } while (paramString.length != 2);
    paramString = paramString[1].split("&");
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      paramQQAppInterface = paramContext;
      if (i >= j) {
        break;
      }
      paramQQAppInterface = paramString[i].split("=");
      if (paramQQAppInterface.length == 2) {
        paramContext.a(paramQQAppInterface[0], paramQQAppInterface[1]);
      }
      i += 1;
    }
    if ((AudioHelper.d()) && (AudioHelper.a(8) == 1) && (((String)localObject1).startsWith("mqqconferenceflyticket://"))) {}
    for (paramString = "mqqavshare://avshare/forward?url=https%3a%2f%2fwww.baidu.com%2fs%3fwd%3dabc%26rsv_spt%3d1&exp=1566906601";; paramString = localException4)
    {
      if (paramString.startsWith("mqqavshare://")) {
        return max.a(paramQQAppInterface, paramContext, paramString);
      }
      String str3;
      if (paramString.startsWith("mqqapi://qzone/groupalbum"))
      {
        localObject1 = paramString.split("\\?");
        if (localObject1.length != 2) {
          return null;
        }
        str3 = localObject1[0];
        str2 = localObject1[1];
        localObject1 = "";
        paramContext = new bdhk(paramQQAppInterface, paramContext);
        if (str3.startsWith("mqqopensdkapi://bizAgent/")) {
          paramQQAppInterface = str3.substring("mqqopensdkapi://bizAgent/".length());
        }
        for (;;)
        {
          paramQQAppInterface = paramQQAppInterface.split("/");
          if (paramQQAppInterface.length == 2) {
            break;
          }
          return null;
          if (str3.startsWith("http://qm.qq.com/cgi-bin/"))
          {
            paramQQAppInterface = str3.substring("http://qm.qq.com/cgi-bin/".length());
          }
          else if (str3.startsWith("http://clientui.3g.qq.com/mqqapi/"))
          {
            paramQQAppInterface = str3.substring("http://clientui.3g.qq.com/mqqapi/".length());
          }
          else if (str3.startsWith("mqqapi://"))
          {
            paramQQAppInterface = str3.substring("mqqapi://".length());
          }
          else if (str3.startsWith("qqstory://"))
          {
            paramQQAppInterface = str3.substring("qqstory://".length());
          }
          else if (str3.startsWith("mqq://"))
          {
            paramQQAppInterface = str3.substring("mqq://".length());
          }
          else if (str3.startsWith("http://clientui.3g.qq.com/mqq/"))
          {
            paramQQAppInterface = str3.substring("http://clientui.3g.qq.com/mqq/".length());
          }
          else if (str3.startsWith("mqqflyticket://"))
          {
            paramQQAppInterface = str3.substring("mqqflyticket://".length());
          }
          else if (str3.startsWith("mqqwpa://"))
          {
            paramQQAppInterface = str3.substring("mqqwpa://".length());
          }
          else if (str3.startsWith("wtloginmqq://"))
          {
            paramQQAppInterface = str3.substring("wtloginmqq://".length());
          }
          else if (str3.startsWith("mqqtribe://"))
          {
            paramQQAppInterface = str3.substring("mqqtribe://".length());
          }
          else if (str3.startsWith("qapp://"))
          {
            paramQQAppInterface = str3.substring("qapp://".length());
          }
          else
          {
            paramQQAppInterface = (QQAppInterface)localObject1;
            if (str3.startsWith("mqqconferenceflyticket://")) {
              paramQQAppInterface = str3.substring("mqqconferenceflyticket://".length());
            }
          }
        }
        paramContext.a = paramString;
        paramContext.b = paramQQAppInterface[0];
        paramContext.c = paramQQAppInterface[1];
        paramQQAppInterface = str2.split("&");
        i = 0;
        for (;;)
        {
          if (i < paramQQAppInterface.length)
          {
            paramString = paramQQAppInterface[i].split("=");
            if (paramString.length == 2) {}
            try
            {
              paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
              paramContext.a(paramString[0], paramString[1]);
              i += 1;
            }
            catch (Exception localException4)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JumpAction", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], localException4);
                }
              }
            }
          }
        }
        return paramContext;
      }
      boolean bool1 = paramString.startsWith("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity");
      boolean bool2 = paramString.startsWith("mqqapi://readingcenter");
      boolean bool5 = paramString.startsWith(" mqqapi://qqreader");
      boolean bool3 = paramString.startsWith("wtloginmqq://");
      boolean bool4 = paramString.startsWith("mqqwpa://");
      boolean bool6 = paramString.startsWith("mqqtribe://");
      boolean bool7 = paramString.startsWith("mqqverifycode://");
      boolean bool8 = paramString.startsWith("mqqdevlock://");
      label5619:
      int k;
      label5642:
      boolean bool9;
      boolean bool10;
      if ((paramString.startsWith("mqqapi://im/chat")) && (paramString.contains("chat_type=crm")) && (paramString.contains("kfnick=")))
      {
        i = 1;
        if ((!paramString.startsWith("mqqapi://card/show_pslcard")) || (!paramString.contains("card_type=troopmember"))) {
          break label5810;
        }
        j = 1;
        if ((!paramString.startsWith("mqqapi://qstory")) || (!paramString.contains("topicid="))) {
          break label5816;
        }
        k = 1;
        bool9 = paramString.startsWith("mqqapi://qqcomic/");
        bool10 = a(paramString);
        boolean bool11 = paramString.startsWith("mqqconferenceflyticket://");
        int n = 0;
        int m = n;
        if (paramString.startsWith("mqqapi://readinjoy"))
        {
          m = n;
          if (paramString.contains("readinjoyNotDecodeUrl=1")) {
            m = 1;
          }
        }
        if ((localException4.startsWith("mqqopensdkapi://bizAgent/")) || (bool2) || (bool3) || (bool4) || (bool6) || (bool1) || (j != 0) || (bool10) || (bool9) || (k != 0) || (m != 0)) {
          break label5822;
        }
        j = 1;
        label5764:
        if (j == 0) {
          break label5834;
        }
        if ((bool2) || (i != 0) || (bool11)) {
          break label5828;
        }
      }
      label5810:
      label5816:
      label5822:
      label5828:
      for (bool1 = true;; bool1 = false)
      {
        str2 = a(localException4, bool1);
        paramString = str2;
        if (str2 != null) {
          break label5834;
        }
        return null;
        i = 0;
        break;
        j = 0;
        break label5619;
        k = 0;
        break label5642;
        j = 0;
        break label5764;
      }
      label5834:
      Object localObject2;
      if ((bool5) || (bool2) || (bool3) || (bool4) || (bool6) || (bool7) || (bool8) || (bool10) || (bool9))
      {
        localObject2 = a(paramString, "?");
        str3 = localObject2[0];
        str2 = null;
        if (localObject2.length > 1) {
          str2 = localObject2[1];
        }
        if ((str2 == null) || (j == 0) || (str3.startsWith("mqqconferenceflyticket://"))) {
          break label6666;
        }
        if ((bool2) || (i != 0)) {
          break label6042;
        }
        bool1 = true;
        label5943:
        str2 = a(str2, bool1);
      }
      label6658:
      label6666:
      for (;;)
      {
        localObject2 = new bdhk(paramQQAppInterface, paramContext);
        if (paramString.startsWith("mqqapi://now/openroom"))
        {
          ((bdhk)localObject2).a = paramString;
          paramQQAppInterface = str3;
          paramContext = paramString;
        }
        for (;;)
        {
          label5984:
          if (paramQQAppInterface.startsWith("mqqopensdkapi://bizAgent/"))
          {
            paramQQAppInterface = paramQQAppInterface.substring("mqqopensdkapi://bizAgent/".length());
            ((bdhk)localObject2).a("attr_original_url", localException4);
          }
          for (;;)
          {
            paramQQAppInterface = paramQQAppInterface.split("/");
            if (paramQQAppInterface.length != 2)
            {
              return null;
              localObject2 = paramString.split("\\?");
              break;
              label6042:
              bool1 = false;
              break label5943;
              if (!paramString.startsWith("nowmqqapi://now/openroom")) {
                break label6658;
              }
              paramContext = Uri.parse(paramString).buildUpon().scheme("mqqapi").build().toString();
              paramQQAppInterface = Uri.parse(str3).buildUpon().scheme("mqqapi").build().toString();
              ((bdhk)localObject2).a = paramContext;
              break label5984;
              if (paramQQAppInterface.startsWith("http://qm.qq.com/cgi-bin/"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("http://qm.qq.com/cgi-bin/".length());
                ((bdhk)localObject2).a("attr_original_url", localException4);
                continue;
              }
              if (paramQQAppInterface.startsWith("http://clientui.3g.qq.com/mqqapi/"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("http://clientui.3g.qq.com/mqqapi/".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("mqqapi://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("mqqapi://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("qqstory://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("qqstory://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("mqq://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("mqq://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("http://clientui.3g.qq.com/mqq/"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("http://clientui.3g.qq.com/mqq/".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("mqqflyticket://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("mqqflyticket://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("mqqwpa://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("mqqwpa://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("wtloginmqq://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("wtloginmqq://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("mqqtribe://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("mqqtribe://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("mqqverifycode://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("mqqverifycode://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("mqqconnect://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("mqqconnect://".length());
                continue;
              }
              if (paramQQAppInterface.startsWith("mqqdevlock://"))
              {
                paramQQAppInterface = paramQQAppInterface.substring("mqqdevlock://".length());
                continue;
              }
              if (!paramQQAppInterface.startsWith("mqqconferenceflyticket://")) {
                break label6652;
              }
              paramQQAppInterface = paramQQAppInterface.substring("mqqconferenceflyticket://".length());
              continue;
            }
            ((bdhk)localObject2).a = paramContext;
            ((bdhk)localObject2).b = paramQQAppInterface[0];
            ((bdhk)localObject2).c = paramQQAppInterface[1];
            if (str2 == null) {
              return localObject2;
            }
            if (bool3)
            {
              paramQQAppInterface = str2.split("&");
              i = 0;
              if (i < paramQQAppInterface.length)
              {
                paramContext = paramQQAppInterface[i];
                if (!bool2) {}
                for (bool1 = true;; bool1 = false)
                {
                  paramContext = a(paramContext, bool1);
                  j = paramContext.indexOf('=');
                  if (j > 0) {
                    ((bdhk)localObject2).a(paramContext.substring(0, j), paramContext.substring(j + 1, paramContext.length()));
                  }
                  i += 1;
                  break;
                }
              }
              return localObject2;
            }
            paramQQAppInterface = str2.split("&");
            i = 0;
            if (i < paramQQAppInterface.length)
            {
              paramContext = a(paramQQAppInterface[i], "=");
              if (paramContext.length == 2)
              {
                if (!bool4) {
                  break label6635;
                }
                ((bdhk)localObject2).a(paramContext[0], a(paramContext[1], false));
              }
              for (;;)
              {
                i += 1;
                break;
                label6635:
                ((bdhk)localObject2).a(paramContext[0], paramContext[1]);
              }
            }
            return localObject2;
            label6652:
            paramQQAppInterface = "";
          }
          paramQQAppInterface = str3;
          paramContext = paramString;
        }
      }
    }
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    try
    {
      String str2 = URLDecoder.decode(paramString);
      str1 = str2;
      if (paramBoolean)
      {
        localObject1 = str2;
        str1 = str2.replaceAll(" ", "+");
      }
    }
    catch (Exception localException)
    {
      do
      {
        String str1;
        Object localObject2 = localObject1;
      } while (!QLog.isColorLevel());
      QLog.d("JumpAction", 2, "JumpParser parser Exception =" + paramString);
    }
    return str1;
    return localObject1;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = a(paramString, false);
    } while ((TextUtils.isEmpty(paramString)) || (!Pattern.compile("gamecenter\\s*=\\s*1").matcher(paramString).find()));
    return true;
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new String[] { paramString1 };
    }
    return new String[] { paramString1.substring(0, i), paramString1.substring(i + paramString2.length(), paramString1.length()) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdib
 * JD-Core Version:    0.7.0.1
 */