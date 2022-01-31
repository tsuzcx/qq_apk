import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amvp
{
  public void a(amph[] paramArrayOfamph)
  {
    QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[handleReadInJoyResetAllConfig] " + paramArrayOfamph);
    if (paramArrayOfamph != null) {
      try
      {
        if (paramArrayOfamph.length > 0)
        {
          new opi();
          int j = paramArrayOfamph.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = TextUtils.isEmpty(paramArrayOfamph[i].a);
            if (bool) {}
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramArrayOfamph)
      {
        QLog.e("ReadinjoyResetFunctionConfProcessor", 1, "[handleReadInJoyResetAllConfig] ", paramArrayOfamph);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvp
 * JD-Core Version:    0.7.0.1
 */