import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqqu
  extends aqkz<aqqr>
{
  public static aqqr b(int paramInt)
  {
    aqqr localaqqr = (aqqr)aqlk.a().a(paramInt);
    if (localaqqr != null) {
      return localaqqr;
    }
    return new aqqr();
  }
  
  @NonNull
  public aqqr a(int paramInt)
  {
    return new aqqr();
  }
  
  @Nullable
  public aqqr a(aqlg[] paramArrayOfaqlg)
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
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaqlg = (aqqs)aqlu.a(localObject1, aqqs.class);
      localObject1 = new aqqr((String)localObject1, paramArrayOfaqlg);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaqlg)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaqlg);
        paramArrayOfaqlg = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(aqqr paramaqqr)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramaqqr.a());
  }
  
  public Class<aqqr> clazz()
  {
    return aqqr.class;
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
 * Qualified Name:     aqqu
 * JD-Core Version:    0.7.0.1
 */