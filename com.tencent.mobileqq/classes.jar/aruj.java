import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1;
import com.tencent.qphone.base.util.QLog;

public class aruj
  implements arsv
{
  aruj(arui paramarui) {}
  
  public void a(int paramInt)
  {
    aruk localaruk = this.a.a(paramInt);
    if (localaruk != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localaruk.a.putBundle("response", localBundle);
      this.a.a(new WebIPCOperator.5.1(this, localaruk));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruj
 * JD-Core Version:    0.7.0.1
 */