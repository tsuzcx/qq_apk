import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class bepo
  extends bepn
{
  private TextView a;
  private View b;
  
  protected bepo(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379788));
    this.b = ((ImageView)paramView.findViewById(2131369194));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bepl parambepl)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131379788: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (benq)parambepl.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = bjnw.d(paramView.getContext());
      paramView.a(new bepp(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(amtj.a(2131712361));
      }
      paramView.c(amtj.a(2131712360));
      paramView.d(amtj.a(2131712358));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(parambepl);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bepl parambepl, benq parambenq, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambenq.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(amtj.a(2131712359)).append(parambenq.b);
      if ((parambenq.a != null) && (!parambenq.a.isEmpty())) {
        localStringBuilder.append(bemu.a(parambenq.a));
      }
      parambenq.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambenq.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, parambepl);
      paramHWReciteItem.b(this.b, parambepl);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepo
 * JD-Core Version:    0.7.0.1
 */