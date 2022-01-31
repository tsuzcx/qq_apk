import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class amsi
  extends ampb<amsh>
{
  public int a()
  {
    return 168;
  }
  
  @NonNull
  public amsh a(int paramInt)
  {
    return new amsh();
  }
  
  @Nullable
  public amsh a(ampi[] paramArrayOfampi)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfampi != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfampi.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfampi[0] != null)
        {
          localObject1 = amsh.a(paramArrayOfampi[0].a);
          paramArrayOfampi = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfampi instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfampi).getManager(217)).b(((amsh)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public Class<amsh> a()
  {
    return amsh.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsh paramamsh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramamsh.toString());
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsi
 * JD-Core Version:    0.7.0.1
 */