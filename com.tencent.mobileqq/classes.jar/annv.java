import android.view.View;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.Pair;

public class annv
  implements Runnable
{
  public annv(DynamicTextItem paramDynamicTextItem, View paramView) {}
  
  public void run()
  {
    DynamicTextItem.Pair localPair = DynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
    if (!((Boolean)DynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem).b).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      localPair.b = Boolean.valueOf(bool);
      this.jdField_a_of_type_AndroidViewView.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     annv
 * JD-Core Version:    0.7.0.1
 */