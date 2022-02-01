import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arcx
  extends aqwt<arcu>
{
  public static arcu b(int paramInt)
  {
    arcu localarcu = (arcu)aqxe.a().a(paramInt);
    if (localarcu != null) {
      return localarcu;
    }
    return new arcu();
  }
  
  @NonNull
  public arcu a(int paramInt)
  {
    return new arcu();
  }
  
  @Nullable
  public arcu a(aqxa[] paramArrayOfaqxa)
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
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaqxa = (arcv)aqxo.a(localObject1, arcv.class);
      localObject1 = new arcu((String)localObject1, paramArrayOfaqxa);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaqxa)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaqxa);
        paramArrayOfaqxa = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(arcu paramarcu)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramarcu.a());
  }
  
  public Class<arcu> clazz()
  {
    return arcu.class;
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
    return 466;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcx
 * JD-Core Version:    0.7.0.1
 */