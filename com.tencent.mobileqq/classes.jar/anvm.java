import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1;
import com.tencent.qphone.base.util.QLog;

public class anvm
  implements anty
{
  anvm(anvl paramanvl) {}
  
  public void a(int paramInt)
  {
    anvn localanvn = this.a.a(paramInt);
    if (localanvn != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localanvn.a.putBundle("response", localBundle);
      this.a.a(new WebIPCOperator.5.1(this, localanvn));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvm
 * JD-Core Version:    0.7.0.1
 */