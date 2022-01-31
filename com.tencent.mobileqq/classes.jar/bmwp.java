import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.lang.ref.WeakReference;

public class bmwp
  extends bmxd<bmwn, bmwn>
  implements umd
{
  public final int a;
  public final String a;
  public final WeakReference<bmee> a;
  public final WeakReference<bmef> b;
  
  public bmwp(bmee parambmee, bmef parambmef, int paramInt)
  {
    this(parambmee, parambmef, null, paramInt);
  }
  
  public bmwp(bmee parambmee, bmef parambmef, String paramString, int paramInt)
  {
    if (parambmee == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmee);
    this.b = new WeakReference(parambmef);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bmwn parambmwn)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambmwn.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      wta.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bmee localbmee = (bmee)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bmef)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbmee != null) && ((!localbmee.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bmef)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbmee.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = bmxg.a(parambmwn.jdField_a_of_type_Int, parambmwn.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bmef)localObject).a(this.jdField_a_of_type_Int)) {
          ((bmef)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bdda.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambmwn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
            continue;
          }
        }
        catch (OutOfMemoryError paramJobContext)
        {
          int m;
          int n;
          int k;
          int i;
          long l2;
          wsv.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
          super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", 6));
          return;
        }
        k = n;
        i = m;
        if (m > n)
        {
          k = n;
          i = m;
          if (j != 0)
          {
            i = ((BitmapFactory.Options)localObject).outHeight;
            k = ((BitmapFactory.Options)localObject).outWidth;
          }
        }
        paramJobContext = xmn.c(localBitmap, i, k, true, false);
        i = bmwy.a(parambmwn);
        if (i != 0)
        {
          paramJobContext = xod.a(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = xmn.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbmee.a(localBitmap);
          if (paramJobContext != localBitmap) {
            xmn.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            wsv.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            wta.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            wta.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambmwn);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambmwn.jdField_a_of_type_Int != 12) && (parambmwn.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = xod.a(paramJobContext, 270.0F);
          continue;
        }
        wsv.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbmee.a(localBitmap);
      }
      wta.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      wsv.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      wta.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      wsv.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambmwn);
      return;
      label673:
      boolean bool = false;
      continue;
      label679:
      continue;
      label682:
      break;
      label685:
      int j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwp
 * JD-Core Version:    0.7.0.1
 */