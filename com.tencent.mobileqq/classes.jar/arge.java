import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arge
  extends arac<argb>
{
  public static argb b(int paramInt)
  {
    argb localargb = (argb)aran.a().a(paramInt);
    if (localargb != null) {
      return localargb;
    }
    return new argb();
  }
  
  @NonNull
  public argb a(int paramInt)
  {
    return new argb();
  }
  
  @Nullable
  public argb a(araj[] paramArrayOfaraj)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaraj != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaraj.length > 0)
      {
        localObject1 = paramArrayOfaraj[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaraj = (argc)arax.a(localObject1, argc.class);
      localObject1 = new argb((String)localObject1, paramArrayOfaraj);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaraj)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaraj);
        paramArrayOfaraj = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(argb paramargb)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramargb.a());
  }
  
  public Class<argb> clazz()
  {
    return argb.class;
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
 * Qualified Name:     arge
 * JD-Core Version:    0.7.0.1
 */