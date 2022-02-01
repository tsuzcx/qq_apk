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

public class boem
  implements boce
{
  public boem(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, bode parambode)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.15.1(this, parambode));
    }
    if (paramInt == 0)
    {
      bnzb.b(AEEditorImageEditFragment.e(), "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.15.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label107;
      }
    }
    label107:
    bodj localbodj;
    do
    {
      do
      {
        return;
        bnzb.b(AEEditorImageEditFragment.e(), "onAIFilterAppliedFailed:" + paramInt);
        ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.15.2(this));
        break;
      } while (parambode == null);
      AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(AEEditorImageEditFragment.a(this.a)), parambode);
      AEEditorImageEditFragment.a(this.a).put(String.valueOf(AEEditorImageEditFragment.a(this.a)), this.a.a(parambode));
      localbodj = (bodj)parambode;
    } while (localbodj == null);
    AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), parambode);
    AEEditorImageEditFragment.a(this.a).resetAEKitModelForAI(AEEditorImageEditFragment.a(this.a), localbodj.jdField_b_of_type_JavaLangString, localbodj.jdField_a_of_type_Float, localbodj.jdField_a_of_type_JavaUtilHashMap, (int)(localbodj.c * 100.0F), localbodj.jdField_b_of_type_Float);
    this.a.a(new String[] { "智能滤镜label", localbodj.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    parambode = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localbodj.jdField_a_of_type_JavaLangString)) {
        break label425;
      }
      parambode = localNewEnhanceCategories.filterType;
    }
    label425:
    for (;;)
    {
      break;
      bnyl.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), "effect_aieffect_" + parambode);
      bnyl.a().a().b.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), Float.valueOf(-1.0F));
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
 * Qualified Name:     boem
 * JD-Core Version:    0.7.0.1
 */