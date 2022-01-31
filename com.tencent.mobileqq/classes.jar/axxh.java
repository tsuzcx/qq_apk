import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class axxh
  extends axxg
  implements axrt
{
  public axro a;
  private axxi a;
  
  public axxh(QQAppInterface paramQQAppInterface, String paramString, axxi paramaxxi, axro paramaxro)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Axro = paramaxro;
    this.jdField_a_of_type_Axxi = paramaxxi;
  }
  
  public void onResp(axsq paramaxsq)
  {
    this.jdField_a_of_type_Axxi.onResp(paramaxsq);
    this.ctrl.a(this);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Axxi.onUpdateProgeress(paramaxsp, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    this.app.getNetEngine(0).b(this.jdField_a_of_type_Axro);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.app.getNetEngine(0).a(this.jdField_a_of_type_Axro);
    this.jdField_a_of_type_Axro.jdField_a_of_type_Axrt = this;
    this.jdField_a_of_type_Axxi.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_Axro.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_Axxi + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxh
 * JD-Core Version:    0.7.0.1
 */