import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class azca
  extends azbz
{
  private TextView a;
  private View b;
  
  protected azca(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312486));
    this.b = ((ImageView)paramView.findViewById(2131302908));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, azbx paramazbx)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131312486: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (azac)paramazbx.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.a != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.a.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = begr.d(paramView.getContext());
      paramView.a(new azcb(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.c(ajjy.a(2131647458));
      }
      paramView.c(ajjy.a(2131647457));
      paramView.d(ajjy.a(2131647455));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().a(paramazbx);
  }
  
  public void a(HWReciteItem paramHWReciteItem, azbx paramazbx, azac paramazac, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(paramazac.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(ajjy.a(2131647456)).append(paramazac.b);
      if ((paramazac.a != null) && (!paramazac.a.isEmpty())) {
        localStringBuilder.append(ayzg.a(paramazac.a));
      }
      paramazac.c = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramazac.c);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.jdField_a_of_type_AndroidWidgetTextView, paramazbx);
      paramHWReciteItem.b(this.b, paramazbx);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azca
 * JD-Core Version:    0.7.0.1
 */