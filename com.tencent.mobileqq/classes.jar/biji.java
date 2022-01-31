import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class biji
  extends bijw
{
  public biji(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public String a()
  {
    return "InteractPasterLayer";
  }
  
  public void a(@NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, String[] paramArrayOfString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.jdField_a_of_type_Bijy == null)
    {
      this.jdField_a_of_type_Bijy = new bijj(this, paramArrayOfString, paramBitmap, new PointF(vms.a(this.jdField_a_of_type_AndroidContentContext) / 2, vms.d(this.jdField_a_of_type_AndroidContentContext) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_Bijy.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
    }
    for (;;)
    {
      this.e = 1;
      super.k();
      return;
      if (!this.jdField_a_of_type_Bijy.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bijy.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bijy.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_Bijy.u = paramBitmap.getWidth();
      this.jdField_a_of_type_Bijy.v = paramBitmap.getHeight();
      this.jdField_a_of_type_Bijy.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
      this.jdField_a_of_type_Bijy.q = paramFloat1;
      this.jdField_a_of_type_Bijy.r = paramFloat2;
      this.jdField_a_of_type_Bijy.s = paramFloat3;
      this.jdField_a_of_type_Bijy.t = paramFloat4;
      this.jdField_a_of_type_Bijy.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biji
 * JD-Core Version:    0.7.0.1
 */