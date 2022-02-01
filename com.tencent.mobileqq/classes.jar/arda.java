import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arda
  extends aqwt<arcy>
{
  public static arcy b(int paramInt)
  {
    arcy localarcy = (arcy)aqxe.a().a(paramInt);
    if (localarcy != null) {
      return localarcy;
    }
    return new arcy();
  }
  
  @NonNull
  public arcy a(int paramInt)
  {
    return new arcy();
  }
  
  @Nullable
  public arcy a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqxa.length > 0)
      {
        localObject1 = paramArrayOfaqxa[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaqxa = (arcz)aqxo.a(localObject1, arcz.class);
      localObject1 = new arcy((String)localObject1, paramArrayOfaqxa);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaqxa)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaqxa);
        paramArrayOfaqxa = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(arcy paramarcy)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramarcy.a());
  }
  
  public Class<arcy> clazz()
  {
    return arcy.class;
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
    return 467;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arda
 * JD-Core Version:    0.7.0.1
 */