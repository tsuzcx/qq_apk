import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aons
  extends aokh<aonr>
{
  public int a()
  {
    return 417;
  }
  
  @NonNull
  public aonr a(int paramInt)
  {
    return new aonr();
  }
  
  @Nullable
  public aonr a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aonr localaonr = new aonr();
      localaonr.a = paramArrayOfaoko[0].a;
      return localaonr;
    }
    return null;
  }
  
  public Class<aonr> a()
  {
    return aonr.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    aonr localaonr = (aonr)aoks.a().a(417);
    if (localaonr != null) {
      ((aknx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).d(localaonr.a);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aonr paramaonr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    aknx localaknx = (aknx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramaonr != null) {}
    for (paramaonr = paramaonr.a;; paramaonr = null)
    {
      localaknx.d(paramaonr);
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
 * Qualified Name:     aons
 * JD-Core Version:    0.7.0.1
 */