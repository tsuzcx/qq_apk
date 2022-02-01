import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class baxg
  extends MqqHandler
{
  baxg(baxf parambaxf) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(baxf.a(this.a).mContext, 2131718072, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bgmo.a(baxf.a(this.a).mContext, paramMessage);
    QQToast.a(baxf.a(this.a).mContext, 2, anni.a(2131698950), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxg
 * JD-Core Version:    0.7.0.1
 */