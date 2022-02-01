import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfq
  extends aqwt<arfr>
{
  public static arfr a()
  {
    return (arfr)aqxe.a().a(564);
  }
  
  @NonNull
  public arfr a(int paramInt)
  {
    return new arfr();
  }
  
  @Nullable
  public arfr a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfaqxa);
    }
    return arfr.a(paramArrayOfaqxa);
  }
  
  public void a(arfr paramarfr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramarfr != null) {
      bbss.a = (int)(paramarfr.a * 60.0D * 60.0D);
    }
  }
  
  public Class<arfr> clazz()
  {
    return arfr.class;
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
 * Qualified Name:     arfq
 * JD-Core Version:    0.7.0.1
 */