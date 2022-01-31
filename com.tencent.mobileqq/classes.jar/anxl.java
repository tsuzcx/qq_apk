import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anxl
  extends aofy<anxk>
{
  public static anxk a()
  {
    return (anxk)aogj.a().a(549);
  }
  
  public int a()
  {
    return 549;
  }
  
  @NonNull
  public anxk a(int paramInt)
  {
    return new anxk();
  }
  
  @Nullable
  public anxk a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      anxk localanxk = anxk.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localanxk;
    }
    return null;
  }
  
  public Class a()
  {
    return anxk.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(anxk paramanxk) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxl
 * JD-Core Version:    0.7.0.1
 */