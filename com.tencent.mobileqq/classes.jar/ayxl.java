import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.widget.ThemeImageView;

public class ayxl
  extends ayxt
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TroopActiveLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout;
  private TroopLabelLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  private FolderTextView jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView;
  public ImageView b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TroopLabelLayout jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View e;
  private View f;
  
  public ayxl(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_c_of_type_Int = 2131559695;
    }
    for (;;)
    {
      paramViewGroup.getResources();
      LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
      localLinearLayout.setOrientation(1);
      localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(this.jdField_c_of_type_Int, null, false), new LinearLayout.LayoutParams(-1, -2));
      localLinearLayout.setClickable(true);
      localLinearLayout.setFocusable(true);
      this.jdField_b_of_type_AndroidViewView = localLinearLayout;
      a();
      return;
      this.jdField_c_of_type_Int = 2131560242;
      continue;
      this.jdField_c_of_type_Int = 2131559662;
      continue;
      this.jdField_c_of_type_Int = 2131561109;
      continue;
      this.jdField_c_of_type_Int = 2131561110;
    }
  }
  
  public View a(String paramString)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramString)) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return this.e;
    }
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout;
    }
    if ("ActiveEntitySearchResultPresenter_expand_desc".equals(paramString)) {
      return this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView;
    }
    return super.a(paramString);
  }
  
  public TroopLabelLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367819));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131364893));
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131364809);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setTag("ActiveEntitySearchResultPresenter_add_troop");
      }
      this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131372285);
      if (this.e != null)
      {
        this.e.setTag("ActiveEntitySearchResultPresenter_pay_troop");
        if ((this.e instanceof ThemeImageView)) {
          ((ThemeImageView)this.e).setMaskShape(bibv.jdField_c_of_type_Int);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131361948));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setTag("ActiveEntitySearchResultPresenter_hot_troop");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366620));
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setTag("ActiveEntitySearchResultPresenter_expand_desc");
      }
      return;
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131375716));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375726));
      this.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378430));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370121));
      this.f = this.jdField_b_of_type_AndroidViewView.findViewById(2131378980);
      continue;
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378344));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378304));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378430));
      if (this.h != null)
      {
        TextView localTextView = this.h;
        int j = azkz.jdField_a_of_type_Int - azkz.a(187.0F);
        int i = j;
        if (j <= 0) {
          i = azkz.a(220.0F);
        }
        localTextView.setMaxWidth(i);
      }
    }
  }
  
  public View b()
  {
    return this.f;
  }
  
  public TroopLabelLayout b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  }
  
  public ImageView c()
  {
    return this.jdField_c_of_type_AndroidWidgetImageView;
  }
  
  public TextView e()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public TextView f()
  {
    return this.jdField_a_of_type_AndroidWidgetButton;
  }
  
  public TextView g()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public TextView h()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxl
 * JD-Core Version:    0.7.0.1
 */