import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;

public class asym
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
  
  public static asym a(String paramString1, String paramString2, String paramString3)
  {
    asym localasym = new asym();
    localasym.jdField_a_of_type_JavaLangString = "2";
    localasym.g = paramString3.substring(0, paramString3.lastIndexOf("/") + 1);
    localasym.h = paramString3.substring(paramString3.lastIndexOf("/") + 1);
    localasym.b = paramString1;
    localasym.c = paramString2;
    localasym.jdField_a_of_type_Long = System.currentTimeMillis();
    QLog.i("NowDownloadTaskInfo", 4, localasym.toString());
    return localasym;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asym
 * JD-Core Version:    0.7.0.1
 */