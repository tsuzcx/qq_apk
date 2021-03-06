package com.tencent.acstat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.acstat.NetworkManager;
import com.tencent.acstat.StatConfig;
import com.tencent.acstat.StatSpecifyReportedInfo;
import com.tencent.acstat.af;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

class c
{
  String a;
  String b = "2.4.2";
  DisplayMetrics c;
  int d = Build.VERSION.SDK_INT;
  String e = Build.MODEL;
  String f = Build.MANUFACTURER;
  String g = Locale.getDefault().getLanguage();
  String h;
  String i;
  String j;
  String k;
  int l = 0;
  String m = null;
  String n = null;
  Context o = null;
  private String p = null;
  private String q = null;
  private String r = null;
  private String s = null;
  
  private c(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    this.o = paramContext.getApplicationContext();
    this.c = StatCommonHelper.getDisplayMetrics(this.o);
    this.a = StatCommonHelper.getCurAppVersion(this.o);
    if (paramStatSpecifyReportedInfo != null) {
      this.h = paramStatSpecifyReportedInfo.getInstallChannel();
    }
    if (!StatCommonHelper.isStringValid(this.h)) {
      this.h = StatConfig.getInstallChannel(this.o);
    }
    this.i = StatCommonHelper.getSimOperator(this.o);
    this.j = TimeZone.getDefault().getID();
    this.l = StatCommonHelper.hasRootAccess(this.o);
    this.k = StatCommonHelper.getExternalStorageInfo(this.o);
    this.m = this.o.getPackageName();
    this.q = StatCommonHelper.getCpuInfo(this.o).toString();
    this.r = StatCommonHelper.getSystemMemory(this.o);
    this.s = StatCommonHelper.getRomMemory();
    this.n = StatCommonHelper.getLauncherPackageName(this.o);
  }
  
  void a(JSONObject paramJSONObject, Thread paramThread)
  {
    String str;
    if (paramThread == null)
    {
      if (this.c != null)
      {
        paramThread = new StringBuilder();
        paramThread.append(this.c.widthPixels);
        paramThread.append("*");
        paramThread.append(this.c.heightPixels);
        paramJSONObject.put("sr", paramThread.toString());
        paramThread = new StringBuilder();
        paramThread.append(this.c.xdpi);
        paramThread.append("*");
        paramThread.append(this.c.ydpi);
        paramJSONObject.put("dpi", paramThread.toString());
      }
      if (NetworkManager.getInstance(this.o).isWifi())
      {
        paramThread = new JSONObject();
        Util.jsonPut(paramThread, "bs", Util.getWiFiBBSID(this.o));
        Util.jsonPut(paramThread, "ss", Util.getWiFiSSID(this.o));
        if (paramThread.length() > 0) {
          Util.jsonPut(paramJSONObject, "wf", paramThread.toString());
        }
      }
      paramThread = Util.getWifiTopN(this.o, 10);
      if ((paramThread == null) || (paramThread.length() <= 0)) {
        break label396;
      }
      str = paramThread.toString();
      paramThread = "wflist";
    }
    else
    {
      Util.jsonPut(paramJSONObject, "thn", paramThread.getName());
      Util.jsonPut(paramJSONObject, "qq", StatConfig.getQQ(this.o));
      Util.jsonPut(paramJSONObject, "cui", StatConfig.getCustomUserId(this.o));
      if ((StatCommonHelper.isStringValid(this.r)) && (this.r.split("/").length == 2)) {
        Util.jsonPut(paramJSONObject, "fram", this.r.split("/")[0]);
      }
      if ((StatCommonHelper.isStringValid(this.s)) && (this.s.split("/").length == 2)) {
        Util.jsonPut(paramJSONObject, "from", this.s.split("/")[0]);
      }
      if (af.a(this.o).b(this.o) != null) {
        paramJSONObject.put("ui", af.a(this.o).b(this.o).getImei());
      }
      str = StatConfig.getLocalMidOnly(this.o);
      paramThread = "mid";
    }
    Util.jsonPut(paramJSONObject, paramThread, str);
    label396:
    Util.jsonPut(paramJSONObject, "pcn", StatCommonHelper.a(this.o));
    Util.jsonPut(paramJSONObject, "osn", Build.VERSION.RELEASE);
    Util.jsonPut(paramJSONObject, "av", this.a);
    Util.jsonPut(paramJSONObject, "ch", this.h);
    Util.jsonPut(paramJSONObject, "mf", this.f);
    Util.jsonPut(paramJSONObject, "sv", this.b);
    Util.jsonPut(paramJSONObject, "osd", Build.DISPLAY);
    Util.jsonPut(paramJSONObject, "prod", Build.PRODUCT);
    Util.jsonPut(paramJSONObject, "tags", Build.TAGS);
    Util.jsonPut(paramJSONObject, "id", Build.ID);
    Util.jsonPut(paramJSONObject, "fng", Build.FINGERPRINT);
    Util.jsonPut(paramJSONObject, "lch", this.n);
    Util.jsonPut(paramJSONObject, "ov", Integer.toString(this.d));
    paramJSONObject.put("os", 1);
    Util.jsonPut(paramJSONObject, "op", this.i);
    Util.jsonPut(paramJSONObject, "lg", this.g);
    Util.jsonPut(paramJSONObject, "md", this.e);
    Util.jsonPut(paramJSONObject, "tz", this.j);
    int i1 = this.l;
    if (i1 != 0) {
      paramJSONObject.put("jb", i1);
    }
    Util.jsonPut(paramJSONObject, "sd", this.k);
    Util.jsonPut(paramJSONObject, "apn", this.m);
    Util.jsonPut(paramJSONObject, "cpu", this.q);
    Util.jsonPut(paramJSONObject, "abi", Build.CPU_ABI);
    Util.jsonPut(paramJSONObject, "abi2", Build.CPU_ABI2);
    Util.jsonPut(paramJSONObject, "ram", this.r);
    Util.jsonPut(paramJSONObject, "rom", this.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.c
 * JD-Core Version:    0.7.0.1
 */