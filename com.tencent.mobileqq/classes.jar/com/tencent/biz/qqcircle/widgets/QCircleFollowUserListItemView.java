package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StUserRecomInfo;
import java.util.List;
import qqcircle.QQCircleFeedBase.StUinBannerData;
import qqcircle.QQCircleFeedBase.StUserRecomInfoBusiData;

public class QCircleFollowUserListItemView
  extends QCircleBaseWidgetView<FeedCloudMeta.StUserRecomInfo>
  implements View.OnClickListener
{
  private QCircleAvatarView a;
  private QCircleAvatarView b;
  private QCircleAvatarView c;
  private QCircleAvatarView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private URLImageView h;
  private QCircleFollowView i;
  private View j;
  private View k;
  private String l;
  private TextView m;
  private String n;
  private int o;
  private int p = -1;
  
  public QCircleFollowUserListItemView(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.l = paramString;
    this.o = paramInt;
  }
  
  public void a(FeedCloudMeta.StUserRecomInfo paramStUserRecomInfo, int paramInt)
  {
    if (paramStUserRecomInfo == null) {
      return;
    }
    QQCircleFeedBase.StUserRecomInfoBusiData localStUserRecomInfoBusiData = new QQCircleFeedBase.StUserRecomInfoBusiData();
    try
    {
      localStUserRecomInfoBusiData.mergeFrom(paramStUserRecomInfo.busiData.get().toByteArray());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    if (localStUserRecomInfoBusiData.pattonType.get() == 1)
    {
      this.k.setVisibility(0);
      this.j.setVisibility(8);
      if ((localStUserRecomInfoBusiData.bannerData != null) && (localStUserRecomInfoBusiData.bannerData.text.get() != null) && (!TextUtils.isEmpty(localStUserRecomInfoBusiData.bannerData.text.get()))) {
        this.f.setText(localStUserRecomInfoBusiData.bannerData.text.get());
      }
      if ((localStUserRecomInfoBusiData.bannerData != null) && (localStUserRecomInfoBusiData.bannerData.userList.get() != null) && (!localStUserRecomInfoBusiData.bannerData.userList.get().isEmpty())) {
        if (localStUserRecomInfoBusiData.bannerData.userList.get().size() == 1)
        {
          this.b.setUser((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(0));
          this.b.setVisibility(0);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
        }
        else if (localStUserRecomInfoBusiData.bannerData.userList.get().size() == 2)
        {
          this.b.setUser((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(0));
          this.c.setUser((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(1));
          this.b.setVisibility(0);
          this.c.setVisibility(0);
          this.d.setVisibility(8);
        }
        else if (localStUserRecomInfoBusiData.bannerData.userList.get().size() > 2)
        {
          this.b.setUser((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(0));
          this.c.setUser((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(1));
          this.d.setUser((FeedCloudMeta.StUser)localStUserRecomInfoBusiData.bannerData.userList.get().get(2));
          this.b.setVisibility(0);
          this.c.setVisibility(0);
          this.d.setVisibility(0);
        }
        else
        {
          this.b.setVisibility(8);
          this.c.setVisibility(8);
          this.d.setVisibility(8);
        }
      }
    }
    else
    {
      this.k.setVisibility(8);
      this.j.setVisibility(0);
      this.a.setUser(paramStUserRecomInfo.user);
      this.n = paramStUserRecomInfo.user.id.get();
      this.e.setText(paramStUserRecomInfo.user.nick.get());
      this.g.setText(paramStUserRecomInfo.user.desc.get());
      URLImageView localURLImageView = this.h;
      if (paramStUserRecomInfo.user.frdState.get() == 1) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      localURLImageView.setVisibility(paramInt);
      this.i.setUserData(paramStUserRecomInfo.user);
      if (this.p == -1) {
        if (paramStUserRecomInfo.user.followState.get() == 0) {
          this.p = 1;
        } else {
          this.p = 0;
        }
      }
      if (this.p == 1) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(29).setThrActionType(3).setExt1(this.n));
      }
    }
    if (localStUserRecomInfoBusiData.recomSource.get() == 1)
    {
      this.m.setVisibility(0);
      return;
    }
    this.m.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131626834;
  }
  
  protected String getLogTag()
  {
    return "QCircleFollowUserListItemView";
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    int i1 = 28;
    Object localObject;
    if (i2 == 2131441672)
    {
      localObject = new QCircleFollowUserBean();
      ((QCircleFollowUserBean)localObject).setUin(this.l);
      ((QCircleFollowUserBean)localObject).setAdapterClassName(QCircleFollowUserListBlock.class.getName());
      QCircleLauncher.a(getContext(), (QCircleFollowUserBean)localObject);
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(28).setThrActionType(5));
    }
    else if ((i2 == 2131441674) && (!TextUtils.isEmpty(this.n)))
    {
      localObject = new QCircleInitBean();
      ((QCircleInitBean)localObject).setUin(this.n);
      ((QCircleInitBean)localObject).setFromReportBean(getReportBean().clone());
      QCircleLauncher.b(paramView.getContext(), (QCircleInitBean)localObject);
      localObject = new QCircleLpReportDc05504.DataBuilder().setToUin(this.n).setActionType(11);
      if (this.o != 0) {
        i1 = 30;
      }
      QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setSubActionType(i1).setThrActionType(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((QCircleAvatarView)paramView.findViewById(2131441674));
    this.a.setOnClickListener(this);
    this.b = ((QCircleAvatarView)paramView.findViewById(2131441669));
    this.c = ((QCircleAvatarView)paramView.findViewById(2131441671));
    this.d = ((QCircleAvatarView)paramView.findViewById(2131441670));
    this.f = ((TextView)paramView.findViewById(2131441679));
    this.e = ((TextView)paramView.findViewById(2131441676));
    this.g = ((TextView)paramView.findViewById(2131441675));
    this.m = ((TextView)paramView.findViewById(2131441667));
    this.h = ((URLImageView)paramView.findViewById(2131441677));
    this.h.setBackgroundURL("https://sola.gtimg.cn/aoi/sola/20200619175130_E9peEWVngd.png");
    this.i = ((QCircleFollowView)paramView.findViewById(2131441673));
    this.i.setItemReportListener(new QCircleFollowUserListItemView.1(this));
    this.j = paramView.findViewById(2131441678);
    this.k = paramView.findViewById(2131441672);
    this.k.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView
 * JD-Core Version:    0.7.0.1
 */