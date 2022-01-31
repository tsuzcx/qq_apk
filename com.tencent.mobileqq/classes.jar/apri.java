import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1;
import com.tencent.qphone.base.util.QLog;

public class apri
  implements appu
{
  apri(aprh paramaprh) {}
  
  public void a(int paramInt)
  {
    aprj localaprj = this.a.a(paramInt);
    if (localaprj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localaprj.a.putBundle("response", localBundle);
      this.a.a(new WebIPCOperator.5.1(this, localaprj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apri
 * JD-Core Version:    0.7.0.1
 */