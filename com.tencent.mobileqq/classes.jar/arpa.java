import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arpa
  extends aqwt<aroz>
{
  public static aroz a()
  {
    aroz localaroz2 = (aroz)aqxe.a().a(573);
    aroz localaroz1 = localaroz2;
    if (localaroz2 == null) {
      localaroz1 = new aroz();
    }
    return localaroz1;
  }
  
  @NonNull
  public aroz a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aroz();
  }
  
  @Nullable
  public aroz a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return aroz.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(aroz paramaroz)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaroz == null) {
        break label43;
      }
    }
    label43:
    for (paramaroz = paramaroz.toString();; paramaroz = " empty")
    {
      QLog.d("SuspiciousTroopConfProcessor", 2, paramaroz);
      return;
    }
  }
  
  public Class<aroz> clazz()
  {
    return aroz.class;
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
      QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 573;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpa
 * JD-Core Version:    0.7.0.1
 */