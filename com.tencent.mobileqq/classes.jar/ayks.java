import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class ayks
  extends BaseAdapter
{
  List<azcv> jdField_a_of_type_JavaUtilList;
  
  ayks(List<azcv> paramList)
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
    azcv localazcv;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Aykr.getContext()).inflate(2131494749, null);
      paramViewGroup = new aykt(this.jdField_a_of_type_Aykr);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131304981));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301817));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303219));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131303531);
      paramView.setOnClickListener(this.jdField_a_of_type_Aykr);
      paramView.setTag(paramViewGroup);
      localazcv = (azcv)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localazcv.a.getTroopName());
      if (localazcv.a.lastMsgTime == 0L) {
        break label270;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641782) + ahcw.a().a(localazcv.a.troopuin, localazcv.a.lastMsgTime));
      label191:
      if (!localazcv.a.hasSetTroopHead()) {
        break label356;
      }
    }
    label270:
    label356:
    for (paramInt = 4;; paramInt = 113)
    {
      azwp localazwp = azwp.a(this.jdField_a_of_type_Aykr.a, paramInt, localazcv.a.troopuin, 3, azwp.a(4, 3), azwp.a(4, 3));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localazwp);
      paramViewGroup.jdField_a_of_type_JavaLangString = localazcv.a.troopuin;
      return paramView;
      paramViewGroup = (aykt)paramView.getTag();
      break;
      if (localazcv.a.troopCreateTime != 0L)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641787) + ahcw.a().a(localazcv.a.troopuin, localazcv.a.troopCreateTime));
        break label191;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label191;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayks
 * JD-Core Version:    0.7.0.1
 */