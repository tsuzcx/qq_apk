import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class asrn
  extends aqwt<asrv>
{
  public static asrv a()
  {
    return (asrv)aqxe.a().a(532);
  }
  
  @NonNull
  public asrv a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new asrv();
  }
  
  @Nullable
  public asrv a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return asrv.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(asrv paramasrv)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramasrv == null) {
        break label73;
      }
    }
    label73:
    for (paramasrv = paramasrv.toString();; paramasrv = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramasrv);
      paramasrv = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramasrv instanceof QQAppInterface)) {
        ((aslo)((QQAppInterface)paramasrv).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).c();
      }
      return;
    }
  }
  
  public Class<asrv> clazz()
  {
    return asrv.class;
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
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 532;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrn
 * JD-Core Version:    0.7.0.1
 */