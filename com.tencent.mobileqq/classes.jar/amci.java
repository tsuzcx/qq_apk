import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class amci
  extends alzl<amch>
{
  public int a()
  {
    return 168;
  }
  
  @NonNull
  public amch a(int paramInt)
  {
    return new amch();
  }
  
  @Nullable
  public amch a(alzs[] paramArrayOfalzs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfalzs != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfalzs.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfalzs[0] != null)
        {
          localObject1 = amch.a(paramArrayOfalzs[0].a);
          paramArrayOfalzs = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfalzs instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfalzs).getManager(217)).b(((amch)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public Class<amch> a()
  {
    return amch.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amch paramamch)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramamch.toString());
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
 * Qualified Name:     amci
 * JD-Core Version:    0.7.0.1
 */