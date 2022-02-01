package com.tencent.biz.qqstory.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.lego.LegoBase;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.playmode.util.StoryTagUtil;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.BannerHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoSourceTagInfoHelper;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;

public class FeedCommentLikeLego
  extends LegoBase
  implements TagAdapter.OnItemClickListener, IEventReceiver
{
  public int a;
  public Activity a;
  protected Rect a;
  public View a;
  public TextView a;
  public FeedCommentEventHandler.KeyBoardUpCallback a;
  private FeedCommentLikeLego.MainWidgetClickListener jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLikeLego$MainWidgetClickListener;
  protected LikeManager a;
  private StoryShare jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
  public ShareGroupItem a;
  public BannerHomeFeed a;
  public CommentLikeFeedItem a;
  public CommentLikeHomeFeed a;
  private TagAdapter jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter;
  private TagFlowLayout jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout;
  public InnerListView a;
  protected boolean a;
  public TextView b;
  protected boolean b;
  private boolean c = false;
  
  public FeedCommentLikeLego(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, CommentLikeHomeFeed paramCommentLikeHomeFeed, int paramInt)
  {
    super(paramContext, 2131561660);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed = paramCommentLikeHomeFeed;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeHomeFeed.a();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager = ((LikeManager)SuperManager.a(15));
    paramContext = new FeedCommentLego(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a());
    paramActivity = FeedLikeLego.a(this.jdField_a_of_type_AndroidContentContext, paramActivity, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int);
    a("commentLego", paramContext);
    a("likeLego", paramActivity);
    paramContext.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.b());
    paramActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.c());
    i();
    h();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("FeedID:");
      paramContext.append(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
      QLog.d("FeedCommentLikeLego", 2, paramContext.toString());
    }
  }
  
  public static FeedCommentLikeLego a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, CommentLikeHomeFeed paramCommentLikeHomeFeed, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new FeedCommentLikeLego(paramContext, paramActivity, paramViewGroup, paramCommentLikeHomeFeed, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public void L_()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType == 1)
    {
      String str = "";
      Object localObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.type == 1)
      {
        localObject = (GeneralFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
        i = this.jdField_a_of_type_Int;
        if (i == 10)
        {
          localObject = ((GeneralFeedItem)localObject).wsSchemaForMain;
        }
        else if (i == 12)
        {
          localObject = ((GeneralFeedItem)localObject).wsSchemaForMemories;
        }
        else
        {
          SLog.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(i) });
          localObject = str;
        }
      }
      else
      {
        localObject = str;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.type == 3)
        {
          localObject = (GeneralRecommendFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
          i = this.jdField_a_of_type_Int;
          if (i == 10)
          {
            localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMain;
          }
          else if (i == 12)
          {
            localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMemories;
          }
          else
          {
            SLog.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(i) });
            localObject = str;
          }
        }
      }
      int i = this.jdField_a_of_type_Int;
      if (i == 10)
      {
        str = "1";
      }
      else if (i == 12)
      {
        str = "3";
      }
      else
      {
        SLog.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(i) });
        str = "-1";
      }
      WeShiGuideDialog.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 2, (String)localObject);
      if (WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
        i = 2;
      } else {
        i = 1;
      }
      StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    }
  }
  
  public LegoDataProvider a()
  {
    return null;
  }
  
  public LegoEvenHandler a()
  {
    return new FeedCommentLikeLego.1(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StoryShare localStoryShare = this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
    if (localStoryShare != null) {
      localStoryShare.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364945));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364969));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374514));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365714);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131378296));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.c = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (this.c)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables()[2];
      if (paramView != null) {
        paramView.setColorFilter(paramContext.getResources().getColor(2131166530), PorterDuff.Mode.SRC_ATOP);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColor(2131166530));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter = new TagAdapter(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter);
  }
  
  public void a(FeedCommentEventHandler.KeyBoardUpCallback paramKeyBoardUpCallback)
  {
    ((FeedCommentLego)a("commentLego")).a(paramKeyBoardUpCallback);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback = paramKeyBoardUpCallback;
  }
  
  public void a(FeedCommentLikeLego.MainWidgetClickListener paramMainWidgetClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLikeLego$MainWidgetClickListener = paramMainWidgetClickListener;
    ((FeedCommentLego)a("commentLego")).a(paramMainWidgetClickListener);
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null)
    {
      h();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)a("commentLego");
    localFeedCommentLego.a(new ShareGroupCommentEventHandler(localFeedCommentLego, paramShareGroupItem));
  }
  
  public void a(BannerHomeFeed paramBannerHomeFeed)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed = paramBannerHomeFeed;
  }
  
  public void a(CommentLikeHomeFeed paramCommentLikeHomeFeed, ShareGroupItem paramShareGroupItem, BannerHomeFeed paramBannerHomeFeed)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed = paramCommentLikeHomeFeed;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeHomeFeed.a();
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)a("commentLego");
    FeedLikeLego localFeedLikeLego = (FeedLikeLego)a("likeLego");
    i();
    h();
    if (paramBannerHomeFeed != null) {
      a(paramBannerHomeFeed);
    } else if (paramShareGroupItem != null) {
      a(paramShareGroupItem);
    }
    localFeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentLikeHomeFeed.a());
    localFeedLikeLego.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    localFeedCommentLego.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.b());
    localFeedLikeLego.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.c());
  }
  
  public void a(TagItem.TagInfoBase paramTagInfoBase)
  {
    StoryTagUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramTagInfoBase);
    int i = this.jdField_a_of_type_Int;
    String str2 = "1";
    String str1;
    if (i == 10)
    {
      str1 = "1";
    }
    else if (i == 12)
    {
      str1 = "3";
    }
    else
    {
      SLog.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(i));
      str1 = "-1";
    }
    if (paramTagInfoBase.jdField_a_of_type_Int != 0) {
      str2 = "2";
    }
    StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(paramTagInfoBase.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
  }
  
  public void a(List paramList)
  {
    paramList = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
    boolean bool2 = paramList.isVipButNoFriend();
    paramList.isSubscribeButNoFriend();
    if (!bool2) {
      paramList.isMe();
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime > 0L) && ((paramList.isMe()) || (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed != null)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramList = this.jdField_a_of_type_AndroidWidgetTextView;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131704523));
      ((StringBuilder)localObject).append(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime));
      paramList.setText(((StringBuilder)localObject).toString());
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
    {
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.a(), false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838740));
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.89F);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed instanceof GeneralHomeFeed;
    int i = 1;
    if (bool1)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType == 1)
      {
        localObject = VideoSourceTagInfoHelper.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType);
        paramList = (List)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramList = (List)localObject;
          if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedSourceTagType == 1) {
            paramList = "来自微视APP";
          }
        }
        bool1 = true;
      }
      else
      {
        paramList = "";
        bool1 = false;
      }
      localObject = ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem).mQimSyncWording;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter.a(((GeneralHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed).d, (String)localObject, ((GeneralHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed).c, bool1, paramList);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter.a(this);
      if (bool2)
      {
        if (this.jdField_a_of_type_Int == 10) {
          paramList = "1";
        } else {
          paramList = "3";
        }
        StoryReportor.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a().getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a().feedId });
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount > 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount > this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.b().size()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramList = this.jdField_b_of_type_AndroidWidgetTextView;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131704549));
      ((StringBuilder)localObject).append(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131704527));
      paramList.setText(((StringBuilder)localObject).toString());
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() != 2) {
      i = 0;
    }
    if (i != 0) {
      ((TroopNickNameManager)SuperManager.a(23)).c();
    }
    d();
  }
  
  public void b() {}
  
  public void c()
  {
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)a("commentLego");
    FeedLikeLego localFeedLikeLego = (FeedLikeLego)a("likeLego");
    localFeedCommentLego.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.b());
    localFeedLikeLego.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.c());
  }
  
  public void d()
  {
    int k = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.b().size();
    int j;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.c().size() <= 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount <= 0)) {
      j = 0;
    } else {
      j = 1;
    }
    int i;
    if ((k == 0) && (j == 0))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount > k) {
        i = StoryApi.a(2131427364);
      } else {
        i = StoryApi.a(2131427361);
      }
    }
    else if ((j != 0) && (k == 0)) {
      i = StoryApi.a(2131427363);
    } else if ((k > 0) && (j == 0)) {
      i = StoryApi.a(2131427362);
    } else {
      i = StoryApi.a(2131427359);
    }
    this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, i));
    if ((k > 0) && (j == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, 0, 0, 0);
      return;
    }
    float f = StoryApi.a(2131427360);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, f + 0.5F), 0, 0);
  }
  
  public void e()
  {
    CommentLikeHomeFeed localCommentLikeHomeFeed = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed;
    if ((localCommentLikeHomeFeed instanceof GeneralHomeFeed))
    {
      ((GeneralHomeFeed)localCommentLikeHomeFeed).c ^= true;
      StoryReportor.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    }
  }
  
  public void f()
  {
    StoryTagUtil.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    int i = this.jdField_a_of_type_Int;
    String str;
    if (i == 10)
    {
      str = "1";
    }
    else if (i == 12)
    {
      str = "3";
    }
    else
    {
      SLog.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(i));
      str = "-1";
    }
    StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = null;
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)a("commentLego");
    localFeedCommentLego.a(new FeedCommentEventHandler(localFeedCommentLego));
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed = null;
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLikeLego
 * JD-Core Version:    0.7.0.1
 */