import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arne
  extends aqwt<arnd>
{
  @NonNull
  public arnd a(int paramInt)
  {
    return new arnd();
  }
  
  @Nullable
  public arnd a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnd.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnd paramarnd)
  {
    if (paramarnd == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    becr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramarnd.a());
    becr.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramarnd.b());
  }
  
  public Class<arnd> clazz()
  {
    return arnd.class;
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
    QLog.d("TencentDocConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public int type()
  {
    return 294;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arne
 * JD-Core Version:    0.7.0.1
 */