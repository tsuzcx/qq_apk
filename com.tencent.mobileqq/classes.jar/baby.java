import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;

public class baby
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
  
  public static baby a(String paramString1, String paramString2, String paramString3)
  {
    baby localbaby = new baby();
    localbaby.jdField_a_of_type_JavaLangString = "2";
    localbaby.g = paramString3.substring(0, paramString3.lastIndexOf("/") + 1);
    localbaby.h = paramString3.substring(paramString3.lastIndexOf("/") + 1);
    localbaby.b = paramString1;
    localbaby.c = paramString2;
    localbaby.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.i("NowDownloadTaskInfo", 4, localbaby.toString());
    return localbaby;
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
 * Qualified Name:     baby
 * JD-Core Version:    0.7.0.1
 */