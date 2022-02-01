import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqqe
  extends aqkz<aqqc>
{
  @NonNull
  public static aqqc a()
  {
    aqqc localaqqc2 = (aqqc)aqlk.a().a(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localaqqc2);
    }
    aqqc localaqqc1 = localaqqc2;
    if (localaqqc2 == null) {
      localaqqc1 = new aqqc();
    }
    return localaqqc1;
  }
  
  @NonNull
  public aqqc a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new aqqc();
  }
  
  @Nullable
  public aqqc a(aqlg[] paramArrayOfaqlg)
  {
    return aqqc.a(paramArrayOfaqlg);
  }
  
  public void a(aqqc paramaqqc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramaqqc.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(34))
      {
        ((aiyr)((QQAppInterface)localObject).getManager(34)).a = paramaqqc;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate bean");
        }
      }
    }
  }
  
  public Class<aqqc> clazz()
  {
    return aqqc.class;
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
 * Qualified Name:     aqqe
 * JD-Core Version:    0.7.0.1
 */