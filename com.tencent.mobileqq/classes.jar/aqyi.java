import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqyi
  extends aqwt<aqyh>
{
  public static void a()
  {
    aqyh localaqyh = (aqyh)aqxe.a().a(67);
    aqyh.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaqyh);
  }
  
  public static void b()
  {
    int i = aqxe.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    aqxe.a().a(67, 0);
  }
  
  @NonNull
  public aqyh a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new aqyh();
    }
    aqyh.a();
    return new aqyh();
  }
  
  @Nullable
  public aqyh a(aqxa[] paramArrayOfaqxa)
  {
    return aqyh.a(paramArrayOfaqxa);
  }
  
  public void a(aqyh paramaqyh)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    aqyh.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaqyh);
  }
  
  public Class<aqyh> clazz()
  {
    return aqyh.class;
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
 * Qualified Name:     aqyi
 * JD-Core Version:    0.7.0.1
 */