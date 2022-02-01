import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.HttpsURLConnection;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bhuw
{
  private static long jdField_a_of_type_Long = 1L;
  private int jdField_a_of_type_Int;
  private bhuz jdField_a_of_type_Bhuz = new bhuz();
  private Object jdField_a_of_type_JavaLangObject = new ReentrantLock();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private WeakReference<bhvb> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = true;
  private bhuy[] jdField_a_of_type_ArrayOfBhuy;
  private final int jdField_b_of_type_Int = 4;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int d;
  private int e;
  
  public bhuw() {}
  
  public bhuw(bhvb parambhvb, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambhvb);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "construct HTTPcomm");
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_d_of_type_Int = 4;
    this.e = 0;
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    System.setProperty("http.maxConnections", "2");
  }
  
  private HttpURLConnection a(bhva parambhva)
  {
    Object localObject1 = parambhva.a();
    String str1 = (String)parambhva.jdField_a_of_type_JavaUtilHashMap.remove("mType");
    String str2;
    int i1;
    int k;
    int i;
    label52:
    Object localObject2;
    int j;
    if (str1 != null)
    {
      str1 = MsfSdkUtils.insertMtype(str1, (String)localObject1);
      localObject1 = null;
      str2 = android.net.Proxy.getDefaultHost();
      i1 = android.net.Proxy.getDefaultPort();
      k = 0;
      i = 0;
      if ((i != 0) || (k >= 2)) {
        break label945;
      }
      localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      localObject1 = null;
      if (localObject2 == null) {
        break label954;
      }
      j = ((NetworkInfo)localObject2).getType();
      localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
    }
    for (;;)
    {
      String str3 = bhvd.b((String)localObject1);
      parambhva.jdField_e_of_type_Boolean = bhvd.jdField_d_of_type_JavaLangString.equals(str3);
      if (!str3.equals(this.jdField_a_of_type_JavaLangString))
      {
        if ((j == 1) || (str3.equals(bhvd.jdField_d_of_type_JavaLangString))) {
          this.jdField_a_of_type_Boolean = false;
        }
      }
      else
      {
        label151:
        if ((j == 1) && (("10.0.0.172".equals(str2)) || ("10.0.0.200".equals(str2)))) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((str2 == null) || (i1 <= 0)) {
          break label948;
        }
      }
      label285:
      label945:
      label948:
      for (int m = 1;; m = 0)
      {
        int i2;
        Object localObject3;
        int n;
        if ((!this.jdField_a_of_type_Boolean) && (m != 0)) {
          if ((str3.equals(bhvd.jdField_d_of_type_JavaLangString)) || (str3.equals(bhvd.jdField_f_of_type_JavaLangString)) || (str3.equals(bhvd.h))) {
            if (!parambhva.jdField_f_of_type_Boolean) {
              switch (parambhva.jdField_h_of_type_Int)
              {
              default: 
                localObject1 = bhvd.b(str1, str2, i1);
                i = 1;
                a((HttpURLConnection)localObject1, parambhva);
                parambhva.jdField_d_of_type_Int = j;
                i2 = bevn.a().a();
                if (parambhva.jdField_a_of_type_Bewq == null)
                {
                  localObject3 = bewk.a(i2);
                  n = ((bewn)localObject3).a();
                  if ("POST".equals(parambhva.e())) {
                    j = 89500;
                  }
                }
                break;
              }
            }
          }
        }
        for (;;)
        {
          ((HttpURLConnection)localObject1).setConnectTimeout(n);
          ((HttpURLConnection)localObject1).setReadTimeout(j);
          a(parambhva, "gettingConn", "getConnection type:" + i2 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i1 + " last apnType:" + this.jdField_a_of_type_JavaLangString + " forceDirect:" + this.jdField_a_of_type_Boolean + ",connectTimeOut:" + n + ",readTimeout:" + j);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          localObject2 = parambhva.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
          str1 = MsfSdkUtils.insertMtype("Other", (String)localObject1);
          break;
          this.jdField_a_of_type_Boolean = true;
          break label151;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
          i = 0;
          break label285;
          localObject1 = bhvd.a(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = bhvd.b(str1, str2, i1);
          i = 1;
          break label285;
          if (str3.equals(bhvd.b))
          {
            localObject1 = bhvd.a(str1, str2, i1);
            i = 1;
            break label285;
          }
          localObject1 = bhvd.a(str1, str2, i1);
          i = 1;
          break label285;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection();
          i = 0;
          break label285;
          j = ((bewn)localObject3).b();
          continue;
          n = parambhva.jdField_a_of_type_Bewq.b(i2);
          j = parambhva.jdField_a_of_type_Bewq.a(i2);
        }
        if (parambhva.e().equals("POST"))
        {
          ((HttpURLConnection)localObject1).setDoOutput(true);
          if (parambhva.b() != null) {
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(parambhva.b().length);
          }
        }
        parambhva.jdField_c_of_type_JavaLangString = ((HttpURLConnection)localObject1).getRequestProperties().toString();
        try
        {
          ((HttpURLConnection)localObject1).connect();
          i = 1;
        }
        catch (Exception localException)
        {
          while (m != 0) {
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = false;
            }
            else
            {
              throw localException;
            }
          }
          throw localException;
        }
        catch (AssertionError localAssertionError)
        {
          String str4;
          for (;;)
          {
            str4 = localAssertionError.getMessage();
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.HttpCommunicator", 2, "assertion:" + str4);
            }
            if (m == 0) {
              break;
            }
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.jdField_a_of_type_Boolean = false;
            }
            else
            {
              i = 1;
            }
          }
          throw new SocketException("AssertionError : " + str4);
        }
        this.jdField_a_of_type_JavaLangString = str3;
        k += 1;
        break label52;
        return localObject1;
      }
      label954:
      j = -1;
    }
  }
  
  private void a(bhva parambhva1, bhva parambhva2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
    }
    parambhva1.a().a(parambhva1, parambhva2, paramInt);
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, bhva parambhva)
  {
    String str;
    bhux localbhux;
    if ((parambhva.i) && ((paramHttpURLConnection instanceof HttpsURLConnection)))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      str = parambhva.jdField_e_of_type_JavaLangString;
      localbhux = new bhux(this, str, parambhva);
      if (parambhva.j)
      {
        paramHttpURLConnection.setRequestProperty("host", str);
        paramHttpURLConnection.setSSLSocketFactory(new bhve(str, localbhux));
        paramHttpURLConnection.setHostnameVerifier(localbhux);
      }
    }
    else
    {
      return;
    }
    paramHttpURLConnection.setRequestProperty("host", str);
    paramHttpURLConnection.setHostnameVerifier(localbhux);
  }
  
  private boolean a(boolean paramBoolean)
  {
    int j = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_Boolean) {
        return false;
      }
      if (!this.jdField_b_of_type_Boolean) {
        return true;
      }
      if (this.jdField_a_of_type_Bhuz.a() > 0) {
        return false;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfBhuy == null) || (this.jdField_a_of_type_ArrayOfBhuy.length == 0)) {
      return false;
    }
    if (this.e > 0) {
      return false;
    }
    bhuy[] arrayOfbhuy = this.jdField_a_of_type_ArrayOfBhuy;
    int k = arrayOfbhuy.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        bhuy localbhuy = arrayOfbhuy[i];
        if ((localbhuy != null) && (localbhuy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) && (localbhuy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
          return false;
        }
      }
      else
      {
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator checkThreadPoolIdle ，ThreadPool Quit ");
          }
          arrayOfbhuy = this.jdField_a_of_type_ArrayOfBhuy;
          k = arrayOfbhuy.length;
          i = j;
          while (i < k)
          {
            arrayOfbhuy[i].sendEmptyMessage(1);
            i += 1;
          }
          this.e = 0;
          this.jdField_d_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ArrayOfBhuy = null;
        }
        return true;
      }
      i += 1;
    }
  }
  
  public int a(bhva parambhva)
  {
    int i = -1;
    int k = this.jdField_c_of_type_Int;
    int j = 1;
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((parambhva != null) && (parambhva.a() != null))
      {
        parambhva.a(9366, -1, "close");
        parambhva.a().b(parambhva, parambhva);
        k = i;
        return k;
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      a();
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (parambhva != null) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bhuz.a() < k)
        {
          i = this.jdField_a_of_type_Int + 1;
          this.jdField_a_of_type_Int = i;
          parambhva.a(i);
          parambhva.jdField_e_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_a_of_type_Bhuz.a(parambhva);
          parambhva.a().a(parambhva, null, 0);
          i = this.jdField_a_of_type_Int;
          k = i;
          if (j == 0) {
            break;
          }
          a("sendMsg");
          return i;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        }
        if ((parambhva != null) && (parambhva.a() != null))
        {
          parambhva.a(9367, -1, "queen full");
          parambhva.a().b(parambhva, parambhva);
        }
      }
      finally {}
      j = 0;
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bhuz != null) {
      return this.jdField_a_of_type_Bhuz.a();
    }
    return "";
  }
  
  public void a()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
          return;
        }
        if ((this.jdField_a_of_type_MqqOsMqqHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
        this.jdField_b_of_type_Boolean = true;
        this.e = 0;
        if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
          this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
        }
        if (this.jdField_a_of_type_ArrayOfBhuy == null)
        {
          this.jdField_a_of_type_ArrayOfBhuy = new bhuy[4];
          if (i < 4)
          {
            HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("httpcommunicator_norm_" + i, 5);
            localHandlerThread.start();
            this.jdField_a_of_type_ArrayOfBhuy[i] = new bhuy(this, localHandlerThread.getLooper());
            this.jdField_a_of_type_ArrayOfBhuy[i].jdField_a_of_type_Int = i;
            i += 1;
            continue;
          }
        }
        i = bevn.a().a();
        if ((i == 2) || (i == 3))
        {
          this.jdField_d_of_type_Int = 3;
          return;
        }
      }
      this.jdField_d_of_type_Int = 4;
    }
  }
  
  public void a(int paramInt)
  {
    localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_Int = 4;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.HttpCommunicator", 2, "netType:" + paramInt + " concurrent:" + this.jdField_d_of_type_Int);
        }
        a("netChange");
        return;
      }
      finally {}
      this.jdField_d_of_type_Int = 3;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  void a(int paramInt, HttpURLConnection paramHttpURLConnection, bhva parambhva)
  {
    if ((paramHttpURLConnection == null) || (parambhva == null)) {
      return;
    }
    parambhva.c(paramInt);
    parambhva.b("Content-Type", paramHttpURLConnection.getContentType());
    parambhva.jdField_d_of_type_JavaLangString = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      parambhva.b("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      parambhva.b("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      parambhva.b("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      parambhva.b("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      parambhva.b("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      parambhva.b("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("Transfer-Encoding") != null) {
      parambhva.b("Transfer-Encoding", paramHttpURLConnection.getHeaderField("Transfer-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      parambhva.b("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      parambhva.b("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      parambhva.b("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    parambhva.jdField_a_of_type_Long = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i;
    if (str != null) {
      i = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        parambhva.jdField_a_of_type_Long = Long.valueOf(str.substring(i + 1)).longValue();
        parambhva.jdField_b_of_type_Long = paramHttpURLConnection.getContentLength();
        a(parambhva, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + parambhva.jdField_a_of_type_Long + ",totalBlockLen:" + parambhva.jdField_b_of_type_Long);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      parambhva.jdField_a_of_type_Long = paramHttpURLConnection.getContentLength();
      parambhva.jdField_b_of_type_Long = parambhva.jdField_a_of_type_Long;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    int i = 4;
    int j = (int)(2L * paramLong / 90000L);
    if (j > 4) {}
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i + 9400));
      localHashMap.put("param_PostSize", String.valueOf(paramInt));
      bdmc.a(BaseApplication.getContext()).a(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i = j;
    }
  }
  
  public void a(bhuy parambhuy)
  {
    if (this.jdField_c_of_type_Boolean) {}
    int i;
    do
    {
      do
      {
        return;
      } while (parambhuy == null);
      parambhuy.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i = parambhuy.jdField_a_of_type_Int;
      if ((i >= 0) && (i < 4))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i, 5);
        ((HandlerThread)???).start();
        bhuy localbhuy = new bhuy(this, ((HandlerThread)???).getLooper());
        localbhuy.jdField_a_of_type_Int = i;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ArrayOfBhuy[i] = localbhuy;
          if (parambhuy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            this.e -= 1;
          }
          a("replaceNewThread index:" + i);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i);
  }
  
  void a(bhuy parambhuy, bhva parambhva)
  {
    if ((!this.jdField_b_of_type_Boolean) && (!parambhva.l)) {
      throw new IOException("httpcommunicator closed");
    }
    if (parambhva.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("request cancelled");
    }
    if ((parambhuy != null) && (parambhuy.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      throw new RuntimeException("thread should close");
    }
    if (parambhva.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(parambhva, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  public void a(bhva parambhva)
  {
    a(parambhva, null);
  }
  
  /* Error */
  public void a(bhva parambhva, bhuy parambhuy)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 386	bhva:a	()Lbhvc;
    //   4: astore 30
    //   6: aconst_null
    //   7: astore 23
    //   9: aconst_null
    //   10: astore 28
    //   12: aconst_null
    //   13: astore 26
    //   15: aconst_null
    //   16: astore 22
    //   18: aconst_null
    //   19: astore 29
    //   21: aconst_null
    //   22: astore 27
    //   24: iconst_m1
    //   25: istore_3
    //   26: lconst_0
    //   27: lstore 12
    //   29: lconst_0
    //   30: lstore 14
    //   32: iconst_0
    //   33: istore 10
    //   35: iconst_0
    //   36: istore 7
    //   38: iconst_0
    //   39: istore 6
    //   41: aload_0
    //   42: aload_1
    //   43: aconst_null
    //   44: iconst_1
    //   45: invokespecial 673	bhuw:a	(Lbhva;Lbhva;I)V
    //   48: iconst_0
    //   49: istore 5
    //   51: iconst_0
    //   52: istore 10
    //   54: aconst_null
    //   55: astore 24
    //   57: aload_0
    //   58: aload_1
    //   59: ldc_w 675
    //   62: ldc_w 487
    //   65: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: aload_2
    //   70: aload_1
    //   71: invokevirtual 677	bhuw:a	(Lbhuy;Lbhva;)V
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 679	bhuw:a	(Lbhva;)Ljava/net/HttpURLConnection;
    //   79: astore 25
    //   81: aload 25
    //   83: astore 23
    //   85: aload_1
    //   86: aload 23
    //   88: putfield 682	bhva:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   91: aload_1
    //   92: invokestatic 471	android/os/SystemClock:uptimeMillis	()J
    //   95: putfield 684	bhva:jdField_c_of_type_Long	J
    //   98: aload_0
    //   99: aload_1
    //   100: ldc_w 686
    //   103: ldc_w 487
    //   106: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   109: iconst_1
    //   110: istore 10
    //   112: invokestatic 689	java/lang/System:currentTimeMillis	()J
    //   115: pop2
    //   116: aload_1
    //   117: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   120: ldc 227
    //   122: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifeq +4833 -> 4958
    //   128: new 691	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1
    //   131: dup
    //   132: aload_0
    //   133: aload_1
    //   134: aload_2
    //   135: invokespecial 694	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1:<init>	(Lbhuw;Lbhva;Lbhuy;)V
    //   138: astore 25
    //   140: aload_0
    //   141: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   144: aload 25
    //   146: ldc2_w 608
    //   149: invokevirtual 698	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   152: pop
    //   153: aload_1
    //   154: invokevirtual 352	bhva:b	()[B
    //   157: astore 31
    //   159: aload 23
    //   161: invokevirtual 702	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   164: astore 24
    //   166: aload_0
    //   167: aload_1
    //   168: ldc_w 704
    //   171: new 243	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 706
    //   181: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 31
    //   186: arraylength
    //   187: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   196: iconst_0
    //   197: istore 4
    //   199: iload 4
    //   201: aload 31
    //   203: arraylength
    //   204: if_icmpge +46 -> 250
    //   207: aload_0
    //   208: aload_2
    //   209: aload_1
    //   210: invokevirtual 677	bhuw:a	(Lbhuy;Lbhva;)V
    //   213: aload 24
    //   215: aload 31
    //   217: iload 4
    //   219: sipush 10240
    //   222: aload 31
    //   224: arraylength
    //   225: iload 4
    //   227: isub
    //   228: invokestatic 712	java/lang/Math:min	(II)I
    //   231: invokevirtual 718	java/io/OutputStream:write	([BII)V
    //   234: aload 24
    //   236: invokevirtual 721	java/io/OutputStream:flush	()V
    //   239: iload 4
    //   241: sipush 10240
    //   244: iadd
    //   245: istore 4
    //   247: goto -48 -> 199
    //   250: aload_2
    //   251: ifnull +13 -> 264
    //   254: aload_2
    //   255: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   258: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   261: ifne +14 -> 275
    //   264: aload_0
    //   265: aload_1
    //   266: ldc_w 723
    //   269: ldc_w 487
    //   272: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 23
    //   277: invokevirtual 727	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   280: invokevirtual 728	java/net/URL:toString	()Ljava/lang/String;
    //   283: invokevirtual 731	java/lang/String:length	()I
    //   286: i2l
    //   287: lstore 16
    //   289: aload 31
    //   291: arraylength
    //   292: istore 4
    //   294: lload 12
    //   296: iload 4
    //   298: i2l
    //   299: ldc2_w 732
    //   302: lload 16
    //   304: ladd
    //   305: ladd
    //   306: ladd
    //   307: lstore 12
    //   309: aload_0
    //   310: aload_2
    //   311: aload_1
    //   312: invokevirtual 677	bhuw:a	(Lbhuy;Lbhva;)V
    //   315: aload 23
    //   317: invokevirtual 736	java/net/HttpURLConnection:getResponseCode	()I
    //   320: istore 4
    //   322: aload_0
    //   323: iload 4
    //   325: aload 23
    //   327: aload_1
    //   328: invokevirtual 738	bhuw:a	(ILjava/net/HttpURLConnection;Lbhva;)V
    //   331: aload_2
    //   332: ifnull +234 -> 566
    //   335: aload_2
    //   336: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   339: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   342: istore 11
    //   344: iload 11
    //   346: ifeq +220 -> 566
    //   349: iload 4
    //   351: sipush 200
    //   354: if_icmpeq +11 -> 365
    //   357: iload 4
    //   359: sipush 206
    //   362: if_icmpne +31 -> 393
    //   365: aload_0
    //   366: aload_1
    //   367: ldc_w 740
    //   370: new 243	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 742
    //   380: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iconst_0
    //   384: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload_2
    //   394: ifnull +13 -> 407
    //   397: aload_2
    //   398: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   401: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   404: ifne +47 -> 451
    //   407: aload_0
    //   408: aload_1
    //   409: ldc_w 744
    //   412: new 243	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 746
    //   422: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_1
    //   426: invokevirtual 748	bhva:d	()Ljava/lang/String;
    //   429: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc_w 750
    //   435: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_1
    //   439: invokevirtual 752	bhva:c	()Ljava/lang/String;
    //   442: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload_0
    //   452: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   455: ifnull +17 -> 472
    //   458: aload 25
    //   460: ifnull +12 -> 472
    //   463: aload_0
    //   464: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   467: aload 25
    //   469: invokevirtual 493	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   472: lload 12
    //   474: lconst_0
    //   475: ladd
    //   476: lstore 12
    //   478: lload 12
    //   480: lconst_0
    //   481: lcmp
    //   482: ifeq +27 -> 509
    //   485: aload_1
    //   486: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   489: ldc 227
    //   491: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   494: ifeq +60 -> 554
    //   497: iconst_1
    //   498: istore 10
    //   500: aload_0
    //   501: aload_1
    //   502: iload 10
    //   504: lload 12
    //   506: invokevirtual 755	bhuw:a	(Lbhva;ZJ)V
    //   509: iconst_0
    //   510: ifeq +11 -> 521
    //   513: new 757	java/lang/NullPointerException
    //   516: dup
    //   517: invokespecial 758	java/lang/NullPointerException:<init>	()V
    //   520: athrow
    //   521: iconst_0
    //   522: ifeq +11 -> 533
    //   525: new 757	java/lang/NullPointerException
    //   528: dup
    //   529: invokespecial 758	java/lang/NullPointerException:<init>	()V
    //   532: athrow
    //   533: aload 24
    //   535: ifnull +8 -> 543
    //   538: aload 24
    //   540: invokevirtual 760	java/io/OutputStream:close	()V
    //   543: aload 23
    //   545: ifnull +8 -> 553
    //   548: aload 23
    //   550: invokevirtual 763	java/net/HttpURLConnection:disconnect	()V
    //   553: return
    //   554: iconst_0
    //   555: istore 10
    //   557: goto -57 -> 500
    //   560: astore_1
    //   561: aload_1
    //   562: invokevirtual 604	java/lang/Exception:printStackTrace	()V
    //   565: return
    //   566: aload_0
    //   567: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   570: ifnull +17 -> 587
    //   573: aload 25
    //   575: ifnull +12 -> 587
    //   578: aload_0
    //   579: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   582: aload 25
    //   584: invokevirtual 493	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   587: aload_0
    //   588: aload_1
    //   589: ldc_w 765
    //   592: new 243	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   599: ldc_w 767
    //   602: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: iload 4
    //   607: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   616: iload 4
    //   618: sipush 302
    //   621: if_icmpeq +11 -> 632
    //   624: iload 4
    //   626: sipush 301
    //   629: if_icmpne +1588 -> 2217
    //   632: iload 5
    //   634: iconst_5
    //   635: if_icmpge +1295 -> 1930
    //   638: aload_0
    //   639: aload_1
    //   640: ldc_w 769
    //   643: new 243	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 771
    //   653: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload_1
    //   657: getfield 362	bhva:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   660: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: ldc_w 773
    //   666: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload_1
    //   670: getfield 541	bhva:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   673: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   682: aload 23
    //   684: ldc_w 775
    //   687: invokevirtual 546	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   690: astore 31
    //   692: aload 31
    //   694: ifnull +763 -> 1457
    //   697: aload 24
    //   699: ifnull +8 -> 707
    //   702: aload 24
    //   704: invokevirtual 760	java/io/OutputStream:close	()V
    //   707: aload 23
    //   709: invokevirtual 763	java/net/HttpURLConnection:disconnect	()V
    //   712: iload 5
    //   714: ifne +380 -> 1094
    //   717: aload_1
    //   718: getfield 778	bhva:k	Z
    //   721: istore 11
    //   723: iload 11
    //   725: ifeq +369 -> 1094
    //   728: aload_1
    //   729: getfield 781	bhva:jdField_g_of_type_Boolean	Z
    //   732: ifeq +324 -> 1056
    //   735: aload_1
    //   736: invokevirtual 784	bhva:a	()Ljava/util/HashMap;
    //   739: ldc_w 408
    //   742: invokevirtual 786	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   745: checkcast 133	java/lang/String
    //   748: astore 22
    //   750: aload 22
    //   752: invokestatic 792	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   755: ifne +339 -> 1094
    //   758: aload 22
    //   760: ldc_w 794
    //   763: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   766: ifeq +328 -> 1094
    //   769: new 317	java/net/URL
    //   772: dup
    //   773: aload 31
    //   775: invokespecial 320	java/net/URL:<init>	(Ljava/lang/String;)V
    //   778: invokevirtual 797	java/net/URL:getHost	()Ljava/lang/String;
    //   781: invokestatic 802	azrc:a	(Ljava/lang/String;)Z
    //   784: istore 11
    //   786: iload 11
    //   788: ifne +306 -> 1094
    //   791: iload 4
    //   793: sipush 200
    //   796: if_icmpeq +11 -> 807
    //   799: iload 4
    //   801: sipush 206
    //   804: if_icmpne +31 -> 835
    //   807: aload_0
    //   808: aload_1
    //   809: ldc_w 740
    //   812: new 243	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   819: ldc_w 742
    //   822: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: iconst_0
    //   826: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   829: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload_2
    //   836: ifnull +13 -> 849
    //   839: aload_2
    //   840: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   843: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   846: ifne +101 -> 947
    //   849: aload_0
    //   850: aload_1
    //   851: ldc_w 744
    //   854: new 243	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   861: ldc_w 746
    //   864: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload_1
    //   868: invokevirtual 748	bhva:d	()Ljava/lang/String;
    //   871: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: ldc_w 750
    //   877: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload_1
    //   881: invokevirtual 752	bhva:c	()Ljava/lang/String;
    //   884: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   893: aload_1
    //   894: getfield 804	bhva:jdField_f_of_type_Int	I
    //   897: sipush -9527
    //   900: if_icmpne +47 -> 947
    //   903: aload_0
    //   904: aload_1
    //   905: ldc_w 806
    //   908: new 243	java/lang/StringBuilder
    //   911: dup
    //   912: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   915: ldc_w 771
    //   918: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: aload_1
    //   922: getfield 362	bhva:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   925: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: ldc_w 773
    //   931: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload_1
    //   935: getfield 541	bhva:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   938: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   947: aload_0
    //   948: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   951: ifnull +17 -> 968
    //   954: aload 25
    //   956: ifnull +12 -> 968
    //   959: aload_0
    //   960: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   963: aload 25
    //   965: invokevirtual 493	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   968: lload 12
    //   970: lconst_0
    //   971: ladd
    //   972: lstore 12
    //   974: lload 12
    //   976: lconst_0
    //   977: lcmp
    //   978: ifeq +27 -> 1005
    //   981: aload_1
    //   982: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   985: ldc 227
    //   987: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   990: ifeq +85 -> 1075
    //   993: iconst_1
    //   994: istore 10
    //   996: aload_0
    //   997: aload_1
    //   998: iload 10
    //   1000: lload 12
    //   1002: invokevirtual 755	bhuw:a	(Lbhva;ZJ)V
    //   1005: iconst_0
    //   1006: ifeq +11 -> 1017
    //   1009: new 757	java/lang/NullPointerException
    //   1012: dup
    //   1013: invokespecial 758	java/lang/NullPointerException:<init>	()V
    //   1016: athrow
    //   1017: iconst_0
    //   1018: ifeq +11 -> 1029
    //   1021: new 757	java/lang/NullPointerException
    //   1024: dup
    //   1025: invokespecial 758	java/lang/NullPointerException:<init>	()V
    //   1028: athrow
    //   1029: aload 24
    //   1031: ifnull +8 -> 1039
    //   1034: aload 24
    //   1036: invokevirtual 760	java/io/OutputStream:close	()V
    //   1039: aload 23
    //   1041: ifnull -488 -> 553
    //   1044: aload 23
    //   1046: invokevirtual 763	java/net/HttpURLConnection:disconnect	()V
    //   1049: return
    //   1050: astore_1
    //   1051: aload_1
    //   1052: invokevirtual 604	java/lang/Exception:printStackTrace	()V
    //   1055: return
    //   1056: new 317	java/net/URL
    //   1059: dup
    //   1060: aload_1
    //   1061: invokevirtual 120	bhva:a	()Ljava/lang/String;
    //   1064: invokespecial 320	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1067: invokevirtual 797	java/net/URL:getHost	()Ljava/lang/String;
    //   1070: astore 22
    //   1072: goto -322 -> 750
    //   1075: iconst_0
    //   1076: istore 10
    //   1078: goto -82 -> 996
    //   1081: astore 22
    //   1083: aload_0
    //   1084: aload_1
    //   1085: ldc_w 808
    //   1088: ldc_w 810
    //   1091: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1094: aload_1
    //   1095: invokevirtual 812	bhva:b	()Z
    //   1098: ifne +229 -> 1327
    //   1101: aload 30
    //   1103: aload 31
    //   1105: invokeinterface 813 2 0
    //   1110: iload 4
    //   1112: sipush 200
    //   1115: if_icmpeq +11 -> 1126
    //   1118: iload 4
    //   1120: sipush 206
    //   1123: if_icmpne +31 -> 1154
    //   1126: aload_0
    //   1127: aload_1
    //   1128: ldc_w 740
    //   1131: new 243	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   1138: ldc_w 742
    //   1141: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: iconst_0
    //   1145: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1148: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1154: aload_2
    //   1155: ifnull +13 -> 1168
    //   1158: aload_2
    //   1159: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1162: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1165: ifne +47 -> 1212
    //   1168: aload_0
    //   1169: aload_1
    //   1170: ldc_w 744
    //   1173: new 243	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 746
    //   1183: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: aload_1
    //   1187: invokevirtual 748	bhva:d	()Ljava/lang/String;
    //   1190: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: ldc_w 750
    //   1196: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: aload_1
    //   1200: invokevirtual 752	bhva:c	()Ljava/lang/String;
    //   1203: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1212: aload_0
    //   1213: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1216: ifnull +17 -> 1233
    //   1219: aload 25
    //   1221: ifnull +12 -> 1233
    //   1224: aload_0
    //   1225: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1228: aload 25
    //   1230: invokevirtual 493	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1233: lload 12
    //   1235: lconst_0
    //   1236: ladd
    //   1237: lstore 12
    //   1239: lload 12
    //   1241: lconst_0
    //   1242: lcmp
    //   1243: ifeq +27 -> 1270
    //   1246: aload_1
    //   1247: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   1250: ldc 227
    //   1252: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1255: ifeq +66 -> 1321
    //   1258: iconst_1
    //   1259: istore 10
    //   1261: aload_0
    //   1262: aload_1
    //   1263: iload 10
    //   1265: lload 12
    //   1267: invokevirtual 755	bhuw:a	(Lbhva;ZJ)V
    //   1270: iconst_0
    //   1271: ifeq +11 -> 1282
    //   1274: new 757	java/lang/NullPointerException
    //   1277: dup
    //   1278: invokespecial 758	java/lang/NullPointerException:<init>	()V
    //   1281: athrow
    //   1282: iconst_0
    //   1283: ifeq +11 -> 1294
    //   1286: new 757	java/lang/NullPointerException
    //   1289: dup
    //   1290: invokespecial 758	java/lang/NullPointerException:<init>	()V
    //   1293: athrow
    //   1294: aload 24
    //   1296: ifnull +8 -> 1304
    //   1299: aload 24
    //   1301: invokevirtual 760	java/io/OutputStream:close	()V
    //   1304: aload 23
    //   1306: ifnull -753 -> 553
    //   1309: aload 23
    //   1311: invokevirtual 763	java/net/HttpURLConnection:disconnect	()V
    //   1314: return
    //   1315: astore_1
    //   1316: aload_1
    //   1317: invokevirtual 604	java/lang/Exception:printStackTrace	()V
    //   1320: return
    //   1321: iconst_0
    //   1322: istore 10
    //   1324: goto -63 -> 1261
    //   1327: aload_1
    //   1328: getfield 814	bhva:jdField_b_of_type_Boolean	Z
    //   1331: ifeq +12 -> 1343
    //   1334: aload 30
    //   1336: aload 31
    //   1338: invokeinterface 813 2 0
    //   1343: aload_1
    //   1344: getfield 816	bhva:jdField_h_of_type_Boolean	Z
    //   1347: ifne +14 -> 1361
    //   1350: aload_1
    //   1351: ldc_w 818
    //   1354: aload_1
    //   1355: invokevirtual 120	bhva:a	()Ljava/lang/String;
    //   1358: invokevirtual 820	bhva:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1361: aload_1
    //   1362: aload 31
    //   1364: invokevirtual 821	bhva:a	(Ljava/lang/String;)V
    //   1367: aload_1
    //   1368: getfield 781	bhva:jdField_g_of_type_Boolean	Z
    //   1371: ifeq +56 -> 1427
    //   1374: aload 31
    //   1376: invokestatic 826	com/tencent/mobileqq/transfile/dns/InnerDns:getHostFromUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   1379: astore 22
    //   1381: aload 22
    //   1383: invokestatic 792	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1386: ifne +12 -> 1398
    //   1389: aload_1
    //   1390: ldc_w 408
    //   1393: aload 22
    //   1395: invokevirtual 820	bhva:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1398: aload_0
    //   1399: aload_1
    //   1400: ldc_w 769
    //   1403: new 243	java/lang/StringBuilder
    //   1406: dup
    //   1407: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   1410: ldc_w 828
    //   1413: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: aload 22
    //   1418: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1424: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1427: aload_1
    //   1428: ldc_w 830
    //   1431: invokevirtual 832	bhva:b	(Ljava/lang/String;)V
    //   1434: iload 5
    //   1436: iconst_1
    //   1437: iadd
    //   1438: istore 5
    //   1440: iload 4
    //   1442: istore_3
    //   1443: aload 24
    //   1445: astore 22
    //   1447: iconst_1
    //   1448: istore 10
    //   1450: aload 25
    //   1452: astore 24
    //   1454: goto -1397 -> 57
    //   1457: new 648	java/io/IOException
    //   1460: dup
    //   1461: ldc_w 834
    //   1464: invokespecial 651	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1467: athrow
    //   1468: astore 28
    //   1470: aload 25
    //   1472: astore 27
    //   1474: iconst_0
    //   1475: istore 5
    //   1477: iconst_1
    //   1478: istore 10
    //   1480: lconst_0
    //   1481: lstore 16
    //   1483: iload 4
    //   1485: istore_3
    //   1486: aload 23
    //   1488: astore 22
    //   1490: aconst_null
    //   1491: astore 23
    //   1493: aconst_null
    //   1494: astore 26
    //   1496: aload 24
    //   1498: astore 25
    //   1500: aload 23
    //   1502: astore 24
    //   1504: lload 12
    //   1506: lstore 14
    //   1508: lload 16
    //   1510: lstore 12
    //   1512: iload 5
    //   1514: istore 4
    //   1516: aload 27
    //   1518: astore 23
    //   1520: aload 28
    //   1522: astore 27
    //   1524: iconst_1
    //   1525: istore 5
    //   1527: aload 27
    //   1529: instanceof 648
    //   1532: istore 11
    //   1534: iload 11
    //   1536: ifeq +62 -> 1598
    //   1539: aload 22
    //   1541: ifnull +57 -> 1598
    //   1544: aconst_null
    //   1545: astore 29
    //   1547: aload 22
    //   1549: invokevirtual 838	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   1552: astore 28
    //   1554: aload 28
    //   1556: astore 29
    //   1558: sipush 10240
    //   1561: newarray byte
    //   1563: astore 31
    //   1565: aload 28
    //   1567: ifnull +21 -> 1588
    //   1570: aload 28
    //   1572: astore 29
    //   1574: aload 28
    //   1576: aload 31
    //   1578: invokevirtual 844	java/io/InputStream:read	([B)I
    //   1581: istore 6
    //   1583: iload 6
    //   1585: ifgt -15 -> 1570
    //   1588: aload 28
    //   1590: ifnull +8 -> 1598
    //   1593: aload 28
    //   1595: invokevirtual 845	java/io/InputStream:close	()V
    //   1598: aload_0
    //   1599: iload 10
    //   1601: iload_3
    //   1602: aload 22
    //   1604: aload_1
    //   1605: aload 27
    //   1607: invokevirtual 848	bhuw:a	(ZILjava/net/HttpURLConnection;Lbhva;Ljava/lang/Throwable;)V
    //   1610: iload 10
    //   1612: ifeq +46 -> 1658
    //   1615: iload_3
    //   1616: sipush 200
    //   1619: if_icmpeq +10 -> 1629
    //   1622: iload_3
    //   1623: sipush 206
    //   1626: if_icmpne +32 -> 1658
    //   1629: aload_0
    //   1630: aload_1
    //   1631: ldc_w 740
    //   1634: new 243	java/lang/StringBuilder
    //   1637: dup
    //   1638: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   1641: ldc_w 742
    //   1644: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1647: iload 4
    //   1649: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1652: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1655: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1658: aload_2
    //   1659: ifnull +13 -> 1672
    //   1662: aload_2
    //   1663: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1666: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1669: ifne +101 -> 1770
    //   1672: aload_0
    //   1673: aload_1
    //   1674: ldc_w 744
    //   1677: new 243	java/lang/StringBuilder
    //   1680: dup
    //   1681: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   1684: ldc_w 746
    //   1687: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: aload_1
    //   1691: invokevirtual 748	bhva:d	()Ljava/lang/String;
    //   1694: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: ldc_w 750
    //   1700: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: aload_1
    //   1704: invokevirtual 752	bhva:c	()Ljava/lang/String;
    //   1707: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1713: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1716: aload_1
    //   1717: getfield 804	bhva:jdField_f_of_type_Int	I
    //   1720: sipush -9527
    //   1723: if_icmpne +47 -> 1770
    //   1726: aload_0
    //   1727: aload_1
    //   1728: ldc_w 806
    //   1731: new 243	java/lang/StringBuilder
    //   1734: dup
    //   1735: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   1738: ldc_w 771
    //   1741: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: aload_1
    //   1745: getfield 362	bhva:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1748: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: ldc_w 773
    //   1754: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: aload_1
    //   1758: getfield 541	bhva:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1761: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1767: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1770: aload_0
    //   1771: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1774: ifnull +17 -> 1791
    //   1777: aload 23
    //   1779: ifnull +12 -> 1791
    //   1782: aload_0
    //   1783: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1786: aload 23
    //   1788: invokevirtual 493	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1791: lload 14
    //   1793: lload 12
    //   1795: ladd
    //   1796: lstore 12
    //   1798: lload 12
    //   1800: lconst_0
    //   1801: lcmp
    //   1802: ifeq +27 -> 1829
    //   1805: aload_1
    //   1806: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   1809: ldc 227
    //   1811: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1814: ifeq +2237 -> 4051
    //   1817: iconst_1
    //   1818: istore 10
    //   1820: aload_0
    //   1821: aload_1
    //   1822: iload 10
    //   1824: lload 12
    //   1826: invokevirtual 755	bhuw:a	(Lbhva;ZJ)V
    //   1829: aload 24
    //   1831: ifnull +8 -> 1839
    //   1834: aload 24
    //   1836: invokevirtual 851	java/io/ByteArrayOutputStream:close	()V
    //   1839: aload 26
    //   1841: ifnull +8 -> 1849
    //   1844: aload 26
    //   1846: invokevirtual 845	java/io/InputStream:close	()V
    //   1849: aload 25
    //   1851: ifnull +8 -> 1859
    //   1854: aload 25
    //   1856: invokevirtual 760	java/io/OutputStream:close	()V
    //   1859: iload 5
    //   1861: istore 4
    //   1863: aload 22
    //   1865: ifnull +12 -> 1877
    //   1868: aload 22
    //   1870: invokevirtual 763	java/net/HttpURLConnection:disconnect	()V
    //   1873: iload 5
    //   1875: istore 4
    //   1877: aload_2
    //   1878: ifnull +13 -> 1891
    //   1881: aload_2
    //   1882: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1885: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1888: ifne -1335 -> 553
    //   1891: aload_1
    //   1892: getfield 652	bhva:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1895: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1898: ifne -1345 -> 553
    //   1901: iload 4
    //   1903: ifeq +2182 -> 4085
    //   1906: aload 30
    //   1908: aload_1
    //   1909: aload_1
    //   1910: invokeinterface 459 3 0
    //   1915: return
    //   1916: astore_2
    //   1917: aload_0
    //   1918: aload_1
    //   1919: ldc_w 853
    //   1922: aload_2
    //   1923: invokestatic 859	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1926: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1929: return
    //   1930: new 113	java/lang/Exception
    //   1933: dup
    //   1934: ldc_w 861
    //   1937: invokespecial 862	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1940: athrow
    //   1941: astore 22
    //   1943: iconst_0
    //   1944: istore_3
    //   1945: iload 6
    //   1947: istore 5
    //   1949: iload 10
    //   1951: ifeq +48 -> 1999
    //   1954: iload 4
    //   1956: sipush 200
    //   1959: if_icmpeq +11 -> 1970
    //   1962: iload 4
    //   1964: sipush 206
    //   1967: if_icmpne +32 -> 1999
    //   1970: aload_0
    //   1971: aload_1
    //   1972: ldc_w 740
    //   1975: new 243	java/lang/StringBuilder
    //   1978: dup
    //   1979: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   1982: ldc_w 742
    //   1985: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1988: iload 5
    //   1990: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1993: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1996: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   1999: aload_2
    //   2000: ifnull +13 -> 2013
    //   2003: aload_2
    //   2004: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2007: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2010: ifne +105 -> 2115
    //   2013: aload_0
    //   2014: aload_1
    //   2015: ldc_w 744
    //   2018: new 243	java/lang/StringBuilder
    //   2021: dup
    //   2022: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   2025: ldc_w 746
    //   2028: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2031: aload_1
    //   2032: invokevirtual 748	bhva:d	()Ljava/lang/String;
    //   2035: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: ldc_w 750
    //   2041: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2044: aload_1
    //   2045: invokevirtual 752	bhva:c	()Ljava/lang/String;
    //   2048: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2054: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   2057: iload_3
    //   2058: ifeq +57 -> 2115
    //   2061: aload_1
    //   2062: getfield 804	bhva:jdField_f_of_type_Int	I
    //   2065: sipush -9527
    //   2068: if_icmpne +47 -> 2115
    //   2071: aload_0
    //   2072: aload_1
    //   2073: ldc_w 806
    //   2076: new 243	java/lang/StringBuilder
    //   2079: dup
    //   2080: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   2083: ldc_w 771
    //   2086: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: aload_1
    //   2090: getfield 362	bhva:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2093: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2096: ldc_w 773
    //   2099: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2102: aload_1
    //   2103: getfield 541	bhva:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2106: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2112: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   2115: aload_0
    //   2116: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2119: ifnull +17 -> 2136
    //   2122: aload 25
    //   2124: ifnull +12 -> 2136
    //   2127: aload_0
    //   2128: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2131: aload 25
    //   2133: invokevirtual 493	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2136: lload 12
    //   2138: lload 14
    //   2140: ladd
    //   2141: lstore 12
    //   2143: lload 12
    //   2145: lconst_0
    //   2146: lcmp
    //   2147: ifeq +27 -> 2174
    //   2150: aload_1
    //   2151: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   2154: ldc 227
    //   2156: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2159: ifeq +1912 -> 4071
    //   2162: iconst_1
    //   2163: istore 10
    //   2165: aload_0
    //   2166: aload_1
    //   2167: iload 10
    //   2169: lload 12
    //   2171: invokevirtual 755	bhuw:a	(Lbhva;ZJ)V
    //   2174: aload 27
    //   2176: ifnull +8 -> 2184
    //   2179: aload 27
    //   2181: invokevirtual 851	java/io/ByteArrayOutputStream:close	()V
    //   2184: aload 26
    //   2186: ifnull +8 -> 2194
    //   2189: aload 26
    //   2191: invokevirtual 845	java/io/InputStream:close	()V
    //   2194: aload 24
    //   2196: ifnull +8 -> 2204
    //   2199: aload 24
    //   2201: invokevirtual 760	java/io/OutputStream:close	()V
    //   2204: aload 23
    //   2206: ifnull +8 -> 2214
    //   2209: aload 23
    //   2211: invokevirtual 763	java/net/HttpURLConnection:disconnect	()V
    //   2214: aload 22
    //   2216: athrow
    //   2217: aload_0
    //   2218: aload_1
    //   2219: aconst_null
    //   2220: iconst_2
    //   2221: invokespecial 673	bhuw:a	(Lbhva;Lbhva;I)V
    //   2224: iload 4
    //   2226: sipush 200
    //   2229: if_icmpeq +11 -> 2240
    //   2232: iload 4
    //   2234: sipush 206
    //   2237: if_icmpne +1379 -> 3616
    //   2240: aload 23
    //   2242: invokevirtual 535	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2245: astore 22
    //   2247: aload 22
    //   2249: ifnonnull +135 -> 2384
    //   2252: ldc_w 487
    //   2255: astore 22
    //   2257: aload_1
    //   2258: getfield 865	bhva:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2261: ifnull +227 -> 2488
    //   2264: aload_1
    //   2265: getfield 865	bhva:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2268: arraylength
    //   2269: ifle +219 -> 2488
    //   2272: aload 22
    //   2274: invokevirtual 731	java/lang/String:length	()I
    //   2277: ifle +211 -> 2488
    //   2280: iconst_0
    //   2281: istore 7
    //   2283: aload_1
    //   2284: getfield 865	bhva:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2287: arraylength
    //   2288: iconst_1
    //   2289: if_icmpne +105 -> 2394
    //   2292: aload_1
    //   2293: getfield 865	bhva:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2296: iconst_0
    //   2297: aaload
    //   2298: ifnull +96 -> 2394
    //   2301: aload_1
    //   2302: getfield 865	bhva:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2305: iconst_0
    //   2306: aaload
    //   2307: invokevirtual 868	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2310: ldc_w 870
    //   2313: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2316: ifeq +78 -> 2394
    //   2319: iconst_1
    //   2320: istore_3
    //   2321: iload_3
    //   2322: ifne +166 -> 2488
    //   2325: new 243	java/lang/StringBuilder
    //   2328: dup
    //   2329: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   2332: astore 28
    //   2334: aload_1
    //   2335: getfield 865	bhva:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2338: astore 29
    //   2340: aload 29
    //   2342: arraylength
    //   2343: istore 5
    //   2345: iconst_0
    //   2346: istore_3
    //   2347: iload_3
    //   2348: iload 5
    //   2350: if_icmpge +95 -> 2445
    //   2353: aload 29
    //   2355: iload_3
    //   2356: aaload
    //   2357: astore 31
    //   2359: aload 31
    //   2361: ifnull +2608 -> 4969
    //   2364: aload 28
    //   2366: aload 31
    //   2368: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: pop
    //   2372: aload 28
    //   2374: ldc_w 872
    //   2377: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: pop
    //   2381: goto +2588 -> 4969
    //   2384: aload 22
    //   2386: invokevirtual 868	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2389: astore 22
    //   2391: goto -134 -> 2257
    //   2394: aload_1
    //   2395: getfield 865	bhva:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2398: astore 29
    //   2400: aload 29
    //   2402: arraylength
    //   2403: istore 8
    //   2405: iconst_0
    //   2406: istore 5
    //   2408: iload 7
    //   2410: istore_3
    //   2411: iload 5
    //   2413: iload 8
    //   2415: if_icmpge -94 -> 2321
    //   2418: aload 29
    //   2420: iload 5
    //   2422: aaload
    //   2423: astore 28
    //   2425: aload 28
    //   2427: ifnull +2549 -> 4976
    //   2430: aload 22
    //   2432: aload 28
    //   2434: invokevirtual 875	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2437: ifeq +2539 -> 4976
    //   2440: iconst_1
    //   2441: istore_3
    //   2442: goto -121 -> 2321
    //   2445: new 648	java/io/IOException
    //   2448: dup
    //   2449: new 243	java/lang/StringBuilder
    //   2452: dup
    //   2453: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   2456: ldc_w 877
    //   2459: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: aload 22
    //   2464: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2467: ldc_w 879
    //   2470: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2473: aload 28
    //   2475: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2478: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2484: invokespecial 651	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2487: athrow
    //   2488: aload_1
    //   2489: getfield 567	bhva:jdField_a_of_type_Long	J
    //   2492: lconst_0
    //   2493: lcmp
    //   2494: ifne +26 -> 2520
    //   2497: aload_1
    //   2498: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   2501: ldc 227
    //   2503: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2506: ifne +14 -> 2520
    //   2509: new 648	java/io/IOException
    //   2512: dup
    //   2513: ldc_w 881
    //   2516: invokespecial 651	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2519: athrow
    //   2520: aload_0
    //   2521: aload_1
    //   2522: ldc_w 883
    //   2525: new 243	java/lang/StringBuilder
    //   2528: dup
    //   2529: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   2532: ldc_w 885
    //   2535: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2538: aload_1
    //   2539: getfield 567	bhva:jdField_a_of_type_Long	J
    //   2542: invokevirtual 599	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2545: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2548: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   2551: aload_1
    //   2552: getfield 684	bhva:jdField_c_of_type_Long	J
    //   2555: lconst_0
    //   2556: lcmp
    //   2557: ifeq +15 -> 2572
    //   2560: aload_1
    //   2561: invokestatic 471	android/os/SystemClock:uptimeMillis	()J
    //   2564: aload_1
    //   2565: getfield 684	bhva:jdField_c_of_type_Long	J
    //   2568: lsub
    //   2569: putfield 887	bhva:jdField_d_of_type_Long	J
    //   2572: aload 30
    //   2574: aload_1
    //   2575: aload_1
    //   2576: iconst_3
    //   2577: invokeinterface 391 4 0
    //   2582: istore 11
    //   2584: iload 11
    //   2586: ifeq +2358 -> 4944
    //   2589: lconst_0
    //   2590: ldc2_w 732
    //   2593: ladd
    //   2594: lstore 14
    //   2596: aload 23
    //   2598: invokevirtual 890	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2601: astore 22
    //   2603: invokestatic 896	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2606: astore 28
    //   2608: invokestatic 899	com/tencent/commonsdk/pool/ByteArrayPool:getMaxBufInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2611: astore 26
    //   2613: aload_1
    //   2614: getfield 901	bhva:jdField_d_of_type_Boolean	Z
    //   2617: ifeq +243 -> 2860
    //   2620: aload_1
    //   2621: invokevirtual 903	bhva:a	()Z
    //   2624: ifne +236 -> 2860
    //   2627: new 905	bhoh
    //   2630: dup
    //   2631: aload 26
    //   2633: aload_1
    //   2634: getfield 567	bhva:jdField_a_of_type_Long	J
    //   2637: l2i
    //   2638: invokespecial 908	bhoh:<init>	(Lcom/tencent/commonsdk/pool/ByteArrayPool;I)V
    //   2641: astore 26
    //   2643: aload_1
    //   2644: getfield 901	bhva:jdField_d_of_type_Boolean	Z
    //   2647: ifeq +282 -> 2929
    //   2650: aload 28
    //   2652: sipush 10240
    //   2655: invokevirtual 912	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   2658: astore 27
    //   2660: iconst_0
    //   2661: istore 5
    //   2663: iconst_0
    //   2664: istore_3
    //   2665: iload_3
    //   2666: istore 7
    //   2668: lload 14
    //   2670: lstore 18
    //   2672: iload_3
    //   2673: istore 8
    //   2675: lload 14
    //   2677: lstore 20
    //   2679: aload 22
    //   2681: aload 27
    //   2683: iload 5
    //   2685: aload 27
    //   2687: arraylength
    //   2688: iload 5
    //   2690: isub
    //   2691: invokevirtual 915	java/io/InputStream:read	([BII)I
    //   2694: istore 6
    //   2696: iload 6
    //   2698: ifle +277 -> 2975
    //   2701: iload_3
    //   2702: istore 7
    //   2704: lload 14
    //   2706: lstore 18
    //   2708: iload_3
    //   2709: istore 8
    //   2711: lload 14
    //   2713: lstore 20
    //   2715: aload_0
    //   2716: aload_2
    //   2717: aload_1
    //   2718: invokevirtual 677	bhuw:a	(Lbhuy;Lbhva;)V
    //   2721: lload 14
    //   2723: iload 6
    //   2725: i2l
    //   2726: ladd
    //   2727: lstore 16
    //   2729: iload 5
    //   2731: iload 6
    //   2733: iadd
    //   2734: istore 9
    //   2736: iload_3
    //   2737: iload 6
    //   2739: iadd
    //   2740: istore 6
    //   2742: iload 6
    //   2744: istore_3
    //   2745: lload 16
    //   2747: lstore 14
    //   2749: iload 9
    //   2751: istore 5
    //   2753: iload 6
    //   2755: istore 7
    //   2757: lload 16
    //   2759: lstore 18
    //   2761: iload 6
    //   2763: istore 8
    //   2765: lload 16
    //   2767: lstore 20
    //   2769: iload 9
    //   2771: aload 27
    //   2773: arraylength
    //   2774: if_icmplt -109 -> 2665
    //   2777: iload 6
    //   2779: istore 7
    //   2781: lload 16
    //   2783: lstore 18
    //   2785: iload 6
    //   2787: istore 8
    //   2789: lload 16
    //   2791: lstore 20
    //   2793: aload_1
    //   2794: invokevirtual 903	bhva:a	()Z
    //   2797: ifeq +142 -> 2939
    //   2800: iload 6
    //   2802: istore 7
    //   2804: lload 16
    //   2806: lstore 18
    //   2808: iload 6
    //   2810: istore 8
    //   2812: lload 16
    //   2814: lstore 20
    //   2816: aload_1
    //   2817: aload 27
    //   2819: invokevirtual 918	bhva:a	([B)V
    //   2822: iload 6
    //   2824: istore 7
    //   2826: lload 16
    //   2828: lstore 18
    //   2830: iload 6
    //   2832: istore 8
    //   2834: lload 16
    //   2836: lstore 20
    //   2838: aload 30
    //   2840: aload_1
    //   2841: aload_1
    //   2842: invokeinterface 920 3 0
    //   2847: iconst_0
    //   2848: istore 5
    //   2850: iload 6
    //   2852: istore_3
    //   2853: lload 16
    //   2855: lstore 14
    //   2857: goto -192 -> 2665
    //   2860: new 850	java/io/ByteArrayOutputStream
    //   2863: dup
    //   2864: invokespecial 921	java/io/ByteArrayOutputStream:<init>	()V
    //   2867: astore 26
    //   2869: goto -226 -> 2643
    //   2872: astore 27
    //   2874: iconst_0
    //   2875: istore 5
    //   2877: iconst_1
    //   2878: istore 10
    //   2880: aload 22
    //   2882: astore 26
    //   2884: iload 4
    //   2886: istore_3
    //   2887: aconst_null
    //   2888: astore 29
    //   2890: aload 23
    //   2892: astore 22
    //   2894: lload 12
    //   2896: lstore 16
    //   2898: aload 24
    //   2900: astore 28
    //   2902: aload 25
    //   2904: astore 23
    //   2906: iload 5
    //   2908: istore 4
    //   2910: lload 14
    //   2912: lstore 12
    //   2914: lload 16
    //   2916: lstore 14
    //   2918: aload 29
    //   2920: astore 24
    //   2922: aload 28
    //   2924: astore 25
    //   2926: goto -1402 -> 1524
    //   2929: sipush 10240
    //   2932: newarray byte
    //   2934: astore 27
    //   2936: goto -276 -> 2660
    //   2939: iload 6
    //   2941: istore 7
    //   2943: lload 16
    //   2945: lstore 18
    //   2947: iload 6
    //   2949: istore 8
    //   2951: lload 16
    //   2953: lstore 20
    //   2955: aload 26
    //   2957: aload 27
    //   2959: invokevirtual 923	java/io/ByteArrayOutputStream:write	([B)V
    //   2962: iconst_0
    //   2963: istore 5
    //   2965: iload 6
    //   2967: istore_3
    //   2968: lload 16
    //   2970: lstore 14
    //   2972: goto -307 -> 2665
    //   2975: iload_3
    //   2976: istore 7
    //   2978: lload 14
    //   2980: lstore 18
    //   2982: iload_3
    //   2983: istore 8
    //   2985: lload 14
    //   2987: lstore 20
    //   2989: aload_1
    //   2990: invokevirtual 903	bhva:a	()Z
    //   2993: ifeq +475 -> 3468
    //   2996: iload 5
    //   2998: ifle +91 -> 3089
    //   3001: iload_3
    //   3002: istore 7
    //   3004: lload 14
    //   3006: lstore 18
    //   3008: iload_3
    //   3009: istore 8
    //   3011: lload 14
    //   3013: lstore 20
    //   3015: iload 5
    //   3017: newarray byte
    //   3019: astore 29
    //   3021: iload_3
    //   3022: istore 7
    //   3024: lload 14
    //   3026: lstore 18
    //   3028: iload_3
    //   3029: istore 8
    //   3031: lload 14
    //   3033: lstore 20
    //   3035: aload 27
    //   3037: iconst_0
    //   3038: aload 29
    //   3040: iconst_0
    //   3041: iload 5
    //   3043: invokestatic 927	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3046: iload_3
    //   3047: istore 7
    //   3049: lload 14
    //   3051: lstore 18
    //   3053: iload_3
    //   3054: istore 8
    //   3056: lload 14
    //   3058: lstore 20
    //   3060: aload_1
    //   3061: aload 29
    //   3063: invokevirtual 918	bhva:a	([B)V
    //   3066: iload_3
    //   3067: istore 7
    //   3069: lload 14
    //   3071: lstore 18
    //   3073: iload_3
    //   3074: istore 8
    //   3076: lload 14
    //   3078: lstore 20
    //   3080: aload 30
    //   3082: aload_1
    //   3083: aload_1
    //   3084: invokeinterface 920 3 0
    //   3089: iload_3
    //   3090: istore 7
    //   3092: lload 14
    //   3094: lstore 18
    //   3096: iload_3
    //   3097: istore 8
    //   3099: lload 14
    //   3101: lstore 20
    //   3103: aload_1
    //   3104: getfield 901	bhva:jdField_d_of_type_Boolean	Z
    //   3107: ifeq +24 -> 3131
    //   3110: iload_3
    //   3111: istore 7
    //   3113: lload 14
    //   3115: lstore 18
    //   3117: iload_3
    //   3118: istore 8
    //   3120: lload 14
    //   3122: lstore 20
    //   3124: aload 28
    //   3126: aload 27
    //   3128: invokevirtual 930	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   3131: iload_3
    //   3132: istore 7
    //   3134: lload 14
    //   3136: lstore 18
    //   3138: iload_3
    //   3139: istore 8
    //   3141: lload 14
    //   3143: lstore 20
    //   3145: aload 26
    //   3147: invokevirtual 851	java/io/ByteArrayOutputStream:close	()V
    //   3150: aload 26
    //   3152: astore 27
    //   3154: aload 22
    //   3156: astore 26
    //   3158: aload 27
    //   3160: astore 22
    //   3162: aload 30
    //   3164: aload_1
    //   3165: aload_1
    //   3166: iconst_4
    //   3167: invokeinterface 391 4 0
    //   3172: pop
    //   3173: iload_3
    //   3174: istore 5
    //   3176: iconst_0
    //   3177: istore_3
    //   3178: aload 22
    //   3180: astore 27
    //   3182: aload 26
    //   3184: astore 22
    //   3186: iload 4
    //   3188: sipush 200
    //   3191: if_icmpeq +11 -> 3202
    //   3194: iload 4
    //   3196: sipush 206
    //   3199: if_icmpne +32 -> 3231
    //   3202: aload_0
    //   3203: aload_1
    //   3204: ldc_w 740
    //   3207: new 243	java/lang/StringBuilder
    //   3210: dup
    //   3211: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   3214: ldc_w 742
    //   3217: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3220: iload 5
    //   3222: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3225: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3228: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   3231: aload_2
    //   3232: ifnull +13 -> 3245
    //   3235: aload_2
    //   3236: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3239: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3242: ifne +105 -> 3347
    //   3245: aload_0
    //   3246: aload_1
    //   3247: ldc_w 744
    //   3250: new 243	java/lang/StringBuilder
    //   3253: dup
    //   3254: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   3257: ldc_w 746
    //   3260: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3263: aload_1
    //   3264: invokevirtual 748	bhva:d	()Ljava/lang/String;
    //   3267: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3270: ldc_w 750
    //   3273: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3276: aload_1
    //   3277: invokevirtual 752	bhva:c	()Ljava/lang/String;
    //   3280: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3283: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3286: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   3289: iload_3
    //   3290: ifeq +57 -> 3347
    //   3293: aload_1
    //   3294: getfield 804	bhva:jdField_f_of_type_Int	I
    //   3297: sipush -9527
    //   3300: if_icmpne +47 -> 3347
    //   3303: aload_0
    //   3304: aload_1
    //   3305: ldc_w 806
    //   3308: new 243	java/lang/StringBuilder
    //   3311: dup
    //   3312: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   3315: ldc_w 771
    //   3318: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3321: aload_1
    //   3322: getfield 362	bhva:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3325: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3328: ldc_w 773
    //   3331: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3334: aload_1
    //   3335: getfield 541	bhva:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3338: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3344: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   3347: aload_0
    //   3348: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3351: ifnull +17 -> 3368
    //   3354: aload 25
    //   3356: ifnull +12 -> 3368
    //   3359: aload_0
    //   3360: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3363: aload 25
    //   3365: invokevirtual 493	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3368: lload 14
    //   3370: lload 12
    //   3372: ladd
    //   3373: lstore 12
    //   3375: lload 12
    //   3377: lconst_0
    //   3378: lcmp
    //   3379: ifeq +27 -> 3406
    //   3382: aload_1
    //   3383: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   3386: ldc 227
    //   3388: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3391: ifeq +562 -> 3953
    //   3394: iconst_1
    //   3395: istore 10
    //   3397: aload_0
    //   3398: aload_1
    //   3399: iload 10
    //   3401: lload 12
    //   3403: invokevirtual 755	bhuw:a	(Lbhva;ZJ)V
    //   3406: aload 27
    //   3408: ifnull +8 -> 3416
    //   3411: aload 27
    //   3413: invokevirtual 851	java/io/ByteArrayOutputStream:close	()V
    //   3416: aload 22
    //   3418: ifnull +8 -> 3426
    //   3421: aload 22
    //   3423: invokevirtual 845	java/io/InputStream:close	()V
    //   3426: aload 24
    //   3428: ifnull +8 -> 3436
    //   3431: aload 24
    //   3433: invokevirtual 760	java/io/OutputStream:close	()V
    //   3436: iload_3
    //   3437: istore 4
    //   3439: aload 23
    //   3441: ifnull -1564 -> 1877
    //   3444: aload 23
    //   3446: invokevirtual 763	java/net/HttpURLConnection:disconnect	()V
    //   3449: iload_3
    //   3450: istore 4
    //   3452: goto -1575 -> 1877
    //   3455: astore 22
    //   3457: aload 22
    //   3459: invokevirtual 604	java/lang/Exception:printStackTrace	()V
    //   3462: iload_3
    //   3463: istore 4
    //   3465: goto -1588 -> 1877
    //   3468: iload 5
    //   3470: ifle +27 -> 3497
    //   3473: iload_3
    //   3474: istore 7
    //   3476: lload 14
    //   3478: lstore 18
    //   3480: iload_3
    //   3481: istore 8
    //   3483: lload 14
    //   3485: lstore 20
    //   3487: aload 26
    //   3489: aload 27
    //   3491: iconst_0
    //   3492: iload 5
    //   3494: invokevirtual 931	java/io/ByteArrayOutputStream:write	([BII)V
    //   3497: iload_3
    //   3498: istore 7
    //   3500: lload 14
    //   3502: lstore 18
    //   3504: iload_3
    //   3505: istore 8
    //   3507: lload 14
    //   3509: lstore 20
    //   3511: aload 26
    //   3513: invokevirtual 932	java/io/ByteArrayOutputStream:flush	()V
    //   3516: iload_3
    //   3517: istore 7
    //   3519: lload 14
    //   3521: lstore 18
    //   3523: iload_3
    //   3524: istore 8
    //   3526: lload 14
    //   3528: lstore 20
    //   3530: aload_1
    //   3531: aload 26
    //   3533: invokevirtual 935	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3536: invokevirtual 918	bhva:a	([B)V
    //   3539: iload_3
    //   3540: istore 7
    //   3542: lload 14
    //   3544: lstore 18
    //   3546: iload_3
    //   3547: istore 8
    //   3549: lload 14
    //   3551: lstore 20
    //   3553: aload 30
    //   3555: aload_1
    //   3556: aload_1
    //   3557: invokeinterface 920 3 0
    //   3562: goto -473 -> 3089
    //   3565: astore 27
    //   3567: aload 22
    //   3569: astore 28
    //   3571: iload 4
    //   3573: istore_3
    //   3574: iconst_1
    //   3575: istore 10
    //   3577: aload 23
    //   3579: astore 22
    //   3581: aload 24
    //   3583: astore 29
    //   3585: lload 12
    //   3587: lstore 14
    //   3589: aload 26
    //   3591: astore 24
    //   3593: aload 25
    //   3595: astore 23
    //   3597: iload 7
    //   3599: istore 4
    //   3601: lload 18
    //   3603: lstore 12
    //   3605: aload 29
    //   3607: astore 25
    //   3609: aload 28
    //   3611: astore 26
    //   3613: goto -2089 -> 1524
    //   3616: aload_1
    //   3617: getfield 186	bhva:jdField_e_of_type_Boolean	Z
    //   3620: ifeq +302 -> 3922
    //   3623: aload_1
    //   3624: getfield 200	bhva:jdField_h_of_type_Int	I
    //   3627: ifeq +295 -> 3922
    //   3630: aload_1
    //   3631: getfield 198	bhva:jdField_f_of_type_Boolean	Z
    //   3634: ifne +288 -> 3922
    //   3637: aload_0
    //   3638: aload_1
    //   3639: ldc_w 937
    //   3642: ldc_w 939
    //   3645: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   3648: aload_1
    //   3649: iconst_1
    //   3650: putfield 198	bhva:jdField_f_of_type_Boolean	Z
    //   3653: aload_0
    //   3654: aload_1
    //   3655: aload_2
    //   3656: invokevirtual 669	bhuw:a	(Lbhva;Lbhuy;)V
    //   3659: new 127	java/util/HashMap
    //   3662: dup
    //   3663: invokespecial 610	java/util/HashMap:<init>	()V
    //   3666: astore 22
    //   3668: aload 22
    //   3670: ldc_w 612
    //   3673: aload_1
    //   3674: getfield 200	bhva:jdField_h_of_type_Int	I
    //   3677: invokestatic 614	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3680: invokevirtual 618	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3683: pop
    //   3684: invokestatic 153	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3687: invokestatic 625	bdmc:a	(Landroid/content/Context;)Lbdmc;
    //   3690: aconst_null
    //   3691: ldc_w 941
    //   3694: iconst_0
    //   3695: lconst_0
    //   3696: lconst_0
    //   3697: aload 22
    //   3699: ldc_w 487
    //   3702: invokevirtual 630	bdmc:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   3705: iload 4
    //   3707: sipush 200
    //   3710: if_icmpeq +11 -> 3721
    //   3713: iload 4
    //   3715: sipush 206
    //   3718: if_icmpne +31 -> 3749
    //   3721: aload_0
    //   3722: aload_1
    //   3723: ldc_w 740
    //   3726: new 243	java/lang/StringBuilder
    //   3729: dup
    //   3730: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   3733: ldc_w 742
    //   3736: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3739: iconst_0
    //   3740: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3743: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3746: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   3749: aload_2
    //   3750: ifnull +13 -> 3763
    //   3753: aload_2
    //   3754: getfield 633	bhuy:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3757: invokevirtual 438	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3760: ifne +47 -> 3807
    //   3763: aload_0
    //   3764: aload_1
    //   3765: ldc_w 744
    //   3768: new 243	java/lang/StringBuilder
    //   3771: dup
    //   3772: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   3775: ldc_w 746
    //   3778: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3781: aload_1
    //   3782: invokevirtual 748	bhva:d	()Ljava/lang/String;
    //   3785: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3788: ldc_w 750
    //   3791: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3794: aload_1
    //   3795: invokevirtual 752	bhva:c	()Ljava/lang/String;
    //   3798: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3801: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3804: invokevirtual 279	bhuw:a	(Lbhva;Ljava/lang/String;Ljava/lang/String;)V
    //   3807: aload_0
    //   3808: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3811: ifnull +17 -> 3828
    //   3814: aload 25
    //   3816: ifnull +12 -> 3828
    //   3819: aload_0
    //   3820: getfield 378	bhuw:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3823: aload 25
    //   3825: invokevirtual 493	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3828: lload 12
    //   3830: lconst_0
    //   3831: ladd
    //   3832: lstore 12
    //   3834: lload 12
    //   3836: lconst_0
    //   3837: lcmp
    //   3838: ifeq +27 -> 3865
    //   3841: aload_1
    //   3842: invokevirtual 229	bhva:e	()Ljava/lang/String;
    //   3845: ldc 227
    //   3847: invokevirtual 184	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3850: ifeq +66 -> 3916
    //   3853: iconst_1
    //   3854: istore 10
    //   3856: aload_0
    //   3857: aload_1
    //   3858: iload 10
    //   3860: lload 12
    //   3862: invokevirtual 755	bhuw:a	(Lbhva;ZJ)V
    //   3865: iconst_0
    //   3866: ifeq +11 -> 3877
    //   3869: new 757	java/lang/NullPointerException
    //   3872: dup
    //   3873: invokespecial 758	java/lang/NullPointerException:<init>	()V
    //   3876: athrow
    //   3877: iconst_0
    //   3878: ifeq +11 -> 3889
    //   3881: new 757	java/lang/NullPointerException
    //   3884: dup
    //   3885: invokespecial 758	java/lang/NullPointerException:<init>	()V
    //   3888: athrow
    //   3889: aload 24
    //   3891: ifnull +8 -> 3899
    //   3894: aload 24
    //   3896: invokevirtual 760	java/io/OutputStream:close	()V
    //   3899: aload 23
    //   3901: ifnull -3348 -> 553
    //   3904: aload 23
    //   3906: invokevirtual 763	java/net/HttpURLConnection:disconnect	()V
    //   3909: return
    //   3910: astore_1
    //   3911: aload_1
    //   3912: invokevirtual 604	java/lang/Exception:printStackTrace	()V
    //   3915: return
    //   3916: iconst_0
    //   3917: istore 10
    //   3919: goto -63 -> 3856
    //   3922: iconst_1
    //   3923: istore_3
    //   3924: aload_0
    //   3925: iload 4
    //   3927: aload 23
    //   3929: aload_1
    //   3930: invokevirtual 943	bhuw:b	(ILjava/net/HttpURLConnection;Lbhva;)V
    //   3933: lconst_0
    //   3934: lstore 14
    //   3936: iconst_1
    //   3937: istore_3
    //   3938: iload 7
    //   3940: istore 5
    //   3942: aload 29
    //   3944: astore 27
    //   3946: aload 28
    //   3948: astore 22
    //   3950: goto -764 -> 3186
    //   3953: iconst_0
    //   3954: istore 10
    //   3956: goto -559 -> 3397
    //   3959: astore 28
    //   3961: aload 29
    //   3963: ifnull -2365 -> 1598
    //   3966: aload 29
    //   3968: invokevirtual 845	java/io/InputStream:close	()V
    //   3971: goto -2373 -> 1598
    //   3974: astore 28
    //   3976: goto -2378 -> 1598
    //   3979: astore 27
    //   3981: aconst_null
    //   3982: astore 28
    //   3984: aload 28
    //   3986: ifnull +8 -> 3994
    //   3989: aload 28
    //   3991: invokevirtual 845	java/io/InputStream:close	()V
    //   3994: aload 27
    //   3996: athrow
    //   3997: astore 29
    //   3999: lload 14
    //   4001: lstore 16
    //   4003: aload 24
    //   4005: astore 27
    //   4007: aload 25
    //   4009: astore 24
    //   4011: aload 22
    //   4013: astore 28
    //   4015: iload_3
    //   4016: istore 6
    //   4018: iconst_1
    //   4019: istore_3
    //   4020: aload 29
    //   4022: astore 22
    //   4024: aload 23
    //   4026: astore 25
    //   4028: iload 4
    //   4030: istore 5
    //   4032: iload 6
    //   4034: istore 4
    //   4036: lload 12
    //   4038: lstore 14
    //   4040: lload 16
    //   4042: lstore 12
    //   4044: aload 28
    //   4046: astore 23
    //   4048: goto -2099 -> 1949
    //   4051: iconst_0
    //   4052: istore 10
    //   4054: goto -2234 -> 1820
    //   4057: astore 22
    //   4059: aload 22
    //   4061: invokevirtual 604	java/lang/Exception:printStackTrace	()V
    //   4064: iload 5
    //   4066: istore 4
    //   4068: goto -2191 -> 1877
    //   4071: iconst_0
    //   4072: istore 10
    //   4074: goto -1909 -> 2165
    //   4077: astore_1
    //   4078: aload_1
    //   4079: invokevirtual 604	java/lang/Exception:printStackTrace	()V
    //   4082: goto -1868 -> 2214
    //   4085: aload 30
    //   4087: aload_1
    //   4088: aload_1
    //   4089: iconst_5
    //   4090: invokeinterface 391 4 0
    //   4095: pop
    //   4096: return
    //   4097: astore_1
    //   4098: goto -3577 -> 521
    //   4101: astore_1
    //   4102: goto -3569 -> 533
    //   4105: astore_1
    //   4106: goto -3563 -> 543
    //   4109: astore_1
    //   4110: goto -3093 -> 1017
    //   4113: astore_1
    //   4114: goto -3085 -> 1029
    //   4117: astore_1
    //   4118: goto -3079 -> 1039
    //   4121: astore_1
    //   4122: goto -2840 -> 1282
    //   4125: astore_1
    //   4126: goto -2832 -> 1294
    //   4129: astore_1
    //   4130: goto -2826 -> 1304
    //   4133: astore_1
    //   4134: goto -257 -> 3877
    //   4137: astore_1
    //   4138: goto -249 -> 3889
    //   4141: astore_1
    //   4142: goto -243 -> 3899
    //   4145: astore 25
    //   4147: goto -731 -> 3416
    //   4150: astore 22
    //   4152: goto -726 -> 3426
    //   4155: astore 22
    //   4157: goto -721 -> 3436
    //   4160: astore 28
    //   4162: goto -2564 -> 1598
    //   4165: astore 28
    //   4167: goto -173 -> 3994
    //   4170: astore 23
    //   4172: goto -2333 -> 1839
    //   4175: astore 23
    //   4177: goto -2328 -> 1849
    //   4180: astore 23
    //   4182: goto -2323 -> 1859
    //   4185: astore_1
    //   4186: goto -2002 -> 2184
    //   4189: astore_1
    //   4190: goto -1996 -> 2194
    //   4193: astore_1
    //   4194: goto -1990 -> 2204
    //   4197: astore 22
    //   4199: aconst_null
    //   4200: astore 25
    //   4202: iconst_0
    //   4203: istore 10
    //   4205: lconst_0
    //   4206: lstore 12
    //   4208: iconst_m1
    //   4209: istore 4
    //   4211: aconst_null
    //   4212: astore 24
    //   4214: aconst_null
    //   4215: astore 23
    //   4217: iconst_0
    //   4218: istore_3
    //   4219: iload 6
    //   4221: istore 5
    //   4223: goto -2274 -> 1949
    //   4226: astore 22
    //   4228: iload_3
    //   4229: istore 4
    //   4231: iconst_0
    //   4232: istore_3
    //   4233: iload 6
    //   4235: istore 5
    //   4237: goto -2288 -> 1949
    //   4240: astore 22
    //   4242: iload_3
    //   4243: istore 4
    //   4245: iconst_0
    //   4246: istore_3
    //   4247: iload 6
    //   4249: istore 5
    //   4251: goto -2302 -> 1949
    //   4254: astore 28
    //   4256: aload 24
    //   4258: astore 25
    //   4260: iload_3
    //   4261: istore 4
    //   4263: aload 22
    //   4265: astore 24
    //   4267: aload 28
    //   4269: astore 22
    //   4271: iconst_0
    //   4272: istore_3
    //   4273: iload 6
    //   4275: istore 5
    //   4277: goto -2328 -> 1949
    //   4280: astore 28
    //   4282: aload 24
    //   4284: astore 25
    //   4286: iload_3
    //   4287: istore 4
    //   4289: aload 22
    //   4291: astore 24
    //   4293: iconst_0
    //   4294: istore_3
    //   4295: aload 28
    //   4297: astore 22
    //   4299: iload 6
    //   4301: istore 5
    //   4303: goto -2354 -> 1949
    //   4306: astore 28
    //   4308: aload 24
    //   4310: astore 25
    //   4312: iload_3
    //   4313: istore 4
    //   4315: aload 22
    //   4317: astore 24
    //   4319: iconst_0
    //   4320: istore_3
    //   4321: aload 28
    //   4323: astore 22
    //   4325: iload 6
    //   4327: istore 5
    //   4329: goto -2380 -> 1949
    //   4332: astore 28
    //   4334: iload_3
    //   4335: istore 4
    //   4337: aload 22
    //   4339: astore 24
    //   4341: aload 28
    //   4343: astore 22
    //   4345: iconst_0
    //   4346: istore_3
    //   4347: iload 6
    //   4349: istore 5
    //   4351: goto -2402 -> 1949
    //   4354: astore 22
    //   4356: iconst_0
    //   4357: istore_3
    //   4358: iload 6
    //   4360: istore 5
    //   4362: goto -2413 -> 1949
    //   4365: astore 28
    //   4367: iconst_0
    //   4368: istore_3
    //   4369: aload 22
    //   4371: astore 26
    //   4373: aload 28
    //   4375: astore 22
    //   4377: iload 6
    //   4379: istore 5
    //   4381: goto -2432 -> 1949
    //   4384: astore 28
    //   4386: iconst_0
    //   4387: istore_3
    //   4388: aload 26
    //   4390: astore 27
    //   4392: aload 22
    //   4394: astore 26
    //   4396: aload 28
    //   4398: astore 22
    //   4400: iload 6
    //   4402: istore 5
    //   4404: goto -2455 -> 1949
    //   4407: astore 28
    //   4409: iload 8
    //   4411: istore 5
    //   4413: lload 20
    //   4415: lstore 14
    //   4417: aload 26
    //   4419: astore 27
    //   4421: aload 22
    //   4423: astore 26
    //   4425: iconst_0
    //   4426: istore_3
    //   4427: aload 28
    //   4429: astore 22
    //   4431: goto -2482 -> 1949
    //   4434: astore 28
    //   4436: iload_3
    //   4437: istore 5
    //   4439: aload 22
    //   4441: astore 27
    //   4443: aload 28
    //   4445: astore 22
    //   4447: iconst_0
    //   4448: istore_3
    //   4449: goto -2500 -> 1949
    //   4452: astore 22
    //   4454: iload 6
    //   4456: istore 5
    //   4458: goto -2509 -> 1949
    //   4461: astore 27
    //   4463: goto -479 -> 3984
    //   4466: astore 27
    //   4468: lconst_0
    //   4469: lstore 12
    //   4471: aconst_null
    //   4472: astore 24
    //   4474: aconst_null
    //   4475: astore 25
    //   4477: aconst_null
    //   4478: astore 23
    //   4480: aconst_null
    //   4481: astore 26
    //   4483: lconst_0
    //   4484: lstore 14
    //   4486: iconst_m1
    //   4487: istore_3
    //   4488: aconst_null
    //   4489: astore 22
    //   4491: iconst_0
    //   4492: istore 4
    //   4494: goto -2970 -> 1524
    //   4497: astore 27
    //   4499: aload 25
    //   4501: astore 26
    //   4503: iconst_0
    //   4504: istore 4
    //   4506: lconst_0
    //   4507: lstore 16
    //   4509: aload 24
    //   4511: astore 25
    //   4513: lload 12
    //   4515: lstore 14
    //   4517: iconst_1
    //   4518: istore 10
    //   4520: aconst_null
    //   4521: astore 28
    //   4523: aconst_null
    //   4524: astore 24
    //   4526: aload 23
    //   4528: astore 22
    //   4530: aload 26
    //   4532: astore 23
    //   4534: lload 16
    //   4536: lstore 12
    //   4538: aload 28
    //   4540: astore 26
    //   4542: goto -3018 -> 1524
    //   4545: astore 27
    //   4547: aload 25
    //   4549: astore 26
    //   4551: iconst_0
    //   4552: istore 4
    //   4554: iconst_1
    //   4555: istore 10
    //   4557: lconst_0
    //   4558: lstore 16
    //   4560: aload 24
    //   4562: astore 25
    //   4564: aload 23
    //   4566: astore 22
    //   4568: lload 12
    //   4570: lstore 14
    //   4572: aconst_null
    //   4573: astore 28
    //   4575: aconst_null
    //   4576: astore 24
    //   4578: aload 26
    //   4580: astore 23
    //   4582: lload 16
    //   4584: lstore 12
    //   4586: aload 28
    //   4588: astore 26
    //   4590: goto -3066 -> 1524
    //   4593: astore 27
    //   4595: lconst_0
    //   4596: lstore 16
    //   4598: aconst_null
    //   4599: astore 28
    //   4601: aload 22
    //   4603: astore 25
    //   4605: aconst_null
    //   4606: astore 26
    //   4608: lload 12
    //   4610: lstore 14
    //   4612: aload 23
    //   4614: astore 22
    //   4616: iconst_0
    //   4617: istore 4
    //   4619: aload 24
    //   4621: astore 23
    //   4623: lload 16
    //   4625: lstore 12
    //   4627: aload 28
    //   4629: astore 24
    //   4631: goto -3107 -> 1524
    //   4634: astore 27
    //   4636: iconst_0
    //   4637: istore 4
    //   4639: lconst_0
    //   4640: lstore 16
    //   4642: aconst_null
    //   4643: astore 26
    //   4645: aload 22
    //   4647: astore 25
    //   4649: lload 12
    //   4651: lstore 14
    //   4653: aconst_null
    //   4654: astore 28
    //   4656: aload 23
    //   4658: astore 22
    //   4660: aload 24
    //   4662: astore 23
    //   4664: lload 16
    //   4666: lstore 12
    //   4668: aload 26
    //   4670: astore 24
    //   4672: aload 28
    //   4674: astore 26
    //   4676: goto -3152 -> 1524
    //   4679: astore 27
    //   4681: iconst_0
    //   4682: istore 4
    //   4684: lconst_0
    //   4685: lstore 16
    //   4687: aload 22
    //   4689: astore 25
    //   4691: lload 12
    //   4693: lstore 14
    //   4695: aconst_null
    //   4696: astore 26
    //   4698: iconst_1
    //   4699: istore 10
    //   4701: aload 23
    //   4703: astore 22
    //   4705: aconst_null
    //   4706: astore 28
    //   4708: aload 24
    //   4710: astore 23
    //   4712: lload 16
    //   4714: lstore 12
    //   4716: aload 28
    //   4718: astore 24
    //   4720: goto -3196 -> 1524
    //   4723: astore 27
    //   4725: iconst_0
    //   4726: istore 4
    //   4728: iconst_1
    //   4729: istore 10
    //   4731: lconst_0
    //   4732: lstore 16
    //   4734: aload 22
    //   4736: astore 26
    //   4738: lload 12
    //   4740: lstore 14
    //   4742: aconst_null
    //   4743: astore 24
    //   4745: aconst_null
    //   4746: astore 28
    //   4748: aload 23
    //   4750: astore 22
    //   4752: aload 25
    //   4754: astore 23
    //   4756: lload 16
    //   4758: lstore 12
    //   4760: aload 26
    //   4762: astore 25
    //   4764: aload 28
    //   4766: astore 26
    //   4768: goto -3244 -> 1524
    //   4771: astore 27
    //   4773: aload 25
    //   4775: astore 26
    //   4777: iconst_0
    //   4778: istore 5
    //   4780: iconst_1
    //   4781: istore 10
    //   4783: aconst_null
    //   4784: astore 28
    //   4786: iload 4
    //   4788: istore_3
    //   4789: aconst_null
    //   4790: astore 29
    //   4792: lload 12
    //   4794: lstore 16
    //   4796: aload 23
    //   4798: astore 22
    //   4800: aload 24
    //   4802: astore 25
    //   4804: aload 26
    //   4806: astore 23
    //   4808: iload 5
    //   4810: istore 4
    //   4812: lload 14
    //   4814: lstore 12
    //   4816: lload 16
    //   4818: lstore 14
    //   4820: aload 29
    //   4822: astore 24
    //   4824: aload 28
    //   4826: astore 26
    //   4828: goto -3304 -> 1524
    //   4831: astore 27
    //   4833: iconst_0
    //   4834: istore 5
    //   4836: iconst_1
    //   4837: istore 10
    //   4839: lload 14
    //   4841: lstore 16
    //   4843: aload 22
    //   4845: astore 28
    //   4847: iload 4
    //   4849: istore_3
    //   4850: aload 25
    //   4852: astore 29
    //   4854: aload 23
    //   4856: astore 22
    //   4858: lload 12
    //   4860: lstore 14
    //   4862: aload 24
    //   4864: astore 25
    //   4866: aload 29
    //   4868: astore 23
    //   4870: iload 5
    //   4872: istore 4
    //   4874: lload 16
    //   4876: lstore 12
    //   4878: aload 26
    //   4880: astore 24
    //   4882: aload 28
    //   4884: astore 26
    //   4886: goto -3362 -> 1524
    //   4889: astore 27
    //   4891: iload_3
    //   4892: istore 5
    //   4894: lload 12
    //   4896: lstore 16
    //   4898: iload 4
    //   4900: istore_3
    //   4901: aload 24
    //   4903: astore 28
    //   4905: aload 22
    //   4907: astore 24
    //   4909: iconst_1
    //   4910: istore 10
    //   4912: aload 23
    //   4914: astore 22
    //   4916: aload 25
    //   4918: astore 23
    //   4920: iload 5
    //   4922: istore 4
    //   4924: lload 14
    //   4926: lstore 12
    //   4928: lload 16
    //   4930: lstore 14
    //   4932: aload 28
    //   4934: astore 25
    //   4936: goto -3412 -> 1524
    //   4939: astore 22
    //   4941: goto -4229 -> 712
    //   4944: iconst_0
    //   4945: istore_3
    //   4946: lconst_0
    //   4947: lstore 14
    //   4949: aconst_null
    //   4950: astore 22
    //   4952: aconst_null
    //   4953: astore 26
    //   4955: goto -1793 -> 3162
    //   4958: aload 24
    //   4960: astore 25
    //   4962: aload 22
    //   4964: astore 24
    //   4966: goto -4657 -> 309
    //   4969: iload_3
    //   4970: iconst_1
    //   4971: iadd
    //   4972: istore_3
    //   4973: goto -2626 -> 2347
    //   4976: iload 5
    //   4978: iconst_1
    //   4979: iadd
    //   4980: istore 5
    //   4982: goto -2574 -> 2408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4985	0	this	bhuw
    //   0	4985	1	parambhva	bhva
    //   0	4985	2	parambhuy	bhuy
    //   25	4948	3	i	int
    //   197	4726	4	j	int
    //   49	4932	5	k	int
    //   39	4416	6	m	int
    //   36	3903	7	n	int
    //   2403	2007	8	i1	int
    //   2734	41	9	i2	int
    //   33	4878	10	bool1	boolean
    //   342	2243	11	bool2	boolean
    //   27	4900	12	l1	long
    //   30	4918	14	l2	long
    //   287	4642	16	l3	long
    //   2670	932	18	l4	long
    //   2677	1737	20	l5	long
    //   16	1055	22	str	String
    //   1081	1	22	localException1	Exception
    //   1379	490	22	localObject1	Object
    //   1941	274	22	localObject2	Object
    //   2245	1177	22	localObject3	Object
    //   3455	113	22	localException2	Exception
    //   3579	444	22	localObject4	Object
    //   4057	3	22	localException3	Exception
    //   4150	1	22	localIOException1	IOException
    //   4155	1	22	localIOException2	IOException
    //   4197	1	22	localObject5	Object
    //   4226	1	22	localObject6	Object
    //   4240	24	22	localObject7	Object
    //   4269	75	22	localObject8	Object
    //   4354	16	22	localObject9	Object
    //   4375	71	22	localObject10	Object
    //   4452	1	22	localObject11	Object
    //   4489	426	22	localObject12	Object
    //   4939	1	22	localThrowable1	Throwable
    //   4950	13	22	localObject13	Object
    //   7	4040	23	localObject14	Object
    //   4170	1	23	localIOException3	IOException
    //   4175	1	23	localIOException4	IOException
    //   4180	1	23	localIOException5	IOException
    //   4215	704	23	localObject15	Object
    //   55	4910	24	localObject16	Object
    //   79	3948	25	localObject17	Object
    //   4145	1	25	localIOException6	IOException
    //   4200	761	25	localObject18	Object
    //   13	4941	26	localObject19	Object
    //   22	2796	27	localObject20	Object
    //   2872	1	27	localThrowable2	Throwable
    //   2934	556	27	localObject21	Object
    //   3565	1	27	localThrowable3	Throwable
    //   3944	1	27	localObject22	Object
    //   3979	16	27	localObject23	Object
    //   4005	437	27	localObject24	Object
    //   4461	1	27	localObject25	Object
    //   4466	1	27	localThrowable4	Throwable
    //   4497	1	27	localThrowable5	Throwable
    //   4545	1	27	localThrowable6	Throwable
    //   4593	1	27	localThrowable7	Throwable
    //   4634	1	27	localThrowable8	Throwable
    //   4679	1	27	localThrowable9	Throwable
    //   4723	1	27	localThrowable10	Throwable
    //   4771	1	27	localThrowable11	Throwable
    //   4831	1	27	localThrowable12	Throwable
    //   4889	1	27	localThrowable13	Throwable
    //   10	1	28	localObject26	Object
    //   1468	53	28	localThrowable14	Throwable
    //   1552	2395	28	localObject27	Object
    //   3959	1	28	localException4	Exception
    //   3974	1	28	localIOException7	IOException
    //   3982	63	28	localObject28	Object
    //   4160	1	28	localIOException8	IOException
    //   4165	1	28	localIOException9	IOException
    //   4254	14	28	localObject29	Object
    //   4280	16	28	localObject30	Object
    //   4306	16	28	localObject31	Object
    //   4332	10	28	localObject32	Object
    //   4365	9	28	localObject33	Object
    //   4384	13	28	localObject34	Object
    //   4407	21	28	localObject35	Object
    //   4434	10	28	localObject36	Object
    //   4521	412	28	localObject37	Object
    //   19	3948	29	localObject38	Object
    //   3997	24	29	localObject39	Object
    //   4790	77	29	localObject40	Object
    //   4	4082	30	localbhvc	bhvc
    //   157	2210	31	localObject41	Object
    // Exception table:
    //   from	to	target	type
    //   451	458	560	java/lang/Exception
    //   463	472	560	java/lang/Exception
    //   485	497	560	java/lang/Exception
    //   500	509	560	java/lang/Exception
    //   513	521	560	java/lang/Exception
    //   525	533	560	java/lang/Exception
    //   538	543	560	java/lang/Exception
    //   548	553	560	java/lang/Exception
    //   947	954	1050	java/lang/Exception
    //   959	968	1050	java/lang/Exception
    //   981	993	1050	java/lang/Exception
    //   996	1005	1050	java/lang/Exception
    //   1009	1017	1050	java/lang/Exception
    //   1021	1029	1050	java/lang/Exception
    //   1034	1039	1050	java/lang/Exception
    //   1044	1049	1050	java/lang/Exception
    //   728	750	1081	java/lang/Exception
    //   750	786	1081	java/lang/Exception
    //   1056	1072	1081	java/lang/Exception
    //   1212	1219	1315	java/lang/Exception
    //   1224	1233	1315	java/lang/Exception
    //   1246	1258	1315	java/lang/Exception
    //   1261	1270	1315	java/lang/Exception
    //   1274	1282	1315	java/lang/Exception
    //   1286	1294	1315	java/lang/Exception
    //   1299	1304	1315	java/lang/Exception
    //   1309	1314	1315	java/lang/Exception
    //   322	331	1468	java/lang/Throwable
    //   335	344	1468	java/lang/Throwable
    //   566	573	1468	java/lang/Throwable
    //   578	587	1468	java/lang/Throwable
    //   587	616	1468	java/lang/Throwable
    //   638	692	1468	java/lang/Throwable
    //   717	723	1468	java/lang/Throwable
    //   728	750	1468	java/lang/Throwable
    //   750	786	1468	java/lang/Throwable
    //   1056	1072	1468	java/lang/Throwable
    //   1083	1094	1468	java/lang/Throwable
    //   1094	1110	1468	java/lang/Throwable
    //   1327	1343	1468	java/lang/Throwable
    //   1343	1361	1468	java/lang/Throwable
    //   1361	1398	1468	java/lang/Throwable
    //   1398	1427	1468	java/lang/Throwable
    //   1427	1434	1468	java/lang/Throwable
    //   1457	1468	1468	java/lang/Throwable
    //   1930	1941	1468	java/lang/Throwable
    //   2217	2224	1468	java/lang/Throwable
    //   2240	2247	1468	java/lang/Throwable
    //   2257	2280	1468	java/lang/Throwable
    //   2283	2319	1468	java/lang/Throwable
    //   2325	2345	1468	java/lang/Throwable
    //   2364	2381	1468	java/lang/Throwable
    //   2384	2391	1468	java/lang/Throwable
    //   2394	2405	1468	java/lang/Throwable
    //   2430	2440	1468	java/lang/Throwable
    //   2445	2488	1468	java/lang/Throwable
    //   2488	2520	1468	java/lang/Throwable
    //   2520	2572	1468	java/lang/Throwable
    //   2572	2584	1468	java/lang/Throwable
    //   3616	3705	1468	java/lang/Throwable
    //   3924	3933	1468	java/lang/Throwable
    //   1906	1915	1916	java/lang/Exception
    //   4085	4096	1916	java/lang/Exception
    //   322	331	1941	finally
    //   335	344	1941	finally
    //   566	573	1941	finally
    //   578	587	1941	finally
    //   587	616	1941	finally
    //   638	692	1941	finally
    //   702	707	1941	finally
    //   707	712	1941	finally
    //   717	723	1941	finally
    //   728	750	1941	finally
    //   750	786	1941	finally
    //   1056	1072	1941	finally
    //   1083	1094	1941	finally
    //   1094	1110	1941	finally
    //   1327	1343	1941	finally
    //   1343	1361	1941	finally
    //   1361	1398	1941	finally
    //   1398	1427	1941	finally
    //   1427	1434	1941	finally
    //   1457	1468	1941	finally
    //   1930	1941	1941	finally
    //   2217	2224	1941	finally
    //   2240	2247	1941	finally
    //   2257	2280	1941	finally
    //   2283	2319	1941	finally
    //   2325	2345	1941	finally
    //   2364	2381	1941	finally
    //   2384	2391	1941	finally
    //   2394	2405	1941	finally
    //   2430	2440	1941	finally
    //   2445	2488	1941	finally
    //   2488	2520	1941	finally
    //   2520	2572	1941	finally
    //   2572	2584	1941	finally
    //   3616	3705	1941	finally
    //   2603	2643	2872	java/lang/Throwable
    //   2860	2869	2872	java/lang/Throwable
    //   3347	3354	3455	java/lang/Exception
    //   3359	3368	3455	java/lang/Exception
    //   3382	3394	3455	java/lang/Exception
    //   3397	3406	3455	java/lang/Exception
    //   3411	3416	3455	java/lang/Exception
    //   3421	3426	3455	java/lang/Exception
    //   3431	3436	3455	java/lang/Exception
    //   3444	3449	3455	java/lang/Exception
    //   2679	2696	3565	java/lang/Throwable
    //   2715	2721	3565	java/lang/Throwable
    //   2769	2777	3565	java/lang/Throwable
    //   2793	2800	3565	java/lang/Throwable
    //   2816	2822	3565	java/lang/Throwable
    //   2838	2847	3565	java/lang/Throwable
    //   2955	2962	3565	java/lang/Throwable
    //   2989	2996	3565	java/lang/Throwable
    //   3015	3021	3565	java/lang/Throwable
    //   3035	3046	3565	java/lang/Throwable
    //   3060	3066	3565	java/lang/Throwable
    //   3080	3089	3565	java/lang/Throwable
    //   3103	3110	3565	java/lang/Throwable
    //   3124	3131	3565	java/lang/Throwable
    //   3145	3150	3565	java/lang/Throwable
    //   3487	3497	3565	java/lang/Throwable
    //   3511	3516	3565	java/lang/Throwable
    //   3530	3539	3565	java/lang/Throwable
    //   3553	3562	3565	java/lang/Throwable
    //   3807	3814	3910	java/lang/Exception
    //   3819	3828	3910	java/lang/Exception
    //   3841	3853	3910	java/lang/Exception
    //   3856	3865	3910	java/lang/Exception
    //   3869	3877	3910	java/lang/Exception
    //   3881	3889	3910	java/lang/Exception
    //   3894	3899	3910	java/lang/Exception
    //   3904	3909	3910	java/lang/Exception
    //   1547	1554	3959	java/lang/Exception
    //   1558	1565	3959	java/lang/Exception
    //   1574	1583	3959	java/lang/Exception
    //   3966	3971	3974	java/io/IOException
    //   1547	1554	3979	finally
    //   1527	1534	3997	finally
    //   1593	1598	3997	finally
    //   1598	1610	3997	finally
    //   3966	3971	3997	finally
    //   3989	3994	3997	finally
    //   3994	3997	3997	finally
    //   1770	1777	4057	java/lang/Exception
    //   1782	1791	4057	java/lang/Exception
    //   1805	1817	4057	java/lang/Exception
    //   1820	1829	4057	java/lang/Exception
    //   1834	1839	4057	java/lang/Exception
    //   1844	1849	4057	java/lang/Exception
    //   1854	1859	4057	java/lang/Exception
    //   1868	1873	4057	java/lang/Exception
    //   2115	2122	4077	java/lang/Exception
    //   2127	2136	4077	java/lang/Exception
    //   2150	2162	4077	java/lang/Exception
    //   2165	2174	4077	java/lang/Exception
    //   2179	2184	4077	java/lang/Exception
    //   2189	2194	4077	java/lang/Exception
    //   2199	2204	4077	java/lang/Exception
    //   2209	2214	4077	java/lang/Exception
    //   513	521	4097	java/io/IOException
    //   525	533	4101	java/io/IOException
    //   538	543	4105	java/io/IOException
    //   1009	1017	4109	java/io/IOException
    //   1021	1029	4113	java/io/IOException
    //   1034	1039	4117	java/io/IOException
    //   1274	1282	4121	java/io/IOException
    //   1286	1294	4125	java/io/IOException
    //   1299	1304	4129	java/io/IOException
    //   3869	3877	4133	java/io/IOException
    //   3881	3889	4137	java/io/IOException
    //   3894	3899	4141	java/io/IOException
    //   3411	3416	4145	java/io/IOException
    //   3421	3426	4150	java/io/IOException
    //   3431	3436	4155	java/io/IOException
    //   1593	1598	4160	java/io/IOException
    //   3989	3994	4165	java/io/IOException
    //   1834	1839	4170	java/io/IOException
    //   1844	1849	4175	java/io/IOException
    //   1854	1859	4180	java/io/IOException
    //   2179	2184	4185	java/io/IOException
    //   2189	2194	4189	java/io/IOException
    //   2199	2204	4193	java/io/IOException
    //   41	48	4197	finally
    //   166	196	4226	finally
    //   199	239	4226	finally
    //   254	264	4226	finally
    //   264	275	4226	finally
    //   275	294	4226	finally
    //   309	322	4240	finally
    //   57	81	4254	finally
    //   85	109	4280	finally
    //   112	140	4306	finally
    //   140	166	4332	finally
    //   2596	2603	4354	finally
    //   2603	2643	4365	finally
    //   2860	2869	4365	finally
    //   2643	2660	4384	finally
    //   2929	2936	4384	finally
    //   2679	2696	4407	finally
    //   2715	2721	4407	finally
    //   2769	2777	4407	finally
    //   2793	2800	4407	finally
    //   2816	2822	4407	finally
    //   2838	2847	4407	finally
    //   2955	2962	4407	finally
    //   2989	2996	4407	finally
    //   3015	3021	4407	finally
    //   3035	3046	4407	finally
    //   3060	3066	4407	finally
    //   3080	3089	4407	finally
    //   3103	3110	4407	finally
    //   3124	3131	4407	finally
    //   3145	3150	4407	finally
    //   3487	3497	4407	finally
    //   3511	3516	4407	finally
    //   3530	3539	4407	finally
    //   3553	3562	4407	finally
    //   3162	3173	4434	finally
    //   3924	3933	4452	finally
    //   1558	1565	4461	finally
    //   1574	1583	4461	finally
    //   41	48	4466	java/lang/Throwable
    //   166	196	4497	java/lang/Throwable
    //   199	239	4497	java/lang/Throwable
    //   254	264	4497	java/lang/Throwable
    //   264	275	4497	java/lang/Throwable
    //   275	294	4497	java/lang/Throwable
    //   309	322	4545	java/lang/Throwable
    //   57	81	4593	java/lang/Throwable
    //   85	109	4634	java/lang/Throwable
    //   112	140	4679	java/lang/Throwable
    //   140	166	4723	java/lang/Throwable
    //   2596	2603	4771	java/lang/Throwable
    //   2643	2660	4831	java/lang/Throwable
    //   2929	2936	4831	java/lang/Throwable
    //   3162	3173	4889	java/lang/Throwable
    //   702	707	4939	java/lang/Throwable
    //   707	712	4939	java/lang/Throwable
  }
  
  void a(bhva parambhva, String paramString1, String paramString2)
  {
    try
    {
      bews.a(bews.b(parambhva.jdField_c_of_type_Int), parambhva.e().equals("POST"), bews.c(parambhva.jdField_b_of_type_Int), parambhva.jdField_a_of_type_JavaLangString, paramString1, paramString2);
      return;
    }
    catch (OutOfMemoryError parambhva) {}
  }
  
  protected void a(bhva parambhva, boolean paramBoolean, long paramLong)
  {
    parambhva.jdField_g_of_type_Int = ((int)paramLong);
    int i = parambhva.jdField_b_of_type_Int;
    int j = parambhva.jdField_c_of_type_Int;
    int k = parambhva.jdField_d_of_type_Int;
    if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      ((bhvb)this.jdField_a_of_type_MqqUtilWeakReference.get()).countFlow(paramBoolean, k, i, j, paramLong);
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.jdField_a_of_type_Bhuz.a() + " mConcurrentRunningMsgs:" + this.e + " mConcurrentLimit:" + this.jdField_d_of_type_Int + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.jdField_a_of_type_Bhuz.a() == 0) {
        return;
      }
    }
    bhuy[] arrayOfbhuy;
    int j;
    if (this.e < this.jdField_d_of_type_Int)
    {
      paramString = this.jdField_a_of_type_Bhuz.a(false);
      if (paramString != null)
      {
        arrayOfbhuy = this.jdField_a_of_type_ArrayOfBhuy;
        j = arrayOfbhuy.length;
      }
    }
    for (;;)
    {
      bhuy localbhuy;
      bhva localbhva;
      if (i < j)
      {
        localbhuy = arrayOfbhuy[i];
        localbhva = localbhuy.jdField_a_of_type_Bhva;
        if (localbhuy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label268;
        }
        this.jdField_a_of_type_Bhuz.a(paramString);
        paramString.b();
        localbhuy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localbhuy.jdField_a_of_type_Bhva = paramString;
        localbhuy.a(paramString);
        this.e += 1;
        paramString.jdField_f_of_type_Long = (SystemClock.uptimeMillis() - paramString.jdField_e_of_type_Long);
        if (QLog.isColorLevel()) {
          a(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label268:
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!localbhuy.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localbhva == null) || (localbhva.b() <= paramString.b())) {
          break;
        }
        localbhuy.a();
      }
      i += 1;
    }
  }
  
  void a(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, bhva parambhva, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      parambhva.a(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      parambhva.a(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        parambhva.a(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        parambhva.a(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        parambhva.a(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = berp.a("Q", -9531L);
        parambhva.b(bhva.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        parambhva.a(-9527, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        parambhva.a(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            parambhva.a(9014, paramInt, paramThrowable.toString());
            return;
          }
          parambhva.a(9050, paramInt, paramThrowable.toString());
          return;
        }
        parambhva.a(9049, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof SocketException))
      {
        paramHttpURLConnection = paramThrowable.toString();
        if (QLog.isColorLevel())
        {
          paramHttpURLConnection = new StringBuilder();
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int j = arrayOfStackTraceElement.length;
          int i = 0;
          while (i < j)
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
            paramHttpURLConnection.append("\n").append(localStackTraceElement.toString());
            i += 1;
          }
          paramHttpURLConnection = paramHttpURLConnection.toString();
        }
        if ((paramThrowable instanceof ConnectException))
        {
          parambhva.a(9052, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          parambhva.a(9053, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          parambhva.a(9054, paramInt, paramHttpURLConnection);
          return;
        }
        parambhva.a(9051, paramInt, paramHttpURLConnection);
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        parambhva.a(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        parambhva.a(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramThrowable = paramThrowable.toString();
      if (paramThrowable.contains("unreachable)")) {
        paramHttpURLConnection = "N_" + -20005;
      }
      for (;;)
      {
        parambhva.a(9047, paramInt, paramThrowable);
        parambhva.b(bhva.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        return;
        if (paramThrowable.contains("Connection refused"))
        {
          paramHttpURLConnection = "N_" + -20002;
        }
        else if (paramThrowable.contains("No route to host"))
        {
          if (paramThrowable.contains("SocketException")) {
            paramHttpURLConnection = "N_" + -20003;
          } else {
            paramHttpURLConnection = "N_" + -20004;
          }
        }
        else if (paramThrowable.contains("unexpected end of stream"))
        {
          paramHttpURLConnection = "N_" + -20005;
        }
        else if (paramThrowable.contains("Connection timed out"))
        {
          paramHttpURLConnection = "N_" + -20006;
        }
        else
        {
          if (paramThrowable.contains("unaccpet content type"))
          {
            parambhva.a(9064, paramInt, paramThrowable);
            return;
          }
          paramHttpURLConnection = "N_" + -20007;
        }
      }
    }
    if ((paramThrowable instanceof SecurityException))
    {
      parambhva.a(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpURLConnection = paramThrowable.getMessage();
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("FlowDecoderExp")))
    {
      parambhva.a(9058, paramInt, paramHttpURLConnection);
      return;
    }
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("DecryptError")))
    {
      parambhva.a(9059, paramInt, paramHttpURLConnection);
      return;
    }
    try
    {
      parambhva.a(9322, paramInt, Log.getStackTraceString(paramThrowable));
      return;
    }
    catch (OutOfMemoryError paramHttpURLConnection) {}
  }
  
  public void b()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new HttpCommunicator.3(this));
  }
  
  void b(int paramInt, HttpURLConnection paramHttpURLConnection, bhva parambhva)
  {
    new StringBuilder().append("Response code: ").append(paramInt).toString();
    long l2 = 0L;
    String str = paramHttpURLConnection.getHeaderField("X-ErrNo");
    if ((str != null) && (!str.equals(""))) {}
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        paramHttpURLConnection = berp.a(paramInt, l1);
        parambhva.b(bhva.jdField_f_of_type_JavaLangString, paramHttpURLConnection);
        parambhva.a(-9527, paramInt, paramHttpURLConnection);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        l1 = l2;
        continue;
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("User-ReturnCode");
      long l1 = l2;
      if (paramHttpURLConnection != null)
      {
        l1 = l2;
        if (!paramHttpURLConnection.equals("")) {
          try
          {
            l1 = Long.parseLong(paramHttpURLConnection);
          }
          catch (Exception paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void b(bhva parambhva)
  {
    if (parambhva == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Bhuz.a(parambhva);
      parambhva.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public void b(bhva parambhva, bhuy parambhuy)
  {
    int i = 0;
    if ((parambhva != null) && (parambhuy != null)) {
      try
      {
        a(parambhva, "responseTimeout", "");
        if (parambhva.b() == null) {}
        for (;;)
        {
          a(90000L, i);
          a(parambhuy);
          parambhva.a(9014, 0, "response timeout");
          parambhva.a().b(parambhva, parambhva);
          return;
          i = parambhva.b().length;
        }
        return;
      }
      catch (Exception parambhva)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", parambhva);
        }
      }
    }
  }
  
  public void c()
  {
    int i = 0;
    long l;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l = System.currentTimeMillis();
      bhva localbhva;
      do
      {
        localbhva = this.jdField_a_of_type_Bhuz.a(true);
        if (localbhva == null) {
          break;
        }
      } while ((localbhva == null) || (localbhva.a() == null));
      localbhva.a(9366, -1, "httpcommunicator_close");
      localbhva.a().b(localbhva, localbhva);
    }
    this.jdField_a_of_type_Bhuz.a();
    if (this.jdField_a_of_type_ArrayOfBhuy != null)
    {
      bhuy[] arrayOfbhuy = this.jdField_a_of_type_ArrayOfBhuy;
      int j = arrayOfbhuy.length;
      while (i < j)
      {
        arrayOfbhuy[i].sendEmptyMessage(1);
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfBhuy = null;
    this.e = 0;
    this.jdField_d_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close_inter.elapse:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhuw
 * JD-Core Version:    0.7.0.1
 */