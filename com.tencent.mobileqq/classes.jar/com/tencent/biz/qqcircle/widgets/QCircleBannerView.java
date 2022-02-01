package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StImage;
import java.util.List;
import qqcircle.QQCircleDitto.StNegativeFbButton;
import qqcircle.QQCircleDitto.StSinglePicBanner;

public class QCircleBannerView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private ImageView a;
  private RelativeLayout b;
  private ImageView c;
  private QCircleBannerView.InviteBannerClickListener d;
  private byte[] e;
  
  public QCircleBannerView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(FeedCloudMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      float f = paramStImage.height.get() * 1.0F / paramStImage.width.get();
      int i = DisplayUtil.d();
      paramStImage = this.a.getLayoutParams();
      paramStImage.height = Math.round(f * i);
      paramStImage.width = -1;
      this.a.setLayoutParams(paramStImage);
    }
  }
  
  protected void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof QQCircleDitto.StSinglePicBanner))
    {
      paramObject = (QQCircleDitto.StSinglePicBanner)paramObject;
      if ((this.c != null) && (paramObject.buttons.get() != null) && (paramObject.buttons.get().size() > 0))
      {
        String str = ((QQCircleDitto.StNegativeFbButton)paramObject.buttons.get().get(0)).color.get();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("close button color: ");
        localStringBuilder2.append(str);
        QLog.d("QCircleInviteBannerView", 1, localStringBuilder2.toString());
        if (str.trim().length() > 0) {
          try
          {
            this.c.setColorFilter(Color.parseColor(str));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      if ((this.a != null) && (paramObject.image.get() != null) && (!TextUtils.isEmpty(paramObject.image.picUrl.get())))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("banner url is:");
        localStringBuilder1.append(paramObject.image.picUrl.get());
        QLog.d("QCircleInviteBannerView", 1, localStringBuilder1.toString());
        a(paramObject.image);
        paramObject = new Option().setTargetView(this.a).setUrl(paramObject.image.picUrl.get());
        QCircleFeedPicLoader.g().loadImage(paramObject, null);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131626859;
  }
  
  protected String getLogTag()
  {
    return "QCircleInviteBannerView";
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("QCircleInviteBannerView", 1, "onAttachedToWindow");
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(14).setThrActionType(1).setFeedReportInfo(this.e).setPageId(getPageId()));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    QCircleBannerView.InviteBannerClickListener localInviteBannerClickListener;
    if (i == 2131436284)
    {
      localInviteBannerClickListener = this.d;
      if (localInviteBannerClickListener != null) {
        localInviteBannerClickListener.a();
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(14).setThrActionType(2).setFeedReportInfo(this.e).setPageId(getPageId()));
    }
    else if (i == 2131444915)
    {
      localInviteBannerClickListener = this.d;
      if (localInviteBannerClickListener != null) {
        localInviteBannerClickListener.b();
      }
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(14).setThrActionType(3).setFeedReportInfo(this.e).setPageId(getPageId()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.a = ((ImageView)paramView.findViewById(2131436284));
      this.b = ((RelativeLayout)paramView.findViewById(2131444915));
      this.c = ((ImageView)paramView.findViewById(2131436282));
      this.a.setOnClickListener(this);
      this.b.setOnClickListener(this);
      this.a.setAdjustViewBounds(true);
    }
  }
  
  public void setInviteBannerClickListener(QCircleBannerView.InviteBannerClickListener paramInviteBannerClickListener)
  {
    this.d = paramInviteBannerClickListener;
  }
  
  public void setReportInfo(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBannerView
 * JD-Core Version:    0.7.0.1
 */