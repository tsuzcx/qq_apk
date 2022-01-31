import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ampz
  extends ampb<amqa>
{
  public static amqa a()
  {
    return (amqa)ampm.a().a(457);
  }
  
  public int a()
  {
    return 457;
  }
  
  @NonNull
  public amqa a(int paramInt)
  {
    return new amqa();
  }
  
  @Nullable
  public amqa a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length == 0)) {
      return null;
    }
    paramArrayOfampi = paramArrayOfampi[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfampi);
    }
    return amqa.a(paramArrayOfampi);
  }
  
  public Class<amqa> a()
  {
    return amqa.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amqa paramamqa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((akac)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(159)).a();
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
 * Qualified Name:     ampz
 * JD-Core Version:    0.7.0.1
 */