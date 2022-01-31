import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class anbj
  extends ampb<anbi>
{
  public int a()
  {
    return 294;
  }
  
  @NonNull
  public anbi a(int paramInt)
  {
    return new anbi();
  }
  
  @Nullable
  public anbi a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return anbi.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<anbi> a()
  {
    return anbi.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public void a(anbi paramanbi)
  {
    if (paramanbi == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    ayfv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramanbi.a());
    ayfv.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramanbi.b());
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
 * Qualified Name:     anbj
 * JD-Core Version:    0.7.0.1
 */