package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.StringUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.mobileqq.pb.PBRepeatField;
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
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;

public class QCirclePushRankItemView
  extends QCircleBaseWidgetView<QQCircleDitto.StItemContainer>
  implements View.OnClickListener
{
  private URLImageView a;
  private ImageView b;
  private RoundCornerImageView c;
  private RoundCornerImageView d;
  private QCircleAvatarView e;
  private TextView f;
  private TextView g;
  private ImageView h;
  private QCircleFollowView i;
  private int j = 1;
  private QQCircleDitto.StItemInfo k;
  private byte[] l;
  
  public QCirclePushRankItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePushRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePushRankItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private FeedCloudMeta.StUser a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramStItemInfo.id.get());
    localStUser.followState.set(QCirclePluginUtil.a(paramStItemInfo.buttonInfo.buttonValue.get()));
    localStUser.nick.set(paramStItemInfo.name.get());
    return localStUser;
  }
  
  private void a(String paramString, ImageView paramImageView, Drawable paramDrawable)
  {
    QCircleFeedPicLoader.g().loadImage(new Option().setTargetView(paramImageView).setUrl(paramString).setLoadingDrawable(paramDrawable), null);
  }
  
  protected void a(QQCircleDitto.StItemContainer paramStItemContainer, int paramInt)
  {
    if (paramStItemContainer == null) {
      return;
    }
    if (paramStItemContainer.items == null) {
      return;
    }
    if (paramStItemContainer.items.size() < this.j) {
      return;
    }
    this.k = ((QQCircleDitto.StItemInfo)paramStItemContainer.items.get(this.j - 1));
    FeedCloudMeta.StUser localStUser = a(this.k);
    this.e.setUser(localStUser);
    this.i.setItemPreClickListener(new QCirclePushRankItemView.1(this));
    this.i.setFollowStateChangeListener(new QCirclePushRankItemView.2(this));
    this.f.setText(localStUser.nick.get());
    if (this.k.des.size() > 0) {
      this.g.setText((CharSequence)this.k.des.get(0));
    }
    paramInt = this.j;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          this.i.setUnFollowDrawable(2130845313);
          this.b.setImageResource(2130845282);
          a("https://sola.gtimg.cn/aoi/sola/20200623154424_iTsZYrPgUW.png", this.a, new ColorDrawable(getResources().getColor(2131167059)));
        }
      }
      else
      {
        this.i.setUnFollowDrawable(2130845313);
        this.b.setImageResource(2130845281);
        a("https://sola.gtimg.cn/aoi/sola/20200623154422_w42NLL8ijc.png", this.a, new ColorDrawable(getResources().getColor(2131167059)));
      }
    }
    else
    {
      this.i.setUnFollowDrawable(2130845313);
      this.b.setImageResource(2130845280);
      a("https://sola.gtimg.cn/aoi/sola/20200623154420_cLrwyWNcQ2.png", this.a, new ColorDrawable(getResources().getColor(2131167059)));
    }
    paramInt = paramStItemContainer.containerType.get();
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt == 3) || (paramInt == 4)) {
        this.h.setImageDrawable(getResources().getDrawable(2130845136));
      }
    }
    else {
      this.h.setImageDrawable(getResources().getDrawable(2130845146));
    }
    this.i.setFollowedDismiss(true);
    this.i.setFollowedDrawable(2130845314);
    this.i.setUserData(localStUser);
    this.c.setCorner(ViewUtils.a(8.0F));
    this.d.setCorner(ViewUtils.a(8.0F));
    if ((this.k.images.get() != null) && (this.k.images.get().size() > 0))
    {
      paramStItemContainer = (FeedCloudMeta.StImage)this.k.images.get(0);
      if ((paramStItemContainer != null) && (paramStItemContainer.picUrl.get() != null)) {
        a(paramStItemContainer.picUrl.get(), this.c, getResources().getDrawable(2130845206));
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131626941;
  }
  
  protected String getLogTag()
  {
    return "QCirclePushRankItemView";
  }
  
  protected void handleAttr(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.handleAttr(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cN);
    if (paramContext != null)
    {
      this.j = paramContext.getInt(R.styleable.cO, 1);
      paramContext.recycle();
    }
  }
  
  public void onClick(View paramView)
  {
    try
    {
      Object localObject = QCircleJsUrlConfig.a(this.k.urlInfo.get(), "RankItemUrl");
      if (StringUtil.a((String)localObject)) {
        QLog.w("QCirclePushRankItemView", 1, "rank item url is empty");
      }
      QCircleLauncher.a(getContext(), (String)localObject);
      if (getData() != null)
      {
        localObject = new QCircleLpReportDc05504.DataBuilder().setActionType(9).setSubActionType(2).setThrActionType(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((QQCircleDitto.StItemContainer)getData()).containerType.get());
        localStringBuilder.append("");
        QCircleLpReportDc05504.report(((QCircleLpReportDc05504.DataBuilder)localObject).setExt1(localStringBuilder.toString()).setFeedReportInfo(this.l).setPageId(getPageId()));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((URLImageView)paramView.findViewById(2131436610));
    this.e = ((QCircleAvatarView)paramView.findViewById(2131440996));
    this.c = ((RoundCornerImageView)paramView.findViewById(2131436334));
    this.d = ((RoundCornerImageView)paramView.findViewById(2131436336));
    this.f = ((TextView)paramView.findViewById(2131448605));
    this.g = ((TextView)paramView.findViewById(2131448665));
    this.h = ((ImageView)paramView.findViewById(2131436478));
    this.b = ((ImageView)paramView.findViewById(2131441843));
    this.i = ((QCircleFollowView)paramView.findViewById(2131442034));
    setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  public void setRank(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setReportInfo(byte[] paramArrayOfByte)
  {
    this.l = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankItemView
 * JD-Core Version:    0.7.0.1
 */