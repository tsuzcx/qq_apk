import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.huayang.Monitor.1;

public class atbh
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbh
 * JD-Core Version:    0.7.0.1
 */