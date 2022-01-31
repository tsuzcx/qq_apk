import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class amjq
  extends Handler
{
  public static int a;
  public static long a;
  private amjf a;
  private long b;
  private long c;
  private long d;
  
  static
  {
    jdField_a_of_type_Int = -1000;
  }
  
  public amjq(Looper paramLooper, QQAppInterface paramQQAppInterface, amjf paramamjf)
  {
    super(paramLooper);
    this.jdField_a_of_type_Amjf = paramamjf;
    this.b = System.currentTimeMillis();
  }
  
  public void a()
  {
    removeCallbacksAndMessages(null);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ThreadRegulator.a().b();
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    jdField_a_of_type_Int = Process.myTid();
    jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis();
    long l2 = System.currentTimeMillis();
    long l3 = SystemClock.currentThreadTimeMillis();
    Object localObject1 = (amjm)paramMessage.obj;
    label266:
    boolean bool;
    do
    {
      for (;;)
      {
        try
        {
          int i = paramMessage.what;
          switch (i)
          {
          default: 
            this.d += SystemClock.currentThreadTimeMillis() - l3;
            this.c += System.currentTimeMillis() - l2;
            if (System.currentTimeMillis() - this.b > 300000L)
            {
              paramMessage = new StringBuilder(100);
              paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
              paramMessage.append("cpu:").append(this.d).append(" - wall:").append(this.c).append(" ");
              localObject1 = (amjn)this.jdField_a_of_type_Amjf.a(1);
              if (localObject1 != null) {
                paramMessage.append(((amjn)localObject1).a());
              }
              localObject1 = (amjr)this.jdField_a_of_type_Amjf.a(2);
              if (localObject1 != null) {
                paramMessage.append(((amjr)localObject1).a()).append("\n");
              }
              QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
              this.d = 0L;
              this.c = 0L;
              this.b = System.currentTimeMillis();
            }
            return;
          }
        }
        finally
        {
          l1 = this.d;
          this.d = (SystemClock.currentThreadTimeMillis() - l3 + l1);
          l1 = this.c;
          this.c = (System.currentTimeMillis() - l2 + l1);
          if (System.currentTimeMillis() - this.b <= 300000L) {
            continue;
          }
          localObject1 = new StringBuilder(100);
          ((StringBuilder)localObject1).append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
          ((StringBuilder)localObject1).append("cpu:").append(this.d).append(" - wall:").append(this.c).append(" ");
          Object localObject2 = (amjn)this.jdField_a_of_type_Amjf.a(1);
          if (localObject2 == null) {
            continue;
          }
          ((StringBuilder)localObject1).append(((amjn)localObject2).a());
          localObject2 = (amjr)this.jdField_a_of_type_Amjf.a(2);
          if (localObject2 == null) {
            continue;
          }
          ((StringBuilder)localObject1).append(((amjr)localObject2).a()).append("\n");
          QLog.d("Q.fts.BgCpu.Total", 1, ((StringBuilder)localObject1).toString());
          this.d = 0L;
          this.c = 0L;
          this.b = System.currentTimeMillis();
        }
        if (((amjm)localObject1).c()) {
          sendMessageDelayed(obtainMessage(2, localObject1), 30000L);
        } else if (QLog.isColorLevel()) {
          QLog.w("Q.fts.sync_worker", 2, "readSyncedCursor is false!!");
        }
      }
      removeMessages(2, localObject1);
      if (((amjm)localObject1).d()) {
        ((amjm)localObject1).e();
      }
      bool = this.jdField_a_of_type_Amjf.b;
      if (!bool) {
        break;
      }
      this.d += SystemClock.currentThreadTimeMillis() - l3;
      this.c += System.currentTimeMillis() - l2;
    } while (System.currentTimeMillis() - this.b <= 300000L);
    paramMessage = new StringBuilder(100);
    paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
    paramMessage.append("cpu:").append(this.d).append(" - wall:").append(this.c).append(" ");
    localObject1 = (amjn)this.jdField_a_of_type_Amjf.a(1);
    if (localObject1 != null) {
      paramMessage.append(((amjn)localObject1).a());
    }
    localObject1 = (amjr)this.jdField_a_of_type_Amjf.a(2);
    if (localObject1 != null) {
      paramMessage.append(((amjr)localObject1).a()).append("\n");
    }
    QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
    this.d = 0L;
    this.c = 0L;
    this.b = System.currentTimeMillis();
    return;
    paramMessage = obtainMessage(2, localObject1);
    if (((amjm)localObject1).f()) {}
    for (long l1 = 15000L;; l1 = 30000L)
    {
      sendMessageDelayed(paramMessage, l1);
      break;
      removeMessages(3, localObject1);
      ((amjm)localObject1).e();
      bool = this.jdField_a_of_type_Amjf.b;
      if (!bool) {
        break;
      }
      this.d += SystemClock.currentThreadTimeMillis() - l3;
      this.c += System.currentTimeMillis() - l2;
      if (System.currentTimeMillis() - this.b <= 300000L) {
        break label266;
      }
      paramMessage = new StringBuilder(100);
      paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
      paramMessage.append("cpu:").append(this.d).append(" - wall:").append(this.c).append(" ");
      localObject1 = (amjn)this.jdField_a_of_type_Amjf.a(1);
      if (localObject1 != null) {
        paramMessage.append(((amjn)localObject1).a());
      }
      localObject1 = (amjr)this.jdField_a_of_type_Amjf.a(2);
      if (localObject1 != null) {
        paramMessage.append(((amjr)localObject1).a()).append("\n");
      }
      QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
      this.d = 0L;
      this.c = 0L;
      this.b = System.currentTimeMillis();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjq
 * JD-Core Version:    0.7.0.1
 */