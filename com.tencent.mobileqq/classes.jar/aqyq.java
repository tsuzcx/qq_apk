import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class aqyq
  extends bbwf
{
  public aqyq(String paramString) {}
  
  public void onDone(bbwg parambbwg)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambbwg.a == 0)
    {
      parambbwg = new File(this.a + ".tmp");
      if (parambbwg.exists()) {
        parambbwg.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqyq
 * JD-Core Version:    0.7.0.1
 */