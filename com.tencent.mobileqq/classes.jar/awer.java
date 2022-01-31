import PersonalState.UserProfile;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.StatusManager.3.1;
import com.tencent.mobileqq.richstatus.StatusManager.3.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class awer
  extends awet
{
  awer(aweo paramaweo) {}
  
  @TargetApi(9)
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new StatusManager.3.1(this, paramBoolean, paramBundle));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onGetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label83:
    awcg localawcg;
    if (paramBoolean1)
    {
      aweo.c(this.a, 0L);
      aweo.a(this.a, paramBoolean2);
      if (aweo.b(this.a) == null) {
        return;
      }
      Iterator localIterator = aweo.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localawcg = (awcg)localIterator.next();
      if (!paramBoolean1) {
        break label162;
      }
    }
    label162:
    for (int i = 100;; i = -1)
    {
      localawcg.a(i, paramBoolean2);
      break label83;
      aweo.c(this.a, System.currentTimeMillis() - 180000L + 60000L);
      paramBoolean2 = aweo.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList<UserProfile> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.mate", 2, "onGetStatusMate " + paramBoolean1 + " " + paramBoolean2 + " " + paramInt + " " + paramArrayList.size());
    }
    if (paramBoolean1) {
      aweo.a(this.a, paramArrayOfByte);
    }
    for (;;)
    {
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          if (aweo.a(this.a) != null)
          {
            aweo.a(this.a, paramArrayList);
            return;
            if (!paramBoolean2) {
              continue;
            }
            aweo.a(this.a, null);
            continue;
          }
          if (aweo.b(this.a) == null) {
            aweo.b(this.a, new ArrayList());
          }
          paramArrayOfByte = this.a.a(aweo.b(this.a), paramArrayList, paramInt);
        }
      }
    }
    for (;;)
    {
      label165:
      if ((aweo.a(this.a) != null) && (aweo.a(this.a).length > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (aweo.c(this.a) == null) {
          break label264;
        }
        paramArrayList = aweo.c(this.a).iterator();
        while (paramArrayList.hasNext()) {
          ((awcf)paramArrayList.next()).a(paramBoolean1, paramBoolean2, paramInt, paramArrayOfByte, bool);
        }
        break;
        paramArrayOfByte = this.a.a(paramArrayList);
        break label165;
      }
      label264:
      break;
      paramArrayOfByte = paramArrayList;
    }
  }
  
  protected void b(boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new StatusManager.3.2(this, paramBoolean));
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onSetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label74:
    awcg localawcg;
    if (paramBoolean1)
    {
      aweo.a(this.a, paramBoolean2);
      if (aweo.b(this.a) == null) {
        return;
      }
      Iterator localIterator = aweo.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localawcg = (awcg)localIterator.next();
      if (!paramBoolean1) {
        break label134;
      }
    }
    label134:
    for (int i = 100;; i = -1)
    {
      localawcg.b(i, paramBoolean2);
      break label74;
      paramBoolean2 = aweo.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awer
 * JD-Core Version:    0.7.0.1
 */