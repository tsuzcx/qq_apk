import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class azkj
  implements azla
{
  private String jdField_a_of_type_JavaLangString;
  
  public azkj(PicShareToWX paramPicShareToWX, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "onSend, result.result = " + paramazlb.a);
    }
    if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
      ThreadManager.getUIHandler().removeCallbacks(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a.dismiss();
    }
    if (paramazlb.a != 0)
    {
      if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
        PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX).callbackResult(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), EIPCResult.createResult(-102, null));
      }
      if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
        QQToast.a(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), 2131718767, 0).a();
      }
      PicShareToWX.a(PicShareToWX.b(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), false);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, false, paramazlb.a, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a();
      if ((paramazlb.a == 0) && (!PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX)))
      {
        paramazlb = paramazlb.e;
        Object localObject = new BitmapFactory.Options();
        bheg.a((BitmapFactory.Options)localObject, this.jdField_a_of_type_JavaLangString, 400);
        localObject = SafeBitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a(paramazlb, (Bitmap)localObject, PicShareToWX.b(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX));
      }
      return;
      if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
        PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX).callbackResult(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), EIPCResult.createSuccessResult(null));
      }
    }
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkj
 * JD-Core Version:    0.7.0.1
 */