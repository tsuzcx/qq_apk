import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

public class bmwm
  extends bmxd<bmwn, bmwn>
{
  public final String a;
  @NonNull
  public final WeakReference<bmgj> a;
  public final String b;
  
  public bmwm(bmgj parambmgj, String paramString1, String paramString2)
  {
    if (parambmgj == null) {
      throw new IllegalArgumentException("atDoodleController is illegal");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmgj);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private boolean a(bmwn parambmwn, String paramString1, String paramString2)
  {
    parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atDoodlePath = paramString1;
    parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.atJsonData = paramString2;
    return true;
  }
  
  protected void a(JobContext paramJobContext, bmwn parambmwn)
  {
    int i = 0;
    int j = 0;
    String str = parambmwn.jdField_a_of_type_JavaLangString;
    if (str == null)
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    bmgj localbmgj = (bmgj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject;
    BitmapFactory.Options localOptions;
    if ((localbmgj != null) && (!localbmgj.a()))
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      paramJobContext = (JobContext)localObject;
      if (localObject == null) {
        paramJobContext = bmxg.a(parambmwn.jdField_a_of_type_Int, parambmwn.b, ".png");
      }
      localObject = localbmgj.a();
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
        bdda.a(str, localOptions);
        localObject = xmn.b((Bitmap)localObject, localOptions.outWidth, localOptions.outHeight, true, false);
        if (localObject == null) {
          break label388;
        }
        bool1 = xmn.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
        if ((localObject != null) && (bool1))
        {
          wsv.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and crop original doodle image success");
          i = j;
          if (a(parambmwn, paramJobContext, this.b)) {
            i = 1;
          }
          xmn.a((Bitmap)localObject);
          if (i == 0) {
            break label360;
          }
          super.notifyResult(parambmwn);
          return;
        }
      }
      catch (OutOfMemoryError paramJobContext)
      {
        wsv.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", 6));
        return;
      }
      if (localObject != null) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        wsv.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "resize and save doodle image failed, resize result=%s, save result=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        bool1 = localbmgj.a(paramJobContext);
        wsv.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "generate original doodle png file : success = " + bool1 + ", path = " + paramJobContext);
        if (!bool1) {
          break label347;
        }
        wsv.b("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "use the original doodle image instead");
        i = j;
        if (!a(parambmwn, paramJobContext, this.b)) {
          break;
        }
        i = 1;
        break;
      }
      label347:
      wsv.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "copy the original doodle image failed, we'll ignore the doodle then publish");
      i = j;
      continue;
      label360:
      super.notifyError(new ErrorMessage(-1, "DoodleLayout generate image failed"));
      return;
      wsv.d("Q.qqstory.publish.edit.GenerateAtDoodleImageSegment", "do not generate at doodle image because at doodle is empty");
      super.notifyResult(parambmwn);
      return;
      label388:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwm
 * JD-Core Version:    0.7.0.1
 */