import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class blgv
  implements blhz
{
  public blgv(AETemplateInfoFragment paramAETemplateInfoFragment, String paramString, Bitmap paramBitmap, long paramLong) {}
  
  public void a(List<blia> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      AETemplateInfoFragment.a(this.jdField_a_of_type_DovComQqImAePlayAETemplateInfoFragment, new ArrayList());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        blia localblia = (blia)paramList.next();
        if (localblia.jdField_a_of_type_Boolean)
        {
          String str = AETemplateInfoFragment.jdField_a_of_type_JavaLangString + System.currentTimeMillis();
          BitmapUtils.saveBitmap(localblia.jdField_a_of_type_AndroidGraphicsBitmap, str);
          AETemplateInfoFragment.a(this.jdField_a_of_type_DovComQqImAePlayAETemplateInfoFragment).add(str);
          BitmapUtils.recycle(localblia.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        else
        {
          AETemplateInfoFragment.a(this.jdField_a_of_type_DovComQqImAePlayAETemplateInfoFragment).add(this.jdField_a_of_type_JavaLangString);
        }
      }
      BitmapUtils.recycle(this.jdField_a_of_type_AndroidGraphicsBitmap);
      AETemplateInfoFragment.a(this.jdField_a_of_type_DovComQqImAePlayAETemplateInfoFragment, true);
    }
    for (;;)
    {
      AETemplateInfoFragment.b(this.jdField_a_of_type_DovComQqImAePlayAETemplateInfoFragment, false);
      return;
      BitmapUtils.recycle(this.jdField_a_of_type_AndroidGraphicsBitmap);
      QLog.e("AETemplateInfoFragment", 1, "changeFace---failed to get face changed bitmaps");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgv
 * JD-Core Version:    0.7.0.1
 */