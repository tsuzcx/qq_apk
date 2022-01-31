import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class axyz
  extends MqqHandler
{
  axyz(axyy paramaxyy) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(axyy.a(this.a).mContext, 2131720109, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bdhj.a(axyy.a(this.a).mContext, paramMessage);
    QQToast.a(axyy.a(this.a).mContext, 2, alud.a(2131700524), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyz
 * JD-Core Version:    0.7.0.1
 */