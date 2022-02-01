import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class bnoy
  implements bnxp
{
  bnoy(bnox parambnox, ToServiceMsg paramToServiceMsg) {}
  
  public void a(int paramInt)
  {
    bnox.a(this.jdField_a_of_type_Bnox, null, null);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = bnox.a(this.jdField_a_of_type_Bnox.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        bnox.a(this.jdField_a_of_type_Bnox, null, null);
        return;
      }
      bnox.a(this.jdField_a_of_type_Bnox, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    bnox.a(this.jdField_a_of_type_Bnox, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoy
 * JD-Core Version:    0.7.0.1
 */