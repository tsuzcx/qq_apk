import android.content.Context;
import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.qqreader.shadow.ReaderShadowImpl.1;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class blpg
  implements IShadow
{
  private static blpg jdField_a_of_type_Blpg;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private blpg()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = anvy.b(192);
  }
  
  public static blpg a()
  {
    if (jdField_a_of_type_Blpg == null) {}
    try
    {
      if (jdField_a_of_type_Blpg == null) {
        jdField_a_of_type_Blpg = new blpg();
      }
      return jdField_a_of_type_Blpg;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new avgs("Reader");
    avgo localavgo = new avgo(paramContext, "Reader", paramString, "5");
    boolean bool;
    if ((localavgo.wasUpdating()) || (localavgo.getLatest() == null))
    {
      bool = true;
      blpu.d("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localavgo.update();
      if (!bool) {
        break label209;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if ((paramString == null) || (blpf.a(paramContext, paramString))) {
          break label220;
        }
        bool = paramString.delete();
        blpu.a("ReaderShadowImpl", "[loadPluginManager] pm apk is invalid and delete result=" + bool);
        paramContext = null;
        if (paramContext == null) {
          break label218;
        }
        return new DynamicPluginManager(new blpi(localavgo, paramContext));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        blpu.a("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        blpx.a(paramContext, -101, "cdn update ExecutionException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        blpu.a("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        blpx.a(paramContext, -102, "cdn update InterruptedException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      label209:
      paramString = localavgo.getLatest();
      continue;
      label218:
      return null;
      label220:
      paramContext = paramString;
    }
  }
  
  public void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReaderShadowImpl.1(this, paramContext, paramString1, paramString2, paramLong, paramBundle, paramEnterCallback));
  }
  
  public PluginManager getPluginManager(Context paramContext, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager == null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager = a(paramContext, paramString1);
    }
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  }
  
  public boolean hasPluginManager()
  {
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager != null;
  }
  
  public void setILoggerFactory()
  {
    if (LoggerFactory.getILoggerFactory() == null) {
      LoggerFactory.setILoggerFactory(avgw.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpg
 * JD-Core Version:    0.7.0.1
 */