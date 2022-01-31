package com.tencent.biz.qqstory.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.tencent.biz.qqstory.storyHome.model.GeneralHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter;
import com.tencent.biz.qqstory.storyHome.tag.TagAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.storyHome.tag.TagFlowLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;
import nam;

public class FeedCommentLikeLego
  extends LegoBase
  implements TagAdapter.OnItemClickListener, IEventReceiver
{
  public int a;
  public Activity a;
  protected Rect a;
  public View a;
  public ImageView a;
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
  public ImageView b;
  public TextView b;
  private boolean b;
  public ImageView c;
  public ImageView d;
  
  public FeedCommentLikeLego(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, CommentLikeHomeFeed paramCommentLikeHomeFeed, int paramInt)
  {
    super(paramContext, 2130970678);
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
    j();
    i();
    if (QLog.isColorLevel()) {
      QLog.d("FeedCommentLikeLego", 2, "FeedID:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
    }
  }
  
  public static FeedCommentLikeLego a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, CommentLikeHomeFeed paramCommentLikeHomeFeed, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new FeedCommentLikeLego(paramContext, paramActivity, paramViewGroup, paramCommentLikeHomeFeed, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public LegoDataProvider a()
  {
    return null;
  }
  
  public LegoEvenHandler a()
  {
    return new nam(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371565));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371566));
    this.d = ((ImageView)paramView.findViewById(2131371567));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371571));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131371570));
    this.c = ((ImageView)paramView.findViewById(2131371536));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371568));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131371569);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout = ((TagFlowLayout)paramView.findViewById(2131371477));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.d.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.c.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentLegoLegoEvenHandler);
    this.jdField_b_of_type_Boolean = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843320);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843314);
      this.d.setImageResource(2130843317);
      this.c.setImageResource(2130843357);
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
      i();
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
    j();
    i();
    if (paramBannerHomeFeed != null) {
      a(paramBannerHomeFeed);
    }
    for (;;)
    {
      localFeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, paramCommentLikeHomeFeed.a());
      localFeedLikeLego.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      localFeedCommentLego.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.b());
      localFeedLikeLego.c(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.c());
      return;
      if (paramShareGroupItem != null) {
        a(paramShareGroupItem);
      }
    }
  }
  
  public void a(TagItem.TagInfoBase paramTagInfoBase)
  {
    StoryTagUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramTagInfoBase);
    String str1;
    if (this.jdField_a_of_type_Int == 10)
    {
      str1 = "1";
      if (paramTagInfoBase.jdField_a_of_type_Int != 0) {
        break label115;
      }
    }
    label115:
    for (String str2 = "1";; str2 = "2")
    {
      StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(paramTagInfoBase.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str1 = "3";
        break;
      }
      SLog.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
      str1 = "-1";
      break;
    }
  }
  
  public void a(List paramList)
  {
    int j = 1;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike == 1)
    {
      bool1 = true;
      b(bool1);
      paramList = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      bool1 = paramList.isVipButNoFriend();
      boolean bool2 = paramList.isSubscribeButNoFriend();
      if ((!bool1) && (!paramList.isMe()) && (!bool2)) {
        break label502;
      }
      i = 1;
      label67:
      if ((i == 0) && ((this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic()))) {
        break label507;
      }
      this.d.setVisibility(0);
      label96:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime <= 0L) || ((!paramList.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem == null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed == null))) {
        break label519;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("浏览" + UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mViewTotalTime));
      label175:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem()) {
        break label531;
      }
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.a(), false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838211));
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.89F);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label234:
      if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed instanceof GeneralHomeFeed)) {
        break label550;
      }
      paramList = ((VideoListFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem).mQimSyncWording;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter.a(((GeneralHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed).d, paramList, ((GeneralHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed).c, bool1);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagAdapter.a(this);
      if (bool1)
      {
        if (this.jdField_a_of_type_Int != 10) {
          break label543;
        }
        paramList = "1";
        label319:
        StoryReportor.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a().getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.a().feedId });
      }
      label375:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.b().size())) {
        break label562;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("全部" + UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount) + "条评论");
      label458:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getRelationType() != 2) {
        break label574;
      }
    }
    label519:
    label531:
    label543:
    label550:
    label562:
    label574:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        ((TroopNickNameManager)SuperManager.a(23)).c();
      }
      d();
      return;
      bool1 = false;
      break;
      label502:
      i = 0;
      break label67;
      label507:
      this.d.setVisibility(8);
      break label96;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label175;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label234;
      paramList = "3";
      break label319;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeTagTagFlowLayout.setVisibility(8);
      break label375;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label458;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843315);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843320);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843319);
  }
  
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
    int i;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed.c().size() > 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mLikeCount > 0))
    {
      j = 1;
      if ((k != 0) || (j != 0)) {
        break label124;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mCommentCount <= k) {
        break label114;
      }
      i = StoryApi.a(2131689497);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, i));
      if ((k <= 0) || (j != 0)) {
        break label172;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, 0, 0, 0);
      return;
      j = 0;
      break;
      label114:
      i = StoryApi.a(2131689498);
      continue;
      label124:
      if ((j != 0) && (k == 0)) {
        i = StoryApi.a(2131689499);
      } else if ((k > 0) && (j == 0)) {
        i = StoryApi.a(2131689500);
      } else {
        i = StoryApi.a(2131689501);
      }
    }
    label172:
    float f = StoryApi.a(2131689502);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setPadding(0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, f + 0.5F), 0, 0);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.isFakeFeedItem())
    {
      QQToast.a(BaseApplication.getContext(), 1, "视频上传失败，无法点赞", 0).a();
      return;
    }
    boolean bool;
    label39:
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mHadLike != 1)
    {
      bool = true;
      FeedLikeDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, bool, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType(), 0);
      ((FeedLikeLego)a("likeLego")).a(bool);
      b(bool);
      FeedCommentLego.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, 0);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner();
      i = StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!(localObject instanceof ShareGroupItem)) {
        break label209;
      }
    }
    label209:
    for (Object localObject = ((IFeedOwner)localObject).getUnionId();; localObject = "")
    {
      StoryReportor.a("home_page", "clk_like", StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), StoryReportor.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, localObject });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FeedCommentLikeLego", 2, "onLikeBtnClick: isLike:" + bool);
      return;
      bool = false;
      break label39;
    }
  }
  
  public void f()
  {
    GeneralHomeFeed localGeneralHomeFeed;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed instanceof GeneralHomeFeed))
    {
      localGeneralHomeFeed = (GeneralHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed;
      if (((GeneralHomeFeed)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeHomeFeed).c) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      localGeneralHomeFeed.c = bool;
      StoryReportor.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
    }
  }
  
  public void g()
  {
    StoryTagUtil.a(this.jdField_a_of_type_AndroidContentContext, "com.tencent.qim");
    String str;
    if (this.jdField_a_of_type_Int == 10) {
      str = "1";
    }
    for (;;)
    {
      StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
      }
      else
      {
        SLog.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
        str = "-1";
      }
    }
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_Int == 10)
    {
      str = "1";
      WeShiGuideDialog.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId);
      if (!WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
        break label142;
      }
    }
    label142:
    for (int i = 2;; i = 1)
    {
      StoryReportor.a("weishi_share", "tag_clk", 0, i, new String[] { str, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().getUnionId(), "weishi", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      if (this.jdField_a_of_type_Int == 12)
      {
        str = "3";
        break;
      }
      SLog.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(this.jdField_a_of_type_Int));
      str = "-1";
      break;
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = null;
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)a("commentLego");
    localFeedCommentLego.a(new FeedCommentEventHandler(localFeedCommentLego));
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelBannerHomeFeed = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLikeLego
 * JD-Core Version:    0.7.0.1
 */