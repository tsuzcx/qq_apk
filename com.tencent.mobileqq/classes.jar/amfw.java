import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.2;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class amfw
  implements amgd, Handler.Callback
{
  private static long jdField_a_of_type_Long = new Random().nextInt(263167);
  public static String a;
  private volatile amfu jdField_a_of_type_Amfu;
  private amgb jdField_a_of_type_Amgb = new amgb();
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private Message jdField_a_of_type_AndroidOsMessage;
  private volatile CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  private volatile InputStream jdField_a_of_type_JavaIoInputStream;
  private ConcurrentHashMap<String, amfx> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private volatile boolean jdField_a_of_type_Boolean;
  public final String b;
  private final AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_b_of_type_Boolean = true;
  private final String jdField_c_of_type_JavaLangString;
  private final AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private final AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private final AtomicBoolean jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private String jdField_f_of_type_JavaLangString;
  private final AtomicBoolean jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private String jdField_g_of_type_JavaLangString;
  private final AtomicBoolean jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaLangString = amtj.a(2131699674);
  }
  
  public amfw(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString2;
    long l = jdField_a_of_type_Long;
    jdField_a_of_type_Long = 1L + l;
    this.jdField_b_of_type_JavaLangString = String.valueOf(l);
    this.jdField_d_of_type_JavaLangString = amey.a(paramString1, "apollo_task_id", String.valueOf(this.jdField_b_of_type_JavaLangString));
    this.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") create:id=" + this.jdField_b_of_type_JavaLangString + ", url = " + paramString1);
    }
  }
  
  public static amfw a(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString))
    {
      String str = amfy.a().a(paramString);
      if (amfy.a().a(str))
      {
        paramString = new amfw(paramString, str);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "createInterceptor startSessionNewThread:" + paramBoolean + ",use:" + (System.currentTimeMillis() - l));
        }
        paramString.a(paramBoolean);
        return paramString;
      }
    }
    return null;
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(paramInt1, paramInt2))
    {
      if (paramBoolean) {
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        }
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    long l = System.currentTimeMillis();
    Object localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      amfy.a().a(BaseApplicationImpl.getContext(), this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, (AppInterface)localObject, this.jdField_a_of_type_Amgb);
      localObject = amfy.a().a(this.jdField_c_of_type_JavaLangString);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          amfq localamfq = (amfq)((Iterator)localObject).next();
          if (localamfq.a())
          {
            amfx localamfx = new amfx(this, localamfq);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localamfq.jdField_a_of_type_JavaLangString, localamfx);
            localamfx.b();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "preloadSSOData use:" + (System.currentTimeMillis() - l));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (3 != i)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      this.jdField_a_of_type_JavaIoInputStream = null;
      this.jdField_g_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_AndroidOsMessage != null) {
        this.jdField_a_of_type_AndroidOsMessage = null;
      }
      if ((!paramBoolean) && (!c())) {
        break label227;
      }
      if ((this.jdField_a_of_type_Amfu != null) && (!paramBoolean))
      {
        this.jdField_a_of_type_Amfu.a();
        this.jdField_a_of_type_Amfu = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
        this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") final destroy, force=" + paramBoolean + ".");
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
        ??? = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (((Iterator)???).hasNext()) {
          ((amfx)((Iterator)???).next()).a();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    label227:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
      } while (!this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 6000L);
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") waiting for destroy, current state =" + i + ".");
  }
  
  private boolean b()
  {
    return (3 == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) || (this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  private void c()
  {
    if (1 != this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask error:sessionState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ".");
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
    long l1 = System.currentTimeMillis();
    this.jdField_f_of_type_JavaLangString = amey.e(this.jdField_e_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask error:fileName is null");
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    Object localObject1 = amey.d(this.jdField_f_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask url is " + this.jdField_e_of_type_JavaLangString + " filePath is " + (String)localObject1);
    }
    Object localObject2 = new File((String)localObject1);
    localObject1 = amey.a((File)localObject2);
    this.jdField_a_of_type_Amgb.e = (System.currentTimeMillis() - l1);
    boolean bool1;
    label296:
    boolean bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      bool1 = true;
      if (!bool1) {
        break label663;
      }
      long l2 = System.currentTimeMillis();
      if (amfy.a().a(this.jdField_c_of_type_JavaLangString, (String)localObject1)) {
        break label652;
      }
      localObject1 = null;
      ((File)localObject2).delete();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask md5 not match delete localFile! url is " + this.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Amgb.a = 1;
      bool1 = false;
      label387:
      this.jdField_a_of_type_Amgb.f = (System.currentTimeMillis() - l2);
      localObject2 = localObject1;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "verify use:" + (System.currentTimeMillis() - l2));
        bool2 = bool1;
        localObject2 = localObject1;
      }
      label451:
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "get LocalFile use:" + (System.currentTimeMillis() - l1));
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsMessage = ((Message)localObject1);
      if (!bool2) {
        break label682;
      }
      ((Message)localObject1).arg1 = 2;
      ((Message)localObject1).obj = localObject2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask hasHtmlCache:" + bool2);
      }
      this.jdField_g_of_type_JavaLangString = ((String)localObject2);
    }
    for (;;)
    {
      a(1, 2, true);
      this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if ((!d()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask:send force destroy message.");
      return;
      bool1 = false;
      break label296;
      label652:
      this.jdField_a_of_type_Amgb.a = 2;
      break label387;
      label663:
      this.jdField_a_of_type_Amgb.a = 0;
      localObject2 = localObject1;
      bool2 = bool1;
      break label451;
      label682:
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask has no cache, do first load flow.");
      }
      ((Message)localObject1).arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
      {
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(255, 1500L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask error:network is not valid!");
        }
      }
      else
      {
        d();
      }
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") canDestroy:false, isWaitingForSessionThread=" + this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isWaitingForBlinkCloseStream=" + this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " isWaitingForDestroy:" + this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      return false;
    }
    return true;
  }
  
  private void d()
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Amfu = new amfu(this.jdField_e_of_type_JavaLangString, true, null, null);
    long l2 = System.currentTimeMillis();
    int j = this.jdField_a_of_type_Amfu.a();
    int i = j;
    Map localMap;
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") connection connect cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      j = this.jdField_a_of_type_Amfu.b();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") connection response cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      localMap = this.jdField_a_of_type_Amfu.a();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") connection get header fields cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      i = j;
      if (localMap != null)
      {
        if (!localMap.containsKey("Set-Cookie")) {
          break label410;
        }
        localObject = "Set-Cookie";
      }
    }
    label410:
    do
    {
      for (;;)
      {
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (List)localMap.get(localObject);
          amey.a(this.jdField_e_of_type_JavaLangString, (List)localObject);
          i = j;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_Connection: respCode = " + i + ", cost " + (System.currentTimeMillis() - l1) + " ms.");
        }
        if (!b()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 6, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_Connection: destroy before server response.");
        }
        return;
        if (localMap.containsKey("set-cookie")) {
          localObject = "set-cookie";
        }
      }
      if (200 == i) {
        break;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
        ((Message)localObject).arg1 = i;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_Connection: response code not 200, response code = " + i);
    return;
    e();
  }
  
  private boolean d()
  {
    if ((this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (c()))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      return true;
    }
    return false;
  }
  
  private void e()
  {
    int i = 2;
    Object localObject1 = this.jdField_a_of_type_Amfu.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, null);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_FirstLoad error:responseDataTuple is null!");
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_JavaIoInputStream = new amgc(this, ((amfv)localObject1).jdField_a_of_type_JavaIoByteArrayOutputStream, ((amfv)localObject1).jdField_a_of_type_JavaIoBufferedInputStream);
    if (((amfv)localObject1).jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        localObject1 = ((amfv)localObject1).jdField_a_of_type_JavaIoByteArrayOutputStream.toString("UTF-8");
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.jdField_g_of_type_JavaLangString = ((String)localObject1);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label399;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_FirstLoad:hasCacheData=" + bool + ".");
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
          ((Message)localObject2).obj = localObject1;
          if (!bool) {
            break label404;
          }
          ((Message)localObject2).arg1 = i;
          this.jdField_a_of_type_AndroidOsMessage = ((Message)localObject2);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          if ((!bool) || (this.jdField_a_of_type_Boolean)) {
            break;
          }
          long l = System.currentTimeMillis();
          amfy.a().b(this.jdField_e_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_FirstLoad :save htmlString " + (System.currentTimeMillis() - l) + " ms.");
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            boolean bool;
            Object localObject2 = localObject1;
          }
        }
        localThrowable1 = localThrowable1;
        localObject2 = null;
      }
      this.jdField_a_of_type_JavaIoInputStream = null;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_FirstLoad error:" + localThrowable1.getMessage() + ".");
        localObject1 = localObject2;
        continue;
        label399:
        bool = false;
        continue;
        label404:
        i = 1;
        continue;
        localObject1 = null;
      }
    }
  }
  
  public amgb a()
  {
    return this.jdField_a_of_type_Amgb;
  }
  
  /* Error */
  public Object a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 345	amfw:jdField_c_of_type_Boolean	Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 286	amfw:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13: ifnull +66 -> 79
    //   16: invokestatic 174	amfy:a	()Lamfy;
    //   19: aload_1
    //   20: invokevirtual 522	amfy:b	(Ljava/lang/String;)Z
    //   23: ifeq +56 -> 79
    //   26: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +29 -> 58
    //   32: ldc 136
    //   34: iconst_2
    //   35: new 138	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 524
    //   45: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: invokestatic 174	amfy:a	()Lamfy;
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 106	amfw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   66: invokevirtual 527	amfy:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   69: astore 5
    //   71: aload 5
    //   73: ifnull +6 -> 79
    //   76: aload 5
    //   78: areturn
    //   79: aload_0
    //   80: getfield 286	amfw:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   83: ifnull +139 -> 222
    //   86: aload_0
    //   87: getfield 104	amfw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   90: invokevirtual 528	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   93: ifne +129 -> 222
    //   96: aload_0
    //   97: getfield 104	amfw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   100: invokevirtual 316	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   103: invokeinterface 319 1 0
    //   108: astore 5
    //   110: aload 5
    //   112: invokeinterface 257 1 0
    //   117: ifeq +105 -> 222
    //   120: aload 5
    //   122: invokeinterface 261 1 0
    //   127: checkcast 267	amfx
    //   130: astore 6
    //   132: aload_1
    //   133: aload 6
    //   135: invokestatic 531	amfx:a	(Lamfx;)Lamfq;
    //   138: getfield 271	amfq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   141: invokevirtual 534	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   144: ifeq -34 -> 110
    //   147: aload 6
    //   149: aload_1
    //   150: invokevirtual 537	amfx:a	(Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   153: astore 7
    //   155: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +40 -> 198
    //   161: ldc 136
    //   163: iconst_2
    //   164: new 138	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 539
    //   174: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 541
    //   184: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 7
    //   189: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aload_0
    //   199: getfield 104	amfw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   202: aload 6
    //   204: invokestatic 531	amfx:a	(Lamfx;)Lamfq;
    //   207: getfield 271	amfq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: invokevirtual 544	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: pop
    //   214: aload 7
    //   216: ifnull -106 -> 110
    //   219: aload 7
    //   221: areturn
    //   222: aload_0
    //   223: aload_1
    //   224: invokevirtual 545	amfw:a	(Ljava/lang/String;)Z
    //   227: ifne +49 -> 276
    //   230: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -226 -> 7
    //   236: ldc 136
    //   238: iconst_2
    //   239: new 138	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   246: ldc 141
    //   248: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: getfield 114	amfw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   255: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 547
    //   261: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aconst_null
    //   275: areturn
    //   276: aload_0
    //   277: getfield 67	amfw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   280: invokevirtual 339	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   283: ifeq +47 -> 330
    //   286: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +41 -> 330
    //   292: ldc 136
    //   294: iconst_2
    //   295: new 138	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   302: ldc 141
    //   304: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_0
    //   308: getfield 114	amfw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   311: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 549
    //   317: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload_0
    //   331: getfield 67	amfw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   334: iconst_0
    //   335: iconst_1
    //   336: invokevirtual 326	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   339: ifne +47 -> 386
    //   342: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq +41 -> 386
    //   348: ldc 136
    //   350: iconst_2
    //   351: new 138	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   358: ldc 141
    //   360: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: getfield 114	amfw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   367: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc_w 551
    //   373: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_1
    //   377: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +41 -> 430
    //   392: ldc 136
    //   394: iconst_2
    //   395: new 138	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   402: ldc 141
    //   404: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_0
    //   408: getfield 114	amfw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   411: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc_w 553
    //   417: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_1
    //   421: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   433: lstore_2
    //   434: aload_0
    //   435: getfield 60	amfw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   438: invokevirtual 284	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   441: iconst_1
    //   442: if_icmpne +357 -> 799
    //   445: aload_0
    //   446: getfield 60	amfw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   449: astore_1
    //   450: aload_1
    //   451: monitorenter
    //   452: aload_0
    //   453: getfield 60	amfw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   456: invokevirtual 284	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   459: iconst_1
    //   460: if_icmpne +53 -> 513
    //   463: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +37 -> 503
    //   469: ldc 136
    //   471: iconst_2
    //   472: new 138	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   479: ldc 141
    //   481: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_0
    //   485: getfield 114	amfw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   488: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc_w 555
    //   494: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload_0
    //   504: getfield 60	amfw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   507: ldc2_w 556
    //   510: invokevirtual 561	java/lang/Object:wait	(J)V
    //   513: aload_1
    //   514: monitorexit
    //   515: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +74 -> 592
    //   521: new 138	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   528: ldc 141
    //   530: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload_0
    //   534: getfield 114	amfw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   537: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc_w 563
    //   543: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: astore_1
    //   547: aload_0
    //   548: getfield 288	amfw:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   551: ifnull +298 -> 849
    //   554: iconst_1
    //   555: istore 4
    //   557: ldc 136
    //   559: iconst_2
    //   560: aload_1
    //   561: iload 4
    //   563: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   566: ldc_w 472
    //   569: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   575: lload_2
    //   576: lsub
    //   577: invokevirtual 192	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   580: ldc_w 565
    //   583: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: aload_0
    //   593: getfield 288	amfw:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   596: ifnonnull +54 -> 650
    //   599: aload_0
    //   600: getfield 290	amfw:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   603: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   606: ifne +44 -> 650
    //   609: aload_0
    //   610: new 567	java/io/ByteArrayInputStream
    //   613: dup
    //   614: aload_0
    //   615: getfield 290	amfw:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   618: ldc_w 503
    //   621: invokevirtual 571	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   624: invokespecial 574	java/io/ByteArrayInputStream:<init>	([B)V
    //   627: putfield 288	amfw:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   630: aload_0
    //   631: iconst_1
    //   632: putfield 576	amfw:jdField_d_of_type_Boolean	Z
    //   635: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +12 -> 650
    //   641: ldc 136
    //   643: iconst_2
    //   644: ldc_w 578
    //   647: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: aload_0
    //   651: getfield 288	amfw:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   654: ifnull +236 -> 890
    //   657: aload_0
    //   658: invokespecial 436	amfw:b	()Z
    //   661: ifne +209 -> 870
    //   664: new 580	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   667: dup
    //   668: aload_0
    //   669: getfield 128	amfw:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   672: invokestatic 581	amey:a	(Ljava/lang/String;)Ljava/lang/String;
    //   675: ldc_w 583
    //   678: aload_0
    //   679: getfield 288	amfw:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   682: invokespecial 586	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   685: astore_1
    //   686: aload_0
    //   687: getfield 75	amfw:jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   690: iconst_1
    //   691: invokevirtual 308	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   694: aload_0
    //   695: getfield 576	amfw:jdField_d_of_type_Boolean	Z
    //   698: ifeq +8 -> 706
    //   701: aload_0
    //   702: iconst_0
    //   703: putfield 576	amfw:jdField_d_of_type_Boolean	Z
    //   706: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq +29 -> 738
    //   712: ldc 136
    //   714: iconst_2
    //   715: new 138	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   722: ldc_w 588
    //   725: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: aload_1
    //   729: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   732: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload_0
    //   739: aconst_null
    //   740: putfield 288	amfw:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   743: aload_1
    //   744: areturn
    //   745: astore 5
    //   747: ldc 136
    //   749: iconst_2
    //   750: new 138	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   757: ldc 141
    //   759: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_0
    //   763: getfield 114	amfw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   766: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: ldc_w 590
    //   772: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload 5
    //   777: invokevirtual 518	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   780: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokestatic 592	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: goto -276 -> 513
    //   792: astore 5
    //   794: aload_1
    //   795: monitorexit
    //   796: aload 5
    //   798: athrow
    //   799: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq -287 -> 515
    //   805: ldc 136
    //   807: iconst_2
    //   808: new 138	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   815: ldc 141
    //   817: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_0
    //   821: getfield 114	amfw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   824: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 594
    //   830: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload_0
    //   834: getfield 60	amfw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   837: invokevirtual 434	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   846: goto -331 -> 515
    //   849: iconst_0
    //   850: istore 4
    //   852: goto -295 -> 557
    //   855: astore_1
    //   856: ldc 136
    //   858: iconst_2
    //   859: aload_1
    //   860: iconst_0
    //   861: anewarray 4	java/lang/Object
    //   864: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   867: goto -232 -> 635
    //   870: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   873: ifeq +12 -> 885
    //   876: ldc 136
    //   878: iconst_2
    //   879: ldc_w 599
    //   882: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   885: aconst_null
    //   886: astore_1
    //   887: goto -193 -> 694
    //   890: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   893: ifeq -886 -> 7
    //   896: ldc 136
    //   898: iconst_2
    //   899: ldc_w 601
    //   902: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aconst_null
    //   906: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	907	0	this	amfw
    //   0	907	1	paramString	String
    //   433	143	2	l	long
    //   555	296	4	bool	boolean
    //   69	52	5	localObject1	Object
    //   745	31	5	localThrowable	Throwable
    //   792	5	5	localObject2	Object
    //   130	73	6	localamfx	amfx
    //   153	67	7	localWebResourceResponse	com.tencent.smtt.export.external.interfaces.WebResourceResponse
    // Exception table:
    //   from	to	target	type
    //   452	503	745	java/lang/Throwable
    //   503	513	745	java/lang/Throwable
    //   452	503	792	finally
    //   503	513	792	finally
    //   513	515	792	finally
    //   747	789	792	finally
    //   794	796	792	finally
    //   609	635	855	java/lang/Throwable
  }
  
  public void a()
  {
    b(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") start error:sessionState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ".");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") now post task flow task.");
    }
    this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (paramBoolean)
    {
      ThreadManager.postImmediately(new ApolloUrlInterceptor.2(this), null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    amgb localamgb = this.jdField_a_of_type_Amgb;
    long l = System.currentTimeMillis();
    localamgb.g = l;
    b();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_Amgb.h = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaIoInputStream != null) {
      this.jdField_a_of_type_JavaIoInputStream = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.jdField_b_of_type_JavaLangString + ") onClose:readComplete:" + paramBoolean);
    }
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (paramByteArrayOutputStream != null))
    {
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloUrlInterceptor.3(this, paramByteArrayOutputStream), 3000L);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("task(").append(this.jdField_b_of_type_JavaLangString).append(") onClose error:readComplete =").append(paramBoolean).append(", outputStream is null -> ");
      if (paramByteArrayOutputStream != null) {
        break label262;
      }
    }
    label262:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      QLog.e("apollo_client_ApolloUrlInterceptor", 6, paramBoolean);
      this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (d()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("apollo_client_ApolloUrlInterceptor", 6, "task(" + this.jdField_b_of_type_JavaLangString + ") onClose cost " + (System.currentTimeMillis() - l) + " ms.");
      return;
    }
  }
  
  public boolean a()
  {
    return !this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(CustomWebView paramCustomWebView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") bind client.");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(this.jdField_e_of_type_JavaLangString);
      paramString = Uri.parse(paramString);
      Object localObject = localUri.getHost() + localUri.getPath();
      String str = paramString.getHost() + paramString.getPath();
      if (localUri.getHost().equalsIgnoreCase(paramString.getHost()))
      {
        paramString = (String)localObject;
        if (!((String)localObject).endsWith("/")) {
          paramString = (String)localObject + "/";
        }
        localObject = str;
        if (!str.endsWith("/")) {
          localObject = str + "/";
        }
        boolean bool = paramString.equalsIgnoreCase((String)localObject);
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("apollo_client_ApolloUrlInterceptor", 2, "isMatchCurrentUrl error:" + paramString.getMessage());
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    if ((!this.jdField_c_of_type_Boolean) && (a(paramString)) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
    {
      this.jdField_e_of_type_JavaLangString = amey.a(paramString, "apollo_task_id", String.valueOf(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_Amgb.i = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("task(").append(this.jdField_b_of_type_JavaLangString).append(") onWebViewInited: mPendingClientCoreMessage not null:");
        if (this.jdField_a_of_type_AndroidOsMessage != null) {
          bool = true;
        }
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, bool + ",currUrl:" + this.jdField_e_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_AndroidOsMessage != null)
      {
        paramString = this.jdField_a_of_type_AndroidOsMessage;
        this.jdField_a_of_type_AndroidOsMessage = null;
        handleMessage(paramString);
      }
      while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
        return true;
      }
      a(true);
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (10 == paramMessage.what)
    {
      b(true);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleMessage:force destroy.");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleMessage error: is destroyed or waiting for destroy.");
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleMessage: msg what = " + paramMessage.what + ".");
      }
      if ((paramMessage.what > 0) && (paramMessage.what < 7) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        this.jdField_a_of_type_AndroidOsMessage = Message.obtain(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleMessage: client not ready, core msg = " + paramMessage.what + ".");
        }
        return true;
      }
      if (paramMessage == this.jdField_a_of_type_AndroidOsMessage) {
        this.jdField_a_of_type_AndroidOsMessage = null;
      }
      switch (paramMessage.what)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "msg.what " + paramMessage.what);
    return false;
    if (paramMessage.arg1 == 1) {
      if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
        }
        this.jdField_a_of_type_Amgb.j = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
        continue;
        if (paramMessage.arg1 == 2) {
          if (this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
            }
            paramMessage = (String)paramMessage.obj;
            this.jdField_a_of_type_Amgb.j = System.currentTimeMillis();
            if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
              if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() != null)
              {
                this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(this.jdField_e_of_type_JavaLangString, paramMessage, "text/html", "utf-8", this.jdField_e_of_type_JavaLangString);
              }
              else
              {
                this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
                QLog.e("apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_PRE_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
            continue;
            if (paramMessage.arg1 == 1)
            {
              if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_CACHE.");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_FirstLoad:url was not invoked.");
              }
            }
            else if (paramMessage.arg1 == 2) {
              if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(\" + id + \") handleClientCoreMessage_FirstLoad with cache, url:" + this.jdField_e_of_type_JavaLangString);
                }
                this.jdField_d_of_type_Boolean = true;
                this.jdField_a_of_type_Amgb.j = System.currentTimeMillis();
                if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
                  if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() != null)
                  {
                    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(this.jdField_e_of_type_JavaLangString, (String)paramMessage.obj, "text/html", "utf-8", this.jdField_e_of_type_JavaLangString);
                  }
                  else
                  {
                    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
                    QLog.e("apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_FIRST_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") FIRST_LOAD_WITH_CACHE load url was invoked.");
                continue;
                if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "handleClientCoreMessage_ConnectionError: load src url.");
                  }
                  if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
                  {
                    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
                    continue;
                    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!b()) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))) {
                      Toast.makeText(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, 1).show();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfw
 * JD-Core Version:    0.7.0.1
 */