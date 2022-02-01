import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ardm
  extends aqwt<ardl>
{
  @NonNull
  public ardl a(int paramInt)
  {
    return new ardl();
  }
  
  @Nullable
  public ardl a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      ardl localardl = ardl.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localardl;
    }
    return null;
  }
  
  public void a(ardl paramardl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramardl.toString());
    }
  }
  
  public Class<ardl> clazz()
  {
    return ardl.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 442;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardm
 * JD-Core Version:    0.7.0.1
 */