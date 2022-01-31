import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoiv
  extends aofy<aoiu>
{
  public static aoiu a()
  {
    return (aoiu)aogj.a().a(452);
  }
  
  public int a()
  {
    return 452;
  }
  
  @NonNull
  public aoiu a(int paramInt)
  {
    return new aoiu().b("0");
  }
  
  @Nullable
  public aoiu a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aoiu localaoiu = aoiu.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaoiu;
    }
    return null;
  }
  
  public Class<aoiu> a()
  {
    return aoiu.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aoiu paramaoiu) {}
  
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
 * Qualified Name:     aoiv
 * JD-Core Version:    0.7.0.1
 */