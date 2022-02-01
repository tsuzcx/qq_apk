import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class bbqj
  extends MqqHandler
{
  bbqj(bbqi parambbqi) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(bbqi.a(this.a).mContext, 2131718832, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bheg.a(bbqi.a(this.a).mContext, paramMessage);
    QQToast.a(bbqi.a(this.a).mContext, 2, anvx.a(2131699643), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqj
 * JD-Core Version:    0.7.0.1
 */