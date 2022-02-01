import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class arat
  extends aqwt<aras>
{
  @NonNull
  public aras a(int paramInt)
  {
    return new aras();
  }
  
  @Nullable
  public aras a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqxa.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfaqxa[0] != null)
        {
          localObject1 = aras.a(paramArrayOfaqxa[0].a);
          paramArrayOfaqxa = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfaqxa instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfaqxa).getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).b(((aras)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(aras paramaras)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramaras.toString());
    }
  }
  
  public Class<aras> clazz()
  {
    return aras.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 168;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arat
 * JD-Core Version:    0.7.0.1
 */