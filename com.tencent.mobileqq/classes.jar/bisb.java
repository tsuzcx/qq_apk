import android.os.Handler;
import android.os.Message;

class bisb
  extends Handler
{
  public int a;
  
  bisb(bisa parambisa) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Bisa.isVisible())
    {
      this.jdField_a_of_type_Bisa.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Bisa.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Bisa.c(this.jdField_a_of_type_Bisa.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bisa.e);
      return;
    }
    if (this.jdField_a_of_type_Bisa.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Bisa.b + this.jdField_a_of_type_Bisa.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Bisa.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bisa.e);
        return;
        this.jdField_a_of_type_Bisa.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bisb
 * JD-Core Version:    0.7.0.1
 */