import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aops
  extends aokh<aopr>
{
  public int a()
  {
    return 442;
  }
  
  @NonNull
  public aopr a(int paramInt)
  {
    return new aopr();
  }
  
  @Nullable
  public aopr a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aopr localaopr = aopr.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaopr;
    }
    return null;
  }
  
  public Class<aopr> a()
  {
    return aopr.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aopr paramaopr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramaopr.toString());
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
 * Qualified Name:     aops
 * JD-Core Version:    0.7.0.1
 */