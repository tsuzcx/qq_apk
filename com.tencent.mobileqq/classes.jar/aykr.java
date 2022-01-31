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

public class aykr
  extends begr
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  aynk jdField_a_of_type_Aynk = (aynk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
  aynt jdField_a_of_type_Aynt;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public aykr(Activity paramActivity, aynt paramaynt)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aynt = paramaynt;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getTag() != null)
    {
      paramView = (aykt)paramView.getTag();
      this.jdField_a_of_type_Aynk.a(paramView.a);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong", 0, 0, "" + this.jdField_a_of_type_Aynk.a().d, "" + this.jdField_a_of_type_Int, "", "");
      this.jdField_a_of_type_Aynk.a();
    }
    do
    {
      return;
      if (2131299272 == paramView.getId())
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1500L)
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Aynk.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aynt);
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "clk_fuyong_new", 0, 0, "" + this.jdField_a_of_type_Aynk.a().d, "" + this.jdField_a_of_type_Int, "", "");
        return;
      }
    } while (2131298711 != paramView.getId());
    this.jdField_a_of_type_Aynk.a();
    dismiss();
  }
  
  public void show()
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131494748, null);
    if ("1103".equals(ThemeUtil.curThemeId)) {
      localLinearLayout.setBackgroundColor(-15921907);
    }
    a(localLinearLayout);
    Object localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localLinearLayout.findViewById(2131309972));
    localObject = (aynk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if ((((aynk)localObject).a == null) || (((aynk)localObject).a.size() == 0))
    {
      dismiss();
      ((aynk)localObject).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    localObject = new ayks(this, ((aynk)localObject).a);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
    this.jdField_a_of_type_ComTencentWidgetXListView.setMaxHeight(aciy.a(200.0F, getContext().getResources()));
    this.jdField_a_of_type_AndroidViewView = localLinearLayout.findViewById(2131299272);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    int i = this.jdField_a_of_type_Aynk.a.size();
    localObject = String.format(ajjy.a(2131641780), new Object[] { Integer.valueOf(i) });
    ((TextView)localLinearLayout.findViewById(2131309465)).setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_Aynk.a();
    this.jdField_a_of_type_Int = (((aynu)localObject).a.size() - 1);
    String str = String.format(ajjy.a(2131641786), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131310041)).setText(str);
    ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312042)).setText(((aynu)localObject).c);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localLinearLayout.findViewById(2131298711));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    super.show();
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "create_page", "exp_fuyong", 0, 0, "" + ((aynu)localObject).d, "" + this.jdField_a_of_type_Int, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aykr
 * JD-Core Version:    0.7.0.1
 */