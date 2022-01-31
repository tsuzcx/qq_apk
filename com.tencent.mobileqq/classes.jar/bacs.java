import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class bacs
  extends bacr
{
  private TextView a;
  private View b;
  
  protected bacs(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378312));
    this.b = ((ImageView)paramView.findViewById(2131368533));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bacp parambacp)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131378312: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (baau)parambacp.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = bfol.d(paramView.getContext());
      paramView.a(new bact(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(ajyc.a(2131713246));
      }
      paramView.c(ajyc.a(2131713245));
      paramView.d(ajyc.a(2131713243));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(parambacp);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bacp parambacp, baau parambaau, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambaau.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(ajyc.a(2131713244)).append(parambaau.b);
      if ((parambaau.a != null) && (!parambaau.a.isEmpty())) {
        localStringBuilder.append(azzy.a(parambaau.a));
      }
      parambaau.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambaau.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, parambacp);
      paramHWReciteItem.b(this.b, parambacp);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacs
 * JD-Core Version:    0.7.0.1
 */