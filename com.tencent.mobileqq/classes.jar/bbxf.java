import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bbxf
  extends aqwt<bbxg>
{
  @NonNull
  public bbxg a(int paramInt)
  {
    return new bbxg();
  }
  
  @Nullable
  public bbxg a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfaqxa[0].a);
      }
      return bbxg.a(paramArrayOfaqxa[0].a);
    }
    return new bbxg();
  }
  
  public void a(bbxg parambbxg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + parambbxg);
    }
    bbxq.a(parambbxg);
  }
  
  public Class<bbxg> clazz()
  {
    return bbxg.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public int type()
  {
    return 485;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxf
 * JD-Core Version:    0.7.0.1
 */