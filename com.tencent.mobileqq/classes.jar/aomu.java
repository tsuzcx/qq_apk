import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aomu
{
  public void a(aogf[] paramArrayOfaogf)
  {
    QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[handleReadInJoyResetAllConfig] " + paramArrayOfaogf);
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          new otw();
          int j = paramArrayOfaogf.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = TextUtils.isEmpty(paramArrayOfaogf[i].a);
            if (bool) {}
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramArrayOfaogf)
      {
        QLog.e("ReadinjoyResetFunctionConfProcessor", 1, "[handleReadInJoyResetAllConfig] ", paramArrayOfaogf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomu
 * JD-Core Version:    0.7.0.1
 */