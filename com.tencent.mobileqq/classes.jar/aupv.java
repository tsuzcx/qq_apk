import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class aupv
  extends azky
{
  aupv(aupt paramaupt, auqh paramauqh, MessageForPic paramMessageForPic, String paramString) {}
  
  public void a(int paramInt, azkf paramazkf)
  {
    if (this.jdField_a_of_type_Auqh != null) {
      this.jdField_a_of_type_Auqh.b();
    }
    AbsDownloader.getFilePath(URLDrawableHelper.getURL(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 1, null).toString().toString());
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, "DownloadBigPic finish");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
      aupt.a(this.jdField_a_of_type_Aupt, ahsl.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic), this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aupv
 * JD-Core Version:    0.7.0.1
 */