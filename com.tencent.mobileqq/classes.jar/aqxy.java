import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class aqxy
  extends arjj<aqxx>
{
  @NonNull
  public aqxx a()
  {
    return new aqxx();
  }
  
  @NonNull
  public aqxx a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    QLog.e("VasUpdateConfProcessor", 1, "onParsed ");
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
              aqxx localaqxx = aqxx.a(localaqxa.a);
              if (QLog.isColorLevel()) {
                QLog.d("VasUpdateConfProcessor", 2, "onParsed " + localaqxa.a);
              }
              if (localaqxx != null) {
                return localaqxx;
              }
            }
            i += 1;
          }
        }
        return new aqxx();
      }
      catch (Exception paramArrayOfaqxa)
      {
        paramArrayOfaqxa.printStackTrace();
        QLog.e("VasUpdateConfProcessor", 1, "onParsed Exception = " + paramArrayOfaqxa.getMessage());
      }
    }
  }
  
  @NonNull
  public aqxx b()
  {
    return new aqxx();
  }
  
  public Class<aqxx> clazz()
  {
    return aqxx.class;
  }
  
  public int type()
  {
    return 649;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxy
 * JD-Core Version:    0.7.0.1
 */