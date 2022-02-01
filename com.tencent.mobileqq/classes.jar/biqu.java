import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class biqu
{
  protected static Map<Integer, List<BaseInterface>> a = new HashMap();
  
  public static void a(WebView paramWebView)
  {
    int i;
    try
    {
      i = paramWebView.hashCode();
      paramWebView = (List)a.get(Integer.valueOf(i));
      if (paramWebView == null) {
        return;
      }
      Iterator localIterator = paramWebView.iterator();
      while (localIterator.hasNext()) {
        ((BaseInterface)localIterator.next()).destroy();
      }
      paramWebView.clear();
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
      return;
    }
    a.remove(Integer.valueOf(i));
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    try
    {
      int i = paramWebView.hashCode();
      paramWebView = ((List)a.get(Integer.valueOf(i))).iterator();
      while (paramWebView.hasNext())
      {
        BaseInterface localBaseInterface = (BaseInterface)paramWebView.next();
        if (localBaseInterface != null) {
          localBaseInterface.setCurrentUrl(paramString);
        }
      }
      return;
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
    }
  }
  
  public static void a(List<BaseInterface> paramList, WebView paramWebView, String paramString, avnj paramavnj)
  {
    if (!bite.a(paramString))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseInterface localBaseInterface = (BaseInterface)localIterator.next();
        paramavnj.a(localBaseInterface, localBaseInterface.getInterfaceName());
        biql.a.put(localBaseInterface.getInterfaceName(), localBaseInterface.getClass());
        localBaseInterface.setCurrentUrl(paramString);
      }
    }
    a.put(Integer.valueOf(paramWebView.hashCode()), paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqu
 * JD-Core Version:    0.7.0.1
 */