import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1;
import com.tencent.qphone.base.util.QLog;

public class ardv
  implements arch
{
  ardv(ardu paramardu) {}
  
  public void a(int paramInt)
  {
    ardw localardw = this.a.a(paramInt);
    if (localardw != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localardw.a.putBundle("response", localBundle);
      this.a.a(new WebIPCOperator.5.1(this, localardw));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardv
 * JD-Core Version:    0.7.0.1
 */