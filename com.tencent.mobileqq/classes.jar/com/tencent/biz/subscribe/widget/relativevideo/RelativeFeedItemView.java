package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class RelativeFeedItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
  implements SimpleEventReceiver
{
  public RoundCornerImageView c;
  private AsyncRichTextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private SquareImageView h;
  private int i = ImmersiveUtils.getScreenWidth() / 2;
  private Drawable j = getResources().getDrawable(2130841060);
  private View k;
  private ImageView l;
  private volatile boolean m = true;
  private boolean n;
  private boolean o;
  
  public RelativeFeedItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (getData() == null) {
      return;
    }
    String str2 = ((CertifiedAccountMeta.StFeed)getData()).poster.id.get();
    int i1 = 1;
    String str1;
    if (paramInt == 1) {
      str1 = "like";
    } else {
      str1 = "cancel_like";
    }
    VSReporter.a(str2, "auth_feeds", str1, 0, this.a, new String[] { "", "", ((CertifiedAccountMeta.StFeed)getData()).poster.nick.get(), ((CertifiedAccountMeta.StFeed)getData()).title.get() });
    int i2 = ((CertifiedAccountMeta.StFeed)getData()).likeInfo.count.get();
    if (paramInt != 1) {
      i1 = -1;
    }
    ((CertifiedAccountMeta.StFeed)getData()).likeInfo.count.set(i2 + i1);
    ((CertifiedAccountMeta.StFeed)getData()).likeInfo.status.set(paramInt);
    setPraisedUI((CertifiedAccountMeta.StFeed)getData());
  }
  
  private void setPraisedUI(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed.likeInfo.count.get() == 0)
    {
      this.f.setVisibility(8);
    }
    else
    {
      this.f.setText(String.valueOf(paramStFeed.likeInfo.count.get()));
      this.f.setVisibility(0);
    }
    int i1;
    if (this.o)
    {
      localImageView = this.l;
      if (paramStFeed.likeInfo.status.get() == 1) {
        i1 = 2130839193;
      } else {
        i1 = 2130839191;
      }
      localImageView.setImageResource(i1);
      return;
    }
    ImageView localImageView = this.l;
    if (paramStFeed.likeInfo.status.get() == 1) {
      i1 = 2130839192;
    } else {
      i1 = 2130839190;
    }
    localImageView.setImageResource(i1);
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    String str = paramStFeed.title.get();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = paramStFeed.content.get();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.d.setVisibility(8);
    }
    else
    {
      this.d.setText((CharSequence)localObject);
      this.d.setVisibility(0);
    }
    if (paramStFeed.poster != null) {
      this.e.setText(paramStFeed.poster.nick.get());
    }
    if (paramStFeed.likeInfo != null) {
      setPraisedUI(paramStFeed);
    }
    if (SubscribeLaucher.a(paramStFeed.type.get()))
    {
      int i1 = paramStFeed.video.duration.get() / 1000 / 60;
      int i2 = paramStFeed.video.duration.get() / 1000;
      this.g.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2 % 60) }));
      float f1;
      if (paramStFeed.video.width.get() >= paramStFeed.video.height.get()) {
        f1 = 0.75F;
      } else {
        f1 = 1.333333F;
      }
      this.c.getLayoutParams().height = ((int)(this.i * f1));
      this.c.getLayoutParams().width = this.i;
      this.c.requestLayout();
      this.g.setVisibility(0);
    }
    else
    {
      this.c.getLayoutParams().height = ((int)(this.i * b(paramStFeed)));
      this.c.getLayoutParams().width = this.i;
      this.c.requestLayout();
      this.g.setVisibility(8);
    }
    SubImageLoader.a(paramStFeed.cover.url.get(), this.c, null, FileUtils.isLocalPath(paramStFeed.cover.url.get()));
    this.h.getLayoutParams().width = ScreenUtil.dip2px(18.0F);
    this.h.getLayoutParams().height = ScreenUtil.dip2px(18.0F);
    SubImageLoader.a(paramStFeed.poster.icon.get(), this.h);
    if ((paramStFeed.status.get() == 3) && (BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStFeed.poster.id.get()))) {
      this.k.setVisibility(0);
    } else if (this.k.getVisibility() == 0) {
      this.k.setVisibility(8);
    }
    this.l.setOnClickListener(new RelativeFeedItemView.1(this, paramStFeed));
    if (this.o)
    {
      this.h.setFilterColor(1711276032);
      this.d.setTextColor(-5723992);
      this.c.setColorFilter(1711276032);
      this.e.setTextColor(-10132123);
      this.g.setTextColor(-5723992);
      this.f.setTextColor(-10132123);
    }
    localObject = getExtraTypeInfo();
    if (localObject != null)
    {
      if (((ExtraTypeInfo)localObject).pageType == 7003)
      {
        VSReporter.a(paramStFeed.poster.id.get(), "auth_follow", "new_c_exp", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
        return;
      }
      if (((ExtraTypeInfo)localObject).pageType == 7004) {
        VSReporter.b(paramStFeed.poster.id.get(), "auth_discover", "exp_content", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
      }
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.d = ((AsyncRichTextView)findViewById(2131448455));
    this.e = ((TextView)findViewById(2131448280));
    this.f = ((TextView)findViewById(2131448451));
    this.c = ((RoundCornerImageView)findViewById(2131436373));
    this.c.setCorner(ImmersiveUtils.dpToPx(4.0F));
    this.h = ((SquareImageView)findViewById(2131436269));
    this.g = ((TextView)findViewById(2131448448));
    this.k = findViewById(2131437590);
    this.l = ((ImageView)findViewById(2131436504));
  }
  
  public float b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((paramStFeed.cover.width.get() != 0) && (paramStFeed.cover.height.get() != 0))
    {
      float f2 = paramStFeed.cover.height.get() / paramStFeed.cover.width.get();
      float f1 = f2;
      if (f2 > 1.333333F) {
        f1 = 1.333333F;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getImageScale()  feed.width:");
      localStringBuilder.append(paramStFeed.cover.width.get());
      localStringBuilder.append("  feed.height:");
      localStringBuilder.append(paramStFeed.cover.height.get());
      localStringBuilder.append("  realHeight=");
      localStringBuilder.append(f1);
      SLog.c("RelativeFeedItemView", localStringBuilder.toString());
      return f1;
    }
    SLog.c("RelativeFeedItemView", "getImageScale()  return 3/4");
    return 0.75F;
  }
  
  protected View f()
  {
    return this;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PraisedUpdateEvents.class);
    return localArrayList;
  }
  
  protected int getLayoutId()
  {
    return 2131624390;
  }
  
  protected View.OnClickListener getOnClickLister()
  {
    return new RelativeFeedItemView.2(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.n = true;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.n = false;
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((getData() != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)))
    {
      String str = ((CertifiedAccountMeta.StFeed)getData()).id.get();
      paramSimpleBaseEvent = (PraisedUpdateEvents)paramSimpleBaseEvent;
      if ((str.equals(paramSimpleBaseEvent.mTargetFeedId)) && (this.f != null)) {
        a(paramSimpleBaseEvent.mPraisedStatus);
      }
    }
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView
 * JD-Core Version:    0.7.0.1
 */