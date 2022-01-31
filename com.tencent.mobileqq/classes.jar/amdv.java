import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amdv
  extends alzl<amdw>
{
  public int a()
  {
    return 530;
  }
  
  @NonNull
  public amdw a(int paramInt)
  {
    return new amdw();
  }
  
  @Nullable
  public amdw a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      paramArrayOfalzs = paramArrayOfalzs[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + paramArrayOfalzs);
      }
      return amdw.a(paramArrayOfalzs);
    }
    return new amdw();
  }
  
  public Class a()
  {
    return amdw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amdw paramamdw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onUpdate");
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
 * Qualified Name:     amdv
 * JD-Core Version:    0.7.0.1
 */