import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arij
  extends arac<arii>
{
  public static arii a()
  {
    return (arii)aran.a().a(292);
  }
  
  @NonNull
  public arii a(int paramInt)
  {
    return new arii();
  }
  
  @Nullable
  public arii a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles = " + paramArrayOfaraj);
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfProcessor", 2, "[onParsed] confFiles[0].content= " + paramArrayOfaraj[0].a);
      }
      return arii.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(arii paramarii) {}
  
  public Class<arii> clazz()
  {
    return arii.class;
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
    return 292;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arij
 * JD-Core Version:    0.7.0.1
 */