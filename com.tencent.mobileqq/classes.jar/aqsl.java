import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqsl
  extends aqkz<aqsk>
{
  public static aqsk a()
  {
    return (aqsk)aqlk.a().a(631);
  }
  
  @NonNull
  public aqsk a(int paramInt)
  {
    return new aqsk();
  }
  
  @Nullable
  public aqsk a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      new aqsk();
      return aqsk.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqsk paramaqsk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onUpdate " + paramaqsk.toString());
    }
  }
  
  public Class<aqsk> clazz()
  {
    return aqsk.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
      QLog.d("QQGamePreloadConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 631;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsl
 * JD-Core Version:    0.7.0.1
 */