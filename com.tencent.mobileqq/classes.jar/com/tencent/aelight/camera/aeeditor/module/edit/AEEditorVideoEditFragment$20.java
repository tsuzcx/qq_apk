package com.tencent.aelight.camera.aeeditor.module.edit;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.session.callback.FrameExtractCallback;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class AEEditorVideoEditFragment$20
  implements FrameExtractCallback
{
  AEEditorVideoEditFragment$20(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, TAVCutVideoSession paramTAVCutVideoSession, String paramString1, String paramString2, String paramString3) {}
  
  public void onExtractCanceled()
  {
    this.a.release();
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pExportEnd(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), "cover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), AEEditorVideoEditFragment.u(this.e)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), this.b), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), "-90000002") }));
  }
  
  public void onExtractFailed()
  {
    this.a.release();
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pExportEnd(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), "cover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), AEEditorVideoEditFragment.u(this.e)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), this.b), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), "-90000001") }));
  }
  
  public void onFrameExtracted(Bitmap paramBitmap)
  {
    this.a.release();
    boolean bool = FileUtils.saveBitmapToFile(paramBitmap, this.b);
    paramBitmap = AEEditorVideoEditFragment.aj();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGoNext... saveBitmapToFile isSuccess:");
    localStringBuilder.append(bool);
    AEQLog.a(paramBitmap, localStringBuilder.toString());
    this.e.e();
    if (ModelExtKt.isLightTemplate(this.e.B.getMediaModel()))
    {
      this.e.B.getMediaModel().getMediaEffectModel().getMusicModel().setBgmVolume(this.e.K);
      this.e.B.getMediaModel().getMediaEffectModel().getMusicModel().setVolume(this.e.J);
    }
    this.e.a(this.c, this.b, this.d);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pExportEnd(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), "cover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), AEEditorVideoEditFragment.u(this.e)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext3(), this.b), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), "0") }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.20
 * JD-Core Version:    0.7.0.1
 */