import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoxe
  extends aokh<aoxd>
{
  public int a()
  {
    return 294;
  }
  
  @NonNull
  public aoxd a(int paramInt)
  {
    return new aoxd();
  }
  
  @Nullable
  public aoxd a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return aoxd.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aoxd> a()
  {
    return aoxd.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public void a(aoxd paramaoxd)
  {
    if (paramaoxd == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    baic.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramaoxd.a());
    baic.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramaoxd.b());
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
 * Qualified Name:     aoxe
 * JD-Core Version:    0.7.0.1
 */