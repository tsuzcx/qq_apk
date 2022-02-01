import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aqmc
  extends aqwr<aqmb>
{
  @NonNull
  public aqmb a()
  {
    return new aqmb();
  }
  
  @NonNull
  public aqmb a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    QLog.e("VasUpdateConfProcessor", 1, "onParsed ");
    if (paramArrayOfaqlg != null) {
      try
      {
        if (paramArrayOfaqlg.length > 0)
        {
          int j = paramArrayOfaqlg.length;
          int i = 0;
          while (i < j)
          {
            aqlg localaqlg = paramArrayOfaqlg[i];
            if (localaqlg != null)
            {
              aqmb localaqmb = aqmb.a(localaqlg.a);
              if (QLog.isColorLevel()) {
                QLog.d("VasUpdateConfProcessor", 2, "onParsed " + localaqlg.a);
              }
              if (localaqmb != null) {
                return localaqmb;
              }
            }
            i += 1;
          }
        }
        return new aqmb();
      }
      catch (Exception paramArrayOfaqlg)
      {
        paramArrayOfaqlg.printStackTrace();
        QLog.e("VasUpdateConfProcessor", 1, "onParsed Exception = " + paramArrayOfaqlg.getMessage());
      }
    }
  }
  
  @NonNull
  public aqmb b()
  {
    return new aqmb();
  }
  
  public Class<aqmb> clazz()
  {
    return aqmb.class;
  }
  
  public int type()
  {
    return 649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmc
 * JD-Core Version:    0.7.0.1
 */