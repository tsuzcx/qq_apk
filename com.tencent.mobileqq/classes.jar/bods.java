import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.timeline.TimelineView.SpeedChangeCallback;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

public class bods
  implements TimelineView.SpeedChangeCallback
{
  public bods(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void onChangeFailed(int paramInt) {}
  
  public void onChangeSucc(float paramFloat)
  {
    this.a.jdField_a_of_type_JavaLangFloat = Float.valueOf(this.a.jdField_a_of_type_Float);
    AEEditorVideoClipFragment.a(this.a).setSpeed(paramFloat, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bods
 * JD-Core Version:    0.7.0.1
 */