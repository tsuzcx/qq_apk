import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aokk
  extends aofy<aoki>
{
  @NonNull
  public static aoki a()
  {
    aoki localaoki2 = (aoki)aogj.a().a(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localaoki2);
    }
    aoki localaoki1 = localaoki2;
    if (localaoki2 == null) {
      localaoki1 = new aoki();
    }
    return localaoki1;
  }
  
  public int a()
  {
    return 458;
  }
  
  @NonNull
  public aoki a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new aoki();
  }
  
  @Nullable
  public aoki a(aogf[] paramArrayOfaogf)
  {
    return aoki.a(paramArrayOfaogf);
  }
  
  public Class<aoki> a()
  {
    return aoki.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aoki paramaoki)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramaoki.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(34))
      {
        ((altc)((QQAppInterface)localObject).getManager(34)).a = paramaoki;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate bean");
        }
      }
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
 * Qualified Name:     aokk
 * JD-Core Version:    0.7.0.1
 */