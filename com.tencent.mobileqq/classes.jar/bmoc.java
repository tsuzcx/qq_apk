import android.view.View;
import android.view.View.OnFocusChangeListener;
import dov.com.qq.im.capture.text.DynamicTextItem;

class bmoc
  implements View.OnFocusChangeListener
{
  bmoc(bmnw parambmnw) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.a(this.a.a.b(), true);
    }
    wsv.b("EditTextDialog", "onFocusChange:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoc
 * JD-Core Version:    0.7.0.1
 */