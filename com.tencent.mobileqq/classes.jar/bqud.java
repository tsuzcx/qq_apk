import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bqud
  extends bquq<bqua, bqua>
{
  public final String a;
  public final WeakReference<bqbr> a;
  private boolean a;
  
  public bqud(bqbr parambqbr, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqbr);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public bqud(bqbr parambqbr, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqbr);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Bitmap a(bqua parambqua, Bitmap paramBitmap)
  {
    try
    {
      parambqua = parambqua.a();
      yuk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", parambqua);
      if (parambqua == null)
      {
        yuk.e("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
        return paramBitmap;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap);
      float f1 = paramBitmap.getWidth();
      float f2 = paramBitmap.getHeight();
      float f3 = parambqua.getWidth();
      float f4 = parambqua.getHeight();
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.scale(f1 / f3, f2 / f4);
      parambqua.draw(localCanvas);
      return paramBitmap;
    }
    catch (OutOfMemoryError parambqua)
    {
      yuk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", parambqua);
    }
    return null;
  }
  
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    long l = SystemClock.uptimeMillis();
    paramJobContext = this.jdField_a_of_type_JavaLangString;
    if (paramJobContext == null) {
      paramJobContext = bqut.a(parambqua.jdField_a_of_type_Int, parambqua.b, ".png");
    }
    for (;;)
    {
      Object localObject = (bqbr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject != null) && (!((bqbr)localObject).c()))
      {
        localObject = ((bqbr)localObject).a();
        if (localObject != null)
        {
          parambqua.jdField_a_of_type_Bqug.b = ((Bitmap)localObject);
          parambqua.jdField_a_of_type_Boolean = true;
          Bitmap localBitmap = a(parambqua, (Bitmap)localObject);
          if (localBitmap == null) {
            break label234;
          }
          yuk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(localBitmap)));
          localObject = localBitmap;
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          boolean bool = zoc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
          parambqua.jdField_a_of_type_Boolean = bool;
          parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          if (!bool) {
            yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + paramJobContext + " failed! error code = " + bool);
          }
        }
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + parambqua.jdField_a_of_type_Boolean + " cost " + (SystemClock.uptimeMillis() - l));
        super.notifyResult(parambqua);
        return;
        label234:
        yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqud
 * JD-Core Version:    0.7.0.1
 */