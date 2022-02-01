import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class arin
{
  public void a(araj[] paramArrayOfaraj)
  {
    QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[handleReadInJoyResetAllConfig] " + paramArrayOfaraj);
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          new pbu();
          int j = paramArrayOfaraj.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = TextUtils.isEmpty(paramArrayOfaraj[i].a);
            if (bool) {}
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramArrayOfaraj)
      {
        QLog.e("ReadinjoyResetFunctionConfProcessor", 1, "[handleReadInJoyResetAllConfig] ", paramArrayOfaraj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arin
 * JD-Core Version:    0.7.0.1
 */