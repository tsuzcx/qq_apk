import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;

class aojh
  implements Runnable
{
  aojh(aojg paramaojg, int paramInt) {}
  
  public void run()
  {
    aojg.a(this.jdField_a_of_type_Aojg).setVisibility(0);
    aojg.a(this.jdField_a_of_type_Aojg).setProgress(this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "progress:" + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aojh
 * JD-Core Version:    0.7.0.1
 */