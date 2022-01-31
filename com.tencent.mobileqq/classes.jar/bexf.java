import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import com.tencent.qqmini.sdk.minigame.webaudio.AudioNativeManager;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.1;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.2;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.3;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.4;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.5;
import com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class bexf
{
  private static bexf jdField_a_of_type_Bexf;
  private bexc jdField_a_of_type_Bexc = new bexc();
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, bexc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public AtomicInteger a;
  private ArrayList<Integer> b = new ArrayList();
  
  private bexf()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public static bexf a()
  {
    if (jdField_a_of_type_Bexf == null) {
      jdField_a_of_type_Bexf = new bexf();
    }
    return jdField_a_of_type_Bexf;
  }
  
  private void a(beka parambeka, int paramInt)
  {
    parambeka = new WebAudioManager.3(this, paramInt, parambeka);
    AudioHandleThread.getInstance().post(parambeka);
  }
  
  public double a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) != null) {
      return ((bexc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))).a() / 1000.0D;
    }
    return -1.0D;
  }
  
  public float a(int paramInt)
  {
    bexc localbexc = (bexc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return -1.0F;
    }
    return localbexc.a(paramInt);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return AudioNativeManager.copyToChannel(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public JSONObject a(int paramInt)
  {
    Object localObject = (bexc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return null;
    }
    paramInt = ((bexc)localObject).a();
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
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
    AudioNativeManager.bindBufferToSource(paramInt2, paramInt1);
    return new JSONObject();
  }
  
  public JSONObject a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (bexc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return null;
    }
    paramInt1 = AudioNativeManager.createBuffer(paramInt1, paramInt2, paramInt3);
    this.b.add(Integer.valueOf(paramInt1));
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("bufferId", paramInt1);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return localObject;
  }
  
  public JSONObject a(beka parambeka, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    bexc localbexc = (bexc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return null;
    }
    long l2 = localbexc.a();
    long l1 = paramInt3 * 1000 - l2;
    if (l1 > 0L)
    {
      AudioHandleThread.getInstance().postDelayed(new WebAudioManager.1(this, paramInt2, paramInt4, parambeka), l1);
      if (l1 <= 0L) {
        break label151;
      }
    }
    label151:
    for (l1 = paramInt3 * 1000;; l1 = l2)
    {
      if (paramInt5 > 0) {
        AudioHandleThread.getInstance().postDelayed(new WebAudioManager.2(this, paramInt2), l1 - l2 + paramInt5 * 1000);
      }
      return new JSONObject();
      AudioNativeManager.play(paramInt2, paramInt4);
      a(parambeka, paramInt2);
      break;
    }
  }
  
  public JSONObject a(String paramString)
  {
    this.jdField_a_of_type_Bexc = new bexc();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), this.jdField_a_of_type_Bexc);
    paramString = new JSONObject();
    try
    {
      paramString.put("audioId", 1);
      return paramString;
    }
    catch (Throwable localThrowable) {}
    return paramString;
  }
  
  public void a()
  {
    AudioNativeManager.closeAudioContext();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt, double paramDouble)
  {
    bexc localbexc = (bexc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return;
    }
    localbexc.a(paramInt, paramDouble);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
    AudioNativeManager.play(-2, 0.0F);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bexc localbexc = (bexc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return;
    }
    localbexc.a(paramInt, paramBoolean);
  }
  
  @RequiresApi(api=16)
  public void a(int paramInt, byte[] paramArrayOfByte, beka parambeka)
  {
    AudioHandleThread.getInstance().post(new WebAudioManager.5(this, paramArrayOfByte, paramInt, parambeka));
  }
  
  public void a(beka parambeka, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = paramInt1 * paramInt3 * 4;
    AudioNativeManager.createScriptProcessorNode(paramInt1, paramInt2, paramInt3);
    parambeka = new WebAudioManager.6(this, parambeka, paramInt1);
    AudioHandleThread.getInstance().post(parambeka);
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    return AudioNativeManager.getBufferChannelData(paramInt1, paramInt2);
  }
  
  public JSONObject b(int paramInt1, int paramInt2, int paramInt3)
  {
    bexc localbexc = (bexc)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return null;
    }
    long l = localbexc.a();
    l = paramInt3 * 1000 - l;
    if (l > 0L) {
      AudioHandleThread.getInstance().postDelayed(new WebAudioManager.4(this, paramInt2), l);
    }
    for (;;)
    {
      return new JSONObject();
      AudioNativeManager.stopSource(paramInt2);
    }
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexf
 * JD-Core Version:    0.7.0.1
 */