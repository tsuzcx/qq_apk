import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

public class amhb
  extends zqh
{
  long jdField_a_of_type_Long;
  amha jdField_a_of_type_Amha;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public amhb(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(amha paramamha)
  {
    this.jdField_a_of_type_Amha = paramamha;
  }
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_Amha.a(-11);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|second step fail:" + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|second step cost:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D + ", isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Amha.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.b);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    bhmi.d(this.jdField_a_of_type_JavaLangString);
    amgx.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, 2);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|second step success!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amhb
 * JD-Core Version:    0.7.0.1
 */