import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class azlk
  extends BaseAdapter
{
  List<baee> jdField_a_of_type_JavaUtilList;
  
  azlk(List<baee> paramList)
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
    baee localbaee;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Azlj.getContext()).inflate(2131560321, null);
      paramViewGroup = new azll(this.jdField_a_of_type_Azlj);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131370647));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367427));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368885));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369200);
      paramView.setOnClickListener(this.jdField_a_of_type_Azlj);
      paramView.setTag(paramViewGroup);
      localbaee = (baee)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbaee.a.getTroopName());
      if (localbaee.a.lastMsgTime == 0L) {
        break label270;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131707578) + ahpj.a().a(localbaee.a.troopuin, localbaee.a.lastMsgTime));
      label191:
      if (!localbaee.a.hasSetTroopHead()) {
        break label356;
      }
    }
    label270:
    label356:
    for (paramInt = 4;; paramInt = 113)
    {
      bayh localbayh = bayh.a(this.jdField_a_of_type_Azlj.a, paramInt, localbaee.a.troopuin, 3, bayh.a(4, 3), bayh.a(4, 3));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbayh);
      paramViewGroup.jdField_a_of_type_JavaLangString = localbaee.a.troopuin;
      return paramView;
      paramViewGroup = (azll)paramView.getTag();
      break;
      if (localbaee.a.troopCreateTime != 0L)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131707583) + ahpj.a().a(localbaee.a.troopuin, localbaee.a.troopCreateTime));
        break label191;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label191;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlk
 * JD-Core Version:    0.7.0.1
 */