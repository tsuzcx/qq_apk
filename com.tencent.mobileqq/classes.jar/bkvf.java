import cooperation.qqreader.utils.QRDebugEnvUrlUtils;
import java.util.HashMap;
import java.util.Map;

public final class bkvf
{
  private static Map<String, String> a = new HashMap();
  
  static
  {
    a.put("qqreaderMan", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?isV2=1");
    a.put("qqreaderWoman", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?isV2=1");
    a.put("qqreaderPublish", "https://cdn.vip.qq.com/club/client/read/6/rel/index.html?isV2=1");
    a.put("qqreaderBookShelfIndex", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_index.html");
    a.put("qqreaderBookShelfBookList", "https://cdn.vip.qq.com/club/client/read/6/rel/man.html");
    a.put("qqreaderBookShelfFm", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_fm.html");
    a.put("qqreaderBookShelfFollow", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_follow.html");
    a.put("qqreaderBookShelfDelete", "https://cdn.vip.qq.com/club/client/read/6/rel/bookShelf_delete.html");
    a.put("qqreaderTribe", "https://cdn.vip.qq.com/club/client/read/6/rel/tribe.html");
    a.put("qqreaderSearchResult", "https://cdn.vip.qq.com/club/client/read/6/rel/new_search.html");
    a.put("qqreaderAccount", "https://cdn.vip.qq.com/club/client/read/6/rel/mine_index.html");
    a.put("qqreaderAppdown", "https://cdn.vip.qq.com/club/client/read/6/rel/appdown.html");
    a.put("qqreaderInteract", "https://cdn.vip.qq.com/club/client/read/6/rel/interact.html");
    a.put("qqreaderComment", "https://cdn.vip.qq.com/club/client/read/6/rel/comment.html");
    a.put("qqreaderReadover", "https://cdn.vip.qq.com/club/client/read/6/rel/readover.html");
    a.put("qqreaderBookFont", "https://cdn.vip.qq.com/club/client/read/6/rel/bookFont.html");
    a.put("qqreaderBookDetails", "https://cdn.vip.qq.com/club/client/read/6/rel/bookDetails.html");
    a.put("qqreaderOffShelf", "https://cdn.vip.qq.com/club/client/read/6/rel/book_offShelf.html");
    a.put("qqreaderBookOutDetail", "https://cdn.vip.qq.com/club/client/read/6/rel/book_outDetail.html");
    a.put("qqreaderQQMoreState", "https://cdn.vip.qq.com/club/client/read/6/rel/userstate.html");
  }
  
  public static String a(String paramString)
  {
    return a(paramString, true);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = d(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "https://cdn.vip.qq.com/club/client/read/6/rel/index.html";
      }
      localObject = new StringBuilder().append(paramString);
      if (!paramString.contains("?")) {
        break label170;
      }
    }
    label170:
    for (paramString = "&";; paramString = "?")
    {
      paramString = paramString;
      localObject = paramString + "_bid=2036&refer=qqreader";
      paramString = (String)localObject;
      if (!((String)localObject).contains("&ChannelID=")) {
        paramString = (String)localObject + "&ChannelID=" + bkvi.a();
      }
      localObject = paramString;
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        localObject = QRDebugEnvUrlUtils.getTestUrl(paramString);
      }
      bkvd.e("ReaderUrlHelper", "getUrlWithBid = " + (String)localObject);
      return localObject;
      paramString = "https://cdn.vip.qq.com/club/client/read/6/rel/" + paramString;
      break;
    }
  }
  
  public static String b(String paramString)
  {
    String str;
    if (paramString == null) {
      str = a("index.html", false);
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (paramString.toLowerCase().startsWith("http://"));
      str = paramString;
    } while (paramString.toLowerCase().startsWith("file://"));
    return c(paramString);
  }
  
  public static String c(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        String str = paramString;
        if (QRDebugEnvUrlUtils.isDebugEnv()) {
          str = QRDebugEnvUrlUtils.getTestUrl(paramString);
        }
        return str;
      }
    }
    for (paramString = a(paramString, false);; paramString = a("index.html", false)) {
      return paramString;
    }
  }
  
  private static String d(String paramString)
  {
    String str2 = null;
    String str1;
    if ((bktu.a != null) && (bktu.a.size() > 0)) {
      str1 = (String)bktu.a.get(paramString);
    }
    for (;;)
    {
      bkvd.d("ReaderUrlHelper", "getUrl = " + str1);
      return str1;
      if (bktu.a != null) {
        str2 = (String)bktu.a.get(paramString);
      }
      str1 = str2;
      if (str2 == null) {
        str1 = (String)a.get(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvf
 * JD-Core Version:    0.7.0.1
 */