import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aota
  extends aokh<aosz>
{
  public static aosz a()
  {
    aosz localaosz2 = (aosz)aoks.a().a(493);
    aosz localaosz1 = localaosz2;
    if (localaosz2 == null) {
      localaosz1 = new aosz();
    }
    return localaosz1;
  }
  
  public int a()
  {
    return 493;
  }
  
  @NonNull
  public aosz a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aosz();
  }
  
  @Nullable
  public aosz a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaoko.length);
      }
      return aosz.a(paramArrayOfaoko[0]);
    }
    return null;
  }
  
  public Class<aosz> a()
  {
    return aosz.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aosz paramaosz)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaosz == null) {
        break label43;
      }
    }
    label43:
    for (paramaosz = paramaosz.toString();; paramaosz = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramaosz);
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
 * Qualified Name:     aota
 * JD-Core Version:    0.7.0.1
 */