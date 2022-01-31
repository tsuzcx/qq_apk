import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1;
import com.tencent.qphone.base.util.QLog;

public class apmz
  implements apll
{
  apmz(apmy paramapmy) {}
  
  public void a(int paramInt)
  {
    apna localapna = this.a.a(paramInt);
    if (localapna != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localapna.a.putBundle("response", localBundle);
      this.a.a(new WebIPCOperator.5.1(this, localapna));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmz
 * JD-Core Version:    0.7.0.1
 */