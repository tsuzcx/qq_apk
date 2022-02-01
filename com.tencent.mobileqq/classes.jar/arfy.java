import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfy
  extends arac<arfx>
{
  public static boolean a()
  {
    arfx localarfx = (arfx)aran.a().a(632);
    if (localarfx != null) {}
    for (boolean bool = localarfx.a();; bool = false)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "isEnableFakeMsg = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public arfx a(int paramInt)
  {
    return new arfx();
  }
  
  @Nullable
  public arfx a(araj[] paramArrayOfaraj)
  {
    int i = 0;
    if (paramArrayOfaraj == null) {}
    for (;;)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
        break;
      }
      new arfx();
      return arfx.a(paramArrayOfaraj);
      i = paramArrayOfaraj.length;
    }
    return null;
  }
  
  public void a(arfx paramarfx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 2, "onUpdate " + paramarfx.toString());
    }
  }
  
  public Class<arfx> clazz()
  {
    return arfx.class;
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
    return 632;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfy
 * JD-Core Version:    0.7.0.1
 */