import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class azuz
  extends beat
{
  azuz(azuy paramazuy, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
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
    azuy.a("Qboss_PreDownload_Start", (HashMap)localObject);
    localObject = new bdvs();
    ((bdvs)localObject).jdField_a_of_type_Bdvw = new azva(this.app, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
    ((bdvs)localObject).jdField_a_of_type_JavaLangString = this.c;
    ((bdvs)localObject).jdField_a_of_type_Int = 0;
    ((bdvs)localObject).c = this.b;
    ((bdwv)this.app.getNetEngine(0)).a((bdws)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azuz
 * JD-Core Version:    0.7.0.1
 */