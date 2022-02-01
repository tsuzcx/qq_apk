import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arae
  extends aqkz<arad>
{
  @NonNull
  public arad a(int paramInt)
  {
    return new arad();
  }
  
  @Nullable
  public arad a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arad.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arad paramarad)
  {
    if (paramarad == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    bdjg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramarad.a());
    bdjg.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramarad.b());
  }
  
  public Class<arad> clazz()
  {
    return arad.class;
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
 * Qualified Name:     arae
 * JD-Core Version:    0.7.0.1
 */