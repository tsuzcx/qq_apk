import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class beau
  extends beat
  implements bdvw
{
  public bdvs a;
  private beav a;
  
  public beau(QQAppInterface paramQQAppInterface, String paramString, beav parambeav, bdvs parambdvs)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_Bdvs = parambdvs;
    this.jdField_a_of_type_Beav = parambeav;
  }
  
  public void onResp(bdwt parambdwt)
  {
    this.jdField_a_of_type_Beav.onResp(parambdwt);
    this.ctrl.a(this);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Beav.onUpdateProgeress(parambdws, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    this.app.getNetEngine(0).b(this.jdField_a_of_type_Bdvs);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    this.app.getNetEngine(0).a(this.jdField_a_of_type_Bdvs);
    this.jdField_a_of_type_Bdvs.jdField_a_of_type_Bdvw = this;
    this.jdField_a_of_type_Beav.a(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_Bdvs.jdField_a_of_type_JavaLangString + ", " + this.jdField_a_of_type_Beav + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beau
 * JD-Core Version:    0.7.0.1
 */