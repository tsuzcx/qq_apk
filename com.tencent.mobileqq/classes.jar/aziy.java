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

public class aziy
  extends aofy<azix>
{
  private final List<aziz> a = new LinkedList();
  
  public static void a(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg)
  {
    int m = paramArrayOfInt.length;
    int i = 0;
    if (i < m)
    {
      Object localObject;
      boolean bool;
      if (paramArrayOfInt[i] == 526) {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("[notifyNetFailed] isSucc=");
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
            break label148;
          }
          bool = true;
          label55:
          localObject = ((StringBuilder)localObject).append(bool).append(", resultCode=");
          if (paramFromServiceMsg == null) {
            break label154;
          }
        }
      }
      label148:
      label154:
      for (int j = paramFromServiceMsg.getResultCode();; j = -1)
      {
        QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, j);
        localObject = aogj.a().a(526);
        if (localObject != null)
        {
          int k = -2;
          j = k;
          if (paramFromServiceMsg != null)
          {
            j = k;
            if (paramFromServiceMsg.getResultCode() == 1002) {
              j = -1;
            }
          }
          ((aofy)localObject).a(j);
        }
        i += 1;
        break;
        bool = false;
        break label55;
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[notifyListeners]:" + this.a.size());
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    try
    {
      synchronized (this.a)
      {
        if (this.a.size() <= 0) {
          break label162;
        }
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          aziz localaziz = (aziz)localIterator.next();
          try
          {
            localaziz.a(paramInt);
          }
          catch (Throwable localThrowable2) {}
          if (QLog.isColorLevel()) {
            QLog.e("SoLoadWidget.SoLoadConfProcessor", 1, localThrowable2, new Object[0]);
          }
        }
      }
      this.a.clear();
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLoadWidget.SoLoadConfProcessor", 1, localThrowable1, new Object[0]);
      }
      return;
    }
    label162:
  }
  
  public int a()
  {
    return 526;
  }
  
  @NonNull
  public azix a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new azix();
  }
  
  @Nullable
  public azix a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onParsed]");
    }
    azix localazix = new azix();
    localazix.a = paramArrayOfaogf;
    return localazix;
  }
  
  public Class<azix> a()
  {
    return azix.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "onReqNoReceive: type=" + a() + "curContent:" + aogj.a().a(526));
    }
    b(0);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
    b(paramInt);
  }
  
  public void a(azix paramazix)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onUpdate] newConf:" + paramazix);
    }
    azit.a().a(paramazix);
    b(0);
  }
  
  public void a(aziz paramaziz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(paramaziz);
        return;
      }
      this.a.add(paramaziz);
      aogj.a().a(526, 0);
      aogj.a().a(new int[] { 526 });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aziy
 * JD-Core Version:    0.7.0.1
 */