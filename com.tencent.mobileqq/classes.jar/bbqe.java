import android.os.Handler;
import android.os.Message;

class bbqe
  extends Handler
{
  bbqe(bbqd parambbqd) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == bbqd.j) && (bbqd.e == this.a.k)) {
      bbqd.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqe
 * JD-Core Version:    0.7.0.1
 */