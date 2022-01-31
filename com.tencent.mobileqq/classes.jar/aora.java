import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aora
  extends aokh<aorb>
{
  public int a()
  {
    return 92;
  }
  
  @NonNull
  public aorb a(int paramInt)
  {
    return new aorb();
  }
  
  @Nullable
  public aorb a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aorb localaorb = new aorb();
      localaorb.a(paramArrayOfaoko);
      return localaorb;
    }
    return new aorb();
  }
  
  public Class<aorb> a()
  {
    return aorb.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aorb paramaorb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return bdne.M(localQQAppInterface.getApp(), str);
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
 * Qualified Name:     aora
 * JD-Core Version:    0.7.0.1
 */