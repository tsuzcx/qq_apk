import android.os.Handler;
import android.os.Message;

class bbmi
  extends Handler
{
  public int a;
  
  bbmi(bbmh parambbmh) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Bbmh.isVisible())
    {
      this.jdField_a_of_type_Bbmh.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Bbmh.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Bbmh.c(this.jdField_a_of_type_Bbmh.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bbmh.e);
      return;
    }
    if (this.jdField_a_of_type_Bbmh.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Bbmh.b + this.jdField_a_of_type_Bbmh.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Bbmh.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bbmh.e);
        return;
        this.jdField_a_of_type_Bbmh.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbmi
 * JD-Core Version:    0.7.0.1
 */