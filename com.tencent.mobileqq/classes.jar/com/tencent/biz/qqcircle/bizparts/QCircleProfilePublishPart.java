package com.tencent.biz.qqcircle.bizparts;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StGuidePublishBubble;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleProfilePublishPart
  extends QCirclePublishFeedPart
{
  private ImageView c;
  private FeedCloudMeta.StGuidePublishBubble d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  
  public QCircleProfilePublishPart(FeedCloudMeta.StUser paramStUser)
  {
    super(paramStUser);
  }
  
  private void b(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(String.valueOf(QCircleCommonUtil.getCurrentAccountLongUin())).setActionType(11).setSubActionType(55).setThrActionType(paramInt).setExt6(this.d.id.get()));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.c != null)
    {
      if (this.e == paramBoolean) {
        return;
      }
      if (!this.f)
      {
        b(1);
        this.f = true;
      }
      this.e = paramBoolean;
      if (paramBoolean)
      {
        Object localObject = this.d;
        int i;
        int j;
        if ((localObject != null) && (((FeedCloudMeta.StGuidePublishBubble)localObject).backgroundImage.has()) && (!TextUtils.isEmpty(this.d.backgroundImage.picUrl.get())))
        {
          FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)this.d.backgroundImage.get();
          localObject = QCircleSkinHelper.getInstance().convertUrl(localStImage.picUrl.get());
          i = ViewUtils.a(localStImage.width.get() / 2);
          j = ViewUtils.a(localStImage.height.get() / 2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("background url:");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" width:");
          localStringBuilder.append(localStImage.width.get());
          localStringBuilder.append(" height:");
          localStringBuilder.append(localStImage.height.get());
          QLog.d("QCircleProfilePublishPart", 1, localStringBuilder.toString());
        }
        else
        {
          QLog.d("QCircleProfilePublishPart", 1, "use backup background");
          localObject = QCircleSkinHelper.getInstance().getUrl("tooltips_emptystate_profile");
          i = ViewUtils.a(226.0F);
          j = ViewUtils.a(137.0F);
        }
        localObject = new Option().setUrl((String)localObject).setRequestWidth(i).setRequestHeight(j).setTargetView(this.c);
        this.c.getLayoutParams().height = j;
        this.c.getLayoutParams().width = i;
        QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
        this.c.setVisibility(0);
        this.c.setOnClickListener(this);
        return;
      }
      this.c.setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.c = ((ImageView)paramView.findViewById(2131440941));
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (TextUtils.equals(paramString, "personal_page_show_publish_guide"))
    {
      if ((paramObject instanceof Boolean)) {
        b(((Boolean)paramObject).booleanValue());
      }
    }
    else if ((TextUtils.equals(paramString, "personal_page_publish_guide_rsp")) && ((paramObject instanceof FeedCloudMeta.StGuidePublishBubble)))
    {
      this.d = ((FeedCloudMeta.StGuidePublishBubble)paramObject);
      this.g = true;
      paramString = new StringBuilder();
      paramString.append("jumpUrl:");
      paramString.append(this.d.jumpUrl.get());
      QLog.d("QCircleProfilePublishPart", 1, paramString.toString());
    }
  }
  
  public void onClick(View paramView)
  {
    if (((paramView.getId() == 2131440941) || (paramView.getId() == 2131440943)) && (this.g))
    {
      FeedCloudMeta.StGuidePublishBubble localStGuidePublishBubble = this.d;
      if ((localStGuidePublishBubble != null) && (localStGuidePublishBubble.jumpUrl.has()) && (!TextUtils.isEmpty(this.d.jumpUrl.get())))
      {
        QCircleLauncher.a(g(), this.d.jumpUrl.get());
        b(2);
        break label90;
      }
    }
    super.onClick(paramView);
    label90:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleProfilePublishPart
 * JD-Core Version:    0.7.0.1
 */