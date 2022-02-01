import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class armg
  extends aqwt<armf>
{
  @NonNull
  public armf a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchHotWordConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new armf();
  }
  
  @Nullable
  public armf a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchHotWordConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return armf.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(armf paramarmf)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarmf == null) {
        break label43;
      }
    }
    label43:
    for (paramarmf = paramarmf.toString();; paramarmf = " empty")
    {
      QLog.d("SearchHotWordConfProcessor", 2, paramarmf);
      return;
    }
  }
  
  public Class clazz()
  {
    return armf.class;
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
 * Qualified Name:     armg
 * JD-Core Version:    0.7.0.1
 */