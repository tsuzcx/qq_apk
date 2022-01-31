import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.qqmini.sdk.minigame.GameRuntime.1.1;

public class bgtk
  implements FPSCallback
{
  bgtk(bgtj parambgtj) {}
  
  public void onFPSChange(float paramFloat)
  {
    bgtj.a(this.a).a(paramFloat);
    bgtj.a(this.a).post(new GameRuntime.1.1(this, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtk
 * JD-Core Version:    0.7.0.1
 */