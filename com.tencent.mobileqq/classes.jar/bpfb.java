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

public class bpfb
  extends bpez<bpel, bpel>
{
  private final String a;
  
  public bpfb()
  {
    this(null);
  }
  
  public bpfb(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, bpel parambpel)
  {
    paramJobContext = null;
    int i = 0;
    Object localObject3 = parambpel.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bpfc.a(parambpel.jdField_a_of_type_Int, parambpel.b, ".jpg");
    }
    String str3 = parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath;
    String str2 = parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath;
    String str4 = parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("dynamic_Sticker_image_path", null);
    String str1 = parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getStringExtra("pl_pic", null);
    if ((str3 != null) || (str2 != null) || (str4 != null))
    {
      try
      {
        localObject3 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject3 != null) {
          break label213;
        }
        super.notifyError(new ErrorMessage(-1, anvx.a(2131706027)));
        return;
      }
      catch (OutOfMemoryError paramJobContext)
      {
        ykq.e("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed : " + paramJobContext);
      }
      if (i == 0) {
        break label715;
      }
      zeb.a(new File(parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath), new File(QQStoryTakeVideoCloseAnimationActivity.jdField_a_of_type_JavaLangString));
      super.notifyResult(parambpel);
      return;
      label213:
      localObject1 = paramJobContext;
      if (str4 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = zdr.a(str4);
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
          localObject1 = zdr.a(str3, null);
          paramJobContext = (JobContext)localObject1;
          ykq.d("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile success %s", new Object[] { str3 });
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
            localObject1 = zdr.a(str2);
            if ((localObject1 == null) || (!(parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || (!parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.getBooleanExtra("landscape_video", false))) {
              break label736;
            }
            paramJobContext = bpem.a((Bitmap)localObject1, -90);
            if (paramJobContext == null) {
              break label736;
            }
            if (paramJobContext == null) {
              break label742;
            }
            localObject1 = zdr.b((Bitmap)localObject3, paramJobContext);
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
              localObject1 = zdr.b(paramJobContext, (Bitmap)localObject3);
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
              ykq.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str1 + " failed", localOutOfMemoryError3);
              localJobContext3 = paramJobContext;
              continue;
              zeb.a(vzh.e);
              boolean bool = zdr.a(localJobContext3, (String)localObject2);
              if (localJobContext3 == null) {
                break label588;
              }
              localJobContext3.recycle();
              if (!bool) {
                break label632;
              }
              parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject2);
              ykq.b("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image success : " + (String)localObject2);
              i = 1;
              continue;
              ykq.d("Q.qqstory.publish.edit.MergeThumbSegment", "merge doodle and thumb image failed");
              i = 0;
              continue;
            }
            if (localObject1 == null)
            {
              i = 0;
              break;
              localOutOfMemoryError1 = localOutOfMemoryError1;
              ykq.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str2 + " failed", localOutOfMemoryError1);
              localJobContext1 = paramJobContext;
              continue;
              localIOException = localIOException;
              ykq.c("Q.qqstory.publish.edit.MergeThumbSegment", "unSerializeBitmapFromFile failed", localIOException);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            ykq.c("Q.qqstory.publish.edit.MergeThumbSegment", "decode " + str2 + " failed", localOutOfMemoryError2);
            localJobContext2 = paramJobContext;
            continue;
          }
        }
      }
      JobContext localJobContext3;
      label588:
      label632:
      ykq.a("Q.qqstory.publish.edit.MergeThumbSegment", "use thumb image as merged image, copy to target destination = %s", localObject2);
      if (zeb.a(new File((String)localObject3), new File((String)localObject2)))
      {
        parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath = ((String)localObject2);
        i = 1;
        break;
      }
      ykq.d("Q.qqstory.publish.edit.MergeThumbSegment", "copy failed, original = %s, target = %s", new Object[] { localObject3, localObject2 });
      break;
      label715:
      super.notifyError(new ErrorMessage(-1, anvx.a(2131706030)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfb
 * JD-Core Version:    0.7.0.1
 */