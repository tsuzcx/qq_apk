import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqcw
  extends aptq<aqcx>
{
  @NonNull
  public aqcx a(int paramInt)
  {
    return new aqcx();
  }
  
  @Nullable
  public aqcx a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      aqcx localaqcx = aqcx.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localaqcx;
    }
    return null;
  }
  
  public void a(aqcx paramaqcx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramaqcx });
    }
  }
  
  public Class<aqcx> clazz()
  {
    return aqcx.class;
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
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 362;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqcw
 * JD-Core Version:    0.7.0.1
 */