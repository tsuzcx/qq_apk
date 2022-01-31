import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;

class bjlq
  implements bjkg
{
  bjlq(bjlp parambjlp) {}
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = bjjq.a(paramFromServiceMsg.getWupBuffer());
      bjlp.a(this.a, paramIntent);
      bjlp.a(this.a, paramIntent, null);
      bjie.a().a(paramIntent);
      if (this.a.a != null)
      {
        paramFromServiceMsg = this.a.a;
        if (paramIntent != null) {
          bool = true;
        }
        paramFromServiceMsg.a(bool);
      }
    }
    do
    {
      return;
      bjlp.a(this.a, null, null);
    } while (this.a.a == null);
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjlq
 * JD-Core Version:    0.7.0.1
 */