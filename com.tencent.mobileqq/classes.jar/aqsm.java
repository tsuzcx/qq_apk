import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqsm
  extends aqkz<aqsp>
{
  @NonNull
  public aqsp a(int paramInt)
  {
    return new aqsp();
  }
  
  @Nullable
  public aqsp a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqsp.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqsp paramaqsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    if (paramaqsp != null) {
      aqsp.a(paramaqsp);
    }
    arvk.a().a();
  }
  
  public Class<aqsp> clazz()
  {
    return aqsp.class;
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
    return 545;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqsm
 * JD-Core Version:    0.7.0.1
 */