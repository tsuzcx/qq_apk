import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ardh
  extends aqwt<ardi>
{
  @NonNull
  public ardi a(int paramInt)
  {
    return new ardi();
  }
  
  @Nullable
  public ardi a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + paramArrayOfaqxa);
      }
      return ardi.a(paramArrayOfaqxa);
    }
    return new ardi();
  }
  
  public void a(ardi paramardi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return ardi.class;
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
 * Qualified Name:     ardh
 * JD-Core Version:    0.7.0.1
 */