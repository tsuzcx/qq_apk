import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class amtx
  extends ampa<amtw>
{
  public int a()
  {
    return 587;
  }
  
  @NonNull
  public amtw a(int paramInt)
  {
    return new amtw();
  }
  
  @Nullable
  public amtw a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfamph.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfamph != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfamph.length > 0) {
        localObject1 = amtw.a(paramArrayOfamph);
      }
    }
    return localObject1;
  }
  
  public Class<amtw> a()
  {
    return amtw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amtw paramamtw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramamtw.toString());
    }
    PhotoListPanel.setShowModeToSp(paramamtw.a);
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
 * Qualified Name:     amtx
 * JD-Core Version:    0.7.0.1
 */