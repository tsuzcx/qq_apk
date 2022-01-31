import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aosa
  extends aofy<aory>
{
  public int a()
  {
    return 432;
  }
  
  @NonNull
  public aory a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aory();
  }
  
  @Nullable
  public aory a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aory.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class<aory> a()
  {
    return aory.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aory paramaory)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaory == null) {
        break label49;
      }
    }
    label49:
    for (paramaory = paramaory.toString();; paramaory = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramaory);
      ayop.a().a();
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
 * Qualified Name:     aosa
 * JD-Core Version:    0.7.0.1
 */