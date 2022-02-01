import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class aqqz
  extends aqkz<aqqy>
{
  @NonNull
  public aqqy a(int paramInt)
  {
    return new aqqy();
  }
  
  @Nullable
  public aqqy a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfaqlg.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqlg != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqlg.length > 0) {
        localObject1 = aqqy.a(paramArrayOfaqlg);
      }
    }
    return localObject1;
  }
  
  public void a(aqqy paramaqqy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramaqqy.toString());
    }
    PhotoListPanel.setShowModeToSp(paramaqqy.a);
  }
  
  public Class<aqqy> clazz()
  {
    return aqqy.class;
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
 * Qualified Name:     aqqz
 * JD-Core Version:    0.7.0.1
 */