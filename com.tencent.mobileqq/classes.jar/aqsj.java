import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqsj
  extends aqkz<aqsi>
{
  public static aqsi a()
  {
    return (aqsi)aqlk.a().a(441);
  }
  
  @NonNull
  public aqsi a(int paramInt)
  {
    return new aqsi();
  }
  
  @Nullable
  public aqsi a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      new aqsi();
      return aqsi.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqsi paramaqsi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onUpdate " + paramaqsi.toString());
    }
  }
  
  public Class<aqsi> clazz()
  {
    return aqsi.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 441;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsj
 * JD-Core Version:    0.7.0.1
 */