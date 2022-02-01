package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class AEEditorImageTemplatePanel$4
  implements Runnable
{
  AEEditorImageTemplatePanel$4(AEEditorImageTemplatePanel paramAEEditorImageTemplatePanel, MetaMaterial paramMetaMaterial, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback) {}
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new File(AEEditorResourceManager.a().k(this.a));
        if (((File)localObject1).exists())
        {
          localObject1 = FileUtils.readFileContent((File)localObject1);
          Object localObject2 = new JSONObject((String)localObject1).optJSONArray("text");
          localObject2 = AEEditorImageTemplatePanel.a(this.this$0, (JSONArray)localObject2);
          if (AEEditorImageTemplatePanel.f(this.this$0) == null) {
            break label311;
          }
          Map localMap = AEEditorImageTemplatePanel.f(this.this$0).b((List)localObject2);
          if (localMap != null)
          {
            AEEditorImageTemplatePanel.g(this.this$0).clear();
            AEEditorImageTemplatePanel.g(this.this$0).putAll(localMap);
          }
          bool1 = AEEditorImageTemplatePanel.a(this.this$0, (List)localObject2, localMap);
          localObject2 = new JSONObject((String)localObject1).optJSONArray("sticker");
          localObject2 = AEEditorImageTemplatePanel.a(this.this$0, (JSONArray)localObject2);
          bool2 = bool1;
          if (AEEditorImageTemplatePanel.h(this.this$0) != null)
          {
            localMap = AEEditorImageTemplatePanel.h(this.this$0).b((List)localObject2);
            if ((!bool1) || (!AEEditorImageTemplatePanel.a(this.this$0, (List)localObject2, localMap))) {
              break label316;
            }
            bool2 = true;
          }
          ImageTemplateMaterialExKt.a(this.a, true);
          ImageTemplateMaterialExKt.a(this.a, (String)localObject1);
          i = j;
          if (!bool2) {
            break label270;
          }
          try
          {
            ImageTemplateMaterialExKt.b(this.a, true);
            i = j;
          }
          catch (Exception localException1)
          {
            i = 1;
            continue;
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception localException2)
      {
        i = 0;
        AEQLog.a(AEEditorImageTemplatePanel.a, "Pic template apply error", localException2);
      }
      label270:
      if (i != 0)
      {
        this.b.a(ApplyMaterialTask.Status.SUCCEEDED, 100);
        return;
      }
      this.b.a(ApplyMaterialTask.Status.FAILED, -1);
      AEEditorImageTemplatePanel.a(this.this$0, false);
      return;
      label311:
      boolean bool1 = true;
      continue;
      label316:
      boolean bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.4
 * JD-Core Version:    0.7.0.1
 */