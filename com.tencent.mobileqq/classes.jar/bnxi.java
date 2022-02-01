import android.app.Activity;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.play.EditTextViewer;
import dov.com.qq.im.ae.play.EditTextViewer.4.1;

public class bnxi
  extends bnoz
{
  public bnxi(EditTextViewer paramEditTextViewer, AppInterface paramAppInterface, String paramString) {}
  
  protected void a(boolean paramBoolean, GetFontDataRsp paramGetFontDataRsp)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (paramGetFontDataRsp != null)
      {
        if (paramGetFontDataRsp.Code != 0) {
          break label74;
        }
        EditTextViewer.a(this.jdField_a_of_type_DovComQqImAePlayEditTextViewer, this.jdField_a_of_type_JavaLangString);
        bool1 = true;
        EditTextViewer.a(this.jdField_a_of_type_DovComQqImAePlayEditTextViewer, paramGetFontDataRsp);
      }
    }
    for (;;)
    {
      EditTextViewer.a(this.jdField_a_of_type_DovComQqImAePlayEditTextViewer).runOnUiThread(new EditTextViewer.4.1(this, bool1));
      return;
      label74:
      if (paramGetFontDataRsp.Code == -10002)
      {
        EditTextViewer.a(this.jdField_a_of_type_DovComQqImAePlayEditTextViewer, 2131689756);
        bool1 = bool2;
      }
      else
      {
        EditTextViewer.a(this.jdField_a_of_type_DovComQqImAePlayEditTextViewer, 2131689758);
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxi
 * JD-Core Version:    0.7.0.1
 */