import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfp
  extends aqwt<arfo>
{
  @NonNull
  public arfo a(int paramInt)
  {
    return new arfo();
  }
  
  @Nullable
  public arfo a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arfo localarfo = arfo.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarfo;
    }
    return new arfo();
  }
  
  public void a(arfo paramarfo) {}
  
  public Class<arfo> clazz()
  {
    return arfo.class;
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
 * Qualified Name:     arfp
 * JD-Core Version:    0.7.0.1
 */