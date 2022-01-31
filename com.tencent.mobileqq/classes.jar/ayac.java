import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;

class ayac
  implements MessageQueue.IdleHandler
{
  ayac(ayaa paramayaa) {}
  
  public boolean queueIdle()
  {
    AIOPictureData localAIOPictureData = this.a.a();
    axyn localaxyn = new axyn();
    if ((localAIOPictureData != null) && (localaxyn.a(localAIOPictureData, 4)) && (localaxyn.a(localAIOPictureData, 4) == null))
    {
      this.a.e(true);
      this.a.updateUI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayac
 * JD-Core Version:    0.7.0.1
 */