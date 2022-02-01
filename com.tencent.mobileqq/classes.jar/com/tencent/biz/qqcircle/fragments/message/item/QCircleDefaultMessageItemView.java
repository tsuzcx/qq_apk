package com.tencent.biz.qqcircle.fragments.message.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBaseMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleDefaultMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleKolMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleSystemMessagePresenter;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleTopReplayMessagePresenter;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.BlockPart;
import feedcloud.FeedCloudMeta.StNotice;

public class QCircleDefaultMessageItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StNotice>
{
  private QCircleBaseMessagePresenter a;
  
  public QCircleDefaultMessageItemView(Context paramContext, int paramInt, BlockPart paramBlockPart)
  {
    super(paramContext, paramInt);
    this.a.a(paramBlockPart);
  }
  
  protected QCircleBaseMessagePresenter a(int paramInt)
  {
    if (paramInt == 3) {
      return new QCircleSystemMessagePresenter(paramInt);
    }
    if ((paramInt != 10) && (paramInt != 11))
    {
      if (paramInt == 14) {
        return new QCircleKolMessagePresenter(paramInt);
      }
      return new QCircleDefaultMessagePresenter(paramInt);
    }
    return new QCircleTopReplayMessagePresenter(paramInt);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    QCircleBaseMessagePresenter localQCircleBaseMessagePresenter = this.a;
    if (localQCircleBaseMessagePresenter != null) {
      localQCircleBaseMessagePresenter.a(paramStNotice, paramInt);
    }
  }
  
  protected void beforeInflateView(Context paramContext, int paramInt)
  {
    this.a = a(paramInt);
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.a(getReportBean());
    }
  }
  
  public int getLayoutId()
  {
    return 2131626874;
  }
  
  protected String getLogTag()
  {
    return "QCircleDefaultMessageWidget";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    QCircleBaseMessagePresenter localQCircleBaseMessagePresenter = this.a;
    if (localQCircleBaseMessagePresenter != null) {
      localQCircleBaseMessagePresenter.a(paramContext, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleDefaultMessageItemView
 * JD-Core Version:    0.7.0.1
 */