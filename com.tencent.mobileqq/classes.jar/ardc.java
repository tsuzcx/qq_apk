import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class ardc
  extends aqwt<ardb>
{
  @NonNull
  public ardb a(int paramInt)
  {
    return new ardb();
  }
  
  @Nullable
  public ardb a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqxa.length > 0) {
        localObject1 = ardb.a(paramArrayOfaqxa);
      }
    }
    return localObject1;
  }
  
  public void a(ardb paramardb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramardb.toString());
    }
    PhotoListPanel.setShowModeToSp(paramardb.a);
  }
  
  public Class<ardb> clazz()
  {
    return ardb.class;
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
 * Qualified Name:     ardc
 * JD-Core Version:    0.7.0.1
 */