import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class bkzu
  implements blic
{
  bkzu(bkzt parambkzt, ToServiceMsg paramToServiceMsg) {}
  
  public void a(int paramInt)
  {
    bkzt.a(this.jdField_a_of_type_Bkzt, null, null);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = bkzt.a(this.jdField_a_of_type_Bkzt.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        bkzt.a(this.jdField_a_of_type_Bkzt, null, null);
        return;
      }
      bkzt.a(this.jdField_a_of_type_Bkzt, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    bkzt.a(this.jdField_a_of_type_Bkzt, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzu
 * JD-Core Version:    0.7.0.1
 */