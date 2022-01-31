import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class andm
  extends ampa<andl>
{
  public static andl a()
  {
    andl localandl2 = (andl)ampl.a().a(573);
    andl localandl1 = localandl2;
    if (localandl2 == null) {
      localandl1 = new andl();
    }
    return localandl1;
  }
  
  public int a()
  {
    return 573;
  }
  
  @NonNull
  public andl a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new andl();
  }
  
  @Nullable
  public andl a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
      }
      return andl.a(paramArrayOfamph[0]);
    }
    return null;
  }
  
  public Class<andl> a()
  {
    return andl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(andl paramandl)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramandl == null) {
        break label43;
      }
    }
    label43:
    for (paramandl = paramandl.toString();; paramandl = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramandl);
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
 * Qualified Name:     andm
 * JD-Core Version:    0.7.0.1
 */