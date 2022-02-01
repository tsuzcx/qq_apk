import android.text.TextUtils;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.PreloadCGITask.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class anhf
{
  private long jdField_a_of_type_Long;
  private angy jdField_a_of_type_Angy;
  private anhc jdField_a_of_type_Anhc;
  private anhk jdField_a_of_type_Anhk;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private volatile boolean jdField_a_of_type_Boolean;
  
  anhf(anhe paramanhe, angy paramangy)
  {
    this.jdField_a_of_type_Angy = paramangy;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(int paramInt, long paramLong)
  {
    try
    {
      if ((anhe.a(this.jdField_a_of_type_Anhe) != null) && (this.jdField_a_of_type_Angy != null))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("preloadSuccess", paramInt);
        localJSONObject.put("costTime", paramLong);
        anhe.a(this.jdField_a_of_type_Anhe).a.put(this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString, localJSONObject);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Apollo_client_PreloadCGITask", 1, localException, new Object[0]);
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      if ((anhe.a(this.jdField_a_of_type_Anhe) != null) && (this.jdField_a_of_type_Angy != null))
      {
        JSONObject localJSONObject = anhe.a(this.jdField_a_of_type_Anhe).a.optJSONObject(this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString);
        if (localJSONObject != null)
        {
          localJSONObject.put("costTime", paramLong);
          anhe.a(this.jdField_a_of_type_Anhe).a.put(this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString, localJSONObject);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Apollo_client_PreloadCGITask", 1, localException, new Object[0]);
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Angy == null) || (!this.jdField_a_of_type_Angy.a())) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Anhc = new anhc(this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_Angy, angg.f(anhe.a(this.jdField_a_of_type_Anhe)));
      l2 = System.currentTimeMillis();
    } while (this.jdField_a_of_type_Boolean);
    int j = this.jdField_a_of_type_Anhc.a();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    int i = j;
    Object localObject2;
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") connection connect cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      i = this.jdField_a_of_type_Anhc.b();
      if (QLog.isColorLevel()) {
        QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") connection response cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      localObject2 = this.jdField_a_of_type_Anhc.a();
      if (QLog.isColorLevel()) {
        QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") connection get header fields cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      if (localObject2 != null) {
        if (((Map)localObject2).containsKey("Set-Cookie")) {
          ??? = "Set-Cookie";
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)???))
        {
          ??? = (List)((Map)localObject2).get(???);
          angg.a(this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString, (List)???);
        }
        ??? = ((Map)localObject2).entrySet().iterator();
        for (;;)
        {
          if (((Iterator)???).hasNext())
          {
            Object localObject7 = (Map.Entry)((Iterator)???).next();
            localObject2 = (String)((Map.Entry)localObject7).getKey();
            localObject7 = (List)((Map.Entry)localObject7).getValue();
            if ((localObject7 != null) && (((List)localObject7).size() > 0))
            {
              this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, ((List)localObject7).get(0));
              continue;
              if (!((Map)localObject2).containsKey("set-cookie")) {
                break label1083;
              }
              ??? = "set-cookie";
              break;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") mHeaderMap:" + this.jdField_a_of_type_JavaUtilHashMap);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_client_PreloadCGITask", 4, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") handleFlow_Connection: respCode = " + i + ", cost " + (System.currentTimeMillis() - l1) + " ms.");
        }
        if (anhe.c(this.jdField_a_of_type_Anhe))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_client_PreloadCGITask", 6, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") handleFlow_Connection: destroy before server response.");
          }
          if (this.jdField_a_of_type_Anhc != null)
          {
            this.jdField_a_of_type_Anhc.a();
            this.jdField_a_of_type_Anhc = null;
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
            this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
            a(this.jdField_a_of_type_Long);
            return;
          }
        }
        if (200 != i)
        {
          if (this.jdField_a_of_type_Anhc != null)
          {
            this.jdField_a_of_type_Anhc.a();
            this.jdField_a_of_type_Anhc = null;
          }
          this.jdField_a_of_type_Anhk = null;
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_client_PreloadCGITask", 4, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") handleFlow_Connection: response code not 200, response code = " + i);
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
            this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
            a(this.jdField_a_of_type_Long);
            return;
          }
        }
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        ??? = this.jdField_a_of_type_Anhc.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, null);
        if (??? == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") handleFlow_FirstLoad error:responseDataTuple is null!");
          }
          this.jdField_a_of_type_Anhk = null;
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
          synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
            this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
            a(this.jdField_a_of_type_Long);
            return;
          }
        }
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_Anhk = new anhk(null, ((anhd)???).jdField_a_of_type_JavaIoByteArrayOutputStream, ((anhd)???).jdField_a_of_type_JavaIoBufferedInputStream);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
          this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
          a(this.jdField_a_of_type_Long);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Apollo_client_PreloadCGITask", 2, "task(" + this.jdField_a_of_type_Angy.jdField_a_of_type_JavaLangString + ") mCostTime:" + this.jdField_a_of_type_Long);
          return;
        }
      }
      label1083:
      ??? = null;
    }
  }
  
  public WebResourceResponse a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_client_PreloadCGITask", 2, "getCgiResource(" + paramString + ") now wait for pendingWebResourceStream!");
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait(200L);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("Apollo_client_PreloadCGITask", 2, "getCgiResource" + localThrowable);
        }
      }
      if (this.jdField_a_of_type_Anhk != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_JavaLangString = angg.a(paramString);
        }
        paramString = new WebResourceResponse(this.jdField_a_of_type_JavaLangString, "utf-8", this.jdField_a_of_type_Anhk);
        if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
          paramString.setResponseHeaders(this.jdField_a_of_type_JavaUtilHashMap);
        }
        a(1, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Anhk = null;
        return paramString;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a(0, this.jdField_a_of_type_Long);
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anhc != null)
    {
      this.jdField_a_of_type_Anhc.a();
      this.jdField_a_of_type_Anhc = null;
    }
    if (this.jdField_a_of_type_Anhk != null) {
      this.jdField_a_of_type_Anhk = null;
    }
    QLog.d("Apollo_client_PreloadCGITask", 1, "PreloadCGITask onDestroy ");
  }
  
  public void b()
  {
    ThreadManagerV2.excute(new ApolloUrlInterceptor.PreloadCGITask.1(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhf
 * JD-Core Version:    0.7.0.1
 */