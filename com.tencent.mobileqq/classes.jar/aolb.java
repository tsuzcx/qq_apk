import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class aolb
  extends aofy<aola>
{
  public int a()
  {
    return 587;
  }
  
  @NonNull
  public aola a(int paramInt)
  {
    return new aola();
  }
  
  @Nullable
  public aola a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaogf != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaogf.length > 0) {
        localObject1 = aola.a(paramArrayOfaogf);
      }
    }
    return localObject1;
  }
  
  public Class<aola> a()
  {
    return aola.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aola paramaola)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramaola.toString());
    }
    PhotoListPanel.setShowModeToSp(paramaola.a);
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aolb
 * JD-Core Version:    0.7.0.1
 */