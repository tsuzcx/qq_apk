import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

class aoaq
  implements Runnable
{
  aoaq(aoap paramaoap, int paramInt) {}
  
  public void run()
  {
    aoap.a(this.jdField_a_of_type_Aoap).setVisibility(0);
    aoap.a(this.jdField_a_of_type_Aoap).setProgress(this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "progress:" + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoaq
 * JD-Core Version:    0.7.0.1
 */