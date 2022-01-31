import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aolf
  extends aokh<aolg>
{
  public static aolg a()
  {
    return (aolg)aoks.a().a(457);
  }
  
  public int a()
  {
    return 457;
  }
  
  @NonNull
  public aolg a(int paramInt)
  {
    return new aolg();
  }
  
  @Nullable
  public aolg a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length == 0)) {
      return null;
    }
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfaoko);
    }
    return aolg.a(paramArrayOfaoko);
  }
  
  public Class<aolg> a()
  {
    return aolg.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aolg paramaolg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((alwd)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(159)).a();
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
 * Qualified Name:     aolf
 * JD-Core Version:    0.7.0.1
 */