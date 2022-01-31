import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1;
import com.tencent.qphone.base.util.QLog;

public class anfd
  implements andq
{
  anfd(anfc paramanfc) {}
  
  public void a(int paramInt)
  {
    anfe localanfe = this.a.a(paramInt);
    if (localanfe != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localanfe.a.putBundle("response", localBundle);
      this.a.a(new WebIPCOperator.5.1(this, localanfe));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anfd
 * JD-Core Version:    0.7.0.1
 */