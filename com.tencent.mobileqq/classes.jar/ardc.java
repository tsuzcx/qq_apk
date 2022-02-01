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

public class ardc
  extends arac<nht>
{
  private final List<ardd> a = new LinkedList();
  
  public static nht a()
  {
    nht localnht = (nht)aran.a().a(642);
    if (localnht != null) {
      return localnht;
    }
    return new nht();
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
          ardd localardd = (ardd)localIterator.next();
          try
          {
            localardd.a(paramInt);
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
  public nht a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AvGameConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new nht();
  }
  
  @Nullable
  public nht a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvGameConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return nht.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(ardd paramardd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(paramardd);
        return;
      }
      this.a.add(paramardd);
      aran.a().a(new int[] { 642 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new AvGameConfProcessor.1(this), this, SystemClock.uptimeMillis() + 10000L);
      return;
    }
  }
  
  public void a(nht paramnht)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramnht == null) {
        break label48;
      }
    }
    label48:
    for (paramnht = paramnht.toString();; paramnht = " empty")
    {
      QLog.d("AvGameConfProcessor", 2, paramnht);
      a(0);
      return;
    }
  }
  
  public Class clazz()
  {
    return nht.class;
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
 * Qualified Name:     ardc
 * JD-Core Version:    0.7.0.1
 */