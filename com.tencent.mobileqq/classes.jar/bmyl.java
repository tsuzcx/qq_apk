import android.os.Message;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;

public class bmyl
  implements bmrk
{
  public bmyl(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    Message localMessage;
    if (this.a.a != null)
    {
      localMessage = this.a.a.obtainMessage();
      if (!paramBoolean) {
        break label61;
      }
    }
    label61:
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      localMessage.obj = paramObject;
      localMessage.what = 7;
      this.a.a.sendMessage(localMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyl
 * JD-Core Version:    0.7.0.1
 */