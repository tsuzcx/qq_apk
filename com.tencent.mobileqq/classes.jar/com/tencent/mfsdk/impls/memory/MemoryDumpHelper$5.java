package com.tencent.mfsdk.impls.memory;

import adkw;
import adkx;
import adlu;
import adlx;
import adly;
import adma;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import bdmc;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qapmsdk.base.meta.DumpResult;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class MemoryDumpHelper$5
  implements Runnable
{
  public MemoryDumpHelper$5(adlu paramadlu, boolean paramBoolean1, InspectUUID paramInspectUUID, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    Object localObject1;
    DumpResult localDumpResult;
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = "" + this.jdField_a_of_type_ComTencentQapmsdkCommonUtilInspectUUID;
      if (!this.jdField_a_of_type_Boolean) {
        break label371;
      }
      localDumpResult = MagnifierSDK.a().a().a((String)localObject1, new adlx(this));
      localObject2 = new MemoryDumpHelper.5.2(this, localDumpResult);
      adlu.a().postDelayed((Runnable)localObject2, 0L);
    }
    for (;;)
    {
      localObject2 = new File(localDumpResult.zipFilePath);
      if (QLog.isColorLevel()) {
        QLog.d("QAPM_MemoryDumpHelper", 2, "leakFlag=true,ZipFile=true,leakName=" + (String)localObject1 + ",dumpPath=" + ((File)localObject2).getAbsolutePath());
      }
      ThreadManager.getUIHandler().post(new MemoryDumpHelper.5.4(this));
      if ((localDumpResult.success) && (!this.jdField_a_of_type_Boolean))
      {
        long l = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) * 100L / Runtime.getRuntime().maxMemory();
        localObject1 = new HashMap(16);
        ((HashMap)localObject1).put("osVersion", Build.VERSION.RELEASE);
        ((HashMap)localObject1).put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        ((HashMap)localObject1).put("maxHeap", String.valueOf(Runtime.getRuntime().maxMemory()));
        ((HashMap)localObject1).put("totalHeap", String.valueOf(Runtime.getRuntime().totalMemory()));
        ((HashMap)localObject1).put("freeHeap", String.valueOf(Runtime.getRuntime().freeMemory()));
        ((HashMap)localObject1).put("threhold", String.valueOf(l));
        ((HashMap)localObject1).put("dumpFileSize", String.valueOf(localDumpResult.hprofFileSize));
        ((HashMap)localObject1).put("zipFileSize", String.valueOf(((File)localObject2).length()));
        bdmc.a(BaseApplication.getContext()).a("", "MemoryPeakDump", true, 0L, 0L, (HashMap)localObject1, "");
        adma.a().b();
      }
      return;
      localObject1 = this.jdField_a_of_type_JavaLangString;
      break;
      label371:
      localDumpResult = MagnifierSDK.a().a().a((String)localObject1, new adly(this));
      MagnifierSDK.a().a().a(localDumpResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.impls.memory.MemoryDumpHelper.5
 * JD-Core Version:    0.7.0.1
 */