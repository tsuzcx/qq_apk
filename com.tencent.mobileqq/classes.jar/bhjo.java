import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;

class bhjo
  implements bhie
{
  bhjo(bhjn parambhjn) {}
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = bhho.a(paramFromServiceMsg.getWupBuffer());
      bhjn.a(this.a, paramIntent);
      bhjn.a(this.a, paramIntent, null);
      bhgc.a().a(paramIntent);
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
      bhjn.a(this.a, null, null);
    } while (this.a.a == null);
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhjo
 * JD-Core Version:    0.7.0.1
 */