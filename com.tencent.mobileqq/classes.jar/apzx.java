import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class apzx
  extends aptq<apzv>
{
  public static apzv b(int paramInt)
  {
    apzv localapzv = (apzv)apub.a().a(paramInt);
    if (localapzv != null) {
      return localapzv;
    }
    return new apzv();
  }
  
  @NonNull
  public apzv a(int paramInt)
  {
    return new apzv();
  }
  
  @Nullable
  public apzv a(aptx[] paramArrayOfaptx)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaptx != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaptx.length > 0)
      {
        localObject1 = paramArrayOfaptx[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaptx = (apzw)apul.a(localObject1, apzw.class);
      localObject1 = new apzv((String)localObject1, paramArrayOfaptx);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaptx)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaptx);
        paramArrayOfaptx = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(apzv paramapzv)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramapzv.a());
  }
  
  public Class<apzv> clazz()
  {
    return apzv.class;
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
 * Qualified Name:     apzx
 * JD-Core Version:    0.7.0.1
 */