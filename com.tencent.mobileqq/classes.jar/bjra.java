import NS_MOBILE_FEEDS.mobile_online_report_item;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService.1;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService.2;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService.3;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class bjra
{
  private static bjra jdField_a_of_type_Bjra;
  int jdField_a_of_type_Int = 0;
  public long a;
  private mobile_online_report_item jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QzoneOnlineTimeCollectRptService.3(this);
  private String jdField_a_of_type_JavaLangString = "QZonlinetime";
  private ArrayList<mobile_online_report_item> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 10000;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "QZonlinetimeLastRecord";
  private ArrayList<mobile_online_report_item> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  private bjra()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static final bjra a()
  {
    if (jdField_a_of_type_Bjra == null) {
      jdField_a_of_type_Bjra = new bjra();
    }
    return jdField_a_of_type_Bjra;
  }
  
  private void a(ArrayList<mobile_online_report_item> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramArrayList = new ArrayList(paramArrayList);
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext(), bjrb.class);
      localNewIntent.putExtra("list", paramArrayList);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
      return;
    }
    QLog.e("QzoneOnlineTimeCollectRptService", 1, "There is no record to report!");
  }
  
  private boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    if (this.jdField_b_of_type_Long != 0L)
    {
      if ((System.currentTimeMillis() / 1000L - this.jdField_b_of_type_Long > localQzoneConfig.getConfig("ClientReport", "OnlineReportInterval", 3600)) || (this.jdField_a_of_type_JavaUtilArrayList.size() >= localQzoneConfig.getConfig("ClientReport", "OnlineReportFrequency", 1))) {
        bool1 = true;
      }
      return bool1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= localQzoneConfig.getConfig("ClientReport", "OnlineReportFrequency", 1)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    long l1 = this.jdField_a_of_type_Long;
    String str = LocalMultiProcConfig.getString(this.jdField_a_of_type_JavaLangString + "_" + l1, "");
    Object localObject2 = LocalMultiProcConfig.getString(this.jdField_b_of_type_JavaLangString + "_" + l1, "");
    long l2 = LocalMultiProcConfig.getLong("key_sp_qzone_crash_time_" + l1, 0L);
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "sp:" + this.jdField_a_of_type_JavaLangString + " lost time:" + (String)localObject2 + " sp:" + this.jdField_b_of_type_JavaLangString + " crash time:" + l2);
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (l2 != 0L)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaLangString.equals("QZonlinetime")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(";")) + ";" + l2;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(str)) {
        localObject2 = str + ";" + (String)localObject1;
      }
      LocalMultiProcConfig.putString(this.jdField_a_of_type_JavaLangString + "_" + l1, (String)localObject2);
      LocalMultiProcConfig.putString(this.jdField_b_of_type_JavaLangString + "_" + l1, "");
    }
    for (;;)
    {
      LocalMultiProcConfig.putLong("key_sp_qzone_crash_time_" + l1, 0L);
      QLog.d("QzoneOnlineTimeCollectRptService", 1, "s:" + (String)localObject2);
      localObject1 = ((String)localObject2).split(";");
      if ((localObject1 == null) || (localObject1.length <= 1)) {
        break;
      }
      int i = 0;
      try
      {
        while (i < localObject1.length)
        {
          localObject2 = new mobile_online_report_item(l1, Long.parseLong(localObject1[i]), Long.parseLong(localObject1[(i + 1)]));
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          i += 2;
        }
        localObject2 = str;
      }
      catch (Exception localException)
      {
        QLog.e("QzoneOnlineTimeCollectRptService", 1, "e:" + localException.toString());
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 1) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null)) {
          this.jdField_b_of_type_Long = ((mobile_online_report_item)this.jdField_a_of_type_JavaUtilArrayList.get(0)).uptime;
        }
        g();
        return;
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        mobile_online_report_item localmobile_online_report_item = (mobile_online_report_item)localIterator.next();
        if (localmobile_online_report_item != null) {
          localStringBuilder.append(localmobile_online_report_item.uptime + ";" + localmobile_online_report_item.downtime + ";");
        }
      }
      if (localStringBuilder.length() == 0) {
        break label252;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      LocalMultiProcConfig.putString(this.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_Long, localStringBuilder.toString());
      QLog.d("QzoneOnlineTimeCollectRptService", 1, "saveData mReportItems size:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " mLastReportTime:" + this.jdField_b_of_type_Long + " re:" + localStringBuilder.toString());
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    for (;;)
    {
      LocalMultiProcConfig.putString(this.jdField_b_of_type_JavaLangString + "_" + this.jdField_a_of_type_Long, "");
      return;
      label252:
      QLog.w("QzoneOnlineTimeCollectRptService", 1, "re length:0");
    }
  }
  
  private void g()
  {
    try
    {
      if (a())
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        if (this.jdField_a_of_type_Long != 0L) {
          a(this.jdField_b_of_type_JavaUtilArrayList);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(new QzoneOnlineTimeCollectRptService.2(this));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_JavaLangString = "QZonlinetime";
      this.jdField_b_of_type_JavaLangString = "QZonlinetimeLastRecord";
      return;
    case 1: 
      this.jdField_a_of_type_JavaLangString = "QZonlinetime_web";
      this.jdField_b_of_type_JavaLangString = "QZonlinetimeLastRecord_web";
      return;
    case 3: 
      this.jdField_a_of_type_JavaLangString = "QZonlinetime_picture";
      this.jdField_b_of_type_JavaLangString = "QZonlinetimeLastRecord_picture";
      return;
    }
    this.jdField_a_of_type_JavaLangString = "QZonlinetime_video";
    this.jdField_b_of_type_JavaLangString = "QZonlinetimeLastRecord_video";
  }
  
  public void a(mobile_online_report_item parammobile_online_report_item)
  {
    if ((parammobile_online_report_item != null) && (parammobile_online_report_item.uptime != 0L) && (parammobile_online_report_item.downtime != 0L)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(parammobile_online_report_item);
    }
    g();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 328	bjra:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   6: ifnonnull +31 -> 37
    //   9: aload_0
    //   10: new 225	NS_MOBILE_FEEDS/mobile_online_report_item
    //   13: dup
    //   14: invokespecial 329	NS_MOBILE_FEEDS/mobile_online_report_item:<init>	()V
    //   17: putfield 328	bjra:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   20: aload_0
    //   21: getfield 328	bjra:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   24: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   27: ldc2_w 126
    //   30: ldiv
    //   31: putfield 247	NS_MOBILE_FEEDS/mobile_online_report_item:uptime	J
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 328	bjra:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   41: lconst_0
    //   42: putfield 266	NS_MOBILE_FEEDS/mobile_online_report_item:downtime	J
    //   45: aload_0
    //   46: getfield 328	bjra:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   49: lconst_0
    //   50: putfield 332	NS_MOBILE_FEEDS/mobile_online_report_item:loginuin	J
    //   53: aload_0
    //   54: getfield 328	bjra:jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item	LNS_MOBILE_FEEDS/mobile_online_report_item;
    //   57: lconst_0
    //   58: putfield 247	NS_MOBILE_FEEDS/mobile_online_report_item:uptime	J
    //   61: goto -41 -> 20
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	bjra
    //   64	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	64	finally
    //   20	34	64	finally
    //   37	61	64	finally
  }
  
  public void b(int paramInt)
  {
    a(paramInt);
    ThreadManager.getSubThreadHandler().post(new QzoneOnlineTimeCollectRptService.1(this));
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item != null)
      {
        this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (System.currentTimeMillis() / 1000L);
        this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.loginuin = this.jdField_a_of_type_Long;
        a(this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt != 1000)
    {
      QLog.w("QzoneOnlineTimeCollectRptService", 1, "QzoneOnlineTimeCollectRptService report failure resultCode:" + paramInt + " RetryTimes:" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int < 2)
      {
        a(this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Int += 1;
      }
      return;
    }
    QLog.d("QzoneOnlineTimeCollectRptService", 1, "QzoneOnlineTimeCollectRptService task succeed!");
    this.jdField_a_of_type_Int = 0;
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      paramInt = 0;
      while (paramInt < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        QLog.d("QzoneOnlineTimeCollectRptService", 1, "sp:" + this.jdField_a_of_type_JavaLangString + " report uptime:" + ((mobile_online_report_item)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).uptime + " downtime:" + ((mobile_online_report_item)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).downtime);
        paramInt += 1;
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    LocalMultiProcConfig.putString(this.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_Long, "");
    LocalMultiProcConfig.putString(this.jdField_b_of_type_JavaLangString + "_" + this.jdField_a_of_type_Long, "");
  }
  
  public void d()
  {
    mobile_online_report_item localmobile_online_report_item;
    if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item != null)
    {
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime <= 0L) {
        break label185;
      }
      this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (System.currentTimeMillis() / 1000L);
      if (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime == this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime) {
        localmobile_online_report_item = this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item;
      }
    }
    for (localmobile_online_report_item.downtime += 1L;; this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime = (this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime + 1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneOnlineTimeCollectRptService", 2, "update sp:" + this.jdField_b_of_type_JavaLangString + " last time:" + this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime);
      }
      LocalMultiProcConfig.putString(this.jdField_b_of_type_JavaLangString + "_" + this.jdField_a_of_type_Long, this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime + ";" + this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.downtime);
      return;
      label185:
      this.jdField_a_of_type_NS_MOBILE_FEEDSMobile_online_report_item.uptime = (System.currentTimeMillis() / 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjra
 * JD-Core Version:    0.7.0.1
 */