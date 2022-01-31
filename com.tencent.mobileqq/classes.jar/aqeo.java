import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class aqeo
  extends batl
{
  public aqeo(String paramString) {}
  
  public void onDone(batm parambatm)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambatm.a == 0)
    {
      parambatm = new File(this.a + ".tmp");
      if (parambatm.exists()) {
        parambatm.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqeo
 * JD-Core Version:    0.7.0.1
 */