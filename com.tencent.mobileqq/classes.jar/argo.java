import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argo
  extends aqwt<argm>
{
  @NonNull
  public argm a(int paramInt)
  {
    return new argm();
  }
  
  @Nullable
  public argm a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      argm localargm = argm.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherEntryConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localargm;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(argm paramargm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onUpdate " + paramargm.toString());
    }
  }
  
  public Class<argm> clazz()
  {
    return argm.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 553;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argo
 * JD-Core Version:    0.7.0.1
 */