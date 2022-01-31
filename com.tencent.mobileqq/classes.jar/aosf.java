import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aosf
  extends aofy<aosd>
{
  public int a()
  {
    return 456;
  }
  
  @NonNull
  public aosd a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aosd();
  }
  
  @Nullable
  public aosd a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerticalSearchConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalSearchConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aosd.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class a()
  {
    return aosd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aosd paramaosd)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaosd == null) {
        break label43;
      }
    }
    label43:
    for (paramaosd = paramaosd.toString();; paramaosd = " empty")
    {
      QLog.d("VerticalSearchConfProcessor", 2, paramaosd);
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
 * Qualified Name:     aosf
 * JD-Core Version:    0.7.0.1
 */