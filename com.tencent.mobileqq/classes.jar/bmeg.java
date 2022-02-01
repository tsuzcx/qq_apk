import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;

class bmeg
  implements bmcw
{
  bmeg(bmef parambmef) {}
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = bmcg.a(paramFromServiceMsg.getWupBuffer());
      bmef.a(this.a, paramIntent);
      bmef.a(this.a, paramIntent, null);
      bmau.a().a(paramIntent);
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
      bmef.a(this.a, null, null);
    } while (this.a.a == null);
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeg
 * JD-Core Version:    0.7.0.1
 */