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

public class bgvr
  implements IShadow
{
  private static bgvr jdField_a_of_type_Bgvr;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private bgvr()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = akhk.b(192);
  }
  
  public static bgvr a()
  {
    if (jdField_a_of_type_Bgvr == null) {}
    try
    {
      if (jdField_a_of_type_Bgvr == null) {
        jdField_a_of_type_Bgvr = new bgvr();
      }
      return jdField_a_of_type_Bgvr;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new arec("Reader");
    ardz localardz = new ardz(paramContext, "Reader", paramString, "4");
    boolean bool;
    if ((localardz.wasUpdating()) || (localardz.getLatest() == null))
    {
      bool = true;
      bgwf.d("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localardz.update();
      if (!bool) {
        break label209;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if ((paramString == null) || (bgvo.a(paramContext, paramString))) {
          break label220;
        }
        bool = paramString.delete();
        bgwf.a("ReaderShadowImpl", "[loadPluginManager] pm apk is invalid and delete result=" + bool);
        paramContext = null;
        if (paramContext == null) {
          break label218;
        }
        return new DynamicPluginManager(new bgvt(localardz, paramContext));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        bgwf.a("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        bgwi.a(paramContext, -101, "cdn update ExecutionException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        bgwf.a("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        bgwi.a(paramContext, -102, "cdn update InterruptedException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      label209:
      paramString = localardz.getLatest();
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
      LoggerFactory.setILoggerFactory(areg.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvr
 * JD-Core Version:    0.7.0.1
 */