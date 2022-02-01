package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.viewmodels.QCircleTagPageViewModel;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StTagInfo;

public class QCircleTagPageTitleBarPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private QCircleTagPageViewModel a;
  private View c;
  private TextView d;
  private ImageView e;
  private ImageView f;
  private QCircleInitBean g;
  private FeedCloudMeta.StTagInfo h;
  
  public QCircleTagPageTitleBarPart(QCircleInitBean paramQCircleInitBean)
  {
    this.g = paramQCircleInitBean;
  }
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (paramStTagInfo == null) {
      return;
    }
    this.h = paramStTagInfo;
    this.d.setText(paramStTagInfo.tagName.get());
  }
  
  public String a()
  {
    return "QCircleTagPageTitleBarPart";
  }
  
  public void a(View paramView)
  {
    this.c = paramView.findViewById(2131447485);
    this.d = ((TextView)paramView.findViewById(2131448814));
    this.e = ((ImageView)paramView.findViewById(2131436275));
    this.f = ((ImageView)paramView.findViewById(2131436571));
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(this.e);
    }
    this.a = ((QCircleTagPageViewModel)a(QCircleTagPageViewModel.class));
    this.a.b.observe(j(), new QCircleTagPageTitleBarPart.1(this));
    paramView = this.g;
    if ((paramView != null) && (paramView.getTagInfo() != null)) {
      a(this.g.getTagInfo());
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if ((TextUtils.equals(paramString, "tag_page_action_title_bar_animation")) && ((paramObject instanceof Message)))
    {
      int i = ((Message)paramObject).what;
      this.c.setBackgroundColor(Color.argb(i, 235, 236, 240));
      this.d.setTextColor(Color.argb(i, 0, 0, 0));
      this.d.setVisibility(0);
      if (i == 0)
      {
        this.c.setBackgroundColor(0);
        this.d.setVisibility(8);
        return;
      }
      if (i == 255)
      {
        this.c.setBackgroundColor(c().getResources().getColor(2131167059));
        this.d.setTextColor(-16777216);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131436275)
    {
      if ((!j().onBackEvent()) && (c() != null)) {
        c().finish();
      }
    }
    else if ((i == 2131436571) && (this.h != null))
    {
      QCircleShareInfo localQCircleShareInfo = new QCircleShareInfo();
      localQCircleShareInfo.d = 3;
      FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
      localStFeed.share.set(this.h.shareInfo.get());
      localQCircleShareInfo.b = localStFeed;
      c("share_action_show_share_sheet", localQCircleShareInfo);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagPageTitleBarPart
 * JD-Core Version:    0.7.0.1
 */