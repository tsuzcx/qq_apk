import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.monitor.common.FPSCalculator.2;
import com.tencent.qqmini.sdk.monitor.common.FPSCalculator.3;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
public class bgwx
{
  private static volatile bgwx jdField_a_of_type_Bgwx;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Choreographer.FrameCallback jdField_a_of_type_AndroidViewChoreographer$FrameCallback;
  private Choreographer jdField_a_of_type_AndroidViewChoreographer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new FPSCalculator.2(this);
  private Vector<bgwz> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean;
  private Runnable b = new FPSCalculator.3(this);
  
  private static long a(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(paramLong);
  }
  
  public static bgwx a()
  {
    if (jdField_a_of_type_Bgwx == null) {}
    try
    {
      if (jdField_a_of_type_Bgwx == null) {
        jdField_a_of_type_Bgwx = new bgwx();
      }
      return jdField_a_of_type_Bgwx;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QMLog.d("FPSCalculator", "FPSCalculator is enable");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    QMLog.d("FPSCalculator", "FPSCalculator set enable = true");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (Build.VERSION.SDK_INT > 16)
    {
      if (this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback == null) {
        this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback = new bgwy(this);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (QMLog.isColorLevel()) {
      QMLog.d("FPSCalculator", "build version is not support ");
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
          ((bgwz)this.jdField_a_of_type_JavaUtilVector.get(i)).a(this.jdField_a_of_type_Long, d);
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
        break label80;
      }
      if (this.jdField_a_of_type_AndroidViewChoreographer != null)
      {
        this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
        if (QMLog.isColorLevel()) {
          QMLog.d("FPSCalculator", "removeFrameCallback ");
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      QMLog.d("FPSCalculator", "FPSCalculator set enable = false");
      return;
      label80:
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    }
  }
  
  public void a(bgwz parambgwz)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilVector.contains(parambgwz)) {
        this.jdField_a_of_type_JavaUtilVector.add(parambgwz);
      }
      if (this.jdField_a_of_type_JavaUtilVector.size() > 0) {
        a();
      }
      return;
    }
  }
  
  public void b(bgwz parambgwz)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilVector.contains(parambgwz)) {
        this.jdField_a_of_type_JavaUtilVector.remove(parambgwz);
      }
      if (this.jdField_a_of_type_JavaUtilVector.size() <= 0) {
        b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwx
 * JD-Core Version:    0.7.0.1
 */