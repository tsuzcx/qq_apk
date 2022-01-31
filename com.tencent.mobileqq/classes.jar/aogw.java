import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aogw
  extends aofy<aogx>
{
  public static aogx a()
  {
    return (aogx)aogj.a().a(457);
  }
  
  public int a()
  {
    return 457;
  }
  
  @NonNull
  public aogx a(int paramInt)
  {
    return new aogx();
  }
  
  @Nullable
  public aogx a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length == 0)) {
      return null;
    }
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfaogf);
    }
    return aogx.a(paramArrayOfaogf);
  }
  
  public Class<aogx> a()
  {
    return aogx.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aogx paramaogx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((alro)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(159)).a();
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
 * Qualified Name:     aogw
 * JD-Core Version:    0.7.0.1
 */