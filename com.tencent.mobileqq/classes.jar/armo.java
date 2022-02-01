import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class armo
  extends aqwt<armm>
{
  @NonNull
  public armm a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new armm();
  }
  
  @Nullable
  public armm a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerticalSearchConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalSearchConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return armm.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(armm paramarmm)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarmm == null) {
        break label43;
      }
    }
    label43:
    for (paramarmm = paramarmm.toString();; paramarmm = " empty")
    {
      QLog.d("VerticalSearchConfProcessor", 2, paramarmm);
      return;
    }
  }
  
  public Class clazz()
  {
    return armm.class;
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
      QLog.e("VerticalSearchConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 456;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armo
 * JD-Core Version:    0.7.0.1
 */