import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bjww
  extends Handler
{
  bjww(bjwu parambjwu, Looper paramLooper)
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
      } while ((paramMessage.what != 1000) || (!bjwu.a(this.a).jdField_a_of_type_Boolean));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.a.jdField_a_of_type_Long) / (1000.0F / bjwu.a(this.a).jdField_a_of_type_Int));
      int i;
      if ((bjwu.a(this.a)) && (bjwu.a(this.a).jdField_a_of_type_Bjxa.a() != 0)) {
        i = k % bjwu.a(this.a).jdField_a_of_type_Bjxa.a();
      }
      for (;;)
      {
        bjwu.a(this.a).jdField_a_of_type_Bjxa.a(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / bjwu.a(this.a).jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.a.invalidateSelf();
        return;
        i = k;
        if (k >= bjwu.a(this.a).jdField_a_of_type_Bjxa.a())
        {
          j = 1;
          i = k;
        }
      }
      this.a.stop();
      this.a.invalidateSelf();
    } while (this.a.jdField_a_of_type_Bjwx == null);
    this.a.jdField_a_of_type_Bjwx.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjww
 * JD-Core Version:    0.7.0.1
 */