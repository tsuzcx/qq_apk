package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.av.utils.ShareUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpActionLegacy;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public class JumpActionLegacyParser
{
  @Nullable
  public static JumpAction a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.contains("videochat"))
    {
      str = paramString;
      if (paramString.contains("uinType=21")) {
        str = URLDecoder.decode(paramString);
      }
    }
    if ((QQAudioHelper.b()) && (QQAudioHelper.a(8) == 1) && (str.startsWith("mqqconferenceflyticket://"))) {
      paramString = "mqqavshare://avshare/forward?url=https%3a%2f%2fwww.baidu.com%2fs%3fwd%3dabc%26rsv_spt%3d1&exp=1566906601";
    } else {
      paramString = str;
    }
    if (paramString.startsWith("mqqavshare://")) {
      return ShareUtils.a(new JumpActionLegacy((QQAppInterface)paramBaseQQAppInterface, paramContext), paramContext, paramString);
    }
    if (paramString.startsWith("mqqapi://qzone/groupalbum"))
    {
      Object localObject = paramString.split("\\?");
      if (localObject.length != 2) {
        return null;
      }
      str = localObject[0];
      localObject = localObject[1];
      paramBaseQQAppInterface = new JumpActionLegacy((QQAppInterface)paramBaseQQAppInterface, paramContext);
      paramContext = str.substring(9).split("/");
      if (paramContext.length != 2) {
        return null;
      }
      paramBaseQQAppInterface.a = paramString;
      paramBaseQQAppInterface.b = paramContext[0];
      paramBaseQQAppInterface.c = paramContext[1];
      paramContext = ((String)localObject).split("&");
      int i = 0;
      while (i < paramContext.length)
      {
        paramString = paramContext[i].split("=");
        if (paramString.length == 2)
        {
          try
          {
            paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("failed to decode param value,tmps[1] is:");
              ((StringBuilder)localObject).append(paramString[0]);
              ((StringBuilder)localObject).append(",tmps[1] is:");
              ((StringBuilder)localObject).append(paramString[1]);
              QLog.d("JumpAction", 2, ((StringBuilder)localObject).toString(), localException);
            }
          }
          paramBaseQQAppInterface.a(paramString[0], paramString[1]);
        }
        i += 1;
      }
      return paramBaseQQAppInterface;
    }
    return a((QQAppInterface)paramBaseQQAppInterface, paramContext, localException, paramString);
  }
  
  private static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = paramString2.startsWith("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity");
    boolean bool3 = paramString2.startsWith("mqqapi://readingcenter");
    boolean bool6 = paramString2.startsWith(" mqqapi://qqreader");
    boolean bool4 = paramString2.startsWith("wtloginmqq://");
    boolean bool5 = paramString2.startsWith("mqqwpa://");
    boolean bool7 = paramString2.startsWith("mqqtribe://");
    boolean bool8 = paramString2.startsWith("mqqverifycode://");
    boolean bool9 = paramString2.startsWith("mqqdevlock://");
    int i;
    if ((paramString2.startsWith("mqqapi://im/chat")) && (paramString2.contains("chat_type=crm")) && (paramString2.contains("kfnick="))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramString2.startsWith("mqqapi://card/show_pslcard")) && (paramString2.contains("card_type=troopmember"))) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((paramString2.startsWith("mqqapi://qstory")) && (paramString2.contains("topicid="))) {
      k = 1;
    } else {
      k = 0;
    }
    boolean bool10 = paramString2.startsWith("mqqapi://qqcomic/");
    boolean bool11 = a(paramString2);
    boolean bool1 = paramString2.startsWith("mqqconferenceflyticket://");
    int m;
    if ((paramString2.startsWith("mqqapi://readinjoy")) && (paramString2.contains("readinjoyNotDecodeUrl=1"))) {
      m = 1;
    } else {
      m = 0;
    }
    boolean bool12 = a(new boolean[] { paramString1.startsWith("mqqopensdkapi://bizAgent/") ^ true, bool3 ^ true, bool4 ^ true, bool5 ^ true, bool7 ^ true, bool2 ^ true, j ^ 0x1, bool11 ^ true, bool10 ^ true, k ^ 0x1, m ^ 0x1 });
    Object localObject = null;
    String str1;
    if (bool12)
    {
      if ((!bool3) && (i == 0) && (!bool1)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString2 = JumpParser.a(paramString1, bool1);
      str1 = paramString2;
      if (paramString2 == null) {
        return null;
      }
    }
    else
    {
      str1 = paramString2;
    }
    bool2 = false;
    String[] arrayOfString = a(str1, new boolean[] { bool6, bool3, bool4, bool5, bool7, bool8, bool9, bool11, bool10 });
    String str2 = arrayOfString[0];
    paramString2 = localObject;
    if (arrayOfString.length > 1) {
      paramString2 = arrayOfString[1];
    }
    if ((paramString2 != null) && (bool12) && (!str2.startsWith("mqqconferenceflyticket://")))
    {
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      paramString2 = JumpParser.a(paramString2, bool1);
    }
    return a(paramQQAppInterface, paramContext, paramString1, str1, str2, paramString2, arrayOfString, bool4, bool3, bool5);
  }
  
  private static JumpAction a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    JumpActionLegacy localJumpActionLegacy = new JumpActionLegacy(paramQQAppInterface, paramContext);
    if (paramString2.startsWith("mqqapi://now/openroom"))
    {
      localJumpActionLegacy.a = paramString2;
      paramContext = paramString2;
      paramArrayOfString = paramString3;
    }
    else
    {
      paramContext = paramString2;
      paramArrayOfString = paramString3;
      if (paramString2.startsWith("nowmqqapi://now/openroom"))
      {
        paramContext = Uri.parse(paramString2).buildUpon().scheme("mqqapi").build().toString();
        paramArrayOfString = Uri.parse(paramString3).buildUpon().scheme("mqqapi").build().toString();
        localJumpActionLegacy.a = paramContext;
      }
    }
    boolean bool = paramArrayOfString.startsWith("mqqopensdkapi://bizAgent/");
    paramString2 = "";
    if (bool)
    {
      paramQQAppInterface = paramArrayOfString.substring(25);
      localJumpActionLegacy.a("attr_original_url", paramString1);
    }
    else if (paramArrayOfString.startsWith("http://qm.qq.com/cgi-bin/"))
    {
      paramQQAppInterface = paramArrayOfString.substring(25);
      localJumpActionLegacy.a("attr_original_url", paramString1);
    }
    else if (paramArrayOfString.startsWith("http://clientui.3g.qq.com/mqqapi/"))
    {
      paramQQAppInterface = paramArrayOfString.substring(33);
    }
    else if (paramArrayOfString.startsWith("http://clientui.3g.qq.com/mqq/"))
    {
      paramQQAppInterface = paramArrayOfString.substring(30);
    }
    else
    {
      try
      {
        paramString1 = new ArrayList(Arrays.asList(new String[] { "mqqapi://", "qqstory://", "mqq://", "mqqflyticket://", "mqqwpa://", "wtloginmqq://", "mqqtribe://", "mqqverifycode://", "mqqconnect://", "mqqdevlock://", "mqqconferenceflyticket://" }));
        i = paramArrayOfString.indexOf("://");
        paramQQAppInterface = paramString2;
        if (i > 0)
        {
          i += 3;
          paramQQAppInterface = paramString2;
          if (paramString1.contains(paramArrayOfString.substring(0, i))) {
            paramQQAppInterface = paramArrayOfString.substring(i);
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramString1 = new StringBuilder();
        paramString1.append("jumpParser error: ");
        paramString1.append(paramQQAppInterface.getMessage());
        QLog.e("JumpAction", 1, paramString1.toString());
        paramQQAppInterface = paramString2;
      }
    }
    paramQQAppInterface = paramQQAppInterface.split("/");
    if (paramQQAppInterface.length != 2) {
      return null;
    }
    localJumpActionLegacy.a = paramContext;
    localJumpActionLegacy.b = paramQQAppInterface[0];
    localJumpActionLegacy.c = paramQQAppInterface[1];
    if (paramString4 == null) {
      return localJumpActionLegacy;
    }
    if (paramBoolean1)
    {
      paramQQAppInterface = paramString4.split("&");
      i = 0;
      while (i < paramQQAppInterface.length)
      {
        paramContext = JumpParser.a(paramQQAppInterface[i], paramBoolean2 ^ true);
        int j = paramContext.indexOf('=');
        if (j > 0) {
          localJumpActionLegacy.a(paramContext.substring(0, j), paramContext.substring(j + 1, paramContext.length()));
        }
        i += 1;
      }
    }
    paramQQAppInterface = paramString4.split("&");
    int i = 0;
    while (i < paramQQAppInterface.length)
    {
      paramContext = JumpParser.a(paramQQAppInterface[i], "=");
      if (paramContext.length == 2) {
        if (paramBoolean3) {
          localJumpActionLegacy.a(paramContext[0], JumpParser.a(paramContext[1], false));
        } else {
          localJumpActionLegacy.a(paramContext[0], paramContext[1]);
        }
      }
      i += 1;
    }
    return localJumpActionLegacy;
  }
  
  private static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = JumpParser.a(paramString, false);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("gamecenter\\s*=\\s*1").matcher(paramString).find();
  }
  
  private static boolean a(boolean... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i] == 0) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    QLog.e("JumpAction", 1, "judgeNeedDecodeUrlByParam error: params are null");
    return false;
  }
  
  private static String[] a(String paramString, boolean... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i] != 0) {
          return JumpParser.a(paramString, "?");
        }
        i += 1;
      }
      return paramString.split("\\?");
    }
    QLog.e("JumpAction", 1, "parseDefaultBodyArray: params are empty");
    return paramString.split("\\?");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActionLegacyParser
 * JD-Core Version:    0.7.0.1
 */