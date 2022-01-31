import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bkkp
  extends bklc<bkkm, bkkm>
{
  public final String a;
  public final WeakReference<bjsd> a;
  private boolean a;
  
  public bkkp(bjsd parambjsd, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjsd);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public bkkp(bjsd parambjsd, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjsd);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(bkkm parambkkm, Bitmap paramBitmap)
  {
    try
    {
      parambkkm = parambkkm.a();
      veg.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambkkm);
      if (parambkkm == null)
      {
        veg.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambkkm.getWidth();
      float f4 = parambkkm.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambkkm.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambkkm)
    {
      veg.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambkkm);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bkkm parambkkm)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = bklf.a(parambkkm.jdField_a_of_type_Int, parambkkm.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bjsd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bjsd)localObject).c()))
      {
        localObject = ((bjsd)localObject).a();
        if (localObject != null)
        {
          parambkkm.jdField_a_of_type_Bkks.b = ((Bitmap)localObject);
          parambkkm.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambkkm, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          veg.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = vxy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambkkm.jdField_a_of_type_Boolean = bool;
          parambkkm.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambkkm.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambkkm);
        return;
        label234:
        veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkp
 * JD-Core Version:    0.7.0.1
 */