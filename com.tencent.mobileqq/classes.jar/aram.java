import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aram
  extends aqwt<aran>
{
  public static aran a()
  {
    return (aran)aqxe.a().a(620);
  }
  
  @NonNull
  public aran a(int paramInt)
  {
    return new aran();
  }
  
  @Nullable
  public aran a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aran.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(aran paramaran)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonSearchTagsConfProcessor", 2, "EmoticonSearchTagsConfProcessor onUpdate");
    }
  }
  
  public Class<aran> clazz()
  {
    return aran.class;
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
 * Qualified Name:     aram
 * JD-Core Version:    0.7.0.1
 */