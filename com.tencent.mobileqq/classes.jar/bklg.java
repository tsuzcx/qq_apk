import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bklg
  extends bklt<bkld, bkld>
{
  public final String a;
  public final WeakReference<bjsu> a;
  private boolean a;
  
  public bklg(bjsu parambjsu, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjsu);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public bklg(bjsu parambjsu, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjsu);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(bkld parambkld, Bitmap paramBitmap)
  {
    try
    {
      parambkld = parambkld.a();
      ved.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambkld);
      if (parambkld == null)
      {
        ved.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambkld.getWidth();
      float f4 = parambkld.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambkld.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambkld)
    {
      ved.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambkld);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bjsu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bjsu)localObject).c()))
      {
        localObject = ((bjsu)localObject).a();
        if (localObject != null)
        {
          parambkld.jdField_a_of_type_Bklj.b = ((Bitmap)localObject);
          parambkld.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambkld, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          ved.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = vxv.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambkld.jdField_a_of_type_Boolean = bool;
          parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambkld.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambkld);
        return;
        label234:
        ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bklg
 * JD-Core Version:    0.7.0.1
 */