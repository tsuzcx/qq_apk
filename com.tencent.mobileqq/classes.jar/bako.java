import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import java.util.Locale;

class bako
  implements MessageQueue.IdleHandler
{
  bako(bakl parambakl) {}
  
  public boolean queueIdle()
  {
    AIOFilePictureData localAIOFilePictureData = this.a.a.a();
    if (localAIOFilePictureData != null)
    {
      baje localbaje = new baje();
      if ((localbaje.a(localAIOFilePictureData, 20)) && (localbaje.a(localAIOFilePictureData, 20) == null))
      {
        if ((!localAIOFilePictureData.g) || (!bfwr.a(localAIOFilePictureData.d))) {
          break label116;
        }
        this.a.f(true);
        this.a.updateUI();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.mContext.getString(2131694570), new Object[] { FileUtil.filesizeToString(localAIOFilePictureData.e) }));
      return false;
      label116:
      if (localAIOFilePictureData.h) {
        this.a.f(false);
      } else {
        this.a.f(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bako
 * JD-Core Version:    0.7.0.1
 */