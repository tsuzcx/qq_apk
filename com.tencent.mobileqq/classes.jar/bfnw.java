import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class bfnw
  extends blir
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bfqm jdField_a_of_type_Bfqm = (bfqm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
  bfqv jdField_a_of_type_Bfqv;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public bfnw(Activity paramActivity, bfqv parambfqv)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bfqv = parambfqv;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      bfny localbfny = (bfny)paramView.getTag();
      this.jdField_a_of_type_Bfqm.a(localbfny.a);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, "" + this.jdField_a_of_type_Bfqm.a().d, "" + this.jdField_a_of_type_Int, "", "");
      this.jdField_a_of_type_Bfqm.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (2131365201 == paramView.getId())
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1500L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Bfqm.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bfqv);
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, "" + this.jdField_a_of_type_Bfqm.a().d, "" + this.jdField_a_of_type_Int, "", "");
      }
      else if (2131364593 == paramView.getId())
      {
        this.jdField_a_of_type_Bfqm.a();
        dismiss();
      }
    }
  }
  
  public void show()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560597, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      localLinearLayout.setBackgroundColor(-15921907);
    }
    a(localLinearLayout);
    Object localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localLinearLayout.findViewById(2131377202));
    localObject = (bfqm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if ((((bfqm)localObject).a == null) || (((bfqm)localObject).a.size() == 0))
    {
      dismiss();
      ((bfqm)localObject).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    localObject = new bfnx(this, ((bfqm)localObject).a);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setMaxHeight(agej.a(200.0F, getContext().getResources()));
    this.jdField_a_of_type_AndroidViewView = localLinearLayout.findViewById(2131365201);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    int i = this.jdField_a_of_type_Bfqm.a.size();
    localObject = String.format(anzj.a(2131706444), new Object[] { Integer.valueOf(i) });
    ((TextView)localLinearLayout.findViewById(2131376607)).setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_Bfqm.a();
    this.jdField_a_of_type_Int = (((bfqw)localObject).a.size() - 1);
    String str = String.format(anzj.a(2131706450), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377286)).setText(str);
    ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379491)).setText(((bfqw)localObject).c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localLinearLayout.findViewById(2131364593));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    super.show();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, "" + ((bfqw)localObject).d, "" + this.jdField_a_of_type_Int, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnw
 * JD-Core Version:    0.7.0.1
 */