import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bpeo
  extends bpez<bpel, bpel>
{
  public final String a;
  public final WeakReference<bors> a;
  private boolean a;
  
  public bpeo(bors parambors, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambors);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Bitmap a(bpel parambpel, Bitmap paramBitmap)
  {
    try
    {
      parambpel = parambpel.a();
      ykq.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambpel);
      if (parambpel == null)
      {
        ykq.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambpel.getWidth();
      float f4 = parambpel.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambpel.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambpel)
    {
      ykq.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambpel);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bpel parambpel)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = bpfc.a(parambpel.jdField_a_of_type_Int, parambpel.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bors)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bors)localObject).c()))
      {
        localObject = ((bors)localObject).a();
        if (localObject != null)
        {
          parambpel.jdField_a_of_type_Bpeq.b = ((Bitmap)localObject);
          parambpel.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambpel, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          ykq.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = zdr.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambpel.jdField_a_of_type_Boolean = bool;
          parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambpel.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambpel);
        return;
        label234:
        ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpeo
 * JD-Core Version:    0.7.0.1
 */