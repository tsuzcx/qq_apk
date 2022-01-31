import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class avzn
  implements bhbz
{
  avzn(avzm paramavzm, ToServiceMsg paramToServiceMsg) {}
  
  public void a(int paramInt)
  {
    avzm.a(this.jdField_a_of_type_Avzm, null, null);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = avzm.a(this.jdField_a_of_type_Avzm.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        avzm.a(this.jdField_a_of_type_Avzm, null, null);
        return;
      }
      avzm.a(this.jdField_a_of_type_Avzm, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    avzm.a(this.jdField_a_of_type_Avzm, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzn
 * JD-Core Version:    0.7.0.1
 */