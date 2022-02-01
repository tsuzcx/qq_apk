import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apxj
  extends aptq<apxk>
{
  public static apxk a()
  {
    return (apxk)apub.a().a(620);
  }
  
  @NonNull
  public apxk a(int paramInt)
  {
    return new apxk();
  }
  
  @Nullable
  public apxk a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return apxk.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(apxk paramapxk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonSearchTagsConfProcessor", 2, "EmoticonSearchTagsConfProcessor onUpdate");
    }
  }
  
  public Class<apxk> clazz()
  {
    return apxk.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 620;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxj
 * JD-Core Version:    0.7.0.1
 */