import android.util.Log;

public class bicc
{
  public final void a(Exception paramException)
  {
    a("e:", paramException);
  }
  
  public void a(String paramString)
  {
    Log.i("GLDrawable", paramString);
  }
  
  public void a(String paramString, Exception paramException)
  {
    Log.i("GLDrawable", paramString, paramException);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    Log.i("GLDrawable", "event=" + paramString1 + " statusCode=" + paramString2 + " statusMsg=" + paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicc
 * JD-Core Version:    0.7.0.1
 */