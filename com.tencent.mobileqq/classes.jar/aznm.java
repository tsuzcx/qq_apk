import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.1.1;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class aznm
  implements zxa<FeedCloudRead.StGetMainPageRsp>
{
  aznm(aznl paramaznl) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    aznl.a(this.a).set(false);
    if (paramStGetMainPageRsp != null)
    {
      paramString = paramStGetMainPageRsp.vecFeed.get();
      if ((paramString != null) && (paramString.size() > 0))
      {
        aznl.a(this.a, paramString);
        aznl.a(this.a).post(new ProfileCircleComponent.1.1(this));
        QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle onResponse success");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznm
 * JD-Core Version:    0.7.0.1
 */