import android.os.Environment;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.ipv6.Ipv6Flags;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbewy;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager.ProxyIp;

public class berp
  implements beuq, bevw, bfcb, bhvc
{
  protected static beup a;
  private static Object jdField_a_of_type_JavaLangObject;
  private static ArrayList<beyf> jdField_a_of_type_JavaUtilArrayList;
  static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static String k;
  private int jdField_a_of_type_Int;
  public bern a;
  protected berr a;
  public bete a;
  public beuo a;
  protected bevl a;
  protected bewo a;
  public beyg a;
  protected bfau a;
  protected bfci a;
  protected AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  protected HashMap<String, String> a;
  protected List<ProxyIpManager.ProxyIp> a;
  private boolean jdField_a_of_type_Boolean;
  String a_ = "P";
  private int b;
  protected berr b;
  protected berr c = new berr();
  protected berr d = new berr();
  int e;
  int f = -9529;
  int g = -9530;
  int jdField_h_of_type_Int = -9531;
  String jdField_h_of_type_JavaLangString = "Q";
  int i;
  public String i;
  int j;
  public String j;
  protected boolean j;
  public int k;
  public long k;
  protected boolean k;
  int l;
  protected long l;
  protected boolean l;
  protected int m;
  long jdField_m_of_type_Long = 0L;
  boolean jdField_m_of_type_Boolean = false;
  protected int n;
  long jdField_n_of_type_Long = 0L;
  boolean jdField_n_of_type_Boolean = false;
  protected int o;
  long jdField_o_of_type_Long = 0L;
  boolean jdField_o_of_type_Boolean = false;
  protected int p;
  protected long p;
  boolean p;
  boolean q = false;
  boolean r = true;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_k_of_type_JavaLangString = "param_reason";
    jdField_a_of_type_Beup = new berq();
  }
  
  public berp()
  {
    this.jdField_e_of_type_Int = -9528;
    this.jdField_i_of_type_Int = -9532;
    this.jdField_j_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_k_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = 0;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 0;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_Bfci = new bfci();
    this.jdField_a_of_type_Berr = new berr();
    this.jdField_b_of_type_Berr = new berr();
    this.jdField_p_of_type_Boolean = false;
  }
  
  public berp(bern parambern, beyg parambeyg)
  {
    this.jdField_e_of_type_Int = -9528;
    this.jdField_i_of_type_Int = -9532;
    this.jdField_j_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_k_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = 0;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 0;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_Bfci = new bfci();
    this.jdField_a_of_type_Berr = new berr();
    this.jdField_b_of_type_Berr = new berr();
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = parambern.jdField_a_of_type_ComTencentCommonAppAppInterface;
    this.jdField_k_of_type_Long = System.nanoTime();
    azpw.a("BaseTransProcessor", "TimeCompare", "Processor Start Time = " + this.jdField_k_of_type_Long + "ns,Processor = " + this);
    this.jdField_a_of_type_Bete = new bete();
    this.jdField_a_of_type_Bern = parambern;
    this.jdField_a_of_type_Beyg = parambeyg;
    this.jdField_a_of_type_Bete.jdField_b_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bete.jdField_b_of_type_Long = this.jdField_a_of_type_Beyg.jdField_a_of_type_Long;
    this.jdField_a_of_type_Bete.jdField_h_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bete.q = this.jdField_a_of_type_Beyg.c;
    parambern = this.jdField_a_of_type_Bete;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Boolean) {
      i1 = 0;
    }
    parambern.jdField_a_of_type_Int = i1;
    this.jdField_a_of_type_Beuo = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    l();
  }
  
  public berp(beyb parambeyb)
  {
    this.jdField_e_of_type_Int = -9528;
    this.jdField_i_of_type_Int = -9532;
    this.jdField_j_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_k_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = 0;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 0;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_Bfci = new bfci();
    this.jdField_a_of_type_Berr = new berr();
    this.jdField_b_of_type_Berr = new berr();
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_Bern = parambeyb;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = parambeyb.a;
    this.jdField_a_of_type_Bete = new bete();
    this.jdField_k_of_type_Long = System.nanoTime();
  }
  
  public berp(String paramString1, String paramString2, boolean paramBoolean, beyb parambeyb)
  {
    this.jdField_e_of_type_Int = -9528;
    this.jdField_i_of_type_Int = -9532;
    this.jdField_j_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_k_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = 0;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_n_of_type_Int = 0;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_Bfci = new bfci();
    this.jdField_a_of_type_Berr = new berr();
    this.jdField_b_of_type_Berr = new berr();
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_Bern = parambeyb;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = parambeyb.a;
    this.jdField_k_of_type_Long = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Bete = new bete(paramString1, paramString2, i1);
      this.jdField_a_of_type_Bete.jdField_a_of_type_Berp = this;
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
    return bera.a(paramException);
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
        beyf localbeyf;
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
              localbeyf = (beyf)localIterator.next();
              localObject2 = localbeyf.getFilter();
            } while (((ArrayList)localObject2).isEmpty());
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        } while (!paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()));
        Message localMessage = localbeyf.obtainMessage();
        localMessage.what = paramMessage.what;
        localMessage.obj = paramMessage.obj;
        localMessage.arg1 = paramMessage.arg1;
        localbeyf.sendMessageDelayed(localMessage, paramLong);
      }
    }
  }
  
  private void a(bevm parambevm)
  {
    long l1 = 0L;
    if ((parambevm.g != 0L) && (this.r)) {
      if (parambevm.jdField_a_of_type_JavaUtilHashMap.get("X-httime") == null) {
        break label219;
      }
    }
    for (int i1 = Integer.parseInt((String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("X-httime"));; i1 = 0)
    {
      if (parambevm.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime"));
      }
      long l2 = i1 - l1;
      long l3 = parambevm.g - i1;
      this.jdField_n_of_type_Long += l3;
      this.jdField_m_of_type_Long += l2;
      this.jdField_o_of_type_Long += l1;
      this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_p_of_type_Int).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.jdField_p_of_type_Int += 1;
      this.jdField_p_of_type_Long = parambevm.h;
      return;
      label219:
      this.r = false;
    }
  }
  
  public static void a(beyf parambeyf)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(parambeyf)) {
        jdField_a_of_type_JavaUtilArrayList.add(parambeyf);
      }
      return;
    }
  }
  
  public static boolean a(int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return true;
    }
    if ((paramInt == -9530) || (paramInt == -9532) || (paramInt == -9533) || (paramInt == -9531))
    {
      paramHashMap.put(jdField_k_of_type_JavaLangString, a("Q", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    if ((paramInt == -9528) || (paramInt == -9529))
    {
      paramHashMap.put(jdField_k_of_type_JavaLangString, a("P", paramInt));
      paramHashMap.put("param_FailCode", Integer.toString(-9527));
      return true;
    }
    return false;
  }
  
  static boolean a(List<ProxyIpManager.ProxyIp> paramList, List<bewy> paramList1)
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
        bewy localbewy = (bewy)((Iterator)localObject).next();
        if ((localProxyIp.ip.equals(localbewy.jdField_a_of_type_JavaLangString)) && (localProxyIp.port == localbewy.jdField_a_of_type_Int)) {
          paramList1.remove(localbewy);
        }
      }
      localObject = new bewy();
      ((bewy)localObject).jdField_a_of_type_JavaLangString = localProxyIp.ip;
      ((bewy)localObject).jdField_a_of_type_Int = localProxyIp.port;
      localArrayList.add(localObject);
    }
    paramList1.addAll(0, localArrayList);
    return true;
  }
  
  public static String b(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  public static void b(beyf parambeyf)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(parambeyf);
      return;
    }
  }
  
  public static String c(String paramString)
  {
    return "C_" + paramString;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bete != null)
    {
      if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int == 0) {
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
      if (i1 > this.jdField_o_of_type_Int) {
        this.jdField_o_of_type_Int = i1;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Beyg != null) {
      if (!this.jdField_a_of_type_Beyg.jdField_a_of_type_Boolean) {
        break label195;
      }
    }
    label195:
    for (int i1 = 1004;; i1 = 2004)
    {
      d(i1);
      this.q = true;
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Beyg != null)) {
        b("cancel", "");
      }
      if (this.jdField_a_of_type_Bfau != null)
      {
        bfca.b(this.jdField_a_of_type_Bfau);
        this.jdField_a_of_type_Bfau = null;
      }
      if (this.jdField_a_of_type_Bevl != null)
      {
        this.jdField_a_of_type_Beuo.b(this.jdField_a_of_type_Bevl);
        this.jdField_a_of_type_Bevl = null;
      }
      this.jdField_a_of_type_Bern.a(b());
      try
      {
        if (this.jdField_a_of_type_Beyg != null)
        {
          beyn localbeyn = this.jdField_a_of_type_Beyg.jdField_a_of_type_Beyn;
          if (localbeyn != null)
          {
            localbeyn.jdField_a_of_type_Int = -1;
            localbeyn.jdField_a_of_type_Long = 9037L;
            localbeyn.jdField_a_of_type_Beyg = this.jdField_a_of_type_Beyg;
          }
        }
        if (this.jdField_a_of_type_Beyg != null) {
          b("cancel", "");
        }
        notifyAll();
        if (this.jdField_a_of_type_Beyg != null) {
          b("cancel", "");
        }
        return 0;
      }
      finally {}
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bete.jdField_a_of_type_Long;
  }
  
  public bete a()
  {
    return this.jdField_a_of_type_Bete;
  }
  
  @Deprecated
  public betf a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_Bete.jdField_a_of_type_Betf;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.jdField_a_of_type_Bete.jdField_b_of_type_Betf;
      } else if (paramInt == 2) {
        localObject1 = this.jdField_a_of_type_Bete.jdField_a_of_type_Betg;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Bete.c;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Bete.jdField_b_of_type_Betg;
      }
    }
  }
  
  beyg a()
  {
    return this.jdField_a_of_type_Beyg;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    return MessageForPtt.getLocalFilePath(paramInt, antf.ba + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + bete.a() + ".amr");
  }
  
  protected String a(String paramString, List<bewy> paramList)
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
    bewy localbewy;
    do
    {
      return paramList;
      localbewy = bews.a(paramString);
      if (localbewy != null) {
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
      if ((!((ProxyIpManager.ProxyIp)localObject3).ip.equals(localbewy.jdField_a_of_type_JavaLangString)) || (((ProxyIpManager.ProxyIp)localObject3).port != localbewy.jdField_a_of_type_Int)) {
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
        paramString = bews.a(paramString, paramList);
        paramString = paramString + "&bHost=" + localbewy.jdField_a_of_type_JavaLangString + "&bPort=" + localbewy.jdField_a_of_type_Int;
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
          paramList = (List<bewy>)localObject1;
          do
          {
            localObject2 = paramList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (bewy)((Iterator)localObject3).next();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            do
            {
              localObject1 = paramList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (ProxyIpManager.ProxyIp)localIterator.next();
            } while ((((bewy)localObject2).jdField_a_of_type_JavaLangString.equals(((ProxyIpManager.ProxyIp)localObject1).ip)) || (((bewy)localObject2).jdField_a_of_type_Int == ((ProxyIpManager.ProxyIp)localObject1).port));
            localObject1 = localObject2;
            paramList = (List<bewy>)localObject1;
          } while (localObject1 == null);
          localObject2 = localObject1;
          localObject1 = paramString;
          if (localObject2 != null) {
            localObject1 = paramString + "&bHost=" + ((bewy)localObject2).jdField_a_of_type_JavaLangString + "&bPort=" + ((bewy)localObject2).jdField_a_of_type_Int;
          }
          paramList = (List<bewy>)localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + localbewy.jdField_a_of_type_JavaLangString + ":" + localbewy.jdField_a_of_type_Int);
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
    b("updateUiState", "state:" + paramInt1 + " ret:" + paramInt2 + " currentProgress:" + this.jdField_b_of_type_Int + " mProgress:" + this.jdField_o_of_type_Int);
    if (((paramInt1 == 2005) || (paramInt1 == 1005)) && (this.jdField_k_of_type_Int == 9001))
    {
      String str = bera.a(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      bdmc.a(BaseApplication.getContext()).a(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
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
      bews.a(true, "image_sending_too_long");
    }
    for (;;)
    {
      b(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label209:
      bews.a(bool, "image_sending_" + this.jdField_k_of_type_Int + "_" + this.jdField_j_of_type_JavaLangString);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      betg localbetg = this.jdField_a_of_type_Bete.jdField_a_of_type_Betg;
      localbetg.jdField_a_of_type_Int = paramInt1;
      localbetg.jdField_a_of_type_Boolean = false;
      localbetg.jdField_a_of_type_JavaLangString = paramString;
      localbetg.jdField_e_of_type_Int = paramInt2;
      localbetg.c = paramLong;
      b(localbetg.jdField_a_of_type_Int, localbetg.jdField_a_of_type_JavaLangString);
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
      betf localbetf = a(paramInt1);
      if (localbetf != null)
      {
        localbetf.jdField_a_of_type_Int = paramInt2;
        localbetf.jdField_a_of_type_JavaLangString = paramString;
        localbetf.jdField_a_of_type_Boolean = false;
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
  
  public void a(int paramInt, String paramString1, String paramString2, berr paramberr)
  {
    this.jdField_k_of_type_Int = paramInt;
    this.jdField_i_of_type_JavaLangString = paramString2;
    this.jdField_j_of_type_JavaLangString = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", paramString2);
    }
    if (paramberr != null)
    {
      paramberr.b();
      paramberr.jdField_a_of_type_Int = 0;
    }
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      betf localbetf = a(paramInt);
      if ((localbetf != null) && ((localbetf.jdField_a_of_type_Long == 0L) || (paramBoolean))) {
        localbetf.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bete.a(paramLong);
  }
  
  public void a(berr paramberr, bevm parambevm, boolean paramBoolean)
  {
    if ((paramberr == null) || (parambevm == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_Server", parambevm.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("serverip", parambevm.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
      paramberr.jdField_b_of_type_Int += 1;
      paramberr.c += parambevm.d - 1;
      paramberr.b();
      paramberr.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("serverip", parambevm.jdField_a_of_type_JavaUtilHashMap.get("firstserverip"));
    paramberr.c += parambevm.d;
    if (parambevm.jdField_b_of_type_Int == -9527) {}
    for (String str = (String)parambevm.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; str = null)
    {
      a(parambevm.jdField_b_of_type_Int, parambevm.jdField_a_of_type_JavaLangString, str, paramberr);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", parambevm.jdField_a_of_type_JavaUtilHashMap.get("param_url"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambevm.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((parambevm.jdField_b_of_type_Int == -9527) && ("H_404_-124".equals(str))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambevm.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      }
      paramberr.jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(berr paramberr, bfbw parambfbw)
  {
    if ((paramberr != null) && (parambfbw != null))
    {
      paramberr.b();
      paramberr.jdField_b_of_type_Int = parambfbw.jdField_e_of_type_Int;
      paramberr.c = parambfbw.f;
      if (parambfbw.c == 0) {
        paramberr.jdField_a_of_type_Int = 1;
      }
    }
    else
    {
      return;
    }
    paramberr.jdField_a_of_type_Int = 0;
    a(parambfbw.d, parambfbw.g, parambfbw.jdField_h_of_type_JavaLangString, paramberr);
  }
  
  public void a(berr paramberr, boolean paramBoolean1, boolean paramBoolean2, aock paramaock)
  {
    if (paramaock == null) {
      return;
    }
    paramberr.b();
    if (paramBoolean2)
    {
      paramberr.c = (paramaock.c - 1);
      paramberr.jdField_b_of_type_Int = 1;
      paramberr.jdField_a_of_type_Int = 1;
      return;
    }
    String str;
    if (paramaock.jdField_b_of_type_Int == 2900)
    {
      i1 = -9527;
      if (!paramBoolean1) {}
      for (str = b(paramaock.jdField_a_of_type_Long);; str = a(paramaock.jdField_a_of_type_Long))
      {
        a(i1, "", str, paramberr);
        paramberr.c = paramaock.c;
        paramberr.jdField_b_of_type_Int = 0;
        paramberr.jdField_a_of_type_Int = 0;
        return;
      }
    }
    if ((paramaock.jdField_b_of_type_Int == 1002) || (paramaock.jdField_b_of_type_Int == 1013))
    {
      if (!paramBoolean1) {}
      for (i1 = 9350;; i1 = 9311)
      {
        str = paramaock.jdField_a_of_type_JavaLangString;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i1 = 9351;; i1 = 9044)
    {
      str = paramaock.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void a(bevy parambevy, bevx parambevx) {}
  
  public void a(bfau parambfau, bfbj parambfbj) {}
  
  public void a(bhva parambhva1, bhva parambhva2) {}
  
  void a(IOException paramIOException)
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
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bfci.d == null) {
      this.jdField_a_of_type_Bfci.d = this.jdField_i_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bfci.e == null) {
      this.jdField_a_of_type_Bfci.e = this.jdField_j_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Bfci.f = (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int + "");
    this.jdField_a_of_type_Bfci.g = (this.jdField_a_of_type_Beyg.c + "");
    if ((this instanceof beru)) {}
    for (this.jdField_a_of_type_Bfci.jdField_a_of_type_Int = Ipv6Config.getFlags().mBdhStrategy;; this.jdField_a_of_type_Bfci.jdField_a_of_type_Int = Ipv6Config.getFlags().mRMDownStrategy)
    {
      if ((this.jdField_b_of_type_Berr != null) && (this.jdField_b_of_type_Berr.jdField_a_of_type_Long > 0L)) {
        this.jdField_a_of_type_Bfci.jdField_a_of_type_Long = ((System.nanoTime() - this.jdField_b_of_type_Berr.jdField_a_of_type_Long) / 1000000L);
      }
      this.jdField_a_of_type_Bfci.a(paramString, paramBoolean);
      return;
    }
  }
  
  public void a(ArrayList<bewy> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramString != null))
    {
      bewy localbewy = new bewy();
      localbewy.jdField_a_of_type_JavaLangString = paramString;
      localbewy.b = true;
      paramArrayList.add(localbewy);
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  public boolean a(bhva parambhva1, bhva parambhva2, int paramInt)
  {
    return true;
  }
  
  public void aN_() {}
  
  public int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Bete.jdField_e_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b() {}
  
  @Deprecated
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  protected void b(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.q) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        beyf localbeyf;
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
              localbeyf = (beyf)localIterator.next();
              localObject3 = localbeyf.getFilter();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localbeyf.obtainMessage();
        this.jdField_a_of_type_Bete.jdField_e_of_type_Int = this.jdField_a_of_type_Bete.d;
        this.jdField_a_of_type_Bete.d = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.jdField_a_of_type_Bete;
        ((Message)localObject4).arg1 = paramInt2;
        localbeyf.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, null, null);
  }
  
  public void b(bhva parambhva1, bhva parambhva2) {}
  
  public void b(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Bete == null) {
      azpw.b("BaseTransProcessor", "logRichMediaEvent", "file is null !");
    }
    do
    {
      return;
      if (!(this instanceof bexd)) {
        break;
      }
    } while (this.jdField_a_of_type_Beyg == null);
    bews.a("T", bews.b(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int), bews.c(this.jdField_a_of_type_Bete.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Bete.jdField_b_of_type_Long), paramString1, paramString2, null);
    return;
    int i1 = -1;
    if (this.jdField_a_of_type_Beyg != null) {
      i1 = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    }
    if ((this instanceof berv))
    {
      i1 = 0;
      if (this.jdField_a_of_type_Beyg == null) {
        break label162;
      }
      bool = this.jdField_a_of_type_Beyg.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      bews.a(bews.b(i1), bool, bews.c(this.jdField_a_of_type_Bete.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Bete.jdField_b_of_type_Long), paramString1, paramString2);
      return;
      if (!(this instanceof besa)) {
        break;
      }
      i1 = 0;
      break;
      label162:
      if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int == 0) {
        bool = true;
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    int i2 = 0;
    this.jdField_a_of_type_JavaUtilHashMap.put("ipStackType", String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
    this.jdField_a_of_type_JavaUtilHashMap.put("msfConnIPType", String.valueOf(MsfServiceSdk.get().getConnectedIPFamily()));
    berj localberj;
    HashMap localHashMap;
    if ((this instanceof beru))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_Ipv6Policy", String.valueOf(Ipv6Config.getFlags().mBdhStrategy));
      if ((this instanceof berj))
      {
        localberj = (berj)this;
        if (localberj.d) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", String.valueOf(1));
        }
        localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
        if (!localberj.c) {
          break label272;
        }
      }
    }
    label272:
    for (int i1 = 1;; i1 = 0)
    {
      localHashMap.put("param_hasV6List", String.valueOf(i1));
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      i1 = i2;
      if (localberj.d) {
        i1 = 1;
      }
      localHashMap.put("param_ipv6First", String.valueOf(i1));
      if ((this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6") != null) && (((String)this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6")).equals(String.valueOf(1)))) {
        bdmc.a(BaseApplication.getContext()).a(null, c() + "_ipv6", paramBoolean, paramLong, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_Ipv6Policy", String.valueOf(Ipv6Config.getFlags().mRMDownStrategy));
      break;
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Bete.d;
  }
  
  protected String c()
  {
    return null;
  }
  
  public void c() {}
  
  @Deprecated
  public void c(int paramInt)
  {
    try
    {
      betf localbetf = a(paramInt);
      if (localbetf != null) {
        localbetf.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c()
  {
    return this.jdField_n_of_type_Boolean;
  }
  
  public long d()
  {
    return this.jdField_a_of_type_Bete.jdField_e_of_type_Int;
  }
  
  protected void d()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isRunning())) {
      b(9366, "account switch");
    }
    b("onError", "elapsed:" + l1 + " errCode:" + this.jdField_k_of_type_Int + " errDesc:" + this.jdField_j_of_type_JavaLangString + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason"));
    a(false);
    this.jdField_a_of_type_Bern.a(b());
  }
  
  protected void d(int paramInt)
  {
    a(paramInt, 0L);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_m_of_type_Boolean;
  }
  
  public int e()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    b("onSuccess", "elapsed:" + l1 + ",key:" + b());
    a(true);
    this.jdField_a_of_type_Bern.a(b());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Bete.a(paramInt);
  }
  
  protected void e(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_k_of_type_Int == 0)) {
      QLog.d("BaseTransProcessor", 1, new Throwable().getStackTrace());
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_check_result", String.valueOf(paramBoolean));
    this.jdField_a_of_type_JavaUtilHashMap.put("param_check_FailCode", String.valueOf(this.jdField_k_of_type_Int));
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
      i1 = this.jdField_o_of_type_Int;
    }
    do
    {
      do
      {
        return i1;
        i1 = i2;
      } while (this.jdField_a_of_type_Bete == null);
      i1 = i2;
    } while (this.jdField_a_of_type_Bete.jdField_a_of_type_Long <= 0L);
    return (int)(this.jdField_a_of_type_Bete.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Bete.jdField_a_of_type_Long);
  }
  
  protected boolean f()
  {
    return (!this.q) && (!this.jdField_m_of_type_Boolean);
  }
  
  public int g()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.jdField_a_of_type_Bete != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_Bete.jdField_a_of_type_Long > 0L)
      {
        i2 = (int)(this.jdField_a_of_type_Bete.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Bete.jdField_a_of_type_Long);
        i1 = i2;
        if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int == 0) {
          if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int != 1)
          {
            i1 = i2;
            if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int != 131075) {}
          }
          else
          {
            i1 = i2;
            if (i2 == 100)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Bete.d != 1003) {
                i1 = 99;
              }
            }
          }
        }
      }
    }
    return i1;
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_Bete != null)
    {
      g();
      f();
    }
  }
  
  public void k() {}
  
  public void l()
  {
    boolean bool = false;
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_Beyg.b());
    if (localInteger == null) {}
    for (int i1 = 0;; i1 = localInteger.intValue())
    {
      this.jdField_n_of_type_Int = i1;
      if (this.jdField_a_of_type_Beyg.d < 3) {
        bool = true;
      }
      this.jdField_j_of_type_Boolean = bool;
      return;
    }
  }
  
  public void m()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_Beyg.b(), Integer.valueOf(this.jdField_n_of_type_Int));
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 2000) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  protected void n()
  {
    this.jdField_k_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  protected void o() {}
  
  public void onResp(bevm parambevm)
  {
    a(parambevm);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berp
 * JD-Core Version:    0.7.0.1
 */