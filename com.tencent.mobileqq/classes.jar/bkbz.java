import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;

public class bkbz
  implements bkcb
{
  public bkbz(QSecFramework paramQSecFramework) {}
  
  public int a(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramLong1 != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSecFramework", 2, String.format("Native msg, cookie: %08X, delay: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      }
      paramObject1 = String.valueOf(paramLong1);
      if (paramLong2 == 0L) {
        break label84;
      }
      QSecFramework.a(this.a).sendMessageDelayed(QSecFramework.a(this.a).obtainMessage(1, paramObject1), 1000L * paramLong2);
    }
    for (;;)
    {
      return 0;
      label84:
      QSecFramework.a(this.a).sendMessage(QSecFramework.a(this.a).obtainMessage(1, paramObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbz
 * JD-Core Version:    0.7.0.1
 */