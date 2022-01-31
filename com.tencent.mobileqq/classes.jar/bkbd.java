import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bkbd
  extends Handler
{
  bkbd(bkbb parambkbb, Looper paramLooper)
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
      } while ((paramMessage.what != 1000) || (!bkbb.a(this.a).jdField_a_of_type_Boolean));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.a.jdField_a_of_type_Long) / (1000.0F / bkbb.a(this.a).jdField_a_of_type_Int));
      int i;
      if ((bkbb.a(this.a)) && (bkbb.a(this.a).jdField_a_of_type_Bkbh.a() != 0)) {
        i = k % bkbb.a(this.a).jdField_a_of_type_Bkbh.a();
      }
      for (;;)
      {
        bkbb.a(this.a).jdField_a_of_type_Bkbh.a(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / bkbb.a(this.a).jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.a.invalidateSelf();
        return;
        i = k;
        if (k >= bkbb.a(this.a).jdField_a_of_type_Bkbh.a())
        {
          j = 1;
          i = k;
        }
      }
      this.a.stop();
      this.a.invalidateSelf();
    } while (this.a.jdField_a_of_type_Bkbe == null);
    this.a.jdField_a_of_type_Bkbe.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbd
 * JD-Core Version:    0.7.0.1
 */