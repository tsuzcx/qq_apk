import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bnow
  extends bnph<bnot, bnot>
{
  public final String a;
  public final WeakReference<bnca> a;
  private boolean a;
  
  public bnow(bnca parambnca, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambnca);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Bitmap a(bnot parambnot, Bitmap paramBitmap)
  {
    try
    {
      parambnot = parambnot.a();
      xvv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambnot);
      if (parambnot == null)
      {
        xvv.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambnot.getWidth();
      float f4 = parambnot.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambnot.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambnot)
    {
      xvv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambnot);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bnot parambnot)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = bnpk.a(parambnot.jdField_a_of_type_Int, parambnot.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bnca)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bnca)localObject).c()))
      {
        localObject = ((bnca)localObject).a();
        if (localObject != null)
        {
          parambnot.jdField_a_of_type_Bnoy.b = ((Bitmap)localObject);
          parambnot.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambnot, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          xvv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = yoy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambnot.jdField_a_of_type_Boolean = bool;
          parambnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambnot.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambnot);
        return;
        label234:
        xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnow
 * JD-Core Version:    0.7.0.1
 */