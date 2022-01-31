import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class biqx
  implements bizb
{
  biqx(biqw parambiqw, ToServiceMsg paramToServiceMsg) {}
  
  public void a(int paramInt)
  {
    biqw.a(this.jdField_a_of_type_Biqw, null, null);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = biqw.a(this.jdField_a_of_type_Biqw.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        biqw.a(this.jdField_a_of_type_Biqw, null, null);
        return;
      }
      biqw.a(this.jdField_a_of_type_Biqw, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    biqw.a(this.jdField_a_of_type_Biqw, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqx
 * JD-Core Version:    0.7.0.1
 */