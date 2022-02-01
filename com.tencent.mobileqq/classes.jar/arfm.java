import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arfm
  extends arac<arfk>
{
  @NonNull
  public static arfk a()
  {
    arfk localarfk2 = (arfk)aran.a().a(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localarfk2);
    }
    arfk localarfk1 = localarfk2;
    if (localarfk2 == null) {
      localarfk1 = new arfk();
    }
    return localarfk1;
  }
  
  @NonNull
  public arfk a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new arfk();
  }
  
  @Nullable
  public arfk a(araj[] paramArrayOfaraj)
  {
    return arfk.a(paramArrayOfaraj);
  }
  
  public void a(arfk paramarfk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramarfk.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(34))
      {
        ((ajka)((QQAppInterface)localObject).getManager(34)).a = paramarfk;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate bean");
        }
      }
    }
  }
  
  public Class<arfk> clazz()
  {
    return arfk.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 458;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfm
 * JD-Core Version:    0.7.0.1
 */