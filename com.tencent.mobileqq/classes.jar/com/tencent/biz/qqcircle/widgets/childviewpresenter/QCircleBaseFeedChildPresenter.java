package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;

public abstract class QCircleBaseFeedChildPresenter<T>
  implements ReportBean<QCircleReportBean>
{
  private static final String TAG = "QCircleBaseFeedChildPresenter";
  protected View mContainer;
  protected T mData;
  protected QCircleExtraTypeInfo mExtraTypeInfo;
  protected QCircleInteractor mIntercator;
  private QCircleInsFeedItemView mParentView;
  protected int mPos;
  protected QCircleReportBean mReportBean;
  protected QCircleExtraTypeInfo mReportInfo = new QCircleExtraTypeInfo();
  
  public abstract void bindData(T paramT, int paramInt);
  
  public View getContainerView()
  {
    return this.mContainer;
  }
  
  public FeedCloudMeta.StFeed getFeedData()
  {
    Object localObject = this.mData;
    if ((localObject instanceof FeedBlockData)) {
      return ((FeedBlockData)localObject).b();
    }
    return null;
  }
  
  protected abstract String getLogTag();
  
  protected int getPageId()
  {
    return QCircleReportBean.getPageId(getLogTag(), this.mReportBean);
  }
  
  public QCircleInsFeedItemView getParentView()
  {
    return this.mParentView;
  }
  
  public int getPos()
  {
    return this.mPos;
  }
  
  public QCircleReportBean getReportBean()
  {
    return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
  }
  
  public abstract void initView(View paramView);
  
  protected boolean interceptFakeClick()
  {
    if (isFakeFeed())
    {
      View localView = this.mContainer;
      if (localView != null)
      {
        QCircleToast.a(localView.getResources().getString(2131895871), 0);
        return true;
      }
    }
    return false;
  }
  
  public boolean isFakeFeed()
  {
    Object localObject = this.mData;
    if ((localObject != null) && ((localObject instanceof FeedBlockData)))
    {
      localObject = ((FeedBlockData)localObject).b().id.get();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("qcircle_fakeid_"))) {
        return true;
      }
    }
    return false;
  }
  
  public void onAttachedToWindow() {}
  
  public void onConfigChanged(Configuration paramConfiguration) {}
  
  public void onDetachedFromWindow() {}
  
  public void setData(T paramT)
  {
    this.mData = paramT;
  }
  
  public void setExtraTypeInfo(QCircleExtraTypeInfo paramQCircleExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramQCircleExtraTypeInfo;
  }
  
  public void setFetchInfoObj(QCircleInteractor paramQCircleInteractor)
  {
    this.mIntercator = paramQCircleInteractor;
  }
  
  public void setParentView(QCircleInsFeedItemView paramQCircleInsFeedItemView)
  {
    this.mParentView = paramQCircleInsFeedItemView;
  }
  
  public void setPos(int paramInt)
  {
    this.mPos = paramInt;
  }
  
  public void setReportBean(QCircleReportBean paramQCircleReportBean)
  {
    this.mReportBean = QCircleReportBean.setReportBean(getLogTag(), paramQCircleReportBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleBaseFeedChildPresenter
 * JD-Core Version:    0.7.0.1
 */