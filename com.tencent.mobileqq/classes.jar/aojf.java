import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class aojf
  extends aofy<aoje>
{
  public int a()
  {
    return 168;
  }
  
  @NonNull
  public aoje a(int paramInt)
  {
    return new aoje();
  }
  
  @Nullable
  public aoje a(aogf[] paramArrayOfaogf)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaogf != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaogf.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfaogf[0] != null)
        {
          localObject1 = aoje.a(paramArrayOfaogf[0].a);
          paramArrayOfaogf = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfaogf instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfaogf).getManager(217)).b(((aoje)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public Class<aoje> a()
  {
    return aoje.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoje paramaoje)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramaoje.toString());
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
 * Qualified Name:     aojf
 * JD-Core Version:    0.7.0.1
 */