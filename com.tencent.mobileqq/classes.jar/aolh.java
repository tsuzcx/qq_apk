import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class aolh
  extends aokh<aoli>
{
  public int a()
  {
    return 574;
  }
  
  @NonNull
  public aoli a(int paramInt)
  {
    return new aoli();
  }
  
  @Nullable
  public aoli a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aoli localaoli = aoli.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfaoko[0].a);
      }
      return localaoli;
    }
    return null;
  }
  
  public Class<aoli> a()
  {
    return aoli.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoli paramaoli)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + paramaoli.a());
    }
    ShortVideoUtils.a(paramaoli.a());
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
 * Qualified Name:     aolh
 * JD-Core Version:    0.7.0.1
 */