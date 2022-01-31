import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.mobileqq.util.FPSCalculator.2;
import com.tencent.mobileqq.util.FPSCalculator.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
public class bcwk
{
  private static volatile bcwk jdField_a_of_type_Bcwk;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Choreographer.FrameCallback jdField_a_of_type_AndroidViewChoreographer$FrameCallback;
  private Choreographer jdField_a_of_type_AndroidViewChoreographer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new FPSCalculator.2(this);
  private Vector<bcwm> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean;
  private Runnable b = new FPSCalculator.3(this);
  
  private static long a(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(paramLong);
  }
  
  public static bcwk a()
  {
    if (jdField_a_of_type_Bcwk == null) {}
    try
    {
      if (jdField_a_of_type_Bcwk == null) {
        jdField_a_of_type_Bcwk = new bcwk();
      }
      return jdField_a_of_type_Bcwk;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("FPSCalculator", 2, "FPSCalculator is enable");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    QLog.d("FPSCalculator", 2, "FPSCalculator set enable = true");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (Build.VERSION.SDK_INT > 16)
    {
      if (this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback == null) {
        this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback = new bcwl(this);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FPSCalculator", 2, "build version is not support ");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.b, 500L);
  }
  
  private void a(long paramLong)
  {
    paramLong = a(paramLong);
    if (this.jdField_a_of_type_Long <= 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      return;
      long l = paramLong - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Int += 1;
      if (l <= 500L) {
        continue;
      }
      double d = this.jdField_a_of_type_Int * 1000 / l;
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Int = 0;
      Object localObject1 = this.jdField_a_of_type_JavaLangObject;
      int i = 0;
      try
      {
        while (i < this.jdField_a_of_type_JavaUtilVector.size())
        {
          ((bcwm)this.jdField_a_of_type_JavaUtilVector.get(i)).onInfo(this.jdField_a_of_type_Long, d);
          i += 1;
        }
      }
      finally {}
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label82;
      }
      if (this.jdField_a_of_type_AndroidViewChoreographer != null)
      {
        this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
        if (QLog.isColorLevel()) {
          QLog.d("FPSCalculator", 2, "removeFrameCallback ");
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      QLog.d("FPSCalculator", 2, "FPSCalculator set enable = false");
      return;
      label82:
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    }
  }
  
  public void a(bcwm parambcwm)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilVector.contains(parambcwm)) {
        this.jdField_a_of_type_JavaUtilVector.add(parambcwm);
      }
      if (this.jdField_a_of_type_JavaUtilVector.size() > 0) {
        a();
      }
      return;
    }
  }
  
  public void b(bcwm parambcwm)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilVector.contains(parambcwm)) {
        this.jdField_a_of_type_JavaUtilVector.remove(parambcwm);
      }
      if (this.jdField_a_of_type_JavaUtilVector.size() <= 0) {
        b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwk
 * JD-Core Version:    0.7.0.1
 */