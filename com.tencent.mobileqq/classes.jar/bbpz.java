import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class bbpz
  extends MqqHandler
{
  bbpz(bbpy parambbpy) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(bbpy.a(this.a).mContext, 2131718205, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bhmq.a(bbpy.a(this.a).mContext, paramMessage);
    QQToast.a(bbpy.a(this.a).mContext, 2, anzj.a(2131699057), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpz
 * JD-Core Version:    0.7.0.1
 */