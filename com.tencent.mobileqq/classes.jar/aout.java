import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aout
  extends aofy<aous>
{
  public static aous a()
  {
    aous localaous2 = (aous)aogj.a().a(573);
    aous localaous1 = localaous2;
    if (localaous2 == null) {
      localaous1 = new aous();
    }
    return localaous1;
  }
  
  public int a()
  {
    return 573;
  }
  
  @NonNull
  public aous a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aous();
  }
  
  @Nullable
  public aous a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aous.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class<aous> a()
  {
    return aous.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aous paramaous)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaous == null) {
        break label43;
      }
    }
    label43:
    for (paramaous = paramaous.toString();; paramaous = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramaous);
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
 * Qualified Name:     aout
 * JD-Core Version:    0.7.0.1
 */