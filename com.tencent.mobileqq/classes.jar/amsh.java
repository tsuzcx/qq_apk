import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class amsh
  extends ampa<amsg>
{
  public int a()
  {
    return 168;
  }
  
  @NonNull
  public amsg a(int paramInt)
  {
    return new amsg();
  }
  
  @Nullable
  public amsg a(amph[] paramArrayOfamph)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfamph != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfamph.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfamph[0] != null)
        {
          localObject1 = amsg.a(paramArrayOfamph[0].a);
          paramArrayOfamph = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfamph instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfamph).getManager(217)).b(((amsg)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public Class<amsg> a()
  {
    return amsg.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsg paramamsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramamsg.toString());
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
 * Qualified Name:     amsh
 * JD-Core Version:    0.7.0.1
 */