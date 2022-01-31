import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bnbc
  extends bnbp<bnaz, bnaz>
{
  public final String a;
  public final WeakReference<bmiq> a;
  private boolean a;
  
  public bnbc(bmiq parambmiq, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmiq);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public bnbc(bmiq parambmiq, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmiq);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(bnaz parambnaz, Bitmap paramBitmap)
  {
    try
    {
      parambnaz = parambnaz.a();
      wxe.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambnaz);
      if (parambnaz == null)
      {
        wxe.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambnaz.getWidth();
      float f4 = parambnaz.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambnaz.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambnaz)
    {
      wxe.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambnaz);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bnaz parambnaz)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = bnbs.a(parambnaz.jdField_a_of_type_Int, parambnaz.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bmiq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bmiq)localObject).c()))
      {
        localObject = ((bmiq)localObject).a();
        if (localObject != null)
        {
          parambnaz.jdField_a_of_type_Bnbf.b = ((Bitmap)localObject);
          parambnaz.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambnaz, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          wxe.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = xqw.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambnaz.jdField_a_of_type_Boolean = bool;
          parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambnaz.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambnaz);
        return;
        label234:
        wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbc
 * JD-Core Version:    0.7.0.1
 */