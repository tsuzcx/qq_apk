import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aqyt
  extends aqwt<aqyn>
{
  public static aqyn b(int paramInt)
  {
    aqyn localaqyn = (aqyn)aqxe.a().a(paramInt);
    if (localaqyn != null) {
      return localaqyn;
    }
    return new aqyn();
  }
  
  @NonNull
  public aqyn a(int paramInt)
  {
    return new aqyn();
  }
  
  public aqyn a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    return new aqyn(paramString);
  }
  
  @Nullable
  public aqyn a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + type());
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      if (!TextUtils.isEmpty(paramArrayOfaqxa)) {
        return a(paramArrayOfaqxa);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + type());
    }
    return null;
  }
  
  public void a(aqyn paramaqyn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onUpdate]  config type = " + type());
    }
  }
  
  public Class<aqyn> clazz()
  {
    return aqyn.class;
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
 * Qualified Name:     aqyt
 * JD-Core Version:    0.7.0.1
 */