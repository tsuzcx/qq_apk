import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import java.util.ArrayList;
import java.util.List;

public class bcwm
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<bcwr> a;
  protected List<String> b = new ArrayList(15);
  
  public bcwm(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(bcwp parambcwp)
  {
    if (parambcwp.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      parambcwp.jdField_a_of_type_JavaLangStringBuilder.delete(0, parambcwp.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    parambcwp.jdField_a_of_type_JavaLangStringBuilder.append(parambcwp.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(parambcwp.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    parambcwp.jdField_a_of_type_AndroidViewView.setContentDescription(parambcwp.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<bcwr> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560494, paramViewGroup, false);
      paramViewGroup = new bcwp(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368772));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)paramView.findViewById(2131379025));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378896));
      paramView.setTag(paramViewGroup);
      localView = paramView;
      if (AppSetting.c)
      {
        paramView.setFocusable(true);
        paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    paramViewGroup = (bcwp)localView.getTag();
    bcwr localbcwr = (bcwr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.jdField_a_of_type_Bcwr = localbcwr;
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localbcwr.jdField_a_of_type_JavaLangString));
    if ((localbcwr.jdField_b_of_type_JavaLangString != null) && (localbcwr.jdField_b_of_type_JavaLangString.startsWith("LV")))
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_JavaLangString = localbcwr.jdField_a_of_type_JavaLangString;
      paramView = (bcwo)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbcwr.c);
      if (paramView != null) {
        break label406;
      }
      paramView = new bcwo(this, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTag(paramView);
    }
    label406:
    for (;;)
    {
      if (AppSetting.c) {
        a(paramViewGroup);
      }
      paramView.a = paramViewGroup;
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_JavaLangString, paramView);
      if (!this.b.contains(paramViewGroup.jdField_a_of_type_JavaLangString))
      {
        new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localbcwr.jdField_b_of_type_JavaLangString }).a();
        this.b.add(paramViewGroup.jdField_a_of_type_JavaLangString);
      }
      return localView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localbcwr.jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localbcwr.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwm
 * JD-Core Version:    0.7.0.1
 */