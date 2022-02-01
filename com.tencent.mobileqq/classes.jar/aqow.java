import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqow
  extends aqkz<aqov>
{
  @NonNull
  public aqov a(int paramInt)
  {
    return new aqov();
  }
  
  @Nullable
  public aqov a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqov localaqov = new aqov();
      localaqov.a = paramArrayOfaqlg[0].a;
      return localaqov;
    }
    return null;
  }
  
  public void a(aqov paramaqov)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    amhd localamhd = (amhd)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramaqov != null) {}
    for (paramaqov = paramaqov.a;; paramaqov = null)
    {
      localamhd.d(paramaqov);
      return;
    }
  }
  
  public Class<aqov> clazz()
  {
    return aqov.class;
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
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    aqov localaqov = (aqov)aqlk.a().a(417);
    if (localaqov != null) {
      ((amhd)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).d(localaqov.a);
    }
  }
  
  public int type()
  {
    return 417;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqow
 * JD-Core Version:    0.7.0.1
 */