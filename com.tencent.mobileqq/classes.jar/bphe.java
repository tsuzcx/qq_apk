import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class bphe
  extends JobSegment<Bitmap, Bitmap>
{
  public final float a;
  public final boolean a;
  
  public bphe(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    paramJobContext = zkh.a(paramBitmap, this.jdField_a_of_type_Float, this.jdField_a_of_type_Boolean);
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("Q.qqstory.publish:ImageAdjustJobSegment", 5));
      return;
    }
    super.notifyResult(paramJobContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphe
 * JD-Core Version:    0.7.0.1
 */