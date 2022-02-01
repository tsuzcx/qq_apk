package com.tencent.biz.qqcircle.share.operation;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.requests.QCircleDeleteFeedRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDelFeedRsp;

public class QCircleDeleteOperation
  extends QCircleBaseShareOperation
{
  public QCircleDeleteOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener != null) && (i() != null) && (!i().isFinishing())) {
      QCircleCustomDialog.a(i(), null, HardCodeUtil.a(2131895708), 2131887648, 2131887629, paramOnClickListener, paramOnClickListener).show();
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    QCircleDeleteFeedRequest localQCircleDeleteFeedRequest = new QCircleDeleteFeedRequest(paramStFeed);
    VSNetworkHelper.getInstance().sendRequest(localQCircleDeleteFeedRequest, b(paramStFeed.id.get()));
  }
  
  private VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDelFeedRsp> b(String paramString)
  {
    return new QCircleDeleteOperation.2(this, paramString);
  }
  
  private DialogInterface.OnClickListener u()
  {
    return new QCircleDeleteOperation.1(this);
  }
  
  private void v()
  {
    a(w());
  }
  
  private FeedCloudMeta.StFeed w()
  {
    if (f().b.isRecomFd.get())
    {
      FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
      localStFeed.id.set(f().b.recomForward.id.get());
      localStFeed.poster.set(f().b.recomForward.poster.get());
      return localStFeed;
    }
    return f().b;
  }
  
  private void x()
  {
    boolean bool = a(57);
    String str = "";
    if ((!bool) && (!QCircleConfigHelper.bg()))
    {
      if (f().c != null) {
        localObject = f().c.mFeed;
      } else {
        localObject = null;
      }
      QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(22).setSubActionType(2);
      Object localObject = str;
      if (f().c != null)
      {
        localObject = str;
        if (f().c.mFeed != null) {
          localObject = f().c.mFeed.poster.id.get();
        }
      }
      localObject = localDataBuilder.setToUin((String)localObject);
      int i;
      if (f().c != null) {
        i = f().c.mDataPosition;
      } else {
        i = -1;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(g())));
      return;
    }
    a(22, 2, f().c, "");
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (i() != null))
    {
      a(u());
      x();
      return;
    }
    a("QCircleDeleteShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleDeleteOperation
 * JD-Core Version:    0.7.0.1
 */