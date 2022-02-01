import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arbr
  extends arac<arbq>
{
  public static void a()
  {
    arbq localarbq = (arbq)aran.a().a(430);
    arbq.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localarbq);
  }
  
  @NonNull
  public arbq a(int paramInt)
  {
    return new arbq();
  }
  
  @Nullable
  public arbq a(araj[] paramArrayOfaraj)
  {
    return arbq.a(paramArrayOfaraj);
  }
  
  public void a(arbq paramarbq)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    arbq.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramarbq);
  }
  
  public Class<arbq> clazz()
  {
    return arbq.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 430;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbr
 * JD-Core Version:    0.7.0.1
 */