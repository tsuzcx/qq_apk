import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class biqg
  implements biyk
{
  biqg(biqf parambiqf, ToServiceMsg paramToServiceMsg) {}
  
  public void a(int paramInt)
  {
    biqf.a(this.jdField_a_of_type_Biqf, null, null);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = biqf.a(this.jdField_a_of_type_Biqf.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        biqf.a(this.jdField_a_of_type_Biqf, null, null);
        return;
      }
      biqf.a(this.jdField_a_of_type_Biqf, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    biqf.a(this.jdField_a_of_type_Biqf, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqg
 * JD-Core Version:    0.7.0.1
 */