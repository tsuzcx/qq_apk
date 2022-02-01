import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class avba
  extends aqkz<avaz>
{
  private avbk a()
  {
    try
    {
      avbk localavbk = avbk.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localavbk;
    }
    catch (Exception localException) {}
    return null;
  }
  
  @NonNull
  public avaz a(int paramInt)
  {
    avaz localavaz = new avaz();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localavaz;
  }
  
  @Nullable
  public avaz a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      avaz localavaz = avaz.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localavaz;
    }
    return null;
  }
  
  public void a(avaz paramavaz)
  {
    avbk localavbk = a();
    if (localavbk != null) {
      localavbk.b(paramavaz.a);
    }
  }
  
  public Class<avaz> clazz()
  {
    return avaz.class;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      return avbk.a(localQQAppInterface);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 164;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avba
 * JD-Core Version:    0.7.0.1
 */