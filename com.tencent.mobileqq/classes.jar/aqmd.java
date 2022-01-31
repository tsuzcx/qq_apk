import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.huayang.Monitor.1;

public class aqmd
{
  public static boolean a = true;
  
  public static void a(String paramString)
  {
    if (a) {
      b(paramString);
    }
  }
  
  public static void b(String paramString)
  {
    ThreadManager.executeOnNetWorkThread(new Monitor.1("https://cgi.pub.qq.com/report/report_vm?monitors=[$ID$]&t=$TIMESTAMP$".replace("$ID$", paramString).replace("$TIMESTAMP$", String.valueOf(System.currentTimeMillis()))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmd
 * JD-Core Version:    0.7.0.1
 */