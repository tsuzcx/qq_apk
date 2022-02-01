import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqtg
  extends aqkz<aqth>
{
  public static aqth a()
  {
    return (aqth)aqlk.a().a(564);
  }
  
  @NonNull
  public aqth a(int paramInt)
  {
    return new aqth();
  }
  
  @Nullable
  public aqth a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length == 0)) {
      return null;
    }
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfaqlg);
    }
    return aqth.a(paramArrayOfaqlg);
  }
  
  public void a(aqth paramaqth)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (paramaqth != null) {
      bazp.a = (int)(paramaqth.a * 60.0D * 60.0D);
    }
  }
  
  public Class<aqth> clazz()
  {
    return aqth.class;
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
    return 564;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtg
 * JD-Core Version:    0.7.0.1
 */