import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import java.util.Locale;

class baya
  implements MessageQueue.IdleHandler
{
  baya(baxx parambaxx) {}
  
  public boolean queueIdle()
  {
    AIOFilePictureData localAIOFilePictureData = this.a.a.a();
    if (localAIOFilePictureData != null)
    {
      bawq localbawq = new bawq();
      if ((localbawq.a(localAIOFilePictureData, 20)) && (localbawq.a(localAIOFilePictureData, 20) == null))
      {
        if ((!localAIOFilePictureData.g) || (!bgnr.a(localAIOFilePictureData.d))) {
          break label116;
        }
        this.a.f(true);
        this.a.updateUI();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.mContext.getString(2131694414), new Object[] { atwl.a(localAIOFilePictureData.e) }));
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
 * Qualified Name:     baya
 * JD-Core Version:    0.7.0.1
 */