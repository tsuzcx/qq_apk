import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import java.util.Locale;

class bbqt
  implements MessageQueue.IdleHandler
{
  bbqt(bbqq parambbqq) {}
  
  public boolean queueIdle()
  {
    AIOFilePictureData localAIOFilePictureData = this.a.a.a();
    if (localAIOFilePictureData != null)
    {
      bbpj localbbpj = new bbpj();
      if ((localbbpj.a(localAIOFilePictureData, 20)) && (localbbpj.a(localAIOFilePictureData, 20) == null))
      {
        if ((!localAIOFilePictureData.g) || (!bhnt.a(localAIOFilePictureData.d))) {
          break label116;
        }
        this.a.f(true);
        this.a.updateUI();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.mContext.getString(2131694456), new Object[] { auog.a(localAIOFilePictureData.e) }));
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
 * Qualified Name:     bbqt
 * JD-Core Version:    0.7.0.1
 */