import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aolo
  extends aokh<aoln>
{
  public static void b()
  {
    aoln localaoln = (aoln)aoks.a().a(430);
    aoln.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaoln);
  }
  
  public int a()
  {
    return 430;
  }
  
  @NonNull
  public aoln a(int paramInt)
  {
    return new aoln();
  }
  
  @Nullable
  public aoln a(aoko[] paramArrayOfaoko)
  {
    return aoln.a(paramArrayOfaoko);
  }
  
  public Class<aoln> a()
  {
    return aoln.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(aoln paramaoln)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    aoln.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaoln);
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
 * Qualified Name:     aolo
 * JD-Core Version:    0.7.0.1
 */