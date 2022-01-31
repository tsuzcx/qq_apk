import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.base.listener.IMonitorListener;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;

public class azpi
{
  private static volatile azpi jdField_a_of_type_Azpi;
  IInspectorListener jdField_a_of_type_ComTencentQapmsdkBaseListenerIInspectorListener = new azpf();
  IMemoryCellingListener jdField_a_of_type_ComTencentQapmsdkBaseListenerIMemoryCellingListener = new azpk();
  IMonitorListener jdField_a_of_type_ComTencentQapmsdkBaseListenerIMonitorListener = new azpl();
  public boolean a;
  
  public static int a()
  {
    int i = 0;
    if (BaseApplicationImpl.sProcessId == 2) {
      i = 14;
    }
    while (BaseApplicationImpl.sProcessId != 7) {
      return i;
    }
    return 19;
  }
  
  public static azpi a()
  {
    if (jdField_a_of_type_Azpi != null) {
      return jdField_a_of_type_Azpi;
    }
    try
    {
      if (jdField_a_of_type_Azpi == null) {
        jdField_a_of_type_Azpi = new azpi();
      }
      azpi localazpi = jdField_a_of_type_Azpi;
      return localazpi;
    }
    finally {}
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        if (BaseApplicationImpl.sProcessId == 1) {
          QAPM.setABTypes(abqu.a);
        }
        this.jdField_a_of_type_Boolean = true;
        int i = QAPM.LevelInfo;
        if (QLog.isColorLevel())
        {
          i = QAPM.LevelInfo;
          String str1 = "edf7897a-1";
          if ((2 != BaseApplicationImpl.sProcessId) && (8 != BaseApplicationImpl.sProcessId))
          {
            String str3 = InitMagnifierSDK.a();
            QAPM.setProperty(201, BaseApplicationImpl.sApplication);
            QAPM.setProperty(101, str1);
            QAPM.setProperty(103, str3);
            QAPM.setProperty(105, Integer.valueOf(i));
            QAPM.setProperty(106, "https://sngapm.qq.com");
            QAPM.setProperty(111, "https://athena.qq.com");
            QAPM.setProperty(301, Boolean.valueOf(false));
            QAPM.setProperty(303, Boolean.valueOf(false));
            QAPM.setProperty(302, Boolean.valueOf(false));
            QAPM.setProperty(305, this.jdField_a_of_type_ComTencentQapmsdkBaseListenerIMonitorListener);
            QAPM.setProperty(304, Boolean.valueOf(true));
            QAPM.setProperty(108, this.jdField_a_of_type_ComTencentQapmsdkBaseListenerIMemoryCellingListener);
            Logger.INSTANCE.setLogProxy(new azpg(i));
            ReporterMachine.INSTANCE.setUploadProxy(new azpj(this));
            QLog.i("QAPM_QQ_Impl", 1, "ensureInit proc = " + BaseApplicationImpl.sProcessId + " ver = " + str3);
          }
        }
        else
        {
          continue;
        }
      }
      finally {}
      String str2 = "None-100";
    }
  }
  
  public void a()
  {
    d();
    QLog.i("QAPM_QQ_Impl", 1, "openLooperAndSmoothAndResource");
    int j = 0;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(9)) {
      j = 0x0 | QAPM.ModeDropFrame;
    }
    int k = a();
    int i = j;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(k)) {
      i = j | QAPM.ModeLooper;
    }
    j = i;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(20)) {
      j = i | QAPM.ModeResource;
    }
    UnifiedMonitor.a().d();
    String str = InitMagnifierSDK.a();
    QLog.i("QAPM_QQ_Impl", 1, "initQAPMSDK proc = " + BaseApplicationImpl.sProcessId + " ver = " + str);
    QAPM.beginScene("SCENE_ALL", j);
  }
  
  public void a(long paramLong)
  {
    QAPM.setProperty(102, String.valueOf(paramLong));
  }
  
  public void a(Object paramObject, String paramString)
  {
    com.tencent.qapmsdk.memory.leakdetect.LeakInspector.startInspect(paramObject, "");
  }
  
  public void b()
  {
    d();
    com.tencent.mfsdk.LeakInspector.LeakInspector.a();
    QLog.i("QAPM_QQ_Impl", 1, "openMemoryLeak");
    if ((2 == BaseApplicationImpl.sProcessId) || (8 == BaseApplicationImpl.sProcessId)) {
      if (!LocalMultiProcConfig.getBool("Qzone_setApm_MemLeak", true)) {}
    }
    for (;;)
    {
      com.tencent.qapmsdk.memory.MemoryLeakMonitor.sEnableFragmentInspect = false;
      QAPM.setProperty(107, this.jdField_a_of_type_ComTencentQapmsdkBaseListenerIInspectorListener);
      QAPM.beginScene("SCENE_ALL", QAPM.ModeLeakInspector);
      return;
      PluginCombination.leakPlugin.eventSampleRatio = abqk.a;
    }
  }
  
  public void c()
  {
    d();
    QLog.i("QAPM_QQ_Impl", 1, "openMemoryCelling");
    PluginCombination.ceilingHprofPlugin.eventSampleRatio = 1.0F;
    PluginCombination.ceilingValuePlugin.eventSampleRatio = 0.1F;
    QAPM.beginScene("SCENE_ALL", QAPM.ModeCeiling);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpi
 * JD-Core Version:    0.7.0.1
 */