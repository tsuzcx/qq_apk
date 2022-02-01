package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import aaae;
import aalu;
import aalw;
import aaxb;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import bclx;
import bgmg;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import yqp;
import zwp;
import zwr;
import zzx;

public class RelativeFeedItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
  implements zwr
{
  private int jdField_a_of_type_Int = ImmersiveUtils.a() / 2;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840264);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public RoundCornerImageView a;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
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
    String str1;
    int j;
    if (paramInt == 1)
    {
      str1 = "like";
      aaxb.a(str2, "auth_feeds", str1, 0, this.jdField_c_of_type_Int, new String[] { "", "", ((CertifiedAccountMeta.StFeed)a()).poster.nick.get(), ((CertifiedAccountMeta.StFeed)a()).title.get() });
      j = ((CertifiedAccountMeta.StFeed)a()).likeInfo.count.get();
      if (paramInt != 1) {
        break label177;
      }
    }
    label177:
    for (int i = 1;; i = -1)
    {
      ((CertifiedAccountMeta.StFeed)a()).likeInfo.count.set(j + i);
      ((CertifiedAccountMeta.StFeed)a()).likeInfo.status.set(paramInt);
      b((CertifiedAccountMeta.StFeed)a());
      return;
      str1 = "cancel_like";
      break;
    }
  }
  
  private void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed.likeInfo.count.get() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!this.jdField_c_of_type_Boolean) {
        break label94;
      }
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramStFeed.likeInfo.status.get() != 1) {
        break label88;
      }
    }
    label88:
    for (int i = 2130839055;; i = 2130839053)
    {
      localImageView.setImageResource(i);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramStFeed.likeInfo.count.get()));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
    label94:
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramStFeed.likeInfo.status.get() == 1) {}
    for (i = 2130839054;; i = 2130839052)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  public float a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    float f1 = 1.333333F;
    if ((paramStFeed.cover.width.get() == 0) || (paramStFeed.cover.height.get() == 0))
    {
      yqp.c("RelativeFeedItemView", "getImageScale()  return 3/4");
      return 0.75F;
    }
    float f2 = paramStFeed.cover.height.get() / paramStFeed.cover.width.get();
    if (f2 > 1.333333F) {}
    for (;;)
    {
      yqp.c("RelativeFeedItemView", "getImageScale()  feed.width:" + paramStFeed.cover.width.get() + "  feed.height:" + paramStFeed.cover.height.get() + "  realHeight=" + f1);
      return f1;
      f1 = f2;
    }
  }
  
  public int a()
  {
    return 2131558801;
  }
  
  public View.OnClickListener a()
  {
    return new aalw(this);
  }
  
  public View a()
  {
    return this;
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    Object localObject;
    label52:
    label195:
    label242:
    label630:
    do
    {
      return;
      String str = paramStFeed.title.get();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = paramStFeed.content.get();
      }
      float f;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(8);
        if (paramStFeed.poster != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStFeed.poster.nick.get());
        }
        if (paramStFeed.likeInfo != null) {
          b(paramStFeed);
        }
        if (!aaae.a(paramStFeed.type.get())) {
          break label553;
        }
        int i = paramStFeed.video.duration.get() / 1000 / 60;
        int j = paramStFeed.video.duration.get() / 1000;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
        if (paramStFeed.video.width.get() < paramStFeed.video.height.get()) {
          break label547;
        }
        f = 0.75F;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ((int)(f * this.jdField_a_of_type_Int));
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.requestLayout();
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        zzx.a(paramStFeed.cover.url.get(), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, null, bgmg.c(paramStFeed.cover.url.get()));
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width = bclx.a(18.0F);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = bclx.a(18.0F);
        zzx.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
        if ((paramStFeed.status.get() != 3) || (!BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStFeed.poster.id.get()))) {
          break label608;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aalu(this, paramStFeed));
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
        if (localObject == null) {
          break;
        }
        if (((ExtraTypeInfo)localObject).pageType != 7003) {
          break label630;
        }
        aaxb.a(paramStFeed.poster.id.get(), "auth_follow", "new_c_exp", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
        return;
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setVisibility(0);
        break label52;
        f = 1.333333F;
        break label195;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ((int)(this.jdField_a_of_type_Int * a(paramStFeed)));
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.requestLayout();
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label242;
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
    } while (((ExtraTypeInfo)localObject).pageType != 7004);
    label547:
    label553:
    label608:
    aaxb.b(paramStFeed.poster.id.get(), "auth_discover", "exp_content", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131379659));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379523));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379656));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131369123));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(4.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369035));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379653));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370174);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369231));
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
    zwp.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_b_of_type_Boolean = false;
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((a() != null) && ((paramSimpleBaseEvent instanceof PraisedUpdateEvents)) && (((CertifiedAccountMeta.StFeed)a()).id.get().equals(((PraisedUpdateEvents)paramSimpleBaseEvent).mTargetFeedId)) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
      a(((PraisedUpdateEvents)paramSimpleBaseEvent).mPraisedStatus);
    }
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView
 * JD-Core Version:    0.7.0.1
 */