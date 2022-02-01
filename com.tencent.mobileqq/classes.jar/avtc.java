import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class avtc
  extends arac<avtb>
{
  private avtm a()
  {
    try
    {
      avtm localavtm = avtm.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localavtm;
    }
    catch (Exception localException) {}
    return null;
  }
  
  @NonNull
  public avtb a(int paramInt)
  {
    avtb localavtb = new avtb();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localavtb;
  }
  
  @Nullable
  public avtb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      avtb localavtb = avtb.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localavtb;
    }
    return null;
  }
  
  public void a(avtb paramavtb)
  {
    avtm localavtm = a();
    if (localavtm != null) {
      localavtm.b(paramavtb.a);
    }
  }
  
  public Class<avtb> clazz()
  {
    return avtb.class;
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
      return avtm.a(localQQAppInterface);
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
 * Qualified Name:     avtc
 * JD-Core Version:    0.7.0.1
 */