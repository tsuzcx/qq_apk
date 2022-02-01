import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.CountrySelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class apqk
  extends bhgj
{
  private apqk(CountrySelectActivity paramCountrySelectActivity) {}
  
  public int a()
  {
    return 2131559558;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (TextView)paramView;
    Object localObject = getItem(paramInt);
    if ((localObject instanceof apql)) {
      paramView.setText(((apql)localObject).jdField_a_of_type_JavaLangString);
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
    if ((this.a.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof apql)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView != null) {
        break label308;
      }
      paramView = this.a.getLayoutInflater().inflate(a(), null);
    }
    label292:
    label302:
    label308:
    for (;;)
    {
      ((TextView)paramView).setText(((apql)getItem(paramInt)).jdField_a_of_type_JavaLangString);
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        View localView = paramView;
        if (paramView == null)
        {
          localView = this.a.getLayoutInflater().inflate(2131559559, null);
          paramView = new apqm(null);
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365185));
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364524));
          localView.findViewById(2131365184).setVisibility(8);
          localView.setTag(paramView);
          localView.setOnClickListener(this.a);
        }
        paramView = (apqm)localView.getTag();
        BaseAddress localBaseAddress = (BaseAddress)getItem(paramInt);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localBaseAddress.name);
        if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_JavaLangString.equals(localBaseAddress.code))) {
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        for (;;)
        {
          paramView.jdField_a_of_type_JavaLangString = localBaseAddress.code;
          if (!CountrySelectActivity.jdField_a_of_type_Boolean) {
            break label302;
          }
          if (paramView.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
            break label292;
          }
          localView.setContentDescription(localBaseAddress.name + amtj.a(2131701749));
          paramView = localView;
          break;
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        localView.setContentDescription(localBaseAddress.name);
        paramView = localView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqk
 * JD-Core Version:    0.7.0.1
 */