import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;

class bgbd
  implements bfzt
{
  bgbd(bgbc parambgbc) {}
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = bfzd.a(paramFromServiceMsg.getWupBuffer());
      bgbc.a(this.a, paramIntent);
      bgbc.a(this.a, paramIntent, null);
      bfxr.a().a(paramIntent);
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
      bgbc.a(this.a, null, null);
    } while (this.a.a == null);
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgbd
 * JD-Core Version:    0.7.0.1
 */