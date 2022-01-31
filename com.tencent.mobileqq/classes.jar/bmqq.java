import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bmqq
  extends bmre
{
  public bmqq(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public String a()
  {
    return "InteractPasterLayer";
  }
  
  public void a(@NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, String[] paramArrayOfString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.jdField_a_of_type_Bmrg == null)
    {
      this.jdField_a_of_type_Bmrg = new bmqr(this, paramArrayOfString, paramBitmap, new PointF(xsm.a(this.jdField_a_of_type_AndroidContentContext) / 2, xsm.d(this.jdField_a_of_type_AndroidContentContext) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_Bmrg.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
    }
    for (;;)
    {
      this.e = 1;
      super.k();
      return;
      if (!this.jdField_a_of_type_Bmrg.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bmrg.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bmrg.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_Bmrg.u = paramBitmap.getWidth();
      this.jdField_a_of_type_Bmrg.v = paramBitmap.getHeight();
      this.jdField_a_of_type_Bmrg.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
      this.jdField_a_of_type_Bmrg.q = paramFloat1;
      this.jdField_a_of_type_Bmrg.r = paramFloat2;
      this.jdField_a_of_type_Bmrg.s = paramFloat3;
      this.jdField_a_of_type_Bmrg.t = paramFloat4;
      this.jdField_a_of_type_Bmrg.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqq
 * JD-Core Version:    0.7.0.1
 */