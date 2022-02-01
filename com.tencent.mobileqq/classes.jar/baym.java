import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;

class baym
  implements MessageQueue.IdleHandler
{
  baym(bayi parambayi) {}
  
  public boolean queueIdle()
  {
    AIOPictureData localAIOPictureData = this.a.a();
    bawu localbawu = new bawu();
    if ((localAIOPictureData != null) && (localbawu.a(localAIOPictureData, 4)) && (localbawu.a(localAIOPictureData, 4) == null))
    {
      this.a.f(true);
      this.a.updateUI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baym
 * JD-Core Version:    0.7.0.1
 */