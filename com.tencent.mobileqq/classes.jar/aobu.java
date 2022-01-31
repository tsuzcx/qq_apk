import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aobu
  extends aokh<aobt>
{
  public static aobt a()
  {
    return (aobt)aoks.a().a(549);
  }
  
  public int a()
  {
    return 549;
  }
  
  @NonNull
  public aobt a(int paramInt)
  {
    return new aobt();
  }
  
  @Nullable
  public aobt a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aobt localaobt = aobt.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaobt;
    }
    return null;
  }
  
  public Class a()
  {
    return aobt.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aobt paramaobt) {}
  
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
 * Qualified Name:     aobu
 * JD-Core Version:    0.7.0.1
 */