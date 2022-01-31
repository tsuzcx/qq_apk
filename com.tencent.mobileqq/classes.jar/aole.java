import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aole
  extends aofy<aolf>
{
  public int a()
  {
    return 530;
  }
  
  @NonNull
  public aolf a(int paramInt)
  {
    return new aolf();
  }
  
  @Nullable
  public aolf a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      paramArrayOfaogf = paramArrayOfaogf[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + paramArrayOfaogf);
      }
      return aolf.a(paramArrayOfaogf);
    }
    return new aolf();
  }
  
  public Class a()
  {
    return aolf.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(aolf paramaolf)
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
 * Qualified Name:     aole
 * JD-Core Version:    0.7.0.1
 */