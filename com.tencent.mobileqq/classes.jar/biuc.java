import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class biuc
  extends biuq<bitz, bitz>
{
  public final String a;
  public final WeakReference<bibg> a;
  private boolean a;
  
  public biuc(bibg parambibg, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambibg);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public biuc(bibg parambibg, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambibg);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(bitz parambitz, Bitmap paramBitmap)
  {
    try
    {
      parambitz = parambitz.a();
      urk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambitz);
      if (parambitz == null)
      {
        urk.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambitz.getWidth();
      float f4 = parambitz.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambitz.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambitz)
    {
      urk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambitz);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bitz parambitz)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = biut.a(parambitz.jdField_a_of_type_Int, parambitz.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bibg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bibg)localObject).c()))
      {
        localObject = ((bibg)localObject).a();
        if (localObject != null)
        {
          parambitz.jdField_a_of_type_Biuf.b = ((Bitmap)localObject);
          parambitz.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambitz, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          urk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = vlc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambitz.jdField_a_of_type_Boolean = bool;
          parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambitz.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambitz);
        return;
        label234:
        urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biuc
 * JD-Core Version:    0.7.0.1
 */