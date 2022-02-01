import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class arcf
  extends aqwt<arcd>
{
  @NonNull
  public static arcd a()
  {
    arcd localarcd2 = (arcd)aqxe.a().a(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localarcd2);
    }
    arcd localarcd1 = localarcd2;
    if (localarcd2 == null) {
      localarcd1 = new arcd();
    }
    return localarcd1;
  }
  
  @NonNull
  public arcd a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new arcd();
  }
  
  @Nullable
  public arcd a(aqxa[] paramArrayOfaqxa)
  {
    return arcd.a(paramArrayOfaqxa);
  }
  
  public void a(arcd paramarcd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramarcd.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).isCreateManager(QQManagerFactory.NEW_FRIEND_MANAGER))
      {
        ((aizi)((QQAppInterface)localObject).getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a = paramarcd;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate bean");
        }
      }
    }
  }
  
  public Class<arcd> clazz()
  {
    return arcd.class;
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
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 458;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcf
 * JD-Core Version:    0.7.0.1
 */