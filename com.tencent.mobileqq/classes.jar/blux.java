import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class blux
  extends arjj<bluw>
{
  public static bluw a()
  {
    return (bluw)aqxe.a().a(689);
  }
  
  @NonNull
  public bluw a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    QLog.e("IliveManagerConfProcessor", 1, "onParsed ");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          int j = paramArrayOfaqxa.length;
          int i = 0;
          while (i < j)
          {
            aqxa localaqxa = paramArrayOfaqxa[i];
            if (localaqxa != null)
            {
              bluw localbluw = bluw.a(localaqxa.a);
              QLog.e("IliveManagerConfProcessor", 1, "onParsed content = " + localaqxa.a);
              if (localbluw != null) {
                return localbluw;
              }
            }
            i += 1;
          }
        }
        return new bluw();
      }
      catch (Throwable paramArrayOfaqxa)
      {
        paramArrayOfaqxa.printStackTrace();
        QLog.e("IliveManagerConfProcessor", 1, "onParsed Exception = " + paramArrayOfaqxa.getMessage());
      }
    }
  }
  
  @NonNull
  public bluw b()
  {
    return new bluw();
  }
  
  @NonNull
  public bluw c()
  {
    return new bluw();
  }
  
  public Class<bluw> clazz()
  {
    return bluw.class;
  }
  
  public int type()
  {
    return 689;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blux
 * JD-Core Version:    0.7.0.1
 */