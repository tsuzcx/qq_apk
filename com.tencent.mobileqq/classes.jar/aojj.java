import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aojj
  extends aofy<aoji>
{
  public int a()
  {
    return 417;
  }
  
  @NonNull
  public aoji a(int paramInt)
  {
    return new aoji();
  }
  
  @Nullable
  public aoji a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aoji localaoji = new aoji();
      localaoji.a = paramArrayOfaogf[0].a;
      return localaoji;
    }
    return null;
  }
  
  public Class<aoji> a()
  {
    return aoji.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    aoji localaoji = (aoji)aogj.a().a(417);
    if (localaoji != null) {
      ((akji)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).d(localaoji.a);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aoji paramaoji)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    akji localakji = (akji)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramaoji != null) {}
    for (paramaoji = paramaoji.a;; paramaoji = null)
    {
      localakji.d(paramaoji);
      return;
    }
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
 * Qualified Name:     aojj
 * JD-Core Version:    0.7.0.1
 */