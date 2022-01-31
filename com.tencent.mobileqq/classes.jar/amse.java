import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class amse
  extends ampb<amsd>
{
  public int a()
  {
    return 453;
  }
  
  @NonNull
  public amsd a(int paramInt)
  {
    return new amsd();
  }
  
  @Nullable
  public amsd a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amsd localamsd = amsd.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DonDisturbProcessor", 0, "onParsed don disturb" + paramArrayOfampi[0].a);
      }
      return localamsd;
    }
    return new amsd();
  }
  
  public Class<amsd> a()
  {
    return amsd.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsd paramamsd)
  {
    bbjn.a(BaseApplicationImpl.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramamsd.a());
    if (QLog.isColorLevel()) {
      QLog.d("DonDisturbProcessor", 0, "onUpdate don disturb" + paramamsd);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amse
 * JD-Core Version:    0.7.0.1
 */