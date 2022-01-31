import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aosv
  extends aofy<aosu>
{
  public int a()
  {
    return 294;
  }
  
  @NonNull
  public aosu a(int paramInt)
  {
    return new aosu();
  }
  
  @Nullable
  public aosu a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aosu.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aosu> a()
  {
    return aosu.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TencentDocConfigProcessor", 1, "AIO_PLUSPENAL_TENCENTDOC_ENRTY_CONFIG failed, resultCode:" + paramInt);
  }
  
  public void a(aosu paramaosu)
  {
    if (paramaosu == null) {}
    while (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return;
    }
    badt.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramaosu.a());
    badt.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramaosu.b());
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
 * Qualified Name:     aosv
 * JD-Core Version:    0.7.0.1
 */