import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bfve
  extends JobSegment<bfvc, bfvc>
{
  private int jdField_a_of_type_Int;
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public bfve(XMediaEditor paramXMediaEditor, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, bfvc parambfvc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment start. info status=", Integer.valueOf(parambfvc.g) });
    }
    String str2 = bfuw.b();
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    Object localObject4 = null;
    String str1 = null;
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = localBitmap2;
    Object localObject3 = localObject4;
    Object localObject1 = str1;
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(parambfvc.f);
        localBitmap1 = localBitmap2;
        localObject3 = localObject4;
        localObject1 = str1;
        localBitmap3 = localMediaMetadataRetriever.getFrameAtTime(-1L);
        if (localBitmap3 == null)
        {
          localBitmap1 = localBitmap2;
          localObject3 = localObject4;
          localObject1 = str1;
          notifyError(new Error("-201"));
        }
      }
      catch (Exception paramJobContext)
      {
        Bitmap localBitmap3;
        int[] arrayOfInt;
        localObject1 = localBitmap1;
        QLog.e("GenerateVideoPosterSegment", 1, "error retrieve video info" + paramJobContext.getMessage());
        localObject1 = localBitmap1;
        notifyError(new Error("-201"));
        try
        {
          localMediaMetadataRetriever.release();
          if (localBitmap1 == null) {
            continue;
          }
          localBitmap1.recycle();
          return;
        }
        catch (RuntimeException paramJobContext)
        {
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject2 = localObject3;
        QLog.e("GenerateVideoPosterSegment", 1, "GenerateVideoPosterSegment error. OutOfMemoryError");
        localObject2 = localObject3;
        URLDrawable.clearMemoryCache();
        localObject2 = localObject3;
        System.gc();
        localObject2 = localObject3;
        if (!this.jdField_a_of_type_Boolean)
        {
          localObject2 = localObject3;
          this.jdField_a_of_type_Boolean = true;
          localObject2 = localObject3;
          a(paramJobContext, parambfvc);
          try
          {
            localMediaMetadataRetriever.release();
            if (localObject3 == null) {
              continue;
            }
            ((Bitmap)localObject3).recycle();
            return;
          }
          catch (RuntimeException paramJobContext)
          {
            return;
          }
        }
        localObject2 = localObject3;
        notifyError(new Error("-1"));
        continue;
      }
      finally
      {
        try
        {
          Object localObject2;
          localMediaMetadataRetriever.release();
          if (localObject2 != null) {
            localObject2.recycle();
          }
        }
        catch (RuntimeException parambfvc)
        {
          continue;
        }
      }
      try
      {
        localMediaMetadataRetriever.release();
        if (0 != 0) {
          throw new NullPointerException();
        }
        return;
      }
      catch (RuntimeException paramJobContext) {}
      localBitmap1 = localBitmap2;
      localObject3 = localObject4;
      localObject1 = str1;
      arrayOfInt = bfvt.a(this.jdField_a_of_type_Int, 200, 300, parambfvc.jdField_a_of_type_Int, parambfvc.b);
      localBitmap1 = localBitmap2;
      localObject3 = localObject4;
      localObject1 = str1;
      localBitmap2 = ThumbnailUtils.extractThumbnail(localBitmap3, arrayOfInt[0], arrayOfInt[1]);
      if (localBitmap2 == null)
      {
        localBitmap1 = localBitmap2;
        localObject3 = localBitmap2;
        localObject1 = localBitmap2;
        notifyError(new Error("-201"));
        try
        {
          localMediaMetadataRetriever.release();
          if (localBitmap2 == null) {
            continue;
          }
          localBitmap2.recycle();
          return;
        }
        catch (RuntimeException paramJobContext) {}
      }
      else
      {
        localBitmap1 = localBitmap2;
        localObject3 = localBitmap2;
        localObject1 = localBitmap2;
        str1 = VFSAssistantUtils.getSDKPrivatePath(str2 + "videoThumb_" + System.currentTimeMillis() + ".jpg");
        localBitmap1 = localBitmap2;
        localObject3 = localBitmap2;
        localObject1 = localBitmap2;
        bheg.a(localBitmap2, new File(str1));
        localBitmap1 = localBitmap2;
        localObject3 = localBitmap2;
        localObject1 = localBitmap2;
        parambfvc.c = str1;
        localBitmap1 = localBitmap2;
        localObject3 = localBitmap2;
        localObject1 = localBitmap2;
        ThreadManager.getUIHandler().post(new VideoInfo.GenerateVideoPosterSegment.1(this, parambfvc, str1));
        localBitmap1 = localBitmap2;
        localObject3 = localBitmap2;
        localObject1 = localBitmap2;
        if (!isCanceled())
        {
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localObject1 = localBitmap2;
          if (QLog.isColorLevel())
          {
            localBitmap1 = localBitmap2;
            localObject3 = localBitmap2;
            localObject1 = localBitmap2;
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment notifyResult. info status=", Integer.valueOf(parambfvc.g) });
          }
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localObject1 = localBitmap2;
          notifyResult(parambfvc);
        }
        try
        {
          localMediaMetadataRetriever.release();
          if (localBitmap2 != null)
          {
            localBitmap2.recycle();
            return;
          }
        }
        catch (RuntimeException paramJobContext) {}
      }
    }
  }
  
  public void onCancel()
  {
    notifyError(new Error("c_2000"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfve
 * JD-Core Version:    0.7.0.1
 */