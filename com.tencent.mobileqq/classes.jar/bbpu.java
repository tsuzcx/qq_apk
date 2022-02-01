import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class bbpu
  extends MqqHandler
{
  bbpu(bbpt parambbpt) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a.mContext, 2131718205, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bhmq.a(this.a.a.mContext, paramMessage);
    QQToast.a(this.a.a.mContext, 2, anzj.a(2131698943), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpu
 * JD-Core Version:    0.7.0.1
 */