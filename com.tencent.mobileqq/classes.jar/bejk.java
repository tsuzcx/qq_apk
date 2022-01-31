import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;

public class bejk
  extends besb
{
  public void loadBaselib(Context paramContext, besd parambesd)
  {
    for (;;)
    {
      besc localbesc;
      try
      {
        if (isBaseLibInit())
        {
          if (parambesd != null) {
            parambesd.a(0, "", this.mBaselibContent.a());
          }
          return;
        }
        localbesc = new besc();
        localbesc.a = bekq.a(paramContext, "mini/QView.js");
        File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QLogic.js");
        if ((localFile.exists()) && (localFile.isFile()))
        {
          Log.i("InternalBaselibLoader", "load ServiceJs from " + localFile.getAbsolutePath());
          localbesc.b = bekq.a(localFile);
          localbesc.h = localFile.getAbsolutePath();
          localbesc.c = bekq.a(paramContext, "mini/QVConsole.js");
          localbesc.d = bekq.a(paramContext, "mini/QRemoteDebug.js");
          localbesc.e = bekq.a(paramContext, "mini/QWebview.js");
          localbesc.f = bekq.a(paramContext, "mini/QWorker.js");
          setBaselib(localbesc);
          if (parambesd == null) {
            continue;
          }
          if (!isBaseLibInit()) {
            break label256;
          }
          parambesd.a(0, "", this.mBaselibContent.a());
          continue;
        }
        Log.i("InternalBaselibLoader", "load ServiceJs from assets");
      }
      finally {}
      localbesc.b = bekq.a(paramContext, "mini/QLogic.js");
      localbesc.h = "assets://mini/QLogic.js";
      continue;
      label256:
      parambesd.a(-1, "基础库加载失败", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejk
 * JD-Core Version:    0.7.0.1
 */