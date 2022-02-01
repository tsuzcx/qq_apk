import android.os.Handler;
import android.os.Message;

class bjbi
  extends Handler
{
  public int a;
  
  bjbi(bjbh parambjbh) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Bjbh.isVisible())
    {
      this.jdField_a_of_type_Bjbh.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Bjbh.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Bjbh.c(this.jdField_a_of_type_Bjbh.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bjbh.e);
      return;
    }
    if (this.jdField_a_of_type_Bjbh.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Bjbh.b + this.jdField_a_of_type_Bjbh.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Bjbh.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bjbh.e);
        return;
        this.jdField_a_of_type_Bjbh.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbi
 * JD-Core Version:    0.7.0.1
 */