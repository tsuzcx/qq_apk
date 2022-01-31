import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amud
  extends ampa<amuc>
{
  public int a()
  {
    return 68;
  }
  
  @NonNull
  public amuc a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new amuc();
  }
  
  @Nullable
  public amuc a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onParsed]");
    }
    amuc localamuc = new amuc();
    localamuc.a = paramArrayOfamph;
    return localamuc;
  }
  
  public Class<amuc> a()
  {
    return amuc.class;
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
  
  public void a(amuc paramamuc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onUpdate]");
    }
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(151);
    localPreloadManager.a(paramamuc);
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
 * Qualified Name:     amud
 * JD-Core Version:    0.7.0.1
 */