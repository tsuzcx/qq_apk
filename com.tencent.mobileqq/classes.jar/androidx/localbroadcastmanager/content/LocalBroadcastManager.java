package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class LocalBroadcastManager
{
  private static final boolean DEBUG = false;
  static final int MSG_EXEC_PENDING_BROADCASTS = 1;
  private static final String TAG = "LocalBroadcastManager";
  private static LocalBroadcastManager mInstance;
  private static final Object mLock = new Object();
  private final HashMap<String, ArrayList<LocalBroadcastManager.ReceiverRecord>> mActions = new HashMap();
  private final Context mAppContext;
  private final Handler mHandler;
  private final ArrayList<LocalBroadcastManager.BroadcastRecord> mPendingBroadcasts = new ArrayList();
  private final HashMap<BroadcastReceiver, ArrayList<LocalBroadcastManager.ReceiverRecord>> mReceivers = new HashMap();
  
  private LocalBroadcastManager(Context paramContext)
  {
    this.mAppContext = paramContext;
    this.mHandler = new LocalBroadcastManager.1(this, paramContext.getMainLooper());
  }
  
  @NonNull
  public static LocalBroadcastManager getInstance(@NonNull Context paramContext)
  {
    synchronized (mLock)
    {
      if (mInstance == null) {
        mInstance = new LocalBroadcastManager(paramContext.getApplicationContext());
      }
      paramContext = mInstance;
      return paramContext;
    }
  }
  
  void executePendingBroadcasts()
  {
    synchronized (this.mReceivers)
    {
      int i;
      LocalBroadcastManager.BroadcastRecord[] arrayOfBroadcastRecord;
      do
      {
        i = this.mPendingBroadcasts.size();
        if (i <= 0) {
          return;
        }
        arrayOfBroadcastRecord = new LocalBroadcastManager.BroadcastRecord[i];
        this.mPendingBroadcasts.toArray(arrayOfBroadcastRecord);
        this.mPendingBroadcasts.clear();
        i = 0;
      } while (i >= arrayOfBroadcastRecord.length);
      ??? = arrayOfBroadcastRecord[i];
      int k = ???.receivers.size();
      int j = 0;
      while (j < k)
      {
        LocalBroadcastManager.ReceiverRecord localReceiverRecord = (LocalBroadcastManager.ReceiverRecord)???.receivers.get(j);
        if (!localReceiverRecord.dead) {
          localReceiverRecord.receiver.onReceive(this.mAppContext, ???.intent);
        }
        j += 1;
      }
      i += 1;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void registerReceiver(@NonNull BroadcastReceiver paramBroadcastReceiver, @NonNull IntentFilter paramIntentFilter)
  {
    synchronized (this.mReceivers)
    {
      LocalBroadcastManager.ReceiverRecord localReceiverRecord = new LocalBroadcastManager.ReceiverRecord(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.mReceivers.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.mReceivers.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localReceiverRecord);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.mActions.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.mActions.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localReceiverRecord);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw paramBroadcastReceiver;
    }
  }
  
  public boolean sendBroadcast(@NonNull Intent paramIntent)
  {
    int i;
    Object localObject1;
    int j;
    Object localObject2;
    int k;
    label527:
    label535:
    label538:
    label545:
    label611:
    label618:
    synchronized (this.mReceivers)
    {
      String str1 = paramIntent.getAction();
      String str2 = paramIntent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
      Uri localUri = paramIntent.getData();
      String str3 = paramIntent.getScheme();
      Set localSet = paramIntent.getCategories();
      if ((paramIntent.getFlags() & 0x8) != 0)
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Resolving type ");
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append(" scheme ");
          ((StringBuilder)localObject1).append(str3);
          ((StringBuilder)localObject1).append(" of intent ");
          ((StringBuilder)localObject1).append(paramIntent);
          Log.v("LocalBroadcastManager", ((StringBuilder)localObject1).toString());
        }
        ArrayList localArrayList = (ArrayList)this.mActions.get(paramIntent.getAction());
        if (localArrayList != null)
        {
          if (i == 0) {
            break label527;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Action list: ");
          ((StringBuilder)localObject1).append(localArrayList);
          Log.v("LocalBroadcastManager", ((StringBuilder)localObject1).toString());
          break label527;
          if (j >= localArrayList.size()) {
            break label618;
          }
          Object localObject3 = (LocalBroadcastManager.ReceiverRecord)localArrayList.get(j);
          if (i != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Matching against filter ");
            ((StringBuilder)localObject1).append(((LocalBroadcastManager.ReceiverRecord)localObject3).filter);
            Log.v("LocalBroadcastManager", ((StringBuilder)localObject1).toString());
          }
          if (((LocalBroadcastManager.ReceiverRecord)localObject3).broadcasting)
          {
            if (i == 0) {
              break label535;
            }
            Log.v("LocalBroadcastManager", "  Filter's target already added");
            break label535;
          }
          IntentFilter localIntentFilter = ((LocalBroadcastManager.ReceiverRecord)localObject3).filter;
          localObject1 = localObject2;
          k = localIntentFilter.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
          if (k < 0) {
            break label545;
          }
          if (i != 0)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("  Filter matched!  match=0x");
            ((StringBuilder)localObject2).append(Integer.toHexString(k));
            Log.v("LocalBroadcastManager", ((StringBuilder)localObject2).toString());
          }
          if (localObject1 != null) {
            break label538;
          }
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(localObject3);
          ((LocalBroadcastManager.ReceiverRecord)localObject3).broadcasting = true;
          break label611;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("  Filter did not match: ");
          ((StringBuilder)localObject3).append((String)localObject1);
          Log.v("LocalBroadcastManager", ((StringBuilder)localObject3).toString());
          break label611;
          while (i < ((ArrayList)localObject2).size())
          {
            ((LocalBroadcastManager.ReceiverRecord)((ArrayList)localObject2).get(i)).broadcasting = false;
            i += 1;
          }
          this.mPendingBroadcasts.add(new LocalBroadcastManager.BroadcastRecord(paramIntent, (ArrayList)localObject2));
          if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessage(1);
          }
          return true;
        }
        return false;
      }
    }
  }
  
  public void sendBroadcastSync(@NonNull Intent paramIntent)
  {
    if (sendBroadcast(paramIntent)) {
      executePendingBroadcasts();
    }
  }
  
  public void unregisterReceiver(@NonNull BroadcastReceiver paramBroadcastReceiver)
  {
    int i;
    int j;
    int k;
    label202:
    label209:
    synchronized (this.mReceivers)
    {
      ArrayList localArrayList1 = (ArrayList)this.mReceivers.remove(paramBroadcastReceiver);
      if (localArrayList1 == null) {
        return;
      }
      i = localArrayList1.size() - 1;
      if (i >= 0)
      {
        LocalBroadcastManager.ReceiverRecord localReceiverRecord1 = (LocalBroadcastManager.ReceiverRecord)localArrayList1.get(i);
        localReceiverRecord1.dead = true;
        j = 0;
        if (j >= localReceiverRecord1.filter.countActions()) {
          break label209;
        }
        String str = localReceiverRecord1.filter.getAction(j);
        ArrayList localArrayList2 = (ArrayList)this.mActions.get(str);
        if (localArrayList2 == null) {
          break label202;
        }
        k = localArrayList2.size() - 1;
        if (k >= 0)
        {
          LocalBroadcastManager.ReceiverRecord localReceiverRecord2 = (LocalBroadcastManager.ReceiverRecord)localArrayList2.get(k);
          if (localReceiverRecord2.receiver == paramBroadcastReceiver)
          {
            localReceiverRecord2.dead = true;
            localArrayList2.remove(k);
          }
        }
        else
        {
          if (localArrayList2.size() > 0) {
            break label202;
          }
          this.mActions.remove(str);
          break label202;
        }
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.localbroadcastmanager.content.LocalBroadcastManager
 * JD-Core Version:    0.7.0.1
 */