import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.3.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.3.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.3.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class blij
  implements blgg
{
  public blij(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, blhb paramblhb)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.3.1(this, paramblhb));
    }
    if (paramInt == 0)
    {
      blfg.b(AEEditorImageEditFragment.e(), "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.3.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label107;
      }
    }
    label107:
    blhf localblhf;
    do
    {
      do
      {
        return;
        blfg.b(AEEditorImageEditFragment.e(), "onAIFilterAppliedFailed:" + paramInt);
        ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.3.2(this));
        break;
      } while (paramblhb == null);
      AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(AEEditorImageEditFragment.a(this.a)), paramblhb);
      AEEditorImageEditFragment.a(this.a).put(String.valueOf(AEEditorImageEditFragment.a(this.a)), this.a.a(paramblhb));
      localblhf = (blhf)paramblhb;
    } while (localblhf == null);
    AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), paramblhb);
    AEEditorImageEditFragment.a(this.a).setAEKitAIFilter(AEEditorImageEditFragment.a(this.a), localblhf.jdField_b_of_type_JavaLangString, localblhf.jdField_a_of_type_Float, localblhf.jdField_a_of_type_JavaUtilHashMap, (int)(localblhf.c * 100.0F), localblhf.jdField_b_of_type_Float);
    this.a.a(new String[] { "智能滤镜label", localblhf.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    paramblhb = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localblhf.jdField_a_of_type_JavaLangString)) {
        break label406;
      }
      paramblhb = localNewEnhanceCategories.filterType;
    }
    label406:
    for (;;)
    {
      break;
      bler.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), "lut_aieffect_" + paramblhb);
      bler.a().a().b.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), Float.valueOf(-1.0F));
      return;
    }
  }
  
  public void aX_()
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "资源下载中，请稍后再试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blij
 * JD-Core Version:    0.7.0.1
 */