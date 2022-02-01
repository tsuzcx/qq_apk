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
  public CommentLikeFeedItem a;
  public CommentLikeHomeFeed b;
  public ShareGroupItem c;
  public BannerHomeFeed d;
  public int e;
  public InnerListView f;
  public TextView g;
  public View h;
  public TextView i;
  public Activity j;
  public FeedCommentEventHandler.KeyBoardUpCallback k;
  protected boolean l = false;
  protected boolean m = false;
  protected Rect n = new Rect();
  protected LikeManager o;
  private TagFlowLayout t;
  private TagAdapter u;
  private boolean v = false;
  private FeedCommentLikeLego.MainWidgetClickListener w;
  private StoryShare x;
  
  public FeedCommentLikeLego(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, CommentLikeHomeFeed paramCommentLikeHomeFeed, int paramInt)
  {
    super(paramContext, 2131628039);
    this.b = paramCommentLikeHomeFeed;
    this.a = paramCommentLikeHomeFeed.c();
    this.j = paramActivity;
    this.e = paramInt;
    this.o = ((LikeManager)SuperManager.a(15));
    paramContext = new FeedCommentLego(this.p, this.j, this.q, this.a, this.e, this.b.a());
    paramActivity = FeedLikeLego.a(this.p, paramActivity, this.q, this.a, this.e);
    a("commentLego", paramContext);
    a("likeLego", paramActivity);
    paramContext.b(this.b.d());
    paramActivity.b(this.b.f());
    k();
    j();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("FeedID:");
      paramContext.append(this.a.feedId);
      QLog.d("FeedCommentLikeLego", 2, paramContext.toString());
    }
  }
  
  public static FeedCommentLikeLego a(Context paramContext, Activity paramActivity, ViewGroup paramViewGroup, CommentLikeHomeFeed paramCommentLikeHomeFeed, int paramInt, ShareGroupItem paramShareGroupItem)
  {
    paramContext = new FeedCommentLikeLego(paramContext, paramActivity, paramViewGroup, paramCommentLikeHomeFeed, paramInt);
    paramContext.a(paramShareGroupItem);
    return paramContext;
  }
  
  public LegoEvenHandler a()
  {
    return new FeedCommentLikeLego.1(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StoryShare localStoryShare = this.x;
    if (localStoryShare != null) {
      localStoryShare.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.i = ((TextView)paramView.findViewById(2131431070));
    this.f = ((InnerListView)paramView.findViewById(2131431096));
    this.g = ((TextView)paramView.findViewById(2131442684));
    this.h = paramView.findViewById(2131431956);
    this.t = ((TagFlowLayout)paramView.findViewById(2131446815));
    this.i.setOnClickListener(this.s);
    this.h.setOnClickListener(this.s);
    this.g.setOnClickListener(this.s);
    this.v = ThemeUtil.isNowThemeIsNight(QQStoryContext.j(), false, null);
    if (this.v)
    {
      paramView = this.g.getCompoundDrawables()[2];
      if (paramView != null) {
        paramView.setColorFilter(paramContext.getResources().getColor(2131167387), PorterDuff.Mode.SRC_ATOP);
      }
      this.g.setCompoundDrawablesWithIntrinsicBounds(null, null, paramView, null);
      this.i.setTextColor(paramContext.getResources().getColor(2131167387));
    }
    this.u = new TagAdapter(this.p);
    this.t.setAdapter(this.u);
  }
  
  public void a(FeedCommentEventHandler.KeyBoardUpCallback paramKeyBoardUpCallback)
  {
    ((FeedCommentLego)b("commentLego")).a(paramKeyBoardUpCallback);
    this.k = paramKeyBoardUpCallback;
  }
  
  public void a(FeedCommentLikeLego.MainWidgetClickListener paramMainWidgetClickListener)
  {
    this.w = paramMainWidgetClickListener;
    ((FeedCommentLego)b("commentLego")).a(paramMainWidgetClickListener);
  }
  
  public void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null)
    {
      j();
      return;
    }
    this.c = paramShareGroupItem;
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)b("commentLego");
    localFeedCommentLego.a(new ShareGroupCommentEventHandler(localFeedCommentLego, paramShareGroupItem));
  }
  
  public void a(BannerHomeFeed paramBannerHomeFeed)
  {
    this.d = paramBannerHomeFeed;
  }
  
  public void a(CommentLikeHomeFeed paramCommentLikeHomeFeed, ShareGroupItem paramShareGroupItem, BannerHomeFeed paramBannerHomeFeed)
  {
    this.b = paramCommentLikeHomeFeed;
    this.a = paramCommentLikeHomeFeed.c();
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)b("commentLego");
    FeedLikeLego localFeedLikeLego = (FeedLikeLego)b("likeLego");
    k();
    j();
    if (paramBannerHomeFeed != null) {
      a(paramBannerHomeFeed);
    } else if (paramShareGroupItem != null) {
      a(paramShareGroupItem);
    }
    localFeedCommentLego.a(this.a, paramCommentLikeHomeFeed.a());
    localFeedLikeLego.a(this.a);
    localFeedCommentLego.c(this.b.d());
    localFeedLikeLego.c(this.b.f());
  }
  
  public void a(TagItem.TagInfoBase paramTagInfoBase)
  {
    StoryTagUtil.a(this.j, paramTagInfoBase);
    int i1 = this.e;
    String str2 = "1";
    String str1;
    if (i1 == 10)
    {
      str1 = "1";
    }
    else if (i1 == 12)
    {
      str1 = "3";
    }
    else
    {
      SLog.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(i1));
      str1 = "-1";
    }
    if (paramTagInfoBase.d != 0) {
      str2 = "2";
    }
    StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { str1, str2, String.valueOf(paramTagInfoBase.a), this.a.feedId });
  }
  
  public void a(List paramList)
  {
    paramList = this.a.getOwner();
    boolean bool2 = paramList.isVipButNoFriend();
    paramList.isSubscribeButNoFriend();
    if (!bool2) {
      paramList.isMe();
    }
    Object localObject;
    if ((this.a.mViewTotalTime > 0L) && ((paramList.isMe()) || (this.c != null) || (this.d != null)))
    {
      this.g.setVisibility(0);
      paramList = this.g;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131902434));
      ((StringBuilder)localObject).append(UIUtils.a(this.a.mViewTotalTime));
      paramList.setText(((StringBuilder)localObject).toString());
    }
    else
    {
      this.g.setVisibility(8);
    }
    if (this.a.isFakeFeedItem())
    {
      if (!ThemeUtil.isNowThemeIsDefault(QQStoryContext.j(), false, null))
      {
        this.h.setBackgroundDrawable(this.p.getResources().getDrawable(2130838959));
        this.h.setAlpha(0.89F);
      }
      this.h.setVisibility(0);
    }
    else
    {
      this.h.setVisibility(8);
    }
    boolean bool1 = this.b instanceof GeneralHomeFeed;
    int i1 = 1;
    if (bool1)
    {
      if (this.a.feedSourceTagType == 1)
      {
        localObject = VideoSourceTagInfoHelper.b(this.a.feedSourceTagType);
        paramList = (List)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramList = (List)localObject;
          if (this.a.feedSourceTagType == 1) {
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
      localObject = ((VideoListFeedItem)this.a).mQimSyncWording;
      this.t.setVisibility(0);
      this.u.a(((GeneralHomeFeed)this.b).j, (String)localObject, ((GeneralHomeFeed)this.b).k, bool1, paramList);
      this.u.a(this);
      if (bool2)
      {
        if (this.e == 10) {
          paramList = "1";
        } else {
          paramList = "3";
        }
        StoryReportor.a("weishi_share", "tag_exp", 0, 0, new String[] { paramList, this.b.c().getOwner().getUnionId(), "weishi", this.b.c().feedId });
      }
    }
    else
    {
      this.t.setVisibility(8);
    }
    if ((this.a.mCommentCount > 0) && (this.a.mCommentCount > this.b.d().size()))
    {
      this.i.setVisibility(0);
      paramList = this.i;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131902459));
      ((StringBuilder)localObject).append(UIUtils.a(this.a.mCommentCount));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131902437));
      paramList.setText(((StringBuilder)localObject).toString());
    }
    else
    {
      this.i.setVisibility(8);
    }
    if (this.a.getOwner().getRelationType() != 2) {
      i1 = 0;
    }
    if (i1 != 0) {
      ((TroopNickNameManager)SuperManager.a(23)).c();
    }
    f();
  }
  
  public LegoDataProvider b()
  {
    return null;
  }
  
  public void bu_()
  {
    CommentLikeHomeFeed localCommentLikeHomeFeed = this.b;
    if ((localCommentLikeHomeFeed instanceof GeneralHomeFeed))
    {
      ((GeneralHomeFeed)localCommentLikeHomeFeed).k ^= true;
      StoryReportor.a("home_page", "clk_tag_more", 0, 0, new String[] { "", "", "", this.a.feedId });
    }
  }
  
  public void bv_()
  {
    StoryTagUtil.a(this.p, "com.tencent.qim");
    int i1 = this.e;
    String str;
    if (i1 == 10)
    {
      str = "1";
    }
    else if (i1 == 12)
    {
      str = "3";
    }
    else
    {
      SLog.a("FeedCommentLikeLego", "unknown feedType: %s", Integer.valueOf(i1));
      str = "-1";
    }
    StoryReportor.a("home_page", "clk_tag", 0, 0, new String[] { str, "3", "", this.a.feedId });
  }
  
  public void bw_()
  {
    if (this.a.feedSourceTagType == 1)
    {
      String str = "";
      Object localObject;
      if (this.a.type == 1)
      {
        localObject = (GeneralFeedItem)this.a;
        i1 = this.e;
        if (i1 == 10)
        {
          localObject = ((GeneralFeedItem)localObject).wsSchemaForMain;
        }
        else if (i1 == 12)
        {
          localObject = ((GeneralFeedItem)localObject).wsSchemaForMemories;
        }
        else
        {
          SLog.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(i1) });
          localObject = str;
        }
      }
      else
      {
        localObject = str;
        if (this.a.type == 3)
        {
          localObject = (GeneralRecommendFeedItem)this.a;
          i1 = this.e;
          if (i1 == 10)
          {
            localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMain;
          }
          else if (i1 == 12)
          {
            localObject = ((GeneralRecommendFeedItem)localObject).wsSchemaForMemories;
          }
          else
          {
            SLog.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(i1) });
            localObject = str;
          }
        }
      }
      int i1 = this.e;
      if (i1 == 10)
      {
        str = "1";
      }
      else if (i1 == 12)
      {
        str = "3";
      }
      else
      {
        SLog.e("FeedCommentLikeLego", "unknown feedType: %s", new Object[] { Integer.valueOf(i1) });
        str = "-1";
      }
      WeShiGuideDialog.a(this.j, this.a.getOwner().getUnionId(), str, this.a.feedId, 2, (String)localObject);
      if (WeishiGuideUtils.a(this.p)) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      StoryReportor.a("weishi_share", "tag_clk", 0, i1, new String[] { str, this.a.getOwner().getUnionId(), "weishi", this.a.feedId });
    }
  }
  
  public void c()
  {
    this.l = true;
    super.c();
  }
  
  public void d() {}
  
  public void e()
  {
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)b("commentLego");
    FeedLikeLego localFeedLikeLego = (FeedLikeLego)b("likeLego");
    localFeedCommentLego.c(this.b.d());
    localFeedLikeLego.c(this.b.f());
  }
  
  public void f()
  {
    int i3 = this.b.d().size();
    int i2;
    if ((this.b.f().size() <= 0) && (this.a.mLikeCount <= 0)) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    int i1;
    if ((i3 == 0) && (i2 == 0))
    {
      if (this.a.mCommentCount > i3) {
        i1 = StoryApi.d(2131492919);
      } else {
        i1 = StoryApi.d(2131492916);
      }
    }
    else if ((i2 != 0) && (i3 == 0)) {
      i1 = StoryApi.d(2131492918);
    } else if ((i3 > 0) && (i2 == 0)) {
      i1 = StoryApi.d(2131492917);
    } else {
      i1 = StoryApi.d(2131492914);
    }
    this.q.setPadding(0, 0, 0, UIUtils.a(this.p, i1));
    if ((i3 > 0) && (i2 == 0))
    {
      this.f.setPadding(0, 0, 0, 0);
      return;
    }
    float f1 = StoryApi.d(2131492915);
    this.f.setPadding(0, UIUtils.a(this.p, f1 + 0.5F), 0, 0);
  }
  
  public boolean isValidate()
  {
    return this.l ^ true;
  }
  
  public void j()
  {
    this.c = null;
    FeedCommentLego localFeedCommentLego = (FeedCommentLego)b("commentLego");
    localFeedCommentLego.a(new FeedCommentEventHandler(localFeedCommentLego));
  }
  
  public void k()
  {
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLikeLego
 * JD-Core Version:    0.7.0.1
 */