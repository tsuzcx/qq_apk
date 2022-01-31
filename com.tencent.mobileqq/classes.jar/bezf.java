import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import NS_MINI_REPORT.REPORT.SingleDcData;
import NS_MINI_REPORT.REPORT.StDcReportReq;
import NS_MINI_REPORT.REPORT.StThirdDcReportReq;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.report.MiniProgramReporter.3;
import com.tencent.qqmini.sdk.report.MiniProgramReporter.4;
import com.tencent.qqmini.sdk.report.MiniProgramReporter.5;
import com.tencent.qqmini.sdk.report.MiniProgramReporter.6;
import com.tencent.qqmini.sdk.report.MiniProgramReporter.7;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class bezf
{
  private static final bezf jdField_a_of_type_Bezf = new bezf();
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private List<APP_REPORT_TRANSFER.SingleDcData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long = System.currentTimeMillis();
  private List<APP_REPORT_TRANSFER.SingleDcData> jdField_b_of_type_JavaUtilList = new ArrayList();
  private long jdField_c_of_type_Long = System.currentTimeMillis();
  private List<REPORT.SingleDcData> jdField_c_of_type_JavaUtilList = new ArrayList();
  private List<REPORT.SingleDcData> d = new ArrayList();
  private List<APP_REPORT_TRANSFER.SingleDcData> e = new ArrayList();
  
  private bezf()
  {
    HandlerThread localHandlerThread = new HandlerThread("mini_program_report");
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public static bezf a()
  {
    return jdField_a_of_type_Bezf;
  }
  
  private void a(byte[] paramArrayOfByte, List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).dataReport(paramArrayOfByte, new bezh(this, paramList));
    }
  }
  
  private void a(byte[] paramArrayOfByte, List<REPORT.SingleDcData> paramList, String paramString1, String paramString2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).report(paramArrayOfByte, paramString1, paramString2, new bezg(this, paramList));
    }
  }
  
  private boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > TimeUnit.SECONDS.toMillis(600L);
  }
  
  private static String b(REPORT.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null) {
      localStringBuilder.append(bfgr.a(paramSingleDcData));
    }
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    if (!this.d.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.d);
      this.d.clear();
      byte[] arrayOfByte = beze.a(localArrayList).toByteArray();
      if (arrayOfByte.length > 0) {
        a(arrayOfByte, localArrayList, "mini_app_dcreport", "ThirdDcReport");
      }
    }
  }
  
  private void e()
  {
    if (!this.e.isEmpty())
    {
      ArrayList localArrayList = new ArrayList(this.e);
      this.e.clear();
      byte[] arrayOfByte = beze.a(localArrayList).toByteArray();
      if (arrayOfByte.length > 0) {
        a(arrayOfByte, localArrayList);
      }
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ArrayList localArrayList;
    Object localObject2;
    Object localObject1;
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList.clear();
      localObject2 = beze.a(localArrayList);
      if (localObject2 != null) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = ((APP_REPORT_TRANSFER.StDataReportReq)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        betc.d("MiniProgramReporter", "performReportLaunchDcDataToServer", localException);
      }
      if (localObject1.length > 262144) {
        break label104;
      }
      a((byte[])localObject1, localArrayList);
      return;
      label104:
      i = localObject1.length / 262144 + 1;
      k = localArrayList.size() / i;
      betc.a("MiniProgramReporter", "performReportLaunchDcDataToServer: split into " + i + " count");
      j = 0;
      i = k;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int i;
      int k;
      int j;
      while (i <= localArrayList.size())
      {
        if ((j < i) && (j >= 0) && (i <= localArrayList.size()))
        {
          localObject1 = localArrayList.subList(j, i);
          APP_REPORT_TRANSFER.StDataReportReq localStDataReportReq = beze.a((List)localObject1);
          if (localStDataReportReq != null) {
            a(localStDataReportReq.toByteArray(), (List)localObject1);
          }
        }
        int m = i + k;
        if (m > localArrayList.size())
        {
          m = localArrayList.size();
          j = i;
          i = m;
        }
        else
        {
          j = i;
          i = m;
        }
      }
    }
  }
  
  private void g()
  {
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ArrayList localArrayList;
    Object localObject2;
    Object localObject1;
    if (!this.jdField_c_of_type_JavaUtilList.isEmpty())
    {
      localArrayList = new ArrayList(this.jdField_c_of_type_JavaUtilList);
      this.jdField_c_of_type_JavaUtilList.clear();
      localObject2 = beze.a(localArrayList);
      if (localObject2 != null) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = ((REPORT.StDcReportReq)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        betc.d("MiniProgramReporter", "performReportToServer", localException);
      }
      if (localObject1.length > 262144) {
        break label108;
      }
      a((byte[])localObject1, localArrayList, "mini_app_apireport", "DcReport");
      return;
      label108:
      i = localObject1.length / 262144 + 1;
      k = localArrayList.size() / i;
      betc.a("MiniProgramReporter", "performReportToServer: split into " + i + " count");
      j = 0;
      i = k;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int i;
      int k;
      int j;
      while (i <= localArrayList.size())
      {
        if ((j < i) && (j >= 0) && (i <= localArrayList.size()))
        {
          localObject1 = localArrayList.subList(j, i);
          REPORT.StDcReportReq localStDcReportReq = beze.a((List)localObject1);
          if (localStDcReportReq != null) {
            a(localStDcReportReq.toByteArray(), (List)localObject1, "mini_app_apireport", "DcReport");
          }
        }
        int m = i + k;
        if (m > localArrayList.size())
        {
          m = localArrayList.size();
          j = i;
          i = m;
        }
        else
        {
          j = i;
          i = m;
        }
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ArrayList localArrayList;
    Object localObject2;
    Object localObject1;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList.clear();
      localObject2 = beze.a(localArrayList);
      if (localObject2 != null) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = ((APP_REPORT_TRANSFER.StDataReportReq)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        betc.d("MiniProgramReporter", "performReportToServer", localException);
      }
      if (localObject1.length > 262144) {
        break label104;
      }
      a((byte[])localObject1, localArrayList);
      return;
      label104:
      i = localObject1.length / 262144 + 1;
      k = localArrayList.size() / i;
      betc.a("MiniProgramReporter", "performReportToServer: split into " + i + " count");
      j = 0;
      i = k;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      int i;
      int k;
      int j;
      while (i <= localArrayList.size())
      {
        if ((j < i) && (j >= 0) && (i <= localArrayList.size()))
        {
          localObject1 = localArrayList.subList(j, i);
          APP_REPORT_TRANSFER.StDataReportReq localStDataReportReq = beze.a((List)localObject1);
          if (localStDataReportReq != null) {
            a(localStDataReportReq.toByteArray(), (List)localObject1);
          }
        }
        int m = i + k;
        if (m > localArrayList.size())
        {
          m = localArrayList.size();
          j = i;
          i = m;
        }
        else
        {
          j = i;
          i = m;
        }
      }
    }
  }
  
  private void i()
  {
    if ((a()) || (this.jdField_a_of_type_JavaUtilList.size() >= 64)) {
      h();
    }
    if ((System.currentTimeMillis() - this.jdField_c_of_type_Long > TimeUnit.SECONDS.toMillis(600L)) || (this.jdField_c_of_type_JavaUtilList.size() >= 64)) {
      g();
    }
    if (this.d.size() >= 1) {
      d();
    }
    if (this.e.size() >= 1) {
      e();
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a()
  {
    k = 64;
    i = 10;
    try
    {
      j = bema.a("MiniApp", "mini_app_report_time_threshold", 10);
      i = j;
      int m = bema.a("MiniApp", "mini_app_report_count_threshold", 64);
      i = m;
      k = j;
      j = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j = k;
        k = i;
      }
    }
    if ((System.currentTimeMillis() - this.jdField_b_of_type_Long > TimeUnit.SECONDS.toMillis(k * 60)) || (this.jdField_b_of_type_JavaUtilList.size() >= j) || (this.jdField_a_of_type_Boolean))
    {
      c();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniProgramReporter.4(this, paramSingleDcData));
  }
  
  public void a(REPORT.SingleDcData paramSingleDcData)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniProgramReporter.3(this, paramSingleDcData));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  public void a(Collection<? extends REPORT.SingleDcData> paramCollection)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniProgramReporter.5(this, paramCollection));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniProgramReporter.7(this));
  }
  
  public void b(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilList.add(paramSingleDcData);
      a();
      return;
    }
    finally
    {
      paramSingleDcData = finally;
      throw paramSingleDcData;
    }
  }
  
  public void b(Collection<? extends APP_REPORT_TRANSFER.SingleDcData> paramCollection)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MiniProgramReporter.6(this, paramCollection));
  }
  
  public void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bezf
 * JD-Core Version:    0.7.0.1
 */