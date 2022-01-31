import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anam
  extends ampb<anak>
{
  public int a()
  {
    return 432;
  }
  
  @NonNull
  public anak a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new anak();
  }
  
  @Nullable
  public anak a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfampi.length);
      }
      return anak.a(paramArrayOfampi[0]);
    }
    return null;
  }
  
  public Class<anak> a()
  {
    return anak.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(anak paramanak)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramanak == null) {
        break label49;
      }
    }
    label49:
    for (paramanak = paramanak.toString();; paramanak = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramanak);
      awtk.a().a();
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
 * Qualified Name:     anam
 * JD-Core Version:    0.7.0.1
 */