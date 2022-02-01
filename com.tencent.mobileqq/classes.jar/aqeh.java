import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class aqeh
  extends aptq<aqeg>
{
  @NonNull
  public aqeg a(int paramInt)
  {
    return new aqeg();
  }
  
  @Nullable
  public aqeg a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      aqeg localaqeg2 = aqeg.a(paramArrayOfaptx[0].a);
      aqeg localaqeg1 = localaqeg2;
      if (localaqeg2 == null) {
        localaqeg1 = new aqeg();
      }
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherConfProcessor", 0, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localaqeg1;
    }
    return new aqeg();
  }
  
  public void a(aqeg paramaqeg) {}
  
  public Class<aqeg> clazz()
  {
    return aqeg.class;
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
    return 653;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqeh
 * JD-Core Version:    0.7.0.1
 */