import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.WebIPCOperator.5.1;
import com.tencent.qphone.base.util.QLog;

public class anvr
  implements anud
{
  anvr(anvq paramanvq) {}
  
  public void a(int paramInt)
  {
    anvs localanvs = this.a.a(paramInt);
    if (localanvs != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localanvs.a.putBundle("response", localBundle);
      this.a.a(new WebIPCOperator.5.1(this, localanvs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anvr
 * JD-Core Version:    0.7.0.1
 */