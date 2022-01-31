import android.view.View;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.Pair;

public class amxr
  implements Runnable
{
  public amxr(DynamicTextItem paramDynamicTextItem, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    DynamicTextItem.Pair localPair;
    if (((Boolean)DynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem).b).booleanValue() != this.jdField_a_of_type_Boolean)
    {
      localPair = DynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
      if (((Boolean)DynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem).b).booleanValue()) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      localPair.b = Boolean.valueOf(bool);
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      DynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amxr
 * JD-Core Version:    0.7.0.1
 */