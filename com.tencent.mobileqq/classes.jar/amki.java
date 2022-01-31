import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amki
  extends alzl<amkg>
{
  public int a()
  {
    return 432;
  }
  
  @NonNull
  public amkg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amkg();
  }
  
  @Nullable
  public amkg a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfalzs.length);
      }
      return amkg.a(paramArrayOfalzs[0]);
    }
    return null;
  }
  
  public Class<amkg> a()
  {
    return amkg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amkg paramamkg)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamkg == null) {
        break label49;
      }
    }
    label49:
    for (paramamkg = paramamkg.toString();; paramamkg = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramamkg);
      avtr.a().a();
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
 * Qualified Name:     amki
 * JD-Core Version:    0.7.0.1
 */