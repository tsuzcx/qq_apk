package com.tencent.luggage.wxa.nl;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.b;
import com.tencent.luggage.wxa.rb.d;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends d<f>
{
  public static final String[] a = { d.a(f.f, "DevPkgLaunchExtInfo") };
  
  public h(b paramb)
  {
    super(paramb, f.f, "DevPkgLaunchExtInfo", f.a);
  }
  
  private boolean b(String paramString1, int paramInt, String paramString2)
  {
    if (af.c(paramString1)) {
      return false;
    }
    f localf = new f();
    localf.b = paramString1;
    localf.c = paramInt;
    if (super.a(localf, f.e))
    {
      localf.d = af.a(paramString2, "{}");
      return super.c(localf, new String[0]);
    }
    localf.d = af.a(paramString2, "{}");
    return super.a(localf);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt, paramString2, true);
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    boolean bool = b(paramString1, paramInt, paramString2);
    o.d("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo() appId:%s,versionType:%s,ret:%b,updatePkgManifests:%b,extInfo:%s", new Object[] { paramString1, Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramString2 });
    if ((bool) && (paramBoolean))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        try
        {
          paramString2 = new JSONObject(paramString2);
        }
        catch (Exception paramString2)
        {
          o.b("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo parse failed, appId[%s], type[%d], e[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
        }
      } else {
        paramString2 = null;
      }
      if (paramString2 != null)
      {
        try
        {
          JSONArray localJSONArray = paramString2.optJSONArray("module_list");
          if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
            ac.a().a(paramString1, paramInt, -1, localJSONArray.toString());
          } else {
            ac.a().a(paramString1, paramInt, -1);
          }
        }
        catch (Exception localException1)
        {
          o.a("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException1, "extract module_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
        }
        try
        {
          String str1 = paramString2.optString("separated_plugin_list");
          if (!TextUtils.isEmpty(str1)) {
            ac.a().a(str1);
          }
        }
        catch (Exception localException2)
        {
          o.a("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException2, "extract separated_plugin_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
        }
      }
    }
    try
    {
      str2 = paramString2.optString("without_lib_md5");
    }
    catch (Exception localException4)
    {
      String str2;
      label255:
      break label255;
    }
    str2 = null;
    try
    {
      if (!af.c(str2)) {
        ac.a().a(paramString1, "__WITHOUT_PLUGINCODE__", 0, paramInt, str2, 12);
      }
    }
    catch (Exception localException3)
    {
      o.a("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException3, "extract withoutLibMd5 with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
    }
    try
    {
      paramString2 = paramString2.optString("widget_list");
      if (!TextUtils.isEmpty(paramString2))
      {
        ac.a().a(paramString1, "", 0, paramInt, paramString2);
        return bool;
      }
    }
    catch (Exception paramString2)
    {
      o.a("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", paramString2, "extract widget_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.h
 * JD-Core Version:    0.7.0.1
 */