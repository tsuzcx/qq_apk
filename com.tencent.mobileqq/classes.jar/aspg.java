import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class aspg
  extends bdvu
{
  public aspg(String paramString) {}
  
  public void onDone(bdvv parambdvv)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambdvv.a == 0)
    {
      parambdvv = new File(this.a + ".tmp");
      if (parambdvv.exists()) {
        parambdvv.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspg
 * JD-Core Version:    0.7.0.1
 */