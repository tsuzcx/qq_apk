import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.1;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.2;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.3;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.4;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class axsz
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), null);
  private axta jdField_a_of_type_Axta;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<Long, Runnable> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private Handler b = new Handler(ThreadManager.getSubThreadLooper(), this);
  
  public axsz(axta paramaxta)
  {
    this.jdField_a_of_type_Axta = paramaxta;
  }
  
  public Runnable a(long paramLong)
  {
    OrderMediaMsgTimerController.1 local1 = new OrderMediaMsgTimerController.1(this, paramLong);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(local1, 8000L);
    return local1;
  }
  
  public Runnable a(String paramString)
  {
    paramString = new OrderMediaMsgTimerController.2(this, paramString);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramString, 8000L);
    return paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))))
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)));
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong))) {
      return;
    }
    OrderMediaMsgTimerController.4 local4 = new OrderMediaMsgTimerController.4(this, paramLong, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(local4, 30000L);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), local4);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_JavaLangRunnable = new OrderMediaMsgTimerController.3(this, paramLong);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localRunnable);
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.b != null)
    {
      this.b.removeCallbacksAndMessages(null);
      this.b = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l = 0L;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj != null) && (this.jdField_a_of_type_Axta != null))
      {
        this.jdField_a_of_type_Axta.a(paramMessage.obj);
        continue;
        if (paramMessage.obj != null) {
          l = ((Long)paramMessage.obj).longValue();
        }
        if (this.jdField_a_of_type_Axta != null)
        {
          this.jdField_a_of_type_Axta.a(l);
          continue;
          if (paramMessage.obj != null) {
            l = ((Long)paramMessage.obj).longValue();
          }
          if (this.jdField_a_of_type_Axta != null) {
            this.jdField_a_of_type_Axta.a(l, paramMessage.arg1, paramMessage.arg2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsz
 * JD-Core Version:    0.7.0.1
 */