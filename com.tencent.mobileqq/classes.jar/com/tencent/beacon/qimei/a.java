package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.e.j;
import com.tencent.beacon.core.info.c;
import com.tencent.beacon.core.info.e;
import java.util.Map;

public class a
{
  private static a a;
  private String b = "";
  private Qimei c;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private boolean m = false;
  private String n = "";
  private String o = "";
  private String p = "";
  private String q = "";
  private String r = "";
  private String s = "";
  private String t = "";
  private String u = "";
  private String v = "";
  
  private a(Context paramContext)
  {
    this.d = c.a(paramContext).c();
    Object localObject = e.d(paramContext);
    this.e = ((e)localObject).i(paramContext);
    this.f = ((e)localObject).h(paramContext);
    this.g = ((e)localObject).b(paramContext);
    if ("".equals(this.e)) {
      this.h = ((e)localObject).e(paramContext);
    }
    this.i = c.a(paramContext).k();
    this.j = ((e)localObject).h();
    this.k = ((e)localObject).d();
    this.l = ((e)localObject).n();
    this.n = ((e)localObject).l();
    this.o = ((e)localObject).k(paramContext);
    try
    {
      this.c = new Qimei();
      localObject = i.c(paramContext);
      if (!j.b((String)localObject)) {
        this.b = ((String)localObject);
      }
      localObject = new StringBuilder();
      d.a("[qimei] final request qimeiJson: " + this.b, new Object[0]);
      localObject = i.a(this.b);
      if (localObject != null)
      {
        Qimei localQimei = this.c;
        localQimei.setQimeiOld((String)((Map)localObject).get("A3"));
        localQimei = this.c;
        localQimei.setQimeiNew((String)((Map)localObject).get("A153"));
        this.c.setQimeiMap((Map)localObject);
        i.b(paramContext, this.c.toString());
      }
      return;
    }
    catch (Exception paramContext)
    {
      d.b("load qimei error ", new Object[] { paramContext.getMessage() });
    }
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new a(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(Qimei paramQimei)
  {
    this.c = paramQimei;
  }
  
  public Qimei b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public QimeiPackage d()
  {
    QimeiPackage localQimeiPackage = new QimeiPackage();
    String str2 = this.d;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.imei = str1;
    str2 = this.f;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.imsi = str1;
    str2 = this.e;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.mac = str1;
    str2 = this.g;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.androidId = str1;
    str2 = this.b;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.qimei = str1;
    str2 = this.j;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.model = str1;
    str2 = this.k;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.brand = str1;
    str2 = this.l;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.osVersion = str1;
    localQimeiPackage.broot = this.m;
    str2 = this.i;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.qq = str1;
    str2 = this.n;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.cid = str1;
    return localQimeiPackage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.a
 * JD-Core Version:    0.7.0.1
 */