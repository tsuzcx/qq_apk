import android.os.Handler;
import android.os.Message;

class bhhj
  extends Handler
{
  public int a;
  
  bhhj(bhhi parambhhi) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Bhhi.isVisible())
    {
      this.jdField_a_of_type_Bhhi.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Bhhi.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Bhhi.c(this.jdField_a_of_type_Bhhi.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bhhi.e);
      return;
    }
    if (this.jdField_a_of_type_Bhhi.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Bhhi.b + this.jdField_a_of_type_Bhhi.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Bhhi.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bhhi.e);
        return;
        this.jdField_a_of_type_Bhhi.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhj
 * JD-Core Version:    0.7.0.1
 */