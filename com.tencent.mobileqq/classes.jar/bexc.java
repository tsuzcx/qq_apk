import com.tencent.qqmini.sdk.minigame.webaudio.AudioNativeManager;

public class bexc
{
  private long a = System.currentTimeMillis();
  
  public bexc()
  {
    AudioNativeManager.initAudioContext();
  }
  
  public float a(int paramInt)
  {
    return AudioNativeManager.getCurrentGain(paramInt);
  }
  
  public int a()
  {
    return AudioNativeManager.createBufferSource();
  }
  
  public long a()
  {
    return System.currentTimeMillis() - this.a;
  }
  
  public void a(int paramInt, double paramDouble)
  {
    AudioNativeManager.setCurrentGain(paramInt, (float)paramDouble);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AudioNativeManager.setBufferSourceLoop(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexc
 * JD-Core Version:    0.7.0.1
 */