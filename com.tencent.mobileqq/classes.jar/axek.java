import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class axek
  extends aqwt<axej>
{
  @NonNull
  public axej a(int paramInt)
  {
    return new axej();
  }
  
  @Nullable
  public axej a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfaqxa[0].a);
      }
      return axej.a(paramArrayOfaqxa[0].a);
    }
    return new axej();
  }
  
  public void a(axej paramaxej)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramaxej);
    }
    ((axel)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.AIO_MULTI_WINDOW_MANAGER)).a(paramaxej);
  }
  
  public Class<axej> clazz()
  {
    return axej.class;
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
 * Qualified Name:     axek
 * JD-Core Version:    0.7.0.1
 */