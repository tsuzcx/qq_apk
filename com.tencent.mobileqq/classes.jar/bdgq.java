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

public class bdgq
  extends aqwt<bdgp>
{
  private final List<bdgr> a = new LinkedList();
  
  private void a(int paramInt)
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
          bdgr localbdgr = (bdgr)localIterator.next();
          try
          {
            localbdgr.a(paramInt);
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
        localObject = aqxe.a().a(526);
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
          ((aqwt)localObject).onReqFailed(j);
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
    bdgf.a();
    a(paramInt);
  }
  
  @NonNull
  public bdgp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new bdgp();
  }
  
  @Nullable
  public bdgp a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onParsed]");
    }
    bdgp localbdgp = new bdgp();
    localbdgp.a = paramArrayOfaqxa;
    return localbdgp;
  }
  
  public void a(bdgp parambdgp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onUpdate] newConf:" + parambdgp);
    }
    bdgl.a().a(parambdgp);
    b(0);
  }
  
  public void a(bdgr parambdgr)
  {
    a(parambdgr, true);
  }
  
  public void a(bdgr parambdgr, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(parambdgr);
        return;
      }
      this.a.add(parambdgr);
      aqxe.a().a(526, 0);
      aqxe.a().a(new int[] { 526 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new SoLoadConfProcessor.1(this), this, SystemClock.uptimeMillis() + 35000L);
      return;
    }
  }
  
  public Class<bdgp> clazz()
  {
    return bdgp.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
    b(paramInt);
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + aqxe.a().a(526));
    }
    b(0);
  }
  
  public int onSend(int paramInt)
  {
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 526;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgq
 * JD-Core Version:    0.7.0.1
 */