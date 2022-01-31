import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.qqmini.sdk.minigame.GameRuntime.1.1;

public class beuz
  implements FPSCallback
{
  beuz(beuy parambeuy) {}
  
  public void onFPSChange(float paramFloat)
  {
    beuy.a(this.a).a(paramFloat);
    beuy.a(this.a).post(new GameRuntime.1.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beuz
 * JD-Core Version:    0.7.0.1
 */