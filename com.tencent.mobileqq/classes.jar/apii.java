import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import java.util.Iterator;
import java.util.List;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;

public class apii
  extends apiq
{
  public apii(MsgBoxListActivity paramMsgBoxListActivity, List paramList) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apii
 * JD-Core Version:    0.7.0.1
 */