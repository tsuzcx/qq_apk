import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class axuq
  extends MqqHandler
{
  axuq(axup paramaxup) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(axup.a(this.a).mContext, 2131720097, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bdda.a(axup.a(this.a).mContext, paramMessage);
    QQToast.a(axup.a(this.a).mContext, 2, alpo.a(2131700512), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axuq
 * JD-Core Version:    0.7.0.1
 */