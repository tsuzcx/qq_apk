import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arhx
  extends arac<arhw>
{
  public static arhw a()
  {
    return (arhw)aran.a().a(631);
  }
  
  @NonNull
  public arhw a(int paramInt)
  {
    return new arhw();
  }
  
  @Nullable
  public arhw a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      new arhw();
      return arhw.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arhw paramarhw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onUpdate " + paramarhw.toString());
    }
  }
  
  public Class<arhw> clazz()
  {
    return arhw.class;
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
 * Qualified Name:     arhx
 * JD-Core Version:    0.7.0.1
 */