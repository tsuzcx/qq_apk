import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amfh
  extends alzl<amfi>
{
  public int a()
  {
    return 92;
  }
  
  @NonNull
  public amfi a(int paramInt)
  {
    return new amfi();
  }
  
  @Nullable
  public amfi a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amfi localamfi = new amfi();
      localamfi.a(paramArrayOfalzs);
      return localamfi;
    }
    return new amfi();
  }
  
  public Class<amfi> a()
  {
    return amfi.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amfi paramamfi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)obz.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return baig.M(localQQAppInterface.getApp(), str);
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
 * Qualified Name:     amfh
 * JD-Core Version:    0.7.0.1
 */