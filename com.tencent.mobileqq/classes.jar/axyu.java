import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class axyu
  extends MqqHandler
{
  axyu(axyt paramaxyt) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a.mContext, 2131720109, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bdhj.a(this.a.a.mContext, paramMessage);
    QQToast.a(this.a.a.mContext, 2, alud.a(2131700410), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyu
 * JD-Core Version:    0.7.0.1
 */