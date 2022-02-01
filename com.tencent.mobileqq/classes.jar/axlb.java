import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class axlb
  extends arac<axla>
{
  @NonNull
  public axla a(int paramInt)
  {
    return new axla();
  }
  
  @Nullable
  public axla a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfaraj[0].a);
      }
      return axla.a(paramArrayOfaraj[0].a);
    }
    return new axla();
  }
  
  public void a(axla paramaxla)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramaxla);
    }
    ((axlc)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).a(paramaxla);
  }
  
  public Class<axla> clazz()
  {
    return axla.class;
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
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public int type()
  {
    return 478;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlb
 * JD-Core Version:    0.7.0.1
 */