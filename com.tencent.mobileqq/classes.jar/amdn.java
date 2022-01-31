import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amdn
  extends alzl<amdk>
{
  public static amdk b(int paramInt)
  {
    amdk localamdk = (amdk)alzw.a().a(paramInt);
    if (localamdk != null) {
      return localamdk;
    }
    return new amdk();
  }
  
  public int a()
  {
    return 466;
  }
  
  @NonNull
  public amdk a(int paramInt)
  {
    return new amdk();
  }
  
  @Nullable
  public amdk a(alzs[] paramArrayOfalzs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfalzs != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfalzs.length > 0)
      {
        localObject1 = paramArrayOfalzs[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfalzs = (amdl)amaf.a(localObject1, amdl.class);
      localObject1 = new amdk((String)localObject1, paramArrayOfalzs);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfalzs)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfalzs);
        paramArrayOfalzs = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<amdk> a()
  {
    return amdk.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amdk paramamdk)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramamdk.a());
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdn
 * JD-Core Version:    0.7.0.1
 */