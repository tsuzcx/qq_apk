import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class badg
  extends badf
{
  private TextView a;
  private View b;
  
  protected badg(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378315));
    this.b = ((ImageView)paramView.findViewById(2131368532));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, badd parambadd)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131378315: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (babi)parambadd.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = bfpc.d(paramView.getContext());
      paramView.a(new badh(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(ajya.a(2131713257));
      }
      paramView.c(ajya.a(2131713256));
      paramView.d(ajya.a(2131713254));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(parambadd);
  }
  
  public void a(HWReciteItem paramHWReciteItem, badd parambadd, babi parambabi, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambabi.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(ajya.a(2131713255)).append(parambabi.b);
      if ((parambabi.a != null) && (!parambabi.a.isEmpty())) {
        localStringBuilder.append(baam.a(parambabi.a));
      }
      parambabi.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambabi.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, parambadd);
      paramHWReciteItem.b(this.b, parambadd);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     badg
 * JD-Core Version:    0.7.0.1
 */