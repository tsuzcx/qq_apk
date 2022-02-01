import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.widget.QQToast;

class asfb
  implements Handler.Callback
{
  asfb(asfa paramasfa) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      QQToast.a(asfa.a(this.a), 2131692595, 0).b(2131299080);
      return true;
    }
    if (paramMessage.obj != null)
    {
      paramMessage = (EmoticonFromGroupEntity)paramMessage.obj;
      this.a.a(paramMessage);
      return true;
    }
    QQToast.a(asfa.a(this.a), 1, 2131689607, 0).b(2131299080);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfb
 * JD-Core Version:    0.7.0.1
 */