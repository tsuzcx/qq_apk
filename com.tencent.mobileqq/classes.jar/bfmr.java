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

public class bfmr
  implements IShadow
{
  private static bfmr jdField_a_of_type_Bfmr;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private boolean jdField_a_of_type_Boolean;
  
  private bfmr()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = ajtb.b(192);
  }
  
  public static bfmr a()
  {
    if (jdField_a_of_type_Bfmr == null) {}
    try
    {
      if (jdField_a_of_type_Bfmr == null) {
        jdField_a_of_type_Bfmr = new bfmr();
      }
      return jdField_a_of_type_Bfmr;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new aqjv("Reader");
    aqjs localaqjs = new aqjs(paramContext, "Reader", paramString, "3");
    boolean bool;
    if ((localaqjs.wasUpdating()) || (localaqjs.getLatest() == null))
    {
      bool = true;
      bfne.c("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localaqjs.update();
      if (!bool) {
        break label174;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if (paramString == null) {
          break label183;
        }
        return new DynamicPluginManager(new bfms(localaqjs, paramString));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        bfne.a("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        bfnk.a(paramContext, 0, "", bfnk.a("cdn update ExecutionException!", paramString.getMessage()));
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        bfne.a("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        bfnk.a(paramContext, 0, "", bfnk.a("cdn update InterruptedException!", paramString.getMessage()));
        paramString = null;
        continue;
      }
      label174:
      paramString = localaqjs.getLatest();
    }
    label183:
    bfnk.a(paramContext, 0, "pluginManager is null!", "");
    return null;
  }
  
  public void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReaderShadowImpl.1(this, paramLong, paramContext, paramString1, paramString2, paramBundle, paramEnterCallback));
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
      LoggerFactory.setILoggerFactory(aqjz.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmr
 * JD-Core Version:    0.7.0.1
 */