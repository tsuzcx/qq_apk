package com.tencent.aelight.camera.aeeditor.module.edit;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.session.callback.FrameExtractCallback;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.MusicModel;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class AEEditorVideoEditFragment$20
  implements FrameExtractCallback
{
  AEEditorVideoEditFragment$20(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, TAVCutVideoSession paramTAVCutVideoSession, String paramString1, String paramString2, String paramString3) {}
  
  public void onExtractCanceled()
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_EXPORT_END(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), "cover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), AEEditorVideoEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT3(), this.jdField_a_of_type_JavaLangString), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "-90000002") }));
  }
  
  public void onExtractFailed()
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_EXPORT_END(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), "cover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), AEEditorVideoEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT3(), this.jdField_a_of_type_JavaLangString), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "-90000001") }));
  }
  
  public void onFrameExtracted(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.release();
    boolean bool = FileUtils.saveBitmapToFile(paramBitmap, this.jdField_a_of_type_JavaLangString);
    paramBitmap = AEEditorVideoEditFragment.h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGoNext... saveBitmapToFile isSuccess:");
    localStringBuilder.append(bool);
    AEQLog.a(paramBitmap, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment.b();
    if (ModelExtKt.isLightTemplate(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel()))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getMusicModel().setBgmVolume(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment.b);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getMediaModel().getMediaEffectModel().getMusicModel().setVolume(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment.jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment.a(this.b, this.jdField_a_of_type_JavaLangString, this.c);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_EXPORT_END(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), "cover"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), AEEditorVideoEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment)), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT3(), this.jdField_a_of_type_JavaLangString), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "0") }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.20
 * JD-Core Version:    0.7.0.1
 */