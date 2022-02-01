import com.tencent.mobileqq.webview.webso.WebSoService;

public class bhrv
{
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((bhsg.b(paramString)) && (!bhsg.d(paramString)) && (aqyj.c().b > 0))
    {
      WebSoService.a().a(paramString, null, true);
      bhsg.a("preload spned time = " + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrv
 * JD-Core Version:    0.7.0.1
 */