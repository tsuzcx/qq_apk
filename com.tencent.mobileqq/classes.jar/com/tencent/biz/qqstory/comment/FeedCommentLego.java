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
  public int a;
  public Activity a;
  public TextView a;
  public FeedCommentDataProvider a;
  public FeedCommentEventHandler.KeyBoardUpCallback a;
  public FeedCommentEventHandler a;
  public FeedCommentLego.CommentInnerAdpter a;
  protected FeedCommentLego.UserIconUpdateReceiver a;
  private FeedCommentLikeLego.MainWidgetClickListener jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLikeLego$MainWidgetClickListener;
  protected CommentManager a;
  protected LikeManager a;
  private SpannableStringUtils.DefaultClickNickCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelSpannableStringUtils$DefaultClickNickCallback;
  private DetailCommentSegment.CommentTextOnTouchListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$CommentTextOnTouchListener;
  public CommentLikeFeedItem a;
  public InnerListView a;
  public List<CommentEntry> a;
  private boolean jdField_a_of_type_Boolean;
  public List<CommentEntry> b = new ArrayList();
  public List<StoryVideoItem> c;
  
  public FeedCommentLego(Context paramContext, Activity paramActivity, View paramView, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, List<StoryVideoItem> paramList)
  {
    super(paramContext, paramView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager = ((CommentManager)SuperManager.a(17));
    this.jdField_a_of_type_ComTencentBizQqstoryModelLikeManager = ((LikeManager)SuperManager.a(15));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailViewSegmentDetailCommentSegment$CommentTextOnTouchListener = new DetailCommentSegment.CommentTextOnTouchListener();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelSpannableStringUtils$DefaultClickNickCallback = new SpannableStringUtils.DefaultClickNickCallback(paramActivity, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_Int, true);
    this.c = paramList;
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
      paramString.c = paramInt3;
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
    int i;
    if (paramBoolean) {
      i = 12;
    } else {
      i = StoryReportor.a(paramCommentLikeFeedItem);
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
    StoryReportor.a("home_page", "send_comment", i, paramInt, new String[] { paramPostCommentCallback, str, StoryQQTextCacher.a().a, paramCommentLikeFeedItem.feedId });
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      if (EmotcationConstants.EMOJI_MAP.get(k, -1) < 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static void b(CommentLikeFeedItem paramCommentLikeFeedItem, CommentEntry paramCommentEntry, int paramInt, FeedCommentEventHandler.PostCommentCallback paramPostCommentCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, 1, paramCommentEntry.feedId, paramCommentEntry.commentId);
    FeedCommentDataProvider.b(paramCommentEntry, new FeedCommentLego.2(paramPostCommentCallback, paramCommentEntry, (CommentManager)SuperManager.a(17), paramBoolean1, paramCommentLikeFeedItem, paramInt, paramBoolean2));
  }
  
  public LegoDataProvider a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentDataProvider = new FeedCommentDataProvider(this);
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentDataProvider;
  }
  
  public LegoEvenHandler a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler = new FeedCommentEventHandler(this);
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$UserIconUpdateReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$UserIconUpdateReceiver);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteComment but index is : ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" and commentlist size is");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.e("FeedCommentLego", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = (CommentEntry)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteCommentData: ");
      localStringBuilder.append(localObject);
      QLog.d("FeedCommentLego", 2, localStringBuilder.toString());
    }
    if (((CommentEntry)localObject).status != 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt);
      e();
      QQToast.a(BaseApplication.getContext(), 2, HardCodeUtil.a(2131704513), 0).a();
      this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.d((CommentEntry)localObject);
      StoryFailCommentCacher.a().a();
      a(this.jdField_a_of_type_Int, 2, ((CommentEntry)localObject).feedId, ((CommentEntry)localObject).commentId);
      return;
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704519), 0).a();
      SLog.e("FeedCommentLego", "ReqGetLikeList Not Network!");
      return;
    }
    ((CommentEntry)localObject).status = 1;
    e();
    FeedCommentDataProvider.a((CommentEntry)localObject, new FeedCommentLego.3(this, paramInt, (CommentEntry)localObject));
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView = ((InnerListView)paramView.findViewById(2131364969));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOverScrollMode(1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371434));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$UserIconUpdateReceiver = new FeedCommentLego.UserIconUpdateReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$UserIconUpdateReceiver);
  }
  
  public void a(FeedCommentEventHandler.KeyBoardUpCallback paramKeyBoardUpCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$KeyBoardUpCallback = paramKeyBoardUpCallback;
  }
  
  public void a(FeedCommentLikeLego.MainWidgetClickListener paramMainWidgetClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLikeLego$MainWidgetClickListener = paramMainWidgetClickListener;
  }
  
  public void a(LegoEvenHandler paramLegoEvenHandler)
  {
    super.a(paramLegoEvenHandler);
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler = ((FeedCommentEventHandler)paramLegoEvenHandler);
  }
  
  public void a(CommentLikeFeedItem paramCommentLikeFeedItem, List<StoryVideoItem> paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    FeedCommentEventHandler localFeedCommentEventHandler = this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler;
    if (localFeedCommentEventHandler != null) {
      localFeedCommentEventHandler.a(paramCommentLikeFeedItem);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelSpannableStringUtils$DefaultClickNickCallback.a(paramCommentLikeFeedItem);
    this.c = paramList;
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
    localCommentEntry.authorUin = QQStoryContext.a().getCurrentUin();
    localCommentEntry.authorUnionId = QQStoryContext.a().b();
    localCommentEntry.status = 1;
    localCommentEntry.feedId = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId;
    localCommentEntry.pbType = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getCommentLikeType();
    if (((Integer)((StoryConfigManager)SuperManager.a(10)).b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1) {
      localCommentEntry.authorRole = 2;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mDenyComment == 1)
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704512), 0).a();
      localCommentEntry.status = 2;
    }
    else
    {
      StoryQQTextCacher.a().a = "";
      a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, localCommentEntry, false, this.jdField_a_of_type_Int, new FeedCommentLego.1(this));
    }
    this.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
    e();
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.b(localCommentEntry);
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
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setOnItemLongClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler);
  }
  
  public void a(List<CommentEntry> paramList, boolean paramBoolean)
  {
    c();
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$CommentInnerAdpter == null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.a(2131561658, 2);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$CommentInnerAdpter = new FeedCommentLego.CommentInnerAdpter(this, 2131561658, this.jdField_a_of_type_JavaUtilList, true);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$CommentInnerAdpter);
    }
    else if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    else
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    e();
  }
  
  public void a(boolean paramBoolean, CommentEntry paramCommentEntry)
  {
    FeedCommentLikeLego localFeedCommentLikeLego = (FeedCommentLikeLego)a();
    CommentLikeFeedItem localCommentLikeFeedItem;
    if (paramBoolean)
    {
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      localCommentLikeFeedItem.mCommentCount += 1;
    }
    else
    {
      localCommentLikeFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
      localCommentLikeFeedItem.mCommentCount -= 1;
    }
    localFeedCommentLikeLego.a(null);
    if (paramCommentEntry != null) {
      localFeedCommentLikeLego.a.a(paramCommentEntry);
    }
  }
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131704506), 0).a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$CommentInnerAdpter = new FeedCommentLego.CommentInnerAdpter(this, 2131561658, this.jdField_a_of_type_JavaUtilList, true);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$CommentInnerAdpter);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$CommentInnerAdpter = new FeedCommentLego.CommentInnerAdpter(this, 2131561658, this.jdField_a_of_type_JavaUtilList, false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentLego$CommentInnerAdpter);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego
 * JD-Core Version:    0.7.0.1
 */