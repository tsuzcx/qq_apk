import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class area
  extends arac<ardz>
{
  @NonNull
  public ardz a(int paramInt)
  {
    return new ardz();
  }
  
  @Nullable
  public ardz a(araj[] paramArrayOfaraj)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaraj != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaraj.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfaraj[0] != null)
        {
          localObject1 = ardz.a(paramArrayOfaraj[0].a);
          paramArrayOfaraj = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfaraj instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfaraj).getManager(217)).b(((ardz)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(ardz paramardz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramardz.toString());
    }
  }
  
  public Class<ardz> clazz()
  {
    return ardz.class;
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
 * Qualified Name:     area
 * JD-Core Version:    0.7.0.1
 */