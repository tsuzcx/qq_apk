package com.tencent.mobileqq.ar;

import android.os.Handler;
import com.tencent.mobileqq.earlydownload.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

class ArConfigService$3
  implements EarlyDownLoadListener
{
  ArConfigService$3(ArConfigService paramArConfigService) {}
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, "EarlyDownLoadListener");
    }
  }
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadProgress data=%s curOffset=%s totalLen=%s", new Object[] { paramXmlData, Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    if ("qq.android.ar.native.so_v8.3.6".equals(paramXmlData.strResName)) {
      ArConfigService.b(this.a, (int)(paramLong1 * 100L / paramLong2));
    }
    int i = (ArConfigService.r(this.a) + ArConfigService.s(this.a) + ArConfigService.t(this.a) + ArConfigService.u(this.a) + ArConfigService.v(this.a)) / 5;
    if (!ArConfigService.q(this.a)) {
      ArConfigService.w(this.a).post(new ArConfigService.3.1(this, i));
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArConfigService", 2, String.format("onDownloadFinish data=%s result=%s", new Object[] { paramXmlData, Boolean.valueOf(paramBoolean1) }));
    }
    if (paramBoolean1)
    {
      if ("qq.android.ar.native.so_v8.3.6".equals(paramXmlData.strResName)) {
        ArConfigService.b(this.a, true);
      }
      if ((ArConfigService.A(this.a)) && (ArConfigService.B(this.a)) && (ArConfigService.C(this.a)) && (ArConfigService.D(this.a)) && (ArConfigService.E(this.a))) {
        ArConfigService.w(this.a).post(new ArConfigService.3.2(this));
      }
    }
    else if (!ArConfigService.q(this.a))
    {
      ArConfigService.w(this.a).post(new ArConfigService.3.3(this));
      ArConfigService.a(this.a, true);
    }
  }
  
  public void b(XmlData paramXmlData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigService.3
 * JD-Core Version:    0.7.0.1
 */