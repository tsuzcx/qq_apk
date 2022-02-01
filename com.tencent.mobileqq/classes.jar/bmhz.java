import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.17.1;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.17.2;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.17.3;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class bmhz
  implements bmfk
{
  public bmhz(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, bmgl parambmgl)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.17.1(this, parambmgl));
    }
    if (paramInt == 0)
    {
      bmbx.b("AEEditorImageEditFragment", "onAIFilterApplySuccess:");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.17.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label105;
      }
    }
    label105:
    while (parambmgl == null)
    {
      return;
      bmbx.b("AEEditorImageEditFragment", "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.17.2(this));
      break;
    }
    parambmgl = (bmgn)parambmgl;
    if (parambmgl != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = 0;
      if (paramInt < AEEditorImageEditFragment.b(this.a))
      {
        if (paramInt == AEEditorImageEditFragment.a(this.a)) {
          localStringBuilder.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt)).a() + "(当前图)|");
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if ((AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt)) != null) && (((bmgu)parambmgl.a.get(paramInt)).a))
          {
            AEEditorImageEditFragment.a(this.a).a(paramInt, AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt)));
            localStringBuilder.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt)).a() + "(err)|");
          }
          else
          {
            AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt), (bmgl)parambmgl.a.get(paramInt));
            AEEditorImageEditFragment.a(this.a).put(String.valueOf(paramInt), this.a.a((bmgl)parambmgl.a.get(paramInt)));
            AEEditorImageEditFragment.a(this.a).a(paramInt, (bmgl)parambmgl.a.get(paramInt));
            localStringBuilder.append(((bmgu)parambmgl.a.get(paramInt)).a() + "|");
          }
        }
      }
      this.a.a("智能滤镜label", localStringBuilder.toString());
    }
    AEEditorImageEditFragment.c(this.a, AEEditorImageEditFragment.a(this.a));
    AEEditorImageEditFragment.d(this.a, AEEditorImageEditFragment.a(this.a));
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
 * Qualified Name:     bmhz
 * JD-Core Version:    0.7.0.1
 */