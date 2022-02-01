import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqon
  extends aqkz<aqoo>
{
  public static aqoo a()
  {
    return (aqoo)aqlk.a().a(622);
  }
  
  @NonNull
  public aqoo a(int paramInt)
  {
    return new aqoo();
  }
  
  @Nullable
  public aqoo a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqoo.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqoo paramaqoo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonTabSortConfProcessor", 2, "EmoticonTabSortConfProcessor onUpdate");
    }
  }
  
  public Class<aqoo> clazz()
  {
    return aqoo.class;
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
 * Qualified Name:     aqon
 * JD-Core Version:    0.7.0.1
 */