import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arer
  extends aqwt<areq>
{
  public static areq a()
  {
    return (areq)aqxe.a().a(631);
  }
  
  @NonNull
  public areq a(int paramInt)
  {
    return new areq();
  }
  
  @Nullable
  public areq a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      new areq();
      return areq.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(areq paramareq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePreloadConfProcessor", 2, "onUpdate " + paramareq.toString());
    }
  }
  
  public Class<areq> clazz()
  {
    return areq.class;
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
      QLog.d("QQGamePreloadConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 631;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arer
 * JD-Core Version:    0.7.0.1
 */