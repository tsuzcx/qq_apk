import android.util.Log;
import com.tencent.qg.qq.GameDemoFragment;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.QGRenderer.QGEventListener;
import com.tencent.qg.sdk.doraemon.DoraemonApiWrapper;

public class bfxo
  implements QGRenderer.QGEventListener
{
  public bfxo(GameDemoFragment paramGameDemoFragment) {}
  
  public void onCanvasCreated()
  {
    Log.d("ejecta", "Event: Canvas was created");
    this.a.a.init();
    String[] arrayOfString = GameDemoFragment.a(this.a);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      GameDemoFragment.a(this.a).loadJavaScriptFileFromSDCard(str);
      i += 1;
    }
  }
  
  public void onDrawFrame() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxo
 * JD-Core Version:    0.7.0.1
 */