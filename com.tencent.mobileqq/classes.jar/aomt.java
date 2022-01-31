import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aomt
  extends aofy<aomu>
{
  public int a()
  {
    return 368;
  }
  
  @NonNull
  public aomu a(int paramInt)
  {
    return new aomu();
  }
  
  @Nullable
  public aomu a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aomu localaomu = new aomu();
      localaomu.a(paramArrayOfaogf);
      return localaomu;
    }
    return new aomu();
  }
  
  public Class<aomu> a()
  {
    return aomu.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aomu paramaomu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return bdiv.N(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomt
 * JD-Core Version:    0.7.0.1
 */