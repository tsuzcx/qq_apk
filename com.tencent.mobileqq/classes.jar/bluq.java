import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import dov.com.qq.im.ae.play.FaceChangeUtils.CropFaceCallback;

class bluq
  implements FaceChangeUtils.CropFaceCallback
{
  bluq(blup paramblup, ToServiceMsg paramToServiceMsg) {}
  
  public void onFail(int paramInt)
  {
    blup.a(this.jdField_a_of_type_Blup, null, null);
  }
  
  public void onSuccess(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = blup.a(this.jdField_a_of_type_Blup.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        blup.a(this.jdField_a_of_type_Blup, null, null);
        return;
      }
      blup.a(this.jdField_a_of_type_Blup, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    blup.a(this.jdField_a_of_type_Blup, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluq
 * JD-Core Version:    0.7.0.1
 */