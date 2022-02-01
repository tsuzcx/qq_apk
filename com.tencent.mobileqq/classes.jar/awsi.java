import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class awsi
  extends aqkz<awsh>
{
  @NonNull
  public awsh a(int paramInt)
  {
    return new awsh();
  }
  
  @Nullable
  public awsh a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOEntranceConfigProcessor", 2, "onParsed : " + paramArrayOfaqlg[0].a);
      }
      return awsh.a(paramArrayOfaqlg[0].a);
    }
    return new awsh();
  }
  
  public void a(awsh paramawsh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOEntranceConfigProcessor", 2, "onUpdate : " + paramawsh);
    }
    ((awsj)BaseApplicationImpl.getApplication().getRuntime().getManager(325)).a(paramawsh);
  }
  
  public Class<awsh> clazz()
  {
    return awsh.class;
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
 * Qualified Name:     awsi
 * JD-Core Version:    0.7.0.1
 */