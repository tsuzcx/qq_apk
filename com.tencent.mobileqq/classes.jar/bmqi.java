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

public class bmqi
  implements IShadow
{
  private static bmqi jdField_a_of_type_Bmqi;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private bmqi()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = aoik.b(192);
  }
  
  public static bmqi a()
  {
    if (jdField_a_of_type_Bmqi == null) {}
    try
    {
      if (jdField_a_of_type_Bmqi == null) {
        jdField_a_of_type_Bmqi = new bmqi();
      }
      return jdField_a_of_type_Bmqi;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    new avyv("Reader");
    avyr localavyr = new avyr(paramContext, "Reader", paramString, "5");
    boolean bool;
    if ((localavyr.wasUpdating()) || (localavyr.getLatest() == null))
    {
      bool = true;
      bmqw.d("ReaderShadowImpl", "needWaitingUpdate:" + bool);
      paramString = localavyr.update();
      if (!bool) {
        break label209;
      }
    }
    for (;;)
    {
      try
      {
        paramString = (File)paramString.get();
        if ((paramString == null) || (bmqh.a(paramContext, paramString))) {
          break label220;
        }
        bool = paramString.delete();
        bmqw.a("ReaderShadowImpl", "[loadPluginManager] pm apk is invalid and delete result=" + bool);
        paramContext = null;
        if (paramContext == null) {
          break label218;
        }
        return new DynamicPluginManager(new bmqk(localavyr, paramContext));
        bool = false;
      }
      catch (ExecutionException paramString)
      {
        bmqw.a("ReaderShadowImpl", "[loadPluginManager] ExecutionException:", paramString);
        bmqz.a(paramContext, -101, "cdn update ExecutionException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      catch (InterruptedException paramString)
      {
        bmqw.a("ReaderShadowImpl", "[loadPluginManager] InterruptedException:", paramString);
        bmqz.a(paramContext, -102, "cdn update InterruptedException!", paramString.getMessage());
        paramString = null;
        continue;
      }
      label209:
      paramString = localavyr.getLatest();
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
      LoggerFactory.setILoggerFactory(avyz.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqi
 * JD-Core Version:    0.7.0.1
 */