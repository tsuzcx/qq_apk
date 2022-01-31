import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.core.proxy.VoIPProxy.VoIPListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class beiy
{
  public static volatile beiy a;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new beiz(this);
  private bejb jdField_a_of_type_Bejb;
  private bejd jdField_a_of_type_Bejd;
  private beje jdField_a_of_type_Beje;
  private VoIPProxy.VoIPListener jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy$VoIPListener = new beja(this);
  private VoIPProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy;
  private Map<Long, bejh> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  private int a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      besl.d("VoIPManager", "cant op mic currently");
      return -1;
    }
    int j = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.enableLocalAudio(paramBoolean);
    int i;
    if (j == 0) {
      if (paramBoolean)
      {
        i = 1;
        this.jdField_a_of_type_Int = i;
        bejh localbejh = a(this.jdField_a_of_type_Long);
        if (localbejh != null) {
          localbejh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        }
        besl.b("VoIPManager", "OpMic " + paramBoolean);
      }
    }
    for (;;)
    {
      return j;
      i = 2;
      break;
      besl.d("VoIPManager", "multiOperator null");
    }
  }
  
  public static beiy a()
  {
    if (jdField_a_of_type_Beiy == null) {}
    try
    {
      if (jdField_a_of_type_Beiy == null) {
        jdField_a_of_type_Beiy = new beiy();
      }
      return jdField_a_of_type_Beiy;
    }
    finally {}
  }
  
  private bejh a(long paramLong)
  {
    bejh localbejh = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbejh = (bejh)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return localbejh;
  }
  
  private JSONArray a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet();
      localObject1 = new HashSet();
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        bejh localbejh = a(((Long)((Iterator)localObject2).next()).longValue());
        if (localbejh != null) {
          ((Set)localObject1).add(localbejh.jdField_a_of_type_JavaLangString);
        }
      }
      localObject1 = new JSONArray((Collection)localObject1);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new JSONArray();
    }
    return localObject2;
  }
  
  private void a(int paramInt)
  {
    besl.a("VoIPManager", "switchAudioRoute " + paramInt);
    if (paramInt == -1) {
      if (e()) {
        this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.setAudioRoute(0);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.setAudioRoute(1);
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.setAudioRoute(0);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.setAudioRoute(1);
  }
  
  private void a(long paramLong)
  {
    besl.b("VoIPManager", "qavInitSDK");
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.init(this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy$VoIPListener);
  }
  
  private void a(bejh parambejh)
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(parambejh.jdField_a_of_type_Long), parambejh);
    }
  }
  
  private void a(List<VoIPProxy.MultiUserInfo> paramList)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet();
    Object localObject2 = new HashSet();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject2).add(Long.valueOf(((VoIPProxy.MultiUserInfo)localIterator.next()).mUin));
    }
    ((Set)localObject1).retainAll((Collection)localObject2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (VoIPProxy.MultiUserInfo)paramList.next();
      if (a(((VoIPProxy.MultiUserInfo)localObject1).mUin) == null)
      {
        localObject2 = new bejh(this, null);
        ((bejh)localObject2).jdField_a_of_type_Long = ((VoIPProxy.MultiUserInfo)localObject1).mUin;
        ((bejh)localObject2).jdField_a_of_type_JavaLangString = ((VoIPProxy.MultiUserInfo)localObject1).mOpenId;
        ((bejh)localObject2).jdField_a_of_type_Int = 1;
        a((bejh)localObject2);
      }
    }
  }
  
  private int b(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      besl.d("VoIPManager", "cant op mute currently");
      return -1;
    }
    int j = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.enableRemoteAudio(paramBoolean);
    int i;
    if (j == 0) {
      if (paramBoolean)
      {
        i = 1;
        this.jdField_b_of_type_Int = i;
        besl.b("VoIPManager", "OpMute " + paramBoolean);
      }
    }
    for (;;)
    {
      return j;
      i = 2;
      break;
      besl.d("VoIPManager", "multiOperator null");
    }
  }
  
  private bejh b(long paramLong)
  {
    bejh localbejh = null;
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      localbejh = (bejh)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
    }
    return localbejh;
  }
  
  private JSONArray b()
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((bejh)localEntry.getValue()).jdField_a_of_type_Boolean) {
          localJSONArray.put(((bejh)localEntry.getValue()).jdField_a_of_type_JavaLangString);
        }
      }
    }
    return localJSONArray;
  }
  
  private void b()
  {
    besl.b("VoIPManager", "exitRoom!");
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.exitRoom();
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.unInit();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  private boolean d()
  {
    AudioRecord localAudioRecord = new AudioRecord(1, 44100, 16, 1, 44100);
    for (;;)
    {
      try
      {
        if (localAudioRecord.getRecordingState() != 1)
        {
          Boolean localBoolean1 = Boolean.valueOf(false);
          localAudioRecord.startRecording();
          if (localAudioRecord.getRecordingState() != 3)
          {
            localAudioRecord.stop();
            localBoolean1 = Boolean.valueOf(false);
          }
          localAudioRecord.stop();
          return localBoolean1.booleanValue();
        }
      }
      catch (Throwable localThrowable)
      {
        besl.d("VoIPManager", "validateMicAvailability", localThrowable);
        return false;
      }
      finally
      {
        localAudioRecord.release();
      }
      Boolean localBoolean2 = Boolean.valueOf(true);
    }
  }
  
  private boolean e()
  {
    return ((AudioManager)MiniAppEnv.g().getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        MiniAppEnv.g().getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        b();
        this.jdField_b_of_type_Boolean = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(bejb parambejb)
  {
    this.jdField_a_of_type_Bejb = parambejb;
  }
  
  public void a(bejc parambejc, beje parambeje, byte[] paramArrayOfByte, bejd parambejd)
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          besl.d("VoIPManager", "不能重复进房");
          if (parambejd != null) {
            parambejd.onError(-3);
          }
          return;
        }
        a();
        if (!this.jdField_a_of_type_Boolean)
        {
          if (d())
          {
            a(parambejc.jdField_a_of_type_Long);
            this.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          this.jdField_a_of_type_Bejd = parambejd;
          this.jdField_a_of_type_Long = parambejc.jdField_a_of_type_Long;
          i = this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVoIPProxy.joinRoom(parambejc.jdField_a_of_type_Long, parambejc.jdField_a_of_type_Int, parambejc.jdField_a_of_type_JavaLangString);
          if (i != 0) {
            break label179;
          }
          this.jdField_a_of_type_Beje = parambeje;
          this.jdField_b_of_type_Boolean = true;
          parambejc = new IntentFilter();
          parambejc.addAction("android.intent.action.HEADSET_PLUG");
          MiniAppEnv.g().getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, parambejc);
          this.jdField_a_of_type_JavaUtilMap.clear();
          continue;
        }
        if (parambejd == null) {
          continue;
        }
      }
      finally {}
      parambejd.onError(-2);
      continue;
      label179:
      besl.d("VoIPManager", "joinRoom ret = " + i);
      if (this.jdField_a_of_type_Bejd != null)
      {
        this.jdField_a_of_type_Bejd.onError(i);
        this.jdField_a_of_type_Bejd = null;
      }
    }
  }
  
  /* Error */
  public void a(beje parambeje, bejf parambejf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 382	beje:jdField_a_of_type_Boolean	Z
    //   6: ifne +46 -> 52
    //   9: iconst_1
    //   10: istore 5
    //   12: aload_0
    //   13: iload 5
    //   15: invokespecial 384	beiy:a	(Z)I
    //   18: istore_3
    //   19: aload_0
    //   20: aload_1
    //   21: getfield 385	beje:jdField_b_of_type_Boolean	Z
    //   24: invokespecial 387	beiy:b	(Z)I
    //   27: istore 4
    //   29: iload_3
    //   30: ifne +8 -> 38
    //   33: iload 4
    //   35: ifeq +23 -> 58
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: iconst_m1
    //   44: invokeinterface 392 2 0
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: iconst_0
    //   53: istore 5
    //   55: goto -43 -> 12
    //   58: aload_2
    //   59: ifnull -10 -> 49
    //   62: aload_2
    //   63: invokeinterface 395 1 0
    //   68: goto -19 -> 49
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	beiy
    //   0	76	1	parambeje	beje
    //   0	76	2	parambejf	bejf
    //   18	12	3	i	int
    //   27	7	4	j	int
    //   10	44	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	71	finally
    //   12	29	71	finally
    //   42	49	71	finally
    //   62	68	71	finally
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	beiy:jdField_a_of_type_Int	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_2
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	beiy
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 43	beiy:jdField_b_of_type_Int	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpne +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	beiy
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.jdField_b_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beiy
 * JD-Core Version:    0.7.0.1
 */