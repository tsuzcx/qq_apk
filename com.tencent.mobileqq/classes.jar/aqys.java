import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqys
  extends ampb<aqyr>
{
  private aqzc a()
  {
    try
    {
      aqzc localaqzc = aqzc.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localaqzc;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int a()
  {
    return 164;
  }
  
  @NonNull
  public aqyr a(int paramInt)
  {
    aqyr localaqyr = new aqyr();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localaqyr;
  }
  
  @Nullable
  public aqyr a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      aqyr localaqyr = aqyr.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localaqyr;
    }
    return null;
  }
  
  public Class<aqyr> a()
  {
    return aqyr.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aqyr paramaqyr)
  {
    aqzc localaqzc = a();
    if (localaqzc != null) {
      localaqzc.b(paramaqyr.a);
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      return aqzc.a(localQQAppInterface);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqys
 * JD-Core Version:    0.7.0.1
 */