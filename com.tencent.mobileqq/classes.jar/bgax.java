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

public class bgax
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<bgbc> a;
  protected List<String> b = new ArrayList(15);
  
  public bgax(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(bgba parambgba)
  {
    if (parambgba.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      parambgba.jdField_a_of_type_JavaLangStringBuilder.delete(0, parambgba.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    parambgba.jdField_a_of_type_JavaLangStringBuilder.append(parambgba.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(parambgba.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    parambgba.jdField_a_of_type_AndroidViewView.setContentDescription(parambgba.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<bgbc> paramList)
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
    bgba localbgba;
    if (paramView == null)
    {
      localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560648, paramViewGroup, false);
      localbgba = new bgba(this);
      localbgba.jdField_a_of_type_AndroidViewView = ((View)localObject);
      localbgba.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369117));
      localbgba.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)((View)localObject).findViewById(2131379934));
      localbgba.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379779));
      ((View)localObject).setTag(localbgba);
      paramView = (View)localObject;
      if (AppSetting.c)
      {
        ((View)localObject).setFocusable(true);
        localbgba.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      localbgba = (bgba)paramView.getTag();
      bgbc localbgbc = (bgbc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localbgba.jdField_a_of_type_Bgbc = localbgbc;
      localbgba.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localbgbc.jdField_a_of_type_JavaLangString));
      if ((localbgbc.jdField_b_of_type_JavaLangString != null) && (localbgbc.jdField_b_of_type_JavaLangString.startsWith("LV")))
      {
        localbgba.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
        localbgba.jdField_a_of_type_JavaLangString = localbgbc.jdField_a_of_type_JavaLangString;
        localObject = (bgaz)localbgba.jdField_a_of_type_AndroidWidgetTextView.getTag();
        localbgba.jdField_a_of_type_AndroidWidgetTextView.setText(localbgbc.c);
        if (localObject != null) {
          break label451;
        }
        localObject = new bgaz(this, null);
        localbgba.jdField_a_of_type_AndroidWidgetTextView.setTag(localObject);
      }
      label451:
      for (;;)
      {
        if (AppSetting.c) {
          a(localbgba);
        }
        ((bgaz)localObject).a = localbgba;
        ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_JavaLangString, localbgba.jdField_a_of_type_JavaLangString, (anwz)localObject);
        if (!this.b.contains(localbgba.jdField_a_of_type_JavaLangString))
        {
          new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localbgbc.jdField_b_of_type_JavaLangString }).a();
          this.b.add(localbgba.jdField_a_of_type_JavaLangString);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localbgba.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
        localbgba.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localbgbc.jdField_b_of_type_JavaLangString);
        localbgba.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localbgbc.jdField_b_of_type_Int);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgax
 * JD-Core Version:    0.7.0.1
 */