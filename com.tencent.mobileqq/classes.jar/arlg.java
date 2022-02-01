import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class arlg
  extends arjj<arlf>
{
  @NonNull
  public arlf a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    anrv localanrv = (anrv)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
    if (localanrv != null) {
      localanrv.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new arlf();
  }
  
  @NonNull
  public arlf a(aqxa[] paramArrayOfaqxa)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    anrv localanrv = (anrv)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
    if (localanrv != null) {
      localanrv.a(localQQAppInterface, paramArrayOfaqxa[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfaqxa[0]);
    }
    return new arlf();
  }
  
  @NonNull
  public arlf b()
  {
    return new arlf();
  }
  
  public Class<arlf> clazz()
  {
    return arlf.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlg
 * JD-Core Version:    0.7.0.1
 */