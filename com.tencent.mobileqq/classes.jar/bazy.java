import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bazy
  extends bazx
  implements baug
{
  public baub a;
  private bazz a;
  
  public bazy(QQAppInterface paramQQAppInterface, String paramString, bazz parambazz, baub parambaub)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Baub = parambaub;
    this.jdField_a_of_type_Bazz = parambazz;
  }
  
  public void onResp(bavf parambavf)
  {
    this.jdField_a_of_type_Bazz.onResp(parambavf);
    this.ctrl.a(this);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bazz.onUpdateProgeress(parambave, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    this.app.getNetEngine(0).b(this.jdField_a_of_type_Baub);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.app.getNetEngine(0).a(this.jdField_a_of_type_Baub);
    this.jdField_a_of_type_Baub.jdField_a_of_type_Baug = this;
    this.jdField_a_of_type_Bazz.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_Bazz + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazy
 * JD-Core Version:    0.7.0.1
 */