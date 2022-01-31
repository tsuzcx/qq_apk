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

public class bcsd
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<bcsi> a;
  protected List<String> b = new ArrayList(15);
  
  public bcsd(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(bcsg parambcsg)
  {
    if (parambcsg.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      parambcsg.jdField_a_of_type_JavaLangStringBuilder.delete(0, parambcsg.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    parambcsg.jdField_a_of_type_JavaLangStringBuilder.append(parambcsg.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(parambcsg.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    parambcsg.jdField_a_of_type_AndroidViewView.setContentDescription(parambcsg.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<bcsi> paramList)
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560495, paramViewGroup, false);
      paramViewGroup = new bcsg(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368759));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)paramView.findViewById(2131378967));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378839));
      paramView.setTag(paramViewGroup);
      localView = paramView;
      if (AppSetting.c)
      {
        paramView.setFocusable(true);
        paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    paramViewGroup = (bcsg)localView.getTag();
    bcsi localbcsi = (bcsi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.jdField_a_of_type_Bcsi = localbcsi;
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localbcsi.jdField_a_of_type_JavaLangString));
    if ((localbcsi.jdField_b_of_type_JavaLangString != null) && (localbcsi.jdField_b_of_type_JavaLangString.startsWith("LV")))
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_JavaLangString = localbcsi.jdField_a_of_type_JavaLangString;
      paramView = (bcsf)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbcsi.c);
      if (paramView != null) {
        break label406;
      }
      paramView = new bcsf(this, null);
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
        new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localbcsi.jdField_b_of_type_JavaLangString }).a();
        this.b.add(paramViewGroup.jdField_a_of_type_JavaLangString);
      }
      return localView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localbcsi.jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localbcsi.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsd
 * JD-Core Version:    0.7.0.1
 */