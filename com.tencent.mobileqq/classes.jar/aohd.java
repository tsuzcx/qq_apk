import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aohd
  extends aofy<aohc>
{
  public static void b()
  {
    aohc localaohc = (aohc)aogj.a().a(67);
    aohc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaohc);
  }
  
  public static void c()
  {
    int i = aogj.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    aogj.a().a(67, 0);
  }
  
  public int a()
  {
    return 67;
  }
  
  @NonNull
  public aohc a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new aohc();
    }
    aohc.a();
    return new aohc();
  }
  
  @Nullable
  public aohc a(aogf[] paramArrayOfaogf)
  {
    return aohc.a(paramArrayOfaogf);
  }
  
  public Class<aohc> a()
  {
    return aohc.class;
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
  
  public void a(aohc paramaohc)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    aohc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaohc);
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
 * Qualified Name:     aohd
 * JD-Core Version:    0.7.0.1
 */