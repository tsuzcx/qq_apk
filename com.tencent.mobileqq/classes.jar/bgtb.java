import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bgtb
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<bgtg> a;
  protected List<String> b = new ArrayList(15);
  
  public bgtb(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(bgte parambgte)
  {
    if (parambgte.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      parambgte.jdField_a_of_type_JavaLangStringBuilder.delete(0, parambgte.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    parambgte.jdField_a_of_type_JavaLangStringBuilder.append(parambgte.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(parambgte.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    parambgte.jdField_a_of_type_AndroidViewView.setContentDescription(parambgte.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<bgtg> paramList)
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
    bgte localbgte;
    if (paramView == null)
    {
      localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560726, paramViewGroup, false);
      localbgte = new bgte(this);
      localbgte.jdField_a_of_type_AndroidViewView = ((View)localObject);
      localbgte.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369392));
      localbgte.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)((View)localObject).findViewById(2131380195));
      localbgte.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380038));
      ((View)localObject).setTag(localbgte);
      paramView = (View)localObject;
      if (AppSetting.c)
      {
        ((View)localObject).setFocusable(true);
        localbgte.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      localbgte = (bgte)paramView.getTag();
      bgtg localbgtg = (bgtg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localbgte.jdField_a_of_type_Bgtg = localbgtg;
      localbgte.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localbgtg.jdField_a_of_type_JavaLangString));
      if ((localbgtg.jdField_b_of_type_JavaLangString != null) && (localbgtg.jdField_b_of_type_JavaLangString.startsWith("LV")))
      {
        localbgte.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
        localbgte.jdField_a_of_type_JavaLangString = localbgtg.jdField_a_of_type_JavaLangString;
        localObject = (bgtd)localbgte.jdField_a_of_type_AndroidWidgetTextView.getTag();
        localbgte.jdField_a_of_type_AndroidWidgetTextView.setText(localbgtg.c);
        if (localObject != null) {
          break label452;
        }
        localObject = new bgtd(this, null);
        localbgte.jdField_a_of_type_AndroidWidgetTextView.setTag(localObject);
      }
      label452:
      for (;;)
      {
        if (AppSetting.c) {
          a(localbgte);
        }
        ((bgtd)localObject).a = localbgte;
        ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_JavaLangString, localbgte.jdField_a_of_type_JavaLangString, (aofo)localObject);
        if (!this.b.contains(localbgte.jdField_a_of_type_JavaLangString))
        {
          new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localbgtg.jdField_b_of_type_JavaLangString }).a();
          this.b.add(localbgte.jdField_a_of_type_JavaLangString);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localbgte.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
        localbgte.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localbgtg.jdField_b_of_type_JavaLangString);
        localbgte.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localbgtg.jdField_b_of_type_Int);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtb
 * JD-Core Version:    0.7.0.1
 */