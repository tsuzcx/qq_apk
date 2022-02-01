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

public class bbvq
  extends bbvs
{
  bbvq(bbvn parambbvn) {}
  
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
    bbtg localbbtg;
    if (paramBoolean1)
    {
      bbvn.c(this.a, 0L);
      bbvn.a(this.a, paramBoolean2);
      if (bbvn.b(this.a) == null) {
        return;
      }
      Iterator localIterator = bbvn.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localbbtg = (bbtg)localIterator.next();
      if (!paramBoolean1) {
        break label162;
      }
    }
    label162:
    for (int i = 100;; i = -1)
    {
      localbbtg.a(i, paramBoolean2);
      break label83;
      bbvn.c(this.a, System.currentTimeMillis() - 180000L + 60000L);
      paramBoolean2 = bbvn.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList<UserProfile> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.mate", 2, "onGetStatusMate " + paramBoolean1 + " " + paramBoolean2 + " " + paramInt + " " + paramArrayList.size());
    }
    if (paramArrayList == null) {
      return;
    }
    if (paramBoolean1) {
      bbvn.a(this.a, paramArrayOfByte);
    }
    for (;;)
    {
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          if (bbvn.a(this.a) != null)
          {
            bbvn.a(this.a, paramArrayList);
            return;
            if (!paramBoolean2) {
              continue;
            }
            bbvn.a(this.a, null);
            continue;
          }
          if (bbvn.b(this.a) == null) {
            bbvn.b(this.a, new ArrayList());
          }
          paramArrayOfByte = this.a.a(bbvn.b(this.a), paramArrayList, paramInt);
        }
      }
    }
    for (;;)
    {
      label171:
      if ((bbvn.a(this.a) != null) && (bbvn.a(this.a).length > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (bbvn.c(this.a) == null) {
          break label270;
        }
        paramArrayList = bbvn.c(this.a).iterator();
        while (paramArrayList.hasNext()) {
          ((bbtf)paramArrayList.next()).a(paramBoolean1, paramBoolean2, paramInt, paramArrayOfByte, bool);
        }
        break;
        paramArrayOfByte = this.a.a(paramArrayList);
        break label171;
      }
      label270:
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
    bbtg localbbtg;
    if (paramBoolean1)
    {
      bbvn.a(this.a, paramBoolean2);
      if (bbvn.b(this.a) == null) {
        return;
      }
      Iterator localIterator = bbvn.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localbbtg = (bbtg)localIterator.next();
      if (!paramBoolean1) {
        break label134;
      }
    }
    label134:
    for (int i = 100;; i = -1)
    {
      localbbtg.b(i, paramBoolean2);
      break label74;
      paramBoolean2 = bbvn.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvq
 * JD-Core Version:    0.7.0.1
 */