import com.tencent.mobileqq.webview.webso.WebSoService;

public class bgys
{
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((bgzd.b(paramString)) && (!bgzd.d(paramString)) && (aqhy.c().b > 0))
    {
      WebSoService.a().a(paramString, null, true);
      bgzd.a("preload spned time = " + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgys
 * JD-Core Version:    0.7.0.1
 */