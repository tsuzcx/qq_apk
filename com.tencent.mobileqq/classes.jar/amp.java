import com.immersion.stickersampleapp.HapticManager;

public class amp
  implements Runnable
{
  public amp(HapticManager paramHapticManager) {}
  
  public void run()
  {
    if (HapticManager.a(this.a)) {
      this.a.a();
    }
    HapticManager.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amp
 * JD-Core Version:    0.7.0.1
 */