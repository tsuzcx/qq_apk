import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.2.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhfm
  implements View.OnClickListener
{
  public bhfm(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Bhfn.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Bhfn.getWindowToken(), 0);
    boolean bool;
    if ((this.a.jdField_a_of_type_Bhfn.getAdapter() != null) && (this.a.jdField_a_of_type_Bhfn.getAdapter().getCount() > 0))
    {
      int i = this.a.jdField_a_of_type_Bhfn.getAdapter().getCount();
      if (i >= 5) {
        break label334;
      }
      int j = AIOUtils.dp2px(7.5F, this.a.getResources());
      int k = AIOUtils.dp2px(40.0F, this.a.getResources());
      this.a.jdField_a_of_type_Bhfn.setDropDownHeight(i * (j * 2 + k) + j * 2);
      Object localObject = ((ImageView)paramView).getDrawable();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("arrow clicked, drawable is down=");
        if (localObject != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
          break label359;
        }
        bool = true;
        label177:
        QLog.d("NewStyleDropdownView", 2, bool + ", isLastDropDown=" + this.a.jdField_a_of_type_Boolean);
      }
      if ((localObject != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) || (this.a.jdField_a_of_type_Boolean)) {
        break label365;
      }
      if (this.a.jdField_a_of_type_Bhfo != null) {
        this.a.jdField_a_of_type_Bhfo.c(false);
      }
      NewStyleDropdownView.a(this.a).postDelayed(new NewStyleDropdownView.2.1(this, paramView), 500L);
      localObject = paramView.getContext();
      if ((localObject != null) && ((localObject instanceof LoginActivity))) {
        bcef.a(((LoginActivity)localObject).app, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label334:
      this.a.jdField_a_of_type_Bhfn.setDropDownHeight(AIOUtils.dp2px(251.5F, this.a.getResources()));
      break;
      label359:
      bool = false;
      break label177;
      label365:
      if (this.a.jdField_a_of_type_Bhfo != null) {
        this.a.jdField_a_of_type_Bhfo.c(true);
      }
      this.a.jdField_a_of_type_Bhfn.dismissDropDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhfm
 * JD-Core Version:    0.7.0.1
 */