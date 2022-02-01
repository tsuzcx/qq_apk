import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.InvalidFileException;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class auml
{
  private static aumk jdField_a_of_type_Aumk;
  public static final IVPluginDataReporter a;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    jdField_a_of_type_JavaLangObject = new Object();
    a();
  }
  
  public static aumc a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = (aumc)ThreadManagerExecutor.getExecutorService(192).submit(new aumm(paramContext, paramString1)).get(20L, TimeUnit.SECONDS);
      return paramContext;
    }
    catch (TimeoutException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
    catch (InterruptedException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
    catch (ExecutionException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
  }
  
  private static aumk a(String paramString, aulr paramaulr)
  {
    QLog.i("shadow::Shadow", 2, "pluginManagerWrapper ，sPluginManagerWrapper = " + jdField_a_of_type_Aumk + " bizType:" + paramString);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Aumk == null)
      {
        jdField_a_of_type_Aumk = new aumk(paramString, new DynamicPluginManager(paramaulr));
        QLog.i("shadow::Shadow", 2, "new pluginManagerWrapper : " + jdField_a_of_type_Aumk);
      }
      paramString = jdField_a_of_type_Aumk;
      return paramString;
    }
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      LoggerFactory.setILoggerFactory(aulz.a());
      label12:
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label12;
    }
  }
  
  public static aumc b(Context paramContext, String paramString1, String paramString2)
  {
    l1 = System.currentTimeMillis();
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(paramString1).opType("CdnGetBizPm").toUin(paramString2);
    Object localObject1 = new aulv(paramString1);
    if (((aulv)localObject1).getLatest() != null) {
      return new aumk(paramString1, new DynamicPluginManager((PluginManagerUpdater)localObject1));
    }
    localaulr = new aulr(paramContext.getApplicationContext(), paramString1, paramString2, "9_1");
    if (QLog.isColorLevel()) {
      QLog.i("shadow::Shadow", 2, "wasUpdating:" + localaulr.wasUpdating() + " getLatest:" + localaulr.getLatest());
    }
    if ((localaulr.wasUpdating()) || (localaulr.getLatest() == null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.i("shadow::Shadow", 2, "needWaitingUpdate:" + bool);
      }
      if (TextUtils.equals("GVideo", paramString1)) {
        localaulr.a(new aumn(paramString1));
      }
      paramString2 = localaulr.update();
      if (!bool) {}
    }
    for (;;)
    {
      try
      {
        paramString2.get();
        localObject2 = paramContext.getPackageManager();
        if (localaulr.getLatest() != null)
        {
          paramContext = localaulr.getLatest().getAbsolutePath();
          l2 = System.currentTimeMillis();
          localObject1 = null;
          paramString2 = null;
        }
      }
      catch (ExecutionException paramContext)
      {
        Object localObject2;
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(1).report();
        throw paramContext;
      }
      catch (InterruptedException paramContext)
      {
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(2).report();
        throw paramContext;
      }
      try
      {
        localObject2 = ((PackageManager)localObject2).getPackageArchiveInfo(paramContext, 128);
        paramString2 = (String)localObject2;
        localObject1 = localObject2;
        QLog.i("shadow::Shadow", 2, "getPackageArchiveInfo，timespan = " + (System.currentTimeMillis() - l2));
        if (localObject2 == null) {
          paramString1 = "";
        }
      }
      catch (Exception localException)
      {
        if (paramString2 == null) {
          paramString1 = "";
        }
        try
        {
          paramString2 = bjkf.a(localaulr.getLatest());
          paramString1 = paramString2;
        }
        catch (IOException paramString2)
        {
          break label497;
        }
        QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
        localaulr.a();
        throw new InvalidFileException("pluginManager apk file is invalid!");
      }
      finally
      {
        if (localException == null) {
          paramString1 = "";
        }
        try
        {
          paramString2 = bjkf.a(localaulr.getLatest());
          paramString1 = paramString2;
        }
        catch (IOException paramString2)
        {
          break label592;
        }
        QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
        localaulr.a();
        throw new InvalidFileException("pluginManager apk file is invalid!");
        throw paramString1;
        l2 = System.currentTimeMillis();
        if (TextUtils.equals("GVideo", paramString1)) {}
        for (paramContext = a(paramString1, localaulr);; paramContext = new aumk(paramString1, new DynamicPluginManager(localaulr)))
        {
          jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(0).report();
          return paramContext;
        }
      }
      try
      {
        paramString2 = bjkf.a(localaulr.getLatest());
        paramString1 = paramString2;
      }
      catch (IOException paramString2)
      {
        continue;
      }
      QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
      localaulr.a();
      throw new InvalidFileException("pluginManager apk file is invalid!");
      bool = false;
      break;
      paramContext = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auml
 * JD-Core Version:    0.7.0.1
 */