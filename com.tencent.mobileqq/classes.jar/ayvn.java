import android.util.LruCache;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.1.1;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayvn
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetMainPageRsp>
{
  ayvn(ayvm paramayvm) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    ayvm.a(this.a).set(false);
    if (paramStGetMainPageRsp != null)
    {
      paramVSBaseRequest = paramStGetMainPageRsp.vecFeed.get();
      ayvm.a(this.a, paramStGetMainPageRsp);
      if (((aymg)ayvm.a(this.a)).a != null) {
        ayvm.a().put(((aymg)ayvm.b(this.a)).a.uin, new ayvr(paramStGetMainPageRsp, System.currentTimeMillis()));
      }
      if ((paramVSBaseRequest != null) && (paramVSBaseRequest.size() > 0))
      {
        ayvm.a(this.a, paramVSBaseRequest);
        ayvm.a(this.a).post(new ProfileCircleComponent.1.1(this));
        QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle onResponse success");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvn
 * JD-Core Version:    0.7.0.1
 */