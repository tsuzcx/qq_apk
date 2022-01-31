import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import java.util.Locale;

class axvj
  implements MessageQueue.IdleHandler
{
  axvj(axvg paramaxvg) {}
  
  public boolean queueIdle()
  {
    AIOFilePictureData localAIOFilePictureData = this.a.a.a();
    if (localAIOFilePictureData != null)
    {
      axua localaxua = new axua();
      if ((localaxua.a(localAIOFilePictureData, 20)) && (localaxua.a(localAIOFilePictureData, 20) == null))
      {
        if ((!localAIOFilePictureData.g) || (!bdec.a(localAIOFilePictureData.d))) {
          break label116;
        }
        this.a.e(true);
        this.a.updateUI();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.mContext.getString(2131695500), new Object[] { arof.a(localAIOFilePictureData.e) }));
      return false;
      label116:
      if (localAIOFilePictureData.h) {
        this.a.e(false);
      } else {
        this.a.e(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvj
 * JD-Core Version:    0.7.0.1
 */