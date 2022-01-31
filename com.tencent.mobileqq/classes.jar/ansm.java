import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.util.BitmapManager;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class ansm
  implements Runnable
{
  public ansm(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.b)))
    {
      QIMEffectCameraCaptureUnit.c(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QIMEffectCameraCaptureUnit.b(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setText(this.jdField_a_of_type_JavaLangString);
      QIMEffectCameraCaptureUnit.b(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setVisibility(0);
    }
    if (!TextUtils.isEmpty(this.b)) {}
    try
    {
      Bitmap localBitmap = BitmapManager.a(this.b);
      QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setImageBitmap(localBitmap);
      QIMEffectCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit).setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ansm
 * JD-Core Version:    0.7.0.1
 */