import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class andh
  extends ampb<andg>
{
  public static andg a()
  {
    andg localandg2 = (andg)ampm.a().a(573);
    andg localandg1 = localandg2;
    if (localandg2 == null) {
      localandg1 = new andg();
    }
    return localandg1;
  }
  
  public int a()
  {
    return 573;
  }
  
  @NonNull
  public andg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new andg();
  }
  
  @Nullable
  public andg a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfampi.length);
      }
      return andg.a(paramArrayOfampi[0]);
    }
    return null;
  }
  
  public Class<andg> a()
  {
    return andg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(andg paramandg)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramandg == null) {
        break label43;
      }
    }
    label43:
    for (paramandg = paramandg.toString();; paramandg = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramandg);
      return;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     andh
 * JD-Core Version:    0.7.0.1
 */