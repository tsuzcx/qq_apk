import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqbz
  extends aqkz<aqby>
{
  public static aqby a()
  {
    return (aqby)aqlk.a().a(549);
  }
  
  @NonNull
  public aqby a(int paramInt)
  {
    return new aqby();
  }
  
  @Nullable
  public aqby a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqby localaqby = aqby.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqby;
    }
    return null;
  }
  
  public void a(aqby paramaqby) {}
  
  public Class clazz()
  {
    return aqby.class;
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
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 549;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbz
 * JD-Core Version:    0.7.0.1
 */