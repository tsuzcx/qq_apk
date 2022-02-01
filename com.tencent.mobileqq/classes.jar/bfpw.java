import android.os.Handler;
import android.os.Message;

class bfpw
  extends Handler
{
  bfpw(bfpv parambfpv) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == bfpv.j) && (bfpv.e == this.a.k)) {
      bfpv.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfpw
 * JD-Core Version:    0.7.0.1
 */