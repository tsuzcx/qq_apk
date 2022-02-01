import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class auou
  extends BaseAdapter
{
  private List<IntimateInfo.CommonTroopInfo> jdField_a_of_type_JavaUtilList;
  
  private auou(CommonTroopListActivity paramCommonTroopListActivity) {}
  
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
    if (paramView == null) {
      paramView = LayoutInflater.from(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity)).inflate(2131559269, null);
    }
    for (;;)
    {
      IntimateInfo.CommonTroopInfo localCommonTroopInfo = a(paramInt);
      ImageView localImageView = (ImageView)paramView.findViewById(2131364856);
      TextView localTextView = (TextView)paramView.findViewById(2131364859);
      localImageView.setImageDrawable(aoch.a(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity), 4, localCommonTroopInfo.troopCode));
      localTextView.setText(localCommonTroopInfo.troopName);
      paramView.setTag(localCommonTroopInfo);
      paramView.setOnClickListener(CommonTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateCommonTroopListActivity));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auou
 * JD-Core Version:    0.7.0.1
 */