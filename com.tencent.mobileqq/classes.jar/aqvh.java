import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqvh
  extends aqkz<aqvg>
{
  public static aqvg a()
  {
    aqvg localaqvg2 = (aqvg)aqlk.a().a(493);
    aqvg localaqvg1 = localaqvg2;
    if (localaqvg2 == null) {
      localaqvg1 = new aqvg();
    }
    return localaqvg1;
  }
  
  @NonNull
  public aqvg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqvg();
  }
  
  @Nullable
  public aqvg a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaqlg.length);
      }
      return aqvg.a(paramArrayOfaqlg[0]);
    }
    return null;
  }
  
  public void a(aqvg paramaqvg)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqvg == null) {
        break label43;
      }
    }
    label43:
    for (paramaqvg = paramaqvg.toString();; paramaqvg = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramaqvg);
      return;
    }
  }
  
  public Class<aqvg> clazz()
  {
    return aqvg.class;
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
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqvh
 * JD-Core Version:    0.7.0.1
 */