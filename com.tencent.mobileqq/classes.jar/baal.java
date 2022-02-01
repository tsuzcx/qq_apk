import android.util.LruCache;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.FeedVsRspCallBack.1;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class baal
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetMainPageRsp>
{
  private WeakReference<baai> a;
  
  baal(baai parambaai)
  {
    this.a = new WeakReference(parambaai);
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    paramVSBaseRequest = (baai)this.a.get();
    if (paramVSBaseRequest == null) {}
    do
    {
      do
      {
        return;
        baai.a(paramVSBaseRequest).set(false);
      } while (paramStGetMainPageRsp == null);
      paramString = paramStGetMainPageRsp.vecFeed.get();
      baai.a(paramVSBaseRequest, paramStGetMainPageRsp);
      if (((azrb)baai.a(paramVSBaseRequest)).a != null) {
        baai.a().put(((azrb)baai.b(paramVSBaseRequest)).a.uin, new baam(paramStGetMainPageRsp, System.currentTimeMillis()));
      }
    } while ((paramString == null) || (paramString.size() <= 0));
    baai.a(paramVSBaseRequest, paramString);
    baai.a(paramVSBaseRequest).post(new ProfileCircleComponent.FeedVsRspCallBack.1(this, paramVSBaseRequest));
    QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle onResponse success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baal
 * JD-Core Version:    0.7.0.1
 */