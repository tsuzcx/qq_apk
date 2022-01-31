import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aomr
  extends aofy<aoms>
{
  public int a()
  {
    return 92;
  }
  
  @NonNull
  public aoms a(int paramInt)
  {
    return new aoms();
  }
  
  @Nullable
  public aoms a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aoms localaoms = new aoms();
      localaoms.a(paramArrayOfaogf);
      return localaoms;
    }
    return new aoms();
  }
  
  public Class<aoms> a()
  {
    return aoms.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyCommonConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aoms paramaoms)
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
      return bdiv.M(localQQAppInterface.getApp(), str);
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
 * Qualified Name:     aomr
 * JD-Core Version:    0.7.0.1
 */