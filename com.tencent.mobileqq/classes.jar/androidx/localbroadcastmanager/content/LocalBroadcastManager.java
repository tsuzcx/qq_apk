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
  private static LocalBroadcastManager jdField_a_of_type_AndroidxLocalbroadcastmanagerContentLocalBroadcastManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final ArrayList<LocalBroadcastManager.BroadcastRecord> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap<BroadcastReceiver, ArrayList<LocalBroadcastManager.ReceiverRecord>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final HashMap<String, ArrayList<LocalBroadcastManager.ReceiverRecord>> b = new HashMap();
  
  private LocalBroadcastManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new LocalBroadcastManager.1(this, paramContext.getMainLooper());
  }
  
  @NonNull
  public static LocalBroadcastManager a(@NonNull Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_AndroidxLocalbroadcastmanagerContentLocalBroadcastManager == null) {
        jdField_a_of_type_AndroidxLocalbroadcastmanagerContentLocalBroadcastManager = new LocalBroadcastManager(paramContext.getApplicationContext());
      }
      paramContext = jdField_a_of_type_AndroidxLocalbroadcastmanagerContentLocalBroadcastManager;
      return paramContext;
    }
  }
  
  void a()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i <= 0) {
          return;
        }
        LocalBroadcastManager.BroadcastRecord[] arrayOfBroadcastRecord = new LocalBroadcastManager.BroadcastRecord[i];
        this.jdField_a_of_type_JavaUtilArrayList.toArray(arrayOfBroadcastRecord);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        i = 0;
        if (i >= arrayOfBroadcastRecord.length) {
          continue;
        }
        ??? = arrayOfBroadcastRecord[i];
        int k = ???.jdField_a_of_type_JavaUtilArrayList.size();
        int j = 0;
        if (j < k)
        {
          LocalBroadcastManager.ReceiverRecord localReceiverRecord = (LocalBroadcastManager.ReceiverRecord)???.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (!localReceiverRecord.b) {
            localReceiverRecord.jdField_a_of_type_AndroidContentBroadcastReceiver.onReceive(this.jdField_a_of_type_AndroidContentContext, ???.jdField_a_of_type_AndroidContentIntent);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public void a(@NonNull BroadcastReceiver paramBroadcastReceiver)
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        ArrayList localArrayList1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.remove(paramBroadcastReceiver);
        if (localArrayList1 == null) {
          return;
        }
        i = localArrayList1.size() - 1;
        if (i >= 0)
        {
          LocalBroadcastManager.ReceiverRecord localReceiverRecord1 = (LocalBroadcastManager.ReceiverRecord)localArrayList1.get(i);
          localReceiverRecord1.b = true;
          j = 0;
          if (j >= localReceiverRecord1.jdField_a_of_type_AndroidContentIntentFilter.countActions()) {
            break label203;
          }
          String str = localReceiverRecord1.jdField_a_of_type_AndroidContentIntentFilter.getAction(j);
          ArrayList localArrayList2 = (ArrayList)this.b.get(str);
          if (localArrayList2 == null) {
            break label196;
          }
          k = localArrayList2.size() - 1;
          if (k >= 0)
          {
            LocalBroadcastManager.ReceiverRecord localReceiverRecord2 = (LocalBroadcastManager.ReceiverRecord)localArrayList2.get(k);
            if (localReceiverRecord2.jdField_a_of_type_AndroidContentBroadcastReceiver == paramBroadcastReceiver)
            {
              localReceiverRecord2.b = true;
              localArrayList2.remove(k);
            }
          }
          else
          {
            if (localArrayList2.size() > 0) {
              break label196;
            }
            this.b.remove(str);
            break label196;
          }
        }
        else
        {
          return;
        }
      }
      k -= 1;
      continue;
      label196:
      j += 1;
      continue;
      label203:
      i -= 1;
    }
  }
  
  public void a(@NonNull BroadcastReceiver paramBroadcastReceiver, @NonNull IntentFilter paramIntentFilter)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      LocalBroadcastManager.ReceiverRecord localReceiverRecord = new LocalBroadcastManager.ReceiverRecord(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localReceiverRecord);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.b.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.b.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localReceiverRecord);
        i += 1;
      }
      return;
    }
  }
  
  public void a(@NonNull Intent paramIntent)
  {
    if (a(paramIntent)) {
      a();
    }
  }
  
  public boolean a(@NonNull Intent paramIntent)
  {
    int i;
    label161:
    int j;
    Object localObject;
    int k;
    ArrayList localArrayList1;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      String str1 = paramIntent.getAction();
      String str2 = paramIntent.resolveTypeIfNeeded(this.jdField_a_of_type_AndroidContentContext.getContentResolver());
      Uri localUri = paramIntent.getData();
      String str3 = paramIntent.getScheme();
      Set localSet = paramIntent.getCategories();
      if ((paramIntent.getFlags() & 0x8) == 0) {
        break label500;
      }
      i = 1;
      if (i != 0) {
        Log.v("LocalBroadcastManager", "Resolving type " + str2 + " scheme " + str3 + " of intent " + paramIntent);
      }
      ArrayList localArrayList2 = (ArrayList)this.b.get(paramIntent.getAction());
      if (localArrayList2 == null) {
        break label477;
      }
      if (i == 0) {
        break label485;
      }
      Log.v("LocalBroadcastManager", "Action list: " + localArrayList2);
      break label485;
      if (j >= localArrayList2.size()) {
        break label536;
      }
      localObject = (LocalBroadcastManager.ReceiverRecord)localArrayList2.get(j);
      if (i != 0) {
        Log.v("LocalBroadcastManager", "Matching against filter " + ((LocalBroadcastManager.ReceiverRecord)localObject).jdField_a_of_type_AndroidContentIntentFilter);
      }
      if (((LocalBroadcastManager.ReceiverRecord)localObject).jdField_a_of_type_Boolean)
      {
        if (i == 0) {
          break label505;
        }
        Log.v("LocalBroadcastManager", "  Filter's target already added");
      }
      else
      {
        k = ((LocalBroadcastManager.ReceiverRecord)localObject).jdField_a_of_type_AndroidContentIntentFilter.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
        if (k >= 0)
        {
          if (i != 0) {
            Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(k));
          }
          if (localArrayList1 != null) {
            break label482;
          }
          localArrayList1 = new ArrayList();
          label311:
          localArrayList1.add(localObject);
          ((LocalBroadcastManager.ReceiverRecord)localObject).jdField_a_of_type_Boolean = true;
        }
      }
    }
    if (i != 0) {
      switch (k)
      {
      default: 
        localObject = "unknown reason";
        label376:
        Log.v("LocalBroadcastManager", "  Filter did not match: " + (String)localObject);
        break;
      }
    }
    for (;;)
    {
      if (i < localArrayList1.size())
      {
        ((LocalBroadcastManager.ReceiverRecord)localArrayList1.get(i)).jdField_a_of_type_Boolean = false;
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new LocalBroadcastManager.BroadcastRecord(paramIntent, localArrayList1));
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
        return true;
        label477:
        label482:
        label485:
        label500:
        label505:
        do
        {
          return false;
          break label311;
          localArrayList1 = null;
          j = 0;
          break label161;
          for (;;)
          {
            j += 1;
            break label161;
            i = 0;
            break;
          }
          localObject = "action";
          break label376;
          localObject = "category";
          break label376;
          localObject = "data";
          break label376;
          localObject = "type";
          break label376;
        } while (localArrayList1 == null);
        label536:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.localbroadcastmanager.content.LocalBroadcastManager
 * JD-Core Version:    0.7.0.1
 */