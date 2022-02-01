import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bduw
  extends arac<bdux>
{
  public static bdux a()
  {
    return (bdux)aran.a().a(610);
  }
  
  @NonNull
  public bdux a(int paramInt)
  {
    return new bdux();
  }
  
  @Nullable
  public bdux a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModeConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bdux.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(bdux parambdux) {}
  
  public Class<bdux> clazz()
  {
    return bdux.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 610;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduw
 * JD-Core Version:    0.7.0.1
 */