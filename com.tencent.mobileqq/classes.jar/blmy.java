import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class blmy
  implements blkn
{
  public blmy(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, bllj parambllj)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.7.1(this, parambllj));
    }
    if (paramInt == 0)
    {
      bljn.b(AEEditorImageEditFragment.e(), "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.7.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label107;
      }
    }
    label107:
    bllo localbllo;
    do
    {
      do
      {
        return;
        bljn.b(AEEditorImageEditFragment.e(), "onAIFilterAppliedFailed:" + paramInt);
        ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.7.2(this));
        break;
      } while (parambllj == null);
      AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(AEEditorImageEditFragment.a(this.a)), parambllj);
      AEEditorImageEditFragment.a(this.a).put(String.valueOf(AEEditorImageEditFragment.a(this.a)), this.a.a(parambllj));
      localbllo = (bllo)parambllj;
    } while (localbllo == null);
    AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), parambllj);
    AEEditorImageEditFragment.a(this.a).setOverlayImage(AEEditorImageEditFragment.a(this.a), null);
    AEEditorImageEditFragment.a(this.a).setAEKitAIFilter(AEEditorImageEditFragment.a(this.a), localbllo.jdField_b_of_type_JavaLangString, localbllo.jdField_a_of_type_Float, localbllo.jdField_a_of_type_JavaUtilHashMap, (int)(localbllo.c * 100.0F), localbllo.jdField_b_of_type_Float);
    this.a.a(new String[] { "智能滤镜label", localbllo.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    parambllj = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localbllo.jdField_a_of_type_JavaLangString)) {
        break label424;
      }
      parambllj = localNewEnhanceCategories.filterType;
    }
    label424:
    for (;;)
    {
      break;
      bliy.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), "lut_aieffect_" + parambllj);
      bliy.a().a().b.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), Float.valueOf(-1.0F));
      return;
    }
  }
  
  public void aU_()
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "资源下载中，请稍后再试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmy
 * JD-Core Version:    0.7.0.1
 */