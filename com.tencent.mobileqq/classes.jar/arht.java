import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arht
  extends arac<arhp>
{
  @NonNull
  public arhp a(int paramInt)
  {
    return new arhp();
  }
  
  @Nullable
  public arhp a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onParsed");
    }
    return arhp.a(paramArrayOfaraj);
  }
  
  public void a(arhp paramarhp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramarhp.toString());
    }
  }
  
  public Class<arhp> clazz()
  {
    return arhp.class;
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
    return 534;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arht
 * JD-Core Version:    0.7.0.1
 */