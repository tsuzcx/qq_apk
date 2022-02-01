import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class banp
  extends bezs
{
  banp(bano parambano, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
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
    bano.a("Qboss_PreDownload_Start", (HashMap)localObject);
    localObject = new beum();
    ((beum)localObject).jdField_a_of_type_Beuq = new banq(this.app, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
    ((beum)localObject).jdField_a_of_type_JavaLangString = this.c;
    ((beum)localObject).jdField_a_of_type_Int = 0;
    ((beum)localObject).c = this.b;
    ((bevo)this.app.getNetEngine(0)).a((bevl)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banp
 * JD-Core Version:    0.7.0.1
 */