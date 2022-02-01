import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bnqr
  extends Handler
{
  bnqr(bnqp parambnqp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    if (this.a.getCallback() == null) {}
    do
    {
      do
      {
        return;
      } while ((paramMessage.what != 1000) || (!bnqp.a(this.a).jdField_a_of_type_Boolean) || (!bnqp.a(this.a)));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.a.jdField_a_of_type_Long) / (1000.0F / bnqp.a(this.a).jdField_a_of_type_Int));
      int i;
      if ((bnqp.b(this.a)) && (bnqp.a(this.a).jdField_a_of_type_Bnqv.a() != 0)) {
        i = k % bnqp.a(this.a).jdField_a_of_type_Bnqv.a();
      }
      for (;;)
      {
        bnqp.a(this.a).jdField_a_of_type_Bnqv.a(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / bnqp.a(this.a).jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.a.invalidateSelf();
        return;
        i = k;
        if (k >= bnqp.a(this.a).jdField_a_of_type_Bnqv.a())
        {
          j = 1;
          i = k;
        }
      }
      this.a.stop();
      this.a.invalidateSelf();
    } while (this.a.jdField_a_of_type_Bnqs == null);
    this.a.jdField_a_of_type_Bnqs.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqr
 * JD-Core Version:    0.7.0.1
 */