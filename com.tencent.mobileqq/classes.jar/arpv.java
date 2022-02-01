import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arpv
  extends arac<arpu>
{
  @NonNull
  public arpu a(int paramInt)
  {
    return new arpu();
  }
  
  @Nullable
  public arpu a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arpu.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arpu paramarpu)
  {
    if (paramarpu == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    becb.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramarpu.a());
    becb.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramarpu.b());
  }
  
  public Class<arpu> clazz()
  {
    return arpu.class;
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
 * Qualified Name:     arpv
 * JD-Core Version:    0.7.0.1
 */