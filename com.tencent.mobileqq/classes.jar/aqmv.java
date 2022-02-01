import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aqmv
  extends aqkz<aqmp>
{
  public static aqmp b(int paramInt)
  {
    aqmp localaqmp = (aqmp)aqlk.a().a(paramInt);
    if (localaqmp != null) {
      return localaqmp;
    }
    return new aqmp();
  }
  
  @NonNull
  public aqmp a(int paramInt)
  {
    return new aqmp();
  }
  
  public aqmp a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    return new aqmp(paramString);
  }
  
  @Nullable
  public aqmp a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + type());
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      paramArrayOfaqlg = paramArrayOfaqlg[0].a;
      if (!TextUtils.isEmpty(paramArrayOfaqlg)) {
        return a(paramArrayOfaqlg);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + type());
    }
    return null;
  }
  
  public void a(aqmp paramaqmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onUpdate]  config type = " + type());
    }
  }
  
  public Class<aqmp> clazz()
  {
    return aqmp.class;
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
 * Qualified Name:     aqmv
 * JD-Core Version:    0.7.0.1
 */