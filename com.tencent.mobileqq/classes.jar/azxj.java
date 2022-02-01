import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

class azxj
  implements Handler.Callback
{
  azxj(azxh paramazxh) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
      if (azxh.a(this.a) == null)
      {
        View localView = azxh.a(this.a, azxh.b(this.a), 5, 0, 5, 0);
        if (localView != null) {
          azxh.a(this.a, new RedTouch(azxh.a(this.a), localView).b(53).e(5).a());
        }
      }
      if (azxh.a(this.a) != null) {
        azxh.a(this.a).a(paramMessage);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxj
 * JD-Core Version:    0.7.0.1
 */