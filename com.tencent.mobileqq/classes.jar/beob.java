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

public class beob
  extends JobSegment<benz, benz>
{
  private int jdField_a_of_type_Int;
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public beob(XMediaEditor paramXMediaEditor, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, benz parambenz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment start. info status=", Integer.valueOf(parambenz.g) });
    }
    String str2 = bent.b();
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
        localMediaMetadataRetriever.setDataSource(parambenz.f);
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
          a(paramJobContext, parambenz);
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
        catch (RuntimeException parambenz)
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
      arrayOfInt = beoq.a(this.jdField_a_of_type_Int, 200, 300, parambenz.jdField_a_of_type_Int, parambenz.b);
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
        str1 = VFSAssistantUtils.getSDKPrivatePath(str2 + "videoThumb_" + System.currentTimeMillis() + ".jpg");
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
        localObject1 = localBitmap1;
        bfvo.a(localBitmap1, new File(str1));
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
        localObject1 = localBitmap1;
        parambenz.c = str1;
        localObject3 = localBitmap1;
        localObject4 = localBitmap1;
        localObject1 = localBitmap1;
        ThreadManager.getUIHandler().post(new VideoInfo.GenerateVideoPosterSegment.1(this, parambenz, str1));
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
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment notifyResult. info status=", Integer.valueOf(parambenz.g) });
          }
          localObject3 = localBitmap1;
          localObject4 = localBitmap1;
          localObject1 = localBitmap1;
          notifyResult(parambenz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beob
 * JD-Core Version:    0.7.0.1
 */