import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class aqos
  extends aqkz<aqor>
{
  @NonNull
  public aqor a(int paramInt)
  {
    return new aqor();
  }
  
  @Nullable
  public aqor a(aqlg[] paramArrayOfaqlg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqlg != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqlg.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfaqlg[0] != null)
        {
          localObject1 = aqor.a(paramArrayOfaqlg[0].a);
          paramArrayOfaqlg = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfaqlg instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfaqlg).getManager(217)).b(((aqor)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(aqor paramaqor)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramaqor.toString());
    }
  }
  
  public Class<aqor> clazz()
  {
    return aqor.class;
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
 * Qualified Name:     aqos
 * JD-Core Version:    0.7.0.1
 */