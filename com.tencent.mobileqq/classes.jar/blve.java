import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class blve
  extends Handler
{
  private WeakReference<QQAppInterface> a;
  
  public blve(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  private void a(Message paramMessage)
  {
    if (this.a == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      QLog.i("IliveGroupTipsBarHelper", 1, "getGroupTipsData");
      localQQAppInterface = (QQAppInterface)this.a.get();
    } while ((localQQAppInterface == null) || ((paramMessage.obj == null) && (!(paramMessage.obj instanceof blvg))));
    paramMessage = (blvg)paramMessage.obj;
    ((blvf)localQQAppInterface.getManager(QQManagerFactory.ILIVE_GROUP_TIPS_MANAGER)).a(String.valueOf(paramMessage.c), paramMessage.e, blvf.c);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blve
 * JD-Core Version:    0.7.0.1
 */