import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class azws
  extends aofy<azwt>
{
  public static azwt a()
  {
    return (azwt)aogj.a().a(610);
  }
  
  public int a()
  {
    return 610;
  }
  
  @NonNull
  public azwt a(int paramInt)
  {
    return new azwt();
  }
  
  @Nullable
  public azwt a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModeConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return azwt.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<azwt> a()
  {
    return azwt.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(azwt paramazwt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azws
 * JD-Core Version:    0.7.0.1
 */