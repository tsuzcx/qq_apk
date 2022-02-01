import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;

public class auoq
{
  public long a;
  private DownloaderTask a;
  public String a;
  public String b;
  public String c;
  public String d = "now_for_qq";
  public String e = "now_appid_2";
  public String f = "now";
  public String g;
  public String h;
  
  public static auoq a(String paramString1, String paramString2, String paramString3)
  {
    auoq localauoq = new auoq();
    localauoq.jdField_a_of_type_JavaLangString = "2";
    localauoq.g = paramString3.substring(0, paramString3.lastIndexOf("/") + 1);
    localauoq.h = paramString3.substring(paramString3.lastIndexOf("/") + 1);
    localauoq.b = paramString1;
    localauoq.c = paramString2;
    localauoq.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.i("NowDownloadTaskInfo", 4, localauoq.toString());
    return localauoq;
  }
  
  public DownloaderTask a()
  {
    return this.jdField_a_of_type_ComTencentHlyybDownloaderDownloaderTask;
  }
  
  public void a(DownloaderTask paramDownloaderTask)
  {
    this.jdField_a_of_type_ComTencentHlyybDownloaderDownloaderTask = paramDownloaderTask;
  }
  
  public String toString()
  {
    return "appid = " + this.jdField_a_of_type_JavaLangString + ", url = " + this.b + ", downloadDir = " + this.g + ", fileName = " + this.h + ", taskSource = " + this.e + ", appName = " + this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auoq
 * JD-Core Version:    0.7.0.1
 */