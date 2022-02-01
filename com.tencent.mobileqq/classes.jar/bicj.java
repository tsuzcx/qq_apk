import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import java.io.File;

public class bicj
{
  public static final int a = ListenChangeVoicePanel.a.length;
  
  public static String a(String paramString)
  {
    String str = paramString.substring(0, paramString.lastIndexOf(".")).concat(".pcm");
    new File(paramString).renameTo(new File(str));
    return str;
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(".");
    return paramString.substring(0, i).concat("_" + paramInt).concat(paramString.substring(i, paramString.length()));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    while (i < a)
    {
      new File(a(paramString1, i)).delete();
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = null;
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    paramString2 = str;
    if (i < a)
    {
      str = a(paramString1, i);
      if (i == paramInt) {
        paramString2 = str;
      }
      for (;;)
      {
        i += 1;
        break;
        new File(str).delete();
      }
    }
    if (paramString2 != null) {
      new File(paramString2).renameTo(new File(paramString1));
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    new File(paramString1).deleteOnExit();
    new File(paramString2).deleteOnExit();
    int i = 0;
    while (i < a)
    {
      new File(a(paramString1, i)).deleteOnExit();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicj
 * JD-Core Version:    0.7.0.1
 */