import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aorv
  extends aofy<aoru>
{
  public int a()
  {
    return 434;
  }
  
  @NonNull
  public aoru a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aoru();
  }
  
  @Nullable
  public aoru a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aoru.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class<aoru> a()
  {
    return aoru.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aoru paramaoru)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaoru == null) {
        break label43;
      }
    }
    label43:
    for (paramaoru = paramaoru.toString();; paramaoru = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramaoru);
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
 * Qualified Name:     aorv
 * JD-Core Version:    0.7.0.1
 */