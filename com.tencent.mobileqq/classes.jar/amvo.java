import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amvo
  extends ampa<amvp>
{
  public int a()
  {
    return 368;
  }
  
  @NonNull
  public amvp a(int paramInt)
  {
    return new amvp();
  }
  
  @Nullable
  public amvp a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amvp localamvp = new amvp();
      localamvp.a(paramArrayOfamph);
      return localamvp;
    }
    return new amvp();
  }
  
  public Class<amvp> a()
  {
    return amvp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amvp paramamvp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onh.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return bbkb.N(localQQAppInterface.getApp(), str);
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
 * Qualified Name:     amvo
 * JD-Core Version:    0.7.0.1
 */