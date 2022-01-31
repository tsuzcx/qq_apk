import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class anao
  extends ampa<anan>
{
  public int a()
  {
    return 434;
  }
  
  @NonNull
  public anan a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new anan();
  }
  
  @Nullable
  public anan a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
      }
      return anan.a(paramArrayOfamph[0]);
    }
    return null;
  }
  
  public Class<anan> a()
  {
    return anan.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(anan paramanan)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramanan == null) {
        break label43;
      }
    }
    label43:
    for (paramanan = paramanan.toString();; paramanan = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramanan);
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
 * Qualified Name:     anao
 * JD-Core Version:    0.7.0.1
 */