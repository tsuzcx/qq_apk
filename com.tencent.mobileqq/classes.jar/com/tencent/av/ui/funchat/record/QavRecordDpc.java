package com.tencent.av.ui.funchat.record;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class QavRecordDpc
{
  private static QavRecordDpc u;
  public String a = null;
  public int b = 1;
  public int c = 4;
  public int d = 2000;
  public int e = 4;
  public int f = 2150;
  public int g = 720;
  public int h = 1;
  public int i = 5;
  public int j = 120000;
  public int k = 1;
  public int l = 1;
  public int m = 0;
  public int n = 0;
  public int o = 5000;
  public int p = 0;
  public int q = 25000;
  public int r = 1;
  public int s;
  public int t;
  
  private static int a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfString != null)
    {
      if (paramInt1 >= paramArrayOfString.length) {
        return paramInt2;
      }
      try
      {
        paramInt1 = Integer.parseInt(paramArrayOfString[paramInt1]);
        return paramInt1;
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    return paramInt2;
  }
  
  public static QavRecordDpc a()
  {
    if (u == null) {
      u = b();
    }
    return u;
  }
  
  private static QavRecordDpc b()
  {
    QavRecordDpc localQavRecordDpc = new QavRecordDpc();
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.qavDpc.name());
    localQavRecordDpc.a = ((String)localObject);
    if (!TextUtils.isEmpty(localQavRecordDpc.a))
    {
      localObject = ((String)localObject).split("\\|");
      localQavRecordDpc.b = a((String[])localObject, 0, 1);
      localQavRecordDpc.c = a((String[])localObject, 1, 4);
      localQavRecordDpc.d = a((String[])localObject, 2, 2000);
      localQavRecordDpc.e = a((String[])localObject, 3, 4);
      localQavRecordDpc.f = a((String[])localObject, 4, 2150);
      localQavRecordDpc.g = a((String[])localObject, 5, 720);
      localQavRecordDpc.h = a((String[])localObject, 6, 1);
      localQavRecordDpc.i = a((String[])localObject, 7, 5);
      localQavRecordDpc.j = a((String[])localObject, 8, 120000);
      localQavRecordDpc.k = a((String[])localObject, 9, 1);
      localQavRecordDpc.l = a((String[])localObject, 10, 1);
      localQavRecordDpc.m = a((String[])localObject, 11, 0);
      localQavRecordDpc.n = a((String[])localObject, 12, 0);
      localQavRecordDpc.o = a((String[])localObject, 13, 5000);
      localQavRecordDpc.p = a((String[])localObject, 14, 0);
      localQavRecordDpc.q = a((String[])localObject, 15, 25000);
      localQavRecordDpc.r = a((String[])localObject, 16, 1);
    }
    localQavRecordDpc.s = DeviceInfoUtil.h();
    localQavRecordDpc.t = ((int)(DeviceInfoUtil.l() / 1000L));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init=");
      ((StringBuilder)localObject).append(localQavRecordDpc);
      QLog.d("QavRecordDpc", 2, ((StringBuilder)localObject).toString());
    }
    return localQavRecordDpc;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.getDefault();
    String str = this.a;
    Integer localInteger = Integer.valueOf(4);
    return String.format(localLocale, "QavRecordDpc:dpc=%s, default=%d|%d|%d|%d|%d|%d, value=%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%s|%s|%s, system=%d|%d", new Object[] { str, Integer.valueOf(1), localInteger, Integer.valueOf(2000), localInteger, Integer.valueOf(2150), Integer.valueOf(720), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o), Integer.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r), Integer.valueOf(this.s), Integer.valueOf(this.t) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordDpc
 * JD-Core Version:    0.7.0.1
 */