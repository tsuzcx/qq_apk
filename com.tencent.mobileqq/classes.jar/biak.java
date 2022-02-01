import android.os.Handler;
import android.os.Message;

class biak
  extends Handler
{
  public int a;
  
  biak(biaj parambiaj) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Biaj.isVisible())
    {
      this.jdField_a_of_type_Biaj.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Biaj.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Biaj.c(this.jdField_a_of_type_Biaj.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Biaj.e);
      return;
    }
    if (this.jdField_a_of_type_Biaj.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Biaj.b + this.jdField_a_of_type_Biaj.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Biaj.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Biaj.e);
        return;
        this.jdField_a_of_type_Biaj.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biak
 * JD-Core Version:    0.7.0.1
 */