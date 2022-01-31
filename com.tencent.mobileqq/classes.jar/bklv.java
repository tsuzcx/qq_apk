import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import java.io.File;
import java.io.IOException;

public class bklv
  extends bklt<bkld, bkld>
{
  private final String a;
  
  public bklv()
  {
    this(null);
  }
  
  public bklv(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, bkld parambkld)
  {
    paramJobContext = null;
    int i = 0;
    Object localObject3 = parambkld.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bklw.a(parambkld.jdField_a_of_type_Int, parambkld.b, ".jpg");
    }
    String str3 = parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath;
    String str2 = parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath;
    String str4 = parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_image_path", null);
    String str1 = parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("pl_pic", null);
    if ((str3 != null) || (str2 != null) || (str4 != null))
    {
      try
      {
        localObject3 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject3 != null) {
          break label213;
        }
        super.notifyError(new ErrorMessage(-1, ajya.a(2131706564)));
        return;
      }
      catch (OutOfMemoryError paramJobContext)
      {
        ved.e("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed : " + paramJobContext);
      }
      if (i == 0) {
        break label715;
      }
      vyf.a(new File(parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_JavaLangString));
      super.notifyResult(parambkld);
      return;
      label213:
      localObject1 = paramJobContext;
      if (str4 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = vxv.a(str4);
        paramJobContext = (JobContext)localObject1;
        if (localObject1 != null)
        {
          paramJobContext = (JobContext)localObject1;
          if (str3 != null) {
            paramJobContext = (JobContext)localObject1;
          }
        }
      }
      catch (OutOfMemoryError localIOException)
      {
        try
        {
          localObject1 = vxv.a(str3, null);
          paramJobContext = (JobContext)localObject1;
          ved.d("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", new Object[] { str3 });
          paramJobContext = (JobContext)localObject1;
          localObject1 = paramJobContext;
          if (paramJobContext == null)
          {
            localObject1 = paramJobContext;
            if (str2 == null) {}
          }
        }
        catch (IOException localIOException)
        {
          try
          {
            localObject1 = vxv.a(str2);
            if ((localObject1 == null) || (!(parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || (!parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false))) {
              break label736;
            }
            paramJobContext = bkle.a((Bitmap)localObject1, -90);
            if (paramJobContext == null) {
              break label736;
            }
            if (paramJobContext == null) {
              break label742;
            }
            localObject1 = vxv.b((Bitmap)localObject3, paramJobContext);
            paramJobContext.recycle();
            ((Bitmap)localObject3).recycle();
            paramJobContext = (JobContext)localObject1;
            localObject1 = paramJobContext;
            if (paramJobContext != null)
            {
              localObject1 = paramJobContext;
              if (str1 == null) {}
            }
            try
            {
              localObject3 = BitmapFactory.decodeFile(str1);
              if (localObject3 == null) {
                break label733;
              }
              localObject1 = vxv.b(paramJobContext, (Bitmap)localObject3);
              if (localObject1 == null) {
                break label733;
              }
              paramJobContext.recycle();
              ((Bitmap)localObject3).recycle();
              paramJobContext = (JobContext)localObject1;
              localObject1 = paramJobContext;
            }
            catch (OutOfMemoryError localOutOfMemoryError3)
            {
              JobContext localJobContext1;
              JobContext localJobContext2;
              ved.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str1 + " failed", localOutOfMemoryError3);
              localJobContext3 = paramJobContext;
              continue;
              vyf.a(ssf.e);
              boolean bool = vxv.a(localJobContext3, (String)localObject2);
              if (localJobContext3 == null) {
                break label588;
              }
              localJobContext3.recycle();
              if (!bool) {
                break label632;
              }
              parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject2);
              ved.b("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image success : " + (String)localObject2);
              i = 1;
              continue;
              ved.d("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
              i = 0;
              continue;
            }
            if (localObject1 == null)
            {
              i = 0;
              break;
              localOutOfMemoryError1 = localOutOfMemoryError1;
              ved.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str2 + " failed", localOutOfMemoryError1);
              localJobContext1 = paramJobContext;
              continue;
              localIOException = localIOException;
              ved.c("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", localIOException);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            ved.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str2 + " failed", localOutOfMemoryError2);
            localJobContext2 = paramJobContext;
            continue;
          }
        }
      }
      JobContext localJobContext3;
      label588:
      label632:
      ved.a("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", localObject2);
      if (vyf.a(new File((String)localObject3), new File((String)localObject2)))
      {
        parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject2);
        i = 1;
        break;
      }
      ved.d("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", new Object[] { localObject3, localObject2 });
      break;
      label715:
      super.notifyError(new ErrorMessage(-1, ajya.a(2131706567)));
      return;
      label733:
      continue;
      label736:
      paramJobContext = localJobContext3;
      continue;
      label742:
      paramJobContext = (JobContext)localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bklv
 * JD-Core Version:    0.7.0.1
 */