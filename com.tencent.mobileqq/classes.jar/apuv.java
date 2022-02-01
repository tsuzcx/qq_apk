import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class apuv
  extends aqgc<apuu>
{
  @NonNull
  public apuu a()
  {
    return new apuu();
  }
  
  @NonNull
  public apuu a(@NonNull aptx[] paramArrayOfaptx)
  {
    QLog.e("VasUpdateConfProcessor", 1, "onParsed ");
    if (paramArrayOfaptx != null) {
      try
      {
        if (paramArrayOfaptx.length > 0)
        {
          int j = paramArrayOfaptx.length;
          int i = 0;
          while (i < j)
          {
            aptx localaptx = paramArrayOfaptx[i];
            if (localaptx != null)
            {
              apuu localapuu = apuu.a(localaptx.a);
              if (QLog.isColorLevel()) {
                QLog.d("VasUpdateConfProcessor", 2, "onParsed " + localaptx.a);
              }
              if (localapuu != null) {
                return localapuu;
              }
            }
            i += 1;
          }
        }
        return new apuu();
      }
      catch (Exception paramArrayOfaptx)
      {
        paramArrayOfaptx.printStackTrace();
        QLog.e("VasUpdateConfProcessor", 1, "onParsed Exception = " + paramArrayOfaptx.getMessage());
      }
    }
  }
  
  @NonNull
  public apuu b()
  {
    return new apuu();
  }
  
  public Class<apuu> clazz()
  {
    return apuu.class;
  }
  
  public int type()
  {
    return 649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apuv
 * JD-Core Version:    0.7.0.1
 */