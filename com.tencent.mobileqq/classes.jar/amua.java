import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amua
  extends ampa<amub>
{
  public int a()
  {
    return 530;
  }
  
  @NonNull
  public amub a(int paramInt)
  {
    return new amub();
  }
  
  @Nullable
  public amub a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = paramArrayOfamph[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + paramArrayOfamph);
      }
      return amub.a(paramArrayOfamph);
    }
    return new amub();
  }
  
  public Class a()
  {
    return amub.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amub paramamub)
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
 * Qualified Name:     amua
 * JD-Core Version:    0.7.0.1
 */