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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class bfej
  extends bkzi
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bfgz jdField_a_of_type_Bfgz = (bfgz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_TROOP_CREATE);
  bfhi jdField_a_of_type_Bfhi;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public bfej(Activity paramActivity, bfhi parambfhi)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bfhi = parambfhi;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      bfel localbfel = (bfel)paramView.getTag();
      this.jdField_a_of_type_Bfgz.a(localbfel.a);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, "" + this.jdField_a_of_type_Bfgz.a().d, "" + this.jdField_a_of_type_Int, "", "");
      this.jdField_a_of_type_Bfgz.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (2131365317 == paramView.getId())
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1500L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Bfgz.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bfhi);
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, "" + this.jdField_a_of_type_Bfgz.a().d, "" + this.jdField_a_of_type_Int, "", "");
      }
      else if (2131364708 == paramView.getId())
      {
        this.jdField_a_of_type_Bfgz.a();
        dismiss();
      }
    }
  }
  
  public void show()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560659, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      localLinearLayout.setBackgroundColor(-15921907);
    }
    a(localLinearLayout);
    Object localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localLinearLayout.findViewById(2131377223));
    localObject = (bfgz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_TROOP_CREATE);
    if ((((bfgz)localObject).a == null) || (((bfgz)localObject).a.size() == 0))
    {
      dismiss();
      ((bfgz)localObject).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    localObject = new bfek(this, ((bfgz)localObject).a);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setMaxHeight(AIOUtils.dp2px(200.0F, getContext().getResources()));
    this.jdField_a_of_type_AndroidViewView = localLinearLayout.findViewById(2131365317);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    int i = this.jdField_a_of_type_Bfgz.a.size();
    localObject = String.format(anvx.a(2131707026), new Object[] { Integer.valueOf(i) });
    ((TextView)localLinearLayout.findViewById(2131376628)).setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_Bfgz.a();
    this.jdField_a_of_type_Int = (((bfhj)localObject).a.size() - 1);
    String str = String.format(anvx.a(2131707032), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377309)).setText(str);
    ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379565)).setText(((bfhj)localObject).c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localLinearLayout.findViewById(2131364708));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    super.show();
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, "" + ((bfhj)localObject).d, "" + this.jdField_a_of_type_Int, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfej
 * JD-Core Version:    0.7.0.1
 */