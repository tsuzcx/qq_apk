import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bmwq
  extends bmxd<bmwn, bmwn>
{
  public final String a;
  public final WeakReference<bmee> a;
  private boolean a;
  
  public bmwq(bmee parambmee, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmee);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public bmwq(bmee parambmee, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmee);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(bmwn parambmwn, Bitmap paramBitmap)
  {
    try
    {
      parambmwn = parambmwn.a();
      wsv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambmwn);
      if (parambmwn == null)
      {
        wsv.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambmwn.getWidth();
      float f4 = parambmwn.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambmwn.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambmwn)
    {
      wsv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambmwn);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bmwn parambmwn)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = bmxg.a(parambmwn.jdField_a_of_type_Int, parambmwn.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bmee)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bmee)localObject).c()))
      {
        localObject = ((bmee)localObject).a();
        if (localObject != null)
        {
          parambmwn.jdField_a_of_type_Bmwt.b = ((Bitmap)localObject);
          parambmwn.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambmwn, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          wsv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = xmn.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambmwn.jdField_a_of_type_Boolean = bool;
          parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambmwn.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambmwn);
        return;
        label234:
        wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwq
 * JD-Core Version:    0.7.0.1
 */