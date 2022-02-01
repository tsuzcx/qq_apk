import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.AvGameConfProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class aqzv
  extends aqwt<nqg>
{
  private final List<aqzw> a = new LinkedList();
  
  public static nqg a()
  {
    nqg localnqg = (nqg)aqxe.a().a(642);
    if (localnqg != null) {
      return localnqg;
    }
    return new nqg();
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "[notifyListeners]:" + this.a.size());
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
          aqzw localaqzw = (aqzw)localIterator.next();
          try
          {
            localaqzw.a(paramInt);
          }
          catch (Throwable localThrowable2) {}
          if (QLog.isColorLevel()) {
            QLog.e("AvGameConfProcessor", 1, localThrowable2, new Object[0]);
          }
        }
      }
      this.a.clear();
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameConfProcessor", 1, localThrowable1, new Object[0]);
      }
      return;
    }
    label162:
  }
  
  @NonNull
  public nqg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AvGameConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new nqg();
  }
  
  @Nullable
  public nqg a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return nqg.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(aqzw paramaqzw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(paramaqzw);
        return;
      }
      this.a.add(paramaqzw);
      aqxe.a().a(new int[] { 642 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new AvGameConfProcessor.1(this), this, SystemClock.uptimeMillis() + 10000L);
      return;
    }
  }
  
  public void a(nqg paramnqg)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramnqg == null) {
        break label48;
      }
    }
    label48:
    for (paramnqg = paramnqg.toString();; paramnqg = " empty")
    {
      QLog.d("AvGameConfProcessor", 2, paramnqg);
      a(0);
      return;
    }
  }
  
  public Class clazz()
  {
    return nqg.class;
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
      QLog.e("AvGameConfProcessor", 2, "onReqFailed " + paramInt);
    }
    a(paramInt);
  }
  
  public int type()
  {
    return 642;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzv
 * JD-Core Version:    0.7.0.1
 */