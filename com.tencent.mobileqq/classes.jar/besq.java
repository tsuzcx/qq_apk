import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class besq
  extends alzl<besp>
{
  private final List<besr> a = new LinkedList();
  
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
        localObject = alzw.a().a(526);
        if (localObject != null) {
          ((alzl)localObject).a(-2);
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
    synchronized (this.a)
    {
      if (this.a.size() <= 0) {
        break label108;
      }
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext()) {
        ((besr)localIterator.next()).a();
      }
    }
    this.a.clear();
    label108:
  }
  
  public int a()
  {
    return 526;
  }
  
  @NonNull
  public besp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new besp();
  }
  
  @Nullable
  public besp a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onParsed]");
    }
    besp localbesp = new besp();
    localbesp.a = paramArrayOfalzs;
    return localbesp;
  }
  
  public Class<besp> a()
  {
    return besp.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "onReqNoReceive: type=" + a());
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
  
  public void a(besp parambesp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onUpdate] newConf:" + parambesp);
    }
    besl.a().a(parambesp);
    b();
  }
  
  public void a(besr parambesr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(parambesr);
        return;
      }
      this.a.add(parambesr);
      alzw.a().a(526, 0);
      alzw.a().a(new int[] { 526 });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besq
 * JD-Core Version:    0.7.0.1
 */