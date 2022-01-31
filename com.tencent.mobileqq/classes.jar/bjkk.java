import android.os.Message;
import dov.com.qq.im.capture.view.MusicFragmentProviderView;

public class bjkk
  implements bjbu
{
  public bjkk(MusicFragmentProviderView paramMusicFragmentProviderView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjkk
 * JD-Core Version:    0.7.0.1
 */