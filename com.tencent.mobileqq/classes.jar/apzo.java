import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apzo
  extends aptq<apzn>
{
  public static boolean a()
  {
    apzn localapzn = (apzn)apub.a().a(632);
    if (localapzn != null) {}
    for (boolean bool = localapzn.a();; bool = false)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "isEnableFakeMsg = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public apzn a(int paramInt)
  {
    return new apzn();
  }
  
  @Nullable
  public apzn a(aptx[] paramArrayOfaptx)
  {
    int i = 0;
    if (paramArrayOfaptx == null) {}
    for (;;)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
        break;
      }
      new apzn();
      return apzn.a(paramArrayOfaptx);
      i = paramArrayOfaptx.length;
    }
    return null;
  }
  
  public void a(apzn paramapzn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 2, "onUpdate " + paramapzn.toString());
    }
  }
  
  public Class<apzn> clazz()
  {
    return apzn.class;
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
 * Qualified Name:     apzo
 * JD-Core Version:    0.7.0.1
 */