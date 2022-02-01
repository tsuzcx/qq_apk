import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argd
  extends aqwt<arge>
{
  @NonNull
  public arge a(int paramInt)
  {
    return new arge();
  }
  
  @Nullable
  public arge a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arge localarge = arge.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarge;
    }
    return null;
  }
  
  public void a(arge paramarge)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramarge });
    }
  }
  
  public Class<arge> clazz()
  {
    return arge.class;
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
 * Qualified Name:     argd
 * JD-Core Version:    0.7.0.1
 */