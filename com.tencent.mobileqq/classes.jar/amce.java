import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class amce
  extends alzl<amcd>
{
  public int a()
  {
    return 453;
  }
  
  @NonNull
  public amcd a(int paramInt)
  {
    return new amcd();
  }
  
  @Nullable
  public amcd a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amcd localamcd = amcd.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DonDisturbProcessor", 0, "onParsed don disturb" + paramArrayOfalzs[0].a);
      }
      return localamcd;
    }
    return new amcd();
  }
  
  public Class<amcd> a()
  {
    return amcd.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amcd paramamcd)
  {
    baig.a(BaseApplicationImpl.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramamcd.a());
    if (QLog.isColorLevel()) {
      QLog.d("DonDisturbProcessor", 0, "onUpdate don disturb" + paramamcd);
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
 * Qualified Name:     amce
 * JD-Core Version:    0.7.0.1
 */