import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arep
  extends aqwt<areo>
{
  public static areo a()
  {
    return (areo)aqxe.a().a(441);
  }
  
  @NonNull
  public areo a(int paramInt)
  {
    return new areo();
  }
  
  @Nullable
  public areo a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      new areo();
      return areo.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(areo paramareo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramareo.toString());
    }
  }
  
  public Class<areo> clazz()
  {
    return areo.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 441;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arep
 * JD-Core Version:    0.7.0.1
 */