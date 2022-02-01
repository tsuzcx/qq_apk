import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ardv
  extends arac<ardw>
{
  public static ardw a()
  {
    return (ardw)aran.a().a(622);
  }
  
  @NonNull
  public ardw a(int paramInt)
  {
    return new ardw();
  }
  
  @Nullable
  public ardw a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return ardw.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(ardw paramardw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonTabSortConfProcessor", 2, "EmoticonTabSortConfProcessor onUpdate");
    }
  }
  
  public Class<ardw> clazz()
  {
    return ardw.class;
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
    return 622;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardv
 * JD-Core Version:    0.7.0.1
 */