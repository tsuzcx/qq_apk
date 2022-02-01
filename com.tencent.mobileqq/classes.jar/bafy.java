import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.1.1;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class bafy
  implements aaav<FeedCloudRead.StGetMainPageRsp>
{
  bafy(bafx parambafx) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    bafx.a(this.a).set(false);
    if (paramStGetMainPageRsp != null)
    {
      paramString = paramStGetMainPageRsp.vecFeed.get();
      if ((paramString != null) && (paramString.size() > 0))
      {
        bafx.a(this.a, paramString);
        bafx.a(this.a).post(new ProfileCircleComponent.1.1(this));
        QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle onResponse success");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafy
 * JD-Core Version:    0.7.0.1
 */