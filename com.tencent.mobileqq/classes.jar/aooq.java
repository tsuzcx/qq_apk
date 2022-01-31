import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aooq
  extends aokh<aoop>
{
  private static aoop a;
  
  public static aoop a()
  {
    aoop localaoop2 = (aoop)aoks.a().a(524);
    aoop localaoop1 = localaoop2;
    if (localaoop2 == null) {
      localaoop1 = aoop.a();
    }
    return localaoop1;
  }
  
  public int a()
  {
    return 524;
  }
  
  @NonNull
  public aoop a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = aoop.a();
    return a;
  }
  
  @Nullable
  public aoop a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      paramArrayOfaoko = aoop.a(paramArrayOfaoko[0].a);
      a = null;
      return paramArrayOfaoko;
    }
    return aoop.a();
  }
  
  public Class<aoop> a()
  {
    return aoop.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(aoop paramaoop)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramaoop);
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
 * Qualified Name:     aooq
 * JD-Core Version:    0.7.0.1
 */