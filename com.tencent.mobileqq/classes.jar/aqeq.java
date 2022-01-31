import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqeq
  extends alzl<aqep>
{
  private aqfa a()
  {
    try
    {
      aqfa localaqfa = aqfa.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localaqfa;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int a()
  {
    return 164;
  }
  
  @NonNull
  public aqep a(int paramInt)
  {
    aqep localaqep = new aqep();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localaqep;
  }
  
  @Nullable
  public aqep a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      aqep localaqep = aqep.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localaqep;
    }
    return null;
  }
  
  public Class<aqep> a()
  {
    return aqep.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aqep paramaqep)
  {
    aqfa localaqfa = a();
    if (localaqfa != null) {
      localaqfa.b(paramaqep.a);
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      return aqfa.a(localQQAppInterface);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqeq
 * JD-Core Version:    0.7.0.1
 */