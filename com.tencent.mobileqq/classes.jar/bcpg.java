import android.os.Handler;
import android.os.Message;

class bcpg
  extends Handler
{
  public int a;
  
  bcpg(bcpf parambcpf) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.jdField_a_of_type_Bcpf.isVisible())
    {
      this.jdField_a_of_type_Bcpf.b = this.jdField_a_of_type_Int;
      return;
    }
    if (this.jdField_a_of_type_Bcpf.b > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Bcpf.c(this.jdField_a_of_type_Bcpf.b - 1);
      sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bcpf.e);
      return;
    }
    if (this.jdField_a_of_type_Bcpf.b < this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Bcpf.b + this.jdField_a_of_type_Bcpf.f;
      if (i <= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Bcpf.c(i);
      }
      for (;;)
      {
        sendEmptyMessageDelayed(0, this.jdField_a_of_type_Bcpf.e);
        return;
        this.jdField_a_of_type_Bcpf.c(this.jdField_a_of_type_Int);
      }
    }
    removeMessages(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcpg
 * JD-Core Version:    0.7.0.1
 */