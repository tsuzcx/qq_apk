import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import java.util.Map;

final class amkw
  extends amle
{
  amkw(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, amky paramamky)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (amkv.a())
      {
        if (amkv.b().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 0, "onConsecutiveFailure reverseListenerMap contains. business id: " + this.tag + " fail count: " + paramInt2);
          }
          if (paramInt2 > 5)
          {
            localamky = (amky)amkv.b().remove(this);
            amkv.a().remove(localamky);
            if (paramInt2 > 5) {
              SosoInterface.b(this);
            }
            return;
          }
          amky localamky = (amky)amkv.b().get(this);
          if (paramInt2 == 5) {
            bool = true;
          }
          localamky.onConsecutiveFailure(paramInt1, paramInt2, bool);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "onConsecutiveFailure reverseListenerMap not contains. business id: " + this.tag + " fail count: " + paramInt2);
      }
    }
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    for (;;)
    {
      synchronized ()
      {
        if (amkv.b().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 0, "onLocationFinish reverseListenerMap contains. business id: " + this.tag);
          }
          if (this.goonListener)
          {
            localamky = (amky)amkv.b().get(this);
            localamky.onLocationFinish(paramInt, amkv.a(paramSosoLbsInfo, this.a.businessId));
            return;
          }
          amky localamky = (amky)amkv.b().remove(this);
          amkv.a().remove(localamky);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "onLocationFinish reverseListenerMap not contains. business id: " + this.tag + " this is: " + this);
      }
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    synchronized ()
    {
      if (amkv.b().containsKey(this)) {
        ((amky)amkv.b().get(this)).onStatusUpdate(paramString1, paramInt, paramString2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkw
 * JD-Core Version:    0.7.0.1
 */