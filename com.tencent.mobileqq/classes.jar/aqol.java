import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqol
  extends aqkz<aqom>
{
  public static aqom a()
  {
    return (aqom)aqlk.a().a(620);
  }
  
  @NonNull
  public aqom a(int paramInt)
  {
    return new aqom();
  }
  
  @Nullable
  public aqom a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqom.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqom paramaqom)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonSearchTagsConfProcessor", 2, "EmoticonSearchTagsConfProcessor onUpdate");
    }
  }
  
  public Class<aqom> clazz()
  {
    return aqom.class;
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
    return 620;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqol
 * JD-Core Version:    0.7.0.1
 */