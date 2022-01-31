import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class azli
  extends BaseAdapter
{
  List<badq> jdField_a_of_type_JavaUtilList;
  
  azli(List<badq> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
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
    badq localbadq;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Azlh.getContext()).inflate(2131560321, null);
      paramViewGroup = new azlj(this.jdField_a_of_type_Azlh);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131370647));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367427));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368885));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369200);
      paramView.setOnClickListener(this.jdField_a_of_type_Azlh);
      paramView.setTag(paramViewGroup);
      localbadq = (badq)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbadq.a.getTroopName());
      if (localbadq.a.lastMsgTime == 0L) {
        break label270;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131707567) + ahpl.a().a(localbadq.a.troopuin, localbadq.a.lastMsgTime));
      label191:
      if (!localbadq.a.hasSetTroopHead()) {
        break label356;
      }
    }
    label270:
    label356:
    for (paramInt = 4;; paramInt = 113)
    {
      baxt localbaxt = baxt.a(this.jdField_a_of_type_Azlh.a, paramInt, localbadq.a.troopuin, 3, baxt.a(4, 3), baxt.a(4, 3));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbaxt);
      paramViewGroup.jdField_a_of_type_JavaLangString = localbadq.a.troopuin;
      return paramView;
      paramViewGroup = (azlj)paramView.getTag();
      break;
      if (localbadq.a.troopCreateTime != 0L)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131707572) + ahpl.a().a(localbadq.a.troopuin, localbadq.a.troopCreateTime));
        break label191;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label191;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azli
 * JD-Core Version:    0.7.0.1
 */