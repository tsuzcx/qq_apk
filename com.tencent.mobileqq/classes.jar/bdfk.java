import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;

public class bdfk
  extends bdnm
{
  public void loadBaselib(Context paramContext, bdno parambdno)
  {
    for (;;)
    {
      bdnn localbdnn;
      try
      {
        if (isBaseLibInit())
        {
          if (parambdno != null) {
            parambdno.a(0, "", this.mBaselibContent.a());
          }
          return;
        }
        localbdnn = new bdnn();
        localbdnn.a = bdgo.a(paramContext, "mini/QView.js");
        File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "QLogic.js");
        if ((localFile.exists()) && (localFile.isFile()))
        {
          Log.i("InternalBaselibLoader", "load ServiceJs from " + localFile.getAbsolutePath());
          localbdnn.b = bdgo.a(localFile);
          localbdnn.h = localFile.getAbsolutePath();
          localbdnn.c = bdgo.a(paramContext, "mini/QVConsole.js");
          localbdnn.d = bdgo.a(paramContext, "mini/QRemoteDebug.js");
          localbdnn.e = bdgo.a(paramContext, "mini/QWebview.js");
          localbdnn.f = bdgo.a(paramContext, "mini/QWorker.js");
          setBaselib(localbdnn);
          if (parambdno == null) {
            continue;
          }
          if (!isBaseLibInit()) {
            break label256;
          }
          parambdno.a(0, "", this.mBaselibContent.a());
          continue;
        }
        Log.i("InternalBaselibLoader", "load ServiceJs from assets");
      }
      finally {}
      localbdnn.b = bdgo.a(paramContext, "mini/QLogic.js");
      localbdnn.h = "assets://mini/QLogic.js";
      continue;
      label256:
      parambdno.a(-1, "基础库加载失败", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdfk
 * JD-Core Version:    0.7.0.1
 */