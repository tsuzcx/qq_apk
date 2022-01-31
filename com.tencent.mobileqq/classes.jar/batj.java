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

public class batj
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<bato> a;
  protected List<String> b = new ArrayList(15);
  
  public batj(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(batm parambatm)
  {
    if (parambatm.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      parambatm.jdField_a_of_type_JavaLangStringBuilder.delete(0, parambatm.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    parambatm.jdField_a_of_type_JavaLangStringBuilder.append(parambatm.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(parambatm.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    parambatm.jdField_a_of_type_AndroidViewView.setContentDescription(parambatm.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<bato> paramList)
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560387, paramViewGroup, false);
      paramViewGroup = new batm(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368564));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)paramView.findViewById(2131378371));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378265));
      paramView.setTag(paramViewGroup);
      localView = paramView;
      if (AppSetting.d)
      {
        paramView.setFocusable(true);
        paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    paramViewGroup = (batm)localView.getTag();
    bato localbato = (bato)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.jdField_a_of_type_Bato = localbato;
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localbato.jdField_a_of_type_JavaLangString));
    if ((localbato.jdField_b_of_type_JavaLangString != null) && (localbato.jdField_b_of_type_JavaLangString.startsWith("LV")))
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_JavaLangString = localbato.jdField_a_of_type_JavaLangString;
      paramView = (batl)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbato.c);
      if (paramView != null) {
        break label406;
      }
      paramView = new batl(this, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTag(paramView);
    }
    label406:
    for (;;)
    {
      if (AppSetting.d) {
        a(paramViewGroup);
      }
      paramView.a = paramViewGroup;
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_JavaLangString, paramView);
      if (!this.b.contains(paramViewGroup.jdField_a_of_type_JavaLangString))
      {
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localbato.jdField_b_of_type_JavaLangString }).a();
        this.b.add(paramViewGroup.jdField_a_of_type_JavaLangString);
      }
      return localView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localbato.jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localbato.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batj
 * JD-Core Version:    0.7.0.1
 */