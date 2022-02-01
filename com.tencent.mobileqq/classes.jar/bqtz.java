import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bqtz
  extends bquq<bqua, bqua>
{
  public final String a;
  @NonNull
  public final WeakReference<bqdw> a;
  public final String b;
  
  public bqtz(bqdw parambqdw, String paramString1, String paramString2)
  {
    if (parambqdw == null) {
      throw new IllegalArgumentException("atDoodleController is illegal");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqdw);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private boolean a(bqua parambqua, String paramString1, String paramString2)
  {
    parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atDoodlePath = paramString1;
    parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData = paramString2;
    return true;
  }
  
  protected void a(JobContext paramJobContext, bqua parambqua)
  {
    int i = 0;
    int j = 0;
    String str = parambqua.jdField_a_of_type_JavaLangString;
    if (str == null)
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    bqdw localbqdw = (bqdw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject;
    BitmapFactory.Options localOptions;
    if ((localbqdw != null) && (!localbqdw.a()))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      paramJobContext = (JobContext)localObject;
      if (localObject == null) {
        paramJobContext = bqut.a(parambqua.jdField_a_of_type_Int, parambqua.b, ".png");
      }
      localObject = localbqdw.a();
      if (localObject != null)
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
      }
    }
    for (;;)
    {
      try
      {
        bhmq.a(str, localOptions);
        localObject = zoc.b((Bitmap)localObject, localOptions.outWidth, localOptions.outHeight, true, false);
        if (localObject == null) {
          break label388;
        }
        bool1 = zoc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        if ((localObject != null) && (bool1))
        {
          yuk.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and crop original doodle image success");
          i = j;
          if (a(parambqua, paramJobContext, this.b)) {
            i = 1;
          }
          zoc.a((Bitmap)localObject);
          if (i == 0) {
            break label360;
          }
          super.notifyResult(parambqua);
          return;
        }
      }
      catch (OutOfMemoryError paramJobContext)
      {
        yuk.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", 6));
        return;
      }
      if (localObject != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        yuk.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and save doodle image failed, resize result=%s, save result=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        bool1 = localbqdw.a(paramJobContext);
        yuk.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "generate original doodle png file : success = " + bool1 + ", path = " + paramJobContext);
        if (!bool1) {
          break label347;
        }
        yuk.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "use the original doodle image instead");
        i = j;
        if (!a(parambqua, paramJobContext, this.b)) {
          break;
        }
        i = 1;
        break;
      }
      label347:
      yuk.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "copy the original doodle image failed, we'll ignore the doodle then publish");
      i = j;
      continue;
      label360:
      super.notifyError(new ErrorMessage(-1, "DoodleLayout generate image failed"));
      return;
      yuk.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "do not generate at doodle image because at doodle is empty");
      super.notifyResult(parambqua);
      return;
      label388:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqtz
 * JD-Core Version:    0.7.0.1
 */