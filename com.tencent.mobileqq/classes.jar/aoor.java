import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoor
  extends aofy<aooq>
{
  public static aooq a()
  {
    aooq localaooq2 = (aooq)aogj.a().a(493);
    aooq localaooq1 = localaooq2;
    if (localaooq2 == null) {
      localaooq1 = new aooq();
    }
    return localaooq1;
  }
  
  public int a()
  {
    return 493;
  }
  
  @NonNull
  public aooq a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aooq();
  }
  
  @Nullable
  public aooq a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aooq.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class<aooq> a()
  {
    return aooq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aooq paramaooq)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaooq == null) {
        break label43;
      }
    }
    label43:
    for (paramaooq = paramaooq.toString();; paramaooq = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramaooq);
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
 * Qualified Name:     aoor
 * JD-Core Version:    0.7.0.1
 */