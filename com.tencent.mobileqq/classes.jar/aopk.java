import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qphone.base.util.QLog;

public class aopk
  extends aokh<aopj>
{
  public int a()
  {
    return 587;
  }
  
  @NonNull
  public aopj a(int paramInt)
  {
    return new aopj();
  }
  
  @Nullable
  public aopj a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onParsed " + paramArrayOfaoko.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaoko != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaoko.length > 0) {
        localObject1 = aopj.a(paramArrayOfaoko);
      }
    }
    return localObject1;
  }
  
  public Class<aopj> a()
  {
    return aopj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aopj paramaopj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanelConfProcessor", 2, "onUpdate " + paramaopj.toString());
    }
    PhotoListPanel.setShowModeToSp(paramaopj.a);
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
 * Qualified Name:     aopk
 * JD-Core Version:    0.7.0.1
 */