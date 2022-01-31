import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amvq
{
  public void a(ampi[] paramArrayOfampi)
  {
    QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[handleReadInJoyResetAllConfig] " + paramArrayOfampi);
    if (paramArrayOfampi != null) {
      try
      {
        if (paramArrayOfampi.length > 0)
        {
          new opl();
          int j = paramArrayOfampi.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = TextUtils.isEmpty(paramArrayOfampi[i].a);
            if (bool) {}
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramArrayOfampi)
      {
        QLog.e("ReadinjoyResetFunctionConfProcessor", 1, "[handleReadInJoyResetAllConfig] ", paramArrayOfampi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvq
 * JD-Core Version:    0.7.0.1
 */