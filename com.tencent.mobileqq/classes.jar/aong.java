import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aong
  extends aofy<aonh>
{
  public int a()
  {
    return 362;
  }
  
  @NonNull
  public aonh a(int paramInt)
  {
    return new aonh();
  }
  
  @Nullable
  public aonh a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aonh localaonh = aonh.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaonh;
    }
    return null;
  }
  
  public Class<aonh> a()
  {
    return aonh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public void a(aonh paramaonh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramaonh });
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
 * Qualified Name:     aong
 * JD-Core Version:    0.7.0.1
 */