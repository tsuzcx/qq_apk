import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class bfkk
  extends BaseAdapter
{
  protected QQAppInterface a;
  protected String a;
  protected List<bfkp> a;
  protected List<String> b = new ArrayList(15);
  
  public bfkk(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(bfkn parambfkn)
  {
    if (parambfkn.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
      parambfkn.jdField_a_of_type_JavaLangStringBuilder.delete(0, parambfkn.jdField_a_of_type_JavaLangStringBuilder.length());
    }
    parambfkn.jdField_a_of_type_JavaLangStringBuilder.append(parambfkn.jdField_a_of_type_AndroidWidgetTextView.getText().toString()).append(",").append(parambfkn.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    parambfkn.jdField_a_of_type_AndroidViewView.setContentDescription(parambfkn.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<bfkp> paramList)
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
    bfkn localbfkn;
    if (paramView == null)
    {
      localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560673, paramViewGroup, false);
      localbfkn = new bfkn(this);
      localbfkn.jdField_a_of_type_AndroidViewView = ((View)localObject);
      localbfkn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369229));
      localbfkn.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)((View)localObject).findViewById(2131379863));
      localbfkn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379724));
      ((View)localObject).setTag(localbfkn);
      paramView = (View)localObject;
      if (AppSetting.c)
      {
        ((View)localObject).setFocusable(true);
        localbfkn.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      localbfkn = (bfkn)paramView.getTag();
      bfkp localbfkp = (bfkp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localbfkn.jdField_a_of_type_Bfkp = localbfkp;
      localbfkn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localbfkp.jdField_a_of_type_JavaLangString));
      if ((localbfkp.jdField_b_of_type_JavaLangString != null) && (localbfkp.jdField_b_of_type_JavaLangString.startsWith("LV")))
      {
        localbfkn.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
        localbfkn.jdField_a_of_type_JavaLangString = localbfkp.jdField_a_of_type_JavaLangString;
        localObject = (bfkm)localbfkn.jdField_a_of_type_AndroidWidgetTextView.getTag();
        localbfkn.jdField_a_of_type_AndroidWidgetTextView.setText(localbfkp.c);
        if (localObject != null) {
          break label451;
        }
        localObject = new bfkm(this, null);
        localbfkn.jdField_a_of_type_AndroidWidgetTextView.setTag(localObject);
      }
      label451:
      for (;;)
      {
        if (AppSetting.c) {
          a(localbfkn);
        }
        ((bfkm)localObject).a = localbfkn;
        ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_JavaLangString, localbfkn.jdField_a_of_type_JavaLangString, (ancx)localObject);
        if (!this.b.contains(localbfkn.jdField_a_of_type_JavaLangString))
        {
          new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.jdField_a_of_type_JavaLangString, localbfkp.jdField_b_of_type_JavaLangString }).a();
          this.b.add(localbfkn.jdField_a_of_type_JavaLangString);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localbfkn.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
        localbfkn.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localbfkp.jdField_b_of_type_JavaLangString);
        localbfkn.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localbfkp.jdField_b_of_type_Int);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkk
 * JD-Core Version:    0.7.0.1
 */