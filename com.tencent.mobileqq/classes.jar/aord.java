import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aord
{
  public void a(aoko[] paramArrayOfaoko)
  {
    QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[handleReadInJoyResetAllConfig] " + paramArrayOfaoko);
    if (paramArrayOfaoko != null) {
      try
      {
        if (paramArrayOfaoko.length > 0)
        {
          new otw();
          int j = paramArrayOfaoko.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = TextUtils.isEmpty(paramArrayOfaoko[i].a);
            if (bool) {}
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramArrayOfaoko)
      {
        QLog.e("ReadinjoyResetFunctionConfProcessor", 1, "[handleReadInJoyResetAllConfig] ", paramArrayOfaoko);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aord
 * JD-Core Version:    0.7.0.1
 */