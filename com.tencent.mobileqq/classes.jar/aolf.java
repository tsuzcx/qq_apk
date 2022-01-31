import android.graphics.Bitmap;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;

class aolf
  implements WXShareHelper.WXShareListener
{
  aolf(aold paramaold, Bitmap paramBitmap) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "[DanceMachine Share]  shareToWechat errorCode : " + paramBaseResp.errCode + "   errorStr : " + paramBaseResp.errCode + "  transaction : " + paramBaseResp.transaction + "  openId : " + paramBaseResp.openId + " type : " + paramBaseResp.getType());
    }
    if ((paramBaseResp.errCode != 0) && (paramBaseResp.errCode != -2)) {
      this.jdField_a_of_type_Aold.a.runOnUiThread(new aolg(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aolf
 * JD-Core Version:    0.7.0.1
 */