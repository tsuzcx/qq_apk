import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqqb
  extends aqkz<aqqa>
{
  private static aqqa a;
  
  public static aqqa a()
  {
    aqqa localaqqa2 = (aqqa)aqlk.a().a(524);
    aqqa localaqqa1 = localaqqa2;
    if (localaqqa2 == null) {
      localaqqa1 = aqqa.a();
    }
    return localaqqa1;
  }
  
  @NonNull
  public aqqa a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = aqqa.a();
    return a;
  }
  
  @Nullable
  public aqqa a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      paramArrayOfaqlg = aqqa.a(paramArrayOfaqlg[0].a);
      a = null;
      return paramArrayOfaqlg;
    }
    return aqqa.a();
  }
  
  public void a(aqqa paramaqqa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramaqqa);
    }
  }
  
  public Class<aqqa> clazz()
  {
    return aqqa.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 524;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqqb
 * JD-Core Version:    0.7.0.1
 */