import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqyf
  extends aqwt<aqyg>
{
  @NonNull
  public aqyg a(int paramInt)
  {
    return new aqyg();
  }
  
  @Nullable
  public aqyg a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed, content:" + paramArrayOfaqxa);
      }
      return aqyg.a(paramArrayOfaqxa);
    }
    return new aqyg();
  }
  
  public void a(aqyg paramaqyg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onUpdate");
    }
    bdnp.a().a(paramaqyg);
  }
  
  public Class clazz()
  {
    return aqyg.class;
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
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 537;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyf
 * JD-Core Version:    0.7.0.1
 */