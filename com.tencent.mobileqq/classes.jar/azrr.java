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

public class azrr
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<azrw> a;
  protected List<String> b = new ArrayList(15);
  
  public azrr(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(azru paramazru)
  {
    if (paramazru.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      paramazru.jdField_a_of_type_JavaLangStringBuilder.delete(0, paramazru.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    paramazru.jdField_a_of_type_JavaLangStringBuilder.append(paramazru.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(paramazru.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    paramazru.jdField_a_of_type_AndroidViewView.setContentDescription(paramazru.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<azrw> paramList)
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494815, paramViewGroup, false);
      paramViewGroup = new azru(this);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302935));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)paramView.findViewById(2131312543));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312436));
      paramView.setTag(paramViewGroup);
      localView = paramView;
      if (AppSetting.c)
      {
        paramView.setFocusable(true);
        paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    paramViewGroup = (azru)localView.getTag();
    azrw localazrw = (azrw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.jdField_a_of_type_Azrw = localazrw;
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localazrw.jdField_a_of_type_JavaLangString));
    if ((localazrw.jdField_b_of_type_JavaLangString != null) && (localazrw.jdField_b_of_type_JavaLangString.startsWith("LV")))
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_JavaLangString = localazrw.jdField_a_of_type_JavaLangString;
      paramView = (azrt)paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localazrw.c);
      if (paramView != null) {
        break label406;
      }
      paramView = new azrt(this, null);
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
        new awrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localazrw.jdField_b_of_type_JavaLangString }).a();
        this.b.add(paramViewGroup.jdField_a_of_type_JavaLangString);
      }
      return localView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localazrw.jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localazrw.jdField_b_of_type_Int);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azrr
 * JD-Core Version:    0.7.0.1
 */