import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.qqmini.sdk.minigame.GameRuntime.1.1;

public class bgxr
  implements FPSCallback
{
  bgxr(bgxq parambgxq) {}
  
  public void onFPSChange(float paramFloat)
  {
    bgxq.a(this.a).a(paramFloat);
    bgxq.a(this.a).post(new GameRuntime.1.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxr
 * JD-Core Version:    0.7.0.1
 */