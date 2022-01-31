import android.os.Environment;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Laxuh;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager.ProxyIp;

public class axou
  implements axrt, axta, axzn, baky
{
  protected static axrs a;
  protected static axtx a;
  private static Object jdField_a_of_type_JavaLangObject;
  private static ArrayList<axvs> jdField_a_of_type_JavaUtilArrayList;
  static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static String j;
  private int jdField_a_of_type_Int;
  public axos a;
  protected axow a;
  public axqf a;
  public axrr a;
  protected axsp a;
  public axvt a;
  protected axyg a;
  protected AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public HashMap<String, String> a;
  protected List<ProxyIpManager.ProxyIp> a;
  private boolean jdField_a_of_type_Boolean;
  String a_ = "P";
  private int b;
  protected axow b;
  protected axow c = new axow();
  int d;
  protected axow d;
  int e;
  int f = -9530;
  int g = -9531;
  int jdField_h_of_type_Int = -9532;
  String jdField_h_of_type_JavaLangString = "Q";
  protected boolean h;
  int i;
  public String i;
  protected boolean i;
  public int j;
  protected boolean j;
  int k;
  public long k;
  protected boolean k;
  protected int l;
  protected long l;
  boolean l;
  protected int m;
  long m;
  protected boolean m;
  protected int n;
  long jdField_n_of_type_Long = 0L;
  boolean jdField_n_of_type_Boolean = false;
  protected int o;
  long o;
  protected boolean o;
  protected long p;
  boolean p;
  
  static
  {
    jdField_a_of_type_Axtx = new axtx();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_j_of_type_JavaLangString = "param_reason";
    jdField_a_of_type_Axrs = new axov();
  }
  
  public axou(axos paramaxos, axvt paramaxvt)
  {
    this.jdField_d_of_type_Int = -9528;
    this.jdField_e_of_type_Int = -9529;
    this.jdField_i_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Axow = new axow();
    this.jdField_b_of_type_Axow = new axow();
    this.jdField_d_of_type_Axow = new axow();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramaxos.jdField_a_of_type_ComTencentCommonAppAppInterface;
    this.jdField_k_of_type_Long = System.nanoTime();
    atpg.a("BaseTransProcessor", "TimeCompare", "Processor Start Time = " + this.jdField_k_of_type_Long + "ns,Processor = " + this);
    this.jdField_a_of_type_Axqf = new axqf();
    this.jdField_a_of_type_Axos = paramaxos;
    this.jdField_a_of_type_Axvt = paramaxvt;
    this.jdField_a_of_type_Axqf.jdField_b_of_type_Int = this.jdField_a_of_type_Axvt.jdField_b_of_type_Int;
    this.jdField_a_of_type_Axqf.jdField_b_of_type_Long = this.jdField_a_of_type_Axvt.jdField_a_of_type_Long;
    this.jdField_a_of_type_Axqf.jdField_h_of_type_Int = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    this.jdField_a_of_type_Axqf.q = this.jdField_a_of_type_Axvt.c;
    paramaxos = this.jdField_a_of_type_Axqf;
    if (this.jdField_a_of_type_Axvt.jdField_a_of_type_Boolean) {
      i1 = 0;
    }
    paramaxos.jdField_a_of_type_Int = i1;
    this.jdField_a_of_type_Axrr = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    k();
  }
  
  public axou(axvo paramaxvo)
  {
    this.jdField_d_of_type_Int = -9528;
    this.jdField_e_of_type_Int = -9529;
    this.jdField_i_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Axow = new axow();
    this.jdField_b_of_type_Axow = new axow();
    this.jdField_d_of_type_Axow = new axow();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_Axos = paramaxvo;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramaxvo.a;
    this.jdField_a_of_type_Axqf = new axqf();
    this.jdField_k_of_type_Long = System.nanoTime();
  }
  
  public axou(String paramString1, String paramString2, boolean paramBoolean, axvo paramaxvo)
  {
    this.jdField_d_of_type_Int = -9528;
    this.jdField_e_of_type_Int = -9529;
    this.jdField_i_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Axow = new axow();
    this.jdField_b_of_type_Axow = new axow();
    this.jdField_d_of_type_Axow = new axow();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_Axos = paramaxvo;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramaxvo.a;
    this.jdField_k_of_type_Long = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Axqf = new axqf(paramString1, paramString2, i1);
      this.jdField_a_of_type_Axqf.jdField_a_of_type_Axou = this;
      return;
      i1 = 1;
    }
  }
  
  public static String a(int paramInt, long paramLong)
  {
    return "H_" + paramInt + "_" + paramLong;
  }
  
  public static String a(long paramLong)
  {
    return "T_" + paramLong;
  }
  
  public static String a(Exception paramException)
  {
    return axob.a(paramException);
  }
  
  public static String a(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
  }
  
  public static void a(Message paramMessage, Class paramClass, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        axvs localaxvs;
        Object localObject2;
        do
        {
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localaxvs = (axvs)localIterator.next();
              localObject2 = localaxvs.getFilter();
            } while (((ArrayList)localObject2).isEmpty());
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        } while (!paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()));
        Message localMessage = localaxvs.obtainMessage();
        localMessage.what = paramMessage.what;
        localMessage.obj = paramMessage.obj;
        localMessage.arg1 = paramMessage.arg1;
        localaxvs.sendMessageDelayed(localMessage, paramLong);
      }
    }
  }
  
  private void a(axsq paramaxsq)
  {
    long l1 = 0L;
    if ((paramaxsq.h != 0L) && (this.jdField_p_of_type_Boolean)) {
      if (paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("X-httime") == null) {
        break label219;
      }
    }
    for (int i1 = Integer.parseInt((String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("X-httime"));; i1 = 0)
    {
      if (paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime"));
      }
      long l2 = i1 - l1;
      long l3 = paramaxsq.h - i1;
      this.jdField_n_of_type_Long += l3;
      this.jdField_m_of_type_Long += l2;
      this.jdField_o_of_type_Long += l1;
      this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_o_of_type_Int).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.jdField_o_of_type_Int += 1;
      this.jdField_p_of_type_Long = paramaxsq.i;
      return;
      label219:
      this.jdField_p_of_type_Boolean = false;
    }
  }
  
  public static void a(axvs paramaxvs)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramaxvs)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramaxvs);
      }
      return;
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Axos != null) && (this.jdField_a_of_type_Axos.jdField_a_of_type_Amfs != null)) {
      return this.jdField_a_of_type_Axos.jdField_a_of_type_Amfs.c;
    }
    return false;
  }
  
  public static boolean a(int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return true;
    }
    if ((paramInt == -9530) || (paramInt == -9532) || (paramInt == -9533) || (paramInt == -9531))
    {
      paramHashMap.put(jdField_j_of_type_JavaLangString, a("Q", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    if ((paramInt == -9528) || (paramInt == -9529))
    {
      paramHashMap.put(jdField_j_of_type_JavaLangString, a("P", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    return false;
  }
  
  static boolean a(List<ProxyIpManager.ProxyIp> paramList, List<axuh> paramList1)
  {
    if ((paramList1 == null) || (paramList == null) || (paramList.isEmpty()) || (paramList1.contains(paramList.get(0)))) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProxyIpManager.ProxyIp localProxyIp = (ProxyIpManager.ProxyIp)paramList.next();
      Object localObject = paramList1.iterator();
      while (((Iterator)localObject).hasNext())
      {
        axuh localaxuh = (axuh)((Iterator)localObject).next();
        if ((localProxyIp.ip.equals(localaxuh.jdField_a_of_type_JavaLangString)) && (localProxyIp.port == localaxuh.jdField_a_of_type_Int)) {
          paramList1.remove(localaxuh);
        }
      }
      localObject = new axuh();
      ((axuh)localObject).jdField_a_of_type_JavaLangString = localProxyIp.ip;
      ((axuh)localObject).jdField_a_of_type_Int = localProxyIp.port;
      localArrayList.add(localObject);
    }
    paramList1.addAll(0, localArrayList);
    return true;
  }
  
  public static String b(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  public static void b(axvs paramaxvs)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(paramaxvs);
      return;
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Axos != null) && (this.jdField_a_of_type_Axos.jdField_a_of_type_Amfs != null)) {
      return this.jdField_a_of_type_Axos.jdField_a_of_type_Amfs.d;
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    return "C_" + paramString;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Axqf != null)
    {
      if (this.jdField_a_of_type_Axqf.jdField_a_of_type_Int == 0) {
        d(1002);
      }
    }
    else {
      return;
    }
    d(2002);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i1 = g();
      if (i1 > this.jdField_n_of_type_Int) {
        this.jdField_n_of_type_Int = i1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Axvt != null) {
      if (!this.jdField_a_of_type_Axvt.jdField_a_of_type_Boolean) {
        break label195;
      }
    }
    label195:
    for (int i1 = 1004;; i1 = 2004)
    {
      d(i1);
      this.jdField_o_of_type_Boolean = true;
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Axvt != null)) {
        b("cancel", "");
      }
      if (this.jdField_a_of_type_Axyg != null)
      {
        axzm.b(this.jdField_a_of_type_Axyg);
        this.jdField_a_of_type_Axyg = null;
      }
      if (this.jdField_a_of_type_Axsp != null)
      {
        this.jdField_a_of_type_Axrr.b(this.jdField_a_of_type_Axsp);
        this.jdField_a_of_type_Axsp = null;
      }
      this.jdField_a_of_type_Axos.a(a());
      try
      {
        if (this.jdField_a_of_type_Axvt != null)
        {
          axwa localaxwa = this.jdField_a_of_type_Axvt.jdField_a_of_type_Axwa;
          if (localaxwa != null)
          {
            localaxwa.jdField_a_of_type_Int = -1;
            localaxwa.jdField_a_of_type_Long = 9037L;
            localaxwa.jdField_a_of_type_Axvt = this.jdField_a_of_type_Axvt;
          }
        }
        if (this.jdField_a_of_type_Axvt != null) {
          b("cancel", "");
        }
        notifyAll();
        if (this.jdField_a_of_type_Axvt != null) {
          b("cancel", "");
        }
        return 0;
      }
      finally {}
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Axqf.jdField_a_of_type_Long;
  }
  
  public axqf a()
  {
    return this.jdField_a_of_type_Axqf;
  }
  
  @Deprecated
  public axqg a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_Axqf.jdField_a_of_type_Axqg;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.jdField_a_of_type_Axqf.jdField_b_of_type_Axqg;
      } else if (paramInt == 2) {
        localObject1 = this.jdField_a_of_type_Axqf.jdField_a_of_type_Axqh;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Axqf.c;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Axqf.jdField_b_of_type_Axqh;
      }
    }
  }
  
  axvt a()
  {
    return this.jdField_a_of_type_Axvt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    return MessageForPtt.getLocalFilePath(paramInt, ajed.aU + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + axqf.a() + ".amr");
  }
  
  protected String a(String paramString, List<axuh> paramList)
  {
    Object localObject1 = null;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      paramList = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("PROXY_IP", 2, "[HTTP] proxy Ip List is empty use common conn!");
        paramList = paramString;
      }
    }
    axuh localaxuh;
    do
    {
      return paramList;
      localaxuh = axub.a(paramString);
      if (localaxuh != null) {
        break;
      }
      paramList = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip fail, host is domain");
    return paramString;
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    int i1 = 0;
    label88:
    Object localObject3;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ProxyIpManager.ProxyIp)((Iterator)localObject2).next();
      if ((!((ProxyIpManager.ProxyIp)localObject3).ip.equals(localaxuh.jdField_a_of_type_JavaLangString)) || (((ProxyIpManager.ProxyIp)localObject3).port != localaxuh.jdField_a_of_type_Int)) {
        break label617;
      }
      i1 = 1;
    }
    label617:
    for (;;)
    {
      break label88;
      if (i1 == 0)
      {
        localObject1 = (ProxyIpManager.ProxyIp)this.jdField_a_of_type_JavaUtilList.get(0);
        paramList = paramString;
        if (paramString == null) {
          break;
        }
        if (paramString.startsWith("http://")) {
          paramList = "http://" + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port + "/";
        }
      }
      for (;;)
      {
        paramString = axub.a(paramString, paramList);
        paramString = paramString + "&bHost=" + localaxuh.jdField_a_of_type_JavaLangString + "&bPort=" + localaxuh.jdField_a_of_type_Int;
        paramList = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port);
        return paramString;
        if (paramString.startsWith("https://"))
        {
          paramList = "https://" + ((ProxyIpManager.ProxyIp)localObject1).ip + ":" + ((ProxyIpManager.ProxyIp)localObject1).port + "/";
          continue;
          localObject3 = paramList.iterator();
          paramList = (List<axuh>)localObject1;
          do
          {
            localObject2 = paramList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (axuh)((Iterator)localObject3).next();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            do
            {
              localObject1 = paramList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (ProxyIpManager.ProxyIp)localIterator.next();
            } while ((((axuh)localObject2).jdField_a_of_type_JavaLangString.equals(((ProxyIpManager.ProxyIp)localObject1).ip)) || (((axuh)localObject2).jdField_a_of_type_Int == ((ProxyIpManager.ProxyIp)localObject1).port));
            localObject1 = localObject2;
            paramList = (List<axuh>)localObject1;
          } while (localObject1 == null);
          localObject2 = localObject1;
          localObject1 = paramString;
          if (localObject2 != null) {
            localObject1 = paramString + "&bHost=" + ((axuh)localObject2).jdField_a_of_type_JavaLangString + "&bPort=" + ((axuh)localObject2).jdField_a_of_type_Int;
          }
          paramList = (List<axuh>)localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + localaxuh.jdField_a_of_type_JavaLangString + ":" + localaxuh.jdField_a_of_type_Int);
          return localObject1;
        }
        paramList = null;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2, long paramLong)
  {
    b("updateUiState", "state:" + paramInt1 + " ret:" + paramInt2 + " currentProgress:" + this.jdField_b_of_type_Int + " mProgress:" + this.jdField_n_of_type_Int);
    if (((paramInt1 == 2005) || (paramInt1 == 1005)) && (this.jdField_j_of_type_Int == 9001))
    {
      String str = axob.a(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      awrn.a(BaseApplication.getContext()).a(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
    }
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    boolean bool;
    if ((l1 > 60000L) || (paramInt1 == 1005))
    {
      bool = true;
      if (l1 <= 60000L) {
        break label209;
      }
      axub.a(true, "image_sending_too_long");
    }
    for (;;)
    {
      b(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label209:
      axub.a(bool, "image_sending_" + this.jdField_j_of_type_Int + "_" + this.jdField_i_of_type_JavaLangString);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      axqh localaxqh = this.jdField_a_of_type_Axqf.jdField_a_of_type_Axqh;
      localaxqh.jdField_a_of_type_Int = paramInt1;
      localaxqh.jdField_a_of_type_Boolean = false;
      localaxqh.jdField_a_of_type_JavaLangString = paramString;
      localaxqh.jdField_e_of_type_Int = paramInt2;
      localaxqh.c = paramLong;
      b(localaxqh.jdField_a_of_type_Int, localaxqh.jdField_a_of_type_JavaLangString);
      c(2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      axqg localaxqg = a(paramInt1);
      if (localaxqg != null)
      {
        localaxqg.jdField_a_of_type_Int = paramInt2;
        localaxqg.jdField_a_of_type_JavaLangString = paramString;
        localaxqg.jdField_a_of_type_Boolean = false;
        c(paramInt1);
      }
      b(paramInt2, paramString);
      return;
    }
    finally {}
  }
  
  protected void a(int paramInt, long paramLong)
  {
    a(paramInt, 0, paramLong);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, axow paramaxow)
  {
    this.jdField_j_of_type_Int = paramInt;
    this.jdField_i_of_type_JavaLangString = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", paramString2);
    }
    if (paramaxow != null)
    {
      paramaxow.b();
      paramaxow.jdField_a_of_type_Int = 0;
    }
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      axqg localaxqg = a(paramInt);
      if ((localaxqg != null) && ((localaxqg.jdField_a_of_type_Long == 0L) || (paramBoolean))) {
        localaxqg.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Axqf.a(paramLong);
  }
  
  public void a(axow paramaxow, axsq paramaxsq, boolean paramBoolean)
  {
    if ((paramaxow == null) || (paramaxsq == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_Server", paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
      paramaxow.jdField_b_of_type_Int += 1;
      paramaxow.c += paramaxsq.jdField_d_of_type_Int - 1;
      paramaxow.b();
      paramaxow.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("firstserverip"));
    paramaxow.c += paramaxsq.jdField_d_of_type_Int;
    if (paramaxsq.jdField_b_of_type_Int == -9527) {}
    for (String str = (String)paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; str = null)
    {
      a(paramaxsq.jdField_b_of_type_Int, paramaxsq.jdField_a_of_type_JavaLangString, str, paramaxow);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("param_url"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((paramaxsq.jdField_b_of_type_Int == -9527) && ("H_404_-124".equals(str))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", paramaxsq.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      }
      paramaxow.jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(axow paramaxow, axzi paramaxzi)
  {
    if ((paramaxow != null) && (paramaxzi != null))
    {
      paramaxow.b();
      paramaxow.jdField_b_of_type_Int = paramaxzi.jdField_e_of_type_Int;
      paramaxow.c = paramaxzi.f;
      if (paramaxzi.c == 0) {
        paramaxow.jdField_a_of_type_Int = 1;
      }
    }
    else
    {
      return;
    }
    paramaxow.jdField_a_of_type_Int = 0;
    a(paramaxzi.jdField_d_of_type_Int, paramaxzi.g, paramaxzi.jdField_h_of_type_JavaLangString, paramaxow);
  }
  
  public void a(axow paramaxow, boolean paramBoolean1, boolean paramBoolean2, ajmn paramajmn)
  {
    if (paramajmn == null) {
      return;
    }
    paramaxow.b();
    if (paramBoolean2)
    {
      paramaxow.c = (paramajmn.c - 1);
      paramaxow.jdField_b_of_type_Int = 1;
      paramaxow.jdField_a_of_type_Int = 1;
      return;
    }
    String str;
    if (paramajmn.jdField_b_of_type_Int == 2900)
    {
      i1 = -9527;
      if (!paramBoolean1) {}
      for (str = b(paramajmn.jdField_a_of_type_Long);; str = a(paramajmn.jdField_a_of_type_Long))
      {
        a(i1, "", str, paramaxow);
        paramaxow.c = paramajmn.c;
        paramaxow.jdField_b_of_type_Int = 0;
        paramaxow.jdField_a_of_type_Int = 0;
        return;
      }
    }
    if ((paramajmn.jdField_b_of_type_Int == 1002) || (paramajmn.jdField_b_of_type_Int == 1013))
    {
      if (!paramBoolean1) {}
      for (i1 = 9350;; i1 = 9311)
      {
        str = paramajmn.jdField_a_of_type_JavaLangString;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i1 = 9351;; i1 = 9044)
    {
      str = paramajmn.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void a(axtc paramaxtc, axtb paramaxtb) {}
  
  public void a(axyg paramaxyg, axyv paramaxyv) {}
  
  public void a(bakw parambakw1, bakw parambakw2) {}
  
  public void a(IOException paramIOException)
  {
    paramIOException = paramIOException.getMessage();
    String str = Environment.getExternalStorageState();
    if (paramIOException.contains("EACCES")) {
      b(9039, paramIOException);
    }
    do
    {
      return;
      if (paramIOException.contains("ENOSPC"))
      {
        b(9040, paramIOException);
        return;
      }
      if (paramIOException.contains("Read-only"))
      {
        b(9039, paramIOException);
        return;
      }
    } while ("mounted".equals(str));
    b(9039, paramIOException);
  }
  
  public void a(String paramString) {}
  
  protected void a(boolean paramBoolean) {}
  
  public boolean a(bakw parambakw1, bakw parambakw2, int paramInt)
  {
    return true;
  }
  
  public void aU_() {}
  
  public int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Axqf.jdField_e_of_type_Long;
  }
  
  protected String b()
  {
    return null;
  }
  
  public void b() {}
  
  @Deprecated
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.jdField_o_of_type_Boolean) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        axvs localaxvs;
        do
        {
          Object localObject3;
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              localaxvs = (axvs)localIterator.next();
              localObject3 = localaxvs.getFilter();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localaxvs.obtainMessage();
        this.jdField_a_of_type_Axqf.jdField_e_of_type_Int = this.jdField_a_of_type_Axqf.jdField_d_of_type_Int;
        this.jdField_a_of_type_Axqf.jdField_d_of_type_Int = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.jdField_a_of_type_Axqf;
        ((Message)localObject4).arg1 = paramInt2;
        localaxvs.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, null, null);
  }
  
  public void b(bakw parambakw1, bakw parambakw2) {}
  
  public void b(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Axqf == null) {
      atpg.b("BaseTransProcessor", "logRichMediaEvent", "file is null !");
    }
    do
    {
      return;
      if (!(this instanceof axun)) {
        break;
      }
    } while (this.jdField_a_of_type_Axvt == null);
    axub.a("T", axub.b(this.jdField_a_of_type_Axvt.jdField_a_of_type_Int), axub.c(this.jdField_a_of_type_Axqf.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Axqf.jdField_b_of_type_Long), paramString1, paramString2, null);
    return;
    int i1 = -1;
    if (this.jdField_a_of_type_Axvt != null) {
      i1 = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    }
    if ((this instanceof axoy))
    {
      i1 = 0;
      if (this.jdField_a_of_type_Axvt == null) {
        break label162;
      }
      bool = this.jdField_a_of_type_Axvt.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      axub.a(axub.b(i1), bool, axub.c(this.jdField_a_of_type_Axqf.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Axqf.jdField_b_of_type_Long), paramString1, paramString2);
      return;
      if (!(this instanceof axpc)) {
        break;
      }
      i1 = 0;
      break;
      label162:
      if (this.jdField_a_of_type_Axqf.jdField_a_of_type_Int == 0) {
        bool = true;
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6") != null) && (((String)this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6")).equals(String.valueOf(1)))) {
      awrn.a(BaseApplication.getContext()).a(null, b() + "_ipv6", paramBoolean, paramLong, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Axqf.jdField_d_of_type_Int;
  }
  
  public void c() {}
  
  @Deprecated
  public void c(int paramInt)
  {
    try
    {
      axqg localaxqg = a(paramInt);
      if (localaxqg != null) {
        localaxqg.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean c()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public long d()
  {
    return this.jdField_a_of_type_Axqf.jdField_e_of_type_Int;
  }
  
  protected void d()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isRunning())) {
      b(9366, "account switch");
    }
    b("onError", "elapsed:" + l1 + " errCode:" + this.jdField_j_of_type_Int + " errDesc:" + this.jdField_i_of_type_JavaLangString + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason"));
    a(false);
    this.jdField_a_of_type_Axos.a(a());
  }
  
  public void d(int paramInt)
  {
    a(paramInt, 0L);
  }
  
  public void d(boolean paramBoolean) {}
  
  public boolean d()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public int e()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    b("onSuccess", "elapsed:" + l1 + ",key:" + a());
    a(true);
    this.jdField_a_of_type_Axos.a(a());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Axqf.a(paramInt);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected boolean e()
  {
    return (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isRunning()) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin());
  }
  
  public int f()
  {
    int i2 = 0;
    int i1;
    if (this.jdField_a_of_type_Boolean) {
      i1 = this.jdField_n_of_type_Int;
    }
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (this.jdField_a_of_type_Axqf == null);
      i1 = i2;
    } while (this.jdField_a_of_type_Axqf.jdField_a_of_type_Long <= 0L);
    return (int)(this.jdField_a_of_type_Axqf.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Axqf.jdField_a_of_type_Long);
  }
  
  protected void f(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_j_of_type_Int == 0)) {
      QLog.d("BaseTransProcessor", 1, new Throwable().getStackTrace());
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_check_result", String.valueOf(paramBoolean));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_check_FailCode", String.valueOf(this.jdField_j_of_type_Int));
  }
  
  protected boolean f()
  {
    return (!this.jdField_o_of_type_Boolean) && (!this.jdField_k_of_type_Boolean);
  }
  
  public int g()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.jdField_a_of_type_Axqf != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_Axqf.jdField_a_of_type_Long > 0L)
      {
        i2 = (int)(this.jdField_a_of_type_Axqf.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Axqf.jdField_a_of_type_Long);
        i1 = i2;
        if (this.jdField_a_of_type_Axqf.jdField_a_of_type_Int == 0) {
          if (this.jdField_a_of_type_Axqf.jdField_b_of_type_Int != 1)
          {
            i1 = i2;
            if (this.jdField_a_of_type_Axqf.jdField_b_of_type_Int != 131075) {}
          }
          else
          {
            i1 = i2;
            if (i2 == 100)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Axqf.jdField_d_of_type_Int != 1003) {
                i1 = 99;
              }
            }
          }
        }
      }
    }
    return i1;
  }
  
  protected boolean g()
  {
    if (!AppSetting.a())
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", String.valueOf(0));
      return false;
    }
    if (!a())
    {
      b("httpDown", "richmedia_down_ipv6_switch is false ");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", String.valueOf(0));
      return false;
    }
    int i1 = NetConnInfoCenter.getActiveNetIpFamily(true);
    this.jdField_a_of_type_JavaUtilHashMap.put("param_net_ip_type", String.valueOf(i1));
    b("httpDown", "isIpv6, getActiveNetIpFamily = " + i1);
    if (i1 == 2)
    {
      b("httpDown", "isIpv6, true ");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", String.valueOf(1));
      return true;
    }
    if ((i1 == 3) && (b()))
    {
      b("httpDown", "richmedia_down_dual_ipv6_switch is true ");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", String.valueOf(1));
      return true;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", String.valueOf(0));
    return false;
  }
  
  protected boolean h()
  {
    return NetConnInfoCenter.getActiveNetIpFamily(true) == 3;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Axqf != null)
    {
      g();
      f();
    }
  }
  
  public void j() {}
  
  public void k()
  {
    boolean bool = false;
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_Axvt.b());
    if (localInteger == null) {}
    for (int i1 = 0;; i1 = localInteger.intValue())
    {
      this.jdField_m_of_type_Int = i1;
      if (this.jdField_a_of_type_Axvt.jdField_d_of_type_Int < 3) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      return;
    }
  }
  
  public void l()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_Axvt.b(), Integer.valueOf(this.jdField_m_of_type_Int));
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 2000) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  protected void m()
  {
    this.jdField_j_of_type_Int = 0;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  protected void n() {}
  
  public void onResp(axsq paramaxsq)
  {
    a(paramaxsq);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axou
 * JD-Core Version:    0.7.0.1
 */