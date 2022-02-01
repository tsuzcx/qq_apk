package com.tencent.featuretoggle.hltxkg.common.a;

import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.c.b.a.b;
import com.tencent.featuretoggle.hltxkg.common.c.d;
import com.tencent.featuretoggle.hltxkg.common.c.f;
import com.tencent.featuretoggle.hltxkg.common.c.j;
import com.tencent.featuretoggle.hltxkg.common.e.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class i
{
  private ThreadPoolExecutor a;
  
  private i()
  {
    StringBuilder localStringBuilder = new StringBuilder("halley_");
    localStringBuilder.append(com.tencent.featuretoggle.hltxkg.common.a.c());
    localStringBuilder.append("_");
    localStringBuilder.append("BusinessTaskPool");
    this.a = ((ThreadPoolExecutor)Executors.newCachedThreadPool(new com.tencent.featuretoggle.hltxkg.common.a.a.a(localStringBuilder.toString())));
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      String str2 = a(paramString, com.tencent.featuretoggle.hltxkg.common.a.c());
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = a(paramString, 0);
      }
      i = Integer.parseInt(str1);
    }
    catch (Throwable paramString)
    {
      int i;
      label38:
      break label38;
    }
    i = paramInt3;
    return c.a(i, paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    int i = 2;
    if (paramInt1 == 2) {
      return b(paramString, paramInt2);
    }
    if (("HLHttpDirect".equals(paramString)) && (paramMap != null) && ("event".equals((String)paramMap.get("B15")))) {
      return b(paramString, paramInt2);
    }
    if ("HLConnEvent".equals(paramString))
    {
      if (paramInt2 == 0)
      {
        paramString = "report_conn_succ_denominator_value";
      }
      else
      {
        if ((paramInt2 != -4) && (paramInt2 != -3) && (paramInt2 != -288)) {
          paramInt1 = 0;
        } else {
          paramInt1 = 1;
        }
        if (paramInt1 != 0) {
          paramString = "report_conn_nonet_fail_denominator_value";
        } else {
          paramString = "report_conn_other_fail_denominator_value";
        }
      }
      if (paramInt2 != 0) {}
    }
    label214:
    do
    {
      for (;;)
      {
        paramInt1 = 100;
        break label214;
        if ((paramInt2 != -4) && (paramInt2 != -3) && (paramInt2 != -288)) {
          paramInt1 = 0;
        } else {
          paramInt1 = 1;
        }
        paramMap = paramString;
        if (paramInt1 == 0) {
          do
          {
            paramInt1 = 1;
            paramString = paramMap;
            break label214;
            if (!"HLSecurityEvent".equals(paramString)) {
              break;
            }
            if (paramInt2 == 0) {
              paramString = "report_security_req_succ_denominator_value";
            } else {
              paramString = "report_security_req_fail_denominator_value";
            }
            paramMap = paramString;
          } while (paramInt2 != 0);
        }
      }
      if ("HLDisconnEvent".equals(paramString))
      {
        paramString = "report_disconn_denominator_value";
        paramInt1 = i;
        paramInt2 = -1;
        break;
      }
      if ((!"HLReqRspEvent".equals(paramString)) && (!"HLHttpAgent".equals(paramString)) && (!"HLHttpDirect".equals(paramString)))
      {
        if ("HLPushEvent".equals(paramString))
        {
          paramString = "report_push_denominator_value";
          paramInt2 = -1;
          paramInt1 = 10;
          break;
        }
        if ("B_DLSDK_Result".equals(paramString)) {
          paramString = "report_mass_download_denominator_value";
        }
        for (;;)
        {
          paramInt2 = -1;
          paramInt1 = 1;
          break label495;
          if ("HLDownTiny".equals(paramString))
          {
            paramString = "report_ease_download_denominator_value";
            break;
          }
          if ((!"HLMsgClickEvent".equals(paramString)) && (!"HLMsgProcessEvent".equals(paramString)) && (!"HLMsgDispatchEvent".equals(paramString)))
          {
            paramString = "";
            paramInt2 = 0;
            paramInt1 = 0;
            break label495;
          }
          if (paramInt2 == 0) {
            paramString = "report_msg_push_succ_denominator_value";
          } else {
            paramString = "report_msg_push_fail_denominator_value";
          }
        }
      }
      if ((paramInt2 == 0) && (paramMap != null) && (com.tencent.featuretoggle.hltxkg.common.d.a.a(paramString, paramInt1, paramMap)))
      {
        paramMap.put("B28", "1");
        paramString = "report_req_ssl_first_denominator_value";
        paramInt2 = -1;
        paramInt1 = 100;
        break;
      }
      if (paramInt2 == 0)
      {
        paramString = "report_req_succ_denominator_value";
      }
      else
      {
        if ((paramInt2 != -4) && (paramInt2 != -3) && (paramInt2 != -288)) {
          paramInt1 = 0;
        } else {
          paramInt1 = 1;
        }
        if (paramInt1 != 0) {
          paramString = "report_req_nonet_fail_denominator_value";
        } else {
          paramString = "report_req_other_fail_denominator_value";
        }
      }
    } while (paramInt2 == 0);
    for (;;)
    {
      if ((paramInt2 != -4) && (paramInt2 != -3) && (paramInt2 != -288)) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      paramMap = paramString;
      if (paramInt1 == 0) {
        break;
      }
    }
    label495:
    if (paramInt2 == -1)
    {
      paramInt2 = a("report_all_events", -1, 1, 1);
      if (paramInt2 == 1) {
        return 1;
      }
      if (paramInt2 == -1) {
        return 0;
      }
      return a(paramString, 0, 2147483647, paramInt1);
    }
    return paramInt2;
  }
  
  public static i a()
  {
    return i.a.a();
  }
  
  private static String a(String paramString, int paramInt)
  {
    String str1 = b.a().a(e.b());
    String str2 = j.a(e.e());
    return f.d().e().a(paramString, paramInt, com.tencent.featuretoggle.hltxkg.common.a.d(), com.tencent.featuretoggle.hltxkg.common.a.a, str1, str2);
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (paramInt <= 2147483647)
      {
        bool1 = bool2;
        if (new Random().nextInt(paramInt) == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    if (!paramString.startsWith(":"))
    {
      if (!paramString.contains(":")) {
        return false;
      }
      paramString = paramString.split(":")[0];
    }
    try
    {
      int i = Integer.parseInt(paramString, 16);
      if (i >= 0)
      {
        if (i > 65535) {
          return false;
        }
        if ((i >> 13 ^ 0x1) == 0) {
          return true;
        }
      }
      return false;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  private static int b(String paramString, int paramInt)
  {
    if (paramString.equals("HLDisconnEvent")) {
      return -2;
    }
    int j = 1;
    int i;
    if (paramInt != 0)
    {
      if ((paramInt != -4) && (paramInt != -3) && (paramInt != -288)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        paramString = "self_report_fail_denominator_value";
        break label63;
      }
    }
    paramString = "self_report_succ_denominator_value";
    label63:
    if (paramInt != 0)
    {
      i = j;
      if (paramInt != -4)
      {
        i = j;
        if (paramInt != -3) {
          if (paramInt == -288) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      if (i == 0)
      {
        paramInt = 2;
        break label112;
      }
    }
    paramInt = 100;
    label112:
    return a(paramString, 0, 2147483647, paramInt);
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split("\\.");
    if (paramString.length != 4) {
      return false;
    }
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = paramString[i];
      }
      try
      {
        int k = Integer.parseInt(str);
        if (k >= 0)
        {
          if (k > 255) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return true;
    return false;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool = paramString.contains("::");
    if ((bool) && (paramString.indexOf("::") != paramString.lastIndexOf("::"))) {
      return false;
    }
    if (((paramString.startsWith(":")) && (!paramString.startsWith("::"))) || ((paramString.endsWith(":")) && (!paramString.endsWith("::")))) {
      return false;
    }
    String[] arrayOfString = paramString.split(":");
    Object localObject = arrayOfString;
    if (bool)
    {
      localObject = new ArrayList(Arrays.asList(arrayOfString));
      if (paramString.endsWith("::")) {
        ((List)localObject).add("");
      } else if ((paramString.startsWith("::")) && (!((List)localObject).isEmpty())) {
        ((List)localObject).remove(0);
      }
      localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    }
    if (localObject.length > 8) {
      return false;
    }
    int k = 0;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (k < localObject.length)
      {
        paramString = localObject[k];
        if (paramString.length() == 0)
        {
          int m = i + 1;
          i = m;
          if (m > 1) {
            return false;
          }
        }
        else
        {
          if ((k == localObject.length - 1) && (paramString.contains(".")))
          {
            if (!b(paramString)) {
              return false;
            }
            j += 2;
            i = 0;
            break label294;
          }
          if (paramString.length() > 4) {
            return false;
          }
        }
      }
      try
      {
        i = Integer.parseInt(paramString, 16);
        if (i >= 0)
        {
          if (i > 65535) {
            return false;
          }
          i = 0;
          j += 1;
          label294:
          k += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    if (j <= 8) {
      return (j >= 8) || (bool);
    }
    return false;
    return false;
  }
  
  public final ThreadPoolExecutor b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.i
 * JD-Core Version:    0.7.0.1
 */