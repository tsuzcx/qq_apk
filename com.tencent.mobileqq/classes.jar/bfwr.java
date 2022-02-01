import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class bfwr
  extends bfwq
{
  private TextView a;
  private View b;
  
  protected bfwr(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380111));
    this.b = ((ImageView)paramView.findViewById(2131369356));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bfwo parambfwo)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380111: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (bfut)parambfwo.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = bkzi.d(paramView.getContext());
      paramView.a(new bfws(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(anvx.a(2131712708));
      }
      paramView.c(anvx.a(2131712707));
      paramView.d(anvx.a(2131712705));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(parambfwo);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bfwo parambfwo, bfut parambfut, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambfut.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(anvx.a(2131712706)).append(parambfut.b);
      if ((parambfut.a != null) && (!parambfut.a.isEmpty())) {
        localStringBuilder.append(bftx.a(parambfut.a));
      }
      parambfut.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambfut.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, parambfwo);
      paramHWReciteItem.b(this.b, parambfwo);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwr
 * JD-Core Version:    0.7.0.1
 */