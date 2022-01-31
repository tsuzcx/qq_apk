import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amlf
  extends alzl<amle>
{
  public int a()
  {
    return 294;
  }
  
  @NonNull
  public amle a(int paramInt)
  {
    return new amle();
  }
  
  @Nullable
  public amle a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return amle.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amle> a()
  {
    return amle.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public void a(amle paramamle)
  {
    if (paramamle == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    axfs.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramamle.a());
    axfs.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramamle.b());
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amlf
 * JD-Core Version:    0.7.0.1
 */