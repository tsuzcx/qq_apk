package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperContainer;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tavcut.exporter.ImageExporter.ImageExportCallback;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$26
  implements ImageExporter.ImageExportCallback
{
  AEEditorImageEditFragment$26(AEEditorImageEditFragment paramAEEditorImageEditFragment, boolean paramBoolean) {}
  
  public void onCancelled() {}
  
  public void onExportComplete()
  {
    AEQLog.b("AEEditorImageEditFragment", "images export complete");
    AEEditorImageEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment, System.currentTimeMillis());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("perf: image export cost = ");
    ((StringBuilder)localObject).append(AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment) - AEEditorImageEditFragment.c(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment));
    ((StringBuilder)localObject).append("ms");
    AEQLog.b("AEEditorImageEditFragment", ((StringBuilder)localObject).toString());
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.26.2(this));
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).P_EXPORT_END(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), "pic"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).toString()), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "0") }));
    String str1 = AEEditorImageEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).toString();
    String str2 = AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).toString();
    String str3 = AEEditorImageEditFragment.c(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).toString();
    if (AEEditorImageEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).get(0) != null) {
      localObject = AEImageCropperContainer.a(((AEEditorImageInfo)AEEditorImageEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).get(0)).c);
    } else {
      localObject = "";
    }
    AEReportUtils.a(str1, str2, str3, (String)localObject, AEEditorImageEditFragment.d(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).toString(), AEEditorImageEditFragment.e(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).toString());
    AEBaseReportParam.a().n();
  }
  
  public void onFailed(Collection<String> paramCollection)
  {
    AEQLog.d("AEEditorImageEditFragment", "images export failed");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.26.1(this, paramCollection));
  }
  
  public void onImageExport(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("image export, path = ");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.b("AEEditorImageEditFragment", ((StringBuilder)localObject).toString());
    if (AEEditorImageEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment) == null) {
      return;
    }
    localObject = AEEditorImageEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).getMediaModels();
    if (((List)localObject).get(AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).size()) != null)
    {
      AEBaseReportParam.a().a().c.put(Integer.valueOf(AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).size()), Integer.valueOf(((MediaModel)((List)localObject).get(AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).size())).getMediaEffectModel().getStickerModelList().size()));
      localObject = ((MediaModel)((List)localObject).get(AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).size())).getMediaEffectModel().getStickerModelList();
      int j = AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).size();
      if (!CollectionUtil.isEmptyList((List)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          if (((List)localObject).get(i) != null)
          {
            String str = ((StickerModel)((List)localObject).get(i)).getMaterialId();
            if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a.a(str) != null) {
              if (localStringBuilder.length() == 0)
              {
                localStringBuilder.append(str);
              }
              else
              {
                localStringBuilder.append(",");
                localStringBuilder.append(str);
              }
            }
          }
          i += 1;
        }
        AEBaseReportParam.a().a().e.put(Integer.valueOf(j), localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a((List)localObject, j);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a((List)localObject);
    }
    localObject = AEBaseDataReporter.a().a(AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).size());
    AEEditorImageEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment, (HashMap)localObject);
    AEEditorImageEditFragment.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.26
 * JD-Core Version:    0.7.0.1
 */