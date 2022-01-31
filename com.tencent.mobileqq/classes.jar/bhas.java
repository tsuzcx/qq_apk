import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.AECamera.qudong.AETemplateInfoFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhas
  implements bhbw
{
  public bhas(AETemplateInfoFragment paramAETemplateInfoFragment, String paramString, Bitmap paramBitmap, long paramLong) {}
  
  public void a(List<bhbx> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      AETemplateInfoFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAETemplateInfoFragment, new ArrayList());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bhbx localbhbx = (bhbx)paramList.next();
        if (localbhbx.jdField_a_of_type_Boolean)
        {
          String str = AETemplateInfoFragment.jdField_a_of_type_JavaLangString + System.currentTimeMillis();
          BitmapUtils.saveBitmap(localbhbx.jdField_a_of_type_AndroidGraphicsBitmap, str);
          AETemplateInfoFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAETemplateInfoFragment).add(str);
          BitmapUtils.recycle(localbhbx.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        else
        {
          AETemplateInfoFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAETemplateInfoFragment).add(this.jdField_a_of_type_JavaLangString);
        }
      }
      BitmapUtils.recycle(this.jdField_a_of_type_AndroidGraphicsBitmap);
      AETemplateInfoFragment.a(this.jdField_a_of_type_DovComQqImAECameraQudongAETemplateInfoFragment, true);
    }
    for (;;)
    {
      AETemplateInfoFragment.b(this.jdField_a_of_type_DovComQqImAECameraQudongAETemplateInfoFragment, false);
      return;
      BitmapUtils.recycle(this.jdField_a_of_type_AndroidGraphicsBitmap);
      QLog.e("AETemplateInfoFragment", 1, "changeFace---failed to get face changed bitmaps");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhas
 * JD-Core Version:    0.7.0.1
 */