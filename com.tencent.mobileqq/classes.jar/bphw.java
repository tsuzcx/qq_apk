import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bphw
  extends bpik
{
  public bphw(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public String a()
  {
    return "InteractPasterLayer";
  }
  
  public void a(@NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, String[] paramArrayOfString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.jdField_a_of_type_Bpim == null)
    {
      this.jdField_a_of_type_Bpim = new bphx(this, paramArrayOfString, paramBitmap, new PointF(zlx.a(this.jdField_a_of_type_AndroidContentContext) / 2, zlx.d(this.jdField_a_of_type_AndroidContentContext) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_Bpim.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
    }
    for (;;)
    {
      this.e = 1;
      super.k();
      return;
      if (!this.jdField_a_of_type_Bpim.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_Bpim.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_Bpim.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_Bpim.u = paramBitmap.getWidth();
      this.jdField_a_of_type_Bpim.v = paramBitmap.getHeight();
      this.jdField_a_of_type_Bpim.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
      this.jdField_a_of_type_Bpim.q = paramFloat1;
      this.jdField_a_of_type_Bpim.r = paramFloat2;
      this.jdField_a_of_type_Bpim.s = paramFloat3;
      this.jdField_a_of_type_Bpim.t = paramFloat4;
      this.jdField_a_of_type_Bpim.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphw
 * JD-Core Version:    0.7.0.1
 */