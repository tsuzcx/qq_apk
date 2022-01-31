import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class aono
  extends aokh<aonn>
{
  public int a()
  {
    return 168;
  }
  
  @NonNull
  public aonn a(int paramInt)
  {
    return new aonn();
  }
  
  @Nullable
  public aonn a(aoko[] paramArrayOfaoko)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaoko != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaoko.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfaoko[0] != null)
        {
          localObject1 = aonn.a(paramArrayOfaoko[0].a);
          paramArrayOfaoko = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfaoko instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfaoko).getManager(217)).b(((aonn)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public Class<aonn> a()
  {
    return aonn.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aonn paramaonn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramaonn.toString());
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
 * Qualified Name:     aono
 * JD-Core Version:    0.7.0.1
 */