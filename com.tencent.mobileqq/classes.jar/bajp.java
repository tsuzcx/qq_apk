import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class bajp
  extends MqqHandler
{
  bajp(bajo parambajo) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a.mContext, 2131718446, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bfvo.a(this.a.a.mContext, paramMessage);
    QQToast.a(this.a.a.mContext, 2, amtj.a(2131699178), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajp
 * JD-Core Version:    0.7.0.1
 */