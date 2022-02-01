import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aris
  extends arac<arit>
{
  public static arit a()
  {
    return (arit)aran.a().a(564);
  }
  
  @NonNull
  public arit a(int paramInt)
  {
    return new arit();
  }
  
  @Nullable
  public arit a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfaraj);
    }
    return arit.a(paramArrayOfaraj);
  }
  
  public void a(arit paramarit)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramarit != null) {
      bbsi.a = (int)(paramarit.a * 60.0D * 60.0D);
    }
  }
  
  public Class<arit> clazz()
  {
    return arit.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 564;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aris
 * JD-Core Version:    0.7.0.1
 */