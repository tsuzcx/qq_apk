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

public class biub
  extends biuq<bitz, bitz>
  implements sks
{
  public final int a;
  public final String a;
  public final WeakReference<bibg> a;
  public final WeakReference<bibh> b;
  
  public biub(bibg parambibg, bibh parambibh, int paramInt)
  {
    this(parambibg, parambibh, null, paramInt);
  }
  
  public biub(bibg parambibg, bibh parambibh, String paramString, int paramInt)
  {
    if (parambibg == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambibg);
    this.b = new WeakReference(parambibh);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bitz parambitz)
  {
    long l1 = SystemClock.uptimeMillis();
    paramJobContext = parambitz.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramJobContext))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      urp.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    bibg localbibg = (bibg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = (bibh)this.b.get();
    Bitmap localBitmap;
    String str;
    if ((localbibg != null) && ((!localbibg.a(this.jdField_a_of_type_Int)) || ((localObject != null) && (((bibh)localObject).a(this.jdField_a_of_type_Int)))))
    {
      localBitmap = localbibg.a(this.jdField_a_of_type_Int, true);
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label682;
      }
      str = biut.a(parambitz.jdField_a_of_type_Int, parambitz.b, ".png");
      if (localBitmap != null) {
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        if (((bibh)localObject).a(this.jdField_a_of_type_Int)) {
          ((bibh)localObject).a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
        }
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        try
        {
          bacm.a(paramJobContext, (BitmapFactory.Options)localObject);
          m = ((BitmapFactory.Options)localObject).outWidth;
          n = ((BitmapFactory.Options)localObject).outHeight;
          if ((parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) && (parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.d()) && (parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() < parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b())) {
            break label685;
          }
          if (parambitz.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 14) {
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
          urk.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", paramJobContext);
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
        paramJobContext = vlc.c(localBitmap, i, k, true, false);
        i = biul.a(parambitz);
        if (i != 0)
        {
          paramJobContext = vms.a(paramJobContext, i);
          if (paramJobContext == null) {
            break label673;
          }
          bool = vlc.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str);
          localbibg.a(localBitmap);
          if (paramJobContext != localBitmap) {
            vlc.a(paramJobContext);
          }
          if ((paramJobContext != null) && (bool))
          {
            urk.b("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
            l2 = SystemClock.uptimeMillis();
            urp.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
            urp.b("take_video", "create_doodle_result", 0, 0, new String[0]);
            parambitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("dynamic_Sticker_image_path", str);
            super.notifyResult(parambitz);
            return;
            j = 0;
          }
        }
        else
        {
          if ((((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) || ((parambitz.jdField_a_of_type_Int != 12) && (parambitz.jdField_a_of_type_Int != 11))) {
            break label679;
          }
          paramJobContext = vms.a(paramJobContext, 270.0F);
          continue;
        }
        urk.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
      }
      finally
      {
        localbibg.a(localBitmap);
      }
      urp.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      urk.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
      urp.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      urk.d("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
      super.notifyResult(parambitz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biub
 * JD-Core Version:    0.7.0.1
 */