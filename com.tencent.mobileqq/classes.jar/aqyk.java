import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqyk
  extends aqwt<aqyj>
{
  public static void a()
  {
    aqyj localaqyj = (aqyj)aqxe.a().a(430);
    aqyj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaqyj);
  }
  
  @NonNull
  public aqyj a(int paramInt)
  {
    return new aqyj();
  }
  
  @Nullable
  public aqyj a(aqxa[] paramArrayOfaqxa)
  {
    return aqyj.a(paramArrayOfaqxa);
  }
  
  public void a(aqyj paramaqyj)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    aqyj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaqyj);
  }
  
  public Class<aqyj> clazz()
  {
    return aqyj.class;
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
 * Qualified Name:     aqyk
 * JD-Core Version:    0.7.0.1
 */