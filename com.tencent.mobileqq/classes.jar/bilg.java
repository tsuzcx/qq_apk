import android.view.View;
import android.view.View.OnFocusChangeListener;
import dov.com.qq.im.capture.text.DynamicTextItem;

class bilg
  implements View.OnFocusChangeListener
{
  bilg(bila parambila) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.a(this.a.a.b(), true);
    }
    urk.b("EditTextDialog", "onFocusChange:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilg
 * JD-Core Version:    0.7.0.1
 */