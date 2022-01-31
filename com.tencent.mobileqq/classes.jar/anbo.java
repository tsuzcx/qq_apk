import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class anbo
  extends ampa<anbn>
{
  public int a()
  {
    return 294;
  }
  
  @NonNull
  public anbn a(int paramInt)
  {
    return new anbn();
  }
  
  @Nullable
  public anbn a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return anbn.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<anbn> a()
  {
    return anbn.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public void a(anbn paramanbn)
  {
    if (paramanbn == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    ayfx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramanbn.a());
    ayfx.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramanbn.b());
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
 * Qualified Name:     anbo
 * JD-Core Version:    0.7.0.1
 */