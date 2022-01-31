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
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class bbjs
  extends bhpy
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bbml jdField_a_of_type_Bbml = (bbml)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
  bbmu jdField_a_of_type_Bbmu;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public bbjs(Activity paramActivity, bbmu parambbmu)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bbmu = parambbmu;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      paramView = (bbju)paramView.getTag();
      this.jdField_a_of_type_Bbml.a(paramView.a);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, "" + this.jdField_a_of_type_Bbml.a().d, "" + this.jdField_a_of_type_Int, "", "");
      this.jdField_a_of_type_Bbml.a();
    }
    do
    {
      return;
      if (2131364920 == paramView.getId())
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1500L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Bbml.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bbmu);
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, "" + this.jdField_a_of_type_Bbml.a().d, "" + this.jdField_a_of_type_Int, "", "");
        return;
      }
    } while (2131364335 != paramView.getId());
    this.jdField_a_of_type_Bbml.a();
    dismiss();
  }
  
  public void show()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560428, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      localLinearLayout.setBackgroundColor(-15921907);
    }
    a(localLinearLayout);
    Object localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localLinearLayout.findViewById(2131376229));
    localObject = (bbml)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if ((((bbml)localObject).a == null) || (((bbml)localObject).a.size() == 0))
    {
      dismiss();
      ((bbml)localObject).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    localObject = new bbjt(this, ((bbml)localObject).a);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setMaxHeight(aekt.a(200.0F, getContext().getResources()));
    this.jdField_a_of_type_AndroidViewView = localLinearLayout.findViewById(2131364920);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    int i = this.jdField_a_of_type_Bbml.a.size();
    localObject = String.format(alpo.a(2131707948), new Object[] { Integer.valueOf(i) });
    ((TextView)localLinearLayout.findViewById(2131375697)).setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_Bbml.a();
    this.jdField_a_of_type_Int = (((bbmv)localObject).a.size() - 1);
    String str = String.format(alpo.a(2131707954), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376304)).setText(str);
    ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378415)).setText(((bbmv)localObject).c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localLinearLayout.findViewById(2131364335));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    super.show();
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, "" + ((bbmv)localObject).d, "" + this.jdField_a_of_type_Int, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjs
 * JD-Core Version:    0.7.0.1
 */