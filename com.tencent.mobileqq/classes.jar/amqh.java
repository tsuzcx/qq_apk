import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amqh
  extends ampa<amqg>
{
  public static void b()
  {
    amqg localamqg = (amqg)ampl.a().a(430);
    amqg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localamqg);
  }
  
  public int a()
  {
    return 430;
  }
  
  @NonNull
  public amqg a(int paramInt)
  {
    return new amqg();
  }
  
  @Nullable
  public amqg a(amph[] paramArrayOfamph)
  {
    return amqg.a(paramArrayOfamph);
  }
  
  public Class<amqg> a()
  {
    return amqg.class;
  }
  
  public void a(int paramInt)
  {
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(amqg paramamqg)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    amqg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramamqg);
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
 * Qualified Name:     amqh
 * JD-Core Version:    0.7.0.1
 */