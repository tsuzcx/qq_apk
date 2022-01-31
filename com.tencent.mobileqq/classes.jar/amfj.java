import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amfj
  extends alzl<amfk>
{
  public int a()
  {
    return 368;
  }
  
  @NonNull
  public amfk a(int paramInt)
  {
    return new amfk();
  }
  
  @Nullable
  public amfk a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amfk localamfk = new amfk();
      localamfk.a(paramArrayOfalzs);
      return localamfk;
    }
    return new amfk();
  }
  
  public Class<amfk> a()
  {
    return amfk.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amfk paramamfk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)obz.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return baig.N(localQQAppInterface.getApp(), str);
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
 * Qualified Name:     amfj
 * JD-Core Version:    0.7.0.1
 */