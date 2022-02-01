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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bhay
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<bhbd> a;
  protected List<String> b = new ArrayList(15);
  
  public bhay(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(bhbb parambhbb)
  {
    if (parambhbb.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      parambhbb.jdField_a_of_type_JavaLangStringBuilder.delete(0, parambhbb.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    parambhbb.jdField_a_of_type_JavaLangStringBuilder.append(parambhbb.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(parambhbb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    parambhbb.jdField_a_of_type_AndroidViewView.setContentDescription(parambhbb.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<bhbd> paramList)
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
    Object localObject;
    bhbb localbhbb;
    if (paramView == null)
    {
      localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560663, paramViewGroup, false);
      localbhbb = new bhbb(this);
      localbhbb.jdField_a_of_type_AndroidViewView = ((View)localObject);
      localbhbb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369207));
      localbhbb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)((View)localObject).findViewById(2131380118));
      localbhbb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379958));
      ((View)localObject).setTag(localbhbb);
      paramView = (View)localObject;
      if (AppSetting.c)
      {
        ((View)localObject).setFocusable(true);
        localbhbb.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      localbhbb = (bhbb)paramView.getTag();
      bhbd localbhbd = (bhbd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localbhbb.jdField_a_of_type_Bhbd = localbhbd;
      localbhbb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localbhbd.jdField_a_of_type_JavaLangString));
      if ((localbhbd.jdField_b_of_type_JavaLangString != null) && (localbhbd.jdField_b_of_type_JavaLangString.startsWith("LV")))
      {
        localbhbb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
        localbhbb.jdField_a_of_type_JavaLangString = localbhbd.jdField_a_of_type_JavaLangString;
        localObject = (bhba)localbhbb.jdField_a_of_type_AndroidWidgetTextView.getTag();
        localbhbb.jdField_a_of_type_AndroidWidgetTextView.setText(localbhbd.c);
        if (localObject != null) {
          break label451;
        }
        localObject = new bhba(this, null);
        localbhbb.jdField_a_of_type_AndroidWidgetTextView.setTag(localObject);
      }
      label451:
      for (;;)
      {
        if (AppSetting.c) {
          a(localbhbb);
        }
        ((bhba)localObject).a = localbhbb;
        ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_JavaLangString, localbhbb.jdField_a_of_type_JavaLangString, (aojm)localObject);
        if (!this.b.contains(localbhbb.jdField_a_of_type_JavaLangString))
        {
          new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localbhbd.jdField_b_of_type_JavaLangString }).a();
          this.b.add(localbhbb.jdField_a_of_type_JavaLangString);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localbhbb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
        localbhbb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localbhbd.jdField_b_of_type_JavaLangString);
        localbhbb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localbhbd.jdField_b_of_type_Int);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhay
 * JD-Core Version:    0.7.0.1
 */