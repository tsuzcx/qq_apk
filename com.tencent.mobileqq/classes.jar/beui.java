import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.qqmini.sdk.minigame.GameRuntime.1.1;

public class beui
  implements FPSCallback
{
  beui(beuh parambeuh) {}
  
  public void onFPSChange(float paramFloat)
  {
    beuh.a(this.a).a(paramFloat);
    beuh.a(this.a).post(new GameRuntime.1.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beui
 * JD-Core Version:    0.7.0.1
 */