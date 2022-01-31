import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;

class axvt
  implements MessageQueue.IdleHandler
{
  axvt(axvr paramaxvr) {}
  
  public boolean queueIdle()
  {
    AIOPictureData localAIOPictureData = this.a.a();
    axue localaxue = new axue();
    if ((localAIOPictureData != null) && (localaxue.a(localAIOPictureData, 4)) && (localaxue.a(localAIOPictureData, 4) == null))
    {
      this.a.e(true);
      this.a.updateUI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvt
 * JD-Core Version:    0.7.0.1
 */