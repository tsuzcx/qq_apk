import android.os.Handler;
import android.os.Message;

class beto
  extends Handler
{
  public int a;
  
  beto(betn parambetn) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Betn.isVisible())
    {
      this.jdField_a_of_type_Betn.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Betn.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Betn.c(this.jdField_a_of_type_Betn.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Betn.e);
      return;
    }
    if (this.jdField_a_of_type_Betn.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Betn.b + this.jdField_a_of_type_Betn.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Betn.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Betn.e);
        return;
        this.jdField_a_of_type_Betn.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beto
 * JD-Core Version:    0.7.0.1
 */