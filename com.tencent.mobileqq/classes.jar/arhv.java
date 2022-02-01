import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arhv
  extends arac<arhu>
{
  public static arhu a()
  {
    return (arhu)aran.a().a(441);
  }
  
  @NonNull
  public arhu a(int paramInt)
  {
    return new arhu();
  }
  
  @Nullable
  public arhu a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      new arhu();
      return arhu.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arhu paramarhu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramarhu.toString());
    }
  }
  
  public Class<arhu> clazz()
  {
    return arhu.class;
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
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 441;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhv
 * JD-Core Version:    0.7.0.1
 */