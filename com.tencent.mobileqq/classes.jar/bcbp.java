import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class bcbp
  extends bcbo
{
  private TextView a;
  private View b;
  
  protected bcbp(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378900));
    this.b = ((ImageView)paramView.findViewById(2131368728));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bcbm parambcbm)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131378900: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (bbzr)parambcbm.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = bhpy.d(paramView.getContext());
      paramView.a(new bcbq(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(alpo.a(2131713629));
      }
      paramView.c(alpo.a(2131713628));
      paramView.d(alpo.a(2131713626));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(parambcbm);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bcbm parambcbm, bbzr parambbzr, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambbzr.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(alpo.a(2131713627)).append(parambbzr.b);
      if ((parambbzr.a != null) && (!parambbzr.a.isEmpty())) {
        localStringBuilder.append(bbyv.a(parambbzr.a));
      }
      parambbzr.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambbzr.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, parambcbm);
      paramHWReciteItem.b(this.b, parambcbm);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbp
 * JD-Core Version:    0.7.0.1
 */