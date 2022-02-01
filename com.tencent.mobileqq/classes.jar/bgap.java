import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bgap
  extends aqwt<bgaq>
{
  public static bgaq a()
  {
    bgaq localbgaq = (bgaq)aqxe.a().a(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + localbgaq);
    }
    return localbgaq;
  }
  
  @NonNull
  public bgaq a(int paramInt)
  {
    return new bgaq();
  }
  
  @Nullable
  public bgaq a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfaqxa);
    }
    return bgaq.a(paramArrayOfaqxa);
  }
  
  public void a(bgaq parambgaq) {}
  
  public Class<bgaq> clazz()
  {
    return bgaq.class;
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
    return 547;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgap
 * JD-Core Version:    0.7.0.1
 */