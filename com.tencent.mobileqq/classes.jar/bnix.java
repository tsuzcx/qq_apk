import android.graphics.Bitmap;
import android.os.Bundle;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

public class bnix
  implements EIPCResultCallback
{
  public bnix(AECMShowRequestController paramAECMShowRequestController, Bitmap paramBitmap) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int k = 736;
    int j = k;
    if (paramEIPCResult.isSuccess())
    {
      j = k;
      if (paramEIPCResult.data != null)
      {
        paramEIPCResult = (HashMap)paramEIPCResult.data.getSerializable("key_request_image_param");
        j = k;
        if (paramEIPCResult != null)
        {
          i = k;
          if (paramEIPCResult.containsKey("KEY_CMSHOW_IMG_MAX_LENGTH"))
          {
            i = k;
            if (((Integer)paramEIPCResult.get("KEY_CMSHOW_IMG_MAX_LENGTH")).intValue() > 0) {
              i = ((Integer)paramEIPCResult.get("KEY_CMSHOW_IMG_MAX_LENGTH")).intValue();
            }
          }
          j = i;
          if (paramEIPCResult.containsKey("KEY_CMSHOW_IMG_QUALITY"))
          {
            j = i;
            if (((Integer)paramEIPCResult.get("KEY_CMSHOW_IMG_QUALITY")).intValue() > 0)
            {
              k = ((Integer)paramEIPCResult.get("KEY_CMSHOW_IMG_QUALITY")).intValue();
              j = i;
            }
          }
        }
      }
    }
    for (int i = k;; i = 90)
    {
      AECMShowRequestController.a(this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController, this.jdField_a_of_type_AndroidGraphicsBitmap, j, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnix
 * JD-Core Version:    0.7.0.1
 */