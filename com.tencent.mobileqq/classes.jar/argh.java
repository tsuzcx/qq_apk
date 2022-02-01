import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class argh
  extends arac<argf>
{
  public static argf b(int paramInt)
  {
    argf localargf = (argf)aran.a().a(paramInt);
    if (localargf != null) {
      return localargf;
    }
    return new argf();
  }
  
  @NonNull
  public argf a(int paramInt)
  {
    return new argf();
  }
  
  @Nullable
  public argf a(araj[] paramArrayOfaraj)
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
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaraj = (argg)arax.a(localObject1, argg.class);
      localObject1 = new argf((String)localObject1, paramArrayOfaraj);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaraj)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaraj);
        paramArrayOfaraj = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(argf paramargf)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramargf.a());
  }
  
  public Class<argf> clazz()
  {
    return argf.class;
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
 * Qualified Name:     argh
 * JD-Core Version:    0.7.0.1
 */