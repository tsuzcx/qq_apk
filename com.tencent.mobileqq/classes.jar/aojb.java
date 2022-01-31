import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aojb
  extends aofy<aoja>
{
  public int a()
  {
    return 453;
  }
  
  @NonNull
  public aoja a(int paramInt)
  {
    return new aoja();
  }
  
  @Nullable
  public aoja a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aoja localaoja = aoja.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DonDisturbProcessor", 0, "onParsed don disturb" + paramArrayOfaogf[0].a);
      }
      return localaoja;
    }
    return new aoja();
  }
  
  public Class<aoja> a()
  {
    return aoja.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoja paramaoja)
  {
    bdiv.a(BaseApplicationImpl.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramaoja.a());
    if (QLog.isColorLevel()) {
      QLog.d("DonDisturbProcessor", 0, "onUpdate don disturb" + paramaoja);
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
 * Qualified Name:     aojb
 * JD-Core Version:    0.7.0.1
 */