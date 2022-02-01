import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class avyi
  extends aptq<avyh>
{
  @NonNull
  public avyh a(int paramInt)
  {
    return new avyh();
  }
  
  @Nullable
  public avyh a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfaptx[0].a);
      }
      return avyh.a(paramArrayOfaptx[0].a);
    }
    return new avyh();
  }
  
  public void a(avyh paramavyh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramavyh);
    }
    ((avyj)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).a(paramavyh);
  }
  
  public Class<avyh> clazz()
  {
    return avyh.class;
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
 * Qualified Name:     avyi
 * JD-Core Version:    0.7.0.1
 */