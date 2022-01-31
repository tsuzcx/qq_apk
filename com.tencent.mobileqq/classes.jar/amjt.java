import android.text.TextUtils;
import cooperation.comic.jsp.QQComicJsCallback;
import cooperation.comic.jsp.QQComicJsPlugin;

public class amjt
  implements QQComicJsCallback
{
  public amjt(QQComicJsPlugin paramQQComicJsPlugin) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      QQComicJsPlugin.a(this.a, paramString1, new String[] { paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjt
 * JD-Core Version:    0.7.0.1
 */