import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apxl
  extends aptq<apxm>
{
  public static apxm a()
  {
    return (apxm)apub.a().a(622);
  }
  
  @NonNull
  public apxm a(int paramInt)
  {
    return new apxm();
  }
  
  @Nullable
  public apxm a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return apxm.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(apxm paramapxm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonTabSortConfProcessor", 2, "EmoticonTabSortConfProcessor onUpdate");
    }
  }
  
  public Class<apxm> clazz()
  {
    return apxm.class;
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
 * Qualified Name:     apxl
 * JD-Core Version:    0.7.0.1
 */