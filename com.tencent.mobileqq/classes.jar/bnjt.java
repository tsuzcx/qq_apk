import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import dov.com.qq.im.ae.play.FaceChangeUtils.CropFaceCallback;

class bnjt
  implements FaceChangeUtils.CropFaceCallback
{
  bnjt(bnjs parambnjs, ToServiceMsg paramToServiceMsg) {}
  
  public void onFail(int paramInt)
  {
    bnjs.a(this.jdField_a_of_type_Bnjs, null, null);
  }
  
  public void onSuccess(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = bnjs.a(this.jdField_a_of_type_Bnjs.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        bnjs.a(this.jdField_a_of_type_Bnjs, null, null);
        return;
      }
      bnjs.a(this.jdField_a_of_type_Bnjs, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    bnjs.a(this.jdField_a_of_type_Bnjs, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjt
 * JD-Core Version:    0.7.0.1
 */