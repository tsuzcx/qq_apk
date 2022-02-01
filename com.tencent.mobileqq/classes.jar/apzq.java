import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apzq
  extends aptq<apzp>
{
  public static boolean a()
  {
    apzp localapzp = (apzp)apub.a().a(675);
    if (localapzp != null) {}
    for (boolean bool = localapzp.a();; bool = true)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "isEnableIFrame = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public apzp a(int paramInt)
  {
    return new apzp();
  }
  
  @Nullable
  public apzp a(aptx[] paramArrayOfaptx)
  {
    int i = 0;
    if (paramArrayOfaptx == null) {}
    for (;;)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
        break;
      }
      new apzp();
      return apzp.a(paramArrayOfaptx);
      i = paramArrayOfaptx.length;
    }
    return null;
  }
  
  public void a(apzp paramapzp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkIFrameProcessor", 2, "onUpdate " + paramapzp.toString());
    }
  }
  
  public Class<apzp> clazz()
  {
    return apzp.class;
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
 * Qualified Name:     apzq
 * JD-Core Version:    0.7.0.1
 */