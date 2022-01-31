import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anat
  extends ampa<anar>
{
  public int a()
  {
    return 432;
  }
  
  @NonNull
  public anar a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new anar();
  }
  
  @Nullable
  public anar a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
      }
      return anar.a(paramArrayOfamph[0]);
    }
    return null;
  }
  
  public Class<anar> a()
  {
    return anar.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(anar paramanar)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramanar == null) {
        break label49;
      }
    }
    label49:
    for (paramanar = paramanar.toString();; paramanar = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramanar);
      awtm.a().a();
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
 * Qualified Name:     anat
 * JD-Core Version:    0.7.0.1
 */