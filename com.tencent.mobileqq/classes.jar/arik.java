import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arik
  extends arac<aril>
{
  @NonNull
  public aril a(int paramInt)
  {
    return new aril();
  }
  
  @Nullable
  public aril a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      aril localaril = new aril();
      localaril.a(paramArrayOfaraj);
      return localaril;
    }
    return new aril();
  }
  
  public void a(aril paramaril)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<aril> clazz()
  {
    return aril.class;
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
      return bhsi.M(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 92;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arik
 * JD-Core Version:    0.7.0.1
 */