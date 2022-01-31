import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amqf
  extends ampa<amqe>
{
  public static void b()
  {
    amqe localamqe = (amqe)ampl.a().a(67);
    amqe.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localamqe);
  }
  
  public static void c()
  {
    int i = ampl.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    ampl.a().a(67, 0);
  }
  
  public int a()
  {
    return 67;
  }
  
  @NonNull
  public amqe a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new amqe();
    }
    amqe.a();
    return new amqe();
  }
  
  @Nullable
  public amqe a(amph[] paramArrayOfamph)
  {
    return amqe.a(paramArrayOfamph);
  }
  
  public Class<amqe> a()
  {
    return amqe.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfig_GlobalProcessor", 2, "onReqNoReceive");
    }
  }
  
  public void a(int paramInt)
  {
    QLog.e("ApolloConfig_GlobalProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void a(amqe paramamqe)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    amqe.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramamqe);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqf
 * JD-Core Version:    0.7.0.1
 */