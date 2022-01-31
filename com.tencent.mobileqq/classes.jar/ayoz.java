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
import java.util.List<Layuo;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager.ProxyIp;

public class ayoz
  implements aysa, ayth, ayzu, bbmi
{
  protected static ayrz a;
  private static Object jdField_a_of_type_JavaLangObject;
  static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static ArrayList<ayvz> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public static String k;
  private int jdField_a_of_type_Int;
  public ayox a;
  protected aypb a;
  public ayqm a;
  public ayry a;
  protected aysw a;
  protected ayue a;
  public aywa a;
  protected ayyn a;
  protected AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, String> a;
  protected List<ProxyIpManager.ProxyIp> a;
  private boolean jdField_a_of_type_Boolean;
  String a_ = "P";
  private int jdField_b_of_type_Int;
  protected aypb b;
  protected aypb c = new aypb();
  int d;
  protected aypb d;
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
    jdField_a_of_type_Ayrz = new aypa();
  }
  
  public ayoz()
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
    this.jdField_a_of_type_Aypb = new aypb();
    this.jdField_b_of_type_Aypb = new aypb();
    this.jdField_d_of_type_Aypb = new aypb();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
  }
  
  public ayoz(ayox paramayox, aywa paramaywa)
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
    this.jdField_a_of_type_Aypb = new aypb();
    this.jdField_b_of_type_Aypb = new aypb();
    this.jdField_d_of_type_Aypb = new aypb();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramayox.jdField_a_of_type_ComTencentCommonAppAppInterface;
    this.jdField_k_of_type_Long = System.nanoTime();
    aune.a("BaseTransProcessor", "TimeCompare", "Processor Start Time = " + this.jdField_k_of_type_Long + "ns,Processor = " + this);
    this.jdField_a_of_type_Ayqm = new ayqm();
    this.jdField_a_of_type_Ayox = paramayox;
    this.jdField_a_of_type_Aywa = paramaywa;
    this.jdField_a_of_type_Ayqm.jdField_b_of_type_Int = this.jdField_a_of_type_Aywa.jdField_b_of_type_Int;
    this.jdField_a_of_type_Ayqm.jdField_b_of_type_Long = this.jdField_a_of_type_Aywa.jdField_a_of_type_Long;
    this.jdField_a_of_type_Ayqm.jdField_h_of_type_Int = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    this.jdField_a_of_type_Ayqm.q = this.jdField_a_of_type_Aywa.c;
    paramayox = this.jdField_a_of_type_Ayqm;
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Boolean) {
      i1 = 0;
    }
    paramayox.jdField_a_of_type_Int = i1;
    this.jdField_a_of_type_Ayry = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    k();
  }
  
  public ayoz(ayvv paramayvv)
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
    this.jdField_a_of_type_Aypb = new aypb();
    this.jdField_b_of_type_Aypb = new aypb();
    this.jdField_d_of_type_Aypb = new aypb();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_Ayox = paramayvv;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramayvv.a;
    this.jdField_a_of_type_Ayqm = new ayqm();
    this.jdField_k_of_type_Long = System.nanoTime();
  }
  
  public ayoz(String paramString1, String paramString2, boolean paramBoolean, ayvv paramayvv)
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
    this.jdField_a_of_type_Aypb = new aypb();
    this.jdField_b_of_type_Aypb = new aypb();
    this.jdField_d_of_type_Aypb = new aypb();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_Ayox = paramayvv;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramayvv.a;
    this.jdField_k_of_type_Long = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Ayqm = new ayqm(paramString1, paramString2, i1);
      this.jdField_a_of_type_Ayqm.jdField_a_of_type_Ayoz = this;
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
    return ayoh.a(paramException);
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
        ayvz localayvz;
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
              localayvz = (ayvz)localIterator.next();
              localObject2 = localayvz.getFilter();
            } while (((ArrayList)localObject2).isEmpty());
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        } while (!paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()));
        Message localMessage = localayvz.obtainMessage();
        localMessage.what = paramMessage.what;
        localMessage.obj = paramMessage.obj;
        localMessage.arg1 = paramMessage.arg1;
        localayvz.sendMessageDelayed(localMessage, paramLong);
      }
    }
  }
  
  private void a(aysx paramaysx)
  {
    long l1 = 0L;
    if ((paramaysx.h != 0L) && (this.jdField_p_of_type_Boolean)) {
      if (paramaysx.jdField_a_of_type_JavaUtilHashMap.get("X-httime") == null) {
        break label219;
      }
    }
    for (int i1 = Integer.parseInt((String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("X-httime"));; i1 = 0)
    {
      if (paramaysx.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime"));
      }
      long l2 = i1 - l1;
      long l3 = paramaysx.h - i1;
      this.jdField_n_of_type_Long += l3;
      this.jdField_m_of_type_Long += l2;
      this.jdField_o_of_type_Long += l1;
      this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_o_of_type_Int).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.jdField_o_of_type_Int += 1;
      this.jdField_p_of_type_Long = paramaysx.i;
      return;
      label219:
      this.jdField_p_of_type_Boolean = false;
    }
  }
  
  public static void a(ayvz paramayvz)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_b_of_type_JavaUtilArrayList.contains(paramayvz)) {
        jdField_b_of_type_JavaUtilArrayList.add(paramayvz);
      }
      return;
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Ayox != null) && (this.jdField_a_of_type_Ayox.jdField_a_of_type_Amvy != null)) {
      return this.jdField_a_of_type_Ayox.jdField_a_of_type_Amvy.c;
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
  
  static boolean a(List<ProxyIpManager.ProxyIp> paramList, List<ayuo> paramList1)
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
        ayuo localayuo = (ayuo)((Iterator)localObject).next();
        if ((localProxyIp.ip.equals(localayuo.jdField_a_of_type_JavaLangString)) && (localProxyIp.port == localayuo.jdField_a_of_type_Int)) {
          paramList1.remove(localayuo);
        }
      }
      localObject = new ayuo();
      ((ayuo)localObject).jdField_a_of_type_JavaLangString = localProxyIp.ip;
      ((ayuo)localObject).jdField_a_of_type_Int = localProxyIp.port;
      localArrayList.add(localObject);
    }
    paramList1.addAll(0, localArrayList);
    return true;
  }
  
  public static String b(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  public static void b(ayvz paramayvz)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_b_of_type_JavaUtilArrayList.remove(paramayvz);
      return;
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Ayox != null) && (this.jdField_a_of_type_Ayox.jdField_a_of_type_Amvy != null)) {
      return this.jdField_a_of_type_Ayox.jdField_a_of_type_Amvy.d;
    }
    return false;
  }
  
  public static String d(String paramString)
  {
    return "C_" + paramString;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Ayqm != null)
    {
      if (this.jdField_a_of_type_Ayqm.jdField_a_of_type_Int == 0) {
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
    if (this.jdField_a_of_type_Aywa != null) {
      if (!this.jdField_a_of_type_Aywa.jdField_a_of_type_Boolean) {
        break label195;
      }
    }
    label195:
    for (int i1 = 1004;; i1 = 2004)
    {
      d(i1);
      this.jdField_o_of_type_Boolean = true;
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Aywa != null)) {
        b("cancel", "");
      }
      if (this.jdField_a_of_type_Ayyn != null)
      {
        ayzt.b(this.jdField_a_of_type_Ayyn);
        this.jdField_a_of_type_Ayyn = null;
      }
      if (this.jdField_a_of_type_Aysw != null)
      {
        this.jdField_a_of_type_Ayry.b(this.jdField_a_of_type_Aysw);
        this.jdField_a_of_type_Aysw = null;
      }
      this.jdField_a_of_type_Ayox.a(a());
      try
      {
        if (this.jdField_a_of_type_Aywa != null)
        {
          aywh localaywh = this.jdField_a_of_type_Aywa.jdField_a_of_type_Aywh;
          if (localaywh != null)
          {
            localaywh.jdField_a_of_type_Int = -1;
            localaywh.jdField_a_of_type_Long = 9037L;
            localaywh.jdField_a_of_type_Aywa = this.jdField_a_of_type_Aywa;
          }
        }
        if (this.jdField_a_of_type_Aywa != null) {
          b("cancel", "");
        }
        notifyAll();
        if (this.jdField_a_of_type_Aywa != null) {
          b("cancel", "");
        }
        return 0;
      }
      finally {}
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long;
  }
  
  public ayqm a()
  {
    return this.jdField_a_of_type_Ayqm;
  }
  
  @Deprecated
  public ayqn a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_Ayqm.jdField_a_of_type_Ayqn;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.jdField_a_of_type_Ayqm.jdField_b_of_type_Ayqn;
      } else if (paramInt == 2) {
        localObject1 = this.jdField_a_of_type_Ayqm.jdField_a_of_type_Ayqo;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Ayqm.c;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Ayqm.jdField_b_of_type_Ayqo;
      }
    }
  }
  
  aywa a()
  {
    return this.jdField_a_of_type_Aywa;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    return MessageForPtt.getLocalFilePath(paramInt, ajsf.aW + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + ayqm.a() + ".amr");
  }
  
  protected String a(String paramString, List<ayuo> paramList)
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
    ayuo localayuo;
    do
    {
      return paramList;
      localayuo = ayui.a(paramString);
      if (localayuo != null) {
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
      if ((!((ProxyIpManager.ProxyIp)localObject3).ip.equals(localayuo.jdField_a_of_type_JavaLangString)) || (((ProxyIpManager.ProxyIp)localObject3).port != localayuo.jdField_a_of_type_Int)) {
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
        paramString = ayui.a(paramString, paramList);
        paramString = paramString + "&bHost=" + localayuo.jdField_a_of_type_JavaLangString + "&bPort=" + localayuo.jdField_a_of_type_Int;
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
          paramList = (List<ayuo>)localObject1;
          do
          {
            localObject2 = paramList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (ayuo)((Iterator)localObject3).next();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            do
            {
              localObject1 = paramList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (ProxyIpManager.ProxyIp)localIterator.next();
            } while ((((ayuo)localObject2).jdField_a_of_type_JavaLangString.equals(((ProxyIpManager.ProxyIp)localObject1).ip)) || (((ayuo)localObject2).jdField_a_of_type_Int == ((ProxyIpManager.ProxyIp)localObject1).port));
            localObject1 = localObject2;
            paramList = (List<ayuo>)localObject1;
          } while (localObject1 == null);
          localObject2 = localObject1;
          localObject1 = paramString;
          if (localObject2 != null) {
            localObject1 = paramString + "&bHost=" + ((ayuo)localObject2).jdField_a_of_type_JavaLangString + "&bPort=" + ((ayuo)localObject2).jdField_a_of_type_Int;
          }
          paramList = (List<ayuo>)localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + localayuo.jdField_a_of_type_JavaLangString + ":" + localayuo.jdField_a_of_type_Int);
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
      String str = ayoh.a(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      axrl.a(BaseApplication.getContext()).a(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
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
      ayui.a(true, "image_sending_too_long");
    }
    for (;;)
    {
      b(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label209:
      ayui.a(bool, "image_sending_" + this.jdField_j_of_type_Int + "_" + this.jdField_j_of_type_JavaLangString);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      ayqo localayqo = this.jdField_a_of_type_Ayqm.jdField_a_of_type_Ayqo;
      localayqo.jdField_a_of_type_Int = paramInt1;
      localayqo.jdField_a_of_type_Boolean = false;
      localayqo.jdField_a_of_type_JavaLangString = paramString;
      localayqo.jdField_e_of_type_Int = paramInt2;
      localayqo.c = paramLong;
      b(localayqo.jdField_a_of_type_Int, localayqo.jdField_a_of_type_JavaLangString);
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
      ayqn localayqn = a(paramInt1);
      if (localayqn != null)
      {
        localayqn.jdField_a_of_type_Int = paramInt2;
        localayqn.jdField_a_of_type_JavaLangString = paramString;
        localayqn.jdField_a_of_type_Boolean = false;
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
  
  public void a(int paramInt, String paramString1, String paramString2, aypb paramaypb)
  {
    this.jdField_j_of_type_Int = paramInt;
    this.jdField_i_of_type_JavaLangString = paramString2;
    this.jdField_j_of_type_JavaLangString = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", paramString2);
    }
    if (paramaypb != null)
    {
      paramaypb.b();
      paramaypb.jdField_a_of_type_Int = 0;
    }
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      ayqn localayqn = a(paramInt);
      if ((localayqn != null) && ((localayqn.jdField_a_of_type_Long == 0L) || (paramBoolean))) {
        localayqn.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Ayqm.a(paramLong);
  }
  
  public void a(aypb paramaypb, aysx paramaysx, boolean paramBoolean)
  {
    if ((paramaypb == null) || (paramaysx == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_Server", paramaysx.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaysx.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
      paramaypb.jdField_b_of_type_Int += 1;
      paramaypb.c += paramaysx.jdField_d_of_type_Int - 1;
      paramaypb.b();
      paramaypb.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramaysx.jdField_a_of_type_JavaUtilHashMap.get("firstserverip"));
    paramaypb.c += paramaysx.jdField_d_of_type_Int;
    if (paramaysx.jdField_b_of_type_Int == -9527) {}
    for (String str = (String)paramaysx.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; str = null)
    {
      a(paramaysx.jdField_b_of_type_Int, paramaysx.jdField_a_of_type_JavaLangString, str, paramaypb);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", paramaysx.jdField_a_of_type_JavaUtilHashMap.get("param_url"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", paramaysx.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((paramaysx.jdField_b_of_type_Int == -9527) && ("H_404_-124".equals(str))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", paramaysx.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      }
      paramaypb.jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(aypb paramaypb, ayzp paramayzp)
  {
    if ((paramaypb != null) && (paramayzp != null))
    {
      paramaypb.b();
      paramaypb.jdField_b_of_type_Int = paramayzp.jdField_e_of_type_Int;
      paramaypb.c = paramayzp.f;
      if (paramayzp.c == 0) {
        paramaypb.jdField_a_of_type_Int = 1;
      }
    }
    else
    {
      return;
    }
    paramaypb.jdField_a_of_type_Int = 0;
    a(paramayzp.jdField_d_of_type_Int, paramayzp.g, paramayzp.jdField_h_of_type_JavaLangString, paramaypb);
  }
  
  public void a(aypb paramaypb, boolean paramBoolean1, boolean paramBoolean2, akaw paramakaw)
  {
    if (paramakaw == null) {
      return;
    }
    paramaypb.b();
    if (paramBoolean2)
    {
      paramaypb.c = (paramakaw.c - 1);
      paramaypb.jdField_b_of_type_Int = 1;
      paramaypb.jdField_a_of_type_Int = 1;
      return;
    }
    String str;
    if (paramakaw.jdField_b_of_type_Int == 2900)
    {
      i1 = -9527;
      if (!paramBoolean1) {}
      for (str = b(paramakaw.jdField_a_of_type_Long);; str = a(paramakaw.jdField_a_of_type_Long))
      {
        a(i1, "", str, paramaypb);
        paramaypb.c = paramakaw.c;
        paramaypb.jdField_b_of_type_Int = 0;
        paramaypb.jdField_a_of_type_Int = 0;
        return;
      }
    }
    if ((paramakaw.jdField_b_of_type_Int == 1002) || (paramakaw.jdField_b_of_type_Int == 1013))
    {
      if (!paramBoolean1) {}
      for (i1 = 9350;; i1 = 9311)
      {
        str = paramakaw.jdField_a_of_type_JavaLangString;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i1 = 9351;; i1 = 9044)
    {
      str = paramakaw.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void a(aytj paramaytj, ayti paramayti) {}
  
  public void a(ayyn paramayyn, ayzc paramayzc) {}
  
  public void a(bbmg parambbmg1, bbmg parambbmg2) {}
  
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
      paramHashMap.put("chatType", this.jdField_a_of_type_Aywa.jdField_a_of_type_Int + "");
      paramHashMap.put("chatUin", this.jdField_a_of_type_Aywa.c + "");
      axrl.a(BaseApplication.getContext()).a(null, paramString4, paramBoolean, 0L, 0L, paramHashMap, "");
    } while (!paramString1.contains(":"));
    axrl.a(BaseApplication.getContext()).a(null, paramString4 + "_ipv6", paramBoolean, 0L, 0L, paramHashMap, "");
  }
  
  public boolean a(bbmg parambbmg1, bbmg parambbmg2, int paramInt)
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
    return this.jdField_a_of_type_Ayqm.jdField_e_of_type_Long;
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
        ayvz localayvz;
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
              localayvz = (ayvz)localIterator.next();
              localObject3 = localayvz.getFilter();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localayvz.obtainMessage();
        this.jdField_a_of_type_Ayqm.jdField_e_of_type_Int = this.jdField_a_of_type_Ayqm.jdField_d_of_type_Int;
        this.jdField_a_of_type_Ayqm.jdField_d_of_type_Int = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.jdField_a_of_type_Ayqm;
        ((Message)localObject4).arg1 = paramInt2;
        localayvz.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, null, null);
  }
  
  public void b(bbmg parambbmg1, bbmg parambbmg2) {}
  
  public void b(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ayqm == null) {
      aune.b("BaseTransProcessor", "logRichMediaEvent", "file is null !");
    }
    do
    {
      return;
      if (!(this instanceof ayuu)) {
        break;
      }
    } while (this.jdField_a_of_type_Aywa == null);
    ayui.a("T", ayui.b(this.jdField_a_of_type_Aywa.jdField_a_of_type_Int), ayui.c(this.jdField_a_of_type_Ayqm.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Ayqm.jdField_b_of_type_Long), paramString1, paramString2, null);
    return;
    int i1 = -1;
    if (this.jdField_a_of_type_Aywa != null) {
      i1 = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    }
    if ((this instanceof aypf))
    {
      i1 = 0;
      if (this.jdField_a_of_type_Aywa == null) {
        break label162;
      }
      bool = this.jdField_a_of_type_Aywa.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      ayui.a(ayui.b(i1), bool, ayui.c(this.jdField_a_of_type_Ayqm.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Ayqm.jdField_b_of_type_Long), paramString1, paramString2);
      return;
      if (!(this instanceof aypj)) {
        break;
      }
      i1 = 0;
      break;
      label162:
      if (this.jdField_a_of_type_Ayqm.jdField_a_of_type_Int == 0) {
        bool = true;
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6") != null) && (((String)this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6")).equals(String.valueOf(1)))) {
      axrl.a(BaseApplication.getContext()).a(null, b() + "_ipv6", paramBoolean, paramLong, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Ayqm.jdField_d_of_type_Int;
  }
  
  public void c() {}
  
  @Deprecated
  public void c(int paramInt)
  {
    try
    {
      ayqn localayqn = a(paramInt);
      if (localayqn != null) {
        localayqn.jdField_b_of_type_Long = System.currentTimeMillis();
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
    return this.jdField_a_of_type_Ayqm.jdField_e_of_type_Int;
  }
  
  protected void d()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isRunning())) {
      b(9366, "account switch");
    }
    b("onError", "elapsed:" + l1 + " errCode:" + this.jdField_j_of_type_Int + " errDesc:" + this.jdField_j_of_type_JavaLangString + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason"));
    a(false);
    this.jdField_a_of_type_Ayox.a(a());
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
    this.jdField_a_of_type_Ayox.a(a());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Ayqm.a(paramInt);
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
      } while (this.jdField_a_of_type_Ayqm == null);
      i1 = i2;
    } while (this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long <= 0L);
    return (int)(this.jdField_a_of_type_Ayqm.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_Ayqm != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long > 0L)
      {
        i2 = (int)(this.jdField_a_of_type_Ayqm.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long);
        i1 = i2;
        if (this.jdField_a_of_type_Ayqm.jdField_a_of_type_Int == 0) {
          if (this.jdField_a_of_type_Ayqm.jdField_b_of_type_Int != 1)
          {
            i1 = i2;
            if (this.jdField_a_of_type_Ayqm.jdField_b_of_type_Int != 131075) {}
          }
          else
          {
            i1 = i2;
            if (i2 == 100)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Ayqm.jdField_d_of_type_Int != 1003) {
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
    if (this.jdField_a_of_type_Ayqm != null)
    {
      g();
      f();
    }
  }
  
  public void j() {}
  
  public void k()
  {
    boolean bool = false;
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_Aywa.b());
    if (localInteger == null) {}
    for (int i1 = 0;; i1 = localInteger.intValue())
    {
      this.jdField_m_of_type_Int = i1;
      if (this.jdField_a_of_type_Aywa.jdField_d_of_type_Int < 3) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      return;
    }
  }
  
  public void l()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_Aywa.b(), Integer.valueOf(this.jdField_m_of_type_Int));
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
  
  public void onResp(aysx paramaysx)
  {
    a(paramaysx);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayoz
 * JD-Core Version:    0.7.0.1
 */