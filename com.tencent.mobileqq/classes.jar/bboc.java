import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class bboc
  extends BaseAdapter
{
  List<bcgz> jdField_a_of_type_JavaUtilList;
  
  bboc(List<bcgz> paramList)
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
    bcgz localbcgz;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Bbob.getContext()).inflate(2131560428, null);
      paramViewGroup = new bbod(this.jdField_a_of_type_Bbob);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131370977));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367565));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369133));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369451);
      paramView.setOnClickListener(this.jdField_a_of_type_Bbob);
      paramView.setTag(paramViewGroup);
      localbcgz = (bcgz)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbcgz.a.getTroopName());
      if (localbcgz.a.lastMsgTime == 0L) {
        break label270;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131707962) + ajlh.a().a(localbcgz.a.troopuin, localbcgz.a.lastMsgTime));
      label191:
      if (!localbcgz.a.hasSetTroopHead()) {
        break label356;
      }
    }
    label270:
    label356:
    for (paramInt = 4;; paramInt = 113)
    {
      bdbk localbdbk = bdbk.a(this.jdField_a_of_type_Bbob.a, paramInt, localbcgz.a.troopuin, 3, bdbk.a(4, 3), bdbk.a(4, 3));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbdbk);
      paramViewGroup.jdField_a_of_type_JavaLangString = localbcgz.a.troopuin;
      return paramView;
      paramViewGroup = (bbod)paramView.getTag();
      break;
      if (localbcgz.a.troopCreateTime != 0L)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131707967) + ajlh.a().a(localbcgz.a.troopuin, localbcgz.a.troopCreateTime));
        break label191;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label191;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboc
 * JD-Core Version:    0.7.0.1
 */