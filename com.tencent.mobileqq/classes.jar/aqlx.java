import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqlx
  extends aqkz<aqly>
{
  public static aqly a()
  {
    return (aqly)aqlk.a().a(457);
  }
  
  @NonNull
  public aqly a(int paramInt)
  {
    return new aqly();
  }
  
  @Nullable
  public aqly a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length == 0)) {
      return null;
    }
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfaqlg);
    }
    return aqly.a(paramArrayOfaqlg);
  }
  
  public void a(aqly paramaqly)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((anpk)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(159)).a();
  }
  
  public Class<aqly> clazz()
  {
    return aqly.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 457;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqlx
 * JD-Core Version:    0.7.0.1
 */