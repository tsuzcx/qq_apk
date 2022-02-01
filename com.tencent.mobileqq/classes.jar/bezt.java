import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bezt
  extends bezs
  implements beuq
{
  public beum a;
  private bezu a;
  
  public bezt(QQAppInterface paramQQAppInterface, String paramString, bezu parambezu, beum parambeum)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Beum = parambeum;
    this.jdField_a_of_type_Bezu = parambezu;
  }
  
  public void onResp(bevm parambevm)
  {
    this.jdField_a_of_type_Bezu.onResp(parambevm);
    this.ctrl.a(this);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bezu.onUpdateProgeress(parambevl, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    this.app.getNetEngine(0).b(this.jdField_a_of_type_Beum);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.app.getNetEngine(0).a(this.jdField_a_of_type_Beum);
    this.jdField_a_of_type_Beum.jdField_a_of_type_Beuq = this;
    this.jdField_a_of_type_Bezu.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_Beum.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_Bezu + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezt
 * JD-Core Version:    0.7.0.1
 */