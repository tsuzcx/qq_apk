import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu;

public class bodp
  implements TimelineView.SpeedChangeCallback
{
  public bodp(AEEditorMvClipMenu paramAEEditorMvClipMenu, float paramFloat, TimelineView.SpeedChangeCallback paramSpeedChangeCallback) {}
  
  public void onChangeFailed(int paramInt)
  {
    this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView$SpeedChangeCallback.onChangeFailed(paramInt);
  }
  
  public void onChangeSucc(float paramFloat)
  {
    ImageView localImageView = AEEditorMvClipMenu.a(this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu);
    Resources localResources = this.jdField_a_of_type_DovComQqImAeeditorModuleClipVideoAEEditorMvClipMenu.getContext().getResources();
    if (this.jdField_a_of_type_Float == 1.0F) {}
    for (int i = 2130837732;; i = 2130837733)
    {
      localImageView.setImageDrawable(localResources.getDrawable(i));
      this.jdField_a_of_type_ComTencentTavcutTimelineTimelineView$SpeedChangeCallback.onChangeSucc(paramFloat);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodp
 * JD-Core Version:    0.7.0.1
 */