import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.CountrySelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import java.util.List;

public class aodf
  extends benu
{
  private aodf(CountrySelectActivity paramCountrySelectActivity) {}
  
  public int a()
  {
    return 2131559423;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (TextView)paramView;
    Object localObject = getItem(paramInt);
    if ((localObject instanceof aodg)) {
      paramView.setText(((aodg)localObject).jdField_a_of_type_JavaLangString);
    }
    while (!(localObject instanceof BaseAddress)) {
      return;
    }
    paramView.setText(((BaseAddress)localObject).pinyinFirst);
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 0;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof aodg)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label284;
      }
      paramView = this.a.getLayoutInflater().inflate(a(), null);
    }
    label273:
    label284:
    for (;;)
    {
      ((TextView)paramView).setText(((aodg)getItem(paramInt)).jdField_a_of_type_JavaLangString);
      return paramView;
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.a.getLayoutInflater().inflate(2131559424, null);
        paramView = new aodh(null);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364877));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364250));
        paramViewGroup.findViewById(2131364876).setVisibility(8);
        paramViewGroup.setTag(paramView);
        paramViewGroup.setOnClickListener(this.a);
      }
      aodh localaodh = (aodh)paramViewGroup.getTag();
      BaseAddress localBaseAddress = (BaseAddress)getItem(paramInt);
      localaodh.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseAddress.name);
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_JavaLangString.equals(localBaseAddress.code))) {
        localaodh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        localaodh.jdField_a_of_type_JavaLangString = localBaseAddress.code;
        paramView = paramViewGroup;
        if (!CountrySelectActivity.jdField_a_of_type_Boolean) {
          break;
        }
        if (localaodh.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          break label273;
        }
        paramViewGroup.setContentDescription(localBaseAddress.name + alpo.a(2131702988));
        return paramViewGroup;
        localaodh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramViewGroup.setContentDescription(localBaseAddress.name);
      return paramViewGroup;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodf
 * JD-Core Version:    0.7.0.1
 */