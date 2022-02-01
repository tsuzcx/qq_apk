import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class arbf
  extends armf<arbe>
{
  @NonNull
  public arbe a()
  {
    return new arbe();
  }
  
  @NonNull
  public arbe a(@NonNull araj[] paramArrayOfaraj)
  {
    QLog.e("VasUpdateConfProcessor", 1, "onParsed ");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          int j = paramArrayOfaraj.length;
          int i = 0;
          while (i < j)
          {
            araj localaraj = paramArrayOfaraj[i];
            if (localaraj != null)
            {
              arbe localarbe = arbe.a(localaraj.a);
              if (QLog.isColorLevel()) {
                QLog.d("VasUpdateConfProcessor", 2, "onParsed " + localaraj.a);
              }
              if (localarbe != null) {
                return localarbe;
              }
            }
            i += 1;
          }
        }
        return new arbe();
      }
      catch (Exception paramArrayOfaraj)
      {
        paramArrayOfaraj.printStackTrace();
        QLog.e("VasUpdateConfProcessor", 1, "onParsed Exception = " + paramArrayOfaraj.getMessage());
      }
    }
  }
  
  @NonNull
  public arbe b()
  {
    return new arbe();
  }
  
  public Class<arbe> clazz()
  {
    return arbe.class;
  }
  
  public int type()
  {
    return 649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbf
 * JD-Core Version:    0.7.0.1
 */