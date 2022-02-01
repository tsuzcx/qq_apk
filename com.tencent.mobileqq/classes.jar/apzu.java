import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class apzu
  extends aptq<apzr>
{
  public static apzr b(int paramInt)
  {
    apzr localapzr = (apzr)apub.a().a(paramInt);
    if (localapzr != null) {
      return localapzr;
    }
    return new apzr();
  }
  
  @NonNull
  public apzr a(int paramInt)
  {
    return new apzr();
  }
  
  @Nullable
  public apzr a(aptx[] paramArrayOfaptx)
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
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaptx = (apzs)apul.a(localObject1, apzs.class);
      localObject1 = new apzr((String)localObject1, paramArrayOfaptx);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaptx)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaptx);
        paramArrayOfaptx = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(apzr paramapzr)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramapzr.a());
  }
  
  public Class<apzr> clazz()
  {
    return apzr.class;
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
 * Qualified Name:     apzu
 * JD-Core Version:    0.7.0.1
 */