import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arcp
  extends aqwt<arco>
{
  public static boolean a()
  {
    arco localarco = (arco)aqxe.a().a(613);
    if (localarco != null) {}
    for (boolean bool = localarco.a();; bool = false)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "isSwitchOpen = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public arco a(int paramInt)
  {
    return new arco();
  }
  
  @Nullable
  public arco a(aqxa[] paramArrayOfaqxa)
  {
    int i = 0;
    if (paramArrayOfaqxa == null) {}
    for (;;)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
        break;
      }
      new arco();
      return arco.a(paramArrayOfaqxa);
      i = paramArrayOfaqxa.length;
    }
    return null;
  }
  
  public void a(arco paramarco)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkD55Processor", 2, "onUpdate " + paramarco.toString());
    }
  }
  
  public Class<arco> clazz()
  {
    return arco.class;
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
    return 613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcp
 * JD-Core Version:    0.7.0.1
 */