import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class arfl
{
  public void a(aqxa[] paramArrayOfaqxa)
  {
    QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[handleReadInJoyResetAllConfig] " + paramArrayOfaqxa);
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          new pmf();
          int j = paramArrayOfaqxa.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = TextUtils.isEmpty(paramArrayOfaqxa[i].a);
            if (bool) {}
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramArrayOfaqxa)
      {
        QLog.e("ReadinjoyResetFunctionConfProcessor", 1, "[handleReadInJoyResetAllConfig] ", paramArrayOfaqxa);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfl
 * JD-Core Version:    0.7.0.1
 */