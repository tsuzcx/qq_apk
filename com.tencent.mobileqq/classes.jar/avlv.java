import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class avlv
  extends bhyn
{
  public avlv(String paramString) {}
  
  public void onDone(bhyo parambhyo)
  {
    PayLikeFloatViewBuilder.a(false);
    if (parambhyo.a == 0)
    {
      parambhyo = new File(this.a + ".tmp");
      if (parambhyo.exists()) {
        parambhyo.renameTo(new File(this.a));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlv
 * JD-Core Version:    0.7.0.1
 */