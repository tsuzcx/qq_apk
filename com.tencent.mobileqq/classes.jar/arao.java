import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arao
  extends aqwt<arap>
{
  public static arap a()
  {
    return (arap)aqxe.a().a(622);
  }
  
  @NonNull
  public arap a(int paramInt)
  {
    return new arap();
  }
  
  @Nullable
  public arap a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arap.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arap paramarap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonTabSortConfProcessor", 2, "EmoticonTabSortConfProcessor onUpdate");
    }
  }
  
  public Class<arap> clazz()
  {
    return arap.class;
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
 * Qualified Name:     arao
 * JD-Core Version:    0.7.0.1
 */