import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class babf
  extends JobSegment<babd, babd>
{
  private int jdField_a_of_type_Int;
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public babf(XMediaEditor paramXMediaEditor, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, babd parambabd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment start. info status=", Integer.valueOf(parambabd.g) });
    }
    String str2 = baax.b();
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    String str1 = null;
    Bitmap localBitmap1 = null;
    Object localObject5 = null;
    Object localObject3 = localObject5;
    Object localObject4 = str1;
    Object localObject1 = localBitmap1;
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(parambabd.f);
        localObject3 = localObject5;
        localObject4 = str1;
        localObject1 = localBitmap1;
        localBitmap2 = localMediaMetadataRetriever.getFrameAtTime(-1L);
        if (localBitmap2 == null)
        {
          localObject3 = localObject5;
          localObject4 = str1;
          localObject1 = localBitmap1;
          notifyError(new Error("-201"));
        }
      }
      catch (Exception paramJobContext)
      {
        Bitmap localBitmap2;
        int[] arrayOfInt;
        localObject1 = localObject3;
        QLog.e("GenerateVideoPosterSegment", 1, "error retrieve video info" + paramJobContext.getMessage());
        localObject1 = localObject3;
        notifyError(new Error("-201"));
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
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject2 = localObject4;
        QLog.e("GenerateVideoPosterSegment", 1, "GenerateVideoPosterSegment error. OutOfMemoryError");
        localObject2 = localObject4;
        URLDrawable.clearMemoryCache();
        localObject2 = localObject4;
        System.gc();
        localObject2 = localObject4;
        if (!this.jdField_a_of_type_Boolean)
        {
          localObject2 = localObject4;
          this.jdField_a_of_type_Boolean = true;
          localObject2 = localObject4;
          a(paramJobContext, parambabd);
          try
          {
            localMediaMetadataRetriever.release();
            if (localObject4 == null) {
              continue;
            }
            ((Bitmap)localObject4).recycle();
            return;
          }
          catch (RuntimeException paramJobContext)
          {
            return;
          }
        }
        localObject2 = localObject4;
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
        catch (RuntimeException parambabd)
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
      localObject3 = localObject5;
      localObject4 = str1;
      localObject1 = localBitmap1;
      arrayOfInt = babu.a(this.jdField_a_of_type_Int, 200, 300, parambabd.jdField_a_of_type_Int, parambabd.b);
      localObject3 = localObject5;
      localObject4 = str1;
      localObject1 = localBitmap1;
      localBitmap1 = ThumbnailUtils.extractThumbnail(localBitmap2, arrayOfInt[0], arrayOfInt[1]);
      if (localBitmap1 == null)
      {
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
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
        catch (RuntimeException paramJobContext) {}
      }
      else
      {
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
        localObject1 = localBitmap1;
        str1 = bbuv.a(str2 + "videoThumb_" + System.currentTimeMillis() + ".jpg");
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
        localObject1 = localBitmap1;
        bbdr.a(localBitmap1, new File(str1));
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
        localObject1 = localBitmap1;
        parambabd.c = str1;
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
        localObject1 = localBitmap1;
        ThreadManager.getUIHandler().post(new VideoInfo.GenerateVideoPosterSegment.1(this, parambabd, str1));
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
        localObject1 = localBitmap1;
        if (!isCanceled())
        {
          localObject3 = localBitmap1;
          localObject4 = localBitmap1;
          localObject1 = localBitmap1;
          if (QLog.isColorLevel())
          {
            localObject3 = localBitmap1;
            localObject4 = localBitmap1;
            localObject1 = localBitmap1;
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment notifyResult. info status=", Integer.valueOf(parambabd.g) });
          }
          localObject3 = localBitmap1;
          localObject4 = localBitmap1;
          localObject1 = localBitmap1;
          notifyResult(parambabd);
        }
        try
        {
          localMediaMetadataRetriever.release();
          if (localBitmap1 != null)
          {
            localBitmap1.recycle();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babf
 * JD-Core Version:    0.7.0.1
 */