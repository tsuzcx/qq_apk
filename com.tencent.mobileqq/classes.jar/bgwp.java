import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.1;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.2;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.3;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.4;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.5;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class bgwp
{
  public static int a;
  private static bgwp jdField_a_of_type_Bgwp;
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(bgkn.b(), bgkn.b() + 5, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
  private bgwl jdField_a_of_type_Bgwl;
  private IAudioNativeManager jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, bgwl> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public AtomicInteger a;
  private boolean jdField_a_of_type_Boolean;
  private HashMap<Integer, Integer> b = new HashMap();
  private HashMap<Integer, bgwr> c = new HashMap();
  private HashMap<Integer, ArrayList<Integer>> d = new HashMap();
  
  static
  {
    jdField_a_of_type_Int = 5;
  }
  
  private bgwp()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public static bgwp a()
  {
    if (jdField_a_of_type_Bgwp == null) {
      jdField_a_of_type_Bgwp = new bgwp();
    }
    return jdField_a_of_type_Bgwp;
  }
  
  private void a(bgkd parambgkd, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return;
    }
    parambgkd = new WebAudioManager.3(this, paramInt1, paramInt2, parambgkd);
    AudioHandleThread.getInstance().post(parambgkd);
  }
  
  public double a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null) {
      return ((bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).a() / 1000.0D;
    }
    return -1.0D;
  }
  
  public float a(int paramInt1, int paramInt2)
  {
    bgwl localbgwl = (bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localbgwl == null) {
      return -1.0F;
    }
    return localbgwl.a(paramInt2);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.copyToChannel(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public JSONObject a(int paramInt)
  {
    Object localObject = (bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return null;
    }
    paramInt = ((bgwl)localObject).a();
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("channelId", paramInt);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return localObject;
  }
  
  public JSONObject a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.bindBufferToSource(paramInt2, paramInt1);
    return new JSONObject();
  }
  
  public JSONObject a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return null;
    }
    bgwl localbgwl = (bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localbgwl == null) {
      return null;
    }
    long l = localbgwl.a();
    l = paramInt3 * 1000 - l;
    if (l > 0L) {
      AudioHandleThread.getInstance().postDelayed(new WebAudioManager.4(this, paramInt2), l);
    }
    for (;;)
    {
      return new JSONObject();
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.stopSource(paramInt2);
    }
  }
  
  public JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return null;
    }
    if ((bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1)) == null) {
      return null;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.createBuffer(paramInt2, paramInt3 * paramInt2 * 2, paramInt4);
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt1));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bufferId", paramInt1);
      return localJSONObject;
    }
    catch (Throwable localThrowable) {}
    return localJSONObject;
  }
  
  public JSONObject a(bgkd parambgkd, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return null;
    }
    bgwl localbgwl = (bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localbgwl == null) {
      return null;
    }
    long l2 = localbgwl.a();
    long l1 = paramInt3 * 1000 - l2;
    if (l1 > 0L)
    {
      AudioHandleThread.getInstance().postDelayed(new WebAudioManager.1(this, paramInt2, paramInt4, parambgkd, paramInt1), l1);
      if (l1 <= 0L) {
        break label159;
      }
    }
    label159:
    for (l1 = paramInt3 * 1000;; l1 = l2)
    {
      if (paramInt5 > 0) {
        AudioHandleThread.getInstance().postDelayed(new WebAudioManager.2(this, paramInt2), l1 - l2 + paramInt5 * 1000);
      }
      return new JSONObject();
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.play(paramInt2, paramInt4);
      a(parambgkd, paramInt2, paramInt1);
      break;
    }
  }
  
  public JSONObject a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return null;
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    this.jdField_a_of_type_Bgwl = new bgwl(this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), this.jdField_a_of_type_Bgwl);
    paramString = new JSONObject();
    try
    {
      paramString.put("audioId", i);
      return paramString;
    }
    catch (Throwable localThrowable) {}
    return paramString;
  }
  
  public void a(int paramInt)
  {
    bgwl localbgwl = (bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localbgwl != null) {
      localbgwl.a();
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    this.d.clear();
    this.c.clear();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.play(-2, 0.0F);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, double paramDouble)
  {
    bgwl localbgwl = (bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localbgwl == null) {
      return;
    }
    localbgwl.a(paramInt2, paramDouble);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    bgwl localbgwl = (bgwl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localbgwl == null) {
      return;
    }
    localbgwl.a(paramInt2, paramBoolean);
  }
  
  @RequiresApi(api=16)
  public void a(int paramInt, byte[] paramArrayOfByte, bgkd parambgkd)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(new WebAudioManager.5(this, paramInt, parambgkd, paramArrayOfByte));
  }
  
  public void a(bgkd parambgkd, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return;
    }
    parambgkd = new WebAudioManager.6(this, parambgkd, ((Integer)this.b.get(Integer.valueOf(paramInt))).intValue() * 2 * 60 / 44100);
    AudioHandleThread.getInstance().post(parambgkd);
  }
  
  public void a(bgkd parambgkd, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return;
    }
    paramInt2 *= paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.createScriptProcessorNode(paramInt2, paramInt3, paramInt4);
    this.b.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void a(ITTEngine paramITTEngine)
  {
    if ((paramITTEngine != null) && (paramITTEngine.getOptionalSoLoadStatus("webAudio"))) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager = paramITTEngine.getAudioNativeManager();
    }
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.getBufferChannelData(paramInt1, paramInt2);
  }
  
  public JSONObject b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {
      return null;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_Bgwp)
      {
        Object localObject1;
        if ((this.c != null) && (this.c.containsKey(Integer.valueOf(paramInt2))))
        {
          localObject1 = (bgwr)this.c.get(Integer.valueOf(paramInt2));
          if ((localObject1 != null) && (this.d != null) && (this.d.containsKey(Integer.valueOf(paramInt2))))
          {
            localObject2 = (ArrayList)this.d.get(Integer.valueOf(paramInt2));
            if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {}
          }
        }
        switch (bgwr.a((bgwr)localObject1))
        {
        case 3: 
          return new JSONObject();
          localObject1 = ((ArrayList)localObject2).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          paramInt2 = ((Integer)((Iterator)localObject1).next()).intValue();
          this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
        }
      }
      Object localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramInt2 = ((Integer)((Iterator)localObject2).next()).intValue();
        this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
      }
      bgwr.a(localbgwr, 2);
      bgwr.a(localbgwr).add(Integer.valueOf(paramInt1));
    }
  }
  
  public void b(ITTEngine paramITTEngine)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {}
    while ((paramITTEngine == null) || (!paramITTEngine.getOptionalSoLoadStatus("webAudio")) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.closeAudioContext();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.d.clear();
    this.c.clear();
  }
  
  public void c(ITTEngine paramITTEngine)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {}
    while ((paramITTEngine == null) || (!paramITTEngine.getOptionalSoLoadStatus("webAudio")) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.suspendAudioContext();
  }
  
  public void d(ITTEngine paramITTEngine)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager == null) {}
    while ((paramITTEngine == null) || (!paramITTEngine.getOptionalSoLoadStatus("webAudio")) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAudioIAudioNativeManager.resumeAudioContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwp
 * JD-Core Version:    0.7.0.1
 */