import android.net.Uri;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.js.OpenJsBridge.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

public class bfjn
  extends atgt
{
  public HashMap<String, atgv> b = new HashMap();
  
  public HashMap<String, atgv> a()
  {
    return this.b;
  }
  
  public void a(atgv paramatgv, String paramString)
  {
    this.b.put(paramString, paramatgv);
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.b.clear();
      return;
    }
    this.b.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, atgu paramatgu)
  {
    long l1 = System.currentTimeMillis();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.i("OpenJsBridge", 4, "[getResult]decode failed: " + (String)paramList.get(i));
            }
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    bflp.b("OpenJsBridge", "[getResult]time4-time3=" + (l2 - l1));
    paramString1 = (atgv)this.b.get(paramString1);
    if (paramString1 != null) {
      paramString1.call(paramString2, paramList, paramatgu);
    }
    while (!(paramatgu instanceof bfjo)) {
      return;
    }
    ((bfjo)paramatgu).b(paramString2);
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if (paramString == null) {}
    Uri localUri;
    do
    {
      return false;
      localUri = Uri.parse(paramString);
    } while ((localUri == null) || (localUri.getScheme() == null) || (!localUri.getScheme().equals("jsbridge")));
    bflp.b("OpenJsBridge", "[canHandleUrl] AsyncInterface_start:" + paramString);
    ThreadManager.executeOnSubThread(new OpenJsBridge.1(this, paramString, paramWebView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfjn
 * JD-Core Version:    0.7.0.1
 */