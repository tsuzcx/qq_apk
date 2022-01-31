import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amdq
  extends alzl<amdo>
{
  public static amdo b(int paramInt)
  {
    amdo localamdo = (amdo)alzw.a().a(paramInt);
    if (localamdo != null) {
      return localamdo;
    }
    return new amdo();
  }
  
  public int a()
  {
    return 467;
  }
  
  @NonNull
  public amdo a(int paramInt)
  {
    return new amdo();
  }
  
  @Nullable
  public amdo a(alzs[] paramArrayOfalzs)
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
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfalzs = (amdp)amaf.a(localObject1, amdp.class);
      localObject1 = new amdo((String)localObject1, paramArrayOfalzs);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfalzs)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfalzs);
        paramArrayOfalzs = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<amdo> a()
  {
    return amdo.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amdo paramamdo)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramamdo.a());
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     amdq
 * JD-Core Version:    0.7.0.1
 */