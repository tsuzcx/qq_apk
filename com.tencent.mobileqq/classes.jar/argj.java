import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class argj
  extends arac<argi>
{
  @NonNull
  public argi a(int paramInt)
  {
    return new argi();
  }
  
  @Nullable
  public argi a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaraj != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaraj.length > 0) {
        localObject1 = argi.a(paramArrayOfaraj);
      }
    }
    return localObject1;
  }
  
  public void a(argi paramargi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramargi.toString());
    }
    PhotoListPanel.setShowModeToSp(paramargi.a);
  }
  
  public Class<argi> clazz()
  {
    return argi.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 587;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argj
 * JD-Core Version:    0.7.0.1
 */