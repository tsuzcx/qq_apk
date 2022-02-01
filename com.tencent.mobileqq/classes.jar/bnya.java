import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;

public class bnya
  implements View.OnClickListener
{
  public bnya(AEEditorImageEditFragment paramAEEditorImageEditFragment, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      bnqu.a().a("ae_editor_tool_bar_red_dot_frame", true, 0);
      View localView = AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment).findViewById(2131376768);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    if (AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment).getVisibility() == 0) {
      AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AEEditorImageEditFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment);
      bnqm.a().v();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnya
 * JD-Core Version:    0.7.0.1
 */