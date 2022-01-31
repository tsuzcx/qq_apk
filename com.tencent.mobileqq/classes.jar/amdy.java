import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amdy
  extends alzl<amdx>
{
  public int a()
  {
    return 68;
  }
  
  @NonNull
  public amdx a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new amdx();
  }
  
  @Nullable
  public amdx a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onParsed]");
    }
    amdx localamdx = new amdx();
    localamdx.a = paramArrayOfalzs;
    return localamdx;
  }
  
  public Class<amdx> a()
  {
    return amdx.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "onReqNoReceive: type=" + a());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onReqNoReceive] failCode=" + paramInt);
    }
  }
  
  public void a(amdx paramamdx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onUpdate]");
    }
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(151);
    localPreloadManager.a(paramamdx);
    localPreloadManager.b();
    localPreloadManager.b(true);
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdy
 * JD-Core Version:    0.7.0.1
 */