import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import java.util.Locale;

class axzs
  implements MessageQueue.IdleHandler
{
  axzs(axzp paramaxzp) {}
  
  public boolean queueIdle()
  {
    AIOFilePictureData localAIOFilePictureData = this.a.a.a();
    if (localAIOFilePictureData != null)
    {
      axyj localaxyj = new axyj();
      if ((localaxyj.a(localAIOFilePictureData, 20)) && (localaxyj.a(localAIOFilePictureData, 20) == null))
      {
        if ((!localAIOFilePictureData.g) || (!bdil.a(localAIOFilePictureData.d))) {
          break label116;
        }
        this.a.e(true);
        this.a.updateUI();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.mContext.getString(2131695502), new Object[] { arso.a(localAIOFilePictureData.e) }));
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
 * Qualified Name:     axzs
 * JD-Core Version:    0.7.0.1
 */