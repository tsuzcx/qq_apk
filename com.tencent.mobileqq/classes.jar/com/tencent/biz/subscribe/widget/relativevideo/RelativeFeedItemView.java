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
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840321);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public RoundCornerImageView a;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = ImmersiveUtils.getScreenWidth() / 2;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  
  public RelativeFeedItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (a() == null) {
      return;
    }
    String str2 = ((CertifiedAccountMeta.StFeed)a()).poster.id.get();
    int i = 1;
    String str1;
    if (paramInt == 1) {
      str1 = "like";
    } else {
      str1 = "cancel_like";
    }
    VSReporter.a(str2, "auth_feeds", str1, 0, this.jdField_a_of_type_Int, new String[] { "", "", ((CertifiedAccountMeta.StFeed)a()).poster.nick.get(), ((CertifiedAccountMeta.StFeed)a()).title.get() });
    int j = ((CertifiedAccountMeta.StFeed)a()).likeInfo.count.get();
    if (paramInt != 1) {
      i = -1;
    }
    ((CertifiedAccountMeta.StFeed)a()).likeInfo.count.set(j + i);
    ((CertifiedAccountMeta.StFeed)a()).likeInfo.status.set(paramInt);
    b((CertifiedAccountMeta.StFeed)a());
  }
  
  private void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed.likeInfo.count.get() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramStFeed.likeInfo.count.get()));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramStFeed.likeInfo.status.get() == 1) {
        i = 2130839039;
      } else {
        i = 2130839037;
      }
      localImageView.setImageResource(i);
      return;
    }
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramStFeed.likeInfo.status.get() == 1) {
      i = 2130839038;
    } else {
      i = 2130839036;
    }
    localImageView.setImageResource(i);
  }
  
  public float a(CertifiedAccountMeta.StFeed paramStFeed)
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
  
  protected int a()
  {
    return 2131558770;
  }
  
  protected View.OnClickListener a()
  {
    return new RelativeFeedItemView.2(this);
  }
  
  protected View a()
  {
    return this;
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
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(0);
    }
    if (paramStFeed.poster != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStFeed.poster.nick.get());
    }
    if (paramStFeed.likeInfo != null) {
      b(paramStFeed);
    }
    if (SubscribeLaucher.a(paramStFeed.type.get()))
    {
      int i = paramStFeed.video.duration.get() / 1000 / 60;
      int j = paramStFeed.video.duration.get() / 1000;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
      float f;
      if (paramStFeed.video.width.get() >= paramStFeed.video.height.get()) {
        f = 0.75F;
      } else {
        f = 1.333333F;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ((int)(this.jdField_c_of_type_Int * f));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.requestLayout();
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ((int)(this.jdField_c_of_type_Int * a(paramStFeed)));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = this.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.requestLayout();
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    SubImageLoader.a(paramStFeed.cover.url.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, null, FileUtils.isLocalPath(paramStFeed.cover.url.get()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width = ScreenUtil.dip2px(18.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = ScreenUtil.dip2px(18.0F);
    SubImageLoader.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
    if ((paramStFeed.status.get() == 3) && (BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStFeed.poster.id.get()))) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new RelativeFeedItemView.1(this, paramStFeed));
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(1711276032);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setTextColor(-5723992);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setColorFilter(1711276032);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-10132123);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-5723992);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10132123);
    }
    localObject = a();
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
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131379675));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379529));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379671));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131369356));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(4.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369284));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379668));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370333);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369448));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(PraisedUpdateEvents.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_b_of_type_Boolean = true;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_b_of_type_Boolean = false;
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((a() != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)))
    {
      String str = ((CertifiedAccountMeta.StFeed)a()).id.get();
      paramSimpleBaseEvent = (PraisedUpdateEvents)paramSimpleBaseEvent;
      if ((str.equals(paramSimpleBaseEvent.mTargetFeedId)) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
        a(paramSimpleBaseEvent.mPraisedStatus);
      }
    }
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView
 * JD-Core Version:    0.7.0.1
 */