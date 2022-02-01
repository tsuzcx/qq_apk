import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arox
  extends arac<arow>
{
  @NonNull
  public arow a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchHotWordConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arow();
  }
  
  @Nullable
  public arow a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchHotWordConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return arow.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(arow paramarow)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarow == null) {
        break label43;
      }
    }
    label43:
    for (paramarow = paramarow.toString();; paramarow = " empty")
    {
      QLog.d("SearchHotWordConfProcessor", 2, paramarow);
      return;
    }
  }
  
  public Class clazz()
  {
    return arow.class;
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
      QLog.e("SearchHotWordConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 433;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arox
 * JD-Core Version:    0.7.0.1
 */