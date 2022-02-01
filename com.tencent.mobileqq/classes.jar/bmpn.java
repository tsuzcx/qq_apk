import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bmpn
  extends Handler
{
  bmpn(bmpl parambmpl, Looper paramLooper)
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
      } while ((paramMessage.what != 1000) || (!bmpl.a(this.a).jdField_a_of_type_Boolean) || (!bmpl.a(this.a)));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.a.jdField_a_of_type_Long) / (1000.0F / bmpl.a(this.a).jdField_a_of_type_Int));
      int i;
      if ((bmpl.b(this.a)) && (bmpl.a(this.a).jdField_a_of_type_Bmpr.a() != 0)) {
        i = k % bmpl.a(this.a).jdField_a_of_type_Bmpr.a();
      }
      for (;;)
      {
        bmpl.a(this.a).jdField_a_of_type_Bmpr.a(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / bmpl.a(this.a).jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.a.invalidateSelf();
        return;
        i = k;
        if (k >= bmpl.a(this.a).jdField_a_of_type_Bmpr.a())
        {
          j = 1;
          i = k;
        }
      }
      this.a.stop();
      this.a.invalidateSelf();
    } while (this.a.jdField_a_of_type_Bmpo == null);
    this.a.jdField_a_of_type_Bmpo.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmpn
 * JD-Core Version:    0.7.0.1
 */