import android.content.Context;
import com.tencent.mobileqq.mini.tissue.TissueEnvImpl;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.IFlutterProxy;
import io.flutter.view.FlutterMain;

class bkwr
  implements IFlutterProxy
{
  bkwr(bkwo parambkwo) {}
  
  public void initFlutterRuntime(BaseRuntime paramBaseRuntime, Context paramContext)
  {
    try
    {
      FlutterMain.setNativeLibDir(TissueEnvImpl.getNativeLibDirInSubProgress());
      FlutterMain.startInitialization(paramContext.getApplicationContext());
      FlutterMain.ensureInitializationComplete(paramContext.getApplicationContext(), null);
      return;
    }
    catch (IllegalStateException paramBaseRuntime) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwr
 * JD-Core Version:    0.7.0.1
 */