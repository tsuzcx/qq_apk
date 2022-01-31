import android.text.TextUtils;
import android.util.Log;
import com.tencent.tissue.v8rt.engine.LibLoader;
import java.io.File;

public class bfdv
  implements LibLoader
{
  public boolean loadSo()
  {
    if (beku.a == null)
    {
      Log.i("V8JsLoader", "tissueEnv is null");
      return false;
    }
    Object localObject = beku.a.getNativeLibDir();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      Log.i("V8JsLoader", "libsDir is empty");
      return false;
    }
    try
    {
      System.loadLibrary("v8jni");
      System.loadLibrary("uvjni");
      localObject = new File((String)localObject, "libtv8rt.so");
      if ((!((File)localObject).isFile()) || (!((File)localObject).canRead())) {
        throw new UnsatisfiedLinkError("libtv8rt.so is broken");
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return false;
    }
    System.load(localThrowable.getAbsolutePath());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdv
 * JD-Core Version:    0.7.0.1
 */