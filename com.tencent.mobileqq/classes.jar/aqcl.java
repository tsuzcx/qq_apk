import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqcl
  extends aptq<aqcm>
{
  public static aqcm a()
  {
    return (aqcm)apub.a().a(564);
  }
  
  @NonNull
  public aqcm a(int paramInt)
  {
    return new aqcm();
  }
  
  @Nullable
  public aqcm a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0)) {
      return null;
    }
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfaptx);
    }
    return aqcm.a(paramArrayOfaptx);
  }
  
  public void a(aqcm paramaqcm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramaqcm != null) {
      bamd.a = (int)(paramaqcm.a * 60.0D * 60.0D);
    }
  }
  
  public Class<aqcm> clazz()
  {
    return aqcm.class;
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
 * Qualified Name:     aqcl
 * JD-Core Version:    0.7.0.1
 */