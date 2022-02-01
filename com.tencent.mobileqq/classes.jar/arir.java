import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arir
  extends arac<ariq>
{
  @NonNull
  public ariq a(int paramInt)
  {
    return new ariq();
  }
  
  @Nullable
  public ariq a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      ariq localariq = ariq.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localariq;
    }
    return new ariq();
  }
  
  public void a(ariq paramariq) {}
  
  public Class<ariq> clazz()
  {
    return ariq.class;
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
    return 490;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arir
 * JD-Core Version:    0.7.0.1
 */