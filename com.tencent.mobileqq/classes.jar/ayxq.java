import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ayxq
  extends ayxp
  implements aysc
{
  public ayrx a;
  private ayxr a;
  
  public ayxq(QQAppInterface paramQQAppInterface, String paramString, ayxr paramayxr, ayrx paramayrx)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Ayrx = paramayrx;
    this.jdField_a_of_type_Ayxr = paramayxr;
  }
  
  public void onResp(aysz paramaysz)
  {
    this.jdField_a_of_type_Ayxr.onResp(paramaysz);
    this.ctrl.a(this);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Ayxr.onUpdateProgeress(paramaysy, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    this.app.getNetEngine(0).b(this.jdField_a_of_type_Ayrx);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.app.getNetEngine(0).a(this.jdField_a_of_type_Ayrx);
    this.jdField_a_of_type_Ayrx.jdField_a_of_type_Aysc = this;
    this.jdField_a_of_type_Ayxr.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_Ayrx.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_Ayxr + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxq
 * JD-Core Version:    0.7.0.1
 */