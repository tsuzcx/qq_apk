import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class bexn
{
  public static final Set<String> a = new HashSet();
  public static final Set<String> b = new HashSet(Arrays.asList(new String[] { "__TT__GLOBAL__", "createAudioInstance", "setAudioState", "getAudioState", "operateAudio", "destroyAudioInstance", "onAudioStateChange", "setInnerAudioOptionQGame", "getAvailableAudioSources", "loadFont", "getTextLineHeight", "getSystemInfo", "getSystemInfoSync" }));
  private static Set<String> c;
  private static Set<String> d;
  
  public static Set<String> a()
  {
    if (c == null)
    {
      c = new HashSet(a);
      Object localObject = bema.a("MiniGame", "MiniGameAPILogWhiteList");
      bexk.a().i("LogFilterUtil", "wns config white list: " + (String)localObject);
      localObject = a((String)localObject);
      if (localObject != null) {
        c.addAll((Collection)localObject);
      }
      localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      if ((localObject != null) && (((MiniAppProxy)localObject).isDebugVersion())) {
        c.add("__jsBridge_all_log__");
      }
    }
    return c;
  }
  
  private static Set<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    HashSet localHashSet;
    String[] arrayOfString;
    do
    {
      do
      {
        return paramString;
        localHashSet = new HashSet();
        arrayOfString = paramString.split(",");
        paramString = localHashSet;
      } while (arrayOfString == null);
      paramString = localHashSet;
    } while (arrayOfString.length <= 0);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localHashSet;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i].trim();
      if (!TextUtils.isEmpty(paramString)) {
        localHashSet.add(paramString);
      }
      i += 1;
    }
  }
  
  public static Set<String> b()
  {
    if (d == null)
    {
      d = new HashSet(b);
      Object localObject = bema.a("MiniGame", "MiniGameAPILogBlackList");
      bexk.a().i("LogFilterUtil", "wns config black list: " + (String)localObject);
      localObject = a((String)localObject);
      if (localObject != null) {
        d.addAll((Collection)localObject);
      }
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexn
 * JD-Core Version:    0.7.0.1
 */