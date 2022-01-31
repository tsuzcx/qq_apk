import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;

public class bekb
  extends bess
{
  public void loadBaselib(Context paramContext, besu parambesu)
  {
    for (;;)
    {
      best localbest;
      try
      {
        if (isBaseLibInit())
        {
          if (parambesu != null) {
            parambesu.a(0, "", this.mBaselibContent.a());
          }
          return;
        }
        localbest = new best();
        localbest.a = belh.a(paramContext, "mini/QView.js");
        File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QLogic.js");
        if ((localFile.exists()) && (localFile.isFile()))
        {
          Log.i("InternalBaselibLoader", "load ServiceJs from " + localFile.getAbsolutePath());
          localbest.b = belh.a(localFile);
          localbest.h = localFile.getAbsolutePath();
          localbest.c = belh.a(paramContext, "mini/QVConsole.js");
          localbest.d = belh.a(paramContext, "mini/QRemoteDebug.js");
          localbest.e = belh.a(paramContext, "mini/QWebview.js");
          localbest.f = belh.a(paramContext, "mini/QWorker.js");
          setBaselib(localbest);
          if (parambesu == null) {
            continue;
          }
          if (!isBaseLibInit()) {
            break label256;
          }
          parambesu.a(0, "", this.mBaselibContent.a());
          continue;
        }
        Log.i("InternalBaselibLoader", "load ServiceJs from assets");
      }
      finally {}
      localbest.b = belh.a(paramContext, "mini/QLogic.js");
      localbest.h = "assets://mini/QLogic.js";
      continue;
      label256:
      parambesu.a(-1, "基础库加载失败", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekb
 * JD-Core Version:    0.7.0.1
 */