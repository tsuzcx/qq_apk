import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class ardk
  extends aqwt<ardj>
{
  @NonNull
  public ardj a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new ardj();
  }
  
  @Nullable
  public ardj a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onParsed]");
    }
    ardj localardj = new ardj();
    localardj.a = paramArrayOfaqxa;
    return localardj;
  }
  
  public void a(ardj paramardj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onUpdate]");
    }
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.PRELOAD_MANAGER);
    localPreloadManager.a(paramardj);
    localPreloadManager.b();
    localPreloadManager.b(true);
  }
  
  public Class<ardj> clazz()
  {
    return ardj.class;
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
 * Qualified Name:     ardk
 * JD-Core Version:    0.7.0.1
 */