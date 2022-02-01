import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bgkb
  extends arac<bgkc>
{
  public static bgkc a()
  {
    bgkc localbgkc = (bgkc)aran.a().a(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + localbgkc);
    }
    return localbgkc;
  }
  
  @NonNull
  public bgkc a(int paramInt)
  {
    return new bgkc();
  }
  
  @Nullable
  public bgkc a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfaraj);
    }
    return bgkc.a(paramArrayOfaraj);
  }
  
  public void a(bgkc parambgkc) {}
  
  public Class<bgkc> clazz()
  {
    return bgkc.class;
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
 * Qualified Name:     bgkb
 * JD-Core Version:    0.7.0.1
 */