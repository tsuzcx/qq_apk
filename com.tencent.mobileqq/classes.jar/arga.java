import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arga
  extends arac<arfz>
{
  public static boolean a()
  {
    arfz localarfz = (arfz)aran.a().a(675);
    if (localarfz != null) {}
    for (boolean bool = localarfz.a();; bool = true)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "isEnableIFrame = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public arfz a(int paramInt)
  {
    return new arfz();
  }
  
  @Nullable
  public arfz a(araj[] paramArrayOfaraj)
  {
    int i = 0;
    if (paramArrayOfaraj == null) {}
    for (;;)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
        break;
      }
      new arfz();
      return arfz.a(paramArrayOfaraj);
      i = paramArrayOfaraj.length;
    }
    return null;
  }
  
  public void a(arfz paramarfz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkIFrameProcessor", 2, "onUpdate " + paramarfz.toString());
    }
  }
  
  public Class<arfz> clazz()
  {
    return arfz.class;
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
    return 675;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arga
 * JD-Core Version:    0.7.0.1
 */