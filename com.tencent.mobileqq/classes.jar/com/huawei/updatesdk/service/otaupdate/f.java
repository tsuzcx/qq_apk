package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.a;
import java.util.Iterator;
import java.util.List;

public class f
{
  private static String a = "com.huawei.appmarket";
  private static b b;
  
  public static void a(b paramb)
  {
    b = paramb;
  }
  
  public static void a(String paramString)
  {
    a = paramString;
    com.huawei.updatesdk.service.d.a.b.a(a.d(a), new f.a(null));
  }
  
  private static ApkUpgradeInfo b(List<ApkUpgradeInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (ApkUpgradeInfo)localIterator.next();
    } while ((a == null) || (!a.equals(paramList.getPackage_())));
    for (;;)
    {
      return paramList;
      paramList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.f
 * JD-Core Version:    0.7.0.1
 */