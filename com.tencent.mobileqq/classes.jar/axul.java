import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class axul
  extends MqqHandler
{
  axul(axuk paramaxuk) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a.mContext, 2131720097, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bdda.a(this.a.a.mContext, paramMessage);
    QQToast.a(this.a.a.mContext, 2, alpo.a(2131700398), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axul
 * JD-Core Version:    0.7.0.1
 */