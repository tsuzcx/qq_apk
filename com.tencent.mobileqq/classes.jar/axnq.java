import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soload.config.SoLoadConfProcessor.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class axnq
  extends ampa<axnp>
{
  private final List<axnr> a = new LinkedList();
  
  public static void a(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg)
  {
    int k = paramArrayOfInt.length;
    int i = 0;
    if (i < k)
    {
      Object localObject;
      boolean bool;
      if (paramArrayOfInt[i] == 526) {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("[notifyNetFailed] isSucc=");
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
            break label123;
          }
          bool = true;
          label55:
          localObject = ((StringBuilder)localObject).append(bool).append(", resultCode=");
          if (paramFromServiceMsg == null) {
            break label129;
          }
        }
      }
      label129:
      for (int j = paramFromServiceMsg.getResultCode();; j = -1)
      {
        QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, j);
        localObject = ampl.a().a(526);
        if (localObject != null) {
          ((ampa)localObject).a(-2);
        }
        i += 1;
        break;
        label123:
        bool = false;
        break label55;
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[notifyListeners]:" + this.a.size());
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    synchronized (this.a)
    {
      if (this.a.size() <= 0) {
        break label115;
      }
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext()) {
        ((axnr)localIterator.next()).a();
      }
    }
    this.a.clear();
    label115:
  }
  
  public int a()
  {
    return 526;
  }
  
  @NonNull
  public axnp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new axnp();
  }
  
  @Nullable
  public axnp a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onParsed]");
    }
    axnp localaxnp = new axnp();
    localaxnp.a = paramArrayOfamph;
    return localaxnp;
  }
  
  public Class<axnp> a()
  {
    return axnp.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "onReqNoReceive: type=" + a() + "curContent:" + ampl.a().a(526));
    }
    b();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
    b();
  }
  
  public void a(axnp paramaxnp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onUpdate] newConf:" + paramaxnp);
    }
    axnl.a().a(paramaxnp);
    b();
  }
  
  public void a(axnr paramaxnr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(paramaxnr);
        return;
      }
      this.a.add(paramaxnr);
      ampl.a().a(526, 0);
      ampl.a().a(new int[] { 526 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new SoLoadConfProcessor.1(this), this, SystemClock.uptimeMillis() + 35000L);
      return;
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public int b(int paramInt)
  {
    return super.b(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnq
 * JD-Core Version:    0.7.0.1
 */