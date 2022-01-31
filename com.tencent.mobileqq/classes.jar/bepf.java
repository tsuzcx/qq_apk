import android.os.Handler;
import android.os.Message;

class bepf
  extends Handler
{
  public int a;
  
  bepf(bepe parambepe) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Bepe.isVisible())
    {
      this.jdField_a_of_type_Bepe.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Bepe.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Bepe.c(this.jdField_a_of_type_Bepe.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bepe.e);
      return;
    }
    if (this.jdField_a_of_type_Bepe.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Bepe.b + this.jdField_a_of_type_Bepe.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Bepe.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bepe.e);
        return;
        this.jdField_a_of_type_Bepe.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepf
 * JD-Core Version:    0.7.0.1
 */