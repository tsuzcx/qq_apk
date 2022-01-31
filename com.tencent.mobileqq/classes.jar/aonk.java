import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aonk
  extends aokh<aonj>
{
  public int a()
  {
    return 453;
  }
  
  @NonNull
  public aonj a(int paramInt)
  {
    return new aonj();
  }
  
  @Nullable
  public aonj a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aonj localaonj = aonj.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DonDisturbProcessor", 0, "onParsed don disturb" + paramArrayOfaoko[0].a);
      }
      return localaonj;
    }
    return new aonj();
  }
  
  public Class<aonj> a()
  {
    return aonj.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aonj paramaonj)
  {
    bdne.a(BaseApplicationImpl.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramaonj.a());
    if (QLog.isColorLevel()) {
      QLog.d("DonDisturbProcessor", 0, "onUpdate don disturb" + paramaonj);
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
 * Qualified Name:     aonk
 * JD-Core Version:    0.7.0.1
 */