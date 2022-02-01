import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class apvq
  extends aptq<apvk>
{
  public static apvk b(int paramInt)
  {
    apvk localapvk = (apvk)apub.a().a(paramInt);
    if (localapvk != null) {
      return localapvk;
    }
    return new apvk();
  }
  
  @NonNull
  public apvk a(int paramInt)
  {
    return new apvk();
  }
  
  public apvk a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    return new apvk(paramString);
  }
  
  @Nullable
  public apvk a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + type());
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      paramArrayOfaptx = paramArrayOfaptx[0].a;
      if (!TextUtils.isEmpty(paramArrayOfaptx)) {
        return a(paramArrayOfaptx);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + type());
    }
    return null;
  }
  
  public void a(apvk paramapvk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onUpdate]  config type = " + type());
    }
  }
  
  public Class<apvk> clazz()
  {
    return apvk.class;
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
 * Qualified Name:     apvq
 * JD-Core Version:    0.7.0.1
 */