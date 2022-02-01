import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apva
  extends aptq<apvb>
{
  public static apvb a()
  {
    return (apvb)apub.a().a(655);
  }
  
  @NonNull
  public apvb a(int paramInt)
  {
    return new apvb();
  }
  
  @Nullable
  public apvb a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return apvb.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(apvb paramapvb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionConfProcessor", 2, "AIORelatedEmotionConfProcessor onUpdate");
    }
  }
  
  public Class<apvb> clazz()
  {
    return apvb.class;
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
    return 655;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apva
 * JD-Core Version:    0.7.0.1
 */