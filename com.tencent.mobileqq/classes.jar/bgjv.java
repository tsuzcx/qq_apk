import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;
import java.io.File;

public class bgjv
  extends BaselibLoader
{
  public void loadBaselib(Context paramContext, BaselibLoader.OnLoadBaselibListener paramOnLoadBaselibListener)
  {
    for (;;)
    {
      BaselibLoader.BaselibContent localBaselibContent;
      try
      {
        if (isBaseLibInit())
        {
          if (paramOnLoadBaselibListener != null) {
            paramOnLoadBaselibListener.onResult(0, "", this.mBaselibContent.clone());
          }
          return;
        }
        localBaselibContent = new BaselibLoader.BaselibContent();
        localBaselibContent.waWebviewJsStr = bgkv.a(paramContext, "mini/QView.js");
        File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QLogic.js");
        if ((localFile.exists()) && (localFile.isFile()))
        {
          Log.i("InternalBaselibLoader", "load ServiceJs from " + localFile.getAbsolutePath());
          localBaselibContent.waServiceJsStr = bgkv.a(localFile);
          localBaselibContent.waServicePath = localFile.getAbsolutePath();
          localBaselibContent.waConsoleJsStr = bgkv.a(paramContext, "mini/QVConsole.js");
          localBaselibContent.waRemoteDebugStr = bgkv.a(paramContext, "mini/QRemoteDebug.js");
          localBaselibContent.miniappWebviewStr = bgkv.a(paramContext, "mini/QWebview.js");
          localBaselibContent.waWorkerStr = bgkv.a(paramContext, "mini/QWorker.js");
          setBaselib(localBaselibContent);
          if (paramOnLoadBaselibListener == null) {
            continue;
          }
          if (!isBaseLibInit()) {
            break label256;
          }
          paramOnLoadBaselibListener.onResult(0, "", this.mBaselibContent.clone());
          continue;
        }
        Log.i("InternalBaselibLoader", "load ServiceJs from assets");
      }
      finally {}
      localBaselibContent.waServiceJsStr = bgkv.a(paramContext, "mini/QLogic.js");
      localBaselibContent.waServicePath = "assets://mini/QLogic.js";
      continue;
      label256:
      paramOnLoadBaselibListener.onResult(-1, "基础库加载失败", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgjv
 * JD-Core Version:    0.7.0.1
 */