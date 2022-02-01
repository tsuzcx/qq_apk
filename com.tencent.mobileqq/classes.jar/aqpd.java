import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqpd
  extends aqkz<aqpc>
{
  @NonNull
  public aqpc a(int paramInt)
  {
    return new aqpc();
  }
  
  @Nullable
  public aqpc a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      aqpc localaqpc = aqpc.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("GlobalSearchConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqpc;
    }
    return null;
  }
  
  public void a(aqpc paramaqpc)
  {
    com.tencent.mobileqq.search.util.SearchConfigManager.needSeparate = paramaqpc.a();
    if (QLog.isColorLevel()) {
      QLog.d("GlobalSearchConfProcessor", 2, "onUpdate " + paramaqpc.toString());
    }
  }
  
  public Class<aqpc> clazz()
  {
    return aqpc.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 414;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpd
 * JD-Core Version:    0.7.0.1
 */