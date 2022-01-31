import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bhuu
  extends Handler
{
  bhuu(bhus parambhus, Looper paramLooper)
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
      } while ((paramMessage.what != 1000) || (!bhus.a(this.a).jdField_a_of_type_Boolean));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.a.jdField_a_of_type_Long) / (1000.0F / bhus.a(this.a).jdField_a_of_type_Int));
      int i;
      if ((bhus.a(this.a)) && (bhus.a(this.a).jdField_a_of_type_Bhuy.a() != 0)) {
        i = k % bhus.a(this.a).jdField_a_of_type_Bhuy.a();
      }
      for (;;)
      {
        bhus.a(this.a).jdField_a_of_type_Bhuy.a(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / bhus.a(this.a).jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.a.invalidateSelf();
        return;
        i = k;
        if (k >= bhus.a(this.a).jdField_a_of_type_Bhuy.a())
        {
          j = 1;
          i = k;
        }
      }
      this.a.stop();
      this.a.invalidateSelf();
    } while (this.a.jdField_a_of_type_Bhuv == null);
    this.a.jdField_a_of_type_Bhuv.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuu
 * JD-Core Version:    0.7.0.1
 */