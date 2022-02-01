package com.tencent.luggage.wxa.on;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static volatile Set<String> a = new HashSet();
  
  static
  {
    a.add("operateLivePlayer");
    a.add("operateLivePusher");
    a.add("operateXWebLivePlayer");
    a.add("operateXWebLivePusher");
    Collections.addAll(a, new String[] { "joinVoIPChat", "exitVoIPChat", "onVoIPChatMembersChanged", "onVoIPChatSpeakersChanged", "onVoIPChatInterrupted", "updateVoIPChatMuteConfig", "insertVoIPView", "updateVoIPView", "removeVoIPView" });
  }
  
  static int a(c paramc, String paramString1, String paramString2)
  {
    if (!a(paramc, paramString1)) {
      return -2147483648;
    }
    if (af.c(paramString2)) {
      return -2147483648;
    }
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (!paramString2.has("permissionBytes")) {
        return -2147483648;
      }
      paramString2 = paramString2.getJSONArray("permissionBytes");
      if (paramString2.length() < 3)
      {
        o.c("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", new Object[] { Integer.valueOf(paramString2.length()) });
        return -2147483648;
      }
      int i;
      if ((paramc instanceof h))
      {
        i = a.1.a[((h)paramc).q().al().a().ordinal()];
        if (i != 1)
        {
          if ((i != 2) && (i != 3)) {
            i = paramString2.optInt(0, -2147483648);
          } else {
            i = paramString2.optInt(1, -2147483648);
          }
        }
        else {
          i = paramString2.optInt(2, -2147483648);
        }
      }
      else
      {
        i = paramString2.optInt(0, -2147483648);
      }
      o.d("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", new Object[] { paramString1, Integer.valueOf(i) });
      return i;
    }
    catch (Exception paramc)
    {
      o.b("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", new Object[] { paramc.getMessage() });
    }
    return -2147483648;
  }
  
  public static void a(String paramString)
  {
    a.add(paramString);
  }
  
  private static boolean a(c paramc, String paramString)
  {
    if ((paramc instanceof u)) {
      return true;
    }
    return a.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.on.a
 * JD-Core Version:    0.7.0.1
 */