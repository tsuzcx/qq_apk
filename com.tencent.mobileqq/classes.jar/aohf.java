import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aohf
  extends aofy<aohe>
{
  public static void b()
  {
    aohe localaohe = (aohe)aogj.a().a(430);
    aohe.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaohe);
  }
  
  public int a()
  {
    return 430;
  }
  
  @NonNull
  public aohe a(int paramInt)
  {
    return new aohe();
  }
  
  @Nullable
  public aohe a(aogf[] paramArrayOfaogf)
  {
    return aohe.a(paramArrayOfaogf);
  }
  
  public Class<aohe> a()
  {
    return aohe.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(aohe paramaohe)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    aohe.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaohe);
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     aohf
 * JD-Core Version:    0.7.0.1
 */