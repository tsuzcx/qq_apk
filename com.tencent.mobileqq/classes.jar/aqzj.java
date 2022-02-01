import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqzj
  extends aqkz<aqzh>
{
  @NonNull
  public aqzh a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqzh();
  }
  
  @Nullable
  public aqzh a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfaqlg.length);
      }
      return aqzh.a(paramArrayOfaqlg[0]);
    }
    return null;
  }
  
  public void a(aqzh paramaqzh)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqzh == null) {
        break label49;
      }
    }
    label49:
    for (paramaqzh = paramaqzh.toString();; paramaqzh = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramaqzh);
      bbsb.a().a();
      return;
    }
  }
  
  public Class<aqzh> clazz()
  {
    return aqzh.class;
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
 * Qualified Name:     aqzj
 * JD-Core Version:    0.7.0.1
 */