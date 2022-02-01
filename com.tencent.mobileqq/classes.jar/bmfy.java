import android.content.Context;
import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.qqreader.shadow.ReaderShadowImpl.1;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class bmfy
  implements IShadow
{
  private static bmfy jdField_a_of_type_Bmfy;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private bmfy()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = ThreadManagerExecutor.getSingleThreadExecutorService(192);
  }
  
  public static bmfy a()
  {
    if (jdField_a_of_type_Bmfy == null) {}
    try
    {
      if (jdField_a_of_type_Bmfy == null) {
        jdField_a_of_type_Bmfy = new bmfy();
      }
      return jdField_a_of_type_Bmfy;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new avrq("Reader");
    avrm localavrm = new avrm(paramContext, "Reader", paramString, "5");
    boolean bool;
    if ((localavrm.wasUpdating()) || (localavrm.getLatest() == null))
    {
      bool = true;
      bmgm.d("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localavrm.update();
      if (!bool) {
        break label209;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if ((paramString == null) || (bmfx.a(paramContext, paramString))) {
          break label220;
        }
        bool = paramString.delete();
        bmgm.a("ReaderShadowImpl", "[loadPluginManager] pm apk is invalid and delete result=" + bool);
        paramContext = null;
        if (paramContext == null) {
          break label218;
        }
        return new DynamicPluginManager(new bmga(localavrm, paramContext));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        bmgm.a("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        bmgp.a(paramContext, -101, "cdn update ExecutionException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        bmgm.a("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        bmgp.a(paramContext, -102, "cdn update InterruptedException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      label209:
      paramString = localavrm.getLatest();
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
      LoggerFactory.setILoggerFactory(avru.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfy
 * JD-Core Version:    0.7.0.1
 */