package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.report.AEEditReportData;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.aeeditor.module.clip.image.AEEditorClipContainer;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.tavcut.exporter.ImageExporter.ImageExportCallback;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.tavsticker.utils.CollectionUtil;
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
    AEEditorImageEditFragment.a(this.b, System.currentTimeMillis());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("perf: image export cost = ");
    ((StringBuilder)localObject).append(AEEditorImageEditFragment.B(this.b) - AEEditorImageEditFragment.C(this.b));
    ((StringBuilder)localObject).append("ms");
    AEQLog.b("AEEditorImageEditFragment", ((StringBuilder)localObject).toString());
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.26.2(this));
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).pExportEnd(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext1(), "pic"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).ext2(), AEEditorImageEditFragment.A(this.b).toString()), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).keyRetCode(), "0") }));
    String str1 = AEEditorImageEditFragment.F(this.b).toString();
    String str2 = AEEditorImageEditFragment.G(this.b).toString();
    String str3 = AEEditorImageEditFragment.H(this.b).toString();
    if (AEEditorImageEditFragment.d(this.b).get(0) != null) {
      localObject = AEEditorClipContainer.a(((AEEditorImageInfo)AEEditorImageEditFragment.d(this.b).get(0)).e);
    } else {
      localObject = "";
    }
    AEReportUtils.a(str1, str2, str3, (String)localObject, AEEditorImageEditFragment.I(this.b).toString(), AEEditorImageEditFragment.J(this.b).toString());
    AEBaseReportParam.a().ab();
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
    if (AEEditorImageEditFragment.f(this.b) == null) {
      return;
    }
    localObject = AEEditorImageEditFragment.f(this.b).getMediaModels();
    if (((List)localObject).get(AEEditorImageEditFragment.A(this.b).size()) != null)
    {
      AEBaseReportParam.a().n().g.put(Integer.valueOf(AEEditorImageEditFragment.A(this.b).size()), Integer.valueOf(((MediaModel)((List)localObject).get(AEEditorImageEditFragment.A(this.b).size())).getMediaEffectModel().getStickerModelList().size()));
      localObject = ((MediaModel)((List)localObject).get(AEEditorImageEditFragment.A(this.b).size())).getMediaEffectModel().getStickerModelList();
      int j = AEEditorImageEditFragment.A(this.b).size();
      if (!CollectionUtil.isEmptyList((List)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          if (((List)localObject).get(i) != null)
          {
            String str = ((StickerModel)((List)localObject).get(i)).getMaterialId();
            if (this.b.w.a(str) != null) {
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
        AEBaseReportParam.a().n().i.put(Integer.valueOf(j), localStringBuilder.toString());
        this.b.a((List)localObject, j);
      }
      this.b.a((List)localObject);
    }
    localObject = AEBaseDataReporter.a().b(AEEditorImageEditFragment.A(this.b).size());
    AEEditorImageEditFragment.a(this.b, (HashMap)localObject);
    AEEditorImageEditFragment.A(this.b).add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.26
 * JD-Core Version:    0.7.0.1
 */