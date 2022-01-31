import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ayxo
  extends ayxn
  implements aysa
{
  public ayrv a;
  private ayxp a;
  
  public ayxo(QQAppInterface paramQQAppInterface, String paramString, ayxp paramayxp, ayrv paramayrv)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Ayrv = paramayrv;
    this.jdField_a_of_type_Ayxp = paramayxp;
  }
  
  public void onResp(aysx paramaysx)
  {
    this.jdField_a_of_type_Ayxp.onResp(paramaysx);
    this.ctrl.a(this);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Ayxp.onUpdateProgeress(paramaysw, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    this.app.getNetEngine(0).b(this.jdField_a_of_type_Ayrv);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.app.getNetEngine(0).a(this.jdField_a_of_type_Ayrv);
    this.jdField_a_of_type_Ayrv.jdField_a_of_type_Aysa = this;
    this.jdField_a_of_type_Ayxp.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_Ayrv.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_Ayxp + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxo
 * JD-Core Version:    0.7.0.1
 */