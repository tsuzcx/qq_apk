import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.widget.QQToast;

class apoe
  implements Handler.Callback
{
  apoe(apod paramapod) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      QQToast.a(apod.a(this.a), 2131692914, 0).b(2131298914);
      return true;
    }
    if (paramMessage.obj != null)
    {
      paramMessage = (EmoticonFromGroupEntity)paramMessage.obj;
      this.a.a(paramMessage);
      return true;
    }
    QQToast.a(apod.a(this.a), 1, 2131689688, 0).b(2131298914);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apoe
 * JD-Core Version:    0.7.0.1
 */