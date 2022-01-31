import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class bbjt
  extends BaseAdapter
{
  List<bccq> jdField_a_of_type_JavaUtilList;
  
  bbjt(List<bccq> paramList)
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
    bccq localbccq;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Bbjs.getContext()).inflate(2131560429, null);
      paramViewGroup = new bbju(this.jdField_a_of_type_Bbjs);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131370958));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367555));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369115));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369433);
      paramView.setOnClickListener(this.jdField_a_of_type_Bbjs);
      paramView.setTag(paramViewGroup);
      localbccq = (bccq)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbccq.a.getTroopName());
      if (localbccq.a.lastMsgTime == 0L) {
        break label270;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131707950) + ajgs.a().a(localbccq.a.troopuin, localbccq.a.lastMsgTime));
      label191:
      if (!localbccq.a.hasSetTroopHead()) {
        break label356;
      }
    }
    label270:
    label356:
    for (paramInt = 4;; paramInt = 113)
    {
      bcxb localbcxb = bcxb.a(this.jdField_a_of_type_Bbjs.a, paramInt, localbccq.a.troopuin, 3, bcxb.a(4, 3), bcxb.a(4, 3));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbcxb);
      paramViewGroup.jdField_a_of_type_JavaLangString = localbccq.a.troopuin;
      return paramView;
      paramViewGroup = (bbju)paramView.getTag();
      break;
      if (localbccq.a.troopCreateTime != 0L)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131707955) + ajgs.a().a(localbccq.a.troopuin, localbccq.a.troopCreateTime));
        break label191;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label191;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjt
 * JD-Core Version:    0.7.0.1
 */