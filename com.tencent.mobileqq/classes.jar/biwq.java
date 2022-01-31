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

public class biwq
  implements IShadow
{
  private static biwq jdField_a_of_type_Biwq;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private biwq()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = alza.b(192);
  }
  
  public static biwq a()
  {
    if (jdField_a_of_type_Biwq == null) {}
    try
    {
      if (jdField_a_of_type_Biwq == null) {
        jdField_a_of_type_Biwq = new biwq();
      }
      return jdField_a_of_type_Biwq;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new asuq("Reader");
    asun localasun = new asun(paramContext, "Reader", paramString, "5");
    boolean bool;
    if ((localasun.wasUpdating()) || (localasun.getLatest() == null))
    {
      bool = true;
      bixe.d("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localasun.update();
      if (!bool) {
        break label209;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if ((paramString == null) || (biwn.a(paramContext, paramString))) {
          break label220;
        }
        bool = paramString.delete();
        bixe.a("ReaderShadowImpl", "[loadPluginManager] pm apk is invalid and delete result=" + bool);
        paramContext = null;
        if (paramContext == null) {
          break label218;
        }
        return new DynamicPluginManager(new biws(localasun, paramContext));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        bixe.a("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        bixh.a(paramContext, -101, "cdn update ExecutionException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        bixe.a("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        bixh.a(paramContext, -102, "cdn update InterruptedException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      label209:
      paramString = localasun.getLatest();
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
      LoggerFactory.setILoggerFactory(asuu.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwq
 * JD-Core Version:    0.7.0.1
 */