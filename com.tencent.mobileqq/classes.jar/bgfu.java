import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import mqq.os.MqqHandler;

public class bgfu
  extends aqwt<bgft>
{
  private final List<bgfw> a = new LinkedList();
  
  public static bgft a()
  {
    bgft localbgft = (bgft)aqxe.a().a(695);
    if (localbgft != null) {
      return localbgft;
    }
    return new bgft();
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardConfigProcessor", 2, "[notifyListeners]:" + this.a.size());
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
          bgfw localbgfw = (bgfw)localIterator.next();
          try
          {
            localbgfw.a(paramInt);
          }
          catch (Throwable localThrowable2) {}
          if (QLog.isColorLevel()) {
            QLog.e("TroopGameCardConfigProcessor", 1, localThrowable2, new Object[0]);
          }
        }
      }
      this.a.clear();
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGameCardConfigProcessor", 1, localThrowable1, new Object[0]);
      }
      return;
    }
    label162:
  }
  
  private void b(bgft parambgft)
  {
    if (parambgft == null) {
      return;
    }
    new bgfz((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(new bggc(parambgft.a(), parambgft.b()), new bgfv(this));
  }
  
  @NonNull
  public bgft a(int paramInt)
  {
    QLog.d("TroopGameCardConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bgft();
  }
  
  @Nullable
  public bgft a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = bgft.a(paramArrayOfaqxa[0].a);
      b(paramArrayOfaqxa);
      return paramArrayOfaqxa;
    }
    return null;
  }
  
  public void a(bgft parambgft) {}
  
  public void a(bgfw parambgfw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardConfigProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(parambgfw);
        return;
      }
      this.a.add(parambgfw);
      aqxe.a().a(new int[] { 695 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new TroopGameCardConfigProcessor.2(this), this, SystemClock.uptimeMillis() + 10000L);
      return;
    }
  }
  
  public Class<bgft> clazz()
  {
    return bgft.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
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
    QLog.d("TroopGameCardConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 695;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfu
 * JD-Core Version:    0.7.0.1
 */