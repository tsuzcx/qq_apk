import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class bcfy
  extends bcfx
{
  private TextView a;
  private View b;
  
  protected bcfy(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378957));
    this.b = ((ImageView)paramView.findViewById(2131368742));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bcfv parambcfv)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131378957: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (bcea)parambcfv.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = bhuf.d(paramView.getContext());
      paramView.a(new bcfz(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(alud.a(2131713641));
      }
      paramView.c(alud.a(2131713640));
      paramView.d(alud.a(2131713638));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(parambcfv);
  }
  
  public void a(HWReciteItem paramHWReciteItem, bcfv parambcfv, bcea parambcea, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambcea.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(alud.a(2131713639)).append(parambcea.b);
      if ((parambcea.a != null) && (!parambcea.a.isEmpty())) {
        localStringBuilder.append(bcde.a(parambcea.a));
      }
      parambcea.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambcea.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, parambcfv);
      paramHWReciteItem.b(this.b, parambcfv);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfy
 * JD-Core Version:    0.7.0.1
 */