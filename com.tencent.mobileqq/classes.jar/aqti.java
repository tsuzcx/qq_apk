import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqti
  extends aqkz<aqtj>
{
  public static aqtj a()
  {
    return (aqtj)aqlk.a().a(647);
  }
  
  @NonNull
  public aqtj a(int paramInt)
  {
    return new aqtj();
  }
  
  @Nullable
  public aqtj a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqtj.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqtj paramaqtj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaHttpsConfProcessor", 2, "RichmediaHttpsConfProcessor onUpdate");
    }
  }
  
  public Class<aqtj> clazz()
  {
    return aqtj.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqti
 * JD-Core Version:    0.7.0.1
 */