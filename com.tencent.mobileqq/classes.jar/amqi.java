import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amqi
  extends ampb<amqh>
{
  public static void b()
  {
    amqh localamqh = (amqh)ampm.a().a(430);
    amqh.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localamqh);
  }
  
  public int a()
  {
    return 430;
  }
  
  @NonNull
  public amqh a(int paramInt)
  {
    return new amqh();
  }
  
  @Nullable
  public amqh a(ampi[] paramArrayOfampi)
  {
    return amqh.a(paramArrayOfampi);
  }
  
  public Class<amqh> a()
  {
    return amqh.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(amqh paramamqh)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    amqh.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramamqh);
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
 * Qualified Name:     amqi
 * JD-Core Version:    0.7.0.1
 */