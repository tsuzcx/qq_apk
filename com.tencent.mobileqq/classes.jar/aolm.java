import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aolm
  extends aokh<aoll>
{
  public static void b()
  {
    aoll localaoll = (aoll)aoks.a().a(67);
    aoll.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaoll);
  }
  
  public static void c()
  {
    int i = aoks.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    aoks.a().a(67, 0);
  }
  
  public int a()
  {
    return 67;
  }
  
  @NonNull
  public aoll a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new aoll();
    }
    aoll.a();
    return new aoll();
  }
  
  @Nullable
  public aoll a(aoko[] paramArrayOfaoko)
  {
    return aoll.a(paramArrayOfaoko);
  }
  
  public Class<aoll> a()
  {
    return aoll.class;
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
  
  public void a(aoll paramaoll)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    aoll.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaoll);
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
 * Qualified Name:     aolm
 * JD-Core Version:    0.7.0.1
 */