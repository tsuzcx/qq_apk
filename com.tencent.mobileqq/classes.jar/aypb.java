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
import java.util.List<Layuq;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager.ProxyIp;

public class aypb
  implements aysc, aytj, ayzw, bbmw
{
  protected static aysb a;
  private static Object jdField_a_of_type_JavaLangObject;
  static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static ArrayList<aywb> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public static String k;
  private int jdField_a_of_type_Int;
  public ayoz a;
  protected aypd a;
  public ayqo a;
  public aysa a;
  protected aysy a;
  protected ayug a;
  public aywc a;
  protected ayyp a;
  protected AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, String> a;
  protected List<ProxyIpManager.ProxyIp> a;
  private boolean jdField_a_of_type_Boolean;
  String a_ = "P";
  private int jdField_b_of_type_Int;
  protected aypd b;
  protected aypd c = new aypd();
  int d;
  protected aypd d;
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
  public String j;
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
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_k_of_type_JavaLangString = "param_reason";
    jdField_a_of_type_Aysb = new aypc();
  }
  
  public aypb()
  {
    this.jdField_d_of_type_Int = -9528;
    this.jdField_e_of_type_Int = -9529;
    this.jdField_i_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Aypd = new aypd();
    this.jdField_b_of_type_Aypd = new aypd();
    this.jdField_d_of_type_Aypd = new aypd();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
  }
  
  public aypb(ayoz paramayoz, aywc paramaywc)
  {
    this.jdField_d_of_type_Int = -9528;
    this.jdField_e_of_type_Int = -9529;
    this.jdField_i_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Aypd = new aypd();
    this.jdField_b_of_type_Aypd = new aypd();
    this.jdField_d_of_type_Aypd = new aypd();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramayoz.jdField_a_of_type_ComTencentCommonAppAppInterface;
    this.jdField_k_of_type_Long = System.nanoTime();
    aung.a("BaseTransProcessor", "TimeCompare", "Processor Start Time = " + this.jdField_k_of_type_Long + "ns,Processor = " + this);
    this.jdField_a_of_type_Ayqo = new ayqo();
    this.jdField_a_of_type_Ayoz = paramayoz;
    this.jdField_a_of_type_Aywc = paramaywc;
    this.jdField_a_of_type_Ayqo.jdField_b_of_type_Int = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ayqo.jdField_b_of_type_Long = this.jdField_a_of_type_Aywc.jdField_a_of_type_Long;
    this.jdField_a_of_type_Ayqo.jdField_h_of_type_Int = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    this.jdField_a_of_type_Ayqo.q = this.jdField_a_of_type_Aywc.c;
    paramayoz = this.jdField_a_of_type_Ayqo;
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Boolean) {
      i1 = 0;
    }
    paramayoz.jdField_a_of_type_Int = i1;
    this.jdField_a_of_type_Aysa = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    k();
  }
  
  public aypb(ayvx paramayvx)
  {
    this.jdField_d_of_type_Int = -9528;
    this.jdField_e_of_type_Int = -9529;
    this.jdField_i_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Aypd = new aypd();
    this.jdField_b_of_type_Aypd = new aypd();
    this.jdField_d_of_type_Aypd = new aypd();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_Ayoz = paramayvx;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramayvx.a;
    this.jdField_a_of_type_Ayqo = new ayqo();
    this.jdField_k_of_type_Long = System.nanoTime();
  }
  
  public aypb(String paramString1, String paramString2, boolean paramBoolean, ayvx paramayvx)
  {
    this.jdField_d_of_type_Int = -9528;
    this.jdField_e_of_type_Int = -9529;
    this.jdField_i_of_type_Int = -9533;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_j_of_type_Int = 9001;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_Aypd = new aypd();
    this.jdField_b_of_type_Aypd = new aypd();
    this.jdField_d_of_type_Aypd = new aypd();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_Ayoz = paramayvx;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramayvx.a;
    this.jdField_k_of_type_Long = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Ayqo = new ayqo(paramString1, paramString2, i1);
      this.jdField_a_of_type_Ayqo.jdField_a_of_type_Aypb = this;
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
    return ayoj.a(paramException);
  }
  
  public static String a(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
  }
  
  public static void a(Message paramMessage, Class paramClass, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((jdField_b_of_type_JavaUtilArrayList != null) && (!jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
        aywb localaywb;
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
              localaywb = (aywb)localIterator.next();
              localObject2 = localaywb.getFilter();
            } while (((ArrayList)localObject2).isEmpty());
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        } while (!paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()));
        Message localMessage = localaywb.obtainMessage();
        localMessage.what = paramMessage.what;
        localMessage.obj = paramMessage.obj;
        localMessage.arg1 = paramMessage.arg1;
        localaywb.sendMessageDelayed(localMessage, paramLong);
      }
    }
  }
  
  private void a(aysz paramaysz)
  {
    long l1 = 0L;
    if ((paramaysz.h != 0L) && (this.jdField_p_of_type_Boolean)) {
      if (paramaysz.jdField_a_of_type_JavaUtilHashMap.get("X-httime") == null) {
        break label219;
      }
    }
    for (int i1 = Integer.parseInt((String)paramaysz.jdField_a_of_type_JavaUtilHashMap.get("X-httime"));; i1 = 0)
    {
      if (paramaysz.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)paramaysz.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime"));
      }
      long l2 = i1 - l1;
      long l3 = paramaysz.h - i1;
      this.jdField_n_of_type_Long += l3;
      this.jdField_m_of_type_Long += l2;
      this.jdField_o_of_type_Long += l1;
      this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_o_of_type_Int).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.jdField_o_of_type_Int += 1;
      this.jdField_p_of_type_Long = paramaysz.i;
      return;
      label219:
      this.jdField_p_of_type_Boolean = false;
    }
  }
  
  public static void a(aywb paramaywb)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_b_of_type_JavaUtilArrayList.contains(paramaywb)) {
        jdField_b_of_type_JavaUtilArrayList.add(paramaywb);
      }
      return;
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Ayoz != null) && (this.jdField_a_of_type_Ayoz.jdField_a_of_type_Amvx != null)) {
      return this.jdField_a_of_type_Ayoz.jdField_a_of_type_Amvx.c;
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
  
  static boolean a(List<ProxyIpManager.ProxyIp> paramList, List<ayuq> paramList1)
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
        ayuq localayuq = (ayuq)((Iterator)localObject).next();
        if ((localProxyIp.ip.equals(localayuq.jdField_a_of_type_JavaLangString)) && (localProxyIp.port == localayuq.jdField_a_of_type_Int)) {
          paramList1.remove(localayuq);
        }
      }
      localObject = new ayuq();
      ((ayuq)localObject).jdField_a_of_type_JavaLangString = localProxyIp.ip;
      ((ayuq)localObject).jdField_a_of_type_Int = localProxyIp.port;
      localArrayList.add(localObject);
    }
    paramList1.addAll(0, localArrayList);
    return true;
  }
  
  public static String b(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  public static void b(aywb paramaywb)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_b_of_type_JavaUtilArrayList.remove(paramaywb);
      return;
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Ayoz != null) && (this.jdField_a_of_type_Ayoz.jdField_a_of_type_Amvx != null)) {
      return this.jdField_a_of_type_Ayoz.jdField_a_of_type_Amvx.d;
    }
    return false;
  }
  
  public static String d(String paramString)
  {
    return "C_" + paramString;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Ayqo != null)
    {
      if (this.jdField_a_of_type_Ayqo.jdField_a_of_type_Int == 0) {
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
    if (this.jdField_a_of_type_Aywc != null) {
      if (!this.jdField_a_of_type_Aywc.jdField_a_of_type_Boolean) {
        break label195;
      }
    }
    label195:
    for (int i1 = 1004;; i1 = 2004)
    {
      d(i1);
      this.jdField_o_of_type_Boolean = true;
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Aywc != null)) {
        b("cancel", "");
      }
      if (this.jdField_a_of_type_Ayyp != null)
      {
        ayzv.b(this.jdField_a_of_type_Ayyp);
        this.jdField_a_of_type_Ayyp = null;
      }
      if (this.jdField_a_of_type_Aysy != null)
      {
        this.jdField_a_of_type_Aysa.b(this.jdField_a_of_type_Aysy);
        this.jdField_a_of_type_Aysy = null;
      }
      this.jdField_a_of_type_Ayoz.a(a());
      try
      {
        if (this.jdField_a_of_type_Aywc != null)
        {
          aywj localaywj = this.jdField_a_of_type_Aywc.jdField_a_of_type_Aywj;
          if (localaywj != null)
          {
            localaywj.jdField_a_of_type_Int = -1;
            localaywj.jdField_a_of_type_Long = 9037L;
            localaywj.jdField_a_of_type_Aywc = this.jdField_a_of_type_Aywc;
          }
        }
        if (this.jdField_a_of_type_Aywc != null) {
          b("cancel", "");
        }
        notifyAll();
        if (this.jdField_a_of_type_Aywc != null) {
          b("cancel", "");
        }
        return 0;
      }
      finally {}
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long;
  }
  
  public ayqo a()
  {
    return this.jdField_a_of_type_Ayqo;
  }
  
  @Deprecated
  public ayqp a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_Ayqo.jdField_a_of_type_Ayqp;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.jdField_a_of_type_Ayqo.jdField_b_of_type_Ayqp;
      } else if (paramInt == 2) {
        localObject1 = this.jdField_a_of_type_Ayqo.jdField_a_of_type_Ayqq;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Ayqo.c;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Ayqo.jdField_b_of_type_Ayqq;
      }
    }
  }
  
  aywc a()
  {
    return this.jdField_a_of_type_Aywc;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    return MessageForPtt.getLocalFilePath(paramInt, ajsd.aW + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + ayqo.a() + ".amr");
  }
  
  protected String a(String paramString, List<ayuq> paramList)
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
    ayuq localayuq;
    do
    {
      return paramList;
      localayuq = ayuk.a(paramString);
      if (localayuq != null) {
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
      if ((!((ProxyIpManager.ProxyIp)localObject3).ip.equals(localayuq.jdField_a_of_type_JavaLangString)) || (((ProxyIpManager.ProxyIp)localObject3).port != localayuq.jdField_a_of_type_Int)) {
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
        paramString = ayuk.a(paramString, paramList);
        paramString = paramString + "&bHost=" + localayuq.jdField_a_of_type_JavaLangString + "&bPort=" + localayuq.jdField_a_of_type_Int;
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
          paramList = (List<ayuq>)localObject1;
          do
          {
            localObject2 = paramList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (ayuq)((Iterator)localObject3).next();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            do
            {
              localObject1 = paramList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (ProxyIpManager.ProxyIp)localIterator.next();
            } while ((((ayuq)localObject2).jdField_a_of_type_JavaLangString.equals(((ProxyIpManager.ProxyIp)localObject1).ip)) || (((ayuq)localObject2).jdField_a_of_type_Int == ((ProxyIpManager.ProxyIp)localObject1).port));
            localObject1 = localObject2;
            paramList = (List<ayuq>)localObject1;
          } while (localObject1 == null);
          localObject2 = localObject1;
          localObject1 = paramString;
          if (localObject2 != null) {
            localObject1 = paramString + "&bHost=" + ((ayuq)localObject2).jdField_a_of_type_JavaLangString + "&bPort=" + ((ayuq)localObject2).jdField_a_of_type_Int;
          }
          paramList = (List<ayuq>)localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + localayuq.jdField_a_of_type_JavaLangString + ":" + localayuq.jdField_a_of_type_Int);
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
      String str = ayoj.a(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      axrn.a(BaseApplication.getContext()).a(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
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
      ayuk.a(true, "image_sending_too_long");
    }
    for (;;)
    {
      b(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label209:
      ayuk.a(bool, "image_sending_" + this.jdField_j_of_type_Int + "_" + this.jdField_j_of_type_JavaLangString);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      ayqq localayqq = this.jdField_a_of_type_Ayqo.jdField_a_of_type_Ayqq;
      localayqq.jdField_a_of_type_Int = paramInt1;
      localayqq.jdField_a_of_type_Boolean = false;
      localayqq.jdField_a_of_type_JavaLangString = paramString;
      localayqq.jdField_e_of_type_Int = paramInt2;
      localayqq.c = paramLong;
      b(localayqq.jdField_a_of_type_Int, localayqq.jdField_a_of_type_JavaLangString);
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
      ayqp localayqp = a(paramInt1);
      if (localayqp != null)
      {
        localayqp.jdField_a_of_type_Int = paramInt2;
        localayqp.jdField_a_of_type_JavaLangString = paramString;
        localayqp.jdField_a_of_type_Boolean = false;
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
  
  public void a(int paramInt, String paramString1, String paramString2, aypd paramaypd)
  {
    this.jdField_j_of_type_Int = paramInt;
    this.jdField_i_of_type_JavaLangString = paramString2;
    this.jdField_j_of_type_JavaLangString = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", paramString2);
    }
    if (paramaypd != null)
    {
      paramaypd.b();
      paramaypd.jdField_a_of_type_Int = 0;
    }
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      ayqp localayqp = a(paramInt);
      if ((localayqp != null) && ((localayqp.jdField_a_of_type_Long == 0L) || (paramBoolean))) {
        localayqp.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Ayqo.a(paramLong);
  }
  
  public void a(aypd paramaypd, aysz paramaysz, boolean paramBoolean)
  {
    if ((paramaypd == null) || (paramaysz == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_Server", paramaysz.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaysz.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
      paramaypd.jdField_b_of_type_Int += 1;
      paramaypd.c += paramaysz.jdField_d_of_type_Int - 1;
      paramaypd.b();
      paramaypd.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaysz.jdField_a_of_type_JavaUtilHashMap.get("firstserverip"));
    paramaypd.c += paramaysz.jdField_d_of_type_Int;
    if (paramaysz.jdField_b_of_type_Int == -9527) {}
    for (String str = (String)paramaysz.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; str = null)
    {
      a(paramaysz.jdField_b_of_type_Int, paramaysz.jdField_a_of_type_JavaLangString, str, paramaypd);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", paramaysz.jdField_a_of_type_JavaUtilHashMap.get("param_url"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", paramaysz.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((paramaysz.jdField_b_of_type_Int == -9527) && ("H_404_-124".equals(str))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", paramaysz.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      }
      paramaypd.jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(aypd paramaypd, ayzr paramayzr)
  {
    if ((paramaypd != null) && (paramayzr != null))
    {
      paramaypd.b();
      paramaypd.jdField_b_of_type_Int = paramayzr.jdField_e_of_type_Int;
      paramaypd.c = paramayzr.f;
      if (paramayzr.c == 0) {
        paramaypd.jdField_a_of_type_Int = 1;
      }
    }
    else
    {
      return;
    }
    paramaypd.jdField_a_of_type_Int = 0;
    a(paramayzr.jdField_d_of_type_Int, paramayzr.g, paramayzr.jdField_h_of_type_JavaLangString, paramaypd);
  }
  
  public void a(aypd paramaypd, boolean paramBoolean1, boolean paramBoolean2, akau paramakau)
  {
    if (paramakau == null) {
      return;
    }
    paramaypd.b();
    if (paramBoolean2)
    {
      paramaypd.c = (paramakau.c - 1);
      paramaypd.jdField_b_of_type_Int = 1;
      paramaypd.jdField_a_of_type_Int = 1;
      return;
    }
    String str;
    if (paramakau.jdField_b_of_type_Int == 2900)
    {
      i1 = -9527;
      if (!paramBoolean1) {}
      for (str = b(paramakau.jdField_a_of_type_Long);; str = a(paramakau.jdField_a_of_type_Long))
      {
        a(i1, "", str, paramaypd);
        paramaypd.c = paramakau.c;
        paramaypd.jdField_b_of_type_Int = 0;
        paramaypd.jdField_a_of_type_Int = 0;
        return;
      }
    }
    if ((paramakau.jdField_b_of_type_Int == 1002) || (paramakau.jdField_b_of_type_Int == 1013))
    {
      if (!paramBoolean1) {}
      for (i1 = 9350;; i1 = 9311)
      {
        str = paramakau.jdField_a_of_type_JavaLangString;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i1 = 9351;; i1 = 9044)
    {
      str = paramakau.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void a(aytl paramaytl, aytk paramaytk) {}
  
  public void a(ayyp paramayyp, ayze paramayze) {}
  
  public void a(bbmu parambbmu1, bbmu parambbmu2) {}
  
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
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap)
  {
    if (!paramBoolean) {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString1)) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
      paramHashMap.put("isSuccess", String.valueOf(paramBoolean));
      paramHashMap.put("server_ip", paramString1);
      paramHashMap.put("server_port", paramString2);
      paramHashMap.put("param_FailCode", paramString3);
      paramHashMap.put("param_reason", this.jdField_i_of_type_JavaLangString);
      paramHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      paramHashMap.put("chatType", this.jdField_a_of_type_Aywc.jdField_a_of_type_Int + "");
      paramHashMap.put("chatUin", this.jdField_a_of_type_Aywc.c + "");
      axrn.a(BaseApplication.getContext()).a(null, paramString4, paramBoolean, 0L, 0L, paramHashMap, "");
    } while (!paramString1.contains(":"));
    axrn.a(BaseApplication.getContext()).a(null, paramString4 + "_ipv6", paramBoolean, 0L, 0L, paramHashMap, "");
  }
  
  public boolean a(bbmu parambbmu1, bbmu parambbmu2, int paramInt)
  {
    return true;
  }
  
  public void aR_() {}
  
  public int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Ayqo.jdField_e_of_type_Long;
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
      if ((jdField_b_of_type_JavaUtilArrayList != null) && (!jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        Iterator localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
        aywb localaywb;
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
              localaywb = (aywb)localIterator.next();
              localObject3 = localaywb.getFilter();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localaywb.obtainMessage();
        this.jdField_a_of_type_Ayqo.jdField_e_of_type_Int = this.jdField_a_of_type_Ayqo.jdField_d_of_type_Int;
        this.jdField_a_of_type_Ayqo.jdField_d_of_type_Int = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.jdField_a_of_type_Ayqo;
        ((Message)localObject4).arg1 = paramInt2;
        localaywb.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, null, null);
  }
  
  public void b(bbmu parambbmu1, bbmu parambbmu2) {}
  
  public void b(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ayqo == null) {
      aung.b("BaseTransProcessor", "logRichMediaEvent", "file is null !");
    }
    do
    {
      return;
      if (!(this instanceof ayuw)) {
        break;
      }
    } while (this.jdField_a_of_type_Aywc == null);
    ayuk.a("T", ayuk.b(this.jdField_a_of_type_Aywc.jdField_a_of_type_Int), ayuk.c(this.jdField_a_of_type_Ayqo.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Ayqo.jdField_b_of_type_Long), paramString1, paramString2, null);
    return;
    int i1 = -1;
    if (this.jdField_a_of_type_Aywc != null) {
      i1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    }
    if ((this instanceof ayph))
    {
      i1 = 0;
      if (this.jdField_a_of_type_Aywc == null) {
        break label162;
      }
      bool = this.jdField_a_of_type_Aywc.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      ayuk.a(ayuk.b(i1), bool, ayuk.c(this.jdField_a_of_type_Ayqo.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Ayqo.jdField_b_of_type_Long), paramString1, paramString2);
      return;
      if (!(this instanceof aypl)) {
        break;
      }
      i1 = 0;
      break;
      label162:
      if (this.jdField_a_of_type_Ayqo.jdField_a_of_type_Int == 0) {
        bool = true;
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6") != null) && (((String)this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6")).equals(String.valueOf(1)))) {
      axrn.a(BaseApplication.getContext()).a(null, b() + "_ipv6", paramBoolean, paramLong, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Ayqo.jdField_d_of_type_Int;
  }
  
  public void c() {}
  
  @Deprecated
  public void c(int paramInt)
  {
    try
    {
      ayqp localayqp = a(paramInt);
      if (localayqp != null) {
        localayqp.jdField_b_of_type_Long = System.currentTimeMillis();
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
    return this.jdField_a_of_type_Ayqo.jdField_e_of_type_Int;
  }
  
  protected void d()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isRunning())) {
      b(9366, "account switch");
    }
    b("onError", "elapsed:" + l1 + " errCode:" + this.jdField_j_of_type_Int + " errDesc:" + this.jdField_j_of_type_JavaLangString + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason"));
    a(false);
    this.jdField_a_of_type_Ayoz.a(a());
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
    this.jdField_a_of_type_Ayoz.a(a());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Ayqo.a(paramInt);
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
      } while (this.jdField_a_of_type_Ayqo == null);
      i1 = i2;
    } while (this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long <= 0L);
    return (int)(this.jdField_a_of_type_Ayqo.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_Ayqo != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long > 0L)
      {
        i2 = (int)(this.jdField_a_of_type_Ayqo.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long);
        i1 = i2;
        if (this.jdField_a_of_type_Ayqo.jdField_a_of_type_Int == 0) {
          if (this.jdField_a_of_type_Ayqo.jdField_b_of_type_Int != 1)
          {
            i1 = i2;
            if (this.jdField_a_of_type_Ayqo.jdField_b_of_type_Int != 131075) {}
          }
          else
          {
            i1 = i2;
            if (i2 == 100)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Ayqo.jdField_d_of_type_Int != 1003) {
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
    if (this.jdField_a_of_type_Ayqo != null)
    {
      g();
      f();
    }
  }
  
  public void j() {}
  
  public void k()
  {
    boolean bool = false;
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_Aywc.b());
    if (localInteger == null) {}
    for (int i1 = 0;; i1 = localInteger.intValue())
    {
      this.jdField_m_of_type_Int = i1;
      if (this.jdField_a_of_type_Aywc.jdField_d_of_type_Int < 3) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      return;
    }
  }
  
  public void l()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_Aywc.b(), Integer.valueOf(this.jdField_m_of_type_Int));
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 2000) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  protected void m()
  {
    this.jdField_j_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  protected void n() {}
  
  public void onResp(aysz paramaysz)
  {
    a(paramaysz);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypb
 * JD-Core Version:    0.7.0.1
 */