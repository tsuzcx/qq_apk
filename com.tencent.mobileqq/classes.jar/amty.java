import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class amty
  extends ampb<amtx>
{
  public int a()
  {
    return 587;
  }
  
  @NonNull
  public amtx a(int paramInt)
  {
    return new amtx();
  }
  
  @Nullable
  public amtx a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfampi.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfampi != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfampi.length > 0) {
        localObject1 = amtx.a(paramArrayOfampi);
      }
    }
    return localObject1;
  }
  
  public Class<amtx> a()
  {
    return amtx.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amtx paramamtx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramamtx.toString());
    }
    PhotoListPanel.setShowModeToSp(paramamtx.a);
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
 * Qualified Name:     amty
 * JD-Core Version:    0.7.0.1
 */