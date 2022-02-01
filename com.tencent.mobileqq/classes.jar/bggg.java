import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class bggg
  extends bggf
{
  private TextView a;
  private View b;
  
  protected bggg(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380031));
    this.b = ((ImageView)paramView.findViewById(2131369171));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bggd parambggd)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380031: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (bgei)parambggd.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = blir.d(paramView.getContext());
      paramView.a(new bggh(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(anzj.a(2131712129));
      }
      paramView.c(anzj.a(2131712128));
      paramView.d(anzj.a(2131712126));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(parambggd);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bggd parambggd, bgei parambgei, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambgei.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(anzj.a(2131712127)).append(parambgei.b);
      if ((parambgei.a != null) && (!parambgei.a.isEmpty())) {
        localStringBuilder.append(bgdm.a(parambgei.a));
      }
      parambgei.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambgei.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, parambggd);
      paramHWReciteItem.b(this.b, parambggd);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggg
 * JD-Core Version:    0.7.0.1
 */