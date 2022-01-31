import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aoqc
  extends aokh<aoqb>
{
  public int a()
  {
    return 390;
  }
  
  @NonNull
  public aoqb a(int paramInt)
  {
    return new aoqb();
  }
  
  @Nullable
  public aoqb a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aoqb localaoqb = aoqb.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaoqb;
    }
    return new aoqb();
  }
  
  public Class<aoqb> a()
  {
    return aoqb.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoqb paramaoqb)
  {
    ((auaa)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).a(paramaoqb);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramaoqb);
    }
  }
  
  public boolean a()
  {
    return true;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqc
 * JD-Core Version:    0.7.0.1
 */