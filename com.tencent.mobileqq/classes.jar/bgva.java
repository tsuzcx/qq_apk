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

public class bgva
  implements IShadow
{
  private static bgva jdField_a_of_type_Bgva;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private bgva()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = akhl.b(192);
  }
  
  public static bgva a()
  {
    if (jdField_a_of_type_Bgva == null) {}
    try
    {
      if (jdField_a_of_type_Bgva == null) {
        jdField_a_of_type_Bgva = new bgva();
      }
      return jdField_a_of_type_Bgva;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new area("Reader");
    ardx localardx = new ardx(paramContext, "Reader", paramString, "4");
    boolean bool;
    if ((localardx.wasUpdating()) || (localardx.getLatest() == null))
    {
      bool = true;
      bgvo.d("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localardx.update();
      if (!bool) {
        break label209;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if ((paramString == null) || (bgux.a(paramContext, paramString))) {
          break label220;
        }
        bool = paramString.delete();
        bgvo.a("ReaderShadowImpl", "[loadPluginManager] pm apk is invalid and delete result=" + bool);
        paramContext = null;
        if (paramContext == null) {
          break label218;
        }
        return new DynamicPluginManager(new bgvc(localardx, paramContext));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        bgvo.a("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        bgvr.a(paramContext, -101, "cdn update ExecutionException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        bgvo.a("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        bgvr.a(paramContext, -102, "cdn update InterruptedException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      label209:
      paramString = localardx.getLatest();
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
      LoggerFactory.setILoggerFactory(aree.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgva
 * JD-Core Version:    0.7.0.1
 */