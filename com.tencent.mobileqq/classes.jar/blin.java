import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.exporter.ImageExporter.ImageExportCallback;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class blin
  implements ImageExporter.ImageExportCallback
{
  public blin(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onCancelled() {}
  
  public void onExportComplete()
  {
    blfg.b(AEEditorImageEditFragment.e(), "images export complete");
    AEEditorImageEditFragment.a(this.a, System.currentTimeMillis());
    blfg.b(AEEditorImageEditFragment.e(), "perf: image export cost = " + (AEEditorImageEditFragment.a(this.a) - AEEditorImageEditFragment.b(this.a)) + "ms");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.7.2(this));
  }
  
  public void onFailed(Collection<String> paramCollection)
  {
    blfg.d(AEEditorImageEditFragment.e(), "images export failed");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.7.1(this, paramCollection));
  }
  
  public void onImageExport(String paramString)
  {
    blfg.b(AEEditorImageEditFragment.e(), "image export, path = " + paramString);
    List localList = AEEditorImageEditFragment.a(this.a).getMediaModels();
    if ((localList.get(AEEditorImageEditFragment.a(this.a).size()) != null) && (((MediaModel)localList.get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList().size() > 0) && (((MediaModel)localList.get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList().get(0) != null) && (((StickerModel)((MediaModel)localList.get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList().get(0)).getTextItems() != null)) {
      bler.a().a().c.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a).size()), Integer.valueOf(((StickerModel)((MediaModel)AEEditorImageEditFragment.a(this.a).getMediaModels().get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList().get(0)).getTextItems().size()));
    }
    blen.a().b(AEEditorImageEditFragment.a(this.a).size());
    AEEditorImageEditFragment.a(this.a).add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blin
 * JD-Core Version:    0.7.0.1
 */