import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.16.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.16.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.16.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bmhy
  implements bmfk
{
  public bmhy(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, bmgl parambmgl)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.16.1(this, parambmgl));
    }
    if (paramInt == 0)
    {
      bmbx.b("AEEditorImageEditFragment", "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.16.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label105;
      }
    }
    label105:
    bmgu localbmgu;
    do
    {
      do
      {
        return;
        bmbx.b("AEEditorImageEditFragment", "onAIFilterAppliedFailed:" + paramInt);
        ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.16.2(this));
        break;
      } while (parambmgl == null);
      AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(AEEditorImageEditFragment.a(this.a)), parambmgl);
      AEEditorImageEditFragment.a(this.a).put(String.valueOf(AEEditorImageEditFragment.a(this.a)), this.a.a(parambmgl));
      localbmgu = (bmgu)parambmgl;
    } while (localbmgu == null);
    AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), parambmgl);
    AEEditorImageEditFragment.a(this.a).resetAEKitModelForAI(AEEditorImageEditFragment.a(this.a), localbmgu.jdField_b_of_type_JavaLangString, localbmgu.jdField_a_of_type_Float, localbmgu.jdField_a_of_type_JavaUtilHashMap, (int)(localbmgu.c * 100.0F), localbmgu.jdField_b_of_type_Float);
    this.a.a(new String[] { "智能滤镜label", localbmgu.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    parambmgl = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localbmgu.jdField_a_of_type_JavaLangString)) {
        break label423;
      }
      parambmgl = localNewEnhanceCategories.filterType;
    }
    label423:
    for (;;)
    {
      break;
      bmbg.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), "effect_aieffect_" + parambmgl);
      bmbg.a().a().b.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), Float.valueOf(-1.0F));
      AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), "effect_aieffect");
      return;
    }
  }
  
  public void aD_()
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "资源下载中，请稍后再试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhy
 * JD-Core Version:    0.7.0.1
 */