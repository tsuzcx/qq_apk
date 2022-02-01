import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.15.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.15.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.15.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bpgh
  implements bpdz
{
  public bpgh(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, bpez parambpez)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.15.1(this, parambpez));
    }
    if (paramInt == 0)
    {
      bpam.b(AEEditorImageEditFragment.e(), "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.15.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label107;
      }
    }
    label107:
    bpfe localbpfe;
    do
    {
      do
      {
        return;
        bpam.b(AEEditorImageEditFragment.e(), "onAIFilterAppliedFailed:" + paramInt);
        ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.15.2(this));
        break;
      } while (parambpez == null);
      AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(AEEditorImageEditFragment.a(this.a)), parambpez);
      AEEditorImageEditFragment.a(this.a).put(String.valueOf(AEEditorImageEditFragment.a(this.a)), this.a.a(parambpez));
      localbpfe = (bpfe)parambpez;
    } while (localbpfe == null);
    AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), parambpez);
    AEEditorImageEditFragment.a(this.a).resetAEKitModelForAI(AEEditorImageEditFragment.a(this.a), localbpfe.jdField_b_of_type_JavaLangString, localbpfe.jdField_a_of_type_Float, localbpfe.jdField_a_of_type_JavaUtilHashMap, (int)(localbpfe.c * 100.0F), localbpfe.jdField_b_of_type_Float);
    this.a.a(new String[] { "智能滤镜label", localbpfe.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    parambpez = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localbpfe.jdField_a_of_type_JavaLangString)) {
        break label425;
      }
      parambpez = localNewEnhanceCategories.filterType;
    }
    label425:
    for (;;)
    {
      break;
      bozv.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), "effect_aieffect_" + parambpez);
      bozv.a().a().b.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), Float.valueOf(-1.0F));
      AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), "effect_aieffect");
      return;
    }
  }
  
  public void aS_()
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "资源下载中，请稍后再试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgh
 * JD-Core Version:    0.7.0.1
 */