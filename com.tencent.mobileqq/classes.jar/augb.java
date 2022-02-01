import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class augb
  extends bgod
{
  public augb(String paramString) {}
  
  public void onDone(bgoe parambgoe)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambgoe.a == 0)
    {
      parambgoe = new File(this.a + ".tmp");
      if (parambgoe.exists()) {
        parambgoe.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augb
 * JD-Core Version:    0.7.0.1
 */