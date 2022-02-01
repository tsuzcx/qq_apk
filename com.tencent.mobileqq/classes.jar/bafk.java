import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView;
import java.util.concurrent.atomic.AtomicBoolean;

public class bafk
  implements Handler.Callback
{
  public bafk(NeoVideoFilterPlayView paramNeoVideoFilterPlayView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (!NeoVideoFilterPlayView.a(this.a))
    {
      this.a.requestRender();
      return true;
    }
    NeoVideoFilterPlayView.a(this.a).set(true);
    xvv.b("FlowEdit_NeoVideoFilterPlayView", "skip request render because of pause play");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafk
 * JD-Core Version:    0.7.0.1
 */