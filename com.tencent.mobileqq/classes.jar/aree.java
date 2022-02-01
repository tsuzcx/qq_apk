import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aree
  extends arac<ared>
{
  @NonNull
  public ared a(int paramInt)
  {
    return new ared();
  }
  
  @Nullable
  public ared a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      ared localared = new ared();
      localared.a = paramArrayOfaraj[0].a;
      return localared;
    }
    return null;
  }
  
  public void a(ared paramared)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    amsx localamsx = (amsx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramared != null) {}
    for (paramared = paramared.a;; paramared = null)
    {
      localamsx.d(paramared);
      return;
    }
  }
  
  public Class<ared> clazz()
  {
    return ared.class;
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
    ared localared = (ared)aran.a().a(417);
    if (localared != null) {
      ((amsx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).d(localared.a);
    }
  }
  
  public int type()
  {
    return 417;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aree
 * JD-Core Version:    0.7.0.1
 */