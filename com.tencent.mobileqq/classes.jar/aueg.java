import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aueg
  extends axxg
{
  aueg(auef paramauef, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
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
    auef.a("Qboss_PreDownload_Start", (HashMap)localObject);
    localObject = new axro();
    ((axro)localObject).jdField_a_of_type_Axrt = new aueh(this.app, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
    ((axro)localObject).jdField_a_of_type_JavaLangString = this.c;
    ((axro)localObject).jdField_a_of_type_Int = 0;
    ((axro)localObject).c = this.b;
    ((axss)this.app.getNetEngine(0)).a((axsp)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aueg
 * JD-Core Version:    0.7.0.1
 */