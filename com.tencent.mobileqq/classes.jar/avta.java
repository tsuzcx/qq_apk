import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class avta
  extends biht
{
  public avta(String paramString) {}
  
  public void onDone(bihu parambihu)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambihu.a == 0)
    {
      parambihu = new File(this.a + ".tmp");
      if (parambihu.exists()) {
        parambihu.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avta
 * JD-Core Version:    0.7.0.1
 */