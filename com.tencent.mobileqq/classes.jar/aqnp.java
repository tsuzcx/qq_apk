import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqnp
  extends aqwt<aqno>
{
  public static aqno a()
  {
    return (aqno)aqxe.a().a(549);
  }
  
  @NonNull
  public aqno a(int paramInt)
  {
    return new aqno();
  }
  
  @Nullable
  public aqno a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aqno localaqno = aqno.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localaqno;
    }
    return null;
  }
  
  public void a(aqno paramaqno) {}
  
  public Class clazz()
  {
    return aqno.class;
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
 * Qualified Name:     aqnp
 * JD-Core Version:    0.7.0.1
 */