import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aowj
  extends aokh<aowh>
{
  public int a()
  {
    return 432;
  }
  
  @NonNull
  public aowh a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aowh();
  }
  
  @Nullable
  public aowh a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfaoko.length);
      }
      return aowh.a(paramArrayOfaoko[0]);
    }
    return null;
  }
  
  public Class<aowh> a()
  {
    return aowh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aowh paramaowh)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaowh == null) {
        break label49;
      }
    }
    label49:
    for (paramaowh = paramaowh.toString();; paramaowh = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramaowh);
      aysy.a().a();
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
 * Qualified Name:     aowj
 * JD-Core Version:    0.7.0.1
 */