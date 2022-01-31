import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amvm
  extends ampa<amvn>
{
  public int a()
  {
    return 92;
  }
  
  @NonNull
  public amvn a(int paramInt)
  {
    return new amvn();
  }
  
  @Nullable
  public amvn a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amvn localamvn = new amvn();
      localamvn.a(paramArrayOfamph);
      return localamvn;
    }
    return new amvn();
  }
  
  public Class<amvn> a()
  {
    return amvn.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amvn paramamvn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onh.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return bbkb.M(localQQAppInterface.getApp(), str);
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
 * Qualified Name:     amvm
 * JD-Core Version:    0.7.0.1
 */