import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class avlx
  extends aqwt<avlw>
{
  private avmh a()
  {
    try
    {
      avmh localavmh = avmh.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localavmh;
    }
    catch (Exception localException) {}
    return null;
  }
  
  @NonNull
  public avlw a(int paramInt)
  {
    avlw localavlw = new avlw();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localavlw;
  }
  
  @Nullable
  public avlw a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      avlw localavlw = avlw.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localavlw;
    }
    return null;
  }
  
  public void a(avlw paramavlw)
  {
    avmh localavmh = a();
    if (localavmh != null) {
      localavmh.b(paramavlw.a);
    }
  }
  
  public Class<avlw> clazz()
  {
    return avlw.class;
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
      return avmh.a(localQQAppInterface);
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
 * Qualified Name:     avlx
 * JD-Core Version:    0.7.0.1
 */