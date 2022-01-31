import android.os.Handler;
import android.os.Message;

class bcpv
  extends Handler
{
  public int a;
  
  bcpv(bcpu parambcpu) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Bcpu.isVisible())
    {
      this.jdField_a_of_type_Bcpu.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Bcpu.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Bcpu.c(this.jdField_a_of_type_Bcpu.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bcpu.e);
      return;
    }
    if (this.jdField_a_of_type_Bcpu.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Bcpu.b + this.jdField_a_of_type_Bcpu.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Bcpu.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bcpu.e);
        return;
        this.jdField_a_of_type_Bcpu.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcpv
 * JD-Core Version:    0.7.0.1
 */