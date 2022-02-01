import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqjt
  extends aptq<aqjs>
{
  @NonNull
  public aqjs a(int paramInt)
  {
    return new aqjs();
  }
  
  @Nullable
  public aqjs a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqjs.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqjs paramaqjs)
  {
    if (paramaqjs == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    bcvs.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramaqjs.a());
    bcvs.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramaqjs.b());
  }
  
  public Class<aqjs> clazz()
  {
    return aqjs.class;
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
 * Qualified Name:     aqjt
 * JD-Core Version:    0.7.0.1
 */