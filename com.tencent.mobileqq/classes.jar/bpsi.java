import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bpsi
  extends bpsv<bpsf, bpsf>
{
  public final String a;
  public final WeakReference<bozw> a;
  private boolean a;
  
  public bpsi(bozw parambozw, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambozw);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public bpsi(bozw parambozw, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambozw);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(bpsf parambpsf, Bitmap paramBitmap)
  {
    try
    {
      parambpsf = parambpsf.a();
      yqp.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambpsf);
      if (parambpsf == null)
      {
        yqp.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambpsf.getWidth();
      float f4 = parambpsf.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambpsf.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambpsf)
    {
      yqp.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambpsf);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bpsf parambpsf)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = bpsy.a(parambpsf.jdField_a_of_type_Int, parambpsf.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bozw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bozw)localObject).c()))
      {
        localObject = ((bozw)localObject).a();
        if (localObject != null)
        {
          parambpsf.jdField_a_of_type_Bpsl.b = ((Bitmap)localObject);
          parambpsf.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambpsf, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          yqp.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = zkh.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambpsf.jdField_a_of_type_Boolean = bool;
          parambpsf.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambpsf.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambpsf);
        return;
        label234:
        yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpsi
 * JD-Core Version:    0.7.0.1
 */