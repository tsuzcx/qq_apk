import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class bfgm
  extends bfgl
{
  private TextView a;
  private View b;
  
  protected bfgm(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379851));
    this.b = ((ImageView)paramView.findViewById(2131369081));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bfgj parambfgj)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379851: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (bfeo)parambfgj.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = bkho.d(paramView.getContext());
      paramView.a(new bfgn(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(anni.a(2131712020));
      }
      paramView.c(anni.a(2131712019));
      paramView.d(anni.a(2131712017));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(parambfgj);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bfgj parambfgj, bfeo parambfeo, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambfeo.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(anni.a(2131712018)).append(parambfeo.b);
      if ((parambfeo.a != null) && (!parambfeo.a.isEmpty())) {
        localStringBuilder.append(bfds.a(parambfeo.a));
      }
      parambfeo.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambfeo.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, parambfgj);
      paramHWReciteItem.b(this.b, parambfgj);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgm
 * JD-Core Version:    0.7.0.1
 */