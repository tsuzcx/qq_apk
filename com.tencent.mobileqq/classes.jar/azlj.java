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

public class azlj
  extends bfpc
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  azoc jdField_a_of_type_Azoc = (azoc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
  azol jdField_a_of_type_Azol;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public azlj(Activity paramActivity, azol paramazol)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Azol = paramazol;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      paramView = (azll)paramView.getTag();
      this.jdField_a_of_type_Azoc.a(paramView.a);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, "" + this.jdField_a_of_type_Azoc.a().d, "" + this.jdField_a_of_type_Int, "", "");
      this.jdField_a_of_type_Azoc.a();
    }
    do
    {
      return;
      if (2131364834 == paramView.getId())
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1500L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Azoc.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Azol);
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, "" + this.jdField_a_of_type_Azoc.a().d, "" + this.jdField_a_of_type_Int, "", "");
        return;
      }
    } while (2131364268 != paramView.getId());
    this.jdField_a_of_type_Azoc.a();
    dismiss();
  }
  
  public void show()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131560320, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      localLinearLayout.setBackgroundColor(-15921907);
    }
    a(localLinearLayout);
    Object localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localLinearLayout.findViewById(2131375735));
    localObject = (azoc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if ((((azoc)localObject).a == null) || (((azoc)localObject).a.size() == 0))
    {
      dismiss();
      ((azoc)localObject).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    localObject = new azlk(this, ((azoc)localObject).a);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setMaxHeight(actj.a(200.0F, getContext().getResources()));
    this.jdField_a_of_type_AndroidViewView = localLinearLayout.findViewById(2131364834);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    int i = this.jdField_a_of_type_Azoc.a.size();
    localObject = String.format(ajya.a(2131707576), new Object[] { Integer.valueOf(i) });
    ((TextView)localLinearLayout.findViewById(2131375215)).setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_Azoc.a();
    this.jdField_a_of_type_Int = (((azom)localObject).a.size() - 1);
    String str = String.format(ajya.a(2131707582), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375807)).setText(str);
    ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377870)).setText(((azom)localObject).c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localLinearLayout.findViewById(2131364268));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    super.show();
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, "" + ((azom)localObject).d, "" + this.jdField_a_of_type_Int, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlj
 * JD-Core Version:    0.7.0.1
 */