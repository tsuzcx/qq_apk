import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class arca
  extends arac<arbu>
{
  public static arbu b(int paramInt)
  {
    arbu localarbu = (arbu)aran.a().a(paramInt);
    if (localarbu != null) {
      return localarbu;
    }
    return new arbu();
  }
  
  @NonNull
  public arbu a(int paramInt)
  {
    return new arbu();
  }
  
  public arbu a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    return new arbu(paramString);
  }
  
  @Nullable
  public arbu a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + type());
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = paramArrayOfaraj[0].a;
      if (!TextUtils.isEmpty(paramArrayOfaraj)) {
        return a(paramArrayOfaraj);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + type());
    }
    return null;
  }
  
  public void a(arbu paramarbu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onUpdate]  config type = " + type());
    }
  }
  
  public Class<arbu> clazz()
  {
    return arbu.class;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("ArkConfProcessor", 1, "[onReqFailed] failCode=" + paramInt + ", config type = " + type());
  }
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
  }
  
  public int type()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arca
 * JD-Core Version:    0.7.0.1
 */