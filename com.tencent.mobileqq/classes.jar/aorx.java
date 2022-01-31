import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aorx
  extends aofy<aorw>
{
  public int a()
  {
    return 433;
  }
  
  @NonNull
  public aorw a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchHotWordConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aorw();
  }
  
  @Nullable
  public aorw a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchHotWordConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aorw.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class a()
  {
    return aorw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchHotWordConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aorw paramaorw)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaorw == null) {
        break label43;
      }
    }
    label43:
    for (paramaorw = paramaorw.toString();; paramaorw = " empty")
    {
      QLog.d("SearchHotWordConfProcessor", 2, paramaorw);
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
 * Qualified Name:     aorx
 * JD-Core Version:    0.7.0.1
 */