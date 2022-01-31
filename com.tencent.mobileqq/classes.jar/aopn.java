import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aopn
  extends aokh<aopo>
{
  public int a()
  {
    return 530;
  }
  
  @NonNull
  public aopo a(int paramInt)
  {
    return new aopo();
  }
  
  @Nullable
  public aopo a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      paramArrayOfaoko = paramArrayOfaoko[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + paramArrayOfaoko);
      }
      return aopo.a(paramArrayOfaoko);
    }
    return new aopo();
  }
  
  public Class a()
  {
    return aopo.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(aopo paramaopo)
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
 * Qualified Name:     aopn
 * JD-Core Version:    0.7.0.1
 */