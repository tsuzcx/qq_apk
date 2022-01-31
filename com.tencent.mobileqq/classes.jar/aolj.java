import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aolj
  extends aofy<aoli>
{
  public int a()
  {
    return 442;
  }
  
  @NonNull
  public aoli a(int paramInt)
  {
    return new aoli();
  }
  
  @Nullable
  public aoli a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aoli localaoli = aoli.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
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
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramaoli.toString());
    }
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     aolj
 * JD-Core Version:    0.7.0.1
 */