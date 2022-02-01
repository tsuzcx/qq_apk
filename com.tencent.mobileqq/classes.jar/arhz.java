import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arhz
  extends aqwt<arhy>
{
  public static arhy a()
  {
    arhy localarhy2 = (arhy)aqxe.a().a(493);
    arhy localarhy1 = localarhy2;
    if (localarhy2 == null) {
      localarhy1 = new arhy();
    }
    return localarhy1;
  }
  
  @NonNull
  public arhy a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arhy();
  }
  
  @Nullable
  public arhy a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return arhy.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(arhy paramarhy)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarhy == null) {
        break label43;
      }
    }
    label43:
    for (paramarhy = paramarhy.toString();; paramarhy = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramarhy);
      return;
    }
  }
  
  public Class<arhy> clazz()
  {
    return arhy.class;
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
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhz
 * JD-Core Version:    0.7.0.1
 */