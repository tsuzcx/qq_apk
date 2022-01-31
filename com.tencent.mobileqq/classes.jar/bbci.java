import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import java.util.List;
import java.util.Map;

public class bbci
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bbci(TroopAdminList paramTroopAdminList, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new bbcj();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560396, null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368781));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370958));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131368224));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      Map localMap = (Map)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_JavaUtilList.get(paramInt);
      String str = localMap.get("uin").toString();
      paramViewGroup.jdField_a_of_type_JavaLangString = str;
      paramViewGroup.c.setBackgroundDrawable(bdda.b());
      bcxb localbcxb = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.app, localMap.get("uin").toString(), (byte)3);
      if (localbcxb != null) {
        paramViewGroup.c.setBackgroundDrawable(localbcxb);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMap.get("nick").toString());
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.b.equals(str)) {
        break;
      }
      paramViewGroup.b.setVisibility(0);
      return paramView;
      paramViewGroup = (bbcj)paramView.getTag();
    }
    paramViewGroup.b.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbci
 * JD-Core Version:    0.7.0.1
 */