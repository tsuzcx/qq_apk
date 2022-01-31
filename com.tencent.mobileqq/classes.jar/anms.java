import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import java.util.Iterator;
import java.util.List;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;

public class anms
  extends anna
{
  public anms(MsgBoxListActivity paramMsgBoxListActivity, List paramList) {}
  
  public void a(boolean paramBoolean, List<nearby_now_anchor.AnchorStatus> paramList, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramBundle.hasNext())
      {
        RecentItemNearbyLiveTipData localRecentItemNearbyLiveTipData = (RecentItemNearbyLiveTipData)paramBundle.next();
        this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity.a(localRecentItemNearbyLiveTipData, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anms
 * JD-Core Version:    0.7.0.1
 */