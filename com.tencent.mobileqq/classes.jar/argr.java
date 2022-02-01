import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class argr
  extends arac<argq>
{
  @NonNull
  public argq a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new argq();
  }
  
  @Nullable
  public argq a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onParsed]");
    }
    argq localargq = new argq();
    localargq.a = paramArrayOfaraj;
    return localargq;
  }
  
  public void a(argq paramargq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onUpdate]");
    }
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(151);
    localPreloadManager.a(paramargq);
    localPreloadManager.b();
    localPreloadManager.b(true);
  }
  
  public Class<argq> clazz()
  {
    return argq.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onReqNoReceive] failCode=" + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "onReqNoReceive: type=" + type());
    }
  }
  
  public int type()
  {
    return 68;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argr
 * JD-Core Version:    0.7.0.1
 */