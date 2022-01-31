import android.os.Environment;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lbasp;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager.ProxyIp;

public class bamw
  implements bapx, barg, baxv, bdlq
{
  protected static bapw a;
  private static Object jdField_a_of_type_JavaLangObject;
  private static ArrayList<baua> jdField_a_of_type_JavaUtilArrayList;
  static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static String k;
  private int jdField_a_of_type_Int;
  public bamu a;
  protected bamy a;
  public baoj a;
  public bapv a;
  protected baqv a;
  protected barz a;
  protected basf a;
  public baub a;
  protected bawo a;
  protected AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public HashMap<String, String> a;
  protected List<ProxyIpManager.ProxyIp> a;
  private boolean jdField_a_of_type_Boolean;
  String a_ = "P";
  private int b;
  protected bamy b;
  protected bamy c = new bamy();
  int d;
  protected bamy d;
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
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_k_of_type_JavaLangString = "param_reason";
    jdField_a_of_type_Bapw = new bamx();
  }
  
  public bamw()
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
    this.jdField_a_of_type_Barz = new barz();
    this.jdField_a_of_type_Bamy = new bamy();
    this.jdField_b_of_type_Bamy = new bamy();
    this.jdField_d_of_type_Bamy = new bamy();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
  }
  
  public bamw(bamu parambamu, baub parambaub)
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
    this.jdField_a_of_type_Barz = new barz();
    this.jdField_a_of_type_Bamy = new bamy();
    this.jdField_b_of_type_Bamy = new bamy();
    this.jdField_d_of_type_Bamy = new bamy();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = parambamu.jdField_a_of_type_ComTencentCommonAppAppInterface;
    this.jdField_k_of_type_Long = System.nanoTime();
    awen.a("BaseTransProcessor", "TimeCompare", "Processor Start Time = " + this.jdField_k_of_type_Long + "ns,Processor = " + this);
    this.jdField_a_of_type_Baoj = new baoj();
    this.jdField_a_of_type_Bamu = parambamu;
    this.jdField_a_of_type_Baub = parambaub;
    this.jdField_a_of_type_Baoj.jdField_b_of_type_Int = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
    this.jdField_a_of_type_Baoj.jdField_b_of_type_Long = this.jdField_a_of_type_Baub.jdField_a_of_type_Long;
    this.jdField_a_of_type_Baoj.jdField_h_of_type_Int = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    this.jdField_a_of_type_Baoj.q = this.jdField_a_of_type_Baub.c;
    parambamu = this.jdField_a_of_type_Baoj;
    if (this.jdField_a_of_type_Baub.jdField_a_of_type_Boolean) {
      i1 = 0;
    }
    parambamu.jdField_a_of_type_Int = i1;
    this.jdField_a_of_type_Bapv = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0);
    k();
  }
  
  public bamw(batw parambatw)
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
    this.jdField_a_of_type_Barz = new barz();
    this.jdField_a_of_type_Bamy = new bamy();
    this.jdField_b_of_type_Bamy = new bamy();
    this.jdField_d_of_type_Bamy = new bamy();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_Bamu = parambatw;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = parambatw.a;
    this.jdField_a_of_type_Baoj = new baoj();
    this.jdField_k_of_type_Long = System.nanoTime();
  }
  
  public bamw(String paramString1, String paramString2, boolean paramBoolean, batw parambatw)
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
    this.jdField_a_of_type_Barz = new barz();
    this.jdField_a_of_type_Bamy = new bamy();
    this.jdField_b_of_type_Bamy = new bamy();
    this.jdField_d_of_type_Bamy = new bamy();
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = true;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_a_of_type_Bamu = parambatw;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = parambatw.a;
    this.jdField_k_of_type_Long = System.nanoTime();
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Baoj = new baoj(paramString1, paramString2, i1);
      this.jdField_a_of_type_Baoj.jdField_a_of_type_Bamw = this;
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
    return bamf.a(paramException);
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
        baua localbaua;
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
              localbaua = (baua)localIterator.next();
              localObject2 = localbaua.getFilter();
            } while (((ArrayList)localObject2).isEmpty());
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        } while (!paramClass.isAssignableFrom((Class)((Iterator)localObject2).next()));
        Message localMessage = localbaua.obtainMessage();
        localMessage.what = paramMessage.what;
        localMessage.obj = paramMessage.obj;
        localMessage.arg1 = paramMessage.arg1;
        localbaua.sendMessageDelayed(localMessage, paramLong);
      }
    }
  }
  
  private void a(baqw parambaqw)
  {
    long l1 = 0L;
    if ((parambaqw.h != 0L) && (this.jdField_p_of_type_Boolean)) {
      if (parambaqw.jdField_a_of_type_JavaUtilHashMap.get("X-httime") == null) {
        break label219;
      }
    }
    for (int i1 = Integer.parseInt((String)parambaqw.jdField_a_of_type_JavaUtilHashMap.get("X-httime"));; i1 = 0)
    {
      if (parambaqw.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime") != null) {
        l1 = Integer.parseInt((String)parambaqw.jdField_a_of_type_JavaUtilHashMap.get("X-piccachetime"));
      }
      long l2 = i1 - l1;
      long l3 = parambaqw.h - i1;
      this.jdField_n_of_type_Long += l3;
      this.jdField_m_of_type_Long += l2;
      this.jdField_o_of_type_Long += l1;
      this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.jdField_o_of_type_Int).append("_").append("tr").append(l3).append("_").append("ht").append(l2).append("_").append("pic").append(l1).append(";");
      this.jdField_o_of_type_Int += 1;
      this.jdField_p_of_type_Long = parambaqw.i;
      return;
      label219:
      this.jdField_p_of_type_Boolean = false;
    }
  }
  
  public static void a(baua parambaua)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(parambaua)) {
        jdField_a_of_type_JavaUtilArrayList.add(parambaua);
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
  
  static boolean a(List<ProxyIpManager.ProxyIp> paramList, List<basp> paramList1)
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
        basp localbasp = (basp)((Iterator)localObject).next();
        if ((localProxyIp.ip.equals(localbasp.jdField_a_of_type_JavaLangString)) && (localProxyIp.port == localbasp.jdField_a_of_type_Int)) {
          paramList1.remove(localbasp);
        }
      }
      localObject = new basp();
      ((basp)localObject).jdField_a_of_type_JavaLangString = localProxyIp.ip;
      ((basp)localObject).jdField_a_of_type_Int = localProxyIp.port;
      localArrayList.add(localObject);
    }
    paramList1.addAll(0, localArrayList);
    return true;
  }
  
  public static String b(long paramLong)
  {
    return "M_" + paramLong;
  }
  
  public static void b(baua parambaua)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(parambaua);
      return;
    }
  }
  
  public static String d(String paramString)
  {
    return "C_" + paramString;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Baoj != null)
    {
      if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int == 0) {
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
    if (this.jdField_a_of_type_Baub != null) {
      if (!this.jdField_a_of_type_Baub.jdField_a_of_type_Boolean) {
        break label195;
      }
    }
    label195:
    for (int i1 = 1004;; i1 = 2004)
    {
      d(i1);
      this.jdField_o_of_type_Boolean = true;
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Baub != null)) {
        b("cancel", "");
      }
      if (this.jdField_a_of_type_Bawo != null)
      {
        baxu.b(this.jdField_a_of_type_Bawo);
        this.jdField_a_of_type_Bawo = null;
      }
      if (this.jdField_a_of_type_Baqv != null)
      {
        this.jdField_a_of_type_Bapv.b(this.jdField_a_of_type_Baqv);
        this.jdField_a_of_type_Baqv = null;
      }
      this.jdField_a_of_type_Bamu.a(a());
      try
      {
        if (this.jdField_a_of_type_Baub != null)
        {
          baui localbaui = this.jdField_a_of_type_Baub.jdField_a_of_type_Baui;
          if (localbaui != null)
          {
            localbaui.jdField_a_of_type_Int = -1;
            localbaui.jdField_a_of_type_Long = 9037L;
            localbaui.jdField_a_of_type_Baub = this.jdField_a_of_type_Baub;
          }
        }
        if (this.jdField_a_of_type_Baub != null) {
          b("cancel", "");
        }
        notifyAll();
        if (this.jdField_a_of_type_Baub != null) {
          b("cancel", "");
        }
        return 0;
      }
      finally {}
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Baoj.jdField_a_of_type_Long;
  }
  
  public baoj a()
  {
    return this.jdField_a_of_type_Baoj;
  }
  
  @Deprecated
  public baok a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_Baoj.jdField_a_of_type_Baok;
        return localObject1;
      }
      finally {}
      if (paramInt == 1) {
        localObject1 = this.jdField_a_of_type_Baoj.jdField_b_of_type_Baok;
      } else if (paramInt == 2) {
        localObject1 = this.jdField_a_of_type_Baoj.jdField_a_of_type_Baol;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Baoj.c;
      } else if (paramInt == 3) {
        localObject1 = this.jdField_a_of_type_Baoj.jdField_b_of_type_Baol;
      }
    }
  }
  
  baub a()
  {
    return this.jdField_a_of_type_Baub;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    return MessageForPtt.getLocalFilePath(paramInt, aljq.aX + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + baoj.a() + ".amr");
  }
  
  protected String a(String paramString, List<basp> paramList)
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
    basp localbasp;
    do
    {
      return paramList;
      localbasp = basj.a(paramString);
      if (localbasp != null) {
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
      if ((!((ProxyIpManager.ProxyIp)localObject3).ip.equals(localbasp.jdField_a_of_type_JavaLangString)) || (((ProxyIpManager.ProxyIp)localObject3).port != localbasp.jdField_a_of_type_Int)) {
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
        paramString = basj.a(paramString, paramList);
        paramString = paramString + "&bHost=" + localbasp.jdField_a_of_type_JavaLangString + "&bPort=" + localbasp.jdField_a_of_type_Int;
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
          paramList = (List<basp>)localObject1;
          do
          {
            localObject2 = paramList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (basp)((Iterator)localObject3).next();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            do
            {
              localObject1 = paramList;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject1 = (ProxyIpManager.ProxyIp)localIterator.next();
            } while ((((basp)localObject2).jdField_a_of_type_JavaLangString.equals(((ProxyIpManager.ProxyIp)localObject1).ip)) || (((basp)localObject2).jdField_a_of_type_Int == ((ProxyIpManager.ProxyIp)localObject1).port));
            localObject1 = localObject2;
            paramList = (List<basp>)localObject1;
          } while (localObject1 == null);
          localObject2 = localObject1;
          localObject1 = paramString;
          if (localObject2 != null) {
            localObject1 = paramString + "&bHost=" + ((basp)localObject2).jdField_a_of_type_JavaLangString + "&bPort=" + ((basp)localObject2).jdField_a_of_type_Int;
          }
          paramList = (List<basp>)localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PROXY_IP", 2, "[HTTP] replace proxy ip: " + localbasp.jdField_a_of_type_JavaLangString + ":" + localbasp.jdField_a_of_type_Int);
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
      String str = bamf.a(new Exception());
      HashMap localHashMap = new HashMap();
      localHashMap.put("stackMsg", str);
      azmz.a(BaseApplication.getContext()).a(null, "actRichMediaReportError", false, 0L, 0L, localHashMap, "");
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
      basj.a(true, "image_sending_too_long");
    }
    for (;;)
    {
      b(paramInt1, paramInt2, paramLong);
      return;
      bool = false;
      break;
      label209:
      basj.a(bool, "image_sending_" + this.jdField_j_of_type_Int + "_" + this.jdField_j_of_type_JavaLangString);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, long paramLong, String paramString)
  {
    try
    {
      baol localbaol = this.jdField_a_of_type_Baoj.jdField_a_of_type_Baol;
      localbaol.jdField_a_of_type_Int = paramInt1;
      localbaol.jdField_a_of_type_Boolean = false;
      localbaol.jdField_a_of_type_JavaLangString = paramString;
      localbaol.jdField_e_of_type_Int = paramInt2;
      localbaol.c = paramLong;
      b(localbaol.jdField_a_of_type_Int, localbaol.jdField_a_of_type_JavaLangString);
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
      baok localbaok = a(paramInt1);
      if (localbaok != null)
      {
        localbaok.jdField_a_of_type_Int = paramInt2;
        localbaok.jdField_a_of_type_JavaLangString = paramString;
        localbaok.jdField_a_of_type_Boolean = false;
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
  
  public void a(int paramInt, String paramString1, String paramString2, bamy parambamy)
  {
    this.jdField_j_of_type_Int = paramInt;
    this.jdField_i_of_type_JavaLangString = paramString2;
    this.jdField_j_of_type_JavaLangString = paramString1;
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", paramString2);
    }
    if (parambamy != null)
    {
      parambamy.b();
      parambamy.jdField_a_of_type_Int = 0;
    }
  }
  
  @Deprecated
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      baok localbaok = a(paramInt);
      if ((localbaok != null) && ((localbaok.jdField_a_of_type_Long == 0L) || (paramBoolean))) {
        localbaok.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Baoj.a(paramLong);
  }
  
  public void a(bamy parambamy, baqw parambaqw, boolean paramBoolean)
  {
    if ((parambamy == null) || (parambaqw == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_Server", parambaqw.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("serverip", parambaqw.jdField_a_of_type_JavaUtilHashMap.get("serverip"));
      parambamy.jdField_b_of_type_Int += 1;
      parambamy.c += parambaqw.jdField_d_of_type_Int - 1;
      parambamy.b();
      parambamy.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("serverip", parambaqw.jdField_a_of_type_JavaUtilHashMap.get("firstserverip"));
    parambamy.c += parambaqw.jdField_d_of_type_Int;
    if (parambaqw.jdField_b_of_type_Int == -9527) {}
    for (String str = (String)parambaqw.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; str = null)
    {
      a(parambaqw.jdField_b_of_type_Int, parambaqw.jdField_a_of_type_JavaLangString, str, parambamy);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_url", parambaqw.jdField_a_of_type_JavaUtilHashMap.get("param_url"));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", parambaqw.jdField_a_of_type_JavaUtilHashMap.get("param_rspHeader"));
      if ((parambaqw.jdField_b_of_type_Int == -9527) && ("H_404_-124".equals(str))) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", parambaqw.jdField_a_of_type_JavaUtilHashMap.get("param_reqHeader"));
      }
      parambamy.jdField_a_of_type_Int = 0;
      return;
    }
  }
  
  public void a(bamy parambamy, baxq parambaxq)
  {
    if ((parambamy != null) && (parambaxq != null))
    {
      parambamy.b();
      parambamy.jdField_b_of_type_Int = parambaxq.jdField_e_of_type_Int;
      parambamy.c = parambaxq.f;
      if (parambaxq.c == 0) {
        parambamy.jdField_a_of_type_Int = 1;
      }
    }
    else
    {
      return;
    }
    parambamy.jdField_a_of_type_Int = 0;
    a(parambaxq.jdField_d_of_type_Int, parambaxq.g, parambaxq.jdField_h_of_type_JavaLangString, parambamy);
  }
  
  public void a(bamy parambamy, boolean paramBoolean1, boolean paramBoolean2, alsj paramalsj)
  {
    if (paramalsj == null) {
      return;
    }
    parambamy.b();
    if (paramBoolean2)
    {
      parambamy.c = (paramalsj.c - 1);
      parambamy.jdField_b_of_type_Int = 1;
      parambamy.jdField_a_of_type_Int = 1;
      return;
    }
    String str;
    if (paramalsj.jdField_b_of_type_Int == 2900)
    {
      i1 = -9527;
      if (!paramBoolean1) {}
      for (str = b(paramalsj.jdField_a_of_type_Long);; str = a(paramalsj.jdField_a_of_type_Long))
      {
        a(i1, "", str, parambamy);
        parambamy.c = paramalsj.c;
        parambamy.jdField_b_of_type_Int = 0;
        parambamy.jdField_a_of_type_Int = 0;
        return;
      }
    }
    if ((paramalsj.jdField_b_of_type_Int == 1002) || (paramalsj.jdField_b_of_type_Int == 1013))
    {
      if (!paramBoolean1) {}
      for (i1 = 9350;; i1 = 9311)
      {
        str = paramalsj.jdField_a_of_type_JavaLangString;
        break;
      }
    }
    if (!paramBoolean1) {}
    for (int i1 = 9351;; i1 = 9044)
    {
      str = paramalsj.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  public void a(bari parambari, barh parambarh) {}
  
  public void a(bawo parambawo, baxd parambaxd) {}
  
  public void a(bdlo parambdlo1, bdlo parambdlo2) {}
  
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
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Barz.e = this.jdField_i_of_type_JavaLangString;
    this.jdField_a_of_type_Barz.e = this.jdField_j_of_type_JavaLangString;
    this.jdField_a_of_type_Barz.f = (this.jdField_a_of_type_Baub.jdField_a_of_type_Int + "");
    this.jdField_a_of_type_Barz.g = (this.jdField_a_of_type_Baub.c + "");
    if ((this instanceof banb)) {}
    for (this.jdField_a_of_type_Barz.jdField_a_of_type_Int = Ipv6Config.sBdhStrategy;; this.jdField_a_of_type_Barz.jdField_a_of_type_Int = Ipv6Config.sRMDownStrategy)
    {
      if ((this.jdField_b_of_type_Bamy != null) && (this.jdField_b_of_type_Bamy.jdField_a_of_type_Long > 0L)) {
        this.jdField_a_of_type_Barz.jdField_a_of_type_Long = ((System.nanoTime() - this.jdField_b_of_type_Bamy.jdField_a_of_type_Long) / 1000000L);
      }
      this.jdField_a_of_type_Barz.a(paramString, paramBoolean);
      return;
    }
  }
  
  public void a(ArrayList<basp> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramString != null))
    {
      basp localbasp = new basp();
      localbasp.jdField_a_of_type_JavaLangString = paramString;
      localbasp.b = true;
      paramArrayList.add(localbasp);
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  public boolean a(bdlo parambdlo1, bdlo parambdlo2, int paramInt)
  {
    return true;
  }
  
  public void aS_() {}
  
  public int b()
  {
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Baoj.jdField_e_of_type_Long;
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
        baua localbaua;
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
              localbaua = (baua)localIterator.next();
              localObject3 = localbaua.getFilter();
            } while (((ArrayList)localObject3).isEmpty());
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localObject4 = (Class)((Iterator)localObject3).next();
        } while (!getClass().equals(localObject4));
        Object localObject4 = localbaua.obtainMessage();
        this.jdField_a_of_type_Baoj.jdField_e_of_type_Int = this.jdField_a_of_type_Baoj.jdField_d_of_type_Int;
        this.jdField_a_of_type_Baoj.jdField_d_of_type_Int = paramInt1;
        ((Message)localObject4).what = paramInt1;
        ((Message)localObject4).obj = this.jdField_a_of_type_Baoj;
        ((Message)localObject4).arg1 = paramInt2;
        localbaua.sendMessageDelayed((Message)localObject4, paramLong);
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, null, null);
  }
  
  public void b(bdlo parambdlo1, bdlo parambdlo2) {}
  
  public void b(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Baoj == null) {
      awen.b("BaseTransProcessor", "logRichMediaEvent", "file is null !");
    }
    do
    {
      return;
      if (!(this instanceof basv)) {
        break;
      }
    } while (this.jdField_a_of_type_Baub == null);
    basj.a("T", basj.b(this.jdField_a_of_type_Baub.jdField_a_of_type_Int), basj.c(this.jdField_a_of_type_Baoj.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Baoj.jdField_b_of_type_Long), paramString1, paramString2, null);
    return;
    int i1 = -1;
    if (this.jdField_a_of_type_Baub != null) {
      i1 = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    }
    if ((this instanceof banc))
    {
      i1 = 0;
      if (this.jdField_a_of_type_Baub == null) {
        break label162;
      }
      bool = this.jdField_a_of_type_Baub.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      basj.a(basj.b(i1), bool, basj.c(this.jdField_a_of_type_Baoj.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_Baoj.jdField_b_of_type_Long), paramString1, paramString2);
      return;
      if (!(this instanceof bang)) {
        break;
      }
      i1 = 0;
      break;
      label162:
      if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int == 0) {
        bool = true;
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("ipStackType", String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
    this.jdField_a_of_type_JavaUtilHashMap.put("msfConnIPType", String.valueOf(MsfServiceSdk.get().getConnectedIPFamily()));
    if ((this instanceof banb)) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_Ipv6Policy", String.valueOf(Ipv6Config.sBdhStrategy));
    }
    for (;;)
    {
      if (((this instanceof bamr)) && (((bamr)this).jdField_a_of_type_JavaUtilArrayList.size() > 0) && (baqa.a()))
      {
        basp localbasp = (basp)((bamr)this).jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((localbasp != null) && ((localbasp.jdField_a_of_type_Boolean) || (localbasp.b))) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_is_ipv6", String.valueOf(1));
        }
      }
      if ((this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6") != null) && (((String)this.jdField_a_of_type_JavaUtilHashMap.get("param_is_ipv6")).equals(String.valueOf(1)))) {
        azmz.a(BaseApplication.getContext()).a(null, b() + "_ipv6", paramBoolean, paramLong, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_Ipv6Policy", String.valueOf(Ipv6Config.sRMDownStrategy));
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Baoj.jdField_d_of_type_Int;
  }
  
  public void c() {}
  
  @Deprecated
  public void c(int paramInt)
  {
    try
    {
      baok localbaok = a(paramInt);
      if (localbaok != null) {
        localbaok.jdField_b_of_type_Long = System.currentTimeMillis();
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
    return this.jdField_a_of_type_Baoj.jdField_e_of_type_Int;
  }
  
  protected void d()
  {
    long l1 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isRunning())) {
      b(9366, "account switch");
    }
    b("onError", "elapsed:" + l1 + " errCode:" + this.jdField_j_of_type_Int + " errDesc:" + this.jdField_j_of_type_JavaLangString + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason"));
    a(false);
    this.jdField_a_of_type_Bamu.a(a());
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
    this.jdField_a_of_type_Bamu.a(a());
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Baoj.a(paramInt);
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
      } while (this.jdField_a_of_type_Baoj == null);
      i1 = i2;
    } while (this.jdField_a_of_type_Baoj.jdField_a_of_type_Long <= 0L);
    return (int)(this.jdField_a_of_type_Baoj.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Baoj.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_Baoj != null)
    {
      i1 = i2;
      if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Long > 0L)
      {
        i2 = (int)(this.jdField_a_of_type_Baoj.jdField_e_of_type_Long * 100L / this.jdField_a_of_type_Baoj.jdField_a_of_type_Long);
        i1 = i2;
        if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int == 0) {
          if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int != 1)
          {
            i1 = i2;
            if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int != 131075) {}
          }
          else
          {
            i1 = i2;
            if (i2 == 100)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Baoj.jdField_d_of_type_Int != 1003) {
                i1 = 99;
              }
            }
          }
        }
      }
    }
    return i1;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Baoj != null)
    {
      g();
      f();
    }
  }
  
  public void j() {}
  
  public void k()
  {
    boolean bool = false;
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_Baub.b());
    if (localInteger == null) {}
    for (int i1 = 0;; i1 = localInteger.intValue())
    {
      this.jdField_m_of_type_Int = i1;
      if (this.jdField_a_of_type_Baub.jdField_d_of_type_Int < 3) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      return;
    }
  }
  
  public void l()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_Baub.b(), Integer.valueOf(this.jdField_m_of_type_Int));
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
  
  public void onResp(baqw parambaqw)
  {
    a(parambaqw);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamw
 * JD-Core Version:    0.7.0.1
 */