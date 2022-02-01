import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqqx
  extends aqkz<aqqv>
{
  public static aqqv b(int paramInt)
  {
    aqqv localaqqv = (aqqv)aqlk.a().a(paramInt);
    if (localaqqv != null) {
      return localaqqv;
    }
    return new aqqv();
  }
  
  @NonNull
  public aqqv a(int paramInt)
  {
    return new aqqv();
  }
  
  @Nullable
  public aqqv a(aqlg[] paramArrayOfaqlg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqlg != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqlg.length > 0)
      {
        localObject1 = paramArrayOfaqlg[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaqlg = (aqqw)aqlu.a(localObject1, aqqw.class);
      localObject1 = new aqqv((String)localObject1, paramArrayOfaqlg);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaqlg)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaqlg);
        paramArrayOfaqlg = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(aqqv paramaqqv)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramaqqv.a());
  }
  
  public Class<aqqv> clazz()
  {
    return aqqv.class;
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
 * Qualified Name:     aqqx
 * JD-Core Version:    0.7.0.1
 */