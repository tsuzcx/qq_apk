package com.tencent.aelight.camera.aeeditor.module.export;

import com.tencent.aelight.camera.aeeditor.listener.AETavSessionStatusListener;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aeeditor.module.params.VideoParamStrategy;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qcircle.tavcut.bean.Size;
import com.tencent.qcircle.tavcut.exporter.VideoExportConfig;
import com.tencent.qcircle.tavcut.exporter.VideoExporter;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.util.VideoUtil;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightMediaTemplateModel;
import org.light.LightAsset;

public class AEEditorGenerateRunnable
  implements Runnable
{
  private final String a = "AEEditorGenerateRunnable";
  private AETavSessionStatusListener b;
  private String c;
  private String d;
  private String e;
  private MediaModel f;
  private VideoExporter g;
  
  public AEEditorGenerateRunnable(String paramString1, String paramString2, String paramString3, MediaModel paramMediaModel, AETavSessionStatusListener paramAETavSessionStatusListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AEEditorGenerateRunnable] new :");
    localStringBuilder.append(paramString1);
    AEQLog.b("AEEditorGenerateRunnable", localStringBuilder.toString());
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramMediaModel;
    this.b = paramAETavSessionStatusListener;
  }
  
  private void a(VideoParamStrategy paramVideoParamStrategy, Size paramSize)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoSrc=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", videoDst=");
    localStringBuilder.append(this.e);
    if (paramSize != null)
    {
      localStringBuilder.append(", exportWidth=");
      localStringBuilder.append(paramSize.getWidth());
      localStringBuilder.append(", exportHeight=");
      localStringBuilder.append(paramSize.getHeight());
    }
    localStringBuilder.append(", exportBitRate=");
    localStringBuilder.append(paramVideoParamStrategy.b());
    localStringBuilder.append(", exportFrameRate=");
    localStringBuilder.append(paramVideoParamStrategy.c());
    paramVideoParamStrategy = new StringBuilder();
    paramVideoParamStrategy.append("[run], exportParams: ");
    paramVideoParamStrategy.append(localStringBuilder.toString());
    AEQLog.d("AEEditorGenerateRunnable", paramVideoParamStrategy.toString());
  }
  
  private boolean b()
  {
    String str = this.c;
    return (str != null) && (str.startsWith("multi_video_"));
  }
  
  public VideoExporter a()
  {
    return this.g;
  }
  
  public void run()
  {
    try
    {
      localObject2 = new TAVCutVideoSession();
      VideoParamStrategy localVideoParamStrategy = ParamFactory.b();
      if (b())
      {
        AEEditorVideoEditFragment.a(BaseApplicationImpl.getContext(), (TAVCutVideoSession)localObject2, localVideoParamStrategy, this.f, null, null);
        localObject1 = AEEditorVideoEditFragment.a((TAVCutVideoSession)localObject2);
      }
      else
      {
        localObject1 = VideoUtil.getVideoSize(this.d);
        ((TAVCutVideoSession)localObject2).setMediaModel(this.f);
        ((TAVCutVideoSession)localObject2).init(BaseApplicationImpl.getContext());
      }
      if (ModelExtKt.isLightTemplate(((TAVCutVideoSession)localObject2).getMediaModel()))
      {
        localObject1 = LightAsset.Load(((TAVCutVideoSession)localObject2).getMediaModel().getMediaTemplateModel().getLightMediaTemplateModel().getFilePath(), 100);
        localObject1 = new Size(((LightAsset)localObject1).width(), ((LightAsset)localObject1).height());
      }
      Object localObject1 = localVideoParamStrategy.a((Size)localObject1);
      VideoExportConfig localVideoExportConfig = new VideoExportConfig();
      localVideoExportConfig.setOutputPath(this.e);
      localVideoExportConfig.setSize(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight());
      localVideoExportConfig.setBitRate(localVideoParamStrategy.b());
      localVideoExportConfig.setFrameRate(localVideoParamStrategy.c());
      ((TAVCutVideoSession)localObject2).applyCurrentSticker();
      a(localVideoParamStrategy, (Size)localObject1);
      this.g = ((TAVCutVideoSession)localObject2).getExporter(localVideoExportConfig);
      this.g.export(new AEEditorGenerateRunnable.1(this, (TAVCutVideoSession)localObject2));
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[ERROR!!!!] generate error");
      ((StringBuilder)localObject2).append(localException.getMessage());
      AEQLog.d("AEEditorGenerateRunnable", ((StringBuilder)localObject2).toString());
      localObject2 = this.b;
      if (localObject2 != null) {
        ((AETavSessionStatusListener)localObject2).a(this.c, -3, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.export.AEEditorGenerateRunnable
 * JD-Core Version:    0.7.0.1
 */