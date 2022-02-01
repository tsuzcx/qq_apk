import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.exporter.ImageExporter.ImageExportCallback;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.20.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.20.2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class bpgm
  implements ImageExporter.ImageExportCallback
{
  public bpgm(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onCancelled() {}
  
  public void onExportComplete()
  {
    bpam.b(AEEditorImageEditFragment.e(), "images export complete");
    AEEditorImageEditFragment.a(this.a, System.currentTimeMillis());
    bpam.b(AEEditorImageEditFragment.e(), "perf: image export cost = " + (AEEditorImageEditFragment.a(this.a) - AEEditorImageEditFragment.b(this.a)) + "ms");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.20.2(this));
  }
  
  public void onFailed(Collection<String> paramCollection)
  {
    bpam.d(AEEditorImageEditFragment.e(), "images export failed");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.20.1(this, paramCollection));
  }
  
  public void onImageExport(String paramString)
  {
    bpam.b(AEEditorImageEditFragment.e(), "image export, path = " + paramString);
    if (AEEditorImageEditFragment.a(this.a) == null) {
      return;
    }
    Object localObject = AEEditorImageEditFragment.a(this.a).getMediaModels();
    if (((List)localObject).get(AEEditorImageEditFragment.a(this.a).size()) != null)
    {
      bozv.a().a().jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a).size()), Integer.valueOf(((MediaModel)((List)localObject).get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList().size()));
      localObject = ((MediaModel)((List)localObject).get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList();
      int i = AEEditorImageEditFragment.a(this.a).size();
      if (!CollectionUtil.isEmptyList((List)localObject)) {
        this.a.a((List)localObject, i);
      }
      localObject = bozv.a((String)AEEditorImageEditFragment.a(this.a).get(i));
      bozv.a().a().jdField_c_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    bozr.a().b(AEEditorImageEditFragment.a(this.a).size());
    AEEditorImageEditFragment.a(this.a).add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgm
 * JD-Core Version:    0.7.0.1
 */