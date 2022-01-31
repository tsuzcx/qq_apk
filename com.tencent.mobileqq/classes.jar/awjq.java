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

public class awjq
  implements awkh
{
  private String jdField_a_of_type_JavaLangString;
  
  public awjq(PicShareToWX paramPicShareToWX, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "onSend, result.result = " + paramawki.a);
    }
    if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
      ThreadManager.getUIHandler().removeCallbacks(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a.dismiss();
    }
    if (paramawki.a != 0)
    {
      if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
        PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX).callbackResult(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), EIPCResult.createResult(-102, null));
      }
      if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
        QQToast.a(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), 2131720032, 0).a();
      }
      PicShareToWX.a(PicShareToWX.b(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), false);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, false, paramawki.a, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a();
      if ((paramawki.a == 0) && (!PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX)))
      {
        paramawki = paramawki.e;
        Object localObject = new BitmapFactory.Options();
        bdhj.a((BitmapFactory.Options)localObject, this.jdField_a_of_type_JavaLangString, 400);
        localObject = SafeBitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX.a(paramawki, (Bitmap)localObject, PicShareToWX.b(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX));
      }
      return;
      if (PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX) != null) {
        PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX).callbackResult(PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX), EIPCResult.createSuccessResult(null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjq
 * JD-Core Version:    0.7.0.1
 */