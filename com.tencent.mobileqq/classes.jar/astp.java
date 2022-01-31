import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class astp
  extends bead
{
  public astp(String paramString) {}
  
  public void onDone(beae parambeae)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambeae.a == 0)
    {
      parambeae = new File(this.a + ".tmp");
      if (parambeae.exists()) {
        parambeae.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astp
 * JD-Core Version:    0.7.0.1
 */