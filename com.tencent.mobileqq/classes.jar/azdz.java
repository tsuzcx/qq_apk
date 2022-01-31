import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class azdz
  extends alzl<azea>
{
  public static azea a()
  {
    azea localazea = (azea)alzw.a().a(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + localazea);
    }
    return localazea;
  }
  
  public int a()
  {
    return 547;
  }
  
  @NonNull
  public azea a(int paramInt)
  {
    return new azea();
  }
  
  @Nullable
  public azea a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length == 0)) {
      return null;
    }
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfalzs);
    }
    return azea.a(paramArrayOfalzs);
  }
  
  public Class<azea> a()
  {
    return azea.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(azea paramazea) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdz
 * JD-Core Version:    0.7.0.1
 */