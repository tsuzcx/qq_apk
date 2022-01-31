import android.os.Handler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView.5.1;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;

public class beoo
  implements yvn<FeedCloudRead.StGetMainPageRsp>
{
  public beoo(ProfileCardMoreInfoView paramProfileCardMoreInfoView) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (paramStGetMainPageRsp != null)
    {
      paramString = paramStGetMainPageRsp.vecFeed.get();
      if ((paramString != null) && (paramString.size() > 0))
      {
        ProfileCardMoreInfoView.a(this.a, paramString);
        ProfileCardMoreInfoView.a(this.a).post(new ProfileCardMoreInfoView.5.1(this));
        QLog.d("ProfileCardMoreInfoView", 4, "makeOrRefreshQQCircle onResponse success");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beoo
 * JD-Core Version:    0.7.0.1
 */