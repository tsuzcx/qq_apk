import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class avay
  extends bhhe
{
  public avay(String paramString) {}
  
  public void onDone(bhhf parambhhf)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambhhf.a == 0)
    {
      parambhhf = new File(this.a + ".tmp");
      if (parambhhf.exists()) {
        parambhhf.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avay
 * JD-Core Version:    0.7.0.1
 */