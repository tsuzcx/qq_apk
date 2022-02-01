import com.tencent.qphone.base.util.QLog;
import kotlin.Pair;

public class bhbm
  extends bhbs
{
  public void a(String paramString)
  {
    QLog.i("GLDrawable", 1, paramString);
  }
  
  public void a(String paramString, Exception paramException)
  {
    QLog.e("GLDrawable", 1, paramString, paramException);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    bhak.a(paramString1, paramLong, new Pair[] { new Pair("status_code", paramString2), new Pair("status_msg", paramString3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbm
 * JD-Core Version:    0.7.0.1
 */