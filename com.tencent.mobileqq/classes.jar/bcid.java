import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bcid
  extends aokh<bcie>
{
  public static bcie a()
  {
    bcie localbcie = (bcie)aoks.a().a(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + localbcie);
    }
    return localbcie;
  }
  
  public int a()
  {
    return 547;
  }
  
  @NonNull
  public bcie a(int paramInt)
  {
    return new bcie();
  }
  
  @Nullable
  public bcie a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length == 0)) {
      return null;
    }
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfaoko);
    }
    return bcie.a(paramArrayOfaoko);
  }
  
  public Class<bcie> a()
  {
    return bcie.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(bcie parambcie) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcid
 * JD-Core Version:    0.7.0.1
 */