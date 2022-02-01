import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

class aysn
  implements Handler.Callback
{
  aysn(aysl paramaysl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
      if (aysl.a(this.a) == null)
      {
        View localView = aysl.a(this.a, aysl.b(this.a), 5, 0, 5, 0);
        if (localView != null) {
          aysl.a(this.a, new RedTouch(aysl.a(this.a), localView).a(53).d(5).a());
        }
      }
      if (aysl.a(this.a) != null) {
        aysl.a(this.a).a(paramMessage);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysn
 * JD-Core Version:    0.7.0.1
 */