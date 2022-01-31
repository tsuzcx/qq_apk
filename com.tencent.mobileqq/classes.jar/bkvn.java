import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class bkvn
  implements bldv
{
  bkvn(bkvm parambkvm, ToServiceMsg paramToServiceMsg) {}
  
  public void a(int paramInt)
  {
    bkvm.a(this.jdField_a_of_type_Bkvm, null, null);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = bkvm.a(this.jdField_a_of_type_Bkvm.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        bkvm.a(this.jdField_a_of_type_Bkvm, null, null);
        return;
      }
      bkvm.a(this.jdField_a_of_type_Bkvm, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    bkvm.a(this.jdField_a_of_type_Bkvm, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvn
 * JD-Core Version:    0.7.0.1
 */