import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class amsd
  extends ampa<amsc>
{
  public int a()
  {
    return 453;
  }
  
  @NonNull
  public amsc a(int paramInt)
  {
    return new amsc();
  }
  
  @Nullable
  public amsc a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amsc localamsc = amsc.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DonDisturbProcessor", 0, "onParsed don disturb" + paramArrayOfamph[0].a);
      }
      return localamsc;
    }
    return new amsc();
  }
  
  public Class<amsc> a()
  {
    return amsc.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsc paramamsc)
  {
    bbkb.a(BaseApplicationImpl.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramamsc.a());
    if (QLog.isColorLevel()) {
      QLog.d("DonDisturbProcessor", 0, "onUpdate don disturb" + paramamsc);
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
 * Qualified Name:     amsd
 * JD-Core Version:    0.7.0.1
 */