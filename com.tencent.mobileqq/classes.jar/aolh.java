import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aolh
  extends aofy<aolg>
{
  public int a()
  {
    return 68;
  }
  
  @NonNull
  public aolg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new aolg();
  }
  
  @Nullable
  public aolg a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onParsed]");
    }
    aolg localaolg = new aolg();
    localaolg.a = paramArrayOfaogf;
    return localaolg;
  }
  
  public Class<aolg> a()
  {
    return aolg.class;
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
  
  public void a(aolg paramaolg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadConfProcessor", 2, "[onUpdate]");
    }
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(151);
    localPreloadManager.a(paramaolg);
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
 * Qualified Name:     aolh
 * JD-Core Version:    0.7.0.1
 */