import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

class bady
  implements Handler.Callback
{
  bady(badw parambadw) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
      if (badw.a(this.a) == null)
      {
        View localView = badw.a(this.a, badw.b(this.a), 5, 0, 5, 0);
        if (localView != null) {
          badw.a(this.a, new RedTouch(badw.a(this.a), localView).a(53).d(5).a());
        }
      }
      if (badw.a(this.a) != null) {
        badw.a(this.a).a(paramMessage);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bady
 * JD-Core Version:    0.7.0.1
 */