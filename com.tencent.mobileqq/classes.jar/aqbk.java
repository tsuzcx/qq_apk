import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class aqbk
  extends auom
{
  aqbk(aqbj paramaqbj, MessageForPic paramMessageForPic) {}
  
  public void a(int paramInt, aunu paramaunu)
  {
    if (this.jdField_a_of_type_Aqbj.jdField_a_of_type_Aqbo != null) {
      this.jdField_a_of_type_Aqbj.jdField_a_of_type_Aqbo.b();
    }
    ayog.d(aywk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 1, null).toString().toString());
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "DownloadBigPic finish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
      aqbc.a(this.jdField_a_of_type_Aqbj.jdField_a_of_type_Aqbc, aehy.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic), this.jdField_a_of_type_Aqbj.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbk
 * JD-Core Version:    0.7.0.1
 */