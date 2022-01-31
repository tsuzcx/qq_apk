import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.4.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.4.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.4.3;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class blik
  implements blgg
{
  public blik(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, blhb paramblhb)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.4.1(this, paramblhb));
    }
    if (paramInt == 0)
    {
      blfg.b(AEEditorImageEditFragment.e(), "onAIFilterApplySuccess:");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.4.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label107;
      }
    }
    label107:
    while (paramblhb == null)
    {
      return;
      blfg.b(AEEditorImageEditFragment.e(), "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.4.2(this));
      break;
    }
    paramblhb = (blhd)paramblhb;
    if (paramblhb != null)
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
          if ((AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)) != null) && (((blhf)paramblhb.a.get(paramInt)).a))
          {
            AEEditorImageEditFragment.a(this.a).a(paramInt, AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)));
            localStringBuilder.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt)).a() + "(err)|");
          }
          else
          {
            AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.a(this.a).get(paramInt), (blhb)paramblhb.a.get(paramInt));
            AEEditorImageEditFragment.a(this.a).put(String.valueOf(paramInt), this.a.a((blhb)paramblhb.a.get(paramInt)));
            AEEditorImageEditFragment.a(this.a).a(paramInt, (blhb)paramblhb.a.get(paramInt));
            localStringBuilder.append(((blhf)paramblhb.a.get(paramInt)).a() + "|");
          }
        }
      }
      this.a.a("智能滤镜label", localStringBuilder.toString());
    }
    AEEditorImageEditFragment.b(this.a, AEEditorImageEditFragment.a(this.a));
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
 * Qualified Name:     blik
 * JD-Core Version:    0.7.0.1
 */