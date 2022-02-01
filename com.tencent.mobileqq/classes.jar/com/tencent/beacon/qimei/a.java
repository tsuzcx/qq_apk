package com.tencent.beacon.qimei;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.util.d;
import com.tencent.beacon.pack.QimeiPackage;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static a a;
  private String b = "";
  private Qimei c;
  
  private a()
  {
    d();
  }
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  private void d()
  {
    try
    {
      this.c = new Qimei();
      Object localObject1 = e.a(com.tencent.beacon.a.c.c.d().c());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.b = ((String)localObject1);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[qimei] final jceRequest qimeiJson: ");
      ((StringBuilder)localObject1).append(this.b);
      com.tencent.beacon.base.util.c.a(((StringBuilder)localObject1).toString(), new Object[0]);
      localObject1 = e.a(this.b);
      if (localObject1 != null)
      {
        this.c.b((String)((HashMap)localObject1).get("A3"));
        this.c.a((String)((HashMap)localObject1).get("A153"));
        this.c.a((Map)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[qimei] showQimei: ");
        ((StringBuilder)localObject1).append(this.c.toString());
        com.tencent.beacon.base.util.c.a(((StringBuilder)localObject1).toString(), new Object[0]);
      }
      return;
    }
    finally {}
  }
  
  public void a(Qimei paramQimei)
  {
    try
    {
      this.c = paramQimei;
      return;
    }
    finally
    {
      paramQimei = finally;
      throw paramQimei;
    }
  }
  
  public Qimei b()
  {
    return this.c;
  }
  
  public QimeiPackage c()
  {
    f localf = f.p();
    QimeiPackage localQimeiPackage = new QimeiPackage();
    localQimeiPackage.imei = localf.m();
    localQimeiPackage.imsi = localf.o();
    localQimeiPackage.mac = localf.s();
    localQimeiPackage.androidId = localf.e();
    String str2 = this.b;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localQimeiPackage.qimei = str1;
    localQimeiPackage.model = Build.MODEL;
    localQimeiPackage.brand = Build.BRAND;
    localQimeiPackage.osVersion = localf.z();
    localQimeiPackage.broot = d.d();
    localQimeiPackage.qq = "";
    localQimeiPackage.cid = localf.v();
    return localQimeiPackage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.qimei.a
 * JD-Core Version:    0.7.0.1
 */