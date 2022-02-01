import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqrc
  extends arac<aqrb>
{
  public static aqrb a()
  {
    return (aqrb)aran.a().a(549);
  }
  
  @NonNull
  public aqrb a(int paramInt)
  {
    return new aqrb();
  }
  
  @Nullable
  public aqrb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      aqrb localaqrb = aqrb.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localaqrb;
    }
    return null;
  }
  
  public void a(aqrb paramaqrb) {}
  
  public Class clazz()
  {
    return aqrb.class;
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
 * Qualified Name:     aqrc
 * JD-Core Version:    0.7.0.1
 */