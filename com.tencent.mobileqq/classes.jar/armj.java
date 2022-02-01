import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class armj
  extends aqwt<armh>
{
  @NonNull
  public armh a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new armh();
  }
  
  @Nullable
  public armh a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return armh.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(armh paramarmh)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarmh == null) {
        break label49;
      }
    }
    label49:
    for (paramarmh = paramarmh.toString();; paramarmh = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramarmh);
      bcko.a().a();
      return;
    }
  }
  
  public Class<armh> clazz()
  {
    return armh.class;
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
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 432;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armj
 * JD-Core Version:    0.7.0.1
 */