import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;

class boqj
  implements boyz
{
  boqj(boqi paramboqi, ToServiceMsg paramToServiceMsg) {}
  
  public void a(int paramInt)
  {
    boqi.a(this.jdField_a_of_type_Boqi, null, null);
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      paramBitmap = boqi.a(this.jdField_a_of_type_Boqi.mApp.getApp(), paramBitmap);
      if ((paramBitmap == null) || (paramBitmap.length() < 1))
      {
        boqi.a(this.jdField_a_of_type_Boqi, null, null);
        return;
      }
      boqi.a(this.jdField_a_of_type_Boqi, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, paramBitmap);
      return;
    }
    boqi.a(this.jdField_a_of_type_Boqi, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqj
 * JD-Core Version:    0.7.0.1
 */