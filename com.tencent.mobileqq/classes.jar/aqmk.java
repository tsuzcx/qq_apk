import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqmk
  extends aqkz<aqmj>
{
  public static void a()
  {
    aqmj localaqmj = (aqmj)aqlk.a().a(67);
    aqmj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaqmj);
  }
  
  public static void b()
  {
    int i = aqlk.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    aqlk.a().a(67, 0);
  }
  
  @NonNull
  public aqmj a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new aqmj();
    }
    aqmj.a();
    return new aqmj();
  }
  
  @Nullable
  public aqmj a(aqlg[] paramArrayOfaqlg)
  {
    return aqmj.a(paramArrayOfaqlg);
  }
  
  public void a(aqmj paramaqmj)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    aqmj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaqmj);
  }
  
  public Class<aqmj> clazz()
  {
    return aqmj.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("ApolloConfig_GlobalProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfig_GlobalProcessor", 2, "onReqNoReceive");
    }
  }
  
  public int type()
  {
    return 67;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmk
 * JD-Core Version:    0.7.0.1
 */