import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

class azlm
  implements Handler.Callback
{
  azlm(azlk paramazlk) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
      if (azlk.a(this.a) == null)
      {
        View localView = azlk.a(this.a, azlk.b(this.a), 5, 0, 5, 0);
        azlk.a(this.a, new RedTouch(azlk.a(this.a), localView).a(53).d(5).a());
      }
      azlk.a(this.a).a(paramMessage);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlm
 * JD-Core Version:    0.7.0.1
 */