import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class apxq
  extends aptq<apxp>
{
  @NonNull
  public apxp a(int paramInt)
  {
    return new apxp();
  }
  
  @Nullable
  public apxp a(aptx[] paramArrayOfaptx)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaptx != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaptx.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfaptx[0] != null)
        {
          localObject1 = apxp.a(paramArrayOfaptx[0].a);
          paramArrayOfaptx = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfaptx instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfaptx).getManager(217)).b(((apxp)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(apxp paramapxp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramapxp.toString());
    }
  }
  
  public Class<apxp> clazz()
  {
    return apxp.class;
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
 * Qualified Name:     apxq
 * JD-Core Version:    0.7.0.1
 */