package com.tencent.biz.qqcircle.share.operation;

import android.view.ViewGroup;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionMenuItem;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheetHelper;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.biz.qqcircle.share.interfaces.IDialogListener;
import com.tencent.biz.qqcircle.widgets.QCircleActionSheet;
import com.tencent.biz.qqcircle.widgets.QCircleActionSheetHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class QCircleDisLikeOperation
  extends QCircleBaseShareOperation
{
  private QCircleActionSheet a;
  
  public QCircleDisLikeOperation(QCircleBaseShareOperation.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((f() != null) && (f().b != null))
    {
      if (i() == null) {
        return;
      }
      FeedCloudMeta.StFeed localStFeed;
      if (f().b.isRecomFd.get())
      {
        localStFeed = new FeedCloudMeta.StFeed();
        localStFeed.id.set(f().b.recomForward.id.get());
        localStFeed.poster.set(f().b.recomForward.poster.get());
      }
      else
      {
        localStFeed = f().b;
      }
      int i = -1;
      if (f().c != null) {
        i = f().c.mDataPosition;
      }
      QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b(localStFeed).setToUin(localStFeed.poster.id.get()).setActionType(65).setSubActionType(paramInt).setIndex(i).setExt3(String.valueOf(localStFeed.createTime));
      if (a(57)) {
        i = h();
      } else {
        i = g();
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(localDataBuilder.setPageId(i)));
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(localStFeed.id.get(), 3));
      if (paramInt == 4) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUnCareRequest(localStFeed.poster.id.get(), 1, 0, null), new QCircleDisLikeOperation.5(this, paramBoolean));
      } else if (paramBoolean) {
        QCircleToast.a(QCircleToast.d, 2131895690, 0);
      }
      a("hidden", null);
    }
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramStFeed, 78, 2);
    a(paramStFeed, 79, 1);
    a("uninterest", null);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    int i;
    if (f().c != null) {
      i = f().c.mDataPosition;
    } else {
      i = -1;
    }
    paramStFeed = QCirclePluginReportUtil.b(paramStFeed).setToUin(f().b.poster.id.get()).setActionType(paramInt1).setSubActionType(paramInt2).setIndex(i).setExt3(String.valueOf(paramStFeed.createTime));
    if (a(57)) {
      paramInt1 = h();
    } else {
      paramInt1 = g();
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramStFeed.setPageId(paramInt1)));
  }
  
  private void a(ArrayList<ActionMenuItem> paramArrayList)
  {
    paramArrayList.add(new ActionMenuItem(5, ActionSheetHelper.a(i(), 2131895804), 5, 0));
  }
  
  private void b(ArrayList<ActionMenuItem> paramArrayList)
  {
    paramArrayList.add(new ActionMenuItem(2, ActionSheetHelper.a(i(), 2131895802), 2, 0));
  }
  
  private void c(ArrayList<ActionMenuItem> paramArrayList)
  {
    paramArrayList.add(new ActionMenuItem(4, ActionSheetHelper.a(i(), 2131895801), 4, 0));
  }
  
  private void d(ArrayList<ActionMenuItem> paramArrayList)
  {
    paramArrayList.add(new ActionMenuItem(3, ActionSheetHelper.a(i(), 2131895803), 3, 0));
  }
  
  private FeedCloudMeta.StFeed u()
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
  
  private void v()
  {
    this.a.e(2131887648);
    this.a.setOnCancelListener(new QCircleDisLikeOperation.1(this));
    this.a.a(new QCircleDisLikeOperation.2(this));
    this.a.a(new QCircleDisLikeOperation.3(this));
  }
  
  private void w()
  {
    if (q() != null) {
      q().a(false, false);
    }
    ActionSheetHelper.a(i(), this.a);
    e();
  }
  
  private ArrayList<ActionMenuItem> x()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      ((QQCircleFeedBase.StFeedBusiReqData)localObject).mergeFrom(f().b.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StFeedBusiReqData)localObject).uninterest_buttons.get();
      if (((List)localObject).contains(Integer.valueOf(1))) {
        d(localArrayList);
      }
      if (((List)localObject).contains(Integer.valueOf(2))) {
        c(localArrayList);
      }
      if (((List)localObject).contains(Integer.valueOf(3))) {
        b(localArrayList);
      }
      if (((List)localObject).contains(Integer.valueOf(7)))
      {
        a(localArrayList);
        return localArrayList;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    return localArrayList;
  }
  
  private ActionSheet.OnButtonClickListener y()
  {
    return new QCircleDisLikeOperation.4(this);
  }
  
  public void a()
  {
    if ((f() != null) && (f().b != null) && (i() != null))
    {
      ActionSheet.OnButtonClickListener localOnButtonClickListener = y();
      ArrayList localArrayList = x();
      this.a = QCircleActionSheetHelper.a(i(), localArrayList, localOnButtonClickListener);
      if (this.a == null)
      {
        QLog.e("QCircleDisLikeShare", 1, "create SecondMenuActionSheet failed");
        return;
      }
      v();
      this.a.g().setBackgroundColor(0);
      this.a.show();
      a(u());
      return;
    }
    a("QCircleDisLikeShare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleDisLikeOperation
 * JD-Core Version:    0.7.0.1
 */