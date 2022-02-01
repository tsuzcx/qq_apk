import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqtf
  extends aqkz<aqte>
{
  @NonNull
  public aqte a(int paramInt)
  {
    return new aqte();
  }
  
  @Nullable
  public aqte a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqte localaqte = aqte.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqte;
    }
    return new aqte();
  }
  
  public void a(aqte paramaqte) {}
  
  public Class<aqte> clazz()
  {
    return aqte.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 490;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtf
 * JD-Core Version:    0.7.0.1
 */