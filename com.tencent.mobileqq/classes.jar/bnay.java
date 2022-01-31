import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bnay
  extends bnbp<bnaz, bnaz>
{
  public final String a;
  @NonNull
  public final WeakReference<bmkv> a;
  public final String b;
  
  public bnay(bmkv parambmkv, String paramString1, String paramString2)
  {
    if (parambmkv == null) {
      throw new IllegalArgumentException("atDoodleController is illegal");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmkv);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private boolean a(bnaz parambnaz, String paramString1, String paramString2)
  {
    parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atDoodlePath = paramString1;
    parambnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData = paramString2;
    return true;
  }
  
  protected void a(JobContext paramJobContext, bnaz parambnaz)
  {
    int i = 0;
    int j = 0;
    String str = parambnaz.jdField_a_of_type_JavaLangString;
    if (str == null)
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    bmkv localbmkv = (bmkv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject;
    BitmapFactory.Options localOptions;
    if ((localbmkv != null) && (!localbmkv.a()))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      paramJobContext = (JobContext)localObject;
      if (localObject == null) {
        paramJobContext = bnbs.a(parambnaz.jdField_a_of_type_Int, parambnaz.b, ".png");
      }
      localObject = localbmkv.a();
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
        bdhj.a(str, localOptions);
        localObject = xqw.b((Bitmap)localObject, localOptions.outWidth, localOptions.outHeight, true, false);
        if (localObject == null) {
          break label388;
        }
        bool1 = xqw.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        if ((localObject != null) && (bool1))
        {
          wxe.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and crop original doodle image success");
          i = j;
          if (a(parambnaz, paramJobContext, this.b)) {
            i = 1;
          }
          xqw.a((Bitmap)localObject);
          if (i == 0) {
            break label360;
          }
          super.notifyResult(parambnaz);
          return;
        }
      }
      catch (OutOfMemoryError paramJobContext)
      {
        wxe.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", 6));
        return;
      }
      if (localObject != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        wxe.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and save doodle image failed, resize result=%s, save result=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        bool1 = localbmkv.a(paramJobContext);
        wxe.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "generate original doodle png file : success = " + bool1 + ", path = " + paramJobContext);
        if (!bool1) {
          break label347;
        }
        wxe.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "use the original doodle image instead");
        i = j;
        if (!a(parambnaz, paramJobContext, this.b)) {
          break;
        }
        i = 1;
        break;
      }
      label347:
      wxe.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "copy the original doodle image failed, we'll ignore the doodle then publish");
      i = j;
      continue;
      label360:
      super.notifyError(new ErrorMessage(-1, "DoodleLayout generate image failed"));
      return;
      wxe.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "do not generate at doodle image because at doodle is empty");
      super.notifyResult(parambnaz);
      return;
      label388:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnay
 * JD-Core Version:    0.7.0.1
 */