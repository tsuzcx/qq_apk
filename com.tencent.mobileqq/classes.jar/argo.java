import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argo
  extends arac<argp>
{
  @NonNull
  public argp a(int paramInt)
  {
    return new argp();
  }
  
  @Nullable
  public argp a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = paramArrayOfaraj[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + paramArrayOfaraj);
      }
      return argp.a(paramArrayOfaraj);
    }
    return new argp();
  }
  
  public void a(argp paramargp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return argp.class;
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
      QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 530;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argo
 * JD-Core Version:    0.7.0.1
 */