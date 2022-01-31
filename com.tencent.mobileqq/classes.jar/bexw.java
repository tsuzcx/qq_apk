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

public class bexw
{
  private static bexw jdField_a_of_type_Bexw;
  private bext jdField_a_of_type_Bext = new bext();
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, bext> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public AtomicInteger a;
  private ArrayList<Integer> b = new ArrayList();
  
  private bexw()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public static bexw a()
  {
    if (jdField_a_of_type_Bexw == null) {
      jdField_a_of_type_Bexw = new bexw();
    }
    return jdField_a_of_type_Bexw;
  }
  
  private void a(bekr parambekr, int paramInt)
  {
    parambekr = new WebAudioManager.3(this, paramInt, parambekr);
    AudioHandleThread.getInstance().post(parambekr);
  }
  
  public double a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) != null) {
      return ((bext)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))).a() / 1000.0D;
    }
    return -1.0D;
  }
  
  public float a(int paramInt)
  {
    bext localbext = (bext)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return -1.0F;
    }
    return localbext.a(paramInt);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return AudioNativeManager.copyToChannel(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public JSONObject a(int paramInt)
  {
    Object localObject = (bext)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return null;
    }
    paramInt = ((bext)localObject).a();
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
    Object localObject = (bext)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
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
  
  public JSONObject a(bekr parambekr, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    bext localbext = (bext)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return null;
    }
    long l2 = localbext.a();
    long l1 = paramInt3 * 1000 - l2;
    if (l1 > 0L)
    {
      AudioHandleThread.getInstance().postDelayed(new WebAudioManager.1(this, paramInt2, paramInt4, parambekr), l1);
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
      a(parambekr, paramInt2);
      break;
    }
  }
  
  public JSONObject a(String paramString)
  {
    this.jdField_a_of_type_Bext = new bext();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), this.jdField_a_of_type_Bext);
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
    bext localbext = (bext)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return;
    }
    localbext.a(paramInt, paramDouble);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
    AudioNativeManager.play(-2, 0.0F);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bext localbext = (bext)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return;
    }
    localbext.a(paramInt, paramBoolean);
  }
  
  @RequiresApi(api=16)
  public void a(int paramInt, byte[] paramArrayOfByte, bekr parambekr)
  {
    AudioHandleThread.getInstance().post(new WebAudioManager.5(this, paramArrayOfByte, paramInt, parambekr));
  }
  
  public void a(bekr parambekr, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = paramInt1 * paramInt3 * 4;
    AudioNativeManager.createScriptProcessorNode(paramInt1, paramInt2, paramInt3);
    parambekr = new WebAudioManager.6(this, parambekr, paramInt1);
    AudioHandleThread.getInstance().post(parambekr);
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    return AudioNativeManager.getBufferChannelData(paramInt1, paramInt2);
  }
  
  public JSONObject b(int paramInt1, int paramInt2, int paramInt3)
  {
    bext localbext = (bext)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)) == null) {
      return null;
    }
    long l = localbext.a();
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
 * Qualified Name:     bexw
 * JD-Core Version:    0.7.0.1
 */