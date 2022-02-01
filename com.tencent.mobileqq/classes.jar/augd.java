import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class augd
  extends aptq<augc>
{
  private augn a()
  {
    try
    {
      augn localaugn = augn.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localaugn;
    }
    catch (Exception localException) {}
    return null;
  }
  
  @NonNull
  public augc a(int paramInt)
  {
    augc localaugc = new augc();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localaugc;
  }
  
  @Nullable
  public augc a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      augc localaugc = augc.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localaugc;
    }
    return null;
  }
  
  public void a(augc paramaugc)
  {
    augn localaugn = a();
    if (localaugn != null) {
      localaugn.b(paramaugc.a);
    }
  }
  
  public Class<augc> clazz()
  {
    return augc.class;
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
      return augn.a(localQQAppInterface);
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
 * Qualified Name:     augd
 * JD-Core Version:    0.7.0.1
 */