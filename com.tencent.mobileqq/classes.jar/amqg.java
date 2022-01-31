import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amqg
  extends ampb<amqf>
{
  public static void b()
  {
    amqf localamqf = (amqf)ampm.a().a(67);
    amqf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localamqf);
  }
  
  public static void c()
  {
    int i = ampm.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    ampm.a().a(67, 0);
  }
  
  public int a()
  {
    return 67;
  }
  
  @NonNull
  public amqf a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new amqf();
    }
    amqf.a();
    return new amqf();
  }
  
  @Nullable
  public amqf a(ampi[] paramArrayOfampi)
  {
    return amqf.a(paramArrayOfampi);
  }
  
  public Class<amqf> a()
  {
    return amqf.class;
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
  
  public void a(amqf paramamqf)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    amqf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramamqf);
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
 * Qualified Name:     amqg
 * JD-Core Version:    0.7.0.1
 */