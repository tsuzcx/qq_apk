import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bgmd
  extends Handler
{
  bgmd(bgmb parambgmb, Looper paramLooper)
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
      } while ((paramMessage.what != 1000) || (!bgmb.a(this.a).jdField_a_of_type_Boolean));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.a.jdField_a_of_type_Long) / (1000.0F / bgmb.a(this.a).jdField_a_of_type_Int));
      int i;
      if ((bgmb.a(this.a)) && (bgmb.a(this.a).jdField_a_of_type_Bgmh.a() != 0)) {
        i = k % bgmb.a(this.a).jdField_a_of_type_Bgmh.a();
      }
      for (;;)
      {
        bgmb.a(this.a).jdField_a_of_type_Bgmh.a(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / bgmb.a(this.a).jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.a.invalidateSelf();
        return;
        i = k;
        if (k >= bgmb.a(this.a).jdField_a_of_type_Bgmh.a())
        {
          j = 1;
          i = k;
        }
      }
      this.a.stop();
      this.a.invalidateSelf();
    } while (this.a.jdField_a_of_type_Bgme == null);
    this.a.jdField_a_of_type_Bgme.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmd
 * JD-Core Version:    0.7.0.1
 */