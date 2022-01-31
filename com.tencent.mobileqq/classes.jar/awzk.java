import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class awzk
  extends bazx
{
  awzk(awzj paramawzj, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  protected void realCancel()
  {
    QLog.i("QbossPreDownloadManager", 1, "ctrl realCancel");
  }
  
  protected void realStart()
  {
    QLog.i("QbossPreDownloadManager", 1, "downloadRes realStart packagename:" + this.jdField_a_of_type_JavaLangString + ",path" + this.b);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("Qboss_PreDownload_PackageName", this.jdField_a_of_type_JavaLangString);
    awzj.a("Qboss_PreDownload_Start", (HashMap)localObject);
    localObject = new baub();
    ((baub)localObject).jdField_a_of_type_Baug = new awzl(this.app, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
    ((baub)localObject).jdField_a_of_type_JavaLangString = this.c;
    ((baub)localObject).jdField_a_of_type_Int = 0;
    ((baub)localObject).c = this.b;
    ((bavh)this.app.getNetEngine(0)).a((bave)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awzk
 * JD-Core Version:    0.7.0.1
 */