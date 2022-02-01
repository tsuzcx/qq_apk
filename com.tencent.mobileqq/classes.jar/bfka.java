import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bfka
  extends aqkz<bfkb>
{
  public static bfkb a()
  {
    bfkb localbfkb = (bfkb)aqlk.a().a(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + localbfkb);
    }
    return localbfkb;
  }
  
  @NonNull
  public bfkb a(int paramInt)
  {
    return new bfkb();
  }
  
  @Nullable
  public bfkb a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length == 0)) {
      return null;
    }
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfaqlg);
    }
    return bfkb.a(paramArrayOfaqlg);
  }
  
  public void a(bfkb parambfkb) {}
  
  public Class<bfkb> clazz()
  {
    return bfkb.class;
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
 * Qualified Name:     bfka
 * JD-Core Version:    0.7.0.1
 */