package com.tencent.biz.qqstory.comment;

import android.app.Activity;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.comment.lego.LegoBase;
import com.tencent.biz.qqstory.comment.lego.LegoDataProvider;
import com.tencent.biz.qqstory.comment.lego.LegoEvenHandler;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils.DefaultClickNickCallback;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment.CommentTextOnTouchListener;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class FeedCommentLego
  extends LegoBase<CommentEntry>
  implements IEventReceiver
{
  public InnerListView a;
  public TextView b;
  public Activity c;
  public List<CommentEntry> d = new ArrayList();
  public List<CommentEntry> e = new ArrayList();
  public FeedCommentLego.CommentInnerAdpter f;
  public CommentLikeFeedItem g;
  public int h;
  public List<StoryVideoItem> i;
  public FeedCommentEventHandler j;
  public FeedCommentDataProvider k;
  public FeedCommentEventHandler.KeyBoardUpCallback l;
  protected CommentManager m;
  protected LikeManager n;
  protected FeedCommentLego.UserIconUpdateReceiver o;
  private SpannableStringUtils.DefaultClickNickCallback t;
  private FeedCommentLikeLego.MainWidgetClickListener u;
  private DetailCommentSegment.CommentTextOnTouchListener v;
  private boolean w;
  
  public FeedCommentLego(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, List<StoryVideoItem> paramList)
  {
    super(paramContext, paramView);
    this.c = paramActivity;
    this.g = paramCommentLikeFeedItem;
    this.h = paramInt;
    this.m = ((CommentManager)SuperManager.a(17));
    this.n = ((LikeManager)SuperManager.a(15));
    this.v = new DetailCommentSegment.CommentTextOnTouchListener();
    this.t = new SpannableStringUtils.DefaultClickNickCallback(paramActivity, this.g, this.h, true);
    this.i = paramList;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 12) {
      return 3;
    }
    if ((paramInt != 210) && (paramInt != 222) && (paramInt != 23) && (paramInt != 220) && (paramInt != 221) && (paramInt != 211)) {
      return 0;
    }
    return 2;
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramString = new FeedInfoChangeEvent(a(paramInt1), paramString, paramInt2);
    if ((paramInt2 == 2) || (paramInt2 == 1)) {
      paramString.e = paramInt3;
    }
    StoryDispatcher.a().dispatch(paramString);
  }
  
  public static void a(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, boolean paramBoolean, int paramInt, FeedCommentEventHandler.PostCommentCallback paramPostCommentCallback)
  {
    b(paramCommentLikeFeedItem, paramCommentEntry, paramInt, paramPostCommentCallback, true, paramBoolean);
    if (paramCommentEntry.isReply()) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    int i1;
    if (paramBoolean) {
      i1 = 12;
    } else {
      i1 = StoryReportor.a(paramCommentLikeFeedItem);
    }
    paramBoolean = paramCommentLikeFeedItem.getOwner().isMe();
    String str = "1";
    if (paramBoolean) {
      paramPostCommentCallback = "1";
    } else {
      paramPostCommentCallback = "2";
    }
    if (a(paramCommentEntry.content)) {
      str = "2";
    }
    StoryReportor.a("home_page", "send_comment", i1, paramInt, new String[] { paramPostCommentCallback, str, StoryQQTextCacher.a().a, paramCommentLikeFeedItem.feedId });
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramString.charAt(i1);
      if (EmotcationConstants.EMOJI_MAP.get(i3, -1) < 0) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, int paramInt, FeedCommentEventHandler.PostCommentCallback paramPostCommentCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, 1, paramCommentEntry.feedId, paramCommentEntry.commentId);
    FeedCommentDataProvider.b(paramCommentEntry, new FeedCommentLego.2(paramPostCommentCallback, paramCommentEntry, (CommentManager)SuperManager.a(17), paramBoolean1, paramCommentLikeFeedItem, paramInt, paramBoolean2));
  }
  
  public LegoEvenHandler a()
  {
    this.j = new FeedCommentEventHandler(this);
    return this.j;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.a = ((InnerListView)paramView.findViewById(2131431096));
    this.a.setOverScrollMode(1);
    this.b = ((TextView)paramView.findViewById(2131438801));
    this.w = true;
    this.o = new FeedCommentLego.UserIconUpdateReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.o);
  }
  
  public void a(FeedCommentEventHandler.KeyBoardUpCallback paramKeyBoardUpCallback)
  {
    this.l = paramKeyBoardUpCallback;
  }
  
  public void a(FeedCommentLikeLego.MainWidgetClickListener paramMainWidgetClickListener)
  {
    this.u = paramMainWidgetClickListener;
  }
  
  public void a(LegoEvenHandler paramLegoEvenHandler)
  {
    super.a(paramLegoEvenHandler);
    this.j = ((FeedCommentEventHandler)paramLegoEvenHandler);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem, List<StoryVideoItem> paramList)
  {
    this.g = paramCommentLikeFeedItem;
    FeedCommentEventHandler localFeedCommentEventHandler = this.j;
    if (localFeedCommentEventHandler != null) {
      localFeedCommentEventHandler.a(paramCommentLikeFeedItem);
    }
    this.t.a(paramCommentLikeFeedItem);
    this.i = paramList;
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry)
  {
    if (paramString.length() <= 0) {
      return;
    }
    CommentEntry localCommentEntry = new CommentEntry();
    if (TextUtils.hasSysEmotion(paramString)) {
      localCommentEntry.content = EmotionCodecUtils.a(paramString);
    } else {
      localCommentEntry.content = paramString;
    }
    localCommentEntry.replyTime = System.currentTimeMillis();
    if (paramCommentEntry != null)
    {
      localCommentEntry.replierUnionId = paramCommentEntry.authorUnionId;
      localCommentEntry.replierName = paramCommentEntry.authorName;
      localCommentEntry.replierRole = paramCommentEntry.authorRole;
    }
    localCommentEntry.authorUin = QQStoryContext.j().getCurrentUin();
    localCommentEntry.authorUnionId = QQStoryContext.a().i();
    localCommentEntry.status = 1;
    localCommentEntry.feedId = this.g.feedId;
    localCommentEntry.pbType = this.g.getCommentLikeType();
    if (((Integer)((StoryConfigManager)SuperManager.a(10)).c("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    if (this.g.mDenyComment == 1)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131902424), 0).show();
      localCommentEntry.status = 2;
    }
    else
    {
      StoryQQTextCacher.a().a = "";
      a(this.g, localCommentEntry, false, this.h, new FeedCommentLego.1(this));
    }
    this.d.add(localCommentEntry);
    g();
    this.m.b(localCommentEntry);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("AddComment: ");
      paramString.append(localCommentEntry.toString());
      QLog.d("FeedCommentLego", 2, paramString.toString());
    }
  }
  
  public void a(List<CommentEntry> paramList)
  {
    a(paramList, true);
    this.a.setOnItemClickListener(this.j);
    this.a.setOnItemLongClickListener(this.j);
    this.b.setOnClickListener(this.j);
  }
  
  public void a(List<CommentEntry> paramList, boolean paramBoolean)
  {
    e();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("renderCommentList:");
      localStringBuilder.append(paramList);
      QLog.d("FeedCommentLego", 2, localStringBuilder.toString());
    }
    if (paramList == null) {
      return;
    }
    if (this.f == null)
    {
      this.d = paramList;
      this.a.a(2131628037, 2);
      this.f = new FeedCommentLego.CommentInnerAdpter(this, 2131628037, this.d, true);
      this.a.setAdapter(this.f);
    }
    else if (paramBoolean)
    {
      this.d = paramList;
    }
    else
    {
      this.d.addAll(paramList);
    }
    g();
  }
  
  public void a(boolean paramBoolean, CommentEntry paramCommentEntry)
  {
    FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)m();
    CommentLikeFeedItem localCommentLikeFeedItem;
    if (paramBoolean)
    {
      localCommentLikeFeedItem = this.g;
      localCommentLikeFeedItem.mCommentCount += 1;
    }
    else
    {
      localCommentLikeFeedItem = this.g;
      localCommentLikeFeedItem.mCommentCount -= 1;
    }
    localFeedCommentLikeLego.a(null);
    if (paramCommentEntry != null) {
      localFeedCommentLikeLego.b.a(paramCommentEntry);
    }
  }
  
  public LegoDataProvider b()
  {
    this.k = new FeedCommentDataProvider(this);
    return this.k;
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= this.d.size())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteComment but index is : ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" and commentlist size is");
      ((StringBuilder)localObject).append(this.d.size());
      QLog.e("FeedCommentLego", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = (CommentEntry)this.d.get(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteCommentData: ");
      localStringBuilder.append(localObject);
      QLog.d("FeedCommentLego", 2, localStringBuilder.toString());
    }
    if (((CommentEntry)localObject).status != 0)
    {
      this.d.remove(paramInt);
      g();
      QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131902425), 0).show();
      this.m.d((CommentEntry)localObject);
      StoryFailCommentCacher.a().b();
      a(this.h, 2, ((CommentEntry)localObject).feedId, ((CommentEntry)localObject).commentId);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.p))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131902430), 0).show();
      SLog.e("FeedCommentLego", "ReqGetLikeList Not Network!");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    g();
    FeedCommentDataProvider.a((CommentEntry)localObject, new FeedCommentLego.3(this, paramInt, (CommentEntry)localObject));
  }
  
  public void c()
  {
    this.w = false;
    if (this.o != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.o);
    }
  }
  
  public void d() {}
  
  public void e()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void f()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(0);
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131902418), 0).show();
  }
  
  public void g()
  {
    this.f = new FeedCommentLego.CommentInnerAdpter(this, 2131628037, this.d, true);
    this.a.setAdapter(this.f);
  }
  
  public void h()
  {
    this.f = new FeedCommentLego.CommentInnerAdpter(this, 2131628037, this.d, false);
    this.a.setAdapter(this.f);
  }
  
  public boolean isValidate()
  {
    return this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego
 * JD-Core Version:    0.7.0.1
 */