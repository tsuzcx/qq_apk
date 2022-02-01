import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aqrt
  extends aqkz<aqrs>
{
  @NonNull
  public aqrs a(int paramInt)
  {
    return new aqrs();
  }
  
  @Nullable
  public aqrs a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqrs localaqrs = aqrs.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqrs;
    }
    return new aqrs();
  }
  
  public void a(aqrs paramaqrs)
  {
    ((awhj)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).a(paramaqrs);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramaqrs);
    }
  }
  
  public Class<aqrs> clazz()
  {
    return aqrs.class;
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
 * Qualified Name:     aqrt
 * JD-Core Version:    0.7.0.1
 */