import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class arhd
  extends arac<arhc>
{
  @NonNull
  public arhc a(int paramInt)
  {
    return new arhc();
  }
  
  @Nullable
  public arhc a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      arhc localarhc = arhc.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarhc;
    }
    return new arhc();
  }
  
  public void a(arhc paramarhc)
  {
    ((axab)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).a(paramarhc);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramarhc);
    }
  }
  
  public Class<arhc> clazz()
  {
    return arhc.class;
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
    return 390;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhd
 * JD-Core Version:    0.7.0.1
 */