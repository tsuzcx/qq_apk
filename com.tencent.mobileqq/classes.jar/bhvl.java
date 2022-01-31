import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

class bhvl
  extends Handler
{
  bhvl(bhvj parambhvj, Looper paramLooper)
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
      } while ((paramMessage.what != 1000) || (!bhvj.a(this.a).jdField_a_of_type_Boolean));
      int k = (int)((float)(SystemClock.uptimeMillis() - this.a.jdField_a_of_type_Long) / (1000.0F / bhvj.a(this.a).jdField_a_of_type_Int));
      int i;
      if ((bhvj.a(this.a)) && (bhvj.a(this.a).jdField_a_of_type_Bhvp.a() != 0)) {
        i = k % bhvj.a(this.a).jdField_a_of_type_Bhvp.a();
      }
      for (;;)
      {
        bhvj.a(this.a).jdField_a_of_type_Bhvp.a(i);
        if (j != 0) {
          break;
        }
        long l = 1000 / bhvj.a(this.a).jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, (int)l);
        this.a.invalidateSelf();
        return;
        i = k;
        if (k >= bhvj.a(this.a).jdField_a_of_type_Bhvp.a())
        {
          j = 1;
          i = k;
        }
      }
      this.a.stop();
      this.a.invalidateSelf();
    } while (this.a.jdField_a_of_type_Bhvm == null);
    this.a.jdField_a_of_type_Bhvm.onAnimationFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhvl
 * JD-Core Version:    0.7.0.1
 */