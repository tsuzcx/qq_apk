import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class ayqo
  implements Handler.Callback, ayso
{
  private float jdField_a_of_type_Float = 0.0F;
  private final int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  private ayqp jdField_a_of_type_Ayqp;
  private aysl jdField_a_of_type_Aysl = new aysl();
  private int b;
  private int c = ayqi.H;
  
  public ayqo(ayqp paramayqp, int paramInt)
  {
    this.jdField_a_of_type_Ayqp = paramayqp;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationInterface", 2, "[status][locInterface] startLocationImpl.");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_Aysl.a(this);
    this.jdField_a_of_type_Aysl.a(2000L, false, false);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 10000L);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationInterface", 2, "[status][locInterface] stopLocationImpl.");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_Aysl.b(this);
    this.jdField_a_of_type_Aysl.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt) {}
  
  public void a(aysk paramaysk, Double paramDouble, boolean paramBoolean)
  {
    if (paramaysk.jdField_a_of_type_Float > this.jdField_a_of_type_Int + this.jdField_a_of_type_Float)
    {
      this.b += 1;
      if (this.b > 8L)
      {
        this.jdField_a_of_type_Float = ((float)(this.jdField_a_of_type_Float + 10.0D));
        this.b = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLocationInterface", 2, new Object[] { "[status][locInterface] ignore location: ", paramaysk, " time:", Integer.valueOf(this.b), " adjust:", Float.valueOf(this.jdField_a_of_type_Float) });
      }
      return;
    }
    this.b = 0;
    if ((paramBoolean) && (this.jdField_a_of_type_Ayqp != null)) {
      this.jdField_a_of_type_Ayqp.a(paramaysk);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > ayqi.H * 2)) {}
    for (this.c = ayqi.H;; this.c = paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoLocationInterface", 2, new Object[] { "[status][distance] setDistanceReqTime ", Integer.valueOf(this.c) });
      }
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("AutoLocationInterface", 2, new Object[] { "unKnow msg:", Integer.valueOf(paramMessage.what) });
      }
      return false;
    case 1: 
      c();
      return false;
    case 2: 
      d();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, ayqi.H);
      return false;
    }
    d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqo
 * JD-Core Version:    0.7.0.1
 */