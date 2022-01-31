import android.content.Context;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class aqkl
{
  public static final IVPluginDataReporter a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    a();
  }
  
  public static aqkc a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = (aqkc)ajtb.a(192).submit(new aqkm(paramContext, paramString1)).get(20L, TimeUnit.SECONDS);
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
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      LoggerFactory.setILoggerFactory(aqjz.a());
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public static aqkc b(Context paramContext, String paramString1, String paramString2)
  {
    l1 = System.currentTimeMillis();
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(paramString1).opType("CdnGetBizPm").toUin(paramString2);
    aqjv localaqjv = new aqjv(paramString1);
    if (localaqjv.getLatest() != null) {
      return new aqkk(paramString1, new DynamicPluginManager(localaqjv));
    }
    paramContext = new aqjs(paramContext, paramString1, paramString2, "7_1");
    if (QLog.isColorLevel()) {
      QLog.i("shadow::Shadow", 2, "wasUpdating:" + paramContext.wasUpdating() + " getLatest:" + paramContext.getLatest());
    }
    if ((paramContext.wasUpdating()) || (paramContext.getLatest() == null)) {}
    for (bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("shadow::Shadow", 2, "needWaitingUpdate:" + bool);
      }
      paramString2 = paramContext.update();
      if (bool) {}
      try
      {
        paramString2.get();
        l2 = System.currentTimeMillis();
        paramContext = new aqkk(paramString1, new DynamicPluginManager(paramContext));
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(0).report();
        return paramContext;
      }
      catch (ExecutionException paramContext)
      {
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(1).report();
        throw paramContext;
      }
      catch (InterruptedException paramContext)
      {
        long l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(2).report();
        throw paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqkl
 * JD-Core Version:    0.7.0.1
 */