import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqiy
  extends aptq<aqiw>
{
  @NonNull
  public aqiw a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqiw();
  }
  
  @Nullable
  public aqiw a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfaptx.length);
      }
      return aqiw.a(paramArrayOfaptx[0]);
    }
    return null;
  }
  
  public void a(aqiw paramaqiw)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqiw == null) {
        break label49;
      }
    }
    label49:
    for (paramaqiw = paramaqiw.toString();; paramaqiw = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramaqiw);
      bbdw.a().a();
      return;
    }
  }
  
  public Class<aqiw> clazz()
  {
    return aqiw.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 432;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqiy
 * JD-Core Version:    0.7.0.1
 */