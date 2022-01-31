import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;

class bjpx
  implements bjon
{
  bjpx(bjpw parambjpw) {}
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = bjnx.a(paramFromServiceMsg.getWupBuffer());
      bjpw.a(this.a, paramIntent);
      bjpw.a(this.a, paramIntent, null);
      bjml.a().a(paramIntent);
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
      bjpw.a(this.a, null, null);
    } while (this.a.a == null);
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpx
 * JD-Core Version:    0.7.0.1
 */