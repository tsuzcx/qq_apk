import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amgj
  extends alzl<amgi>
{
  @NonNull
  public static amgi a()
  {
    amgi localamgi2 = (amgi)alzw.a().a(550);
    amgi localamgi1 = localamgi2;
    if (localamgi2 == null) {
      localamgi1 = new amgi();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localamgi1.toString());
    }
    return localamgi1;
  }
  
  public int a()
  {
    return 550;
  }
  
  @NonNull
  public amgi a(int paramInt)
  {
    return new amgi();
  }
  
  @Nullable
  public amgi a(alzs[] paramArrayOfalzs)
  {
    return amgi.a(paramArrayOfalzs);
  }
  
  public Class a()
  {
    return amgi.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amgi paramamgi)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(347))
      {
        ((arxi)((QQAppInterface)localObject).getManager(347)).a = paramamgi;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramamgi.toString());
        }
      }
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
 * Qualified Name:     amgj
 * JD-Core Version:    0.7.0.1
 */