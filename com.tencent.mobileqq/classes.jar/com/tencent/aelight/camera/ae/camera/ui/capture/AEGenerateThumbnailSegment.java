package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbTask;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MeasureJobSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tribe.async.async.JobContext;

public class AEGenerateThumbnailSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  /* Error */
  private static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: new 18	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 19	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: invokevirtual 23	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc2_w 24
    //   17: invokevirtual 29	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual 32	android/media/MediaMetadataRetriever:release	()V
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: goto +33 -> 61
    //   31: astore_0
    //   32: ldc 34
    //   34: ldc 36
    //   36: aload_0
    //   37: invokestatic 41	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: aload_1
    //   41: invokevirtual 32	android/media/MediaMetadataRetriever:release	()V
    //   44: goto +15 -> 59
    //   47: astore_0
    //   48: ldc 34
    //   50: ldc 36
    //   52: aload_0
    //   53: invokestatic 41	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: goto -16 -> 40
    //   59: aconst_null
    //   60: areturn
    //   61: aload_1
    //   62: invokevirtual 32	android/media/MediaMetadataRetriever:release	()V
    //   65: goto +5 -> 70
    //   68: aload_0
    //   69: athrow
    //   70: goto -2 -> 68
    //   73: astore_1
    //   74: aload_0
    //   75: areturn
    //   76: astore_0
    //   77: goto -18 -> 59
    //   80: astore_1
    //   81: goto -16 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   7	55	1	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   73	1	1	localRuntimeException1	java.lang.RuntimeException
    //   80	1	1	localRuntimeException2	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   8	21	27	finally
    //   32	40	27	finally
    //   48	56	27	finally
    //   8	21	31	java/lang/RuntimeException
    //   8	21	47	java/lang/IllegalArgumentException
    //   21	25	73	java/lang/RuntimeException
    //   40	44	76	java/lang/RuntimeException
    //   61	65	80	java/lang/RuntimeException
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    AEQLog.a("AEGenerateThumbnailSegment", "start generate thumb ...");
    paramJobContext = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs;
    int i = paramJobContext.c;
    Bitmap localBitmap = a(paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a());
    if (localBitmap != null)
    {
      String str = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".jpg");
      if (new GenerateThumbTask(localBitmap, str, paramJobContext.jdField_a_of_type_Int, paramJobContext.jdField_b_of_type_Int, i, paramJobContext.jdField_a_of_type_Float, paramJobContext.jdField_a_of_type_Double, paramJobContext.jdField_b_of_type_Double, paramGenerateContext.jdField_a_of_type_Int).a(new Void[0]).intValue() == 0)
      {
        paramGenerateContext.jdField_a_of_type_JavaLangString = str;
        paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.thumbPath = str;
        AEQLog.c("AEGenerateThumbnailSegment", "generate %d thumb success ...");
        super.notifyResult(paramGenerateContext);
        return;
      }
      AEQLog.c("AEGenerateThumbnailSegment", "generate %d thumb failed ...");
      super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131705770)));
      return;
    }
    AEQLog.c("AEGenerateThumbnailSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null");
    super.notifyError(new ErrorMessage(-1, HardCodeUtil.a(2131705771)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.AEGenerateThumbnailSegment
 * JD-Core Version:    0.7.0.1
 */