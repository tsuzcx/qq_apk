import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.qq.im.poi.LbsPackPoiListActivity;

public class anl
  implements DialogInterface.OnDismissListener
{
  public anl(LbsPackPoiListActivity paramLbsPackPoiListActivity, int paramInt, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LbsPackPoiListActivity.a(this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity, false);
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.b.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.a.setVisibility(0);
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.b.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComQqImPoiLbsPackPoiListActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anl
 * JD-Core Version:    0.7.0.1
 */