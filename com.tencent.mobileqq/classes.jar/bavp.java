import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bavp
  extends bavo
  implements bapx
{
  public baps a;
  private bavq a;
  
  public bavp(QQAppInterface paramQQAppInterface, String paramString, bavq parambavq, baps parambaps)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Baps = parambaps;
    this.jdField_a_of_type_Bavq = parambavq;
  }
  
  public void onResp(baqw parambaqw)
  {
    this.jdField_a_of_type_Bavq.onResp(parambaqw);
    this.ctrl.a(this);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Bavq.onUpdateProgeress(parambaqv, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    this.app.getNetEngine(0).b(this.jdField_a_of_type_Baps);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.app.getNetEngine(0).a(this.jdField_a_of_type_Baps);
    this.jdField_a_of_type_Baps.jdField_a_of_type_Bapx = this;
    this.jdField_a_of_type_Bavq.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_Baps.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_Bavq + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavp
 * JD-Core Version:    0.7.0.1
 */