import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arhg
  extends aqwt<arhf>
{
  @NonNull
  public arhf a(int paramInt)
  {
    return new arhf();
  }
  
  @Nullable
  public arhf a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arhf localarhf = arhf.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfaqxa[0].a);
      }
      return localarhf;
    }
    return null;
  }
  
  public void a(arhf paramarhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramarhf.toString());
    }
  }
  
  public Class<arhf> clazz()
  {
    return arhf.class;
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
    return 207;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhg
 * JD-Core Version:    0.7.0.1
 */