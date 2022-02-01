import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arpa
  extends arac<aroy>
{
  @NonNull
  public aroy a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aroy();
  }
  
  @Nullable
  public aroy a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return aroy.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(aroy paramaroy)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaroy == null) {
        break label49;
      }
    }
    label49:
    for (paramaroy = paramaroy.toString();; paramaroy = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramaroy);
      bcku.a().a();
      return;
    }
  }
  
  public Class<aroy> clazz()
  {
    return aroy.class;
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
 * Qualified Name:     arpa
 * JD-Core Version:    0.7.0.1
 */