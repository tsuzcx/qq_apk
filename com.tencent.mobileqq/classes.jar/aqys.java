import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class aqys
  extends bbwt
{
  public aqys(String paramString) {}
  
  public void onDone(bbwu parambbwu)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambbwu.a == 0)
    {
      parambbwu = new File(this.a + ".tmp");
      if (parambbwu.exists()) {
        parambbwu.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqys
 * JD-Core Version:    0.7.0.1
 */