import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arim
  extends arac<arin>
{
  @NonNull
  public arin a(int paramInt)
  {
    return new arin();
  }
  
  @Nullable
  public arin a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      arin localarin = new arin();
      localarin.a(paramArrayOfaraj);
      return localarin;
    }
    return new arin();
  }
  
  public void a(arin paramarin)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<arin> clazz()
  {
    return arin.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ozs.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return bhsi.N(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 368;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arim
 * JD-Core Version:    0.7.0.1
 */