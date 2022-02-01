import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class apzz
  extends aptq<apzy>
{
  @NonNull
  public apzy a(int paramInt)
  {
    return new apzy();
  }
  
  @Nullable
  public apzy a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfaptx.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaptx != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaptx.length > 0) {
        localObject1 = apzy.a(paramArrayOfaptx);
      }
    }
    return localObject1;
  }
  
  public void a(apzy paramapzy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramapzy.toString());
    }
    PhotoListPanel.setShowModeToSp(paramapzy.a);
  }
  
  public Class<apzy> clazz()
  {
    return apzy.class;
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
 * Qualified Name:     apzz
 * JD-Core Version:    0.7.0.1
 */