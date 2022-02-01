import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class bkjk
  extends aqgc<bkjj>
{
  public static bkjj a()
  {
    return (bkjj)apub.a().a(689);
  }
  
  @NonNull
  public bkjj a(@NonNull aptx[] paramArrayOfaptx)
  {
    QLog.e("IliveManagerConfProcessor", 1, "onParsed ");
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
              bkjj localbkjj = bkjj.a(localaptx.a);
              QLog.e("IliveManagerConfProcessor", 1, "onParsed content = " + localaptx.a);
              if (localbkjj != null) {
                return localbkjj;
              }
            }
            i += 1;
          }
        }
        return new bkjj();
      }
      catch (Throwable paramArrayOfaptx)
      {
        paramArrayOfaptx.printStackTrace();
        QLog.e("IliveManagerConfProcessor", 1, "onParsed Exception = " + paramArrayOfaptx.getMessage());
      }
    }
  }
  
  @NonNull
  public bkjj b()
  {
    return new bkjj();
  }
  
  @NonNull
  public bkjj c()
  {
    return new bkjj();
  }
  
  public Class<bkjj> clazz()
  {
    return bkjj.class;
  }
  
  public int type()
  {
    return 689;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjk
 * JD-Core Version:    0.7.0.1
 */