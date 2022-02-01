import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aoes
  extends Handler
{
  public aoes(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 990)
    {
      paramMessage = new ArrayList();
      synchronized (QQAppInterface.a(this.a))
      {
        paramMessage.addAll(QQAppInterface.a(this.a));
        QQAppInterface.a(this.a).clear();
        QQAppInterface.a(this.a).removeMessages(990);
        ??? = new ArrayList();
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          break label138;
        }
        i = 0;
        if (i < paramMessage.size())
        {
          ???.add(this.a.a(1, (String)paramMessage.get(i), 0));
          i += 1;
        }
      }
      QQAppInterface.a(this.a, 1, paramMessage, ???);
      label138:
      if (QLog.isColorLevel()) {
        bhrl.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, user getQQHead resp uinList: ", paramMessage);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramMessage.what != 991) {
              break;
            }
            paramMessage = new ArrayList();
            synchronized (QQAppInterface.b(this.a))
            {
              paramMessage.addAll(QQAppInterface.b(this.a));
              QQAppInterface.b(this.a).clear();
              QQAppInterface.a(this.a).removeMessages(991);
              ??? = new ArrayList();
              if ((paramMessage == null) || (paramMessage.size() <= 0)) {
                continue;
              }
              i = 0;
              if (i < paramMessage.size())
              {
                ???.add(this.a.a(4, (String)paramMessage.get(i), 0));
                i += 1;
              }
            }
            QQAppInterface.a(this.a, 4, paramMessage, ???);
          } while (!QLog.isColorLevel());
          bhrl.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, group getQQHead resp uinList: ", paramMessage);
          return;
          if (paramMessage.what != 993) {
            break;
          }
          paramMessage = new ArrayList();
          synchronized (QQAppInterface.c(this.a))
          {
            paramMessage.addAll(QQAppInterface.c(this.a));
            QQAppInterface.c(this.a).clear();
            QQAppInterface.a(this.a).removeMessages(993);
            ??? = new ArrayList();
            if ((paramMessage == null) || (paramMessage.size() <= 0)) {
              continue;
            }
            i = 0;
            if (i < paramMessage.size())
            {
              ???.add(this.a.a(101, (String)paramMessage.get(i), 0));
              i += 1;
            }
          }
          QQAppInterface.a(this.a, 101, paramMessage, ???);
        } while (!QLog.isColorLevel());
        bhrl.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, dis getQQHead resp uinList: ", paramMessage);
        return;
      } while (paramMessage.what != 992);
      paramMessage = new ArrayList();
      synchronized (QQAppInterface.d(this.a))
      {
        paramMessage.addAll(QQAppInterface.d(this.a));
        QQAppInterface.d(this.a).clear();
        QQAppInterface.a(this.a).removeMessages(992);
        ??? = new ArrayList();
        if ((paramMessage == null) || (paramMessage.size() <= 0)) {
          continue;
        }
        i = 0;
        if (i < paramMessage.size())
        {
          ???.add(this.a.a(113, (String)paramMessage.get(i), 0));
          i += 1;
        }
      }
      QQAppInterface.a(this.a, 113, paramMessage, ???);
    } while (!QLog.isColorLevel());
    bhrl.a("Q.qqhead.broadcast", 2, "headQQHeadBroadcast, newGroup getQQHead resp uinList: ", paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoes
 * JD-Core Version:    0.7.0.1
 */