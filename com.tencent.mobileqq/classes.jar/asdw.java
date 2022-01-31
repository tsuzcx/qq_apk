import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import java.util.List;

public class asdw
  extends BaseAdapter
{
  private List<IntimateInfo.CommonTroopInfo> jdField_a_of_type_JavaUtilList;
  
  private asdw(CommonTroopListActivity paramCommonTroopListActivity) {}
  
  public IntimateInfo.CommonTroopInfo a(int paramInt)
  {
    return (IntimateInfo.CommonTroopInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<IntimateInfo.CommonTroopInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity)).inflate(2131559191, null);
    }
    paramView = a(paramInt);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131364637);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131364640);
    localImageView.setImageDrawable(bcxb.a(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity), 4, paramView.troopCode));
    localTextView.setText(paramView.troopName);
    paramViewGroup.setTag(paramView);
    paramViewGroup.setOnClickListener(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdw
 * JD-Core Version:    0.7.0.1
 */