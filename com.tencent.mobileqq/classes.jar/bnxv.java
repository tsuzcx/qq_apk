import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.exporter.ImageExporter.ImageExportCallback;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.21.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.21.2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class bnxv
  implements ImageExporter.ImageExportCallback
{
  public bnxv(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onCancelled() {}
  
  public void onExportComplete()
  {
    bnrh.b("AEEditorImageEditFragment", "images export complete");
    AEEditorImageEditFragment.a(this.a, System.currentTimeMillis());
    bnrh.b("AEEditorImageEditFragment", "perf: image export cost = " + (AEEditorImageEditFragment.a(this.a) - AEEditorImageEditFragment.b(this.a)) + "ms");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.21.2(this));
  }
  
  public void onFailed(Collection<String> paramCollection)
  {
    bnrh.d("AEEditorImageEditFragment", "images export failed");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.21.1(this, paramCollection));
  }
  
  public void onImageExport(String paramString)
  {
    bnrh.b("AEEditorImageEditFragment", "image export, path = " + paramString);
    if (AEEditorImageEditFragment.a(this.a) == null) {
      return;
    }
    Object localObject = AEEditorImageEditFragment.a(this.a).getMediaModels();
    if (((List)localObject).get(AEEditorImageEditFragment.a(this.a).size()) != null)
    {
      bnqq.a().a().jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a).size()), Integer.valueOf(((MediaModel)((List)localObject).get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList().size()));
      localObject = ((MediaModel)((List)localObject).get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList();
      int i = AEEditorImageEditFragment.a(this.a).size();
      if (!CollectionUtil.isEmptyList((List)localObject)) {
        this.a.a((List)localObject, i);
      }
      localObject = bnqq.a((String)AEEditorImageEditFragment.a(this.a).get(i));
      bnqq.a().a().jdField_c_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    bnqm.a().b(AEEditorImageEditFragment.a(this.a).size());
    AEEditorImageEditFragment.a(this.a).add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxv
 * JD-Core Version:    0.7.0.1
 */