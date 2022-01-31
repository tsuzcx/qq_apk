import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class aogy
  extends aofy<aogz>
{
  public int a()
  {
    return 574;
  }
  
  @NonNull
  public aogz a(int paramInt)
  {
    return new aogz();
  }
  
  @Nullable
  public aogz a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aogz localaogz = aogz.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfaogf[0].a);
      }
      return localaogz;
    }
    return null;
  }
  
  public Class<aogz> a()
  {
    return aogz.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aogz paramaogz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + paramaogz.a());
    }
    ShortVideoUtils.a(paramaogz.a());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public int b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onSend: " + paramInt + ", isOpen:" + ShortVideoUtils.g());
    }
    return super.b(paramInt);
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
 * Qualified Name:     aogy
 * JD-Core Version:    0.7.0.1
 */