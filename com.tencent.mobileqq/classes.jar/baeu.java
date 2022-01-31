import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class baeu
  extends ampb<baev>
{
  public static baev a()
  {
    baev localbaev = (baev)ampm.a().a(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + localbaev);
    }
    return localbaev;
  }
  
  public int a()
  {
    return 547;
  }
  
  @NonNull
  public baev a(int paramInt)
  {
    return new baev();
  }
  
  @Nullable
  public baev a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length == 0)) {
      return null;
    }
    paramArrayOfampi = paramArrayOfampi[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfampi);
    }
    return baev.a(paramArrayOfampi);
  }
  
  public Class<baev> a()
  {
    return baev.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(baev parambaev) {}
  
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
 * Qualified Name:     baeu
 * JD-Core Version:    0.7.0.1
 */