import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amdh
  extends alzl<amdf>
{
  @NonNull
  public static amdf a()
  {
    amdf localamdf2 = (amdf)alzw.a().a(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localamdf2);
    }
    amdf localamdf1 = localamdf2;
    if (localamdf2 == null) {
      localamdf1 = new amdf();
    }
    return localamdf1;
  }
  
  public int a()
  {
    return 458;
  }
  
  @NonNull
  public amdf a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new amdf();
  }
  
  @Nullable
  public amdf a(alzs[] paramArrayOfalzs)
  {
    return amdf.a(paramArrayOfalzs);
  }
  
  public Class<amdf> a()
  {
    return amdf.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amdf paramamdf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramamdf.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(34))
      {
        ((ajnf)((QQAppInterface)localObject).getManager(34)).a = paramamdf;
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
 * Qualified Name:     amdh
 * JD-Core Version:    0.7.0.1
 */