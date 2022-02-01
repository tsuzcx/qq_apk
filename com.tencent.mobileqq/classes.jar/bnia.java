import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.poi.AESelectLocationFragment;

class bnia
  implements View.OnClickListener
{
  bnia(bnhy parambnhy) {}
  
  public void onClick(View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)AEModule.getContext().getSystemService("input_method");
    if (bnhy.a(this.a) != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(bnhy.a(this.a).getWindowToken(), 0);
      bnhy.a(this.a, bnhy.a(this.a));
      bnhy.a(this.a).setTextColor(-1);
    }
    if (bnhy.a(this.a) != null) {
      bnhy.a(this.a).b();
    }
    AESelectLocationFragment.a(bnhy.a(this.a), 203);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnia
 * JD-Core Version:    0.7.0.1
 */