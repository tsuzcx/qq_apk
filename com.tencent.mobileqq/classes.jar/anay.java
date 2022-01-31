import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anay
  extends ampa<anaw>
{
  public int a()
  {
    return 456;
  }
  
  @NonNull
  public anaw a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new anaw();
  }
  
  @Nullable
  public anaw a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerticalSearchConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalSearchConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
      }
      return anaw.a(paramArrayOfamph[0]);
    }
    return null;
  }
  
  public Class a()
  {
    return anaw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(anaw paramanaw)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramanaw == null) {
        break label43;
      }
    }
    label43:
    for (paramanaw = paramanaw.toString();; paramanaw = " empty")
    {
      QLog.d("VerticalSearchConfProcessor", 2, paramanaw);
      return;
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
 * Qualified Name:     anay
 * JD-Core Version:    0.7.0.1
 */