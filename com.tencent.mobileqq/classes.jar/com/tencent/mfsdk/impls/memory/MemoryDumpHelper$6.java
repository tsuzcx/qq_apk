package com.tencent.mfsdk.impls.memory;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleCelling;
import com.tencent.qqperf.monitor.base.IAPMModuleLeak;
import com.tencent.qqperf.opt.clearmemory.MemoryReporter;
import java.io.File;
import java.util.HashMap;

class MemoryDumpHelper$6
  implements Runnable
{
  MemoryDumpHelper$6(MemoryDumpHelper paramMemoryDumpHelper, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = this.jdField_a_of_type_JavaLangString; !this.jdField_a_of_type_Boolean; localObject = this.jdField_b_of_type_JavaLangString)
    {
      localDumpResult = MagnifierSDK.a().a().a((String)localObject, new MemoryDumpHelper.6.1(this));
      MagnifierSDK.a().a().a(localDumpResult);
      MemoryDumpHelper.d(this.this$0);
      localFile = new File(localDumpResult.zipFilePath);
      if (QLog.isColorLevel()) {
        QLog.d("QAPM_MemoryDumpHelper", 2, "leakFlag=true,ZipFile=true,leakName=" + (String)localObject + ",dumpPath=" + localFile.getAbsolutePath());
      }
      if (localDumpResult.success)
      {
        long l = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) * 100L / Runtime.getRuntime().maxMemory();
        localObject = new HashMap(16);
        ((HashMap)localObject).put("osVersion", Build.VERSION.RELEASE);
        ((HashMap)localObject).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        ((HashMap)localObject).put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory()));
        ((HashMap)localObject).put("totalHeap", String.valueOf(Runtime.getRuntime().totalMemory()));
        ((HashMap)localObject).put("freeHeap", String.valueOf(Runtime.getRuntime().freeMemory()));
        ((HashMap)localObject).put("threhold", String.valueOf(l));
        ((HashMap)localObject).put("dumpFileSize", String.valueOf(localDumpResult.hprofFileSize));
        ((HashMap)localObject).put("zipFileSize", String.valueOf(localFile.length()));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "MemoryPeakDump", true, 0L, 0L, (HashMap)localObject, "");
        MemoryReporter.a().b();
      }
      return;
    }
    DumpResult localDumpResult = MagnifierSDK.a().a().a((String)localObject, new MemoryDumpHelper.6.2(this));
    File localFile = new File(localDumpResult.zipFilePath);
    if (QLog.isColorLevel()) {
      QLog.d("QAPM_MemoryDumpHelper", 2, "leakFlag=true,ZipFile=true,leakName=" + (String)localObject + ",dumpPath=" + localFile.getAbsolutePath());
    }
    MagnifierSDK.a().a().a(System.currentTimeMillis(), localDumpResult.zipFilePath);
    MemoryDumpHelper.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.6
 * JD-Core Version:    0.7.0.1
 */