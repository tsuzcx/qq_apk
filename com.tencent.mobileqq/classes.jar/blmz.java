import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.8.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.8.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.8.3;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class blmz
  implements blkn
{
  public blmz(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, bllj parambllj)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.8.1(this, parambllj));
    }
    if (paramInt == 0)
    {
      bljn.b(AEEditorImageEditFragment.e(), "onAIFilterApplySuccess:");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.8.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label107;
      }
    }
    label107:
    while (parambllj == null)
    {
      return;
      bljn.b(AEEditorImageEditFragment.e(), "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.8.2(this));
      break;
    }
    parambllj = (blll)parambllj;
    if (parambllj != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = 0;
      if (paramInt < AEEditorImageEditFragment.b(this.a))
      {
        if (paramInt == AEEditorImageEditFragment.a(this.a)) {
          localStringBuilder.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)).a() + "(当前图)|");
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if ((AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)) != null) && (((bllo)parambllj.a.get(paramInt)).a))
          {
            AEEditorImageEditFragment.a(this.a).a(paramInt, AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)));
            localStringBuilder.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)).a() + "(err)|");
          }
          else
          {
            AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt), (bllj)parambllj.a.get(paramInt));
            AEEditorImageEditFragment.a(this.a).put(String.valueOf(paramInt), this.a.a((bllj)parambllj.a.get(paramInt)));
            AEEditorImageEditFragment.a(this.a).a(paramInt, (bllj)parambllj.a.get(paramInt));
            localStringBuilder.append(((bllo)parambllj.a.get(paramInt)).a() + "|");
          }
        }
      }
      this.a.a("智能滤镜label", localStringBuilder.toString());
    }
    AEEditorImageEditFragment.b(this.a, AEEditorImageEditFragment.a(this.a));
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
 * Qualified Name:     blmz
 * JD-Core Version:    0.7.0.1
 */